package com.kbroo.PersonalInfoManager;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.kbroo.PersonalInfoManager.customFileManager.CustomFileManager;
import com.kbroo.PersonalInfoManager.task.Task;

public class Main {
    public static void main(String[] args) {
        CustomFileManager customFileManager = new CustomFileManager();
        ArrayList<Task> toDoList = customFileManager.getTasksFromFile("tasks.txt");

        System.out.println("Вас приветствует InfoManager v1.0");
        System.out.print("Укажите ваше имя: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Приветствую " + name + "\n");

        while(true) {
            int choice = 0;
            boolean choiceIsTrue = false;
            System.out.println("========= MENU =========\n" +
                    "1. Показать список дел.\n" +
                    "2. Добавить задачу.\n" +
                    "3. Пометить выполненной.\n" +
                    "0. Выход.\n");
            System.out.print("\nВыберите действие: ");
            while (!choiceIsTrue) {
                try {
                    choice = scanner.nextInt();
                    choiceIsTrue = true;
                } catch (InputMismatchException e) {
                    System.out.println("Введено некорректное значение.\n");
                    scanner.nextLine();
                    System.out.print("\nВыберите действие: ");
                }
            }
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("\nСписок дел:\n");
                    int i = 1;
                    for (Task el : toDoList) {
                        System.out.print(i + ". " + el.getTitle());
                        if (el.getDone()) System.out.print(" | [X]");
                        System.out.println();
                        i++;
                    }
                    break;
                case 2:
                    System.out.print("Укажите задачу, которую хотите добавить: ");
                    String newTask = scanner.nextLine();
                    Task newEl = new Task(newTask);
                    toDoList.add(newEl);
                    System.out.println("Новая задача добавлена.\n");
                    break;
                case 3:
                    System.out.print("Укажите номер задачи, которую вы выполнили: ");
                    int numberOfTask;
                    try {
                        numberOfTask = scanner.nextInt();
                        scanner.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Вы ввели не число.\n");
                        scanner.nextLine();
                        break;
                    }
                    if (toDoList.size() < numberOfTask) {
                        System.out.println("Задача не существует.\n");
                        break;
                    } else if (toDoList.get(numberOfTask - 1).getDone()) {
                        System.out.println("Задача уже выполена.\n");
                        break;
                    } else {
                        toDoList.get(numberOfTask - 1).changeDone();
                    }
                    break;
                case 0:
                    System.out.println("\n=======================\n");
                    customFileManager.saveToFile(toDoList);
                    System.exit(0);
                    break;
            }
            System.out.println("\n=======================\n");
        }
    }
}
