package ru.hh.tests.api.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import ru.hh.helpers.CustomAllureListener;

import static io.restassured.RestAssured.with;

public class HhSpecs {
    public static RequestSpecification requestSpec = with()
            .filter(CustomAllureListener.withCustomTemplates())
            .headers("User-Agent", "QaApp")
            .log().uri()
            .log().method()
            .log().body()
            .log().headers()
            .contentType(ContentType.JSON);

    public static ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .expectStatusCode(200)
            .build();
}
