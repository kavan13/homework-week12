package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utility;

public class TopMenuTest extends Utility {
    String baseurl = "https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }
    @Test
    //1 - verifyUserShouldNavigateToShippingPageSuccessfully()
    //		1.1 Click on the “Shipping” link
    //		1.2 Verify the text “Shipping”
    public void verifyUserShouldNavigateToShippingPageSuccessfully() {
        clickOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//li[@class='leaf']//a[@href='shipping.html']//span[contains(text(),'Shipping')]"));

        String expectedMessage = "Shipping";
        String actualMessage = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Text verify", expectedMessage, actualMessage);
    }

        //2 - verifyUserShouldNavigateToNewPageSuccessfully()
        //		2.1 Click on the “New!” link
        //		2.2 Verify the text “New arrivals”
        @Test
        public void verifyUserShouldNavigateToNewPageSuccessfully(){
            clickOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[contains(text(),'New!')]"));
            String expectedMessage = "New arrivals";
            String actualMessage = getTextFromElement(By.xpath("//h1[@id='page-title']"));
            Assert.assertEquals("Text verify",expectedMessage,actualMessage);
        }
        //	3 - verifyUserShouldNavigateToComingsoonPageSuccessfully()
        //		3.1 Click on the “Coming soon” link
        //		3.2 Verify the text “Coming soon”
        @Test
        public void verifyUserShouldNavigateToComingsoonPageSuccessfully(){
            clickOnElement(By.linkText("Coming soon"));
            String expectedMessage = "Coming soon";
            String actualMessage = getTextFromElement(By.xpath("//h1[@id='page-title']"));
            Assert.assertEquals("Text verify",actualMessage,expectedMessage);
        }
        //	4 - verifyUserShouldNavigateToContactUsPageSuccessfully()
        //		4.1 Click on the “Contact us” link
        //		4.2 Verify the text “Contact us”
        @Test
        public void  verifyUserShouldNavigateToContactUsPageSuccessfully(){
            clickOnElement(By.linkText("Contact us"));
            String expectedMessage = "Contact us";
            String actualMessage = getTextFromElement(By.xpath("//h1[@id='page-title']"));
            Assert.assertEquals("Text verify",actualMessage,expectedMessage);
        }
    @After
    public void teardown(){
        closeBrowser();
    }
    }





