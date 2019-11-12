package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HotelHomePage extends AbstractPage{

    private static final String HOTEL_HOMEPAGE_URL = "https://www.booking.com/";

    @FindBy(xpath = "//input[@id ='ss']")
    private WebElement inputPlace;

    @FindBy(xpath = "//*[@id='frm']/div[1]/div[4]/div[2]/button") //Govno
    private WebElement searchButton;

    @FindBy(xpath = "//span[@class ='sb-date-field__icon sb-date-field__icon-btn bk-svg-wrapper calendar-restructure-sb']")
    private WebElement arrivalDateSpan;

    @FindBy(xpath = "//div[@class ='sb-searchbox__error -visible']")
    private WebElement alertMessage;

    private WebElement dateCheckIn;
    private WebElement dateCheckOut;

   public HotelHomePage incorrectSearch(String destination, String checkIn, String checkOut){
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       inputPlace.sendKeys(destination);
       arrivalDateSpan.click();
       this.dateCheckIn = driver.findElement(By.xpath("//td[@data-date = '" + checkIn +"']"));
       this.dateCheckOut = driver.findElement(By.xpath("//td[@data-date = '" + checkOut +"']"));
       dateCheckIn.click();
       dateCheckOut.click();
       searchButton.click();

       return new HotelHomePage(driver);

   }

    public SearchHotelResult correctSearch (String destination, String checkIn,String checkOut){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        inputPlace.sendKeys(destination);
        arrivalDateSpan.click();
        this.dateCheckIn = driver.findElement(By.xpath("//td[@data-date = '" + checkIn +"']"));
        this.dateCheckOut = driver.findElement(By.xpath("//td[@data-date = '" + checkOut +"']"));
        dateCheckIn.click();
        dateCheckOut.click();
        searchButton.click();
        return new SearchHotelResult(driver);
    }

    public String searchNotFoundAlertMessage(){
        return alertMessage.getText();
    }

    public HotelHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @Override
    public HotelHomePage openPage()
    {
        driver.get(HOTEL_HOMEPAGE_URL);
        return this;
    }
}
