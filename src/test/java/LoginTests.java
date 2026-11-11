import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class LoginTests {
    private static String msg = ""Welcome, user1!!!!!!!""
    @Test
    void successfulLoginTest(){
        open("https://autotests.ai/stack/backend-java-spring/frontend-typescript-react/login");
        $("[data-testid=login-input]").setValue("user1");
        $("[data-testid=password-input]").setValue("password1").pressEnter();
        $("[data-testid=welcome-message]").shouldBe(text(msg));

        closeWebDriver();
    }
    @Test
    void emptyLoginLoginTest(){
        open("https://autotests.ai/stack/backend-java-spring/frontend-typescript-react/login");
        $("[data-testid=login-input]").setValue("");
        $("[data-testid=password-input]").setValue("password1").pressEnter();
        $("[data-testid=error-message]").shouldBe(text("Login is required (minimum 3 characters)"));

        closeWebDriver();
    }
@Test
    void more64charactersLoginLoginTest(){
        open("https://autotests.ai/stack/backend-java-spring/frontend-typescript-react/login");
        $("[data-testid=login-input]").setValue("111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
        $("[data-testid=password-input]").setValue("password1").pressEnter();
        $("[data-testid=error-message]").shouldBe(text("username size must be between 3 and 64"));

        closeWebDriver();
    }
    }

