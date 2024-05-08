package ru.hh.helpers;

import com.github.javafaker.Faker;

public class RandomData {
    Faker faker = new Faker();

    public String getRandomEmployer() {
        return faker.options().option(
                "Яндекс",
                "Тинькофф",
                "2ГИС",
                "HeadHunter",
                "VK"
        );
    }

    public String getRandomArea() {
        return faker.options().option(
                "Санкт-Петербург",
                "Москва",
                "Курск",
                "Барнаул",
                "Тагил"
        );
    }

    public String getRandomId() {
        return String.valueOf(faker.number().numberBetween(1, 100000));
    }
}
