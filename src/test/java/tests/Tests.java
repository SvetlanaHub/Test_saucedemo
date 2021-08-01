package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.RegisterExtension;
import pageObject.LoginPage;
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
        loginPage
                  .openLoginPage();
        loginPage
                .login();
        loginPage.products.shouldBe(visible);
        Assertions.assertEquals("Products", loginPage.products.getText(),"User is not log in");

    }
    @Test
    @Order(1)
    @DisplayName("Shopping")

    public void shopping() {

    }


    @AfterAll
    public void tearDown() {
        closeWebDriver();
    }


    }

