/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author Student
 */
public class RandomVar {

    private String X_name;
    private ArrayList X_value = null;
    private ArrayList prob = null;
    private double Mean;
    private double Variance;
    private double StdDev;
    private static final Pattern PATTERN = Pattern.compile("-?\\d+(\\.\\d+)?");

    public boolean isNumeric(String stringNumber) {
        if (stringNumber == null) {
            return false;
        }
        return PATTERN.matcher(stringNumber).matches();
    }

    public RandomVar(String x_name, Object[] values) {
        X_name = x_name;
        X_value = new ArrayList<>();
        prob = new ArrayList<>();
        this.assignX_Prob(values);
    }

    public ArrayList getXValue() {
        return X_value;
    }

    public ArrayList getProb() {
        return prob;
    }

    /**
     * Getting the values of the random variable, and computing the probability
     * mass function
     *
     * @param values : input values
     */
    public void assignX_Prob(Object[] values) {
        Arrays.sort(values); // The array must be sorted before counting appeared-frequency
        int count = 0;
        int arrSize = values.length;
        for (int i = 0; i < arrSize; i++) {
            if (X_value.contains(values[i])) {
                count++;
            } else {
                if (i == 0) {
                    count = 1;
                    X_value.add(values[i]);
                }
                if (i != 0 && i != arrSize - 1) {
                    double d_prob = ((double) count) / arrSize;
                    prob.add(d_prob);
                    count = 1;
                    X_value.add(values[i]);
                }
            }

            if (i == arrSize - 1) {
                double d_prob = ((double) count) / arrSize;
                prob.add(d_prob);
            }
        }
    }

    /**
     * Computing Mean
     *
     * @return Mean : double
     */
    public double computeMean() {
        double mean = 0;
        for (Object obj : X_value) {
            if (obj instanceof String) {
                try { // TODO: Check if X is numeric
                    double number = Double.parseDouble((String) obj);
                    mean += number;
                } catch (NumberFormatException e) {
                    return 0; // If any instances is not Numerical -> Return 0
                }
            }
        }
        mean /= X_value.size();
        return Mean = mean;
    }

    /**
     * Computing Variance
     *
     * @return Variance : double
     */
    public double computeVar() {
        double var = 0;
        double mean = this.computeMean();
        for (Object obj : X_value) {
            if (obj instanceof String) {
                try { // TODO: Check if X is numeric
                    double number = Double.parseDouble((String) obj);
                    var += Math.pow(number - mean, 2);
                } catch (NumberFormatException e) {
                    return 0; // If any instances is not Numerical -> Return 0
                }
            }
        }
        var /= X_value.size() - 1;
        return Variance = var;
    }

    /**
     * Computing Standard Deviation
     *
     * @return StdDev : double
     */
    public double computeStdDev() {
        double std = Math.sqrt(this.computeVar());
        return StdDev = std;
    }

    /**
     * Display the bar chart of the probability mass function
     */
    public void displayBarChart() {
        AWTBarChart chart = new AWTBarChart(
                "Probability Mass Function",
                "Probability Mass Function of " + this.X_name,
                this.X_name, "Probability", "PMF",
                this.X_value, this.prob
        );
        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
    }

    /**
     * Display the line chart of the probability mass function
     */
    public void displayLineChart() {
        AWTLineChart chart = new AWTLineChart(
                "Probability Mass Function",
                "Probability Mass Function of " + this.X_name,
                this.X_name, "Probability", "PMF",
                this.X_value, this.prob
        );
        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
    }

}
