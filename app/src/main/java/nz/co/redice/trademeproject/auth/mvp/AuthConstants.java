package nz.co.redice.trademeproject.auth.mvp;

public class AuthConstants {
    public static final String OAUTH_URL = "https://secure.tmsandbox.co.nz/Oauth/";
    public static final String SIGNATURE_METHOD = "PLAINTEXT";
    public static final String HEADER_KEY = "header_key";
    public static final String SCOPE = "MyTradeMeRead,MyTradeMeWrite";

    public static final String USER_AUTHORIZATION_URL = "https://secure.tmsandbox.co.nz/Oauth/Authorize?oauth_token=";

    public static final String CONSUMER_KEY = "30548980993F4C6DBBC29869DB28F1FA";
    public static final String CONSUMER_SECRET = "FC503D3AE07F64E3B9A023C2FF08BA33%26";

    public static final String REQUEST_HEADER = "REQUEST_HEADER";
    public static final String VERIFIER_KEY = "oauth_verifier";
}
