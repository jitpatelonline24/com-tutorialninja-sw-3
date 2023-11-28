package laptopandnotebooks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.Utility;

import java.util.Random;

public class LaptopAndNotebooksTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException {

//        1.1 Mouse hover on Laptops & Notebooks Tab.and click
Thread.sleep(2000);
mouseHoverAndClick(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
//        1.2 Click on “Show All Laptops & Notebooks”
clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
//        1.3 Select Sort By "Price (High > Low)"
selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low");
//        1.4 Verify the Product price will arrange in High to Low order.
verifyTheListIsAscedingOrder(By.xpath("//p[@class = 'price']"));
    }
    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
// Currency changed to Pound££££ and click
        Thread.sleep(2000);
        mouseHoverAndClick(By.xpath("//span[normalize-space()='Currency']"));
        mouseHoverAndClick(By.xpath("//button[normalize-space()='£Pound Sterling']"));
//        2.1 Mouse hover on Laptops & Notebooks Tab and click
Thread.sleep(2000);
mouseHoverAndClick(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
//        2.2 Click on “Show All Laptops & Notebooks”
clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
//        2.3 Select Sort By "Price (High > Low)"
selectByVisibleTextFromDropdown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");
//        2.4 Select Product “MacBook”
clickOnElement(By.xpath("//a[normalize-space()='MacBook']"));
//        2.5 Verify the text “MacBook”
verifyTheStringMessage(By.xpath("//h1[normalize-space()='MacBook']"),"MacBook");
//        2.6 Click on ‘Add To Cart’ button
clickOnElement(By.xpath("//button[@id='button-cart']"));
//        2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
verifyTheStringMessage(By.xpath("//div[@class='alert alert-success alert-dismissible']"),"Success: You have added MacBook to your shopping cart!");
//        2.8 Click on link “shopping cart” display into success message
clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
//        2.9 Verify the text "Shopping Cart"
        verifyTheStringMessage(By.xpath("//h1[contains(text(),'Shopping Cart')]"), "Shopping Cart");
//        2.10 Verify the Product name "MacBook"
verifyTheStringMessage(By.xpath("//div[@class = 'table-responsive']/table[1]/tbody[1]/tr[1]/td[2]/a[1]"),"MacBook");
//        2.11 Change Quantity "2"
String string = Keys.CONTROL + "a";
sendTextToElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"),string);
sendTextToElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"),"2");
//        2.12 Click on “Update” Tab
clickOnElement(By.xpath("(//button[@type='submit'])[1]"));
//        2.13 Verify the message “Success: You have modified your shopping cart!”
verifyTheStringMessage(By.xpath("//div[@class='alert alert-success alert-dismissible']"),"Success: You have modified your shopping cart!");
//        2.14 Verify the Total £737.45
verifyTheStringMessage(By.xpath("//div[@class = 'table-responsive']/table[1]/tbody[1]/tr[1]/td[6]"),"£737.45");
//        2.15 Click on “Checkout” button
clickOnElement(By.xpath("//a[@class='btn btn-primary']"));
//        2.16 Verify the text “Checkout”
verifyTheStringMessage(By.xpath("//h1[normalize-space()='Checkout']"),"Checkout");
//        2.17 Verify the Text “New Customer”
verifyTheStringMessage(By.xpath("//h2[normalize-space()='New Customer']"),"New Customer");
//        2.18 Click on “Guest Checkout” radio button
clickOnElement(By.xpath("//input[@value='guest']"));
//        2.19 Click on “Continue” tab
clickOnElement(By.xpath("//input[@id='button-account']"));
//        2.20 Fill the mandatory fields
sendTextToElement(By.name("firstname"),"Abcd");
sendTextToElement(By.name("lastname"),"xyz");
Random random = new Random();
random.nextInt(1000);
sendTextToElement(By.id("input-payment-email"),"test"+random+"gmail.com");
sendTextToElement(By.name("telephone"),"07711122532");
sendTextToElement(By.name("address_1"),"122, Def st. ");
sendTextToElement(By.name("city"),"London");
sendTextToElement(By.name("postcode"), "HA1 1AB");
selectByVisibleTextFromDropDown(By.name("country_id"), "United Kingdom");
sendTextToElement(By.name("zone_id"),"Devon");
//        2.21 Click on “Continue” Button
clickOnElement(By.xpath("//input[@id='button-guest']"));
//        2.22 Add Comments About your order into text area
sendTextToElement(By.xpath("//textarea[@name='comment']"),"The product is Good.");
//        2.23 Check the Terms & Conditions check box
clickOnElement(By.xpath("//input[@name='agree']"));
//        2.24 Click on “Continue” button
clickOnElement(By.xpath("//input[@id='button-payment-method']"));
//        2.25 Verify the message “Warning: Payment method required!”
        verifyTheStringMessage(By.xpath("//div[@class='alert alert-danger alert-dismissible']"), "Warning: Payment method required!");
}
@After
public void tearDown(){
    closeBrowser();
        }
    }
