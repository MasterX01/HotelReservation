package com.bridgelabz.hotelreservation;

public class Hotel {
    String hotelName;
    int rating;
    int weekDayRates;
    int weekendRates;
    String typeOfCustomer;

    public Hotel(String hotelName, int rating, int weekDayRates, int weekendRates) {
        this.hotelName = hotelName;
        this.rating = rating;
        this.weekDayRates = weekDayRates;
        this.weekendRates = weekendRates;
    }
    public String getHotelName(){
        return this.hotelName;
    }
    public int getWeekDayRates() {
        return this.weekDayRates;
    }
    public int getWeekendRates() {
        return weekendRates;
    }

}
