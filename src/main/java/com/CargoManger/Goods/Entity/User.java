package com.CargoManger.Goods.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;


    @Email
    @NotBlank
    private String email;


    @NotBlank
    private String password;

    private String phone;
    private String address;
    private String profilePictureUrl;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
