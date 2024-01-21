package testdata;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class GenerateTestData {

    public static class CreateBookingData {
        private final Faker faker;
        private final SimpleDateFormat dateFormat;


        public CreateBookingData() {
            dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            faker = new Faker();
        }

        public String firstName() {
            return faker.name().firstName();
        }

        public String lastName() {
            return faker.name().lastName();
        }

        public boolean isDepositPaid() {
            return faker.bool().bool(); // Returns Random True or False.
        }

        public String getCheckingDate() {
            Date date = faker.date().future(365, TimeUnit.DAYS);
            return dateFormat.format(date);
        }

        public String getCheckOUtDate() {
            Date date = faker.date().future(365, TimeUnit.DAYS);
            return dateFormat.format(date);
        }

        public String additionalDetails() {
            return faker.lorem().sentence();
        }
    }


}
