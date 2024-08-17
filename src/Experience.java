import java.time.LocalDate;
import java.util.List;

public class Experience extends Employee{
    private int ExpInYear;
    private String ProSkill;

    public Experience(String ID, String fullName, LocalDate birthDay, String email, List<Certificate> certificateList, String phone, int expInYear, String proSkill) {
        super(ID, fullName, birthDay, email, certificateList, phone);
        ExpInYear = expInYear;
        ProSkill = proSkill;
    }

    public Experience(int i, String johnDoe, String date, String number, String mail, int i1, String java) {
    }

    public int getExpInYear() {
        return ExpInYear;
    }

    public void setExpInYear(int expInYear) {
        ExpInYear = expInYear;
    }

    public String getProSkill() {
        return ProSkill;
    }

    public void setProSkill(String proSkill) {
        ProSkill = proSkill;
    }

    @Override
    public void showInfo() {
        System.out.println("ID: " + getID());
        System.out.println("Full Name: " + getFullName());
        System.out.println("BirthDay: " + getBirthDay());
        System.out.println("Phone: " + getPhone());
        System.out.println("Email: " + getEmail());
        System.out.println("Experience In Year: " + ExpInYear);
        System.out.println("Professional Skill: " + ProSkill);
        System.out.println("Certificates: ");
        for (Certificate certificate : certificateList) {
            System.out.println("  Certificate ID: " + certificate.getCertificateID());
            System.out.println("  Certificate Name: " + certificate.getCertificateName());
            System.out.println("  Certificate Rank: " + certificate.getCertificateRank());
            System.out.println("  Certificated Date: " + certificate.getCertificateDate());
        }
    }
}
