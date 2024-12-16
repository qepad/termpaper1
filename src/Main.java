import java.util.Random;

public class Main {

    private static Random random = new Random();
    private static Employee[] employees = new Employee[10];
    private static String[] names = {"Никита", "Николай", "Алексей", "Ян", "Максим", "Илья", "Михаил", "Дмитрий", "Даниил", "Роман"};
    private static String[] surnames = {"Куликов", "Макаров", "Демидов", "Кудрявцев", "Федотов", "Кулешов", "Чернышев", "Голованов", "Попов", "Тихомиров"};
    private static String[] patronymics = {"Иванович", "Константинович", "Викторович", "Владимирович", "Владиславович", "Александрович", "Матвеевич", "Егорович", "Александрович", "Маркович"};

    private static void generateEmployees() {
        for (int i = 0; i < employees.length; i++) {
            String name = surnames[random.nextInt(0, surnames.length)] + " " +
                    names[random.nextInt(0, names.length)] + " " +
                    patronymics[random.nextInt(0, patronymics.length)];
            employees[i] = new Employee(random.nextInt(1, 6), name, random.nextInt(30000, 100000));
        }
    }


    public static void main(String[] args) {
        generateEmployees();
        System.out.println("данные сотрудников:");
        printEmployees();
        System.out.println();

        System.out.println("ежемесячные расходы на зарплату: " + salarySum() + " руб.");
        System.out.println("минимальная зарплата: " + findMinSalary().getSalary() + " руб. (id: " + findMinSalary().getId() + ")");
        System.out.println("максимальная зарплата: " + findMaxSalary().getSalary() + " руб. (id: " + findMaxSalary().getId() + ")");
        System.out.println("средняя зарплата: " + findSalaryAverage() + " руб.");
        System.out.println();

        System.out.println("ФИО всех сотрудников:");
        printName();
        System.out.println();

        System.out.println("Проиндексированная зарплата");
        increaseSalary(5);
        System.out.println();

        System.out.println();
        findDepartment(3);

    }

    private static void printEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private static int salarySum() {
        int sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum;
    }

    private static Employee findMinSalary() {
        Employee minSalary = null;
        for (Employee employee : employees) {
            if (minSalary == null || employee.getSalary() < minSalary.getSalary()) {
                minSalary = employee;
            }
        }
        return minSalary;
    }

    private static Employee findMaxSalary() {
        Employee maxSalary = null;
        for (Employee employee : employees) {
            if (maxSalary == null || employee.getSalary() > maxSalary.getSalary()) {
                maxSalary = employee;
            }
        }
        return maxSalary;
    }

    private static double findSalaryAverage() {
        double average = (double) salarySum() / employees.length;
        return average;
    }

    private static void printName() {
        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }
    }

    private static void increaseSalary(int increment) {
        for (Employee employee : employees) {
            employee.setSalary((employee.getSalary() + (employee.getSalary() * increment / 100)));
            if (increment > 0) {
                System.out.println(employee.getName() + ": " + employee.getSalary() + " руб. (+" + increment + "%)");
            } else if (increment < 0) {
                System.out.println(employee.getName() + ": " + employee.getSalary() + " руб. (" + increment + "%)");
            }
        }
        if (increment == 0) {
            System.out.println("индексации не было");
        }
    }

    private static void findDepartment(int department) {
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (employee.getDepartment() == department) {
                System.out.println(employees[i]);
            }
        }



    }
}