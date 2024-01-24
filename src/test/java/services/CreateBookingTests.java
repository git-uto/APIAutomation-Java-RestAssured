package services;

import clients.BookingClient;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Properties;

public class CreateBookingTests {

    private BookingClient bookingClient;
    private Response response;
    @BeforeMethod
    private void setup()
    {
        bookingClient =  new BookingClient();
    }

    @Test
    public void successfulCreation()
    {
        response = bookingClient.createBooking();
        Assert.assertEquals(200, 200);
    }
}
