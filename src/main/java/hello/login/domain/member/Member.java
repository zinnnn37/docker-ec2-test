package hello.login.domain.member;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class Member {

	private Long id;

	@NotEmpty
	private String loginId;

	@NotEmpty
	private String name;

	@NotEmpty
	private String password;

}
