#language:ru
#encoding:UTF-8

@test @PriceItem

  Функционал: проверка цены товара "<Sauce Labs Bike Light>" в корзине
  Допустим открыта главная страница сайта "https://www.saucedemo.com/"
  И пользователь успешно вошел в систему
  И пользователь выбрал товар "<Sauce Labs Bike Light>" и нажал кнопку "Add To Cart"
  Тогда в корзине отображается товар "<Sauce Labs Bike Light>" с ценой $9.99


