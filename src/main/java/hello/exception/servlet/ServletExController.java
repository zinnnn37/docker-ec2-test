package hello.exception.servlet;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Slf4j
@Controller
public class ServletExController {

	@GetMapping("/error-ex")
	@ResponseBody
	public void errorEx() {
		throw new RuntimeException("예외 발생!");
	}

	@GetMapping("/error-404")
	@ResponseBody
	public void error404(HttpServletResponse response) throws IOException {
		response.sendError(404, "404 오류!");
	}

	@GetMapping("/error-500")
	@ResponseBody
	public void error500(HttpServletResponse response) throws IOException {
		response.sendError(500);
	}
}