package com.bridgelabz.hotelreservation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hotel {
    public String hotelName;
    public int regularWeekDayRate;
    public int regularWeekEndRate;
    public int loyaltyWeekDayRates;
    public int loyaltyWeekendRates;
    int rating;

    enum customers{
        REGULAR, LOYALTY;
    }

    public Hotel(String hotelName, int regularWeekDayRate, int regularWeekEndRate, int rating, int loyaltyWeekDayRates, int loyaltyWeekendRates) {
        this.hotelName = hotelName;
        this.regularWeekDayRate = regularWeekDayRate;
        this.regularWeekEndRate = regularWeekEndRate;
        this.rating = rating;
        this.loyaltyWeekDayRates = loyaltyWeekDayRates;
        this.loyaltyWeekendRates = loyaltyWeekendRates;
    }

    public static String getDayOfWeek(String date) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy");
        Date actualDate = dateFormat.parse(date);
        DateFormat dayFormat = new SimpleDateFormat("EE");
        String day = dayFormat.format(actualDate);
        return day;
    }

    public int calculatePrice(customers type, String... days) throws ParseException {
        int totalAmount = 0;
        for (int day = 0; day < days.length; day++) {
            String whichDay = getDayOfWeek(days[day]);
            if (whichDay.equals("Sat") || whichDay.equals("Sun")) {
                totalAmount += type == customers.REGULAR ? this.regularWeekEndRate : this.loyaltyWeekendRates;
            } else{
                totalAmount += type == customers.REGULAR ? this.regularWeekDayRate : this.loyaltyWeekDayRates;
            }
        }
        return totalAmount;
    }
}