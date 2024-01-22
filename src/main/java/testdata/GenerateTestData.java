package testdata;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class GenerateTestData {

    public static class CreateBookingData {
        private static Faker faker = new Faker();
        private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


        public CreateBookingData() {
            //dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            //faker = new Faker();
        }

        public static String firstName() {
            return faker.name().firstName();
        }
        public static int totalPrice()
        {
            return faker.number().randomDigit();
        }

        public static String lastName() {
            return faker.name().lastName();
        }

        public static boolean isDepositPaid() {
            return faker.bool().bool(); // Returns Random True or False.
        }

        public static String getCheckingDate() {
            Date date = faker.date().future(365, TimeUnit.DAYS);
            return dateFormat.format(date);
        }

        public static String getCheckOUtDate() {
            Date date = faker.date().future(365, TimeUnit.DAYS);
            return dateFormat.format(date);
        }

        public static String additionalDetails() {
            return faker.lorem().sentence();
        }
    }


}
