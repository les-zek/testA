package pl.sdacademy.tarr.exam.ex2.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sdacademy.tarr.exam.ex2.task.enums.Status;
import pl.sdacademy.tarr.exam.ex2.task.enums.Type;
import pl.sdacademy.tarr.exam.ex2.user.User;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllByUser(User user);

    List<Task> findAllByStatusAndTypeAndUser(Status status, Type type, User user);

    List<Task> findAllByStatusAndUser(Status status, User user);

    List<Task> findAllByTypeAndUser(Type type, User user);


    //  dodatkowa metoda 2 - pokaz wszystkie taski o wybranym statusie
    List<Task> findAllByStatus(Status status);
// dodatkowa metoda 3 - pokaz wszystkie taski o wybranym typie

    List<Task> findAllByType(Type type);


}

