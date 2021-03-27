package com.bridgelabz.hotelreservationtest;

import com.bridgelabz.hotelreservation.HotelReservation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HotelReservationTest {

    @Test
    public void givenHotelDetails_whenAdding1stHotel_ShouldReturnTrue() {
        HotelReservation hotels = new HotelReservation();
        Assertions.assertTrue(hotels.addHotel("Lalit", 5, 200));

    }

    @Test
    public void givenHotelDetails_whenAdding2ndHotel_ShouldReturnTrue() {
        HotelReservation hotels = new HotelReservation();
        Assertions.assertTrue(hotels.addHotel("Taj", 4, 150));

    }

    @Test
    public void givenHotelDetails_whenAdding3rdHotel_ShouldReturnTrue() {
        HotelReservation hotels = new HotelReservation();
        Assertions.assertTrue(hotels.addHotel("BlueBell", 3, 100));

    }

}
