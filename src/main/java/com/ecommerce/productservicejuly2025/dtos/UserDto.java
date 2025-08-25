package com.ecommerce.productservicejuly2025.dtos;

//import com.ecommerce.userserviceaug2025.models.Role;
//import com.ecommerce.userserviceaug2025.models.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {
    private String name;
    private String email;
    private List<Role> role;


}
