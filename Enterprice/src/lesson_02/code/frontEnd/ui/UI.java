package lesson_02.code.frontEnd.ui;

import lesson_02.code.backEnd.dto.RequestDto;
import lesson_02.code.backEnd.dto.ResponseDto;
import lesson_02.code.backEnd.entity.Task;
import lesson_02.code.backEnd.service.TaskServiceAdd;
import lesson_02.code.backEnd.service.TaskServiceFind;

import java.util.List;
import java.util.Scanner;

public class UI {

    private final TaskServiceAdd addService;
    private final TaskServiceFind findService;

    public UI(TaskServiceAdd addService, TaskServiceFind findService) {
        this.addService = addService;
        this.findService = findService;
    }

    public void start() {
        while (true) {
            System.out.println("Please enter your choice:");
            System.out.println("1. Add new task");
            System.out.println("2. Find task by id");
            System.out.println("3. Find task by name");
            System.out.println("4. Exit");

            Scanner scanner = new Scanner(System.in);

            int userInput = scanner.nextInt();
            scanner.nextLine();

            switch (userInput) {
                case 1:
                    addTask(scanner);
                    break;
                case 2:
                    findTaskById(scanner);
                    break;
                case 3:
                    findTaskByName(scanner);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
    }

    private void addTask(Scanner scanner) {
        System.out.println("Please enter task name:");
        String taskName = scanner.nextLine();
        System.out.println("Please enter task description:");
        String taskDescription = scanner.nextLine();

        ResponseDto<Task> responseDto = addService.addNewTask(new RequestDto(taskName, taskDescription));

        if (responseDto.getResponseCode() == 200) {
            System.out.println("Task added successfully.");
        } else {
            System.out.println(responseDto.getErrors());
        }
    }

    private void findTaskById(Scanner scanner) {
        System.out.println("Please enter task ID:");
        int taskId = scanner.nextInt();
        scanner.nextLine();

        ResponseDto<Task> responseDto = findService.findById(taskId);
        if (responseDto.getResponseCode() == 200) {
            System.out.println("Task found: " + responseDto.getResult());
        } else {
            System.out.println(responseDto.getErrors());
        }
    }

    private void findTaskByName(Scanner scanner) {
        System.out.println("Please enter task name:");
        String taskName = scanner.nextLine();

        ResponseDto<List<Task>> responseDto = findService.findByName(taskName);
        if (responseDto.getResponseCode() == 200) {
            System.out.println("Tasks found: " + responseDto.getResult());
        } else {
            System.out.println(responseDto.getErrors());
        }
    }
}