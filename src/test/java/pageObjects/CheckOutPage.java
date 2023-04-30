package pageObjects;

import abstractComponents.abstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage extends abstractComponent {

    WebDriver driver;
    public CheckOutPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (css="[placeholder='Select Country']")
    WebElement country;

    @FindBy (xpath="(//button[contains(@class,'ta-item')])[2]")
    WebElement selectCountry;

    @FindBy (css=".btnn")
    WebElement submit;



    public void selectCountry(String countryName) throws InterruptedException {
        Actions a = new Actions(driver);
        a.sendKeys(country, countryName).build().perform();
        Thread.sleep(2000);
        selectCountry.click();
    }

    public ConfirmationPage submitOrder(){
        submit.click();
        return new ConfirmationPage(driver);
    }





    //   wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
}
