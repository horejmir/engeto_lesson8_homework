import model.SchoolClass;
import model.Student;
import model.Teacher;
import service.SchoolService;
import service.SchoolServiceBasic;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Teacher teacher = new Teacher("Jan", "Novák", "Mgr.");

        Student student1 = new Student("Petr", "Svoboda", LocalDate.of(2011, 1, 3), 1);
        Student student2 = new Student("Milan", "Říha", LocalDate.of(2010, 9, 27), 123);
        Student student3 = new Student("Jindřich", "Nový", LocalDate.of(2012, 2, 3), 345);

        SchoolClass schoolClass = new SchoolClass("4.C", 4, teacher, List.of(student1, student2, student3));

        SchoolService service = new SchoolServiceBasic();
        service.addSchoolCLass(schoolClass);
        service.generateOutput();



    }
}
