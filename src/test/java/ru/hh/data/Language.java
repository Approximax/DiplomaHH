package ru.hh.data;

public enum Language {
    RU("Работа найдётся для каждого"),
    EN("There's a job for everyone");

    public final String description;

    Language(String description) {
        this.description = description;
    }
}