package ru.hh.tests.api.models.employers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployerRequestModel {
    String text;
    String area;
}
