package com.github.annaleighsmith;

public class Task {
    private String title;
    private String description;
    private boolean completed;

    // Default constructor
    public Task() {
        this.title = "";
        this.description = "";
        this.completed = false;
    }

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.completed = false; // By default task is incomplete
    }

    // Overloaded constructor to specify initial completion status
    public Task(String title, String description, boolean completed) {
        this.title = title;
        this.description = description;
        this.completed = completed;
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    // Method to mark as complete
    public void complete() {
        this.completed = true;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                '}';

    }
}
