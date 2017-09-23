package pages;

import libs.ActionsWithElements;
import libs.ConfigData;
import libs.ExcelDriver;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

@RunWith(value = Parameterized.class)
public class BasePage {
    WebDriver driver;
    public Logger logger;
    ActionsWithElements actionsWithElements;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        logger = Logger.getLogger( getClass() );
        actionsWithElements = new ActionsWithElements( driver );
        PageFactory.initElements( driver, this );
    }

    public void goToPage(String url) {
        try {
            driver.get( url );
            logger.info( "Main page opened" );
        } catch (Exception e) {
            logger.info( "Can't open Main page" );
            Assert.fail( "Can't open Main page" );
        }
    }

    @Parameterized.Parameters
    public Map<String, String> getTestData(String sheetName) {
        Map<String, String> testData = null;
        try {
            String testDataFilePath = ConfigData.getCfgValue( "DATA_FILE" );
            String testDataSheet = ConfigData.getCfgValue( sheetName );
            testData = ExcelDriver.getData( testDataFilePath, testDataSheet );
            logger.info( "Test data executed from excel file." );
        } catch (Exception e) {
            logger.error( "Can't execute test data from excel file" );
            Assert.fail( "Can't execute test data from excel file" );
        }
        return testData;
    }

}

