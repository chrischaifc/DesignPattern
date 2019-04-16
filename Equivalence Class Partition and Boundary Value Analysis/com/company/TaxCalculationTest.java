package com.company;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class TaxCalculationTest {

    private int marital;
    private int dependents;
    private int income;
    private int expectedTax;

    //constructor for inputs
    public TaxCalculationTest(int marital, int dependents, int income, int expectedTax) {
        this.marital = marital;
        this.dependents = dependents;
        this.income = income;
        this.expectedTax = expectedTax;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                //normal data
                {1, 1, 18, 1440}, {1, 1, 40, 3600}, {1, 1, 105, 12350}, {1, 1, 200, 29100}, {1, 1, 600, 126600},
                {1, 2, 18, 1260}, {1, 2, 40, 3200}, {1, 2, 105, 11300}, {1, 2, 200, 27100}, {1, 2, 600, 120600},
                {1, 3, 18, 1080}, {1, 3, 40, 2800}, {1, 3, 105, 10250}, {1, 3, 200, 25100}, {1, 3, 600, 114600},
                {2, 1, 18, 1260}, {2, 1, 40, 3200}, {2, 1, 105, 11300}, {2, 1, 200, 27100}, {2, 1, 600, 120600},
                {2, 2, 18, 1080}, {2, 2, 40, 2800}, {2, 2, 105, 10250}, {2, 2, 200, 25100}, {2, 2, 600, 114600},
                {2, 3, 18, 900}, {2, 3, 40, 2400}, {2, 3, 105, 9200}, {2, 3, 200, 23100}, {2, 3, 600, 108600},
                {2, 4, 18, 720}, {2, 4, 40, 2000}, {2, 4, 105, 8150}, {2, 4, 200, 21100}, {2, 4, 600, 102600},

                //data at boundaries
                {1, 1, 20, 1600}, {1, 1, 60, 5600}, {1, 1, 150, 19100}, {1, 1, 250, 39100}, {1, 1, 1000, 226600},
                {1, 2, 20, 1400}, {1, 2, 60, 5000}, {1, 2, 150, 17600}, {1, 2, 250, 36600}, {1, 2, 1000, 216600},
                {1, 3, 20, 1200}, {1, 3, 60, 4400}, {1, 3, 150, 16100}, {1, 3, 250, 34100}, {1, 3, 1000, 206600},
                {2, 1, 20, 1400}, {2, 1, 60, 5000}, {2, 1, 150, 17600}, {2, 1, 250, 36600}, {2, 1, 1000, 216600},
                {2, 2, 20, 1200}, {2, 2, 60, 4400}, {2, 2, 150, 16100}, {2, 2, 250, 34100}, {2, 2, 1000, 206600},
                {2, 3, 20, 1000}, {2, 3, 60, 3800}, {2, 3, 150, 14600}, {2, 3, 250, 31600}, {2, 3, 1000, 196600},
                {2, 4, 20, 800}, {2, 4, 60, 3200}, {2, 4, 150, 13100}, {2, 4, 250, 29100}, {2, 4, 1000, 186600}

        });
    }

    //test
    @org.junit.Test
    public void tax() {
        assertEquals(expectedTax, TaxCalculation.tax(marital, dependents, income));
    }
}