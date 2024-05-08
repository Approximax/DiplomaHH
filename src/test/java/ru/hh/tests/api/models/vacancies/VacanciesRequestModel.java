package ru.hh.tests.api.models.vacancies;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class VacanciesRequestModel {

    @JsonProperty("vacancy_id")
    String vacancyId;
}
