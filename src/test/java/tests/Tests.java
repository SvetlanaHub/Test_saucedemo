package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.RegisterExtension;
import pageObject.*;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class Tests {

    @RegisterExtension
    static ScreenShooterExtension screenshotEmAll = new ScreenShooterExtension(true).to("resources/screenshots");

    @BeforeAll
    void setup() {

        Configuration.startMaximized = true;

    }

    @Test
    @Order(1)
    @DisplayName("Login")

    void Login() {

        LoginPage.openLoginPage();
        LoginPage.login();
        ProductsPage.products.shouldBe(visible);
        Assertions.assertEquals("PRODUCTS", ProductsPage.products.getText(), "User is not log in");

    }

    @Test
    @Order(2)
    @DisplayName("Shopping")

    void shopping() {

        LoginPage.openLoginPage();
        LoginPage.login();
        ProductsPage.addToCart();
        CartPage.clickToCheckoutButton();
        CheckoutInformationPage.clickContinueButton();
        CheckoutOverviewPage.clickToFinishButton();
        CheckoutCompletePage.thankYouOrderMessage.shouldBe(visible);
        Assertions.assertEquals("THANK YOU FOR YOUR ORDER", CheckoutCompletePage.thankYouOrderMessage.getText(), "Error: order not completed");

    }

    @Test
    @Order(3)
    @DisplayName("Cancellation of purchase")

    void cancellationOfPurchase() {

        LoginPage.openLoginPage();
        LoginPage.login();
        ProductsPage.addToCart();
        CartPage.clickToCheckoutButton();
        CheckoutInformationPage.clickContinueButton();
        CheckoutOverviewPage.clickToCancelButton();
        CartPage.clickToRemoveButton();
        ProductsPage.products.shouldBe(visible);
        Assertions.assertEquals("PRODUCTS", ProductsPage.products.getText(), "Error: purchase not canceled");

    }

    @Test
    @Order(4)
    @DisplayName("Removing all items from the cart")

    void removingAllItemsFromTheCart() {

        LoginPage.openLoginPage();
        LoginPage.login();
        ProductsPage.addToCart();
        CartPage.clickToRemoveButton();
        CartPage.cartBadge.shouldNotBe(visible);
        Assertions.assertTrue(CartPage.cartButton.getText().contains(""), "Items have not been deleted");

    }

    @Test
    @Order(5)
    @DisplayName("Сalculation of the total amount of items")

    void calculationOfTheTotalAmountOfItems() {

        LoginPage.openLoginPage();
        LoginPage.login();
        ProductsPage.addToCart();
        CartPage.clickToCheckoutButton();
        CheckoutInformationPage.clickContinueButton();
        Assertions.assertEquals(CheckoutOverviewPage.sumOrder(), CheckoutOverviewPage.getTotalSum(), "The amount is not correct");

    }

    @AfterAll
    void tearDown() {

        closeWebDriver();

    }

}






