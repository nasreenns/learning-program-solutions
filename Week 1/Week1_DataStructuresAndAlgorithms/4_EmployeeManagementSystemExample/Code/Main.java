public class Main {
    Employee[] employees = new Employee[100];
    int size = 0;

    public void addEmployee(int id, String name, String position, double salary) {
        employees[size++] = new Employee(id, name, position, salary);
    }

    public Employee searchEmployee(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == id) {
                return employees[i];
            }
        }
        return null;
    }

    public void deleteEmployee(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == id) {
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[size - 1] = null;
                size--;
                break;
            }
        }
    }

    public void displayEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Main manager = new Main();

        manager.addEmployee(101, "Arjun", "Manager", 75000);
        manager.addEmployee(102, "Meera", "Developer", 50000);
        manager.addEmployee(103, "Kiran", "Designer", 45000);

        System.out.println("All Employees:");
        manager.displayEmployees();

        Employee found = manager.searchEmployee(102);
        System.out.println("Search Result: " + (found != null ? found : "Employee not found"));

        manager.deleteEmployee(102);
        System.out.println("After Deletion:");
        manager.displayEmployees();
    }
}
