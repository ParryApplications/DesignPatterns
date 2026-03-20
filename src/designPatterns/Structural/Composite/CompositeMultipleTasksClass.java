package designPatterns.Structural.Composite;

import java.util.ArrayList;
import java.util.List;

//Composite
public class CompositeMultipleTasksClass implements Task {

    private List<Task> taskList;
    private String name;

    public CompositeMultipleTasksClass(String name) {
        this.name = name;
        taskList = new ArrayList<>();
    }

    @Override
    public String getTaskName() {
        return name;
    }

    public boolean addTask(Task task) {
        return taskList.add(task);
    }

    public boolean removeTask(Task task) {
        return taskList.remove(task);
    }

    @Override
    public void display() {
        System.out.printf("Composite Task :: AKA %s%n", name);
        taskList.forEach(Task::display);
    }
}
