package com.hotelManagementSystem.views;

import com.hotelManagementSystem.dao.ChartDao;

import org.knowm.xchart.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//4 data biểu đồ :
//        - XChart Pie Chart: theo dõi nhu cầu chọn loại phòng của khách hàng
//        -XChart Donut Chart: số lượng phòng khả dụng và không khả dụng
//        -XChart Basic Bar Chart: theo dõi số lượng khách hàng theo tuần
//        - XYChart: quản lý doanh thu hàng tháng


public class Chart extends JFrame{
    private JPanel p1;
    private JButton refreshBtn;
    private static PieChart pieChart;
    private static CategoryChart barChart;
    private static CategoryChart barChart2;
    private static XYChart xyChart;

    public JPanel getP1() {
        return p1;
    }
    public Chart(){
        initComponent();
    }

    private void initComponent(){
        p1 = new JPanel();
        p1.setBounds(0, 0, 1100, 600);
        p1.setLayout(null);
        add(p1);


        pieChart = new ChartDao().getChartPieChart();
        final JPanel[] chartPanel = {new XChartPanel<>(pieChart)};
        chartPanel[0].setBounds(0, 0, 500, 300);
        p1.add(chartPanel[0]);

        barChart = new ChartDao().getChartBarChart();
        final JPanel[] chartPanel2 = {new XChartPanel<>(barChart)};
        chartPanel2[0].setBounds(500, 0, 500, 300);
        p1.add(chartPanel2[0]);

        barChart2 = new ChartDao().getChartBar2Chart();
        final JPanel[] chartPanel3 = {new XChartPanel<>(barChart2)};
        chartPanel3[0].setBounds(0, 300, 500, 250);
        p1.add(chartPanel3[0]);

        xyChart = new ChartDao().getChartLineChart();
        final JPanel[] chartPanel4 = {new XChartPanel<>(xyChart)};
        chartPanel4[0].setBounds(500, 300, 500, 250);
        p1.add(chartPanel4[0]);


        ImageIcon refreshBut = new ImageIcon(ClassLoader.getSystemResource("icons/refresh.png"));
        Image imgButton1 = refreshBut.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        refreshBtn = new JButton(new ImageIcon(imgButton1));
        refreshBtn.setBounds(1020, 250, 40, 40);
        refreshBtn.setBorder(null);
        refreshBtn.setBackground(Color.decode("#eeeeee"));
        refreshBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // remove the old chart panels
                p1.remove(chartPanel[0]);
                p1.remove(chartPanel2[0]);
                p1.remove(chartPanel3[0]);
                p1.remove(chartPanel4[0]);
                // get new chart data
                pieChart = new ChartDao().getChartPieChart();
                chartPanel[0] = new XChartPanel<>(pieChart);
                chartPanel[0].setBounds(0, 0, 500, 300);
                p1.add(chartPanel[0]);

                barChart = new ChartDao().getChartBarChart();
                chartPanel2[0] = new XChartPanel<>(barChart);
                chartPanel2[0].setBounds(500, 0, 500, 300);
                p1.add(chartPanel2[0]);

                barChart2 = new ChartDao().getChartBar2Chart();
                chartPanel3[0] = new XChartPanel<>(barChart2);
                chartPanel3[0].setBounds(0, 300, 500, 250);
                p1.add(chartPanel3[0]);

                xyChart = new ChartDao().getChartLineChart();
                chartPanel4[0] = new XChartPanel<>(xyChart);
                chartPanel4[0].setBounds(500, 300, 500, 250);
                p1.add(chartPanel4[0]);
                // repaint the panel
                p1.revalidate();
                p1.repaint();
            }
        });
        p1.add(refreshBtn);


    }




}
