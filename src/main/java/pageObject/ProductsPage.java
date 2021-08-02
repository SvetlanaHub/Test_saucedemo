package pageObject;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
public class ProductsPage {

    //BUTTONS
    static SelenideElement addToCartButton = $("#add-to-cart-sauce-labs-backpack");
    private static final SelenideElement cartButton = $(".shopping_cart_link");

    public static final SelenideElement products = $(".title");


    public static void addToCart() {

        addToCartButton.click();
        cartButton.click();

    }

}

