package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import java.util.Random;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage  {
    public LoginPage(String url){
        Selenide.open(url);
    }
    private final static String ERROR_MESSAGE1 = "Please input your Email or Phone!";
    private final static String ERROR_MESSAGE2 = "Please input your password!";
    private final SelenideElement emailField = $("[placeholder='username, Email or phone']");
    private final SelenideElement passowrdField = $("[placeholder='Password']");
    private final SelenideElement signUpNow = $("[href='/signup/user-application']");
    private final SelenideElement submit = $x("//span[text()='Sign In']");
    private final SelenideElement errorMessage1 = $("[id='normal_login_username_help']");
    private final SelenideElement errorMessage2 = $("[id='normal_login_password_help']");

    public LoginPage() {

    }

    public LoginPage putEmail(String email){
        emailField.setValue(email);
        return new LoginPage();
    }

    public LoginPage putPasswordField(String password) {
        passowrdField.setValue(password);
        return new LoginPage();
    }

    public LoginPage clickSubmit() {
        submit.click();
        return new LoginPage();
    }


    public void assertErrorMessageVisible() {
        errorMessage1.shouldBe(Condition.visible);
        errorMessage1.shouldBe(Condition.text(ERROR_MESSAGE1));
    }

    public void assertErrorMessage2Visible() {
        errorMessage2.shouldBe(Condition.visible);
        errorMessage2.shouldBe(Condition.text(ERROR_MESSAGE2));
    }
    public static String randomInvalidPassword(int len) {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(rand.nextInt(5));
        }
        return sb.toString();
    }
}