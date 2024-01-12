package helpers;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class DataFaker {
    private TestDataProvider testDataProvider = new TestDataProvider();
    private Faker faker = new Faker(new Locale("en-US"));
    private FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-US"), new RandomService());



    public String getFakeName() {
        return faker.name().firstName();
    }

    public String getFakeLastName() {
        return faker.name().lastName();
    }

    public String getFakeBirthdate() {
        return generateBirthdate();
    }

    private String generateBirthdate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(testDataProvider.getTestData("dateFormat"));
        return dateFormat.format(faker.date().birthday());

    }


}
