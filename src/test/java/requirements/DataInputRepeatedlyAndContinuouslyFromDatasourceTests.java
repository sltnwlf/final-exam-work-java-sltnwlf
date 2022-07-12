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

public class DataInputRepeatedlyAndContinuouslyFromDatasourceTests extends TestBase {

    /*******************************************************************************************************************
                      Teszt, ami elfogadja az adatvédelmi nyilatkozatot, beregisztrál 5 felhasználót,
                       amihez egy előre elkészített fájlból olvassa be az adatokat, majd ellenőrzi,
               hogy megfelelő-e a cookie-k száma. 1 adatvédelmi nyilatkozat + az 5 regisztrált felhasználó.
     ******************************************************************************************************************/
    @RepeatedTest(3)
    @Epic("Portio")
    @Story("Data input repeatedly and continuously from datasource tests")
    @DisplayName("TC28, Data input on registration repeatedly and continuously from datasource test")
    @Severity(SeverityLevel.CRITICAL)
    public void testDataInputOnRegistrationRepeatedlyAndContinuouslyFromDatasource() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.registrationRepeatedlyAndContinuouslyFromDatasource();
        Set<Cookie> cookieSet = driver.manage().getCookies();
        int expected = 6;
        int actual = cookieSet.size();
        Assertions.assertEquals(expected,actual);
    }

    /*******************************************************************************************************************
         Teszt, ami elfogadja az adatvédelmi nyilatkozatot, beregisztrál 5 felhasználót, és be is jelentkezik velük,
             majd ki is jelentkezik mindegyikkel, amihez két előre elkészített fájlból olvassa be az adatokat.
     Eztuán ellenőrzi az egyik előzőleg beregisztrált felhasználóval, hogy  továbbra is rendben be tudunk-e jelentkezni.
     ******************************************************************************************************************/
    @RepeatedTest(3)
    @Epic("Portio")
    @Story("Data input repeatedly and continuously from datasource tests")
    @DisplayName("TC29, Data input on login repeatedly and continuously from datasource test")
    @Severity(SeverityLevel.CRITICAL)
    public void testDataInputOnLoginRepeatedlyAndContinuouslyFromDatasource() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.regLogRepeatedlyAndContinuouslyFromDatasource();
        regLog.login(
                TestData.regLogUsernameFromFile,
                TestData.regLogPasswordFromFile);
        boolean logActual = regLog.isThereRegLogForm();
        Assertions.assertFalse(logActual);
    }

}
