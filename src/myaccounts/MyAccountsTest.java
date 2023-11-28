package myaccounts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

import java.util.Random;

public class MyAccountsTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMyAccountOptions(String option) {
        clickOnElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='"+option+"']"));
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() throws InterruptedException {

// 1.1 Click on My Account Link.
clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
// 1.2 Call the method “selectMyAccountOptions” method and pass the parameter“Register”
        Thread.sleep(2000);
        selectMyAccountOptions("Register");
// 1.3 Verify the text “Register Account”.
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='Register Account']"),"Register Account");
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() throws InterruptedException {

//      2.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
//      2.2 Call the method “selectMyAccountOptions”method and pass the parameter“Login”
        Thread.sleep(2000);
        selectMyAccountOptions("Login");
//      2.3 Verify the text “Returning Customer”.
        verifyTheStringMessage(By.xpath("//h2[normalize-space()='Returning Customer']"), "Returning Customer");
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {


//3.1 Clickr on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
//3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");
//3.3 Enter First Name
        sendTextToElement(By.name("firstname"), "Abcd");
//3.4 Enter Last Name
        sendTextToElement(By.name("lastname"), "Xyz");
//3.5 Enter Email
        Random random = new Random(1000);
        sendTextToElement(By.id("input-email"), "test"+random.nextInt()+"@gmail.com");
//3.6 Enter Telephone
        sendTextToElement(By.name("telephone"), "07411185254");
//3.7 Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"), "abcd123");
//3.8 Enter Password Confirm
        sendTextToElement(By.xpath("//input[@id='input-confirm']"), "abcd123");
//3.9 Select Subscribe Yes radio button
        clickOnElement(By.xpath("//label[normalize-space()='Yes']"));
//        3.10 Click on Privacy Policy check box
        clickOnElement(By.xpath("//input[@name='agree']"));
//        3.11 Click on Continue button
        clickOnElement(By.xpath("//input[@value='Continue']"));
//        3.12 Verify the message “Your Account Has Been Created!”
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"), "Your Account Has Been Created!");
//        3.13 Click on Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
//        3.14 Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
//        3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");
//        3.16 Verify the text “Account Logout”
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='Account Logout']"), "Account Logout");
//        3.17 Click on Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {

//    4.1 Clickr on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
//        4.2 Call the method “selectMyAccountOptions” method and pass the parameter ““Login””
        Thread.sleep(200);
        selectMyAccountOptions("Login");
//        4.3 Enter Email address
        sendTextToElement(By.xpath("//input[@id='input-email']"), "abcdxyz123@gmail.com");
//        4.4 Enter Last Name (This option is not there in the form)
//        4.5 Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"), "abcd@123");
//        4.6 Click on Login button
        clickOnElement(By.xpath("//input[@value='Login']"));
//        4.7 Verify text “My Account”
        verifyTheStringMessage(By.xpath("//h2[normalize-space()='My Account']"), "My Account");
//        4.8 Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
//        4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        Thread.sleep(200);
        selectMyAccountOptions("Logout");
//        4.10 Verify the text “Account Logout”
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='Account Logout']"), "Account Logout");
//        4.11 Click on Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
