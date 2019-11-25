/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4_5;

import java.util.ArrayList;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Student
 */
public class AWTChart extends ApplicationFrame {

    public AWTChart(String applicationTitle) {
        super(applicationTitle);
    }

    protected DefaultCategoryDataset createDataset(ArrayList keys, ArrayList probs, String lineName) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < keys.size(); i++) {
            Object objKey = keys.get(i);
            Object objProb = probs.get(i);
            if (objKey instanceof String && objProb instanceof Double) {
                try {
                    dataset.addValue((double) objProb, lineName, (String) objKey);
                } catch (NumberFormatException e) {
                    System.out.println(e);
                    return null; // If ERROR -> Return null
                }
            } else {
                throw new IllegalArgumentException("Keys & Probs should be String & Double");
            }
        }
        return dataset;
    }

}
