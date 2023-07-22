package com.niit.userAuthenticationService.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;


@Getter
@Setter
@Entity
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class User {
    @Id
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String role;
    private int age;
    private String phoneNumber;

}
