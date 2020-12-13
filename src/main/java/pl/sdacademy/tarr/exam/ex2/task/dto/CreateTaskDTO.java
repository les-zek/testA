package pl.sdacademy.tarr.exam.ex2.task.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sdacademy.tarr.exam.ex2.task.enums.Status;
import pl.sdacademy.tarr.exam.ex2.task.enums.Type;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTaskDTO {
    private String title;
    private Type type;
    private Status status;
    private long userId;
}
