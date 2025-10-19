package br.com.cmdev.datejavatimeexamples.rest;

import br.com.cmdev.datejavatimeexamples.dto.JavaDatesResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

@RestController
@RequestMapping("/v1/api/date")
public class JavaDatesControlller {

    @GetMapping("/generate")
    public ResponseEntity<JavaDatesResponse> generateDates() {

        var response = new JavaDatesResponse(
                LocalDate.now().minus(5, ChronoUnit.YEARS),
                LocalDateTime.now(),
                ZonedDateTime.now(),
                ZoneOffset.UTC
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
