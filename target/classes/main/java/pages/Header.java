package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends BasePage {

    public Header(WebDriver driver) {
        super( driver );
    }

    @FindBy(xpath = "//div[@id='wishlist']")
    private WebElement wishlist;

    @FindBy(xpath = "//a[@name='close']")
    private WebElement socialNetClose;

    public void goToWishList() {
        actionsWithElements.clickAction( socialNetClose );
        actionsWithElements.clickAction( wishlist );
    }
}
