package pageObject;


import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
public class CartPage {

    //BUTTONS
    private static final SelenideElement checkoutButton = $("#checkout");
    private static final SelenideElement removeBackpack = $("#remove-sauce-labs-backpack");
    private static final SelenideElement removeBikeLight = $("#remove-sauce-labs-bike-light");
    public static final SelenideElement cartButton = $(".shopping_cart_link");


    public static final SelenideElement cartBadge = $(".shopping_cart_badge");
    private static final SelenideElement cartItemPrice = $(".inventory_item_price");


    public static void clickToCheckoutButton() {

        checkoutButton.click();

    }

    public static void clickToRemoveButton() {

        removeBackpack.click();
        removeBikeLight.click();

    }

        public void getPrice() {

        cartItemPrice.getText();

    }

}

