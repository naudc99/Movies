package es.ndc.api_movies.entities;

import es.ndc.api_movies.models.UserDTO;
import es.ndc.api_movies.models.UserRolesDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(exclude = { "reviews", "reservations", "role" })
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 30)
    private String name;

    private String image = "";

    @NotBlank
    @Pattern(regexp = "[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
            + "[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
            + "(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z0-9]"
            + "(?:[a-zA-Z0-9-]*[a-zA-Z0-9])?", message = "Email no válido")
    private String email;

    private String password;

    LocalDateTime lifeSpan = LocalDateTime.now();


    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private RoleEntity role;

    public UserDTO toDTO() {
        return new UserDTO(this);
    }

    public UserRolesDTO toRolesDTO() { return new UserRolesDTO(this); }
}