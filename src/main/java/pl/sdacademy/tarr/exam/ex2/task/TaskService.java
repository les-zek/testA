package pl.sdacademy.tarr.exam.ex2.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.sdacademy.tarr.exam.ex2.task.enums.Status;
import pl.sdacademy.tarr.exam.ex2.task.enums.Type;
import pl.sdacademy.tarr.exam.ex2.user.User;
import pl.sdacademy.tarr.exam.ex2.user.UserRepository;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;

    public void createTask(Task task) {
        taskRepository.save(task);
    }

    public Task getTask(long taskId) {
        return taskRepository.findById(taskId).orElseGet(() -> new Task());
    }


    public List<Task> getTasksByUser(long userId) {
        User user = userRepository.findById(userId).orElseGet(() -> new User());
        return taskRepository.findAllByUser(user);
    }

    public List<Task> getTaskByStatusAndTypeAndUser(Status status, Type type, long userId) {
        User user = userRepository.findById(userId).orElseGet(() -> new User());
        return taskRepository.findAllByStatusAndTypeAndUser(status, type, user);
    }

    public List<Task> getTaskByStatusAndUser(Status status, long userId) {
        User user = userRepository.findById(userId).orElseGet(() -> new User());
        return taskRepository.findAllByStatusAndUser(status, user);
    }
    public List<Task> getTaskByTypeAndUser(Type type, long userId) {
        User user = userRepository.findById(userId).orElseGet(() -> new User());
        return taskRepository.findAllByTypeAndUser(type, user);
    }


    public void updateTask(Task task) {
        taskRepository.save(task);

    }

    public void updateTaskUser(long taskId, long userId) {
        Task task = getTask(taskId);
        User user = userRepository.findById(userId).orElseGet(() -> new User());
        task.setUser(user);
        taskRepository.save(task);
    }
    public void deleteTask(long id) {
        taskRepository.deleteById(id);
    }

    // dodatkowo metoda 1 - pokaz wszystkie taski w kolejnosci od najstarszego do najnowszego
    public List<Task> getTasks() {
        return taskRepository.findAll(Sort.by(Sort.Direction.ASC, "dateAdded"));
    }

    // dodatkowa metoda 2 - pokaz wszystkie taski o wybranym statusie
    public List<Task> getTasksByStatus(Status status) {
        return taskRepository.findAllByStatus(status);
    }

    // dodatkowa metoda 3 - pokaz wszystkie taski o wybranym typie
    public List<Task> getTasksByType(Type type) {
        return taskRepository.findAllByType(type);
    }
}