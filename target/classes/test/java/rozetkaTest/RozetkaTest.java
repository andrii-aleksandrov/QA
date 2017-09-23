package rozetkaTest;

import baseTest.BaseTest;
import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class RozetkaTest extends BaseTest {

    public RozetkaTest(String browser) {
        super( browser );
    }

    @Test
    public void wishListRozetka() throws InterruptedException {
        String productID;
        String reviews;
        Integer reviewsInt;

        Map<String, String> dataSet = basePage.getTestData( "VALID_DATA" );
        String login = dataSet.get( "login" );
        String pass = dataSet.get( "pass" );

        basePage.goToPage( "https://rozetka.com.ua/" );

        loginPage.clickLoginLink();
        loginPage.enterLogin( login );
        loginPage.enterPassword( pass );
        loginPage.clickSubmitButton();

        mainPage.moveToNotebooksAndComputers();
        filterBlock.selectFilter();

        //Get product id with max reviews on page
        Map<String, Integer> itemsMap = new HashMap<>();
        int numberOfItems = itemsPage.getNumberOfItems();

        for (int i = 0; i < numberOfItems; i++) {

            productID = itemsPage.getProductId( i );
            reviews = itemsPage.getRewiews( productID );

            reviewsInt = itemsPage.getIntegerReviews( reviews );

            if (reviewsInt > 0) {
                itemsMap.put( productID, reviewsInt );
            }
        }

        Map.Entry<String, Integer> max = Collections.max( itemsMap.entrySet(),
                Comparator.comparingInt( Map.Entry::getValue ) );
        String maxReviewsID = max.getKey();

        //productPage.addToWishList( maxReviewsID );
        itemsPage.goToProductPage( maxReviewsID );
        productPage.addToWishList();
        header.goToWishList();
        String wishListID = wishList.getIdInWishList();

        wishList.clearWishList();

        checkCriteria( "ID of product does not match", maxReviewsID, wishListID );
    }
}
