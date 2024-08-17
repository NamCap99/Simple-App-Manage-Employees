import java.time.LocalDate;
import java.util.List;

public class Fresher extends Employee{
    private LocalDate Graduate_date;
    private String Graduate_rank;
    private String Education;

    public Fresher(String ID, String fullName, LocalDate birthDay, String email, List<Certificate> certificateList, String phone, String education, String graduate_rank, LocalDate graduate_date) {
        super(ID, fullName, birthDay, email, certificateList, phone);
        Education = education;
        Graduate_rank = graduate_rank;
        Graduate_date = graduate_date;
    }

    public String getEducation() {
        return Education;
    }

    public void setEducation(String education) {
        Education = education;
    }

    public LocalDate getGraduate_date() {
        return Graduate_date;
    }

    public void setGraduate_date(LocalDate graduate_date) {
        Graduate_date = graduate_date;
    }

    public String getGraduate_rank() {
        return Graduate_rank;
    }

    public void setGraduate_rank(String graduate_rank) {
        Graduate_rank = graduate_rank;
    }

    public void showInfo() {
        System.out.println("ID: " + getID());
        System.out.println("Full Name: " + getFullName());
        System.out.println("BirthDay: " + getBirthDay());
        System.out.println("Phone: " + getPhone());
        System.out.println("Email: " + getEmail());
        System.out.println("Graduation Date: " + Graduate_date);
        System.out.println("Graduation Rank: " + Graduate_rank);
        System.out.println("Education: " + Education);
    }
}
