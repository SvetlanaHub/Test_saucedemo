#language:ru
#encoding:UTF-8

  @test @login

Функционал: Параметризированный запуск тестов

    Структура сценария: Проверка, что пользователь может входить в систему с допустимым именем пользователя и паролем
    Допустим открыта главная страница сайта "https://www.saucedemo.com/"
    И на странице присутствует форма логина
    И пользователь вводит имя пользователя "<standard_user>" в поле "<Username>"
    И пользователь вводит пароль "<secret_sauce>" в поле "<Password>"
    И пользователь нажимает кнопку "LOGIN"
    Тогда пользователь должен успешно войти в систему и перейти на страницу товаров

      Примеры:
        | Username     |Password     |
        | standard_user|secret_sauce |


