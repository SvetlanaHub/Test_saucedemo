package steps;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;

import org.junit.jupiter.api.Assertions;
import pageObject.ProductsPage;
import tests.Tests;

import static com.codeborne.selenide.Selenide.open;
import static pageObject.LoginPage.*;

public class LoginSteps extends Tests {

    @Допустим("^открыта главная страница сайта \"([^\"]*)\"$")
    public void openPage(String pageURL) {
        open(pageURL);
        Configuration.startMaximized = true;
    }

    @И("на странице присутствует форма логина")
    public void onPagePresentFormLogin() {

    }

    @И("пользователь вводит имя пользователя \"([^\"]*)\" в поле \"([^\"]*)\"$")
    public void userEntersUsernameInTheField(String arg0, String arg1) {
        usernameField.sendKeys(USERNAME);
    }

    @И("пользователь вводит пароль \"([^\"]*)\" в поле \"([^\"]*)\"$")
    public void userEntersPasswordInTheField(String arg0, String arg1) {
        passwordField.sendKeys(PASSWORD);
    }

    @И("пользователь нажимает кнопку \"([^\"]*)\"$")
    public void userPressesTheButton(String arg0) {
        loginButton.click();
    }

    @Тогда("пользователь должен успешно войти в систему и перейти на страницу товаров")
    public void userMustSuccessfullyLoginToTheSystemAndGoToTheProductsPage() {
        Assertions.assertEquals("PRODUCTS", ProductsPage.products.getText(), "User is not log in");
    }
}