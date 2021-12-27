package com.delremi.srini.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ClientDisplayDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String address;
    private int countryId;
}
