package com.bridgelabz.hotelreservation;

import java.util.ArrayList;

public class HotelReservation {
    ArrayList<Hotel> listOfHotels = new ArrayList<>();

    public boolean addHotel(String hotelName, int rating){
        listOfHotels.add(new Hotel(hotelName, rating));
        return true;
    }
}
