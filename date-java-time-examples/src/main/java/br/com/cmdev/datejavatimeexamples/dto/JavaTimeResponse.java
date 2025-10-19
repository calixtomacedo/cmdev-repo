package br.com.cmdev.datejavatimeexamples.dto;

import java.time.*;

public record JavaTimeResponse(
        LocalDate localDate,
        LocalDateTime localDateTime,
        OffsetDateTime offsetDateTime,
        LocalDateTime OffsetDateTimeToLocalDateTime,
        ZonedDateTime zonedDateTime,
        ZoneOffset zoneOffset,

        ZoneId zoneId, ZoneId id, ZonedDateTime now) {}
