package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
    private String first_name;
    private String middle_name;
    private String last_name;
    private String date_of_birth;


    @Override
    public String toString() {
        return "Student{firstName='" + first_name + '\'' +
                ", middleName='" + middle_name + '\'' +
                ", lastName='" + last_name + '\'' +
                ", dateOfBirth='" + date_of_birth + '\'' +
                '}';
    }

    public Student() {
    }

    public static Builder builder() {
        return new Builder();
    }


    public static final class Builder {
        private String first_name;
        private String middle_name;
        private String last_name;
        private String date_of_birth;


        public Builder firstName(String firstName) {
            this.first_name = firstName;
            return this;
        }

        public Builder middleName(String middleName) {
            this.middle_name = middleName;
            return this;
        }


        public Builder lastName(String lastName) {
            this.last_name = lastName;
            return this;
        }

        public Builder dateOfBirth(String dateOfBirth) {
            this.date_of_birth = dateOfBirth;
            return this;
        }

        public Student build() {
            Student student = new Student();
            student.first_name = this.first_name;
            student.middle_name = this.middle_name;
            student.last_name = this.last_name;
            student.date_of_birth = this.date_of_birth;
            return student;
        }

    }
}
