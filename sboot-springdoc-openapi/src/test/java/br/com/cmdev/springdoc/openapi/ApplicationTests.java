package br.com.cmdev.springdoc.openapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

	@Test
	void contextLoads() {
	}

    @Test
    void mainMethodRuns() {
        Application.main(new String[]{});
    }
}
