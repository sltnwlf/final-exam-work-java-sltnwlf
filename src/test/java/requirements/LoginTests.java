package requirements;

import base.TestBase;
import base.TestData;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginTests extends TestBase {

    /*******************************************************************************************************************
                   Teszt, ami elfogadja az adatvédelmi nyilatkozatot, beregisztrál egy felhasználót úgy,
                  hogy minden inputmezőt kitölt, majd be is jelentkezik ezekkel az adatokkal és ellenőrzi,
                                          hogy a bejelentkező ablak eltűnt-e.
     ******************************************************************************************************************/
    @Test
    @Epic("Portio")
    @Story("Login tests")
    @DisplayName("TC11, Everything is filled test")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginEverythingIsFilled() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.regLog(
                TestData.regLogUsername,
                TestData.regLogPassword,
                TestData.email,
                TestData.regLogDescription,
                TestData.regLogUsername,
                TestData.regLogPassword);
        boolean actual = regLog.isThereRegLogForm();
        Assertions.assertFalse(actual);
    }

    /*******************************************************************************************************************
                    Teszt, ami elfogadja az adatvédelmi nyilatkozatot, beregisztrál egy felhasználót úgy,
                                hogy a felhasználónév inputmezőt üresen hagyja, majd ellenőrzi,
                            hogy a bejelentkező ablak az elvártaknak megfelelően a helyén marad-e.
     ******************************************************************************************************************/
    @Test
    @Epic("Portio")
    @Story("Login tests")
    @DisplayName("TC12, Username is empty test")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginUsernameIsEmpty() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.regLog(
                TestData.regLogUsername,
                TestData.regLogPassword,
                TestData.email,
                TestData.regLogDescription,
                TestData.empty,
                TestData.regLogPassword);
        boolean actual = regLog.isThereRegLogForm();
        Assertions.assertTrue(actual);
    }

    /*******************************************************************************************************************
                   Teszt, ami elfogadja az adatvédelmi nyilatkozatot, beregisztrál egy felhasználót úgy,
                                hogy a jelszó inputmezőt üresen hagyja, majd ellenőrzi,
                        hogy a bejelentkező ablak az elvártaknak megfelelően a helyén marad-e.
     ******************************************************************************************************************/
    @Test
    @Epic("Portio")
    @Story("Login tests")
    @DisplayName("TC13, Password is empty test")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginPasswordIsEmpty() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.regLog(
                TestData.regLogUsername,
                TestData.regLogPassword,
                TestData.email,
                TestData.regLogDescription,
                TestData.regLogUsername,
                TestData.empty);
        boolean actual = regLog.isThereRegLogForm();
        Assertions.assertTrue(actual);
    }

    /*******************************************************************************************************************
                   Teszt, ami elfogadja az adatvédelmi nyilatkozatot, beregisztrál egy felhasználót úgy,
                    hogy a jelszó inputmezőt üresen hagyja, majd megkísérel bejelentkezni és ellenőrzi,
                                     hogy a bejelentkező ablak a helyén marad-e.
     ******************************************************************************************************************/
    @Test
    @Epic("Portio")
    @Story("Login tests")
    @DisplayName("TC14, Password is unregistered test")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginPasswordIsUnregistered() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.regLog(
                TestData.regLogUsername,
                TestData.empty,
                TestData.email,
                TestData.regLogDescription,
                TestData.regLogUsername,
                TestData.regLogPassword);
        boolean actual = regLog.isThereRegLogForm();
        Assertions.assertTrue(actual);
    }

    /*******************************************************************************************************************
               Teszt, ami elfogadja az adatvédelmi nyilatkozatot, beregisztrál egy felhasználót úgy,
             hogy a felhasználónév inputmezőt üresen hagyja, majd megkísérel bejelentkezni és ellenőrzi,
                                  hogy a bejelentkező ablak a helyén marad-e.
     ******************************************************************************************************************/
    @Test
    @Epic("Portio")
    @Story("Login tests")
    @DisplayName("TC15, Username is unregistered test")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginUsernameIsUnregistered() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.regLog(
                TestData.empty,
                TestData.regLogPassword,
                TestData.email,
                TestData.regLogDescription,
                TestData.regLogUsername,
                TestData.regLogPassword);
        boolean actual = regLog.isThereRegLogForm();
        Assertions.assertTrue(actual);
    }

}