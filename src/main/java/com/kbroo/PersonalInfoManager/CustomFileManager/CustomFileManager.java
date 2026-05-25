package com.kbroo.PersonalInfoManager.CustomFileManager;

import com.kbroo.PersonalInfoManager.Task.Task;

import java.io.*;
import java.sql.Array;
import java.util.ArrayList;

public class CustomFileManager {

    public void saveToFile(ArrayList<Task> toDoList) {
        try {
            FileWriter fileWriter = new FileWriter("tasks.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for (Task el : toDoList) {
                int isDone = 0;
                if (el.getDone()) isDone = 1;
                writer.write(isDone + ";" + el.getTitle());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Ошибка при сохранение данных в файл.");
        }
    }

    public ArrayList<Task> getTasksFromFile(String filename) {
        ArrayList<Task> toDoList = new ArrayList<>();
        File file = new File(filename);
        if (!file.exists()) return toDoList;

        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 2) {
                    boolean isDone = parts[0].equals("1");
                    String title = parts[1];
                    toDoList.add(new Task(title, isDone));
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Ошибка при получении данных из файла.");
        }
        return toDoList;
    }

}
