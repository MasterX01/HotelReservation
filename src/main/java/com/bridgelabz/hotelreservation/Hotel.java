package com.bridgelabz.hotelreservation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hotel {
    public String hotelName;
    public int regularWeekDayRate;
    public int regularWeekEndRate;
    public int rating;

    public Hotel(String hotelName, int regularWeekDayRate, int regularWeekEndRate, int rating) {
        this.hotelName = hotelName;
        this.regularWeekDayRate = regularWeekDayRate;
        this.regularWeekEndRate = regularWeekEndRate;
        this.rating = rating;
    }

    public static String getDayOfWeek(String date) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy");
        Date actualDate = dateFormat.parse(date);
        DateFormat dayFormat = new SimpleDateFormat("EE");
        String day = dayFormat.format(actualDate);
        return day;
    }

    public int calculatePrice(String... days) throws ParseException {
        int totalAmount = 0;
        for (int day = 0; day < days.length; day++) {
            String whichDay = getDayOfWeek(days[day]);
            if (whichDay.equals("Sat") || whichDay.equals("Sun")) {
                totalAmount += this.regularWeekEndRate;
            } else{
                totalAmount += this.regularWeekDayRate;
            }
        }
        return totalAmount;
    }
}