/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4_5;

import java.util.ArrayList;
import java.util.Arrays;

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

    public RandomVar(String x_name, Object[] values) {
        X_name = x_name;
        X_value = new ArrayList<>();
        prob = new ArrayList<>();
        Arrays.sort(values);
        assignX_Prob(values);
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
        int count = 0;
        for (int i = 0; i < values.length; i++) {
            if (X_value.contains(values[i])) {
                count++;
            } else {
                if (i == 0) {
                    count = 1;
                    X_value.add(values[i]);
                }
                if (i != 0 && i != values.length - 1) {
                    double d_prob = ((double) count) / values.length;
                    prob.add(d_prob);
                    count = 1;
                    X_value.add(values[i]);
                }
            }

            if (i == values.length - 1) {
                double d_prob = ((double) count) / values.length;
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
        // TODO: Check if X is numeric
        Mean = mean;
        return mean;
    }

    /**
     * Computing Variance
     *
     * @return Variance : double
     */
    public double computeVar() {
        double var = 0;
        // TODO: Check if X is numeric
        Variance = var;
        return var;
    }

    /**
     * Computing Standard Deviation
     *
     * @return StdDev : double
     */
    public double computeStdDev() {
        double STD = 0;
        // TODO: Check if X is numeric
        StdDev = STD;
        return STD;
    }

    /**
     * Display the bar chart of the probability mass function
     */
    public void displayBarChart() {
        // TODO
    }

    /**
     * Display the line chart of the probability mass function
     */
    public void displayLineChart() {
        // TODO
    }

}
