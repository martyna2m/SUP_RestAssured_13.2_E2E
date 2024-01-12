package tests.providers;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import models.Student;

import static org.hamcrest.CoreMatchers.not;

public class ResponseSpecificationProvider {


    public ResponseSpecification getResponseSpecification201(Student student) {
        return new ResponseSpecBuilder()
                .expectBody("id", not("0"))
                .build()
                .contentType(ContentType.JSON)
                .statusCode(201);

    }

    public ResponseSpecification getResponseSpecification200() {
        ResponseSpecification responseSpecification = RestAssured.expect();
        responseSpecification.contentType(ContentType.JSON);
        responseSpecification.statusCode(200);
        return responseSpecification;
    }


}
