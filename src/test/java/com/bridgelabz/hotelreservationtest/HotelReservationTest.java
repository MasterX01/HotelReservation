package com.bridgelabz.hotelreservationtest;

import com.bridgelabz.hotelreservation.HotelReservation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HotelReservationTest {

    @Test
    public void givenHotelDetails_ShouldBeAddedToHotelDatails() {
        HotelReservation hotels = new HotelReservation();
        Assertions.assertTrue(hotels.addHotel("Lalit", 5));
        Assertions.assertTrue(hotels.addHotel("Taj", 4));
        Assertions.assertTrue(hotels.addHotel("BlueBell", 3));

    }
}
