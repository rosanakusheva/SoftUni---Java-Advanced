package DefiningClasses.CompanyRoster;

public class Employee {
    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;

    public double getSalary() {
        return salary;
    }

    public Employee(String name, double salary, String position, String department) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.age = -1;
        this.email = "n/a";
    }

    public Employee(String name, double salary, String position, String department, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    public Employee(String name, double salary, String position, String department, String email) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = -1;
    }

    public Employee(String name, double salary, String position, String department, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.age = age;
        this.email = "n/a";

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name + " ").append(String.format("%.2f ", salary)).append(email + " ").append(age );
//        if (email != null) {
//            sb.append(email + " ");
//        } else {
//            sb.append("n/a ");
//        }
//        if (age == 0) {
//            sb.append("-1");
//        } else {
//            sb.append(age);
        return sb.toString();
    }

}


