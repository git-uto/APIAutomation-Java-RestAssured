package unittests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testdata.GenerateTestData;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GenerateTestDataTests {
    private  GenerateTestData.CreateBookingData createBookingData;
    private SimpleDateFormat dateFormat;

    @BeforeMethod
    public void setup()
    {
        createBookingData =  new GenerateTestData.CreateBookingData();
        dateFormat =  new SimpleDateFormat("yyyy-MM-dd");
    }
    @Test
    void testFirstName() {
        String firstName = createBookingData.firstName();
        Assert.assertNotNull(firstName);
    }
    @Test
    void testLastName ()
    {
        String lastName = createBookingData.lastName();
        Assert.assertNotNull(lastName);
    }
    @Test
    void testIsDepositPaid()
    {
        Boolean isDepositPaid =  createBookingData.isDepositPaid();
        Assert.assertNotNull(isDepositPaid);
    }
    @Test
    void testAdditionalDetails()
    {
        String additionalDetails = createBookingData.additionalDetails();
        Assert.assertNotNull(additionalDetails);
        System.out.println(additionalDetails);
    }
    @Test
    public void testCheckInDateIsFormattedCorrectly() throws ParseException {
        String checkInDate = createBookingData.getCheckingDate();
        Date date = dateFormat.parse(checkInDate);
        String formattedDate = dateFormat.format(date);
        Assert.assertEquals(checkInDate, formattedDate, "Check-in date should be formatted as yyyy-MM-dd");
    }
    @Test
    public void testCheckOUtDateIsFormattedCorrectly() throws ParseException {
        String checkOutDate = createBookingData.getCheckOUtDate();
        Date date =  dateFormat.parse(checkOutDate);
        String formattedDate = dateFormat.format(date);
        Assert.assertEquals(checkOutDate, formattedDate,"Check-out date should be formatted as yyyy-MM-dd");
    }

}

