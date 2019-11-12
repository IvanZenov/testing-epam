package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HotelPageInformation extends AbstractPage {

    @FindBy(xpath = "//a[@href ='#blockdisplay4']")
    private WebElement allGuestReviews;

    @FindBy(xpath = "//div[@class='ugc_add_review_entrypoint_wrap ugc_add_review_entrypoint_simple  ']")
    private WebElement writeReviewButton;

    @FindBy(xpath = "//div[@class='bui_form__group entrypoint_form_button bui-spacer--larger  bui-spacer'")
    private WebElement rateYouStay;

    @FindBy(xpath = "//div[@class='bui-alert bui-alert--error bui-u-bleed@small validation-error-message error-code']")
    private WebElement errorReviewMessage;


    public String errorReviewMessage(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        allGuestReviews.click();
        writeReviewButton.click();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        rateYouStay.click();
        return errorReviewMessage.getText();

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
