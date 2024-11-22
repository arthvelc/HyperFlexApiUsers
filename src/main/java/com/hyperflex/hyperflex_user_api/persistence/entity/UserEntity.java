package com.hyperflex.hyperflex_user_api.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", nullable = false)
    private Long idUser;

    @Column(name="user_name", nullable = false, length = 30)
    @NotBlank(message = "usarname obligatorio")
    private String userName;

    @Column(nullable = false, length = 50)
    @Email(message = "Ingresar un Email válido")
    @NotBlank(message = "Campo email obligatorio")
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "La contraseña es obligatoria")
    private String password;

    @Column(nullable = false, length = 30)
    @NotBlank(message = "El nombre es obligatorio")
    private String name;

    @Column(nullable = false, length = 30)
    @NotBlank(message = "El apellido es obligatorio")
    private String lastName;

    @Past(message = "La fecha debe ser en el pasado")
    private LocalDate birthday;
}
