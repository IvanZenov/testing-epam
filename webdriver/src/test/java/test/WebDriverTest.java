package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HotelHomePage;
import page.HotelPageInformation;
import page.SearchHotelResult;

public class WebDriverTest {
    private final static String INCORRECT_CITY_NAME = "adfjkl";
    private final static String CITY_NAME_ALERT_TEXT = "Ошибка:\n" + "К сожалению, нам не известно это направление.";
    private final static String BOOKING_DETAILS_ERROR_MESSAGE = "Введите номер вашего бронирования.";
    public WebDriver driver;



    @BeforeMethod(alwaysRun = true)
        public void setUpBrowser(){
            driver = new ChromeDriver();
        }


    @Test
    public void incorrectDestinationName(){
        String alertMessage = new HotelHomePage(driver)
                .openPage()
                .incorrectSearch(INCORRECT_CITY_NAME,"2019-11-12","2019-11-13")
                .searchNotFoundAlertMessage();
        Assert.assertEquals(CITY_NAME_ALERT_TEXT,alertMessage);
    }

    @Test
    public void writeReviewWithoutBookingDetails(){
        String  message = new HotelHomePage(driver)
                .openPage()
                .correctSearch("Madrid","2019-11-12","2019-11-13")
                .checkComment()
                .errorReviewMessage();
        Assert.assertEquals(message,BOOKING_DETAILS_ERROR_MESSAGE);
    }


    @AfterMethod(alwaysRun = true)
    public void tearDownBrowser(){
        driver.quit();
        driver = null;
    }


}
