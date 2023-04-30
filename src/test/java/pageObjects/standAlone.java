package pageObjects;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testComponents.BaseTest;

import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class standAlone extends BaseTest {

    String productName = "ZARA COAT 3";


    @DataProvider
    public Object[][] getData() throws IOException {
       List<HashMap<String,String>> data =  getJsonDataToMap(System.getProperty("user.dir") + "//src//test//java//dataProvider//PurchaseOrder.json");
        return new Object[][] {{data.get(0)},{data.get(1)}};

    }

    @Test(dataProvider = "getData", groups = {"Purchase"})
    public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException {


        //    Landing_Page landingPage = launchApplication();

        ProductCatalogue productCatalogue = landingPage.portalLogin((String) input.get("Email"),(String) input.get("pwd"));
        List<WebElement> products = productCatalogue.getProductList();

        productCatalogue.addProductToCart(input.get("productName"));
        CartPage cartPage = productCatalogue.goToCartPage();

        Boolean match = cartPage.verifyPageDisplayed(input.get("productName"));
        Assert.assertTrue(match);

        CheckOutPage checkOutPage = cartPage.goToCheckout();
        checkOutPage.selectCountry("India");

        ConfirmationPage confirmationPage = checkOutPage.submitOrder();

        String confirmMessage = confirmationPage.getConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
        Toolkit.getDefaultToolkit().beep();

    }

    @Test(dependsOnMethods = {"submitOrder"})
    public void orderHistory() {
        ProductCatalogue productCatalogue = landingPage.portalLogin("testuser69@gmail.com", "Test2User@");
        OrderPage orderPage= productCatalogue.goToOrderPage();
        String commonProductname=productName.toLowerCase();
        Assert.assertTrue(orderPage.verifyOrderPageIsDisplayed(commonProductname));
    }

//    public String getScreenshot(String testCaseName) throws IOException {
//        TakesScreenshot ts = (TakesScreenshot)driver;
//        File source = ts.getScreenshotAs(OutputType.FILE);
//       File file = new File(System.getProperty("user.dir") + "//reports//" + ".png");
//        FileUtils.copyFile(source,file);
//        return System.getProperty("user.dir") + "//reports//" + ".png";
//    }

 /*@DataProvider
    public Object[][] getData(){

     return new Object[][] {{"testuser69@gmail.com","Test2User@","ZARA COAT 3"},{"testuser69@gmail.com","Test2User@","ADIDAS ORIGINAL"}};
 }*/

}


//        ChromeOptions options = new ChromeOptions();
//     //   options.addArguments("--headless");
//        options.addArguments("--disable-extenisons");
//        options.addArguments("--no-gpu");
//        WebDriver driver =new ChromeDriver(options);
//        driver.get("");
//        driver.quit();


// driver.close();

//       WebDriverManager.chromedriver().setup();

//
//        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
//        Landing_Page landingPage = new Landing_Page(driver);
//        landingPage.goTo("https://rahulshettyacademy.com/client");
// driver.get("https://rahulshettyacademy.com/client");
//        driver.findElement(By.id("userEmail")).sendKeys("testuser69@gmail.com");
//        driver.findElement(By.id("userPassword")).sendKeys("Test2User@");
//        driver.findElement(By.id("login")).click();

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
//        List<WebElement> itemList = driver.findElements(By.cssSelector(".mb-3"));
//
//        WebElement prod = products.stream().filter(item -> item.findElement(By.cssSelector("b")).getText().equals(productName)).
//                findFirst().orElse(null);
//
//        // assert products != null;
//        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

// WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
//
//        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();


//Java Stream
//        List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
//        Boolean match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equals(productName));
//        Assert.assertTrue(match);
//
//        driver.findElement(By.cssSelector(".totalRow button")).click();

//        Actions a = new Actions(driver);
//        a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "India").build().perform();
//
//     //   wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
//
//        Thread.sleep(3000);
// driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btnn"))).click();
//
//
//        String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
//        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
//    @DataProvider
//    public Object[][] getData(){
//        HashMap<String,String> map = new HashMap<String,String>();
//        map.put("Email","testuser69@gmail.com");
//        map.put("pwd","Test2User@");
//        map.put("productName","ZARA COAT 3");
//
//        HashMap<String,String> map1 = new HashMap<String,String>();
//        map1.put("Email","testuser69@gmail.com");
//        map1.put("pwd","Test2User@");
//        map1.put("productName","ADIDAS ORIGINAL");
//
//        return new Object[][] {{map},{map1}};
//
//    }
// driver.quit();