import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimpleTodoList {

    private final List<String> tasks = new ArrayList<>();

    public void addTask(String task) {
        if (task == null) return;
        task = task.trim();
        if (!task.isEmpty()) {
            tasks.add(task);
            System.out.println("Task added: \"" + task + "\"");
        } else {
            System.out.println("Empty task cannot be added.");
        }
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks yet.");
            return;
        }
        System.out.println("\n--- To-Do List ---");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, tasks.get(i));
        }
        System.out.println("------------------\n");
    }

    public void deleteTask(int index) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to delete.");
            return;
        }
        if (index < 1 || index > tasks.size()) {
            System.out.println("Invalid task number.");
            return;
        }
        tasks.remove(index - 1);
        System.out.println("Task deleted.");
    }

    public void updateTask(int index) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to update.");
            return;
        }
        if (index < 1 || index > tasks.size()) {
            System.out.println("Invalid task number.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the new task: ");
        String newTask = sc.nextLine().trim();

        if (!newTask.isEmpty()) {
            tasks.set(index - 1, newTask);
            System.out.println("Task updated.");
        } else {
            System.out.println("Task cannot be empty.");
        }
    }

    public static void main(String[] args) {
        SimpleTodoList todo = new SimpleTodoList();
        Scanner sc = new Scanner(System.in);

        System.out.println("Simple To-Do App");
        System.out.println("Choose an option (exit with 3):\n");

        while (true) {
            System.out.println("Options:");
            System.out.println("1) Add new task");
            System.out.println("2) List all tasks");
            System.out.println("3) Exit");
            System.out.println("4) Delete a task");
            System.out.println("5) Update a task");
            System.out.print("Your choice: ");

            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("Enter a new task: ");
                    String task = sc.nextLine();
                    todo.addTask(task);
                    break;
                case "2":
                    todo.listTasks();
                    break;
                case "3":
                    System.out.println("Exiting program. Goodbye!");
                    sc.close();
                    return;
                case "4":
                    System.out.print("Enter the task number to delete: ");
                    if (sc.hasNextInt()) {
                        int delIndex = sc.nextInt();
                        sc.nextLine(); // consume newline
                        todo.deleteTask(delIndex);
                    } else {
                        System.out.println("Invalid input.");
                        sc.nextLine(); // clear buffer
                    }
                    break;
                case "5":
                    System.out.print("Enter the task number to update: ");
                    if (sc.hasNextInt()) {
                        int updIndex = sc.nextInt();
                        sc.nextLine(); // consume newline
                        todo.updateTask(updIndex);
                    } else {
                        System.out.println("Invalid input.");
                        sc.nextLine(); // clear buffer
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1–5.");
            }
        }
    }
}
