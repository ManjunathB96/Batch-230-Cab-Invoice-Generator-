package com.bridgelabz_cab_invoice_generator;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CabInvoiceGeneratorTest {
    CabInvoiceGenerator invoiceGenerator = null;

    @BeforeEach
     void setUp() throws Exception {
        invoiceGenerator = new CabInvoiceGenerator();
    }

    @Test
    void givenDistanceAndTime_ShouldReturn_TotalFare() {
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assertions.assertEquals(25, fare, 0.0);
    }

    @Test
    void givenLessDistanceOTime_ShouldReturn_MinFare() {
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assertions.assertEquals(5, fare);
    }

    @Test
    void givenMultipleRides_ShouldReturn_TotalFare() {
       // CabInvoiceGenerator invoiceGenerator = new CabInvoiceGenerator();
        Ride[] rides = {
                new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assertions.assertEquals(expectedInvoiceSummary, summary);
    }
}

