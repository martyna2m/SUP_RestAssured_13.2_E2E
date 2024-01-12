package tests.e2eTests;

import models.Student;
import models.StudentData;
import models.StudentDetails;
import org.junit.jupiter.api.Test;
import tests.base.TestBase;

public class StudentsDetailsTest extends TestBase {
    Student studentObject;

    StudentData expectedStudentData;
    StudentDetails expectedStudentDetails;
    StudentDetails actualStudentDetails;

    @Test
    void shouldTestStudentDetailsApi() {

        studentObject = studentFactory.getRandomStudent();

        //POST
        int id = postMethodsProvider.createStudentAndGetId(studentObject);
        expectedStudentData = new StudentData(studentObject, id);

        //GET
        String status = getMethodsProvider.getStudentStatus(id);
        expectedStudentDetails = new StudentDetails(status, expectedStudentData);
        actualStudentDetails = getMethodsProvider.getStudentDetails(id);

        softAssertions.assertThat(status).as("Checking if student exists").isEqualTo("true");

        //PUT

        studentObject.setMiddle_name(dataFaker.getFakeName());
        putMethodsProvider.updateStudentData(expectedStudentData);


        //GET
        actualStudentDetails = getMethodsProvider.getStudentDetails(id);
        System.out.println(actualStudentDetails);
        //   softAssertions.assertThat(actualStudentDetails.getData().getStudent().getMiddle_name())
        //     .as("Checking if middle name was updated correctly")
        //     .isEqualTo(studentObject.getMiddle_name());

        //DELETE

        //GET


        softAssertions.assertAll();


    }


}
