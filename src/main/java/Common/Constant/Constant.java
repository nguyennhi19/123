package Common.Constant;

import org.openqa.selenium.WebDriver;

public class Constant {

    public static WebDriver driver;
    public static final String RAILWAY_URL = "http://www.railwayb2.somee.com/Page/HomePage.cshtml";
    public static final String EMAIL = "nhi123@gmail.com";
    public static final String PASSWORD = "12345678";
    public static String MSG_WELCOME_USER = "Welcome %s";
    public static final String INVALID_PASSWORD = "1";
    public static final String MSG_PROBLEM_WITH_LOGIN = "There was a problem with your login and/or errors exist in your form.";
    public static final String MSG_INVALID_USERNAME_PASSWORD = "Invalid username or password. Please try again.";
    public static String VALID_DEPART_DATE = "11/15/2022";
    public static String VALID_DEPART_From = "Huế";
    public static String VALID_ARRIVE_AT = "Sài Gòn";
    public static String ARRIVE_AT_DUPLICATE_WITH_DEPART_FROM = "Huế";
    public static String ARRIVE_AT_TICKET_NO_SUPPORT = "Phan Thiết";
    public static String VALID_SEAT = "Hard seat";
    public static String VALID_AMOUNT_TICKET = "1";
    public static String MAX_AMOUNT_TICKET = "10";
    public static String SUCCESSFULLY_TITLE = "Ticket Booked Successfully!";
    public static String ERROR_MESSAGE_TRAIN_NO_SUPPORT = "This ticket no support on this day";
    public static String ERROR_MESSAGE_ARRIVE_AT_DUPLICATE_WITH_DEPART_FROM = "Depart and Arrive stations can't be the same.";
    public static String ERROR_MESSAGE_WHEN_BOOK_10_TICKET = "You have booked 10 tickets. You can book no more.";

}
