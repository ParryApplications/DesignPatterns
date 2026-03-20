package designPatterns.Structural.Composite;

public class Client {
    public static void main(String[] args) {
        LeafSingleTaskClass task1 = new LeafSingleTaskClass("Wash Cloths");
        LeafSingleTaskClass task2 = new LeafSingleTaskClass("Buy Groceries Cloths");

        CompositeMultipleTasksClass multipleBasicTasks = new CompositeMultipleTasksClass("Weekly Tasks");
        multipleBasicTasks.addTask(task1);
        multipleBasicTasks.addTask(task2);

        LeafSingleTaskClass task3 = new LeafSingleTaskClass("Switch");
        LeafSingleTaskClass task4 = new LeafSingleTaskClass("Go for vacation");

        CompositeMultipleTasksClass multipleLargeTasks = new CompositeMultipleTasksClass("Big Tasks");

        multipleLargeTasks.addTask(task3);
        multipleLargeTasks.addTask(task4);

        CompositeMultipleTasksClass parentTasks = new CompositeMultipleTasksClass("All Tasks");

        parentTasks.addTask(multipleBasicTasks);
        parentTasks.addTask(multipleLargeTasks);

        parentTasks.display();


    }
}
