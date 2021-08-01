package pageObject;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class BaseElements {

    //HEADER

    private final SelenideElement cartIcon = $("#shopping_cart_container");
    private final SelenideElement burgerMenu = $("#react-burger-menu-btn");
    public final SelenideElement products = $x("//span[text()='Products')]");

}
