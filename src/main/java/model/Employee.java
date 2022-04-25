package model;

import jakarta.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "employeeXML")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {
    @XmlElement
    private String firstName;
    @XmlElement
    private String lastName;
    @XmlElement
    private int age;
    @XmlElement
    private Address address;
    @XmlElement
    private List<PhoneNumber> phoneNumbers;

    public Employee() {
    }

    public Employee(String firstName, String lastName, int age, Address address, List<PhoneNumber> phoneNumbers) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.phoneNumbers = phoneNumbers;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", address=" + address +
                ", phoneNumbers=" + phoneNumbers +
                '}';
    }
}
