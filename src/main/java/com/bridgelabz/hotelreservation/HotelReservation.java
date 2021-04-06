package com.bridgelabz.hotelreservation;

import java.text.ParseException;
import java.util.*;

public class HotelReservation {
    public List<Hotel> listOfHotels = new ArrayList<>();

    public void add(Hotel... hotels) {
        int i = 0;
        while (i < hotels.length) {
            listOfHotels.add(hotels[i]);
            i++;
        }
    }

    public Hotel findCheapestHotel(String... days) throws ParseException {
        int lowestPrice = Integer.MAX_VALUE;
        Hotel cheapHotel = listOfHotels.get(0);
        for (int hotel = 0; hotel < listOfHotels.size(); hotel++) {
            int price = listOfHotels.get(hotel).calculatePrice(days);
            if (price < lowestPrice) {
                lowestPrice = price;
                cheapHotel = listOfHotels.get(hotel);
            }
            if (price == lowestPrice && cheapHotel.rating < listOfHotels.get(hotel).rating)
                cheapHotel = listOfHotels.get(hotel);
        }
        return cheapHotel;
    }

    public Hotel findBestRatedHotel(String... days) throws ParseException {
        int rating = 0;
        Hotel bestRated = listOfHotels.get(0);
        for (int hotel = 0; hotel < listOfHotels.size(); hotel++) {
            if (rating < listOfHotels.get(hotel).rating)
                bestRated = listOfHotels.get(hotel);
        }
        return bestRated;
    }

}
