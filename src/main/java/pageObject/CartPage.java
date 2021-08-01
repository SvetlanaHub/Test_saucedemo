package pageObject;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {

    private final SelenideElement checkoutButton = $("#checkout");
    private final SelenideElement removeButton = $("btn btn_secondary btn_small cart_button");
    private final SelenideElement carPrice = $(".inventory_item_price");

    public void clickToCheckoutButton() {

        checkoutButton.click();

    }

    public void clickToRemoveButton() {

        removeButton.click();
    }

    public void getPrice () {

        carPrice.getText();

    }
}

