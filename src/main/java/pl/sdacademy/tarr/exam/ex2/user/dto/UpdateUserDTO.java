package pl.sdacademy.tarr.exam.ex2.user.dto;

import java.io.Serializable;

public class UpdateUserDTO implements Serializable {

	private final long id;
	private final String name;

	public UpdateUserDTO(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "UpdateUserDTO{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
