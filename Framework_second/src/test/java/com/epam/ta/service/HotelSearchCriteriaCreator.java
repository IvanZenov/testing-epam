package com.epam.ta.service;

import com.epam.ta.model.HotelSearchCriteria;

public class HotelSearchCriteriaCreator {


    public static final String TEST_DATA_HOTEL_SEARCH_CRITERIA_DESTINATION = "testdata.hotelSearchCriteria.destination";
    public static final String TEST_DATA_HOTEL_SEARCH_CRITERIA_CHECKIN_DATE = "testdata.hotelSearchCriteria.arrivalDate";
    public static final String TEST_DATA_HOTEL_SEARCH_CRITERIA_CHECKOUT_DATE = "testdata.hotelSearchCriteria.departureDate";
    public static final String INCORRECT_DESTINATION = "dajfkladsjfl";


    public static HotelSearchCriteria withCredentialsFromProperty() {
        return new HotelSearchCriteria(TestDataReader.getTestData(TEST_DATA_HOTEL_SEARCH_CRITERIA_DESTINATION),
                TEST_DATA_HOTEL_SEARCH_CRITERIA_CHECKIN_DATE,TEST_DATA_HOTEL_SEARCH_CRITERIA_CHECKOUT_DATE);

    }

    public static HotelSearchCriteria withIncorrectDestination() {
        return new HotelSearchCriteria(TestDataReader.getTestData(INCORRECT_DESTINATION),
                TEST_DATA_HOTEL_SEARCH_CRITERIA_CHECKIN_DATE, TEST_DATA_HOTEL_SEARCH_CRITERIA_CHECKOUT_DATE);

    }
    public static HotelSearchCriteria withYesterdayDate(){
        return new HotelSearchCriteria(TestDataReader.getTestData(TEST_DATA_HOTEL_SEARCH_CRITERIA_DESTINATION),
                TestDataReader.getTestData(TEST_DATA_HOTEL_SEARCH_CRITERIA_CHECKOUT_DATE),
                TestDataReader.getTestData(TEST_DATA_HOTEL_SEARCH_CRITERIA_CHECKIN_DATE));
    }

    public static HotelSearchCriteria withoutDepartureDate(){
        return new HotelSearchCriteria(TestDataReader.getTestData(TEST_DATA_HOTEL_SEARCH_CRITERIA_DESTINATION),
                TestDataReader.getTestData(TEST_DATA_HOTEL_SEARCH_CRITERIA_CHECKIN_DATE),
                TestDataReader.getTestData(""));
    }

}
