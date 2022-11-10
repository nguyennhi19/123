package Common;

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
    public static final int NUMBER_OF_LOGIN = 4;
    public static final String MSG_RUN_OUT_OF_TRY_LOGIN = "User can't login and message \"You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.\" appears.";
    public static final String EMAIL_REGISTER = "nhi1246@gmail.com";
    public static final String CONFIRM_PASSWORD = "12345678";
    public static final String CONFIRM_INVALID_PASSWORD = "123456789";
    public static final String PID = "12345678";
    public static String MSG_REGISTER_SUCCESSFULLY = "Thank you for registering your account";
    public static final String MSG_REGISTER_FAILED = "There're errors in the form. Please correct the errors and try again.";
    public static final String MSG_PASSWORD_FIELD = "Invalid password length";
    public static final String MSG_PID_FIELD = "Invalid ID length";
    public static final String MSG_CHANGE_PASSWORD_SUCCESS = "Your password has been updated!";
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
    public static String DEPART_FROM = "Sài Gòn";
    public static String ARRIVE_AT = "Huế";
    public static String MSG_CONTENT_OF_BOOK_TICKET_PAGE = "Book ticket";
    public static final String ErrorPage = "Server Error";

}
