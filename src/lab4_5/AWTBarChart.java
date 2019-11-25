/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4_5;

import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;

/**
 *
 * @author Student
 */
public class AWTBarChart extends AWTChart {

    public AWTBarChart(String applicationTitle, String chartTitle,
            String xAxis, String yAxis, String lineName,
            ArrayList values, ArrayList probs) {
        super(applicationTitle);
        JFreeChart barChart = ChartFactory.createBarChart(
                chartTitle, xAxis, yAxis,
                createDataset(values, probs, lineName),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        this.setContentPane(chartPanel);
    }

}
