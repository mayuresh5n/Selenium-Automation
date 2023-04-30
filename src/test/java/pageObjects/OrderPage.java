package pageObjects;

import abstractComponents.abstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPage extends abstractComponent {

    WebDriver driver;
    @FindBy(css = ".totalRow button")
    WebElement checkoutEle;
    @FindBy(css = "tr td:nth-child(3)")
    private List<WebElement> productNames;

    public OrderPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Boolean verifyOrderPageIsDisplayed(String productName) {

        Boolean match = productNames.stream().anyMatch(cartProduct -> cartProduct.getText().equals(productName));
        return match;
    }

//    public CheckOutPage goToCheckout() {
//        checkoutButton.click();
//        return new CheckOutPage(driver);


}



