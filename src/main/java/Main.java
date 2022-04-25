import model.*;

import java.io.*;
import java.util.*;

import static converter.EmployeeToJsonConverter.*;
import static converter.EmployeeToXmlConverter.*;

public class Main {
    public static void main(String[] args) {
        List<PhoneNumber> phoneNumbers = new ArrayList<>();
        phoneNumbers.add(new PhoneNumber(PhoneNumberType.HOME, "077000000"));
        phoneNumbers.add(new PhoneNumber(PhoneNumberType.MOBILE, "055000000"));
        Address address = new Address("Armenia", "Yerevan", "Baghramyan", "0014");
        Employee employee = new Employee("Mark", "Jacobs", 30, address, phoneNumbers);
        Employee employee2 = new Employee("Steve", "Harvey", 36, address, phoneNumbers);
        Employee employee3 = new Employee("Alex", "Spenser", 42, address, phoneNumbers);
        Employee employee4 = new Employee("Amelia", "Strikes", 28, address, phoneNumbers);

        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);

        //Json
        File fileOneEmployeeJson = new File("src/main/resources/Employee.json");
        File fileEmployeesListJson = new File("src/main/resources/EmployeesList.json");

        convertEmployeeToJson(employee, fileOneEmployeeJson);
        convertEmployeeToJson(employees, fileEmployeesListJson);

        Employee employee5 = makeEmployeeFromJson(fileOneEmployeeJson);
        System.out.println(employee5.toString());

        List<Employee> employees2 = makeEmployeeListFromJson(fileEmployeesListJson);

        //Xml
        File fileOneEmployeeXml = new File("src/main/resources/Employee.xml");
        File fileEmployeesListXml = new File("src/main/resources/EmployeesList.xml");

        convertEmployeeToXml(employee, fileOneEmployeeXml);

        Employee employee6 = makeEmployeeFromXml(fileOneEmployeeXml);
        System.out.println(employee6.toString());
    }
}
