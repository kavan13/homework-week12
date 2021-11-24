package hotdeals;

import com.google.common.base.Verify;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Mouse;
import utility.Utility;

public class HotDealsTest extends Utility {
    String baseurl = "https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }

    //	1 - verifySaleProductsArrangeAlphabetically()
    //		1.1 Mouse hover on the “Hot deals” link
    //		1.2 Mouse hover on the “Sale”  link and click
    //		1.3 Verify the text “Sale”
    //		1.4 Mouse hover on “Sort By” and select “Name A-Z”
    //		1.5 Verify that the product arrange alphabetically
    @Test
    public void verifySaleProductsArrangeAlphabetically() throws InterruptedException {

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
    }

    //	2 - verifySaleProductsPriceArrangeLowToHigh()
    @Test
    public void verifySaleProductsPriceArrangeLowToHigh() throws InterruptedException {
        //		2.1 Mouse hover on the “Hot deals” link
        mouseHoverToElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[text()='Hot deals']"));

        //		2.2 Mouse hover on the “Sale”  link and click
        mouseHoverAndClickToElement(By.linkText("Sale"));

        //		2.3 Verify the text “Sale”
        String expectedMessage = "Sale";
        String actualMessage = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Text verify", expectedMessage, actualMessage);

        //		2.4 Mouse hover on “Sort By” and select “Price Low-High”
        Thread.sleep(1000);
        mouseHoverToElement(By.xpath("//span[contains(text(),'Sort by:')]"));
        clickOnElement(By.partialLinkText("Price Low - Hi"));

        //2.5 Verify that the product’s price arrange Low to High
        String expectedMsg = "Price Low - High";
        String actualMsg = getTextFromElement(By.xpath("//span[contains(text(),'Price Low - High')]"));
        Assert.assertEquals("Text verify", expectedMsg, actualMsg);

    }

    //	3 - vefirySalesProductsArrangedByRates()
    @Test
    public void vefirySalesProductsArrangedByRates() throws InterruptedException {
        //3.1 Mouse hover on the “Hot deals” link
        mouseHoverToElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[text()='Hot deals']"));

        //		3.2 Mouse hover on the “Sale”  link and click
        mouseHoverAndClickToElement(By.linkText("Sale"));

        //		3.3 Verify the text “Sale”
        String expectedMessage = "Sale";
        String actualMessage = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Text verify", expectedMessage, actualMessage);

        //		3.4 Mouse hover on “Sort By” and select “Rates”
        Thread.sleep(1000);
        mouseHoverToElement(By.xpath("//span[contains(text(),'Sort by:')]"));
        clickOnElement(By.partialLinkText("Rates"));

        //		3.5 Verify that the product’s arrange Rates
        String expectedMsg = "Rates";
        String actualMsg = getTextFromElement(By.xpath("//span[contains(text(),'Rates')]"));
        Assert.assertEquals("Text verify", expectedMsg, actualMsg);
    }

    //	4 - verifyBestSellersProductsArrangeByZToA()
    @Test
    public void verifyBestSellersProductsArrangeByZToA() throws InterruptedException {

        //		1.1 Mouse hover on the “Hot deals” link
        mouseHoverToElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[text()='Hot deals']"));
        //		1.2 Mouse hover on the “Bestsellers”  link and click
        mouseHoverAndClickToElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[text()='Bestsellers']"));
        //		1.3 Verify the text “Bestsellers”
        String expectedMessage = "Bestsellers";
        String actualMessage = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Text verify", expectedMessage, actualMessage);
        //		1.4 Mouse hover on “Sort By” and select “Name Z-A”
        Thread.sleep(1000);
        mouseHoverToElement(By.xpath("//span[contains(text(),'Sort by:')]"));
        clickOnElement(By.partialLinkText("Name Z -"));

        //		1.5 Verify that the product arrange by Z to A
        String expectedMsg = "Name Z - A";
        String actualMsg = getTextFromElement(By.xpath("//span[contains(text(),'Name Z - A')]"));
        Assert.assertEquals("Text verify", expectedMsg, actualMsg);
    }

    //	5 - verifyBestSellersProductsPriceArrangeHighToLow()
    @Test
    public void verifyBestSellersProductsPriceArrangeHighToLow() throws InterruptedException {
        //		2.1 Mouse hover on the “Hot deals” link
        mouseHoverToElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[text()='Hot deals']"));
        //		2.2 Mouse hover on the “Bestsellers” link and click
        mouseHoverAndClickToElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[text()='Bestsellers']"));
        //		2.3 Verify the text “Bestsellers”
        String expectedMessage = "Bestsellers";
        String actualMessage = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Text verify", expectedMessage, actualMessage);

        //		2.4 Mouse hover on “Sort By” and select “Price High-Low”
        Thread.sleep(1000);
        mouseHoverToElement(By.xpath("//span[contains(text(),'Sort by:')]"));
        clickOnElement(By.partialLinkText("Price High - L"));

        //		2.5 Verify that the product’s price arrange High to Low
        String expectedMsg = "Price High - Low";
        String actualMsg = getTextFromElement(By.xpath("//span[contains(text(),'Price High - Low')]"));
        Assert.assertEquals("Text verify", expectedMsg, actualMsg);
    }

    //	6 - verifyBestSellersProductsArrangeByRates()
    @Test
    public void verifyBestSellersProductsArrangeByRates() throws InterruptedException {
        //		3.1 Mouse hover on the “Hot deals” link
        mouseHoverToElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[text()='Hot deals']"));

        //		3.2 Mouse hover on the “Bestsellers”  link and click
        mouseHoverAndClickToElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[text()='Bestsellers']"));

        //		3.3 Verify the text “Bestsellers”
        String expectedMessage = "Bestsellers";
        String actualMessage = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Text verify", expectedMessage, actualMessage);
        //		3.4 Mouse hover on “Sort By” and select “Rates”
        Thread.sleep(1000);
        mouseHoverToElement(By.xpath("//span[contains(text(),'Sort by:')]"));
        clickOnElement(By.partialLinkText("Rates"));

        //		3.5 Verify that the product’s arrange Rates
        String expectedMsg = "Rates";
        String actualMsg = getTextFromElement(By.xpath("//span[contains(text(),'Rates')]"));
        Assert.assertEquals("Text verify", expectedMsg, actualMsg);

    }


}
