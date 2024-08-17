import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeManagement {
    private List<Employee> employees;

    public EmployeeManagement() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee emp) {
        employees.add(emp);
    }

    public void removeEmployee(String id) {
        employees.removeIf(employee -> employee.getID().equals(id));
    }

    public Optional<Employee> findEmployeeById(String id) {
        return employees.stream()
                .filter(employee -> employee.getID().equals(id))
                .findFirst();
    }

    public List<Employee> findEmployeesByType(int employeeType) {
        return this.employees.stream().filter(
                employee -> {
                    if (employeeType == 0) {
                        return employee instanceof Experience;
                    }
                    if (employeeType == 1) {
                        return employee instanceof Fresher;
                    }
                    if (employeeType == 2) {
                        return employee instanceof Intern;
                    }
                    return false;
                }
        ).collect(Collectors.toList());
    }

    public List<Intern> findAllInterns() {
        return employees.stream()
                .filter(Intern.class::isInstance)
                .map(Intern.class::cast)
                .collect(Collectors.toList());
    }

    public List<Experience> findAllExperiences() {
        return employees.stream()
                .filter(Experience.class::isInstance)
                .map(Experience.class::cast)
                .collect(Collectors.toList());
    }

    public List<Fresher> findAllFreshers() {
        return employees.stream()
                .filter(Fresher.class::isInstance)
                .map(Fresher.class::cast)
                .collect(Collectors.toList());
    }

    public List<Employee> findAll() {
        return this.employees;
    }

    public void showAllEmployees() {
        for (Employee employee : employees) {
            employee.showInfo();
        }
    }

//    private void check(Employee employee) throws BirthDayException, PhoneException, EmailException, FullNameException {
//        ValidatorService.birthdayCheck(employee.getBirthDay());
//        ValidatorService.phoneCheck(employee.getPhone());
//        ValidatorService.emailCheck(employee.getEmail());
//        ValidatorService.nameCheck(employee.getFullName());
//    }
}
