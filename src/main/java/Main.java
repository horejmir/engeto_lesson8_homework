import model.SchoolClass;
import model.Student;
import model.Teacher;
import service.SchoolService;
import service.SchoolServiceBasic;
import service.SchoolServiceFull;
import service.SchoolServiceJSON;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //test data
        Teacher teacher1 = new Teacher("Jan", "Novák", "Mgr.");
        Student student1 = new Student("Petr", "Svoboda", LocalDate.of(2011, 1, 3), 1);
        Student student2 = new Student("Milan", "Říha", LocalDate.of(2010, 9, 27), 123);
        Student student3 = new Student("Jindřich", "Nový", LocalDate.of(2012, 2, 3), 345);
        SchoolClass schoolClass1 = new SchoolClass("4.C", 4, teacher1, List.of(student1, student2, student3));

        //select implementatiton by user
        Scanner input = new Scanner(System.in);
        int implSelected = 1;
        boolean continueInput = true;

        System.out.println("Implementation of SchoolService:");
        System.out.println("\t1: SchoolServiceBasic - short output to console");
        System.out.println("\t2: SchoolServiceFull - detailed output to console");
        System.out.println("\t3: SchoolServiceJSON - output to JSON file");

        do {
            try{
                System.out.print("Choose implementation: ");
                implSelected = input.nextInt();

                if(implSelected > 0 && implSelected < 4)
                    continueInput = false;
                else
                    System.out.println("\tTry again. (Incorrect selection: 1 - 3 is required)");
            }
            catch (InputMismatchException ex) {
                System.out.println("\tTry again. (Incorrect input: an integer is required)");
                input.nextLine();
            }
        }
        while (continueInput);


        //create instance of selected implementation
        SchoolService service;

        if (implSelected == 2)
            service = new SchoolServiceFull();
        else if (implSelected == 3)
            service = new SchoolServiceJSON("output.json");
        else
            service = new SchoolServiceBasic();

        System.out.println("\tSelected implementation: " + implSelected + " -> '" + service.getClass().getName() + "'\n");


        //import data and generate output
        if (service instanceof SchoolServiceJSON) {
            ((SchoolServiceJSON) service).importFromFile("input.json");
        }

        service.addSchoolCLass(schoolClass1);
        service.generateOutput();
    }
}
