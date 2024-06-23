1//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import lesson_02.code.backEnd.repository.TaskRepository;
import lesson_02.code.backEnd.service.TaskServiceAdd;
import lesson_02.code.backEnd.service.TaskServiceFind;
import lesson_02.code.backEnd.service.validation.Validation;
import lesson_02.code.frontEnd.ui.UI;

public class Main {
    public static void main(String[] args) {

        TaskRepository taskRepository = new TaskRepository();
        Validation validation = new Validation();

        TaskServiceAdd taskServiceAdd = new TaskServiceAdd(taskRepository, validation);
        TaskServiceFind taskServiceFind = new TaskServiceFind(taskRepository);

        UI ui = new UI(taskServiceAdd, taskServiceFind);
        ui.start();

    }
}