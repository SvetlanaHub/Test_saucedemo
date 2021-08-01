package pageObject;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class ProductsPage {

    private final SelenideElement addToCartButton = $("btn btn_primary btn_small btn_inventory");
    private final SelenideElement cartButton = $(".shopping_cart_link");


    public void addToCart() {

        addToCartButton.click();
        cartButton.click();

    }
}
