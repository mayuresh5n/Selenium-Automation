package pageObjects;

import abstractComponents.abstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Landing_Page extends abstractComponent {

    WebDriver driver;
    @FindBy(id = "userEmail")
    WebElement UserEmail;
    @FindBy(id = "userPassword")
    WebElement Password;
    @FindBy(id = "login")
    WebElement LoginButton;
    @FindBy(css = "[class*='flyInOut']")
    WebElement errorMessage;

    public Landing_Page(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ProductCatalogue portalLogin(String Email, String Pwd) {
        UserEmail.sendKeys(Email);
        Password.sendKeys(Pwd);
        LoginButton.click();
        return new ProductCatalogue(driver);
    }

    public String gettErrorMessage() throws InterruptedException {
        Thread.sleep(20);
//         waitForWebElementToAppear(errorMessage);
        return errorMessage.getText();
    }

    public ProductCatalogue goTo(String Url) {
        driver.get(Url);
        return new ProductCatalogue(driver);
    }

}