package es.ndc.api_movies.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import es.ndc.api_movies.entities.UserEntity;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long userId;
    private String name;
    private String email;
    private String image;

    public UserDTO(UserEntity user) {
        this.userId = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.image = user.getImage();
        
    }
}


