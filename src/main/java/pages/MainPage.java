package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super( driver );
    }

    @FindBy(xpath = ".//a[@id='fat_menu_btn']")
    private WebElement fatMenuButton;

    @FindBy(xpath = ".//li[@id='2416']")
    private WebElement notebooksAndComputers;

    @FindBy(xpath = "//li[@class='f-menu-sub']//a[@href='https://rozetka.com.ua/notebooks/c80004/']")
    private WebElement notebooks;

    public void moveToNotebooksAndComputers() {
        try {
            actionsWithElements.moveTo( fatMenuButton );
            actionsWithElements.moveTo( notebooksAndComputers );
            actionsWithElements.clickAction( notebooks );

        } catch (Exception e) {
            logger.error( "Element can't be clicked: " + notebooksAndComputers.toString() );
        }
    }
}
