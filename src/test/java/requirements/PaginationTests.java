package requirements;

import base.TestBase;
import base.TestData;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

public class PaginationTests extends TestBase {

    /*******************************************************************************************************************
          Teszt, ami elfogadja az adatvédelmi nyilatkozatot, beregisztrál egy felhasználót, be is jelentkezik vele,
         ráklikkel a blogra, végiglapozza az össze oldalt, közben megszámolja, hogy mennyi van a blogbejegyzésekből.
     ******************************************************************************************************************/
    @RepeatedTest(3)
    @Epic("Portio")
    @Story("Pagination tests")
    @DisplayName("TC17, Pagination on blog page test")
    @Severity(SeverityLevel.CRITICAL)
    public void testPaginationOnBlogPage() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.regLog(
                TestData.regLogUsername,
                TestData.regLogPassword,
                TestData.email,
                TestData.regLogDescription,
                TestData.regLogUsername,
                TestData.regLogPassword);
        landing.clickOnSeeAllPost();
        int expected = 9;
        int actual = blog.articleCounter();
        Assertions.assertEquals(expected, actual);
    }

}
