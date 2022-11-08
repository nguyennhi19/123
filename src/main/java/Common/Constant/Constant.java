package Common.Constant;

import org.openqa.selenium.WebDriver;

public class Constant {

    public static WebDriver driver;
    public static final String RAILWAY_URL = "http://www.railwayb2.somee.com/Page/HomePage.cshtml";
    public static final String USERNAME = "nhi12@gmail.com";
    public static final String PASSWORD = "12345678";
    public static String MSG_WELCOME_USER = "Welcome %s";
    public static final String INVALID_PASSWORD = "1";
    public static final String MSG_PROBLEM_WITH_LOGIN = "There was a problem with your login and/or errors exist in your form.";
    public static final String MSG_INVALID_USERNAME_PASSWORD = "Invalid username or password. Please try again.";
    public static String VALID_DEPART_DATE = "11/10/2022";
    public static String INVALID_DEPART_DATE = "11/1/2022";
    public static String EMPTY_DEPART_DATE = "";
    public static String VALID_DEPART_From = "Huế";
    public static String EMPTY_DEPART_From = "";
    public static String VALID_ARRIVE_AT = "Sài Gòn";
    public static String EMPTY_ARRIVE_AT = "";
    public static String ARRIVE_AT_DUPLICATE_WITH_DEPART_FROM = "Sài Gòn";
    public static String ARRIVE_AT_TICKET_NO_SUPPORT = "Phan Thiết";
    public static String VALID_SEAT = "Hard seat";
    public static String EMPTY_SEAT = "";
    public static String VALID_AMOUNT_TICKET = "1";
    public static String MAX_AMOUNT_TICKET = "10";
    public static String MORE_THAN_MAX_AMOUNT_TICKET = "11";
    public static String LESS_THAN_MAX_AMOUNT_TICKET = "-1";


}
