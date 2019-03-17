package pl.sdacademy.tarr.exam.ex2.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sdacademy.tarr.exam.ex2.user.dto.CreateUserDTO;
import pl.sdacademy.tarr.exam.ex2.user.dto.UpdateUserDTO;
import pl.sdacademy.tarr.exam.ex2.user.dto.UserDTO;

import java.util.List;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserMapper userMapper;

	@GetMapping("/users")
	public List<UserDTO> getUsers() {
		List<User> users = userService.getUsers();

		return userMapper.toDTOs(users);
	}

	@GetMapping("/users/{userId}")
	public UserDTO getUser(@PathVariable long userId) {
		User user = userService.getUser(userId);

		return userMapper.toDTO(user);
	}

	@PostMapping("/users")
	public void createUser(CreateUserDTO userDTO) {
		User user = userMapper.fromDTO(userDTO);

		userService.createUser(user);
	}

	@PutMapping("/users/{userId}")
	public void updateUser(UpdateUserDTO userDTO, @PathVariable long userId) {
		User userFromDb = userService.getUser(userId);

		if (userFromDb != null) {
			User user = userMapper.fromDTO(userDTO);
			user.setId(userId);
			userService.updateUser(user);
		}
	}

	@DeleteMapping("/users/{userId}")
	public void deleteUser(@PathVariable long userId) {
		userService.deleteUser(userId);
	}
}