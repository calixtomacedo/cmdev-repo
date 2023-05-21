package br.com.cmdev.springoauth;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.boot.SpringApplication;

public class ApplicationTests {

    @Test
    public void testApplication() {
        MockedStatic<SpringApplication> mockedStatic = Mockito.mockStatic(SpringApplication.class);
		mockedStatic.when((MockedStatic.Verification) SpringApplication.run(Application.class, new String[]{})).thenReturn(null);
        Application.main(new String[]{});
		Assertions.assertThat(SpringApplication.run(Application.class)).isEqualTo(null);
    }


}
