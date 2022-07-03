package requirements;

import base.TestBase;
import base.TestData;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

public class TermsAndConditionsTests extends TestBase {

    /*******************************************************************************************************************
          Teszt, ami elfogadja az adatvédelmi nyilatkozatot, beregisztrál egy felhasználót, be is jelentkezik vele,
                         majd ellenőrzi, hogy az adatvédelmi nyilatkozat ablaka megjelent-e újra.
     ******************************************************************************************************************/
    @RepeatedTest(2)
    @Order(1)
    @Epic("Portio")
    @Story("Terms and conditions tests")
    @DisplayName("TC01, Accept test")
    @Severity(SeverityLevel.CRITICAL)
    public void testTermsAndConditionsAccept(){
        regLog.clickOnTermsAndConditionsAccept();
        regLog.regLog(
                TestData.regLogUsername,
                TestData.regLogPassword,
                TestData.empty,
                TestData.empty,
                TestData.regLogUsername,
                TestData.regLogPassword);
        landing.clickOnLogout();
        boolean actual = regLog.isThereTermsAndConditionsPopup();
        Assertions.assertFalse(actual);
    }

    /*******************************************************************************************************************
              Teszt, ami elfogadás nélkül bezárja az adatvédelmi nyilatkozatot, beregisztrál egy felhasználót,
              be is jelentkezik vele, majd ellenőrzi, hogy az adatvédelmi nyilatkozat ablaka megjelent-e újra.
     ******************************************************************************************************************/
    @RepeatedTest(2)
    @Order(2)
    @Epic("Portio")
    @Story("Terms and conditions tests")
    @DisplayName("TC02, Close test")
    @Severity(SeverityLevel.CRITICAL)
    public void testTermsAndConditionsClose() {
        regLog.clickOnTermsAndConditionsClose();
        regLog.regLog(
                TestData.regLogUsername,
                TestData.regLogPassword,
                TestData.empty,
                TestData.empty,
                TestData.regLogUsername,
                TestData.regLogPassword);
        landing.clickOnLogout();
        boolean actual = regLog.isThereTermsAndConditionsPopup();
        Assertions.assertTrue(actual);
    }

}
