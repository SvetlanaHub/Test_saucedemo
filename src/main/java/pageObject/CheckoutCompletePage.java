package pageObject;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutCompletePage {

    public static SelenideElement thankYouOrderMessage = $(".complete-header");

}
