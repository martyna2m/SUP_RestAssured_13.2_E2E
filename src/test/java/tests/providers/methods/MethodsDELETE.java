package tests.providers.methods;

import static io.restassured.RestAssured.given;

public class MethodsDELETE extends MethodsProviderBase {

    public void deleteStudent(int id) {
        given()
                .spec(requestSpecificationProvider.getRequestSpecificationWithId(id))
                .when()
                .delete()
                .then()
                .spec(responseSpecificationProvider.getResponseSpecification200());
    }


}
