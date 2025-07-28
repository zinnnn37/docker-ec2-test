package hello.login.web.session;

import hello.login.domain.member.Member;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import static org.assertj.core.api.Assertions.*;

public class SessionManagerTest {

	SessionManager sessionManager = new SessionManager();

	@Test
	void sessionTest() {
		// create
		MockHttpServletResponse response = new MockHttpServletResponse();
		Member              member   = new Member();
		sessionManager.createSession(member, response);

		// store cookie
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.setCookies(response.getCookies()); // mySessionId

		// search
		Object result = sessionManager.getSession(request);
		assertThat(result).isEqualTo(member);

		// expire
		sessionManager.expire(request);
		Object expired = sessionManager.getSession(request);
		assertThat(expired).isNull();
	}
}
