public class Main {
    Task head = null;

    public void addTask(int id, String name, String status) {
        Task newTask = new Task(id, name, status);
        if (head == null) {
            head = newTask;
        } else {
            Task temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newTask;
        }
    }

    public Task searchTask(String name) {
        Task temp = head;
        while (temp != null) {
            if (temp.taskName.equalsIgnoreCase(name)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void deleteTask(int id) {
        if (head == null) return;

        if (head.taskId == id) {
            head = head.next;
            return;
        }

        Task temp = head;
        while (temp.next != null && temp.next.taskId != id) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public void displayTasks() {
        Task temp = head;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Main manager = new Main();

        manager.addTask(1, "Design UI", "Pending");
        manager.addTask(2, "Write Backend", "In Progress");
        manager.addTask(3, "Testing", "Not Started");

        System.out.println("All Tasks:");
        manager.displayTasks();

        Task found = manager.searchTask("Write Backend");
        System.out.println("Search Result: " + (found != null ? found : "Task not found"));

        manager.deleteTask(2);
        System.out.println("After Deletion:");
        manager.displayTasks();
    }
}
