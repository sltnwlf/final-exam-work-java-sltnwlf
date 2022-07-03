package requirements;

import base.TestBase;
import base.TestData;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

public class DataDeleteTests extends TestBase {

    /*******************************************************************************************************************
          Teszt, ami elfogadja az adatvédelmi nyilatkozatot, beregisztrál egy felhasználót, be is jelentkezik vele,
     ráklikkel a profile gombra, kitölti a formot a megfelelő adatokkal, elmenti a profilt, továbbá egy változóba menti
        az aktuális cookie tartalom számát, kitörli az felhasználót, újra lementi az aktuális cookie tartalom számát,
                          majd összehasonlítja a két számot és ha nem egyeznek a teszt sikeres.
     ******************************************************************************************************************/
    @RepeatedTest(3)
    @Epic("Portio")
    @Story("Data delete tests")
    @DisplayName("TC32, Delete account test")
    @Severity(SeverityLevel.CRITICAL)
    public void testDataDeleteAccount() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.regLog(
                TestData.regLogUsername,
                TestData.regLogPassword,
                TestData.email,
                TestData.regLogDescription,
                TestData.regLogUsername,
                TestData.regLogPassword);
        landing.clickOnProfile();
        profile.fillAll(
                TestData.profileName1,
                TestData.profileBio1,
                TestData.profilePhone1);
        int numberOfCookies1 = utils.getCookies().size();
        utils.refresh();
        profile.deleteAtOnce();
        int numberOfCookies2 = utils.getCookies().size();
        boolean isTrue = numberOfCookies1 == numberOfCookies2;
        Assertions.assertFalse(isTrue);
    }

}
