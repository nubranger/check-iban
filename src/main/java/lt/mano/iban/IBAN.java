package lt.mano.iban;

public class IBAN {

    private String numberIBAN;
    private Boolean statusIBAN;

    public IBAN() {

    }

    public IBAN(String numberIBAN) {
        this.numberIBAN = numberIBAN;
        this.statusIBAN = new IBANValidator().isValid(numberIBAN);
    }

    public String getNumberIBAN() {
        return numberIBAN;
    }

    public Boolean getStatusIBAN() {
        return statusIBAN;
    }

    public void setStatusIBAN(Boolean statusIBAN) {
        this.statusIBAN = statusIBAN;
    }

    public void setNumberIBAN(String numberIBAN) {
        this.numberIBAN = numberIBAN;
    }

    @Override
    public String toString() {
        return "IBAN{" +
                "number='" + numberIBAN + '\'' +
                ", status=" + statusIBAN +
                '}';
    }
}
