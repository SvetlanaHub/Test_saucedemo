#language:ru
#encoding:UTF-8

@test @AddingItem

Функционал: Параметризированный запуск тестов

  Структура сценария: проверка, что пользователь может добавить в корзину "<Item>"
    Допустим открыта главная страница сайта "https://www.saucedemo.com/"
    И на странице присутствует форма логина
    И пользователь вводит имя пользователя "<standard_user>" в поле "<Username>"
    И пользователь вводит пароль "<secret_sauce>" в поле "<Password>"
    И пользователь нажимает кнопку "LOGIN"
    И пользователь выбирает "<Item>" и нажимает кнопку "Add To Cart"
    Тогда в корзине должен быть "<Item>"

    Примеры:
      | Username     |Password     |Item|
      | standard_user|secret_sauce |Sauce Labs Backpack|

