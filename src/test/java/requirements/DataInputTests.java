package requirements;

import base.TestBase;
import base.TestData;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

public class DataInputTests extends TestBase {

    /*******************************************************************************************************************
         Teszt, ami elfogadja az adatvédelmi nyilatkozatot, beregisztrál egy felhasználót, be is jelentkezik vele,
            rákattint a Get in touch gombra, kitölti a formot úgy, hogy minden inptumezőt kitölt a jó adatokkal,
                           rákattint a checkboxra, és az üzenet küldésére is majd ellenőrzi,
                              hogy megjelent-e az üzenet elküldésével kapcsolatos üzenet.
     ******************************************************************************************************************/
    @RepeatedTest(3)
    @Epic("Portio")
    @Story("Data input tests")
    @DisplayName("TC19, Everything is filled test")
    @Severity(SeverityLevel.CRITICAL)
    public void testDataInputEverythingIsFilled() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.regLog(
                TestData.regLogUsername,
                TestData.regLogPassword,
                TestData.email,
                TestData.regLogDescription,
                TestData.regLogUsername,
                TestData.regLogPassword);
        landing.clickOnGetInTouch();
        contact.fillForm(
                TestData.contactName,
                TestData.email,
                TestData.contactMessage);
        contact.clickOnCheckbox();
        contact.clickOnSend();
        boolean actual = contact.isThereStatus();
        Assertions.assertTrue(actual);
    }

    /*******************************************************************************************************************
          Teszt, ami elfogadja az adatvédelmi nyilatkozatot, beregisztrál egy felhasználót, be is jelentkezik vele,
               rákattint a Get in touch gombra, kitölti a formot úgy, hogy az üzenet inptumezőt üresen hagyja,
                            rákattint a checkboxra, és az üzenet küldésére is majd ellenőrzi,
                              hogy megjelent-e az üzenet elküldésével kapcsolatos üzenet.
     ******************************************************************************************************************/
    @RepeatedTest(3)
    @Epic("Portio")
    @Story("Data input tests")
    @DisplayName("TC20, Message is empty test")
    @Severity(SeverityLevel.CRITICAL)
    public void testDataInputMessageIsEmpty() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.regLog(
                TestData.regLogUsername,
                TestData.regLogPassword,
                TestData.email,
                TestData.regLogDescription,
                TestData.regLogUsername,
                TestData.regLogPassword);
        landing.clickOnGetInTouch();
        contact.fillForm(
                TestData.contactName,
                TestData.email,
                TestData.empty);
        contact.clickOnCheckbox();
        contact.clickOnSend();
        boolean actual = contact.isThereStatus();
        Assertions.assertTrue(actual);
    }

    /*******************************************************************************************************************
          Teszt, ami elfogadja az adatvédelmi nyilatkozatot, beregisztrál egy felhasználót, be is jelentkezik vele,
                      rákattint a Get in touch gombra, kitölti a formot,de checkboxra nem kattint rá,
                             rákattint a checkboxra, és az üzenet küldésére is majd ellenőrzi,
                                hogy megjelent-e az üzenet elküldésével kapcsolatos üzenet.
     ******************************************************************************************************************/
    @RepeatedTest(3)
    @Epic("Portio")
    @Story("Data input tests")
    @DisplayName("TC21, Checkbox is empty test")
    @Severity(SeverityLevel.CRITICAL)
    public void testDataInputCheckboxIsEmpty() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.regLog(
                TestData.regLogUsername,
                TestData.regLogPassword,
                TestData.email,
                TestData.regLogDescription,
                TestData.regLogUsername,
                TestData.regLogPassword);
        landing.clickOnGetInTouch();
        contact.fillForm(
                TestData.contactName,
                TestData.email,
                TestData.contactMessage);
        contact.clickOnSend();
        boolean actual = contact.isThereStatus();
        Assertions.assertFalse(actual);
    }

    /*******************************************************************************************************************
         Teszt, ami elfogadja az adatvédelmi nyilatkozatot, beregisztrál egy felhasználót, be is jelentkezik vele,
              rákattint a Get in touch gombra, kitölti a formot úgy, hogy az email inptumezőt üresen hagyja,
                           rákattint a checkboxra, és az üzenet küldésére is majd ellenőrzi,
                              hogy megjelent-e az üzenet elküldésével kapcsolatos üzenet.
     ******************************************************************************************************************/
    @RepeatedTest(3)
    @Epic("Portio")
    @Story("Data input tests")
    @DisplayName("TC22, Email is empty test")
    @Severity(SeverityLevel.CRITICAL)
    public void testDataInputEmailIsEmpty() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.regLog(
                TestData.regLogUsername,
                TestData.regLogPassword,
                TestData.email,
                TestData.regLogDescription,
                TestData.regLogUsername,
                TestData.regLogPassword);
        landing.clickOnGetInTouch();
        contact.fillForm(
                TestData.contactName,
                TestData.empty,
                TestData.contactMessage);
        contact.clickOnCheckbox();
        contact.clickOnSend();
        boolean actual = contact.isThereStatus();
        Assertions.assertFalse(actual);
    }

    /*******************************************************************************************************************
          Teszt, ami elfogadja az adatvédelmi nyilatkozatot, beregisztrál egy felhasználót, be is jelentkezik vele,
                  rákattint a Get in touch gombra, kitölti a formot úgy, hogy az email-ben nincs kukac,
                           rákattint a checkboxra, és az üzenet küldésére is majd ellenőrzi,
                              hogy megjelent-e az üzenet elküldésével kapcsolatos üzenet.
     ******************************************************************************************************************/
    @RepeatedTest(3)
    @Epic("Portio")
    @Story("Data input tests")
    @DisplayName("TC23, Email without at test")
    @Severity(SeverityLevel.CRITICAL)
    public void testDataInputEmailWithoutAt(){
        regLog.clickOnTermsAndConditionsAccept();
        regLog.regLog(
                TestData.regLogUsername,
                TestData.regLogPassword,
                TestData.email,
                TestData.regLogDescription,
                TestData.regLogUsername,
                TestData.regLogPassword);
        landing.clickOnGetInTouch();
        contact.fillForm(
                TestData.contactName,
                TestData.emailWithoutAt,
                TestData.contactMessage);
        contact.clickOnCheckbox();
        contact.clickOnSend();
        boolean actual = contact.isThereStatus();
        Assertions.assertFalse(actual);
    }

    /*******************************************************************************************************************
         Teszt, ami elfogadja az adatvédelmi nyilatkozatot, beregisztrál egy felhasználót, be is jelentkezik vele,
               rákattint a Get in touch gombra, kitölti a formot úgy, hogy az email kukac után nincs semmi,
                           rákattint a checkboxra, és az üzenet küldésére is majd ellenőrzi,
                              hogy megjelent-e az üzenet elküldésével kapcsolatos üzenet.
     ******************************************************************************************************************/
    @RepeatedTest(3)
    @Epic("Portio")
    @Story("Data input tests")
    @DisplayName("TC24, Email, nothing after at test")
    @Severity(SeverityLevel.CRITICAL)
    public void testDataInputEmailNothingAfterAt() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.regLog(
                TestData.regLogUsername,
                TestData.regLogPassword,
                TestData.email,
                TestData.regLogDescription,
                TestData.regLogUsername,
                TestData.regLogPassword);
        landing.clickOnGetInTouch();
        contact.fillForm(
                TestData.contactName,
                TestData.emailNothingAfterAt,
                TestData.contactMessage);
        contact.clickOnCheckbox();
        contact.clickOnSend();
        boolean actual = contact.isThereStatus();
        Assertions.assertFalse(actual);
    }

    /*******************************************************************************************************************
         Teszt, ami elfogadja az adatvédelmi nyilatkozatot, beregisztrál egy felhasználót, be is jelentkezik vele,
               rákattint a Get in touch gombra, kitölti a formot úgy, hogy az email kukac előtt nincs semmi,
                           rákattint a checkboxra, és az üzenet küldésére is majd ellenőrzi,
        hogy megjelent-e az üzenet elküldésével kapcsolatos üzenet. Manuális tesztelés esetén volt csak kimuatható,
                              hogy, azon kívül, hogy helyesen nem küldené el az üzenetet,
                              a figyelmeztető üzenet az input mezőnél eltér az elvárttól.
     ******************************************************************************************************************/
    @RepeatedTest(3)
    @Epic("Portio")
    @Story("Data input tests")
    @DisplayName("TC25, Email, nothing before at test")
    @Severity(SeverityLevel.CRITICAL)
    public void testDataInputEmailNothingBeforeAt() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.regLog(
                TestData.regLogUsername,
                TestData.regLogPassword,
                TestData.email,
                TestData.regLogDescription,
                TestData.regLogUsername,
                TestData.regLogPassword);
        landing.clickOnGetInTouch();
        contact.fillForm(
                TestData.contactName,
                TestData.emailNothingBeforeAt,
                TestData.contactMessage);
        contact.clickOnCheckbox();
        contact.clickOnSend();
        boolean actual = contact.isThereStatus();
        Assertions.assertFalse(actual);
    }

    /*******************************************************************************************************************
          Teszt, ami elfogadja az adatvédelmi nyilatkozatot, beregisztrál egy felhasználót, be is jelentkezik vele,
                 rákattint a Get in touch gombra, kitölti a formot úgy, hogy az email nem tartalmaz pontot,
                             rákattint a checkboxra, és az üzenet küldésére is majd ellenőrzi,
                                hogy megjelent-e az üzenet elküldésével kapcsolatos üzenet.
     ******************************************************************************************************************/
    @RepeatedTest(3)
    @Epic("Portio")
    @Story("Data input tests")
    @DisplayName("TC26, Email without dot test")
    @Severity(SeverityLevel.CRITICAL)
    public void testDataInputEmailWithoutDot() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.regLog(
                TestData.regLogUsername,
                TestData.regLogPassword,
                TestData.email,
                TestData.regLogDescription,
                TestData.regLogUsername,
                TestData.regLogPassword);
        landing.clickOnGetInTouch();
        contact.fillForm(
                TestData.contactName,
                TestData.emailWithoutDot,
                TestData.contactMessage);
        contact.clickOnCheckbox();
        contact.clickOnSend();
        utils.scrollOnPage(200);
        utils.implicitlyWait(3);
        utils.makeScreenshot();
        boolean actual = contact.isThereStatus();
        Assertions.assertFalse(actual);
    }

    /*******************************************************************************************************************
          Teszt, ami elfogadja az adatvédelmi nyilatkozatot, beregisztrál egy felhasználót, be is jelentkezik vele,
                 rákattint a Get in touch gombra, kitölti a formot úgy, hogy az név inptumezőt üresen hagyja,
                             rákattint a checkboxra, és az üzenet küldésére is majd ellenőrzi,
                                hogy megjelent-e az üzenet elküldésével kapcsolatos üzenet.
     ******************************************************************************************************************/
    @RepeatedTest(3)
    @Epic("Portio")
    @Story("Data input tests")
    @DisplayName("TC27, Name is empty test")
    @Severity(SeverityLevel.CRITICAL)
    public void testDataInputNameEmpty() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.regLog(
                TestData.regLogUsername,
                TestData.regLogPassword,
                TestData.email,
                TestData.regLogDescription,
                TestData.regLogUsername,
                TestData.regLogPassword);
        landing.clickOnGetInTouch();
        contact.fillForm(
                TestData.empty,
                TestData.email,
                TestData.contactMessage);
        contact.clickOnCheckbox();
        contact.clickOnSend();
        boolean actual = contact.isThereStatus();
        Assertions.assertFalse(actual);
    }

}

