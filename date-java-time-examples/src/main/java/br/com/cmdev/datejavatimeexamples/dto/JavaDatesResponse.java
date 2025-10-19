package br.com.cmdev.datejavatimeexamples.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public record JavaDatesResponse(
        LocalDate localDate,
        LocalDateTime localDateTime,
        ZonedDateTime zonedDateTime,
        ZoneOffset zoneOffset

) {}
