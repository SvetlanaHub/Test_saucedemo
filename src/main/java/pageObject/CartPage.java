package pageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import javax.lang.model.util.Elements;

import static com.codeborne.selenide.Selenide.*;

public class CartPage {

    //BUTTONS
    private static final SelenideElement checkoutButton = $("#checkout");
    private static final SelenideElement removeButton = $x("//button[text()='Remove']");
    public static ElementsCollection itemsCollection = $$(".inventory_item_name");
    private static final SelenideElement removeBackpack = $("#remove-sauce-labs-backpack");
    private static final SelenideElement removeBikeLight = $("#remove-sauce-labs-bike-light");
    public static final SelenideElement cartBadge = $(".shopping_cart_badge");


    //public static final SelenideElement cartList = (SelenideElement) $$(".cart_list");

    private final SelenideElement cartItemPrice = $(".inventory_item_price");


    public static void clickToCheckoutButton() {

        checkoutButton.click();

    }

    //public static void clickToRemoveButton() {

        //removeBackpack.click();
        //removeBikeLight.click();

    //}
    public static void clickToRemoveButton() {

        items.get(1).$x("//button[text()='Remove']").click();

    }

    public void getPrice () {

        cartItemPrice.getText();

    }
}

