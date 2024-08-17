import java.time.LocalDate;

public class Certificate {

    protected String CertificateID;
    protected String CertificateName;
    protected String CertificateRank;
    protected LocalDate CertificateDate;

    public Certificate(String certificateID, String certificateName, LocalDate certificateDate,
            String certificateRank) {
        CertificateID = certificateID;
        CertificateName = certificateName;
        CertificateDate = certificateDate;
        CertificateRank = certificateRank;
    }

    public Certificate() {

    }

    public String getCertificateName() {
        return CertificateName;
    }

    public void setCertificateName(String certificateName) {
        CertificateName = certificateName;
    }

    public String getCertificateID() {
        return CertificateID;
    }

    public void setCertificateID(String certificateID) {
        CertificateID = certificateID;
    }

    public LocalDate getCertificateDate() {
        return CertificateDate;
    }

    public void setCertificateDate(LocalDate certificateDate) {
        CertificateDate = certificateDate;
    }

    public String getCertificateRank() {
        return CertificateRank;
    }

    public void setCertificateRank(String certificateRank) {
        CertificateRank = certificateRank;
    }
}
