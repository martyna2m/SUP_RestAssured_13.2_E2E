package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentData {
    private Student student;
    private int id;

    public StudentData(Student student, int id) {
        this.student = student;
        this.id = id;
    }

    public StudentData() {
    }

    @Override
    public String toString() {
        return "StudentData{" + student +
                ", id=" + id +
                '}';
    }
}
