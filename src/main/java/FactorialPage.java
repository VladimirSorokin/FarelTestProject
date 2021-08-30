import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FactorialPage extends AuthCommon {

    private final By numberInput = By.id("number");
    private final By calculateButton = By.id("getFactorial");
    private final By resultString = By.id("resultDiv");

    @Step("Calculate factorial for number {0}")
    public String calculateFactorial(String number) throws InterruptedException {
        $(numberInput).shouldBe(Condition.visible).setValue(number);
        $(calculateButton).shouldBe(Condition.visible).click();
        Thread.sleep(1000);
        return $(resultString).shouldBe(Condition.visible)
                .waitUntil(Condition.not(Condition.empty), 1000).getText();
    }
}
