import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class FarelUITests {
    private FactorialPage factPage;

    @DataProvider(name = "data-provider-success")
    public Object[][] dataProviderMethod() {
        return new Object[][] { { "10", "3628800" }, { "0", "1" }, { "100", "9.332621544394415e+157" },
                { "170", "7.257415615307999e+306" }, { "171", "Infinity" }, { "979", "Infinity" } };
    }

    @DataProvider(name = "data-provider-failed")
    public Object[][] dataProviderFailedMethod() {
        return new Object[][] { { "-1", "Please enter an positive integer" },
                { "-200", "Please enter an positive integer" },
                { "sdgdsgsd", "Please enter an integer" } };
    }

    @BeforeClass
    public void auth() {
        factPage = new FactorialPage();
        Selenide.open(factPage.getURl());
    }

    @Test(dataProvider = "data-provider-success", priority = 1)
    public void calculateFactorialPositiveTest(String number, String result) throws InterruptedException {
        String resultString = factPage.calculateFactorial(number);
        assertThat(resultString).isEqualTo(
                String.format("The factorial of %s is: %s", number, result)
        );
    }

    @Test(dataProvider = "data-provider-failed", priority = 2)
    public void calculateFactorialNegativeTest(String number, String result) throws InterruptedException {
        String resultString = factPage.calculateFactorial(number);
        assertThat(resultString).isEqualTo(result);
    }
}
