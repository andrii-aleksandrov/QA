package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super( driver );
    }

    @FindBy(xpath = "//div[@name='wishlists']/a")
    private WebElement addToWishListLink;

    public void addToWishList(){
        actionsWithElements.clickAction( addToWishListLink );
    }

}
