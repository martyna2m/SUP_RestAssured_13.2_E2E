package tests.providers.methods;

import io.restassured.response.Response;
import models.Student;
import models.StudentData;
import models.StudentDetails;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class GetMethodsProvider extends MethodsProviderBase {


    public String getStudentStatus(int id) {
        return getStudentWithIdResponse(id).path("status").toString();
    }

    public StudentDetails getStudentDetails(int id) {
        return new StudentDetails(getStudentStatus(id), getStudentData(id));
    }

    public StudentData getStudentData(int id) {
        HashMap<String, Object> map = getStudentWithIdResponse(id).path("data");
        int studentId = (int) map.get("id");
        map.remove("id");
        Student student = convertHashMapToObject(map, Student.class);
        return new StudentData(student, studentId);

    }

    private Response getStudentWithIdResponse(int id) {
        return given()
                .spec(requestSpecificationProvider.getRequestSpecificationForGetAndPutWithId(id))
                .when()
                .get()
                .then()
                .spec(responseSpecificationProvider.getResponseSpecificationForGetAndPut())
                .extract().response();
    }


}
