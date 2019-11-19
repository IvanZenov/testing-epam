package test;

import model.HotelSearchOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HotelHomePage;
import service.HotelSearchOptionsCreator;

import static util.StringUtils.BOOKING_DESTINATION;

public class CorrectSearchHotels extends CommonCondition {


    @Test
    public void checkCurrentDestinationOnHotelPage(){
        HotelSearchOptions hotelSearchOptions = HotelSearchOptionsCreator.withCorrectSearch();
        String  message = new HotelHomePage(driver)
                .openPage()
                .correctSearch(hotelSearchOptions.getDestination(),
                        hotelSearchOptions.getCheckIn(),
                        hotelSearchOptions.getCheckOut())
                .checkComment()
                .getDestinationHotel();
        Assert.assertEquals(BOOKING_DESTINATION,message);
    }
}
