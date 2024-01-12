package tests.providers.methods;

import models.Student;

import static io.restassured.RestAssured.given;

public class MethodsPOST extends MethodsProviderBase {

    public void createStudent(Student studentObject) {
        String stringId = given()
                .spec(requestSpecificationProvider.getRequestSpecification()).when()
                .body(studentObject)
                .post()
                .then()
                .spec(responseSpecificationProvider.getResponseSpecification201(studentObject))
                .extract().response().path("id").toString();

        int id = Integer.parseInt(stringId);
        studentObject.setId(id);

    }


}
