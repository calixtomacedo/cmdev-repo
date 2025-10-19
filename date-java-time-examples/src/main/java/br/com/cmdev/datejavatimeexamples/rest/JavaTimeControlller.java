package br.com.cmdev.datejavatimeexamples.rest;

import br.com.cmdev.datejavatimeexamples.dto.JavaTimeResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.*;

@RestController
@RequestMapping("/v1/api/date")
public class JavaTimeControlller {

    @GetMapping("/generate")
    public ResponseEntity<JavaTimeResponse> generateDates() {

        var response = new JavaTimeResponse(
                LocalDate.now(),
                LocalDateTime.now(),
                OffsetDateTime.now(),
                OffsetDateTime.now().toLocalDateTime(),
                ZonedDateTime.now(),
                ZoneOffset.UTC,
                ZoneId.systemDefault(),
                ZoneId.of("America/Recife"),
                ZonedDateTime.now(ZoneId.of("America/Sergipe"))
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
