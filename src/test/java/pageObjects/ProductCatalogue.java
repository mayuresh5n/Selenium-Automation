package pageObjects;

import abstractComponents.abstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCatalogue extends abstractComponent {
    WebDriver driver;
    public ProductCatalogue(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy (css=".mb-3")
    List<WebElement> products;
    By productsBy = By.cssSelector(".mb-3");
    By toastMessage = By.cssSelector("#toast-container");


    @FindBy (css=".ng-animating") WebElement spinner;

    public List<WebElement> getProductList(){

        waitForElementToAppear(productsBy);
        return products;
    }

    public WebElement getProductByName(String productName){
        WebElement prod = getProductList().stream().filter(item -> item.findElement(By.cssSelector("b")).getText().equals(productName)).
                findFirst().orElse(null);
        return prod;
    }

    public void addProductToCart(String productName){
        WebElement prod = getProductByName(productName);
        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
        waitForElementToAppear(toastMessage);
        waitForElementToDisappear(spinner);
    }


}
