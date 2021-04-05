package com.bridgelabz.hotelreservation;

import com.bridgelabz.hotelreservation.Hotel;
import com.bridgelabz.hotelreservation.HotelReservation;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HotelReservationTest {
    HotelReservation hotelreservation;

    @Test
    public void whenGivenHotel_WhenAdded_ShouldMatchTheAdded() {
        Hotel hotel1 = new Hotel("Lakewood", 110);
        Hotel hotel2 = new Hotel("Bridgewood", 160);
        Hotel hotel3 = new Hotel("Nashvilla", 220);
        hotelreservation = new HotelReservation();
        hotelreservation.add(hotel1, hotel2, hotel3);
        Hotel hotel = new Hotel("Ridgewood", 220);
        Assertions.assertEquals("Ridgewood", hotel.hotelName);
        Assertions.assertEquals(220, hotel.regularCustomerRate);
    }

    @Test
    public void given3Hotels_whenGivenDates_ShouldReturnCheapestHotel() {
        Hotel hotel1 = new Hotel("Lakewood", 110);
        Hotel hotel2 = new Hotel("Bridgewood", 160);
        Hotel hotel3 = new Hotel("Nashvilla", 220);
        hotelreservation = new HotelReservation();
        hotelreservation.add(hotel1, hotel2, hotel3);
        Hotel cheapHotel = hotelreservation.findCheapestHotel("16March2020", "17March2020", "18March2020");
        Assertions.assertEquals("Lakewood", cheapHotel.hotelName);
    }
}
