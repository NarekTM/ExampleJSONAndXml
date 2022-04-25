package model;

public class PhoneNumber {
    private PhoneNumberType type;
    private String number;

    public PhoneNumber() {
    }

    public PhoneNumber(PhoneNumberType type, String number) {
        this.type = type;
        this.number = number;
    }

    public PhoneNumberType getType() {
        return type;
    }

    public void setType(PhoneNumberType type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "type=" + type +
                ", number='" + number + '\'' +
                '}';
    }
}
