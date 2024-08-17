import java.util.Optional;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class UserInterface {

    static EmployeeManagement employeeManagement = new EmployeeManagement();

    public static void add(int type) {
        Employee employee = null;

        if (type == 0) {
            employee = addExperience();
        } else if (type == 1) {
            employee = addFresher();
        } else if (type == 2) {
            employee = addIntern();
        }

        try {
            check(employee);
            employeeManagement.addEmployee(employee);
        } catch (BirthDayException | EmailException | FullNameException | PhoneException e) {
            System.err.println("Validation error: " + e.getMessage());
            add(type);
        }
    }

    private static Experience addExperience() {
        Scanner scanner = ScannerFactory.getScanner();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.print("Input ID: ");
        String id = scanner.nextLine();
        System.out.print("Input Name: ");
        String name = scanner.nextLine();
        System.out.print("Input BirthDay (dd-MM-yyyy): ");
        LocalDate birthDay = LocalDate.parse(scanner.nextLine(), formatter);
        System.out.print("Input Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Input Email: ");
        String email = scanner.nextLine();
        System.out.print("Input Years of Experience: ");
        int expInYear = Integer.parseInt(scanner.nextLine());
        System.out.print("Input Professional Skill: ");
        String proSkill = scanner.nextLine();

        List<Certificate> certificateList = new ArrayList<>(); // Assuming you collect certificate data here

        return new Experience(id, name, birthDay, email, certificateList, phone, expInYear, proSkill);
    }

    private static Fresher addFresher() {
        Scanner scanner = ScannerFactory.getScanner();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.print("Input ID: ");
        String id = scanner.nextLine();
        System.out.print("Input Name: ");
        String name = scanner.nextLine();
        System.out.print("Input BirthDay (dd-MM-yyyy): ");
        LocalDate birthDay = LocalDate.parse(scanner.nextLine(), formatter);
        System.out.print("Input Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Input Email: ");
        String email = scanner.nextLine();
        System.out.print("Input Graduation Date (dd-MM-yyyy): ");
        LocalDate graduationDate = LocalDate.parse(scanner.nextLine(), formatter);
        System.out.print("Input Graduation Rank: ");
        String graduationRank = scanner.nextLine();
        System.out.print("Input Education: ");
        String education = scanner.nextLine();

        List<Certificate> certificateList = new ArrayList<>(); // Assuming you collect certificate data here

        return new Fresher(id, name, birthDay, email, certificateList, phone, education, graduationRank, graduationDate);
    }

    private static Intern addIntern() {
        Scanner scanner = ScannerFactory.getScanner();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.print("Input ID: ");        System.out.print("Input Name: ");
        String name = scanner.nextLine();
        System.out.print("Input BirthDay (dd-MM-yyyy): ");
        LocalDate birthDay = LocalDate.parse(scanner.nextLine(), formatter);
        System.out.print("Input Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Input Email: ");
        String email = scanner.nextLine();
        System.out.print("Input Majors: ");
        String majors = scanner.nextLine();
        System.out.print("Input Semester: ");
        String semester = scanner.nextLine();
        System.out.print("Input University Name: ");
        String universityName = scanner.nextLine();
        String id = scanner.nextLine();


        List<Certificate> certificateList = new ArrayList<>(); // Assuming you collect certificate data here

        return new Intern(id, name, birthDay, email, certificateList, phone, majors, semester, universityName);
    }

    public static void editEmployee(String id) {
        Scanner scanner = ScannerFactory.getScanner();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        Optional<Employee> employeeOptional = employeeManagement.findEmployeeById(id);

        if (!employeeOptional.isPresent()) {
            System.out.println("Employee not found with ID: " + id);
            return;
        }

        Employee employee = employeeOptional.get();

        System.out.print("Input new Name (current: " + employee.getFullName() + "): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) {
            employee.setFullName(name);
        }

        System.out.print("Input new BirthDay (dd-MM-yyyy) (current: " + employee.getBirthDay() + "): ");
        String birthDayStr = scanner.nextLine();
        if (!birthDayStr.isEmpty()) {
            LocalDate birthDay = LocalDate.parse(birthDayStr, formatter);
            employee.setBirthDay(birthDay);
        }

        System.out.print("Input new Phone (current: " + employee.getPhone() + "): ");
        String phone = scanner.nextLine();
        if (!phone.isEmpty()) {
            employee.setPhone(phone);
        }

        System.out.print("Input new Email (current: " + employee.getEmail() + "): ");
        String email = scanner.nextLine();
        if (!email.isEmpty()) {
            employee.setEmail(email);
        }

        if (employee instanceof Experience) {
            Experience experience = (Experience) employee;
            System.out.print("Input new Years of Experience (current: " + experience.getExpInYear() + "): ");
            String expInYearStr = scanner.nextLine();
            if (!expInYearStr.isEmpty()) {
                int expInYear = Integer.parseInt(expInYearStr);
                experience.setExpInYear(expInYear);
            }

            System.out.print("Input new Professional Skill (current: " + experience.getProSkill() + "): ");
            String proSkill = scanner.nextLine();
            if (!proSkill.isEmpty()) {
                experience.setProSkill(proSkill);
            }
        } else if (employee instanceof Fresher) {
            Fresher fresher = (Fresher) employee;
            System.out.print("Input new Graduation Date (dd-MM-yyyy) (current: " + fresher.getGraduate_date() + "): ");
            String graduationDateStr = scanner.nextLine();
            if (!graduationDateStr.isEmpty()) {
                LocalDate graduationDate = LocalDate.parse(graduationDateStr, formatter);
                fresher.setGraduate_date(graduationDate);
            }

            System.out.print("Input new Graduation Rank (current: " + fresher.getGraduate_rank() + "): ");
            String graduationRank = scanner.nextLine();
            if (!graduationRank.isEmpty()) {
                fresher.setGraduate_rank(graduationRank);
            }

            System.out.print("Input new Education (current: " + fresher.getEducation() + "): ");
            String education = scanner.nextLine();
            if (!education.isEmpty()) {
                fresher.setEducation(education);
            }
        } else if (employee instanceof Intern) {
            Intern intern = (Intern) employee;
            System.out.print("Input new Majors (current: " + intern.getMajors() + "): ");
            String majors = scanner.nextLine();
            if (!majors.isEmpty()) {
                intern.setMajors(majors);
            }

            System.out.print("Input new Semester (current: " + intern.getSemester() + "): ");
            String semester = scanner.nextLine();
            if (!semester.isEmpty()) {
                intern.setSemester(semester);
            }

            System.out.print("Input new University Name (current: " + intern.getUniversity_name() + "): ");
            String universityName = scanner.nextLine();
            if (!universityName.isEmpty()) {
                intern.setUniversity_name(universityName);
            }
        }

        try {
            check(employee);
        } catch (BirthDayException | EmailException | FullNameException | PhoneException e) {
            System.err.println("Validation error: " + e.getMessage());
            editEmployee(id);
        }
    }

    private static void check(Employee employee) throws BirthDayException, PhoneException, EmailException, FullNameException {
        ValidatorService.birthdayCheck(employee.getBirthDay());
        ValidatorService.phoneCheck(employee.getPhone());
        ValidatorService.emailCheck(employee.getEmail());
        ValidatorService.nameCheck(employee.getFullName());
    }

    public static class ValidatorService {

        public static void birthdayCheck(LocalDate birthDay) throws BirthDayException {
            if (birthDay == null || birthDay.isAfter(LocalDate.now())) {
                throw new BirthDayException("Birth date cannot be in the future or null");
            }
        }

        public static void phoneCheck(String phone) throws PhoneException {
            if (!Pattern.matches("\\d{10}", phone)) {
                throw new PhoneException("Phone number must be 10 digits");
            }
        }

        public static void emailCheck(String email) throws EmailException {
            if (!Pattern.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", email)) {
                throw new EmailException("Invalid email format");
            }
        }

        public static void nameCheck(String fullName) throws FullNameException {
            if (fullName == null || fullName.trim().isEmpty()) {
                throw new FullNameException("Full name cannot be empty");
            }
        }
    }

    public static class ScannerFactory {

        private static Scanner SCANNER;

        public static Scanner getScanner() {
            if (SCANNER == null) {
                SCANNER = new Scanner(System.in);
            }
            return SCANNER;
        }
    }
}
