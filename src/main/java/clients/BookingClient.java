package clients;

import configs.EndPointReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import testdata.GenerateTestData;

import java.util.Properties;
import java.util.logging.Logger;

public class BookingClient {
    private static final Logger logger = Logger.getLogger(BookingClient.class.getName());
    private static final EndPointReader endPointReader = EndPointReader.getInstance();
    private static final Properties endPointReaderProperties = endPointReader.getProperties();
    private static final String FIRSTNAME_KEY = "firstname";
    private static final String LASTNAME_KEY = "lastname";
    private static final String TOTAL_PRICE_KEY = "totalprice";
    private static final String DEPOSIT_PAID_KEY = "depositpaid";
    private static final String CHECK_IN_KEY = "checkin";
    private static final String CHECK_OUT_KEY = "checkout";
    private static final String ADDITIONAL_NEEDS_KEY = "additionalneeds";
    private static final String createBookingEndpoint = endPointReaderProperties.getProperty("createBookingEndpoint");

    private String firstName;
    private String lastName;
    private int totalPrice;
    private boolean depositPaid;
    private String checkin;
    private String checkout;
    private String additionalNeeds;


    public BookingClient() {
        this(GenerateTestData.CreateBookingData.firstName(), GenerateTestData.CreateBookingData.lastName(), GenerateTestData.CreateBookingData.totalPrice(), GenerateTestData.CreateBookingData.isDepositPaid(), GenerateTestData.CreateBookingData.getCheckingDate(), GenerateTestData.CreateBookingData.getCheckOUtDate(), GenerateTestData.CreateBookingData.additionalDetails());
    }

    public BookingClient(String firstName, String lastName, int totalPrice, boolean depositPaid, String checkin, String checkout, String additionalNeeds) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.totalPrice = totalPrice;
        this.depositPaid = depositPaid;
        this.checkin = checkin;
        this.checkout = checkout;
        this.additionalNeeds = additionalNeeds;
    }

    private JSONObject createBookingPayload() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(FIRSTNAME_KEY, firstName);
        jsonObject.put(LASTNAME_KEY, lastName);
        jsonObject.put(TOTAL_PRICE_KEY, totalPrice);
        jsonObject.put(DEPOSIT_PAID_KEY, depositPaid);
        jsonObject.put(CHECK_IN_KEY, checkin);
        jsonObject.put(CHECK_OUT_KEY, checkout);
        jsonObject.put(ADDITIONAL_NEEDS_KEY, additionalNeeds);
        return jsonObject;

    }
    public Response createBooking ()
    {
        return RestAssured.given()
                .body(createBookingPayload())
                .post(createBookingEndpoint);
    }
}
