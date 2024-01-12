package tests.providers.methods;

import io.restassured.response.Response;
import models.Student;
import models.StudentDetails;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class MethodsGET extends MethodsProviderBase {


    public StudentDetails getStudentDetails(int id) {
        return new StudentDetails(getStudentStatus(id), getStudentData(id));
    }

    private Boolean getStudentStatus(int id) {
        return Boolean.valueOf(getStudentWithIdResponse(id).path("status").toString());
    }

    private Student getStudentData(int id) {
        HashMap<String, Object> map = getStudentWithIdResponse(id).path("data");
        return convertHashMapToObject(map, Student.class);
    }

    private Response getStudentWithIdResponse(int id) {
        return given()
                .spec(requestSpecificationProvider.getRequestSpecificationWithId(id))
                .when()
                .get()
                .then()
                .spec(responseSpecificationProvider.getResponseSpecification200())
                .extract().response();

    }


}
