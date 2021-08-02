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
    public void setupLogin() {

        Configuration.startMaximized = true;
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginPage();
        loginPage.login();
        ProductsPage.products.shouldBe(visible);
        Assertions.assertEquals("PRODUCTS", ProductsPage.products.text(),"User is not log in");

    }

    @Test
    @Order(1)
    @DisplayName("Shopping")

    public void shopping() {

        ProductsPage.addToCart();
        CartPage.clickToCheckoutButton();
        CheckoutInformationPage.checkout();
        CheckoutOverviewPage.clickToFinishButton();
        CheckoutCompletePage.thankYouOrderMessage.shouldBe(visible);
        Assertions.assertEquals("THANK YOU FOR YOUR ORDER", CheckoutCompletePage.thankYouOrderMessage.getText(),"Error: order not completed");

    }

    @Test
    @Order(2)
    @DisplayName("Cancellation of purchase")

    public void cancellationOfPurchase() {

        ProductsPage.addToCart();
        CartPage.clickToCheckoutButton();
        CheckoutInformationPage.checkout();
        CheckoutOverviewPage.clickToCancelButton();
        ProductsPage.products.shouldBe(visible);
        Assertions.assertEquals("Products", ProductsPage.products.getText(),"User is not log in");

    }

    @Test
    @Order(3)
    @DisplayName("Removing all items from the cart")

    public void removingAllItemsFromTheCart() {

        ProductsPage.addToCart();

    }

    @AfterAll
    public void tearDown() {
        closeWebDriver();
    }


    }

