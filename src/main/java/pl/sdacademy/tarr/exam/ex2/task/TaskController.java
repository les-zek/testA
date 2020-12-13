package pl.sdacademy.tarr.exam.ex2.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sdacademy.tarr.exam.ex2.task.enums.Status;
import pl.sdacademy.tarr.exam.ex2.task.enums.Type;
import pl.sdacademy.tarr.exam.ex2.task.dto.CreateTaskDTO;
import pl.sdacademy.tarr.exam.ex2.task.dto.TaskDTO;
import pl.sdacademy.tarr.exam.ex2.task.dto.UpdateTaskDTO;
import pl.sdacademy.tarr.exam.ex2.user.User;

import java.util.List;

@RestController
public class TaskController {


    @Autowired
    private TaskService taskService;
    @Autowired
    private TaskMapper taskMapper;

    // tworzenie zadania dla podanego użytkownika

    @PostMapping("/addTask")
    public void addTask(CreateTaskDTO createTaskDto) {
        taskService.createTask(taskMapper.fromDto(createTaskDto));
    }


    @GetMapping("/tasks/{taskId}")
    public TaskDTO getTask(@PathVariable("taskId") long taskId) {
        return taskMapper.toDto(taskService.getTask(taskId));

    }

    @GetMapping("/tasks/userId={userId}")
    public List<TaskDTO> getTaskByUser(@PathVariable("userId") long userId) {
        return taskMapper.toDtos(taskService.getTasksByUser(userId));
    }

    @GetMapping("/tasks/filterTasks")
    private List<TaskDTO> getTasksByStatusAndTypeAndUser(
            @RequestParam("status") Status status,
            @RequestParam("type") Type type,
            @RequestParam("userId") long userId
    ) {
        return taskMapper.toDtos(taskService.getTaskByStatusAndTypeAndUser(status, type, userId));
    }

    @GetMapping("/tasks/filterTasksByStatusAndUser")
    private List<TaskDTO> getTasksByStatusAndUser(
            @RequestParam("status") Status status,
            @RequestParam("userId") long userId) {
        return taskMapper.toDtos(taskService.getTaskByStatusAndUser(status, userId));
    }

    @GetMapping("/tasks/filterTasksByTypeAndUser")
    private List<TaskDTO> getTasksByTypeAndUser(
            @RequestParam("type") Type type,
            @RequestParam("userId") long userId) {
        return taskMapper.toDtos(taskService.getTaskByTypeAndUser(type, userId));
    }

    @PutMapping("/updateTask")
    public void updateTask(UpdateTaskDTO updateTaskDto) {
        taskService.updateTask(taskMapper.fromDto(updateTaskDto));
    }

    @PutMapping("/updateTaskUser")
    public void updateTaskUser(@RequestParam("taskId") long taskId,
                               @RequestParam("userId") long userId) {
        taskService.updateTaskUser(taskId, userId);
    }

    @DeleteMapping("/tasks/{taskId}")
    public void deleteTask(@PathVariable long taskId) {
        taskService.deleteTask(taskId);
    }

// dodatkowo metoda 1 - pokaz wszystkie taski w kolejnosci od najstarszego do najnowszego

    @GetMapping("/tasks")
    public List<TaskDTO> getTasks() {
        return taskMapper.toDtos(taskService.getTasks());
    }
//  dodatkowa metoda 2 - pokaz wszystkie taski o wybranym statusie

    @GetMapping("/tasks/status={status}")
    public List<TaskDTO> getTasksByStatus(@PathVariable("status") Status status) {
        return taskMapper.toDtos(taskService.getTasksByStatus(status));
    }
// dodatkowa metoda 3 - pokaz wszystkie taski o wybranym typie

    @GetMapping("/tasks/type={type}")
    public List<TaskDTO> getTasksByType(@PathVariable("type") Type type) {
        return taskMapper.toDtos(taskService.getTasksByType(type));
    }
}
