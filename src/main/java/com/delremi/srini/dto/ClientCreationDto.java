package com.delremi.srini.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ClientCreationDto {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String username;

    private String email;

    @NotNull
    private String address;

    @NotNull
    private int countryId;
}
