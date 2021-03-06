package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsWithElements {
    WebDriver driver;
    Logger logger;
    WebDriverWait webDriverWait;
    Actions actions;

    public ActionsWithElements(WebDriver driver) {
        this.driver = driver;
        logger = Logger.getLogger( getClass() );
        try {
            webDriverWait = new WebDriverWait( driver, Integer.parseInt( ConfigData.getCfgValue( "WEBDRIVER_WAIT" ) ) );
        } catch (Exception e) {
            logger.error( "Can't initialize WebDriverWait" );
        }
    }

    public ActionsWithElements() {

    }

    public void clickAction(WebElement element) {
        try {
            webDriverWait.until( ExpectedConditions.elementToBeClickable( element ) );
            element.click();
            logger.info( "Element was clicked: " + element );
        } catch (Exception e) {
            logger.error( "Element can't be clicked: " + element );
            Assert.fail( "Element can't be clicked: " + element );
        }
    }

    public void clickAndHold(WebElement element) {
        actions = new Actions( driver );
        try {
            actions.clickAndHold( element ).build().perform();
            logger.info( "Element clicked and holded: " + element );
        } catch (Exception e) {
            logger.error( "Element can't be clicked: " + element );
        }
    }

    public void click(WebElement element) {
        actions = new Actions( driver );
        try {
            actions.click( element ).build().perform();
            logger.info( "Element clicked: " + element );
        } catch (Exception e) {
            logger.error( "Element can't be clicked: " + element );
        }
    }

    public void enterText(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys( text );
            logger.info( "Text " + text + " sent to " + element );
        } catch (Exception e) {
            logger.error( "Text " + text + " can't be send to " + element );
            Assert.fail( "Text " + text + " can't be send to " + element );
        }
    }

    public String getUsernameText(WebElement element, String username) {
        String elementText = "Failed to get text";
        try {
            webDriverWait.until( ExpectedConditions.textToBePresentInElement( element, username ) );
            elementText = element.getText();
            logger.info( "Text executed from element " + element );
        } catch (Exception e) {
            logger.error( "Can't get text from element " + element );
            Assert.fail( "Can't get text from element " + element );
        }
        return elementText;
    }

    public boolean isOnThePage(WebElement element) {
        webDriverWait.until( ExpectedConditions.visibilityOf( element ) );
        return element.isDisplayed();
    }

    public WebElement getElementByXPath(String xpath) {
        WebElement element = null;
        try {
            element = driver.findElement( By.xpath( xpath ) );
        } catch (Exception e) {
            logger.error( "WebElement can't be found by xPath: " + xpath );
        }
        return element;
    }

    public void moveTo(WebElement elementByXPath) {
        actions = new Actions( driver );
        try {
            webDriverWait.until( ExpectedConditions.visibilityOf( elementByXPath ) );
            actions.moveToElement( elementByXPath).build().perform();
            logger.info( "Moved to element " + elementByXPath );
        } catch (Exception e) {
            logger.error( "Can't move to element." );
            Assert.fail( "Can't move to element." );
        }
    }

    public void moveToElementWithOffset(WebElement elementByXPath, int x, int y) {
        actions = new Actions( driver );
        try {
            webDriverWait.until( ExpectedConditions.visibilityOf( elementByXPath ) );
            actions.moveToElement( elementByXPath, x, y ).build().perform();
            logger.info( "Moved to element " + elementByXPath );
        } catch (Exception e) {
            logger.error( "Can't move to element." );
            Assert.fail( "Can't move to element." );
        }
    }

    public String getElementText(WebElement element) {
        String text = "no text executed";
        try {
            text = element.getText();
            logger.info( "Text taken from element " + element );
        } catch (Exception e) {
            logger.error( "Can't get text from " + element );
            Assert.fail( "Can't get text from " + element );
        }
        return text;
    }

    public String returnTagValue(WebElement element, String tagName) {
        String tagValue = null;
        try {
            tagValue = element.getAttribute( tagName );
            logger.info( tagValue );
        } catch (Exception e) {
            logger.error( "Can't get text from tag" );
        }
        return tagValue;
    }

    public void waitForWebElementVisibility(WebElement element) {
        try {
            webDriverWait.until( ExpectedConditions.visibilityOf( element ) );
        } catch (Exception e) {
            logger.error( "Profile link not available" );
        }
    }
}
