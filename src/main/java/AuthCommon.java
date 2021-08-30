

public class AuthCommon {
    protected String user = "qa";
    protected String pass = "sanfrancisco!";
    protected String factorialUrl = "qa-interview.farel.io";

    public String getURl() {
        return "https://" + user + ":" + pass + "@" + factorialUrl;
    }



}
