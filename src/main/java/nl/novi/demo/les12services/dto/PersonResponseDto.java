package nl.novi.demo.les12services.dto;

import java.time.LocalDate;

public record PersonResponseDto(
        int id,
        String name,
        LocalDate dob
) {
}
