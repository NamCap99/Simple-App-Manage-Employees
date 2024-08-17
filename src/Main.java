import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        Scanner scanner = UserInterface.ScannerFactory.getScanner();

        while (true) {
            System.out.println("Welcome to Employee App: ");
            System.out.println("Press 1: Add");
            System.out.println("Press 2: Delete single employee");
            // System.out.println("Press 3: Edit");
            System.out.println("Press 4: Remove all");
            System.out.println("Press 5: Show all employees");
            System.out.println("Press 6: Show all interns");
            System.out.println("Press 7: Show all experiences");
            System.out.println("Press 8: Show all freshers");
            System.out.println("Press 0: to exit");

            int userInput = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            switch (userInput) {
                case 1:
                    handleAddEmployee(scanner);
                    break;
                case 2:
                    handleDeleteEmployee(scanner, userInterface);
                    break;
                case 3:
                    System.out.println("Edit functionality is not implemented yet.");
                    break;
                case 4:
                    handleRemoveAllEmployees(userInterface);
                    break;
                case 5:
                    handleShowAllEmployees(userInterface);
                    break;
                case 6:
                    handleShowAllInterns(userInterface);
                    break;
                case 7:
                    handleShowAllExperiences(userInterface);
                    break;
                case 8:
                    handleShowAllFreshers(userInterface);
                    break;
                case 0:
                    System.out.println("Exiting the application.");
                    return;
                default:
                    System.out.println("Invalid input, please try again.");
            }
        }
    }

    private static void handleAddEmployee(Scanner scanner) {
        System.out.println("Add Employee");
        System.out.println("Press 0: Experience");
        System.out.println("Press 1: Fresher");
        System.out.println("Press 2: Internship");
        int type = scanner.nextInt();
        scanner.nextLine(); // consume the newline
        UserInterface.add(type);
    }

    private static void handleDeleteEmployee(Scanner scanner, UserInterface userInterface) {
        System.out.println("Enter the ID of the employee to delete: ");
        String idToDelete = scanner.nextLine();
        userInterface.employeeManagement.removeEmployee(idToDelete);
    }

    private static void handleRemoveAllEmployees(UserInterface userInterface) {
        System.out.println("Removing all employees.");
        userInterface.employeeManagement = new EmployeeManagement();
    }

    private static void handleShowAllEmployees(UserInterface userInterface) {
        System.out.println("Showing all employees:");
        userInterface.employeeManagement.showAllEmployees();
    }

    private static void handleShowAllInterns(UserInterface userInterface) {
        System.out.println("Showing all interns:");
        userInterface.employeeManagement.findAllInterns().forEach(Employee::showInfo);
    }

    private static void handleShowAllExperiences(UserInterface userInterface) {
        System.out.println("Showing all experiences:");
        userInterface.employeeManagement.findAllExperiences().forEach(Employee::showInfo);
    }

    private static void handleShowAllFreshers(UserInterface userInterface) {
        System.out.println("Showing all freshers:");
        userInterface.employeeManagement.findAllFreshers().forEach(Employee::showInfo);
    }
}
