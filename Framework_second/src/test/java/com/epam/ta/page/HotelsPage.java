package com.epam.ta.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HotelsPage extends AbstractPage {

    @FindBy(xpath = "//input[@id='destination-autosuggest']")
    private WebElement destinationsInput;

    @FindBy(xpath = "//input[@id='guests-rooms']")
    private WebElement guestsSelect;

    @FindBy(xpath = "//div[@class='SearchBar_SearchBa']")
    private WebElement searchBarDestination;

    @FindBy(xpath = "//*[@id='adults']")
    private WebElement currectRoomsNumber;

    @FindBy(xpath = "//*[@id='popover']/div/div/div/div[2]/div/button[1]")
    private WebElement minusAdultsButtuon;

    @FindBy(xpath = "//*[@id='popover']/div/div/div/div[2]/div/button[2]")
    private WebElement plusAdultsButtuon;

    @FindBy(xpath = "//*[@id='popover']/div/div/div/div[1]/div/button[1]")
    private WebElement minusRoomsButtuon;

    @FindBy(xpath = "//*[@id='popover']/div/div/div/div[1]/div/button[2]")
    private WebElement plusRoomsButtuon;

    @FindBy(xpath = "//*[@id='popover']/footer/button")
    private WebElement applyGuestsNumber;

    @FindBy(xpath = "//*[@id='frm']/button")
    private WebElement searchHotelsButton;

    @FindBy(xpath = "//div[@class='HotelCard_HotelCard__price__1Q_iY']")
    private List<WebElement> hotelPrice;

    @FindBy(xpath = "//span[@class='HotelCard_HotelCard__name__3EA3e']")
    private List<WebElement> hotelName;

    @FindBy(xpath = "//*[@id='app-root']")
    private WebElement hotelRating;

    @FindBy(xpath = "//div[@class='HotelCard_HotelCard__cta__26snW']")
    private List<WebElement> detailHotelInformationButton;

    @FindBy(xpath = "//a[@class='BpkCard_bpk-card__3E_5J ']")
    private List<WebElement> selectionOfHotels;

    @FindBy(xpath = "//div[@class ='sb-searchbox__error -visible']")
    private WebElement alertMessage;

    @FindBy(xpath = "//div[@class='form-error']/span")
    private WebElement errorMessageDate;

    public HotelsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public HotelsPage openPage() {
        return this;
    }

    public HotelsPage searchForHotels(String destinations, String checkIn, String checkOut) {
        destinationsInput.sendKeys(destinations);
        destinationsInput.click();
        guestsSelect.click();
        applyGuestsNumber.click();
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        searchHotelsButton.click();
        return this;
    }

    private void changeAdultsCount(int adultsNumber) {
        int adultsClickCount = adultsNumber - Integer.parseInt(currectAdultsNumber.getAttribute("value"));
        if (adultsClickCount > 0) {
            for (int i = 0; i < adultsClickCount; i++) {
                plusAdultsButtuon.click();
            }
        } else {
            for (int i = 0; i < Math.abs(adultsClickCount); i++) {
                minusAdultsButtuon.click();
            }
        }
    }

    public HotelDetailPage openDetailedHotelInformation(int hotelNumber) {
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        if (hotelNumber - 1 < detailHotelInformationButton.size()) {
            detailHotelInformationButton.get(hotelNumber - 1).click();
            ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(newTab.get(1));
            return new HotelDetailPage(driver);
        }
        return null;
    }

    public String getHotelPrice(int hotelNumber) {
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        return hotelNumber - 1 < hotelPrice.size() ? hotelPrice.get(hotelNumber - 1).getText() : null;
    }

    public String getHotelName(int hotelNumber) {
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);

        return hotelNumber - 1 < hotelName.size() ? hotelName.get(hotelNumber - 1).getText() : null;
    }

    public String getDestination() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        return destinationsInput.getAttribute("value");
    }


    public String getHotelRating() {
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        return hotelRating.getText();
    }
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String searchNotFoundAlertMessage(){
        return alertMessage.getText();
    }

    public String getTextOfMessageAboutErrorsWithDate(){
        return errorMessageDate.getText();
    }


}
