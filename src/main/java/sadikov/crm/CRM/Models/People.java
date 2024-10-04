package sadikov.crm.CRM.Models;

public class People {
    private int id;
    private String fio;
    private String dateOfBirth;
    private String parentFio;
    private String ticket;
    private int summ;
    private String paymentMethod;
    private int factTicket;
    private int factMoney;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getParentFio() {
        return parentFio;
    }

    public void setParentFio(String parentFio) {
        this.parentFio = parentFio;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public int getSumm() {
        return summ;
    }

    public void setSumm(int summ) {
        this.summ = summ;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getFactTicket() {
        return factTicket;
    }

    public void setFactTicket(int factTicket) {
        this.factTicket = factTicket;
    }

    public int getFactMoney() {
        return factMoney;
    }

    public void setFactMoney(int factMoney) {
        this.factMoney = factMoney;
    }
}
