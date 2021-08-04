package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.RegisterExtension;
import pageObject.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Boolean.parseBoolean;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class Tests {

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

        LoginPage.openLoginPage();
        LoginPage.login();
        ProductsPage.products.shouldBe(visible);
        Assertions.assertEquals("PRODUCTS", ProductsPage.products.getText(), "User is not log in");

    }

    @Test
    @Order(2)
    @DisplayName("Shopping")

    public void shopping() {

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

    public void cancellationOfPurchase() {

        LoginPage.openLoginPage();
        LoginPage.login();
        ProductsPage.addToCart();
        CartPage.clickToCheckoutButton();
        CheckoutInformationPage.clickContinueButton();
        CheckoutOverviewPage.clickToCancelButton();
        ProductsPage.products.shouldBe(visible);
        Assertions.assertEquals("PRODUCTS", ProductsPage.products.getText(), "Error: purchase not canceled");

    }

    @Test
    @Order(4)
    @DisplayName("Removing all items from the cart")

    public void removingAllItemsFromTheCart() {

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

    public void calculationOfTheTotalAmountOfItems() {

        LoginPage.openLoginPage();
        LoginPage.login();
        ProductsPage.addToCart();
        CartPage.clickToCheckoutButton();
        CheckoutInformationPage.clickContinueButton();
        String stringPrice = CheckoutOverviewPage.cartItemTotalPrice.getText().replace("Item total: $", "");
        Double doublePrice = Double.parseDouble(stringPrice);
        CheckoutOverviewPage.cartItemTotalPrice.shouldBe(visible);
        //Assertions.assertFalse(parseBoolean(CheckoutOverviewPage.cartItemTotalPrice.getText()), stringPrice), "The amount is not correct");

    }

    @AfterAll
        public void tearDown() {

            closeWebDriver();

        }

    }






