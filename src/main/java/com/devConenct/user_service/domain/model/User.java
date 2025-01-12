package com.devConenct.user_service.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    private String phone;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
    @Column()
    private final boolean isEnabled = false;

    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column()
    private String profilePictureUrl;
    @Column()
    private String bio;
    @Column()
    private String city;
    @Column()
    private String company;

    @Column(nullable = false)
    private final boolean isAccountNonExpired = true;
    @Column(nullable = false)
    private final boolean isCredentialsNonExpired = true;
    @Column(nullable = false)
    private final boolean isAccountNonLocked = true;

    public User(String username, String email, String password, Role role, String phone, String firstName, String lastName, String profilePictureUrl, String bio, String city, String company) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.phone = phone;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profilePictureUrl = profilePictureUrl;
        this.bio = bio;
        this.city = city;
        this.company = company;
    }
}

