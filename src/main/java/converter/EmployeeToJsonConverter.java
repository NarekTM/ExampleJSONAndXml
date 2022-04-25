package converter;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import model.Employee;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class EmployeeToJsonConverter {
    public static void convertEmployeeToJson(Employee employee, File file) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try(FileWriter fileWriter = new FileWriter(file)) {
            gson.toJson(employee, fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void convertEmployeeToJson(List<Employee> list, File file) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try(FileWriter fileWriter = new FileWriter(file)) {
            gson.toJson(list, fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Employee makeEmployeeFromJson(File file) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Employee employee = null;

        try(FileReader fileReader = new FileReader(file)) {
            employee = gson.fromJson(fileReader, Employee.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return employee;
    }

    public static List<Employee> makeEmployeeListFromJson(File file) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<Employee> employees = new ArrayList<>();


        try(FileReader fileReader = new FileReader(file)) {
            JsonObject jsonObject = gson.fromJson(fileReader, JsonObject.class);
            JsonElement jsonElement = jsonObject.get("employees");
            Type listType = new TypeToken<List<Employee>>() {}.getType();
            employees = gson.fromJson(jsonElement, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return employees;
    }
}
