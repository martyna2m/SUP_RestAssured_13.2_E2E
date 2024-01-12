package tests.e2eTests;

import models.Student;
import models.StudentDetails;
import org.junit.jupiter.api.Test;
import tests.base.TestBase;

public class StudentsDetailsTest extends TestBase {
    Student studentObject;
    StudentDetails expectedStudentDetails;
    StudentDetails actualStudentDetails;


    @Test
    void shouldTestStudentDetailsApi() {

        studentObject = studentFactory.getRandomStudent();

        //POST
        int id = methodsPOST.createStudentAndGetId(studentObject);
        expectedStudentDetails = new StudentDetails(true, studentObject);

        //GET
        actualStudentDetails = methodsGET.getStudentDetails(id);
        softAssertions.assertThat(actualStudentDetails.getStatus()).as("Checking if student exists").isEqualTo(true);

        //PUT
        studentObject.setMiddle_name(dataFaker.getFakeName());
        methodsPUT.updateStudentData(studentObject);


        //GET
        actualStudentDetails = methodsGET.getStudentDetails(id);
        softAssertions.assertThat(actualStudentDetails.getStudent().getMiddle_name())
                .as("Checking if middle name has been updated correctly")
                .isEqualTo(studentObject.getMiddle_name());

        //DELETE



        //GET


        softAssertions.assertAll();


    }


}
