package br.com.cmdev.datejavatimeexamples;

import java.time.*;
import java.util.Set;

public class JavaTimeTests {

    static void main() {

        LocalDate localDate = LocalDate.now();
        System.out.println("localDate: "+localDate);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime: "+localDateTime);

        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        System.out.println("offsetDateTime: "+offsetDateTime);

        LocalDateTime offsetLocalDateTime = offsetDateTime.toLocalDateTime();
        System.out.println("offsetLocalDateTime: "+offsetLocalDateTime);


        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("zonedDateTime: "+zonedDateTime);

        ZoneOffset zoneOffset = ZoneOffset.UTC;
        System.out.println("zoneOffset: "+zoneOffset);


        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        availableZoneIds.stream()
                .filter(zone -> zone.contains("America"))
                .forEach(System.out::println);


    }


}
