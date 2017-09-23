package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishList extends BasePage {
    public WishList(WebDriver driver) {
        super( driver );
    }

    @FindBy(xpath = "//input[@name='wishlist-block-goods-checkbox']")
    private WebElement checkboxWithID;

    @FindBy(xpath = "//a[@name='wishlist-delete']")
    private WebElement clearWishList;

    @FindBy(xpath = "//a[@name='wishlist-delete-submit']")
    private WebElement clearConfirmation;

    public String getIdInWishList(){
        return checkboxWithID.getAttribute( "goods_id" );
    }

    public void clearWishList(){
        actionsWithElements.clickAction( clearWishList );
        actionsWithElements.clickAction( clearConfirmation );
    }
}
