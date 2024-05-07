package ru.hh.tests.api.models.dictionares;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.lang.reflect.Array;
import java.util.List;

@Data
public class LanguagesModel {

    List<Languages> languages;

    @Data
    public static class Languages {
        String id;
        String name;
        String uid;
    }
}
