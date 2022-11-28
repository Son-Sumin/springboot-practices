package myweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class MyWebApplication {
	
	@Controller
	public class HelloController {   // inner class 생성 가능
		@RequestMapping("/hello")
		public String hello() {
			return "hello";
		}
	}
	
	// Web에서는 try-catch를 사용하면 안됨. 서버가 꺼지지 않고 계속 실행되어야 하므로
	public static void main(String[] args) {
		SpringApplication.run(MyWebApplication.class, args);
		
		//try(ConfigurableApplicationContext ac = SpringApplication.run(MyWebApplication.class, args)) {}
	}
}
