package ex02;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Spring Boot Test Integration 기반
 * 
 * (JUnit 확인, SpringBoot wk)
 * Spring Boot Test Integration(@SpringBootTest)에서는
 * 자동(스캔)을 위해서 설정 클래스에 @SpringBootConfiguration을 달아야한다.
 * 
 * @SpringBootApplication은 @SpringBootConfiguration 기능을 갖고 있다.
 * 
 * ex01/MyApplicationTest02 의 옳은 버전
 * 
 */

@SpringBootTest
public class MyApplicationTest {
	@Autowired
	private MyComponent myComponent;
	
	@Test
	public void myComponentNotNull() {
		assertNotNull(myComponent);
	}
}
