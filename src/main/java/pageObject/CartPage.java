package pageObject;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {

    private final SelenideElement checkoutButton = $("#checkout");
    private final SelenideElement removeButton = $("btn btn_secondary btn_small cart_button");


    public void clickToCheckoutButton() {

        checkoutButton.click();
        removeButton.click();

    }
}
