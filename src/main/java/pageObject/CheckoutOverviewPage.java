package pageObject;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selenide.$;

public class CheckoutOverviewPage {

    //BUTTONS
    private static final SelenideElement finishButton = $("#finish");
    private static final SelenideElement cancelButton = $("#cancel");

    //PRICE
    private final SelenideElement cartItemPrice = $(".inventory_item_price");
    public static SelenideElement cartItemTotalPrice = $(".summary_subtotal_label");

    public static void clickToFinishButton() {

        finishButton.click();

    }

    public static void clickToCancelButton() {

        cancelButton.click();

    }

    public void getItemPrice () {

        cartItemPrice.getText();

    }


}

