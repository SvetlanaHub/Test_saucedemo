package pageObject;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProductsPage {

    //BUTTONS
    public final SelenideElement products = $x("//span[text()='Products')]");
    public static SelenideElement addToCartButton = $("btn btn_primary btn_small btn_inventory");
    private static final SelenideElement cartButton = $(".shopping_cart_link");



    public static void addToCart() {

        addToCartButton.click();
        cartButton.click();

    }
}
