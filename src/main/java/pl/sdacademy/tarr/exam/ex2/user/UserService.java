package pl.sdacademy.tarr.exam.ex2.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getUsers() {
		return userRepository.findAll(Sort.by(Sort.Order.desc("id")));
	}

	public User getUser(long id) {
		return userRepository.getOne(id);
	}

	public void createUser(User user) {
		userRepository.save(user);
	}

	public void updateUser(User user) {
		userRepository.save(user);
	}

	public void deleteUser(long id) {
		userRepository.deleteById(id);
	}
}
