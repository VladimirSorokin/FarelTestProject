import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

public class FarelUITests {

    @Test
    public void SignInTest() {
        Selenide.open("https://qa-interview.farel.io/");
    }
}
