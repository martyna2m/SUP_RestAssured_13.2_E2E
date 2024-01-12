package helpers;

import models.Student;

public class StudentFactory {
    private DataFaker dataFaker = new DataFaker();
    private TestDataProvider testDataProvider = new TestDataProvider();

    public Student getRandomStudent() {
        return Student.builder()
                .firstName(dataFaker.getFakeName())
                .middleName(dataFaker.getFakeName())
                .lastName(dataFaker.getFakeLastName())
                .dateOfBirth(dataFaker.getFakeBirthdate())
                .build();
    }


    public Student getStudentFromYaml() {
        return Student.builder()
                .firstName(testDataProvider.getTestDataFromSection("student1", "firstName"))
                .middleName(testDataProvider.getTestDataFromSection("student1", "middleName"))
                .lastName(testDataProvider.getTestDataFromSection("student1", "lastName"))
                .dateOfBirth(testDataProvider.getTestDataFromSection("student1", "dateOfBirth"))
                .build();


    }

}
