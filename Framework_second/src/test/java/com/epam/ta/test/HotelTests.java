package com.epam.ta.test;

import com.epam.ta.model.HotelSearchCriteria;
import com.epam.ta.page.HomePage;
import com.epam.ta.page.HotelDetailPage;
import com.epam.ta.page.HotelsPage;
import com.epam.ta.service.HotelSearchCriteriaCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.epam.ta.util.StringUtils.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class HotelTests extends CommonConditions {

    @Test
    public void detailedHotelInformationHasPriceAlertMainText() {
        HotelSearchCriteria hotelSearchCriteria = HotelSearchCriteriaCreator.withCredentialsFromProperty();

        HotelDetailPage hotelDetailPage = new HotelsPage(driver)
                .openPage()
                .searchForHotels(hotelSearchCriteria.getDestination(), hotelSearchCriteria.getCheckIn(), hotelSearchCriteria.getCheckOut())
                .openDetailedHotelInformation(1);

        switchToWindow(1);

        String priceAlertMainText = hotelDetailPage.openPricingAlertSettings()
                .getPriceAlertMainText();

        assertThat(PRICE_ALERT_MAIN_TEXT, is(equalTo(priceAlertMainText)));
    }

    @Test
    public void priceOfTheHotelAfterSearchingIsTheSameAsOnTheHotelPage() {
        HotelSearchCriteria hotelSearchCriteria = HotelSearchCriteriaCreator.withCredentialsFromProperty();

        HotelsPage hotelsPage = new HotelsPage(driver)
                .openPage()
                .searchForHotels(hotelSearchCriteria.getDestination(), hotelSearchCriteria.getCheckIn(), hotelSearchCriteria.getCheckOut());

        String hotelPriceAfterSearching = hotelsPage.getHotelPrice(FIRST_HOTEL_NUMBER);

        HotelDetailPage hotelDetailPage = hotelsPage.openDetailedHotelInformation(FIRST_HOTEL_NUMBER);

        switchToWindow(1);

        String hotelPriceOnDetailPage = hotelDetailPage.getHotelPrice();

        assertThat(hotelPriceAfterSearching, is(equalTo(hotelPriceOnDetailPage)));
    }

    @Test
    public void openHotelDetailPageAfterClickTheButtonMoreDetails() {
        HotelSearchCriteria hotelSearchCriteria = HotelSearchCriteriaCreator.withCredentialsFromProperty();

        HotelsPage hotelsPage = new HotelsPage(driver)
                .openPage()
                .searchForHotels(hotelSearchCriteria.getDestination(), hotelSearchCriteria.getCheckIn(), hotelSearchCriteria.getCheckOut());

        String hotelNameAfterSearching = hotelsPage.getHotelName(FIRST_HOTEL_NUMBER);
        String searchUrl = hotelsPage.getCurrentUrl();

        HotelDetailPage hotelDetailPage = hotelsPage.openDetailedHotelInformation(FIRST_HOTEL_NUMBER);

        switchToWindow(1);

        String currentUrl = hotelDetailPage.getCurrentUrl();
        String hotelNameOnDetailPage = hotelDetailPage.getHotelName();

        assertThat(hotelNameAfterSearching, is(equalTo(hotelNameOnDetailPage)));
        assertThat(currentUrl, is(not(searchUrl)));
    }

    @Test
    public void checkSearchDestinationAfterSearch() throws InterruptedException {
        HotelSearchCriteria hotelSearchCriteria = HotelSearchCriteriaCreator.withCredentialsFromProperty();

        HotelsPage hotelsPage = new HotelsPage(driver)
                .openPage()
                .searchForHotels(hotelSearchCriteria.getDestination(), hotelSearchCriteria.getCheckIn(), hotelSearchCriteria.getCheckOut());

        String destinationTextFromSearchBar = hotelsPage.getDestination();

        assertThat(destinationTextFromSearchBar, is(equalTo(hotelSearchCriteria.getDestination())));
    }

    @Test
    public void checkHotelRatingInDetailPage() {
        HotelSearchCriteria hotelSearchCriteria = HotelSearchCriteriaCreator.withCredentialsFromProperty();

        HotelsPage hotelsPage = new HotelsPage(driver)
                .openPage()
                .searchForHotels(hotelSearchCriteria.getDestination(), hotelSearchCriteria.getCheckIn(), hotelSearchCriteria.getCheckOut());

        String hotelRationAfterSearch = hotelsPage.getHotelRating();

        HotelDetailPage hotelDetailPage = hotelsPage.openDetailedHotelInformation(FIRST_HOTEL_NUMBER);

        switchToWindow(1);

        String hotelRatingOnDetailPage = hotelDetailPage.getHotelRating();

        assertThat(hotelRationAfterSearch, is(equalTo(hotelRatingOnDetailPage)));
    }

    @Test
    public void incorrectDestinationName(){
        HotelSearchCriteria hotelSearchOptions = HotelSearchCriteriaCreator.withIncorrectDestination();
        String alertMessage = new HotelsPage(driver)
                .openPage()
                .searchForHotels(hotelSearchOptions.getDestination(),
                        hotelSearchOptions.getCheckIn(),
                        hotelSearchOptions.getCheckOut())
                .searchNotFoundAlertMessage();
        Assert.assertEquals(CITY_NAME_ALERT_TEXT,alertMessage);
    }

    @Test
    public void checkAdultsOnHotelDetailPage() {
        HotelSearchCriteria hotelSearchCriteria = HotelSearchCriteriaCreator.withCredentialsFromProperty();

        HotelDetailPage hotelDetailPage = new HotelsPage(driver)
                .openPage()
                .searchForHotels(hotelSearchCriteria.getDestination(), hotelSearchCriteria.getCheckIn(), hotelSearchCriteria.getCheckOut())
                .openDetailedHotelInformation(1);

        switchToWindow(1);

        int currentNumberOfAdults = hotelDetailPage.getCurrentNumberOfAdults();

        assertThat(currentNumberOfAdults, is(equalTo(hotelSearchCriteria.getNumberOfGuests())));

    }
    public void searchHotelWithYesterdayDate(){
        HotelSearchCriteria hotelSearchCriteria = HotelSearchCriteriaCreator.withYesterdayDate();
        String textOfMessageAboutErrorsWithDate = new HotelsPage(driver)
                .openPage()
                .searchForHotels(hotelSearchCriteria.getDestination(), hotelSearchCriteria.getCheckIn(), hotelSearchCriteria.getCheckOut())
                .getTextOfMessageAboutErrorsWithDate();
        assertThat(textOfMessageAboutErrorsWithDate, is(equalTo(ERROR_MESSAGE_YESTERDAY_DATE)));
    }

    @Test
    public void searchHotelWithoutDepartureDate(){
        HotelSearchCriteria hotelSearchCriteria = HotelSearchCriteriaCreator.withoutDepartureDate();
        String textOfMessageAboutErrorsWithDate = new HotelsPage(driver)
                .openPage()
                .searchForHotels(hotelSearchCriteria.getDestination(), hotelSearchCriteria.getCheckIn(), hotelSearchCriteria.getCheckOut())
                .getTextOfMessageAboutErrorsWithDate();
        assertThat(textOfMessageAboutErrorsWithDate, is(equalTo("Укажите дату выезда")));
    }

    @Test
    public void changeAdultsAndRoomNumberOnHotelDetailPage() {
        HotelSearchCriteria hotelSearchCriteria = HotelSearchCriteriaCreator.withCredentialsFromProperty();

        HotelDetailPage hotelDetailPage = new HotelsPage(driver)
                .openPage()
                .searchForHotels(hotelSearchCriteria.getDestination(), hotelSearchCriteria.getCheckIn(), hotelSearchCriteria.getCheckOut())
                .openDetailedHotelInformation(1);

        switchToWindow(1);

        hotelDetailPage.changeAdultsCount(TEN_ADULTS);

        int currentNumberOfAdults = hotelDetailPage.getCurrentNumberOfAdults();
        assertThat(currentNumberOfAdults, is(equalTo(TEN_ADULTS)));

    }
}
