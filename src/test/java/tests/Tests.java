package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.By;
import pageObject.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static pageObject.CartPage.clickToRemoveButton;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class Tests {

    LoginPage loginPage = new LoginPage();
    ProductsPage productsPage = new ProductsPage();
    CartPage cartPage = new CartPage();
    CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage();
    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
    CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage();


    @RegisterExtension
    static ScreenShooterExtension screenshotEmAll = new ScreenShooterExtension(true).to("resources/screenshots");

    @BeforeAll
    public void setup() {

        Configuration.startMaximized = true;

    }

    @Test
    @Order(1)
    @DisplayName("Login")

    public void Login() {

        loginPage.openLoginPage();
        loginPage.login();
        productsPage.products.shouldBe(visible);
        Assertions.assertEquals("PRODUCTS", ProductsPage.products.getText(), "User is not log in");

    }

    @Test
    @Order(2)
    @DisplayName("Shopping")

    public void shopping() {

        loginPage.openLoginPage();
        loginPage.login();
        productsPage.addToCart();
        cartPage.clickToCheckoutButton();
        CheckoutInformationPage.clickContinueButton();
        checkoutOverviewPage.clickToFinishButton();
        checkoutCompletePage.thankYouOrderMessage.shouldBe(visible);
        Assertions.assertEquals("THANK YOU FOR YOUR ORDER", CheckoutCompletePage.thankYouOrderMessage.getText(), "Error: order not completed");

    }

    @Test
    @Order(3)
    @DisplayName("Cancellation of purchase")

    public void cancellationOfPurchase() {

        loginPage.openLoginPage();
        loginPage.login();
        productsPage.addToCart();
        cartPage.clickToCheckoutButton();
        CheckoutInformationPage.clickContinueButton();
        CheckoutOverviewPage.clickToCancelButton();
        ProductsPage.products.shouldBe(visible);
        Assertions.assertEquals("PRODUCTS", ProductsPage.products.getText(), "Error: purchase not canceled");

    }

    @Test
    @Order(4)
    @DisplayName("Removing all items from the cart")

    public void removingAllItemsFromTheCart() {

        loginPage.openLoginPage();
        loginPage.login();
        ProductsPage.addToCart();

        CartPage.cartBadge.shouldBe(visible);
        //CartPage.itemsCollection = CartPage.clickToRemoveButton();
        //removeButtonCollection.first().$(By.xpath("//button[text()='Remove']")).click();
        CartPage.clickToRemoveButton();

    }

    @Test
    @Order(5)
    @DisplayName("Сalculation of the total amount of items")

    public void calculationOfTheTotalAmountOfItems() {

        loginPage.openLoginPage();
        loginPage.login();
        ProductsPage.addToCart();
        cartPage.clickToCheckoutButton();
        CheckoutInformationPage.clickContinueButton();
        ElementsCollection selenideElements = CartPage.itemsCollection.shouldBe(visible);


    }





    @AfterAll
        public void tearDown() {
            closeWebDriver();
        }
    }





