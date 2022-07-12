package requirements;

import base.TestBase;
import base.TestData;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;

public class DataListingTests extends TestBase {

    /*******************************************************************************************************************
          Teszt, ami elfogadja az adatvédelmi nyilatkozatot, beregisztrál egy felhasználót, be is jelentkezik vele,
                     ráklikkel a blogra, az első oldalon kiszedi egy tömbbe az összes bejegyzés címét,
                                és ezt a tömböt hasonlítja össze egy elvárt eredménnyel.
     ******************************************************************************************************************/
    @RepeatedTest(3)
    @Epic("Portio")
    @Story("Data listing tests")
    @DisplayName("TC18, Listing on first blog page test")
    @Severity(SeverityLevel.NORMAL)
    public void testDataListingOnFirstBlogPage() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.regLog(
                TestData.regLogUsername,
                TestData.regLogPassword,
                TestData.email,
                TestData.regLogDescription,
                TestData.regLogUsername,
                TestData.regLogPassword);
        landing.clickOnSeeAllPost();
        String[] actual = blog.listArticleTitlesOnFirstPage();
        String[] expected = {
                "Markdown Formatting Demo",
                "Designer Conference at Florida 2020",
                "Benjamin Franklins thoughts about new designers",
                "Designers thoughts about mobile UI",
                "How to become acreative designer",
                "New designers limitations"};
        Assertions.assertArrayEquals(expected, actual);
    }

}
