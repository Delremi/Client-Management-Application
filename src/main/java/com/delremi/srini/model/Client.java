package com.delremi.srini.model;

import com.delremi.srini.dto.ClientDisplayDto;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String username;

    private String email;

    @Column(nullable = false)
    private String address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    private Country country;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User createdBy;

    public ClientDisplayDto toDisplayDto() {
        return new ClientDisplayDto(id, firstName, lastName, username, email, address, country.getId());
    }
}
