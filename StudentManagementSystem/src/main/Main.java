package main;

import dao.StudentDAO;
import model.Student;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {

            System.out.println("\n=== STUDENT MANAGEMENT SYSTEM ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Course: ");
                    String course = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    Student s = new Student(name, age, course, email);
                    dao.addStudent(s);
                    break;

                case 2:
                    List<Student> list = dao.getAllStudents();

                    System.out.println("\n--- STUDENT LIST ---");
                    for (Student st : list) {
                        System.out.println(st.getId() + " | " + st.getName() + " | " +
                                st.getAge() + " | " + st.getCourse() + " | " +
                                st.getEmail());
                    }
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("New Course: ");
                    String newCourse = sc.nextLine();

                    System.out.print("New Email: ");
                    String newEmail = sc.nextLine();

                    dao.updateStudent(id, newCourse, newEmail);
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    int delId = sc.nextInt();
                    sc.nextLine();

                    dao.deleteStudent(delId);
                    break;

                case 5:
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}