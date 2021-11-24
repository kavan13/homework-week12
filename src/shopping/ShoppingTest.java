package shopping;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import utility.Utility;

import java.util.Random;

public class ShoppingTest extends Utility {
    String baseurl = "https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }

    @Test
    public void verifyThatUserShouldPlaceOrderSuccessfullyForAvengersFabrikationsPlushRelatedProducts() throws InterruptedException {
        // 1.1 Mouse hover on the “Hot deals” link
        //		1.2 Mouse hover on the “Sale”  link and click
        //		1.3 Verify the text “Sale”
        //		1.4 Mouse hover on “Sort By” and select “Name A-Z”
        mouseHoverToElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[text()='Hot deals']"));
        mouseHoverAndClickToElement(By.linkText("Sale"));

        String expectedMessage = "Sale";
        String actualMessage = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Text verify", expectedMessage, actualMessage);

        Thread.sleep(1000);
        mouseHoverToElement(By.xpath("//span[contains(text(),'Sort by:')]"));
        clickOnElement(By.partialLinkText("Name A -"));

        String expectedMsg = "Name A - Z";
        String actualMsg = getTextFromElement(By.xpath("//span[contains(text(),'Name A - Z')]"));
        Assert.assertEquals("Text verify", expectedMsg, actualMsg);
        //1.5 Click on “Add to cart” button of the product “AvengersFabrikationsPlushRelatedProducts”
        clickOnElement(By.xpath("//button[contains(@class,'regular-button add-to-cart product-add2cart productid-16')]//span[contains(text(),'Add to cart')]"));
        //1.6 Verify the@ message “Product has been added to your cart” display in  green bar
        String expectedMessage1 = "Product has been added to your cart";
        String actualMessage1 = getTextFromElement(By.xpath("//li[contains(text(),'Product has been added to your cart')]"));
        Assert.assertEquals("Text verify", expectedMessage1, actualMessage1);

        //1.7 Click on X sign to close the message
        clickOnElement(By.xpath("//a[@class='close']"));
        //1.8 Click on “Your cart” icon and Click on “View cart” button
        Thread.sleep(1000);
        clickOnElement(By.xpath("//div[@title='Your cart']"));
        clickOnElement(By.xpath("//span[contains(text(),'View cart')]"));

        //  1.9 Verify the text “Your shopping cart - 1 item”
        Thread.sleep(1000);
        String expectedMessage2 = "Your shopping cart - 1 item";
        String actualMessage2 = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Text verify", expectedMessage2, actualMessage2);

        //clv1.10 Change the Qty = 2
        Thread.sleep(1000);
        clearValue(By.xpath("//input[@id='amount16']"));
        sendTextToElement(By.xpath("//input[@id='amount16']"), "2");
        //1.11 Verify the text “Your shopping cart - 2 items”
        Thread.sleep(1000);
        String expectedMessage3 = "Your shopping cart - 2 items";
        String actualMessage3 = getTextFromElement(By.xpath("//h1[text()='Your shopping cart - 2 items']"));
        Assert.assertEquals("Text verify", expectedMessage3, actualMessage3);
        //1.12 Verify the Subtotal $29.98
        String expectedMessage4 = "Subtotal: $29.98";
        String actualMessage4 = getTextFromElement(By.xpath("//ul[@class='sums']//li[@class='subtotal']"));
        Assert.assertEquals("Text verify", expectedMessage4, actualMessage4);

        //1.13 Verify the total $36.00
        String expectedMessage5 = "$36.00";
        String actualMessage5 = getTextFromElement(By.xpath("//li[@class='total']"));
        Assert.assertEquals("Text verify", expectedMessage5, actualMessage5);
        //1.14 Click on “Go to checkout” button
        clickOnElement(By.xpath("//span[contains(text(),'Go to checkout')]"));
        //1.15 Verify the text “Log in to your account”
        String expectedMessage6 = "Log in to your account";
        String actualMessage6 = getTextFromElement(By.xpath("//h3[contains(text(),'Log in to your account')]"));
        Assert.assertEquals("Text verify", expectedMessage6, actualMessage6);
        //1.16 Enter Email address
        Random random = new Random();
        int randomNumber = random.nextInt(1000);
        sendTextToElement(By.xpath("//input[@id='email']"), "abc"+randomNumber+"@gmail.com");
        //1.17 Click on “Continue” Button
        clickOnElement(By.xpath("//*[@class='btn  regular-button anonymous-continue-button submit']"));
        //1.18 Verify the text “Secure Checkout”
        Thread.sleep(1000);
        String expectedMessage7 = "Secure Checkout";
        Thread.sleep(1000);
        String actualMessage7 = getTextFromElement(By.xpath("//h1[@class='title']"));
        Thread.sleep(1000);
        Assert.assertEquals("Text verify", expectedMessage7, actualMessage7);
        //1.19 Fill all the mandatory fields
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='shippingaddress-firstname']"), "Kavan");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='shippingaddress-lastname']"), "Patel");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='shippingaddress-street']"), "12 Road");
        Thread.sleep(1000);
        clearValue(By.xpath("//input[@id='shippingaddress-city']"));
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='shippingaddress-city']"), "London");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//select[@id='shippingaddress-country-code']"), "United kingdom");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='shippingaddress-custom-state']"), "London");
        Thread.sleep(1000);
        clearValue(By.xpath("//input[@id='shippingaddress-zipcode']"));
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='shippingaddress-zipcode']"), "Ha8 9Qe");


        Thread.sleep(1000);
        //1.20 Check the check box “Create an account for later use”
        mouseHoverAndClickToElement(By.xpath("//input[@id='create_profile']"));
        //1.21 Enter the password

        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='password']"),"abcd123#");

        //1.22 Select the Delivery Method to “Local Shipping”Use
        Thread.sleep(2000);
      mouseHoverAndClickToElement(By.xpath("//body/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[2]/ul[1]/li[2]/div[1]"));

        //1.23 Select Payment Method “COD”
        Thread.sleep(2000);
       clickOnElement(By.xpath("//input[@id='pmethod6']"));

        //1.24 Verify the total $47.22
        Thread.sleep(1000);
        String expectedTotal = "$36.00";
        String actualTotal = getTextFromElement(By.xpath("//div[@class='total clearfix']//span[@class='surcharge']"));
        Assert.assertEquals("Price verify", expectedTotal, actualTotal);

        //1.25 Click on “Place Order” Button
       Thread.sleep(2000);
       clickOnElement(By.xpath("//*[@class='btn regular-button regular-main-button place-order submit']"));
      //  mouseHoverAndClickToElement(By.xpath("//button[@class='btn regular-button regular-main-button place-order submit']"));

        // 1.26 Verify the text “Thank you for your order”
        Thread.sleep(1000);
        String expectedMessage8 = "Thank you for your order";
        String actualMessage8 = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Text verify", expectedMessage8, actualMessage8);

    }

    //2 - verifyThatUserShouldClearShoppingCartSuccessfully()
    @Test
    public void verifyThatUserShouldClearShoppingCartSuccessfully() throws InterruptedException {
        //    1.1 Mouse hover on the “Hot deals” link
        mouseHoverToElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"));

        //    1.2 Mouse hover on the “Bestseller”  link and click
        mouseHoverToElement(By.linkText("Bestsellers")).click();

        //1.3 Verify the text “Bestsellers”
        String expectedText = "Bestsellers";
        String actualText = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("User Should no able to mouse hover to sale ", expectedText, actualText);
        Thread.sleep(1000);

        //    1.4 Mouse hover on “Sort By” and select “Name A-Z”
        mouseHoverToElement(By.xpath("//span[contains(text(),'Sort by:')]"));
        clickOnElement(By.partialLinkText("Name A -"));

        //    1.5 Click on “Add to cart” button of the product “Vinyl Idolz: Ghostbusters”
        Thread.sleep(1000);
        mouseHoverToElement(By.xpath("//div[@class='product productid-13 ']"));
        clickOnElement(By.xpath("//div[@class='product productid-13 ']//div[@class='add-to-cart-button']"));

        //1.6 Verify the message “Product has been added to your cart” display in  green bar
        String expectedText1 = "Product has been added to your cart";
        String actualText1 = getTextFromElement(By.xpath("//li[(text()='Product has been added to your cart')]"));
        Assert.assertEquals("Text did not Match", expectedText1, actualText1);

        //1.7 Click on X sign to close the message
        clickOnElement(By.xpath("//a[@class='close']"));

        //1.8 Click on “Your cart” icon and Click on “View cart” button
        Thread.sleep(1000);
        clickOnElement(By.xpath("//div[@class='lc-minicart lc-minicart-horizontal collapsed recently-updated']"));
        clickOnElement(By.xpath("//span[contains(text(),'View cart')]"));

        //1.9 Verify the text “Your shopping cart - 1 item”
        String expectedText2 = "Your shopping cart - 1 item";
        String actualText2 = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Text did not Match", expectedText2, actualText2);

        //1.10 Click on “Empty your cart” link
        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[contains(text(),'Empty your cart')]"));

        //1.11 Verify the text “Are you sure you want to clear your cart?” on alert
        Alert alert = driver.switchTo().alert();
        String expectedAlertMsg = "Are you sure you want to clear your cart?";
        String actualAlertMsg = alert.getText();
        Assert.assertEquals("Message verify",expectedAlertMsg,actualAlertMsg);
        //1.12 Click “Ok” on alert
        Thread.sleep(1000);
        alert.accept();
        //1.13 Verify the message “Item(s) deleted from your cart”
        Thread.sleep(1000);
        String expectedDeleteMsg = "Item(s) deleted from your cart";
        String actualDeleteMsg = getTextFromElement(By.xpath("//li[text()='Item(s) deleted from your cart']"));
        Assert.assertEquals("Message verify",expectedDeleteMsg,actualDeleteMsg);
        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[@class='close']"));
        //1.15 Verify the text “Your cart is empty”
        String expectedMsg1 = "Your cart is empty";
        String actualMsg1 = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Message verify",expectedMsg1,actualMsg1);
    }
    @After
    public void teardown(){
        closeBrowser();
    }
}
