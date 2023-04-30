package pageObjects;

import org.testng.Assert;
import org.testng.annotations.Test;
import testComponents.BaseTest;
import testComponents.retry;

import java.io.IOException;

public class ErrorValidations extends BaseTest {

    @Test(groups = {"Purchase"}, retryAnalyzer = retry.class)
    public void submitOrder() throws IOException, InterruptedException {

        // String productName = "ZARA COAT 3";
        //    Landing_Page landingPage = launchApplication();

        landingPage.portalLogin("testuser69@gmail.com", "TestUser@");
        Assert.assertEquals("Incorrect email or password.", landingPage.gettErrorMessage());

    }
}