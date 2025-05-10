import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static RegistrationSystem system = new RegistrationSystem();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getIntInput("Enter your choice: ");
            running = processChoice(choice);
        }
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n=== Student Registration System ===");
        System.out.println("1. Add Student");
        System.out.println("2. Add Course");
        System.out.println("3. Enroll Student in Course");
        System.out.println("4. Remove Student from Course");
        System.out.println("5. List Courses for Student");
        System.out.println("6. List Students in Course");
        System.out.println("7. Sort Courses for Student");
        System.out.println("8. Sort Students in Course");
        System.out.println("9. Check if Course is Full");
        System.out.println("10. Check if Student is Normal");
        System.out.println("11. Undo Last Action");
        System.out.println("12. Redo Last Action");
        System.out.println("0. Exit");
    }

    private static boolean processChoice(int choice) {
        switch (choice) {
            case 1:
                addStudent();
                break;
            case 2:
                addCourse();
                break;
            case 3:
                enrollStudent();
                break;
            case 4:
                removeEnrollment();
                break;
            case 5:
                listCoursesByStudent();
                break;
            case 6:
                listStudentsByCourse();
                break;
            case 7:
                sortCoursesByStudent();
                break;
            case 8:
                sortStudentsByCourse();
                break;
            case 9:
                checkCourseCapacity();
                break;
            case 10:
                checkNormalStudent();
                break;
            case 11:
                system.undo();
                break;
            case 12:
                system.redo();
                break;
            case 0:
                System.out.println("Thank you for using the system!");
                return false;
            default:
                System.out.println("Invalid choice! Please try again.");
        }
        return true;
    }

    private static void addStudent() {
        int studentID = getIntInput("Enter student ID: ");
        system.addStudent(studentID);
    }

    private static void addCourse() {
        int courseID = getIntInput("Enter course ID: ");
        system.addCourse(courseID);
    }

    private static void enrollStudent() {
        int studentID = getIntInput("Enter student ID: ");
        int courseID = getIntInput("Enter course ID: ");
        system.enrollStudent(studentID, courseID);
    }

    private static void removeEnrollment() {
        int studentID = getIntInput("Enter student ID: ");
        int courseID = getIntInput("Enter course ID: ");
        system.removeEnrollment(studentID, courseID);
    }

    private static void listCoursesByStudent() {
        int studentID = getIntInput("Enter student ID: ");
        system.listCoursesByStudent(studentID);
    }

    private static void listStudentsByCourse() {
        int courseID = getIntInput("Enter course ID: ");
        system.listStudentsByCourse(courseID);
    }

    private static void sortCoursesByStudent() {
        int studentID = getIntInput("Enter student ID: ");
        system.SortCoursesByID(studentID);
    }

    private static void sortStudentsByCourse() {
        int courseID = getIntInput("Enter course ID: ");
        system.SortStudentsByID(courseID);
    }

    private static void checkCourseCapacity() {
        int courseID = getIntInput("Enter course ID: ");
        boolean isFull = system.isFullCourse(courseID);
        System.out.println("Course " + courseID + " is " + (isFull ? "full" : "not full"));
    }

    private static void checkNormalStudent() {
        int studentID = getIntInput("Enter student ID: ");
        boolean isNormal = system.isNormalStudent(studentID);
        System.out.println("Student " + studentID + " is " + (isNormal ? "a normal student" : "not a normal student"));
    }

    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }
    }
} 