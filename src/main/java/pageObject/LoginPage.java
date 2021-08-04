package pageObject;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends ProductsPage {

    //LOGIN FORM FIELDS
    private final SelenideElement usernameField = $("#user-name");
    private final SelenideElement passwordField = $("#password");

    //BUTTON
    private final SelenideElement loginButton = $("#login-button");

    //DATA
    private static final CharSequence USERNAME = ("standard_user");
    private static final CharSequence PASSWORD = ("secret_sauce");

    public void login() {

        usernameField.sendKeys(USERNAME);
        passwordField.sendKeys(PASSWORD);
        loginButton.click();

    }

    public void openLoginPage(){

        open("https://www.saucedemo.com/");

    }
}

