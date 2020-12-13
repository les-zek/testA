package pl.sdacademy.tarr.exam.ex2.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.sdacademy.tarr.exam.ex2.user.UserService;
import pl.sdacademy.tarr.exam.ex2.task.dto.CreateTaskDTO;
import pl.sdacademy.tarr.exam.ex2.task.dto.TaskDTO;
import pl.sdacademy.tarr.exam.ex2.task.dto.UpdateTaskDTO;
import pl.sdacademy.tarr.exam.ex2.user.dto.UserDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskMapper {
    @Autowired
    private UserService userService;
    @Autowired
    private TaskService taskService;
    public TaskDTO toDto(Task task) {
        return new TaskDTO(
                task.getTaskId(),
                task.getTitle(),
                task.getDateAdded(),
                task.getType(),
                task.getStatus(),
                new UserDTO(task.getUser().getId(), task.getUser().getName())
        );
    }

    public List<TaskDTO> toDtos(List<Task> tasks) {
        return tasks.stream().map(task -> toDto(task)).collect(Collectors.toList());
    }

    public Task fromDto(CreateTaskDTO createTaskDto) {
        Task task = new Task();
        task.setTitle(createTaskDto.getTitle());
        task.setDateAdded(LocalDateTime.now());
        task.setType(createTaskDto.getType());
        task.setStatus(createTaskDto.getStatus());
        // zwraca usera po id przypisujacej wlasciciela zadania
        task.setUser(userService.getUser(createTaskDto.getUserId()));
        // getUserbyId
        return task;
    }

    public Task fromDto(UpdateTaskDTO updateTaskDto) {
        Task task= taskService.getTask(updateTaskDto.getTaskId());
        task.setTaskId(updateTaskDto.getTaskId());
        task.setTitle(updateTaskDto.getTitle());
//        task.setDateAdded(LocalDateTime.now());
        task.setType(updateTaskDto.getType());
        task.setStatus(updateTaskDto.getStatus());
        return task;
    }
}
