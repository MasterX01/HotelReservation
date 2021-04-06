package com.bridgelabz.hotelreservation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hotel {
    public String hotelName;
    public int regularWeekDayRate;
    public int regularWeekEndRate;

    public Hotel(String hotelName, int regularWeekDayRate, int regularWeekEndRate) {
        this.hotelName = hotelName;
        this.regularWeekDayRate = regularWeekDayRate;
        this.regularWeekEndRate = regularWeekEndRate;

    }

    @Override
    public String toString() {
        String str = "Hotel name : " + this.hotelName + " rates for regular customer : " + this.regularWeekDayRate;
        return str;
    }

    // method to get day-weekday/weekend
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
            if (whichDay == "Sat" || whichDay == "Sun")
                totalAmount += this.regularWeekEndRate;
            else
                totalAmount += this.regularWeekDayRate;
            day++;
        }
        return totalAmount;
    }
}