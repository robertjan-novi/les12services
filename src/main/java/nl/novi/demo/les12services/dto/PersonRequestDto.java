package nl.novi.demo.les12services.dto;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record PersonRequestDto(
        @Size(min=3, max=128)
        String name,

        @Past
        LocalDate dob
) {
}
