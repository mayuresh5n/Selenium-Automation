package pageObjects;

import abstractComponents.abstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage extends abstractComponent {

    WebDriver driver;

    public ConfirmationPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (css=".hero-primary")
    WebElement confirmationText;

    public String getConfirmationMessage(){
        return confirmationText.getText();
       // Assert.assertTrue(confirmMessage.equalsIgnoreCase(thankYouMessage));
    }
}
