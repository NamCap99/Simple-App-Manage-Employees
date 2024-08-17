import java.time.LocalDate;
import java.util.List;

public class Intern extends Employee{
    private String Majors;
    private String Semester;
    private String University_name;

    public Intern(String ID, String fullName, LocalDate birthDay, String email, List<Certificate> certificateList, String phone, String majors, String semester, String university_name) {
        super(ID, fullName, birthDay, email, certificateList, phone);
        Majors = majors;
        Semester = semester;
        University_name = university_name;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String semester) {
        Semester = semester;
    }

    public String getUniversity_name() {
        return University_name;
    }

    public void setUniversity_name(String university_name) {
        University_name = university_name;
    }

    public String getMajors() {
        return Majors;
    }

    public void setMajors(String majors) {
        Majors = majors;
    }

    @Override
    public void showInfo(){
        System.out.println("ID: " + getID());
        System.out.println("Full Name: " + getFullName());
        System.out.println("BirthDay: " + getBirthDay());
        System.out.println("Phone: " + getPhone());
        System.out.println("Email: " + getEmail());
        System.out.println("Majors: " + Majors);
        System.out.println("Semester: " + Semester);
        System.out.println("University Name: " + University_name);
    }
}
