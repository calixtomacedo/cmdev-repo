package br.com.cmdev.user;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.boot.SpringApplication;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ApplicationTests {

    @Test
    void applicationMain() {
        try (MockedStatic<SpringApplication> utilities = Mockito.mockStatic(SpringApplication.class)) {
            utilities.when(() -> SpringApplication.run(Application.class)).thenReturn(null);
            Application.main("0");
            assertNotNull(new Application());
        }
    }
}
