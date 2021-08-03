package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HotelSearchPage extends BasePage {
    private WebDriver driver;

    public HotelSearchPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By sortBySelector = By.id("sort");
    private By hotelInformationCard = By.cssSelector("[data-stid='open-hotel-information']");

    private By priceText = By.cssSelector("[data-stid='price-lockup-text']");

    public void sortByPrice() {
        WebElement sortDropdown = driver.findElement(sortBySelector);
        Select select = new Select(sortDropdown);
        select.selectByValue("PRICE_LOW_TO_HIGH");
        waitForElementToBeVisible(hotelInformationCard);
    }

    public boolean correctlySortedByPrice() {
        sortByPrice();
        List<WebElement> allPricesInText = getWebElementList(priceText);
        List<Integer> allPrices = pricesList(allPricesInText);

        return allPrices.stream().sorted().collect(Collectors.toList()).equals(allPrices);
    }

    public List<Integer> pricesList(List<WebElement> priceList) {
        ArrayList<Integer> allPrices = new ArrayList<>();

        for(WebElement price: priceList) {
            int num = Integer.parseInt(price.getText().substring(0, 0));
            System.out.println(num);
            allPrices.add(num);
        }
        return allPrices;
    }
}
