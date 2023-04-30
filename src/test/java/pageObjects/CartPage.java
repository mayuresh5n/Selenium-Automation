package pageObjects;

import abstractComponents.abstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends abstractComponent {
    WebDriver driver;
    @FindBy(css = ".cartSection h3")
    List<WebElement> cartProducts;
    @FindBy(css = ".totalRow button")
    WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Boolean verifyPageDisplayed(String productName) {

        Boolean match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equals(productName));
        return match;
    }

    public CheckOutPage goToCheckout() {
        checkoutButton.click();
        return new CheckOutPage(driver);

    }


}
