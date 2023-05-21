package br.com.cmdev.sbootbeanvalidation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

class ApplicationTests {

	@Test
	public void testApplication() {
		MockedStatic<SpringApplication> mockedStatic = Mockito.mockStatic(SpringApplication.class);
		mockedStatic.when((MockedStatic.Verification) SpringApplication.run(Application.class, new String[]{})).thenReturn(null);
		Application.main(new String[]{});
		Assertions.assertThat(SpringApplication.run(Application.class)).isEqualTo(null);
	}

}
