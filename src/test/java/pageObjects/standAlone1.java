package pageObjects;

public class standAlone1 {
    public static void main(String[] args) throws InterruptedException {
    }
    }

     /*   WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/client");

        //Variables
        String productName = "ZARA COAT 3";

        driver.findElement(By.id("userEmail")).sendKeys("testuser69@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Test2User@");
        driver.findElement(By.id("login")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
        List<WebElement> itemList = driver.findElements(By.cssSelector(".mb-3"));

        WebElement products = itemList.stream().filter(item -> item.findElement(By.cssSelector("b")).getText().equals(productName)).
                findFirst().orElse(null);

        // assert products != null;
        products.findElement(By.cssSelector(".card-body button:last-of-type")).click();

        // WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));

        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

        //Java Stream
        List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
        Boolean match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equals(productName));
        Assert.assertTrue(match);

        driver.findElement(By.cssSelector(".totalRow button")).click();

        Actions a = new Actions(driver);
        a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "India").build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));

        Thread.sleep(3000);
        driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btnn"))).click();


    //    String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
   //     Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

        driver.quit();

    }
}


//        ChromeOptions options = new ChromeOptions();
//     //   options.addArguments("--headless");
//        options.addArguments("--disable-extenisons");
//        options.addArguments("--no-gpu");
//        WebDriver driver =new ChromeDriver(options);
//        driver.get("");
//        driver.quit();
*/
