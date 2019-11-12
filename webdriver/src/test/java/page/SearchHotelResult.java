package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchHotelResult extends AbstractPage {

    @FindBy(xpath = "//div[@class ='sr-cta-button-row']")
    private WebElement chooseHotelButton;

    public HotelPageInformation checkComment(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        chooseHotelButton.click();
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));
        return new HotelPageInformation(driver);
    }



    protected SearchHotelResult(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    protected SearchHotelResult openPage() {
        return this;
    }
}
