package service;

import model.SchoolClass;
import model.Student;

public class SchoolServiceFull extends SchoolServiceBasic implements SchoolService {

    @Override
    public void generateOutput() {

        for (SchoolClass schoolClass : classes) {
            System.out.println("\n######################################");
            System.out.println("Třída: " + schoolClass.getDescription()
                    + " (ročník: " + schoolClass.getGrade() + ")");
            System.out.println("Třídní učitel: " + schoolClass.getTeacher().getName()
                    + ", " + schoolClass.getTeacher().getSurname()
                    + " (" + schoolClass.getTeacher().getAcademicDegree() + ")");
            System.out.println("Počet studentů: " + schoolClass.getStudents().size());
            System.out.println("\n======================================");

            int index = 0;
            for (Student student : schoolClass.getStudents())
                System.out.println("# " + ++index + " # "
                        + student.getFormattedId() + " - "
                        + student.getNameSurname() + " ("
                        + student.getDateOfBirth().getYear() + ")");

        }

    }

}

