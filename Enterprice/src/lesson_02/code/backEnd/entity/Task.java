package lesson_02.code.backEnd.entity;

public class Task {
    private Integer id;
    private String taskName;
    private String taskDescription;

    public Task(Integer id, String taskName, String taskDescription) {
        this.id = id;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
    }

    public Task() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                '}';
    }
}
