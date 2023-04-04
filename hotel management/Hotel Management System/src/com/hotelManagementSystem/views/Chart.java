package com.hotelManagementSystem.views;

import org.knowm.xchart.*;
import org.knowm.xchart.demo.charts.ExampleChart;
import org.knowm.xchart.style.Styler;
import org.knowm.xchart.style.colors.XChartSeriesColors;
import org.knowm.xchart.style.lines.SeriesLines;
import org.knowm.xchart.style.markers.SeriesMarkers;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.*;
import java.util.List;

import static org.knowm.xchart.style.colors.ChartColor.GREY;

//4 data biểu đồ :
//        - XChart Pie Chart: theo dõi nhu cầu chọn loại phòng của khách hàng
//        -XChart Donut Chart: số lượng phòng khả dụng và không khả dụng
//        -XChart Basic Bar Chart: theo dõi số lượng khách hàng theo tuần
//        - XYChart: quản lý doanh thu hàng tháng

// Pie Chart
//public class Chart implements ExampleChart<PieChart> {
//    private static JPanel contentPane;
//
//    public static void main(String[] args) {
//        ExampleChart<PieChart> exampleChart = new Chart ();
//        PieChart chart = exampleChart.getChart();
//        new SwingWrapper<PieChart>(chart).displayChart();
//    }
//
//    @Override
//    public PieChart getChart() {
//
//        // Create Chart
//        PieChart chart = new PieChartBuilder().width(1000).height(600).title(getClass().getSimpleName()).build();
//
//        // Customize Chart
//        Color[] sliceColors = new Color[] { new Color(224, 68, 14), new Color(230, 105, 62), new Color(236, 143, 110), new Color(243, 180, 159), new Color(246, 199, 182) };
//        chart.getStyler().setSeriesColors(sliceColors);
//
//        // Series
//        chart.addSeries("Gold", 24);
//        chart.addSeries("Silver", 21);
//        chart.addSeries("Platinum", 39);
//        chart.addSeries("Copper", 17);
//        chart.addSeries("Zinc", 40);
//
//        return chart;
//    }
//
//    @Override
//    public String getExampleChartName() {
//        return null;
//    }
//}

// Donut Chart
//public class Chart implements ExampleChart<PieChart> {
//
//    public static void main(String[] args) {
//
//        ExampleChart<PieChart> exampleChart = new Chart();
//        PieChart chart = exampleChart.getChart();
//        new SwingWrapper<PieChart>(chart).displayChart();
//    }
//
//    @Override
//    public PieChart getChart() {
//
//        // Create Chart
//        PieChart chart = new PieChartBuilder().width(1000).height(600).title(getClass().getSimpleName()).build();
//
//        // Customize Chart
//        chart.getStyler().setLegendVisible(false);
//
//        chart.getStyler().setAnnotationType(AnnotationType.Label);
//        chart.getStyler().setAnnotationDistance(.82);
//        chart.getStyler().setPlotContentSize(.9);
//        chart.getStyler().setDefaultSeriesRenderStyle(PieSeries.PieSeriesRenderStyle.Donut);
//        // chart.getStyler().setCircular(false);
//
//        // Series
//        chart.addSeries("A", 22);
//        chart.addSeries("B", 10);
//        chart.addSeries("C", 34);
//        chart.addSeries("D", 22);
//        chart.addSeries("E", 29);
//        chart.addSeries("F", 40);
//
//        return chart;
//    }
//
//    @Override
//    public String getExampleChartName() {
//        return null;
//    }
//
//}

//Basic Bar Chart
public class Chart implements ExampleChart<CategoryChart> {

    public static void main(String[] args) {

        ExampleChart<CategoryChart> exampleChart = new Chart();
        CategoryChart chart = exampleChart.getChart();
        new SwingWrapper<CategoryChart>(chart).displayChart();
    }

    @Override
    public CategoryChart getChart() {

        // Create Chart
        CategoryChart chart = new CategoryChartBuilder().width(1000).height(600).title("Score Histogram").xAxisTitle("Score").yAxisTitle("Number").build();

        // Customize Chart
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.getStyler().setLabelsRotation(1);

        // Series
        chart.addSeries("test 1", Arrays.asList(new Integer[] { 0, 1, 2, 3, 4 }), Arrays.asList(new Integer[] { 4, 5, 9, 6, 5 }));

        return chart;
    }
    public String getExampleChartName() {
        return null;
    }
}


////Customized Chart
//public class Chart implements ExampleChart<XYChart> {
//
//    public static void main(String[] args) {
//
//        ExampleChart<XYChart> exampleChart = new Chart();
//        XYChart chart = exampleChart.getChart();
//        new SwingWrapper<XYChart>(chart).displayChart();
//    }
//
//    @Override
//    public XYChart getChart() {
//
//        // Create Chart
//        XYChart chart = new XYChartBuilder().width(500).height(300).title("LineChart03").xAxisTitle("X").yAxisTitle("Y").build();
//
//        // Customize Chart
//        chart.getStyler().setPlotBackgroundColor(Color.WHITE);
//        chart.getStyler().setPlotGridLinesColor(new Color(255, 255, 255));
//        chart.getStyler().setChartBackgroundColor(Color.WHITE);
//        chart.getStyler().setLegendBackgroundColor(Color.PINK);
//        chart.getStyler().setChartFontColor(Color.MAGENTA);
//        chart.getStyler().setChartTitleBoxBackgroundColor(new Color(0, 222, 0));
//        chart.getStyler().setChartTitleBoxVisible(true);
//        chart.getStyler().setChartTitleBoxBorderColor(Color.BLACK);
//        chart.getStyler().setPlotGridLinesVisible(false);
//
//        chart.getStyler().setAxisTickPadding(20);
//
//        chart.getStyler().setAxisTickMarkLength(15);
//
//        chart.getStyler().setPlotMargin(20);
//
//        chart.getStyler().setChartTitleFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
//        chart.getStyler().setLegendFont(new Font(Font.SERIF, Font.PLAIN, 18));
//        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideSE);
//        chart.getStyler().setLegendSeriesLineLength(12);
//        chart.getStyler().setAxisTitleFont(new Font(Font.SANS_SERIF, Font.ITALIC, 18));
//        chart.getStyler().setAxisTickLabelsFont(new Font(Font.SERIF, Font.PLAIN, 11));
//        chart.getStyler().setDatePattern("dd-MMM");
//        chart.getStyler().setDecimalPattern("#0.000");
//        chart.getStyler().setLocale(Locale.GERMAN);
//
//        // generates linear data
//        List<Date> xData = new ArrayList<Date>();
//        List<Double> yData = new ArrayList<Double>();
//
//        DateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
//        Date date = null;
//        for (int i = 1; i <= 10; i++) {
//
//            try {
//                date = sdf.parse(i + ".10.2008");
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//            xData.add(date);
//            yData.add(Math.random() * i);
//        }
//
//        // Series
//        XYSeries series = chart.addSeries("Real Data", xData, yData);
//        series.setLineColor(XChartSeriesColors.BLUE);
//        series.setMarkerColor(Color.ORANGE);
//        series.setMarker(SeriesMarkers.CIRCLE);
//        series.setLineStyle(SeriesLines.SOLID);
//
//        return chart;
//    }
//
//    @Override
//    public String getExampleChartName() {
//        return null;
//    }
//}