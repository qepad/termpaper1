import java.util.Objects;

public class Employee {

    private int department;
    private final String name;
    private int salary;
    private final int id;
    private static int generateId = 1;

    public Employee(int department, String name, int salary) {
        id = generateId++;
        this.department = department;
        this.name = name;
        this.salary = salary;
    }

    public int getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && salary == employee.salary && id == employee.id && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(department, name, salary, id);
    }

    @Override
    public String toString() {
        return "id: " + id +
                ", отдел: " + department +
                ", имя: " + name +
                ", зарплата: " + salary;
    }
}
