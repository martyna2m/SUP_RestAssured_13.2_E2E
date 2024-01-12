package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDetails {
    private Boolean status;
    private Student student;

    public StudentDetails(Boolean status, Student student) {
        this.status = status;
        this.student = student;
    }

    public StudentDetails() {
    }

    @Override
    public String toString() {
        return "StudentDetails{" +
                "status='" + status + '\'' +
                ", " + student +
                '}';
    }
}

