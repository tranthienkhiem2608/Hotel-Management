package com.hotelManagementSystem.dao;

import com.hotelManagementSystem.conn.Conn;
import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;

import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class ChartDao {
    private Conn conn = new Conn();

    public PieChart getChartPieChart(){
        int countSingle = 0;
        int countDouble = 0;
        int countKing = 0;
        PieChart chart = new PieChartBuilder().width(500).height(300).title("The needs of customers").build();
        Color[] sliceColors = new Color[] { new Color(224, 68, 14), new Color(230, 105, 62), new Color(236, 143, 110)  };
        chart.getStyler().setSeriesColors(sliceColors);
        String createTempTableSql = "CREATE TEMPORARY TABLE temp_customer_history AS SELECT * FROM HistoryCustomer;";
        String query = "SELECT * FROM Customer UNION ALL SELECT * FROM temp_customer_history";
        String query1 = "SELECT bedType FROM Room WHERE roomNumber IN (SELECT roomNumber FROM temp_customer_history)";
        try{
            PreparedStatement createTempTableStmt = conn.getConnection().prepareStatement(createTempTableSql);
            createTempTableStmt.executeUpdate();
            PreparedStatement stmt = conn.getConnection().prepareStatement(query);
            ResultSet rs1 = stmt.executeQuery();
            PreparedStatement stmt1 = conn.getConnection().prepareStatement(query1);
            ResultSet rs = stmt1.executeQuery();
            while (rs.next()){
                if (rs.getString("bedType").equals("Single bed")){
                    countSingle++;
                }else if (rs.getString("bedType").equals("Double bed")){
                    countDouble++;
                }else if (rs.getString("bedType").equals("King bed")){
                    countKing++;
                }
            }
            chart.addSeries("Single bed", countSingle);
            chart.addSeries("Double bed", countDouble);
            chart.addSeries("King bed", countKing);
            String dropTempTableSql = "DROP TEMPORARY TABLE temp_customer_history;";
            PreparedStatement dropTempTableStmt = conn.getConnection().prepareStatement(dropTempTableSql);
            dropTempTableStmt.executeUpdate();
            return chart;

        }catch (Exception e){
            e.printStackTrace();
        return null;
        }
    }
    public CategoryChart getChartBarChart(){
        int countAvailable = 0;
        int countOccupied = 0;
        CategoryChart chart = new CategoryChartBuilder().width(500).height(300).title("Room Status").xAxisTitle("count").yAxisTitle("Room number").build();
        Color[] sliceColors = new Color[] { new Color(224, 68, 14), new Color(230, 105, 62) };
        chart.getStyler().setSeriesColors(sliceColors);
        chart.getStyler().setLabelsRotation(0);
        chart.getStyler().setAvailableSpaceFill(0.2);
        chart.getStyler().setYAxisDecimalPattern("#");



        String query = "SELECT * FROM Room";
        try{
            //count room available and occupied
            PreparedStatement stmt = conn.getConnection().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                if (rs.getString("availability").equals("available")){
                    countAvailable++;
                }else if (rs.getString("availability").equals("occupied")){
                    countOccupied++;
                }
            }
            chart.addSeries("Available", List.of(0), List.of(countAvailable));
            chart.addSeries("Occupied", List.of(0), List.of(countOccupied));
            chart.getStyler().setAnnotationLineStroke(new BasicStroke(1.0f));
            chart.getStyler().getAnnotationLineColor();
            chart.getStyler().setAnnotationTextPanelFont(new Font("Arial", Font.PLAIN, 12));
            chart.getStyler().setPlotGridLinesVisible(false);
            return chart;
        }catch (Exception e) {
            e.printStackTrace();
        }

    return null;
    }

    public CategoryChart getChartBar2Chart(){
        CategoryChart chart = new CategoryChartBuilder().width(500).height(250).title("Customer").xAxisTitle("DateTime").yAxisTitle("Number Customer").build();
        Color[] sliceColors = new Color[] { new Color(224, 68, 14) };
        chart.getStyler().setSeriesColors(sliceColors);
        chart.getStyler().setAvailableSpaceFill(0.2);
        chart.getStyler().setLabelsRotation(0);
        chart.getStyler().setYAxisDecimalPattern("#");

        List<String> xData = new ArrayList<>();
        List<Integer> yData = new ArrayList<>();
        String query = "SELECT DATE_FORMAT(checkindate, '%m-%d') AS date, COUNT(*) AS count FROM customer GROUP BY date";
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd");

        try {
            PreparedStatement stmt = conn.getConnection().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String dateStr = rs.getString("date");
                Date date = dateFormat.parse(dateStr);
                String formattedDate = dateFormat.format(date);
                xData.add(formattedDate);
                yData.add(rs.getInt("count"));
            }
            chart.getStyler().setAnnotationLineStroke(new BasicStroke(1.0f));
            chart.getStyler().getAnnotationLineColor();
            chart.getStyler().setAnnotationTextPanelFont(new Font("Arial", Font.PLAIN, 12));
            chart.getStyler().setPlotGridLinesVisible(false);
            chart.addSeries("Số lượng khách", xData, yData);
            return chart;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public XYChart getChartLineChart(){
        XYChart chart = new XYChartBuilder().width(500).height(250).title("Revenue").xAxisTitle("DateTime").yAxisTitle("Revenue").build();
        Color[] sliceColors = new Color[] { new Color(224, 68, 14) };
        chart.getStyler().setSeriesColors(sliceColors);
        String query ="SELECT * FROM historyCustomer";
        Map<String, Integer> weeklyRevenue = new TreeMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try{
            PreparedStatement stmt = conn.getConnection().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Date checkinDate = rs.getDate("checkoutdate");
                int deposit = rs.getInt("deposit");
                Calendar cal = Calendar.getInstance();
                cal.setTime(checkinDate);
                int revenue = weeklyRevenue.getOrDefault(sdf.format(checkinDate), 0);
                weeklyRevenue.put(sdf.format(checkinDate), revenue + deposit);
            }
            List<Date> dates = weeklyRevenue.keySet().stream().map(s -> {
                try {
                    return sdf.parse(s);
                } catch (Exception e) {
                    return new Date();
                }
            }).collect(Collectors.toList());
            List<Integer> revenues = new ArrayList<>(weeklyRevenue.values());
            chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
            chart.getStyler().setXAxisTickMarkSpacingHint(50);
            chart.getStyler().setPlotGridVerticalLinesVisible(false);
            chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Area);

            List<Date> sortedDates = dates.stream().sorted().collect(Collectors.toList());
            chart.addSeries("Doanh thu", sortedDates, revenues);
            return chart;
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
