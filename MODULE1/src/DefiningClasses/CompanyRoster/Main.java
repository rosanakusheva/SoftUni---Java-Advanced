package DefiningClasses.CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Employee>> departments = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String[] data = scanner.nextLine().split("\\s+");

            String name = data[0];
            double salary = Double.parseDouble(data[1]);
            String position = data[2];
            String department = data[3];
            String email = null;
            int age = 0;

            Employee employee = null;

            if (data.length == 6) {
                email = data[4];
                age = Integer.parseInt(data[5]);
                employee = new Employee(name, salary, position, department, email, age);

            } else if (data.length == 4) {
                employee = new Employee(name, salary, position, department);

            } else if (data.length == 5) {
                String fourthParameter = data[4];
                if (fourthParameter.contains("@")) {
                    email = fourthParameter;
                    employee = new Employee(name, salary, position, department, email);
                } else {
                    age = Integer.parseInt(fourthParameter);
                    employee = new Employee(name, salary, position, department, age);
                }

            }
            if (!departments.containsKey(department)) {
                departments.put(department, new ArrayList<>());
                departments.get(department).add(employee);
            } else {
                departments.get(department).add(employee);
            }
        }
        String maxAverageSalaryDepartment = departments.entrySet()
                .stream()
                .max(Comparator.comparingDouble(entry -> getAverageSalary(entry.getValue())))
                .get()
                .getKey();

        System.out.printf("Highest Average Salary: %s%n", maxAverageSalaryDepartment);
        List<Employee> employeeList = departments.get(maxAverageSalaryDepartment);
        employeeList.sort(Comparator.comparingDouble(employee -> employee.getSalary()));
        Collections.reverse(employeeList);
         for (Employee employee : employeeList){
             System.out.println(employee);
         }
    }

    public static double getAverageSalary(List<Employee> employees) {
        double sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum / employees.size();
    }
}
