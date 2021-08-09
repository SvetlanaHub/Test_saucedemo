package steps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;
import pageObject.CartPage;
import tests.Tests;
import static pageObject.LoginPage.*;


public class AddingItemSteps extends Tests {

    @И("пользователь выбирает \"([^\"]*)\" и нажимает кнопку \"([^\"]*)\"$")
    public void userSelectsAndPressesAButton(String arg0, String arg1) {
        addToCartBackpack.click();
    }

    @Тогда("в корзине должен быть \"([^\"]*)\"$")
    public void inTheBasketShouldBe(String arg0) {
        cartButton.click();
        Assertions.assertEquals("Sauce Labs Backpack",CartPage.inventoryItem.getText(), "Cart is empty");

    }
}