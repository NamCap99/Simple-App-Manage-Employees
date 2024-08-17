import java.time.LocalDate;
import java.util.List;

public abstract class Employee {
    protected String FullName;
    protected LocalDate BirthDay;
    protected String Email;
    protected String Phone;
    protected List<Certificate> certificateList;
    protected static int employeeCount = 0;
    
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public LocalDate getBirthDay() {
        return BirthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        BirthDay = birthDay;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public List<Certificate> getCertificateList() {
        return certificateList;
    }

    public void setCertificateList(List<Certificate> certificateList) {
        this.certificateList = certificateList;
    }

    protected String ID;

    public Employee() {
        employeeCount++;
    }

    public Employee(String ID, String fullName, LocalDate birthDay, String email, List<Certificate> certificateList, String phone) {
        this.ID = ID;
        FullName = fullName;
        BirthDay = birthDay;
        Email = email;
        this.certificateList = certificateList;
        Phone = phone;
    }

    public abstract void showInfo();
}
