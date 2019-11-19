package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HotelPageInformation extends AbstractPage {

    @FindBy(xpath = "// sb-destination__input")
    private WebElement destinationOfHotelPage;

    @FindBy(xpath = "//a[@href ='#blockdisplay4']")
    private WebElement allGuestReviews;

    @FindBy(xpath = "//div[@class=' ugc_add_review_entrypoint_simple  ']")
    private WebElement writeReviewButton;

    @FindBy(xpath = "//div[@class='  bui-spacer'")
    private WebElement rateYouStay;

    @FindBy(xpath = "//div[@class=' error-code']")
    private WebElement errorReviewMessage;


    public String getDestinationHotel(){

        return destinationOfHotelPage.getText();

    }

    protected HotelPageInformation(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    protected HotelPageInformation openPage() {
        return this;
    }
}
