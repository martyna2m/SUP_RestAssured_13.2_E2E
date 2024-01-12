package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDetails {
    private String status;
    private StudentData data;

    public StudentDetails(String status, StudentData data) {
        this.status = status;
        this.data = data;
    }

    public StudentDetails() {
    }

    @Override
    public String toString() {
        return "StudentDetails{" +
                "status='" + status + '\'' +
                ", data=" + data +
                '}';
    }
}

