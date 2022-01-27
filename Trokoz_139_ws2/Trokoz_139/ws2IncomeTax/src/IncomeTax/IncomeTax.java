/**********************************************
 Workshop # 2
 Course:	    JAC444 - Winter 2021
 Last Name: 	Trokoz
 First Name: 	Liubov
 ID:		    139578199
 Section: 	    NBB
 This assignment represents my own work in accordance with Seneca Academic Policy.
 Signature
 Date: 		    13-02-2021
 **********************************************/

package IncomeTax;

public class IncomeTax {

    public static final int SINGLE_FILER = 0;
    public static final int MARRIED_JOINTLY_OR_QUALIFYING_WIDOW = 1;
    public static final int MARRIED_SEPARATELY = 2;
    public static final int HEAD_OF_HOUSEHOLD = 3;

    private int statusInput;
    private int[][] intervals;
    private double[] rates;
    private double taxableIncome;

    public static double[] taxRate2009 = { 0.10, 0.15, 0.25, 0.28, 0.33, 0.35 };

    public static int[][] intervals2009 = {
            { 8350, 33950, 82250, 171550, 372950 },
            { 16700, 67900, 137050, 20885, 372950 },
            { 8350, 33950, 68525, 104425, 186475 },
            { 11950, 45500, 117450, 190200, 372950 }
    };

    IncomeTax() {
        taxableIncome = 0;
        statusInput = SINGLE_FILER;
        setRates(taxRate2009);
        setIntervals(intervals2009);
    }

    IncomeTax(int statusInput, int[][] intervals, double[] rates, double taxableIncome) {
        setRates(rates);
        setIntervals(intervals);
        setTaxableIncome(taxableIncome);
        setStatusInput(statusInput);
    }

    public double getIncomeTax() {
        double incomeTax = 0;
        if (taxableIncome <= intervals[statusInput][0])
            incomeTax = taxableIncome * rates[0];
        else
            incomeTax = intervals[statusInput][0] * rates[0];

        for (int i = 1; i < intervals[0].length; i++) {
            if (taxableIncome > intervals[statusInput][i])
                incomeTax += (intervals[statusInput][i] - intervals[statusInput][i - 1]) * rates[i];
            else {
                incomeTax += (taxableIncome - intervals[statusInput][i - 1]) * rates[i];
                break; }
        }
        return incomeTax;
    }

    public void setStatusInput(int statusInput) {
        this.statusInput = statusInput;
    }

    public void setRates(double[] rates) {
        this.rates = rates;
    }

    public double[] getRates() {
        return rates;
    }

    public void setIntervals(int[][] intervals) {
        this.intervals = intervals;
    }

    public int[][] getIntervals() {
        return intervals;
    }

    public void setTaxableIncome(double taxableIncome) {
        this.taxableIncome = taxableIncome;
    }
}
