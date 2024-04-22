package com.github.annaleighsmith;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager(); // Instantiate your TaskManager

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Task Manager Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. Update Task");
            System.out.println("3. Delete Task");
            System.out.println("4. View All Tasks");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    // Add Task
                    System.out.print("Enter task title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    taskManager.addTask(new Task(title, description));
                    break;
                case 2:
                    // Update Task
                    List<Task> tasks = taskManager.getTasks(); // Access tasks list

                    // Prompt the user to enter the task ID
                    System.out.print("Enter the task ID you want to update: ");
                    int taskIdToUpdate = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    // Validate the input task ID
                    if (taskIdToUpdate < 0 || taskIdToUpdate >= tasks.size()) {
                        System.out.println("Invalid task ID.");
                        break;
                    }

                    // Prompt the user to enter the updated task title and description
                    System.out.print("Enter the updated task title: ");
                    String updatedTitle = scanner.nextLine();
                    System.out.print("Enter the updated task description: ");
                    String updatedDescription = scanner.nextLine();

                    // Update the task
                    Task updatedTask = new Task(updatedTitle, updatedDescription);
                    if (taskManager.updateTask(taskIdToUpdate, updatedTask)){
                        System.out.println("Task updated successfully");
                    }
                    else {
                        System.out.println("Error updating task");
                    }
                    break;
                case 3:
                    // Delete Task
                    while (true) {
                        System.out.print("Enter task id you would like to delete or enter 0 to exit: ");
                        String taskIdStr = scanner.nextLine().trim();
                        if (taskIdStr.equals("0")) {
                            break;
                        }
                        try {
                            int taskId = Integer.parseInt(taskIdStr);
                            if (taskManager.deleteTask(taskId)) {
                                System.out.println("Task deleted successfully.");
                            } else {
                                System.out.println("Task ID not found. Please enter a valid task ID");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid task ID. Please enter a valid integer.");
                        }
                    }
                    break;
                case 4:
                    taskManager.viewAllTasks();
                    break;
                case 0:
                    System.out.println("Exiting Task Manager. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}