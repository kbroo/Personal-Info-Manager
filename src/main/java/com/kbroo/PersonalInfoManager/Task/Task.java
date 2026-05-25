package com.kbroo.PersonalInfoManager.Task;

public class Task {
    private final String title;
    private boolean isDone;

    public Task(String title) {
        this.title = title;
        this.isDone = false;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean getDone() {
        return isDone;
    }

    public void changeDone() {
        this.isDone = !this.isDone;
    }
}
