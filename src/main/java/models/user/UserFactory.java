package models.user;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.Locale;
import java.util.Random;

public class UserFactory {

    private static String fakerLanguage = System.getProperty("faker language");

    private static FakeValuesService fakeValuesService;
    private static Faker faker;

    public static User getAlreadyRegisteredUser() {
        return new UserBuilder()
                .socialTitle(SocialTitle.valueOf(System.getProperty("user social title")))
                .firstName(System.getProperty("user first name"))
                .lastName(System.getProperty("user last name"))
                .email(System.getProperty("user email"))
                .password(System.getProperty("user password"))
                .build();
    }

    public static User getRandomUser() {
        initFaker();
        return new UserBuilder()
                .socialTitle(getRandomSocialTitle())
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(fakeValuesService.bothify("????##@test.com"))
                .password(fakeValuesService.regexify("[a-z1-9]{8}"))
                .build();
    }

    private static void initFaker() {
        fakeValuesService = new FakeValuesService(
                new Locale(fakerLanguage), new RandomService());
        faker = new Faker(new Locale(fakerLanguage));
    }

    private static SocialTitle getRandomSocialTitle() {
        return SocialTitle.values()[new Random().nextInt(SocialTitle.values().length)];
    }
}
