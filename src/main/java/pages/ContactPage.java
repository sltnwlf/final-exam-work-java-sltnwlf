package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage {

    private final WebDriver driver;
    private final By name = By.xpath("//*[@id=\"contact-form\"]/div[1]/div[1]/input");
    private final By email = By.xpath("//*[@id=\"contact-form\"]/div[1]/div[2]/input");
    private final By message = By.xpath("//*[@id=\"message\"]");
    private final By checkbox = By.xpath("//*[@id=\"aggrement\"]");
    private final By send = By.xpath("//*[@id=\"contact-form-button\"]");
    private final By status = By.xpath("//*[@id=\"contact-form-status\"]");

    public ContactPage(WebDriver driver) {
        this.driver = driver;
    }

    /*******************************************************************************************************************
                                          Metódus a name input feltöltésére.
     ******************************************************************************************************************/
    public void fillName(String input) {
        driver.findElement(name).sendKeys(input);
    }

    /*******************************************************************************************************************
                                         Metódus az email input feltöltésére.
     ******************************************************************************************************************/
    public void fillEmail(String input) {
        driver.findElement(email).sendKeys(input);
    }

    /*******************************************************************************************************************
                                         Metódus a message input feltöltésére.
     ******************************************************************************************************************/
    public void fillMessage(String input) {
        driver.findElement(message).sendKeys(input);
    }

    /*******************************************************************************************************************
         Metódus, ami az előzőekben létrehozott metódusok segítségével feltölti az összes inputot a contact oldalon.
     ******************************************************************************************************************/
    public void fillForm(String name, String email, String message) {
        fillName(name);
        fillEmail(email);
        fillMessage(message);
    }

    /*******************************************************************************************************************
                                         Metódus, ami kipipálja checkbox mezőt.
     ******************************************************************************************************************/
    public void clickOnCheckbox() {
        driver.findElement(checkbox).click();
    }

    /*******************************************************************************************************************
                                         Metódus, ami rákattint a küldés gombra.
     ******************************************************************************************************************/
    public void clickOnSend() {
        driver.findElement(send).click();
    }

    /*******************************************************************************************************************
                             Metódus, ami egy WebDriverWait segítségével 2 másodpercig várja,
        hogy megjelenik-e a küldés gombra kattintás utáni üzenet, és az ennek megfelelő boolean értékkel tér vissza.
     ******************************************************************************************************************/
    public boolean isThereStatus() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.visibilityOfElementLocated(status));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

}