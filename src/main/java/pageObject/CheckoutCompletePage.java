package pageObject;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutCompletePage {

    //MESSAGE
    public static SelenideElement thankYouOrderMessage = $(".complete-header");

    //BUTTON
    public static SelenideElement backHomeButton = $("#back-to-products");


    public static void clickToBackHomeButton() {

        backHomeButton.click();

    }
}
