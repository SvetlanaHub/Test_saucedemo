package pageObject;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends ProductsPage {

    //LOGIN FORM FIELDS
    private static final SelenideElement usernameField = $("#user-name");
    private static final SelenideElement passwordField = $("#password");

    //BUTTON
    private static final SelenideElement loginButton = $("#login-button");

    //DATA
    private static final CharSequence USERNAME = ("standard_user");
    private static final CharSequence PASSWORD = ("secret_sauce");

    public static void login() {

        usernameField.sendKeys(USERNAME);
        passwordField.sendKeys(PASSWORD);
        loginButton.click();

    }

    public static void openLoginPage(){

        open("https://www.saucedemo.com/");

    }
}

