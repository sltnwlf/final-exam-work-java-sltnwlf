package requirements;

import base.TestBase;
import base.TestData;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

public class RegistrationTests extends TestBase {

    /*******************************************************************************************************************
           Teszt, ami elfogadja az adatvédelmi nyilatkozatot, megkísérel beregisztrálni egy felhasználót úgy,
              hogy minden inputmezőt kitölt, majd ellenőrzi, hogy megjelent-e a "User registered!" üzenet.
     ******************************************************************************************************************/
    @RepeatedTest(3)
    @Epic("Portio")
    @Story("Registration tests")
    @DisplayName("TC03, Everything is filled test")
    @Severity(SeverityLevel.CRITICAL)
    public void testRegistrationEverythingIsFilled(){
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registration(
                TestData.regLogUsername,
                TestData.regLogPassword,
                TestData.email,
                TestData.regLogDescription);
        String actual = regLog.getRegisterStatus();
        String expected = "User registered!";
        Assertions.assertEquals(expected, actual);
    }

    /*******************************************************************************************************************
            Teszt, ami elfogadja az adatvédelmi nyilatkozatot, megkísérel beregisztrálni egy felhasználót úgy,
           hogy a leírás inputmezőt üresen hagyja, majd ellenőrzi, hogy megjelent-e a "User registered!" üzenet.
     ******************************************************************************************************************/
    @RepeatedTest(3)
    @Epic("Portio")
    @Story("Registration tests")
    @DisplayName("TC04, Description is empty test")
    @Severity(SeverityLevel.CRITICAL)
    public void testRegistrationDescriptionIsEmpty(){
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registration(
                TestData.regLogUsername,
                TestData.regLogPassword,
                TestData.email,
                TestData.empty);
        String actual = regLog.getRegisterStatus();
        String expected = "User registered!";
        Assertions.assertEquals(expected, actual);
    }

    /*******************************************************************************************************************
            Teszt, ami elfogadja az adatvédelmi nyilatkozatot, megkísérel beregisztrálni egy felhasználót úgy,
      hogy az email és a leírás inputmezőt üresen hagyja, majd ellenőrzi, hogy megjelent-e a "User registered!" üzenet.
     ******************************************************************************************************************/
    @RepeatedTest(3)
    @Epic("Portio")
    @Story("Registration tests")
    @DisplayName("TC05, Email and description are empty test")
    @Severity(SeverityLevel.CRITICAL)
    public void testRegistrationEmailAndDescriptionAreEmpty(){
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registration(
                TestData.regLogUsername,
                TestData.regLogPassword,
                TestData.empty,
                TestData.empty);
        String actual = regLog.getRegisterStatus();
        String expected = "User registered!";
        Assertions.assertEquals(expected, actual);
    }

    /*******************************************************************************************************************
             Teszt, ami elfogadja az adatvédelmi nyilatkozatot, megkísérel beregisztrálni egy felhasználót úgy,
             hogy az email nem tartalmaz kukacot, majd ellenőrzi, hogy megjelent-e a "User registered!" üzenet.
     ******************************************************************************************************************/
    @RepeatedTest(3)
    @Epic("Portio")
    @Story("Registration tests")
    @DisplayName("TC06, Email without at test")
    @Severity(SeverityLevel.CRITICAL)
    public void testRegistrationEmailWithoutAt(){
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registration(
                TestData.regLogUsername,
                TestData.regLogPassword,
                TestData.emailWithoutAt,
                TestData.regLogDescription);
        utils.makeScreenshot();
        boolean actual = regLog.isThereRegisterStatus();
        Assertions.assertFalse(actual);
    }

    /*******************************************************************************************************************
           Teszt, ami elfogadja az adatvédelmi nyilatkozatot, megkísérel beregisztrálni egy felhasználót úgy,
            hogy az email nem tartalmaz pontot, majd ellenőrzi, hogy megjelent-e a "User registered!" üzenet.
     ******************************************************************************************************************/
    @RepeatedTest(3)
    @Epic("Portio")
    @Story("Registration tests")
    @DisplayName("TC07, Email without dot test")
    @Severity(SeverityLevel.CRITICAL)
    public void testRegistrationEmailWithoutDot(){
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registration(
                TestData.regLogUsername,
                TestData.regLogPassword,
                TestData.emailWithoutDot,
                TestData.regLogDescription);
        utils.makeScreenshot();
        boolean actual = regLog.isThereRegisterStatus();
        Assertions.assertFalse(actual);
    }

    /*******************************************************************************************************************
           Teszt, ami elfogadja az adatvédelmi nyilatkozatot, megkísérel beregisztrálni egy felhasználót úgy,
          hogy a jelszó inputmezőt üresen hagyja, majd ellenőrzi, hogy megjelent-e a "User registered!" üzenet.
     ******************************************************************************************************************/
    @RepeatedTest(3)
    @Epic("Portio")
    @Story("Registration tests")
    @DisplayName("TC08, Password is empty test")
    @Severity(SeverityLevel.CRITICAL)
    public void testRegistrationPasswordIsEmpty(){
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registration(
                TestData.regLogUsername,
                TestData.empty,
                TestData.email,
                TestData.regLogDescription);
        utils.makeScreenshot();
        boolean actual = regLog.isThereRegisterStatus();
        Assertions.assertFalse(actual);
    }

    /*******************************************************************************************************************
             Teszt, ami elfogadja az adatvédelmi nyilatkozatot, megkísérel beregisztrálni egy felhasználót úgy,
        hogy a felhasználónév inputmezőt üresen hagyja, majd ellenőrzi, hogy megjelent-e a "User registered!" üzenet.
     ******************************************************************************************************************/
    @RepeatedTest(3)
    @Epic("Portio")
    @Story("Registration tests")
    @DisplayName("TC09, Username is empty test")
    @Severity(SeverityLevel.CRITICAL)
    public void testRegistrationUsernameIsEmpty(){
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registration(
                TestData.empty,
                TestData.regLogPassword,
                TestData.email,
                TestData.regLogDescription);
        utils.makeScreenshot();
        boolean actual = regLog.isThereRegisterStatus();
        Assertions.assertFalse(actual);
    }

    /*******************************************************************************************************************
            Teszt, ami elfogadja az adatvédelmi nyilatkozatot, megkísérel beregisztrálni egy felhasználót úgy,
          hogy az összes inputmezőt üresen hagyja, majd ellenőrzi, hogy megjelent-e a "User registered!" üzenet.
     ******************************************************************************************************************/
    @RepeatedTest(3)
    @Epic("Portio")
    @Story("Registration tests")
    @DisplayName("TC10, Everything is empty test")
    @Severity(SeverityLevel.CRITICAL)
    public void testRegistrationEverythingIsEmpty(){
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registration(
                TestData.empty,
                TestData.empty,
                TestData.empty,
                TestData.empty);
        utils.makeScreenshot();
        boolean actual = regLog.isThereRegisterStatus();
        Assertions.assertFalse(actual);
    }

}
