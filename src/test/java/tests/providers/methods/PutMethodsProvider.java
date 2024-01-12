package tests.providers.methods;

import models.StudentData;

import static io.restassured.RestAssured.given;

public class PutMethodsProvider extends MethodsProviderBase {

    public void updateStudentData(StudentData studentData) {
        given()
                .spec(requestSpecificationProvider.getRequestSpecificationForGetAndPutWithId(studentData.getId())).when()
                .body(studentData)
                .put()
                .then()
                .spec(responseSpecificationProvider.getResponseSpecificationForGetAndPut());
    }
}
