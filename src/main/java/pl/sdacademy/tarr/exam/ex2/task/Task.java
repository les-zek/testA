package pl.sdacademy.tarr.exam.ex2.task;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sdacademy.tarr.exam.ex2.task.enums.Status;
import pl.sdacademy.tarr.exam.ex2.task.enums.Type;
import pl.sdacademy.tarr.exam.ex2.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long taskId;
    private String title;
    private LocalDateTime dateAdded;
    private Type type;
    private Status status;
    @ManyToOne
    @JoinColumn(name = "id")
    private User user;
}
