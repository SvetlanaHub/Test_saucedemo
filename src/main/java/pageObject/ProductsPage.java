package pageObject;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class ProductsPage {

    //BUTTONS
    public static SelenideElement addToCartButton = $("btn btn_primary btn_small btn_inventory");
    private static final SelenideElement cartButton = $(".shopping_cart_link");

    public static final SelenideElement products = $(".header_secondary_container");

    public static void addToCart() {

        addToCartButton.click();
        cartButton.click();

    }
}
