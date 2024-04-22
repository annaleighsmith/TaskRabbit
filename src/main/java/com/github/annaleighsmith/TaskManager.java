package com.github.annaleighsmith;


import java.util.ArrayList;
import java.util.List;

    public class TaskManager {
        private List<Task> tasks;

        public TaskManager() {
            this.tasks = TaskFileManager.readTasksFromFile();
            if (this.tasks == null) {
                this.tasks = new ArrayList<>();
            }
        }

        // Getter method for tasks list
        public List<Task> getTasks() {
            return tasks;
        }

        public void addTask(Task task) {
            tasks.add(task);
            System.out.println("Task added successfully.");
            saveChangesToFile();
        }

        public void updateTask(int taskId, Task updatedTask) {
            if (isValidTaskId(taskId)) {
                tasks.set(taskId, updatedTask);
                System.out.println("Task updated successfully");
                saveChangesToFile();
            } else {
                System.out.println("Invalid Task ID.");
            }
        }

        public void deleteTask(int taskId) {
            if (isValidTaskId(taskId)) {
                tasks.remove(taskId);
                System.out.println("Task deleted successfully.");
                saveChangesToFile(); // Save tasks to file after deleting the task
            } else {
                System.out.println("Invalid task ID.");
            }
        }

        public void viewAllTasks() {
            if (tasks.isEmpty()) {
                System.out.println("No tasks available.");
            } else {
                System.out.println("All tasks:");
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println("Task ID: " + i + ", " + tasks.get(i));
                }
            }
        }

        private boolean isValidTaskId(int taskId) {
            return taskId > 0 && taskId < tasks.size();
        }

        public void saveChangesToFile() {
            TaskFileManager.writeTasksToFile(tasks);
        }
    }

