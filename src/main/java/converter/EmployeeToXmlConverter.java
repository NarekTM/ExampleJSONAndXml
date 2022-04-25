package converter;

import jakarta.xml.bind.*;
import model.Employee;
import java.io.File;

public class EmployeeToXmlConverter {
    public static void convertEmployeeToXml(Employee employee, File file) {
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(Employee.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(employee, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static Employee makeEmployeeFromXml(File file) {
        JAXBContext jaxbContext;
        Employee employee = null;
        try {
            jaxbContext = JAXBContext.newInstance(Employee.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            employee = (Employee) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return employee;
    }
}
