package com.bridgelabz.hotelreservation;

import com.bridgelabz.hotelreservation.Hotel;
import com.bridgelabz.hotelreservation.HotelReservation;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

public class HotelReservationTest {
    HotelReservation hotelreservation = new HotelReservation();

    @Test
    public void whenGivenHotel_WhenAdded_ShouldMatchTheAdded() {
        Hotel hotel1 = new Hotel("Lakewood", 110, 90, 3);
        Hotel hotel2 = new Hotel("Bridgewood", 150, 50,4);
        Hotel hotel3 = new Hotel("Ridgewood", 220, 150, 5);
        hotelreservation.add(hotel1, hotel2, hotel3);
        Hotel hotel = new Hotel("Ridgewood", 220, 150, 5);
        Assertions.assertEquals("Ridgewood", hotel.hotelName);
        Assertions.assertEquals(220, hotel.regularWeekDayRate);
    }

    @Test
    public void given3Hotels_whenGivenDates_ShouldReturnCheapestHotel() throws ParseException{
        Hotel hotel1 = new Hotel("Lakewood", 110, 90, 3);
        Hotel hotel2 = new Hotel("Bridgewood", 150, 50, 4);
        Hotel hotel3 = new Hotel("Ridgewood", 220, 150, 5);
        hotelreservation.add(hotel1, hotel2, hotel3);
        Hotel cheapHotel = hotelreservation.findCheapestHotel("16March2020", "17March2020", "18March2020");
        Assertions.assertEquals("Lakewood", cheapHotel.hotelName);
    }

    @Test
    public void givenWeekendRate_WhenAdded_ShouldMatch() {
        Hotel hotel1 = new Hotel("Lakewood", 110, 90, 3);
        Hotel hotel2 = new Hotel("Bridgewood", 150, 50, 4);
        Hotel hotel3 = new Hotel("Ridgewood", 220, 150, 5);
        hotelreservation.add(hotel1, hotel2, hotel3);
        Hotel hotel = new Hotel("Bridgewood", 220, 150, 4);
        Assertions.assertEquals("Bridgewood", hotel.hotelName);
        Assertions.assertEquals(150, hotel.regularWeekEndRate);
    }

    @Test
    public void given3Hotels_whenGivenDatesIncludingWeekends_ShouldReturnCheapestHotel() throws ParseException {
        Hotel hotel1 = new Hotel("Lakewood", 110, 90, 3);
        Hotel hotel2 = new Hotel("Bridgewood", 150, 50, 4);
        Hotel hotel3 = new Hotel("Ridgewood", 220, 150, 5);
        hotelreservation.add(hotel1, hotel2, hotel3);
        Hotel cheapHotel = hotelreservation.findCheapestHotel("11Sep2020", "12Sep2020");
        Assertions.assertEquals("Bridgewood", cheapHotel.hotelName);
    }

    @Test
    public void givenRating_WhenAdded_ShouldMatch() {
        Hotel hotel1 = new Hotel("Lakewood", 110, 90, 3);
        Hotel hotel2 = new Hotel("Bridgewood", 150, 50, 4);
        Hotel hotel3 = new Hotel("Ridgewood", 220, 150, 5);
        hotelreservation.add(hotel1, hotel2, hotel3);
        Hotel hotel = new Hotel("Ridgewood", 220, 150,5);
        Assertions.assertEquals("Ridgewood", hotel.hotelName);
        Assertions.assertEquals(5, hotel.rating);
    }

    @Test
    public void given3Hotels_whenGivenDates_ShouldReturnCheapestHotelAsPerRating() throws ParseException {
        Hotel hotel1 = new Hotel("Lakewood", 110, 90, 3);
        Hotel hotel2 = new Hotel("Bridgewood", 150, 50, 4);
        Hotel hotel3 = new Hotel("Ridgewood", 220, 150, 5);
        hotelreservation.add(hotel1, hotel2, hotel3);
        Hotel cheapHotel = hotelreservation.findCheapestHotel("11Sep2020", "12Sep2020");
        Assertions.assertEquals("Bridgewood", cheapHotel.hotelName);
    }

}
