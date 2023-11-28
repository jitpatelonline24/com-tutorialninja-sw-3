package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() throws InterruptedException {
// 1.1 Mouse hover on “Desktops” Tab and click
        Thread.sleep(2000);
        mouseHoverOnElement(By.xpath("//a[normalize-space()='Desktops']"));
        Thread.sleep(200);
// 1.2 call selectMenu method and pass the menu = “Show All Desktops”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));
// 1.3 Verify the text ‘Desktops’
        verifyTheStringMessage(By.tagName("h2"), "Desktops");

    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() throws InterruptedException {
    // 2.1 Mouse hover on “Laptops & Notebooks” Tab and click
    Thread.sleep(200);
    mouseHoverOnElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
// 2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
    clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
// 2.3 Verify the text ‘Laptops & Notebooks’
verifyTheStringMessage(By.tagName("h2"), "Laptops & Notebook");

    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() throws InterruptedException {
// 3.1 Mouse hover on “Components” Tab and click
    Thread.sleep(2000);
    mouseHoverOnElement(By.xpath("//a[normalize-space()='Components']"));
// 3.2 call selectMenu method and pass the menu = “Show All Components”
   Thread.sleep(2000);
   clickOnElement(By.xpath("//a[normalize-space()='Show AllComponents']"));
// 3.3 Verify the text ‘Components’
   verifyTheStringMessage(By.tagName("h2"),"Components");

    }

    @After
    public void tearDown() {
           closeBrowser();
    }

}
