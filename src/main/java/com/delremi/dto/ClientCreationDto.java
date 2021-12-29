package com.delremi.dto;

import com.delremi.model.Country;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientCreationDto {

    @NotBlank(message = "First name must not be empty!")
    private String firstName;

    @NotBlank(message = "Last name must not be empty!")
    private String lastName;

    @NotBlank(message = "Username must not be empty!")
    private String username;

    private String email;

    @NotBlank(message = "Address must not be empty!")
    private String address;

    @NotNull(message = "Country must be selected!")
    private Country country;
}
