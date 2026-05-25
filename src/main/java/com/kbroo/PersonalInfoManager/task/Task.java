package com.kbroo.PersonalInfoManager.task;

public class Task {
    private final String title;
    private boolean isDone;

    public Task(String title) {
        this.title = title;
        this.isDone = false;
    }

    public Task(String title, boolean isDone) {
        this.title = title;
        this.isDone = isDone;
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
