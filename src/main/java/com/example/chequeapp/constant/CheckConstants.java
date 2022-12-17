package com.example.chequeapp.constant;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

public class CheckConstants {

    public static String HEADER = """
                           CASH RECEIPT
                          supermarket 123
                     12, MILKYWAY Galaxy / Earth
                          Tel: 154-167-7852
                           
            """;
    public static String CASHIER = "CASHIER: №" + ThreadLocalRandom.current().nextInt(1, 9999);
    public static String DATE_AND_TIME = "date: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
            + "\n" +
            "time: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss"));

    public static String DIVIDING_LINE = "___________________________________________";
}
