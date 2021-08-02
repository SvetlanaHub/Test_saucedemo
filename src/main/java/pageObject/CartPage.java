package pageObject;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {

    //BUTTONS
    private static final SelenideElement checkoutButton = $("#checkout");
    private final SelenideElement removeButton = $("#remove-sauce-labs-backpack");
    private final SelenideElement cartItemPrice = $(".inventory_item_price");

    public static void clickToCheckoutButton() {

        checkoutButton.click();

    }

    public void clickToRemoveButton() {

        removeButton.click();
    }

    public void getPrice () {

        cartItemPrice.getText();

    }
}

