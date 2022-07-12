package requirements;

import base.TestBase;
import base.TestData;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

public class LogoutTests extends TestBase {

    /*******************************************************************************************************************
         Teszt, ami elfogadja az adatvédelmi nyilatkozatot, beregisztrál egy felhasználót, be is jelentkezik vele,
        ráklikkel a kijelentkezés gombra, ellenőrzi, hogy újra megejelent-e a bejelentkező ablak, nyit egy új tabot,
       ismét bejelentkezik az előzőleg beregisztrált felhasználóval, majd újra rányom a kijelentkezésre és ellenőrzi,
                                       hogy a bejelentkező ablak újra megjelent-e.
     ******************************************************************************************************************/
    @RepeatedTest(3)
    @Epic("Portio")
    @Story("Logout tests")
    @DisplayName("TC16, Double logout on different tabs with logout button test")
    @Severity(SeverityLevel.CRITICAL)
    public void testDoubleLogoutOnDifferentTabsWithLogoutButton() throws InterruptedException {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.regLog(
                TestData.regLogUsername,
                TestData.regLogPassword,
                TestData.email,
                TestData.regLogDescription,
                TestData.regLogUsername,
                TestData.regLogPassword);
        landing.clickOnLogout();
        boolean actualFirstTab = regLog.isThereRegLogForm();
        utils.createNewTab();
        utils.navigateToPortio();
        regLog.login(
                TestData.regLogUsername,
                TestData.regLogPassword);
        utils.sleep(2000);
        landing.clickOnLogout();
        boolean actualSecondTab = regLog.isThereRegLogForm();
        Assertions.assertTrue(actualFirstTab);
        Assertions.assertTrue(actualSecondTab);
    }

}
