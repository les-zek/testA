package pl.sdacademy.tarr.exam.ex2.task.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sdacademy.tarr.exam.ex2.task.enums.Status;
import pl.sdacademy.tarr.exam.ex2.task.enums.Type;
import pl.sdacademy.tarr.exam.ex2.user.dto.UserDTO;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {
    private long taskId;
    private String title;
    private LocalDateTime dateAdded;
    private Type type;
    private Status status;
    private UserDTO userDto;
}
