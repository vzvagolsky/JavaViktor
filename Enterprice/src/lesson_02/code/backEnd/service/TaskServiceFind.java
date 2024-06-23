package lesson_02.code.backEnd.service;

import lesson_02.code.backEnd.dto.ResponseDto;
import lesson_02.code.backEnd.entity.Task;
import lesson_02.code.backEnd.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

public class TaskServiceFind {

    private final TaskRepository repository;

    public TaskServiceFind(TaskRepository repository) {
        this.repository = repository;
    }

    public ResponseDto<Task> findById(Integer id) {
        Optional<Task> task = repository.findById(id);
        if (task.isPresent()) {
            return new ResponseDto<>(200, task.get(), List.of());
        } else {
            return new ResponseDto<>(404, null, List.of("Task not found"));
        }
    }

    public ResponseDto<List<Task>> findByName(String name) {
        List<Task> tasks = repository.findByTaskNameStream(name);
        if (!tasks.isEmpty()) {
            return new ResponseDto<>(200, tasks, List.of());
        } else {
            return new ResponseDto<>(404, List.of(), List.of("No tasks found with the given name"));
        }
    }
}
