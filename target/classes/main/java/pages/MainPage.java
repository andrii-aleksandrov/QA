package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super( driver );
    }

    @FindBy(xpath = ".//a[@id='fat_menu_btn']")
    private WebElement fatMenuButton;

    @FindBy(xpath = ".//li[@id='2416']/a")
    private WebElement notebooksAndComputers;

    @FindBy(xpath = "//div[@name='second_menu']//a[@href='https://rozetka.com.ua/notebooks/c80004/']")
    private WebElement notebooks;

    @FindBy(xpath = "//div[@name='block_with_goods']//p//a[@href='https://rozetka.com.ua/notebooks/c80004/']")
    private WebElement notebooksSubmenu;

    public void moveToNotebooksAndComputers() {
        actionsWithElements.clickAndHold( notebooksAndComputers );
        try {
            actionsWithElements.click( notebooks );
        } catch (Exception e) {
            actionsWithElements.clickAction( notebooksAndComputers );
            actionsWithElements.clickAction( notebooksSubmenu );
        }
    }
}
