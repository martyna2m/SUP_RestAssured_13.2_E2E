package tests.providers.methods;

import models.Student;

import static io.restassured.RestAssured.given;

public class PostMethodsProvider extends MethodsProviderBase {

    public int createStudentAndGetId(Student studentObject) {
        String stringId = given()
                .spec(requestSpecificationProvider.getRequestSpecificationForPost()).when()
                .body(studentObject)
                .post()
                .then()
                .spec(responseSpecificationProvider.getResponseSpecificationForPost(studentObject))
                .extract().response().path("id").toString();
        return Integer.parseInt(stringId);
    }



}
