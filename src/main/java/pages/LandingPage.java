package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Utils;

public class LandingPage {

    private final WebDriver driver;
    private final By seeAllPost = By.xpath("//*[@id=\"blog\"]/div[2]/div[1]/div[2]/div/a");
    private final By logout = By.id("logout-link");
    private final By getInTouch = By.xpath("//*[@id=\"contact\"]/div[2]/div[1]/div/div/div[4]/a");
    private final By profile = By.id("profile-btn");

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    /*******************************************************************************************************************
                                       Metódus, ami rákattint a profile gombra.
     ******************************************************************************************************************/
    public void clickOnProfile() {
        driver.findElement(profile).click();
    }

    /*******************************************************************************************************************
                                       Metódus, ami rákattint a logout gombra.
     ******************************************************************************************************************/
    public void clickOnLogout() {
        driver.findElement(logout).click();
    }

    /*******************************************************************************************************************
                          Metódus, ami odagörget a "Get in touch" gombhoz és is rákattint.
     ******************************************************************************************************************/
    public void clickOnGetInTouch() {
        Utils u = new Utils(driver);
        u.scrollToElement(getInTouch);
        driver.findElement(getInTouch).click();
    }

    /*******************************************************************************************************************
                      Egyszerű metódus, ami odagörget a "See all post" gombhoz és is rákattint.
     ******************************************************************************************************************/
    public void clickOnSeeAllPost() {
        Utils u = new Utils(driver);
        u.scrollToElement(seeAllPost);
        driver.findElement(seeAllPost).click();
    }

}