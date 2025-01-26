package br.com.cmdev.user;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ApplicationTests {

	@Test
	void contextLoads() {
	}
/*
	@Test
	void applicationMainTest() {
		try (MockedStatic<SpringApplication> utilities = Mockito.mockStatic(SpringApplication.class)) {
			utilities.when(() -> SpringApplication.run(Application.class)).thenReturn(null);
			Application.main(new String[0]);
			assertNotNull(new Application());
		}
	}
*/
}
