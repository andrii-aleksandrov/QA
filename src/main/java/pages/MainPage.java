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

    @FindBy(xpath = "//*[@id='2416']/div/div[2]/div/ul[1]/li[1]/a")
    private WebElement notebooks;

    @FindBy(xpath = "//div[@name='block_with_goods']//p//a[@href='https://rozetka.com.ua/notebooks/c80004/']")
    private WebElement notebooksSubmenu;

    public void moveToNotebooksAndComputers() {
        try {
            actionsWithElements.moveTo( fatMenuButton );
            actionsWithElements.moveTo( notebooksAndComputers );
            actionsWithElements.clickAction( notebooks );
        } catch (Exception e) {
            actionsWithElements.clickAction( notebooksAndComputers );
            actionsWithElements.clickAction( notebooksSubmenu );
        }
    }
}
