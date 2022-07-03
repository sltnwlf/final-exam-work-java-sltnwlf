package requirements;

import base.TestBase;
import base.TestData;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class DataModifyingTests extends TestBase {

    /*******************************************************************************************************************
          Teszt, ami elfogadja az adatvédelmi nyilatkozatot, beregisztrál egy felhasználót, be is jelentkezik vele,
     ráklikkel a profile gombra, kitölti a formot a megfelelő adatokkal, elmenti a profilt, továbbá egy változóba menti
              az aktuális cookie tartalom számát, törli az input mezőket, más adatokkal újra kitölti a formot,
         elmenit az új profilt, újra lementi az aktuális cookie tartalom számát, majd összehasonlítja a két számot
                                          és ha nem egyeznek a teszt sikeres.
     ******************************************************************************************************************/
    @RepeatedTest(2)
    @Order(31)
    @Epic("Portio")
    @Story("Data modifying tests")
    @DisplayName("TC31, Modifying on profile test")
    @Severity(SeverityLevel.CRITICAL)
    public void testDataModifyingProfile() {
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
        Set<Cookie> cookies1 = utils.getCookies();
        profile.clearAll();
        profile.fillAll(
                TestData.profileName2,
                TestData.profileBio2,
                TestData.profilePhone2);
        utils.getCookies();
        Set<Cookie> cookies2 = utils.getCookies();
        boolean isTrue = cookies1 == cookies2;
        Assertions.assertFalse(isTrue);
    }

}
