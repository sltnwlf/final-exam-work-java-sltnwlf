package requirements;

import base.TestBase;
import base.TestData;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

public class DataSavingTests extends TestBase {

    /*******************************************************************************************************************
         Teszt, ami elfogadja az adatvédelmi nyilatkozatot, beregisztrál egy felhasználót, be is jelentkezik vele,
       ráklikkel a blogra, az összes oldalon végiglapoz, kiszedi egy tömbbe az összes bejegyzés címét, ezeket beteszi
     egy újonnan létrehozott fájlba, majd az ebből a fájlből kiolvasott sorokat hasonlítja össze egy elvárt eredménnyel.
     ******************************************************************************************************************/
    @RepeatedTest(3)
    @Epic("Portio")
    @Story("Data saving tests")
    @DisplayName("TC30, Saving article titles into file test")
    @Severity(SeverityLevel.NORMAL)
    public void testDataSavingArticleTitlesIntoFile() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.regLog(
                TestData.regLogUsername,
                TestData.regLogPassword,
                TestData.email,
                TestData.regLogDescription,
                TestData.regLogUsername,
                TestData.regLogPassword);
        landing.clickOnSeeAllPost();
        blog.saveArticleTitlesIntoFile();
        String[] actual = utils.readFromFile("ArticleTitles.txt");
        String[] expected = {
                "1. article title: Markdown Formatting Demo",
                "2. article title: Designer Conference at Florida 2020",
                "3. article title: Benjamin Franklins thoughts about new designers",
                "4. article title: Designers thoughts about mobile UI",
                "5. article title: How to become acreative designer",
                "6. article title: New designers limitations",
                "7. article title: Things you must know as a designer",
                "8. article title: World's Most Famous App Developers and Designers",
                "9. article title: You must know this before becoming a designer"};
        Assertions.assertArrayEquals(expected,actual);
    }

}
