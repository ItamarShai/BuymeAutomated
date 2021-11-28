package POM;

import ToolsAndInterfaces.WebpageParent;
import org.openqa.selenium.By;

public class HomeScreen extends WebpageParent {

//    Open price range menu
    public void openPriceRangeMenu() {
        clickElement(By.cssSelector("div[id=ember1014_chosen]"));
    }

//    Choose price range
    public void pickPriceRange() {
        clickElement(By.cssSelector("li[class=active-result][data-option-array-index='3']"));
    }

//    Open region menu
    public void openRegionMenu() {
        clickElement(By.cssSelector("div[id=ember1029_chosen]"));
    }

//    Pick region
    public void pickRegion() {
        clickElement(By.cssSelector("li[class=active-result][data-option-array-index='3']"));
    }

//    Open category menu
    public void openCategoryMenu() {
        clickElement(By.cssSelector("div[id=ember1039_chosen]"));
    }

//    Pick category
    public void pickCategory() {
        clickElement(By.cssSelector("li[class=active-result][data-option-array-index='3']"));
    }

//    Search for a gift
    public void findNewGift() {
        clickElement(By.cssSelector("a[id=ember1074]"));
    }


}
