package configuration;

public class UrlProvider {
    public static String getCartUrl() {
        return System.getProperty("web url") + System.getProperty("cart url part");
    }
}
