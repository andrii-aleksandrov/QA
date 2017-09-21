package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ItemsPage extends BasePage {

    public ItemsPage(WebDriver driver) {
        super( driver );
    }

    @FindBy(xpath = "//div[@id='catalog_goods_block']//div[@class='g-id']")
    private List<WebElement> itemID;

    public int getNumberOfItems() {
        return itemID.size();
    }

    public String getProductId(int i) {
        String id = "";
        String idXPath;
        WebElement divID;
        int itemNumber = i + 1;
        String itemNumberString = String.valueOf( itemNumber );
        if (itemNumberString.length() < 2) {
            itemNumberString = "0" + itemNumberString;
        }
        idXPath = ".//input[@value='0" + itemNumberString + "']";
        divID = actionsWithElements.getElementByXPath( idXPath );

        try {
            id = divID.getAttribute( "name" );
            id = id.substring( 15 );
        } catch (Exception e) {
            logger.info( "Can't get product ID" );
        }
        return id;
    }

    public String getRewiews(String id) {
        String reviewsString = "0";
        String reviewsXpath = "//div[@class='g-i-tile g-i-tile-catalog']//div[@class='g-rating']//a[contains(@href, '" + id + "')]";
        try {
            WebElement reviews = actionsWithElements.getElementByXPath( reviewsXpath );
            reviewsString = reviews.getAttribute( "data-count" );
        } catch (Exception e) {
            logger.error( "Can't get reviews from item with ID: " + id );
        }
        return reviewsString;
    }

    public Integer getIntegerReviews(String reviews) {
        Integer reviewsInteger = 0;
        try {
            reviewsInteger = Integer.parseInt( reviews );
        } catch (Exception e) {
            logger.error( "Can't parse reviews to Integer" );
        }
        return reviewsInteger;
    }

    public void addToWishList(String maxReviewsID) {
        String wishlistIconXPath = "";
        String wishListLinkXPath = "";
        WebElement wishlistIcon;
        WebElement wishListLink;
        wishlistIconXPath = "//div[@id='wishlist-popup-" + maxReviewsID + "']";
        try {
            wishlistIcon = actionsWithElements.getElementByXPath( wishlistIconXPath );
            wishListLinkXPath = wishlistIconXPath + "//div/a";
            wishListLink = actionsWithElements.getElementByXPath( wishListLinkXPath );

            actionsWithElements.moveTo( wishlistIcon );
            actionsWithElements.clickAction( wishListLink );
        } catch (Exception e) {
            logger.error( "Can't click wishlist button" );
        }
    }

    public void goToProductPage(String id) {
        String productLinkXPath;
        WebElement productLink;
        productLinkXPath = "//div[@class='g-i-tile-i-title clearfix']//a[contains(@href, '" + id + "')]";
        productLink = actionsWithElements.getElementByXPath( productLinkXPath );
        actionsWithElements.clickAction( productLink );
    }
}
