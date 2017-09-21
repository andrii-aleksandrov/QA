package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilterBlock extends BasePage {
    public FilterBlock(WebDriver driver) {
        super( driver );
    }

    @FindBy(xpath = "//div[@class='m-cat']//ul[2]/li[3]/ul/li[3]/a")
    WebElement filterPrice3;

    public void selectFilter() {
        actionsWithElements.clickAction( filterPrice3 );
    }

}
