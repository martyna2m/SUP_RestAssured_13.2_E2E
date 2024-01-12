package tests.studentDetailsTests;

import models.Student;
import models.StudentDetails;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.base.TestBase;

public class End2EndTest extends TestBase {
    Student studentObject;
    StudentDetails expectedStudentDetails;
    StudentDetails actualStudentDetails;


    @Test
    void shouldTestStudentDetailsApi() {

        studentObject = studentFactory.getRandomStudent();

        //POST
        methodsPOST.createStudent(studentObject);
        expectedStudentDetails = new StudentDetails(true, studentObject);


        //GET
        actualStudentDetails = methodsGET.getStudentDetails(studentObject.getId());
        Assertions.assertThat(actualStudentDetails.getStatus()).isEqualTo(true);

        //PUT
        studentObject.setMiddle_name(dataFaker.getFakeName());
        methodsPUT.updateStudentData(studentObject);


        //GET
        actualStudentDetails = methodsGET.getStudentDetails(studentObject.getId());
        Assertions.assertThat(actualStudentDetails.getStudent().getMiddle_name())
                .isEqualTo(studentObject.getMiddle_name());

        //DELETE
        methodsDELETE.deleteStudent(studentObject.getId());


        //GET
        actualStudentDetails = methodsGET.getStudentDetails(studentObject.getId());
        Assertions.assertThat(actualStudentDetails.getStatus()).isEqualTo(false);


    }


}
