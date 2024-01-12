package tests.providers.methods;

import models.Student;

import static io.restassured.RestAssured.given;

public class MethodsPUT extends MethodsProviderBase {

    public void updateStudentData(Student student) {
        given()
                .spec(requestSpecificationProvider.getRequestSpecificationForGetAndPutWithId(student.getId())).when()
                .body(student)
                .put()
                .then()
                .spec(responseSpecificationProvider.getResponseSpecificationForGetAndPut());
    }
}
