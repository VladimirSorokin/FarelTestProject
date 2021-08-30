import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import static org.assertj.core.api.Assertions.assertThat;

public class FarelAPITests {
    private FactorialRequests factRequests;

    @DataProvider(name = "data-provider-success")
    public Object[][] dataProviderMethod() {
        return new Object[][]{{"10", "3628800"}, { "0", "1" },
                { "100", "933262154439441526816992388562667004907159682643816214685929638952175999932299156089414639761" +
                        "56518286253697920827223758251185210916864000000000000000000000000" },
                { "170", "725741561530799896739672821112926311471699168129645137654357779890056184340170615785235074924" +
                        "2617459511490991237838520776666022565442753025328900773207510902400430280058295603966612599658" +
                        "2571043985582942575689663134396122625710949468067112055688804571933402126614528000000000000000" +
                        "00000000000000000000000000" },
                { "171", "1241018070217667823424840524103103992616605577501693185388951803611996075221691752992751978" +
                        "12048758557646495950167038705280988985869071076733124203221848436431047357788996854827829075" +
                        "45415619648521534683180442932395981736968996572359039476161522785581800611763651084288000000" +
                        "00000000000000000000000000000000000" },
                { "979", "Infinity" } };
    }

    @DataProvider(name = "data-provider-failed")
    public Object[][] dataProviderFailedMethod() {
        return new Object[][]{{"-1", "Please enter an positive integer"},
                {"-200", "Please enter an positive integer"},
                {"sdgdsgsd", "Please enter an integer"}};
    }

    @BeforeClass
    public void before() {
        factRequests = new FactorialRequests();
    }

    @Test(dataProvider = "data-provider-success", priority = 1)
    public void calculateFactorialPositiveAPITest(String number, String result) {
        Response response = factRequests.postRequestFactorial(number);

        assertThat(response.getStatusCode()).isEqualTo(200);
        assertThat(response.jsonPath().getString("answer")).isEqualTo(result);

    }

    @Test(dataProvider = "data-provider-failed", priority = 1)
    public void calculateFactorialNegativeAPITest(String number, String result) {
        Response response = factRequests.postRequestFactorial(number);

        assertThat(response.getStatusCode()).isEqualTo(200);
        assertThat(response.jsonPath().getString("error")).isEqualTo(result);
    }

}
