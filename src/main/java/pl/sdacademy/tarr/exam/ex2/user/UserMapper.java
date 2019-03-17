package pl.sdacademy.tarr.exam.ex2.user;

import org.springframework.stereotype.Component;
import pl.sdacademy.tarr.exam.ex2.user.dto.CreateUserDTO;
import pl.sdacademy.tarr.exam.ex2.user.dto.UpdateUserDTO;
import pl.sdacademy.tarr.exam.ex2.user.dto.UserDTO;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

	public UserDTO toDTO(User user) {
		return new UserDTO(user.getId(), user.getName());
	}

	public List<UserDTO> toDTOs(List<User> users) {
		return users.stream()
				.map(user -> toDTO(user))
				.collect(Collectors.toList());
	}

	public User fromDTO(CreateUserDTO userDTO) {
		User user = new User();
		user.setName(userDTO.getName());
		return user;
	}

	public User fromDTO(UpdateUserDTO userDTO) {
		User user = new User();
		user.setId(userDTO.getId());
		user.setName(userDTO.getName());
		return user;
	}
}

