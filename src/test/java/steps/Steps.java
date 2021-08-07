package steps;

import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;

import tests.Tests;

public class Steps extends Tests {

    @Допустим("^открыта главная страница сайта \"([^\"]*)\"$")

    @И("на странице присутствует форма логина")
    public void наСтраницеПрисутствуетФормаЛогина() {
    }

    @И("пользователь вводит имя пользователя {string} в поле {string}")
    public void пользовательВводитИмяПользователяВПоле(String arg0, String arg1) {
    }

    @И("пользователь вводит пароль {string} в поле {string}")
    public void пользовательВводитПарольВПоле(String arg0, String arg1) {
    }

    @И("пользователь нажимает кнопку {string}")
    public void пользовательНажимаетКнопку(String arg0) {
    }

    @Тогда("пользователь должен успешно войти в систему и перейти на страницу товаров")
    public void пользовательДолженУспешноВойтиВСистемуИПерейтиНаСтраницуТоваров() {
    }
}