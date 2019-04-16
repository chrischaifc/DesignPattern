package com.company;

public class TaxCalculation {

    //3D array for different conditions
    static double[][][] var1 =
            {
                    {
                            {0, 1.6, 5.6, 19.1, 39.1},
                            {0, 1.4, 5.0, 17.6, 36.6},
                            {0, 1.2, 4.4, 16.1, 34.1}
                    },
                    {
                            {0, 1.4, 5.0, 17.6, 36.6},
                            {0, 1.2, 4.4, 16.1, 34.1},
                            {0, 1.0, 3.8, 14.6, 31.6},
                            {0, 0.8, 3.2, 13.1, 29.1}
                    }
            };


    static double[][][] var2 =
            {
                    {
                            {0.08, 0.10, 0.15, 0.20, 0.25},
                            {0.07, 0.09, 0.14, 0.19, 0.24},
                            {0.06, 0.08, 0.13, 0.18, 0.23}
                    },
                    {
                            {0.07, 0.09, 0.14, 0.19, 0.24},
                            {0.06, 0.08, 0.13, 0.18, 0.23},
                            {0.05, 0.07, 0.12, 0.17, 0.22},
                            {0.04, 0.06, 0.11, 0.16, 0.21}
                    }
            };

    static int[] var3 = {0, 20, 60, 150, 250};

    //to calculate the tax
    public static int tax (int t, int d, int X){
        int varIndex = var3Index(X);
        int index = var3[varIndex];
        int tax = (int) Math.round((var1[t-1][d-1][varIndex] + var2[t-1][d-1][varIndex] * (X - index)) * 1000);
        return tax;
    }

    //get index based on income
    public static int var3Index(int X)
    {
        int i = 0;
        if (X <= 20)
            i = 0;
        else if (X <= 60)
            i = 1;
        else if (X <= 150)
            i = 2;
        else if (X <= 250)
            i = 3;
        else if (X <= 1000)
            i = 4;

        return i;

    }


}
