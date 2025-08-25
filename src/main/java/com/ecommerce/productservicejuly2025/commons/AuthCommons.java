package com.ecommerce.productservicejuly2025.commons;

import com.ecommerce.productservicejuly2025.dtos.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthCommons {

    private RestTemplate restTemplate;

    public AuthCommons(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserDto validateToken(String tokenValue){

        ResponseEntity<UserDto> responseEntity =
                restTemplate.getForEntity(
                        "http://localhost:9090/users/validate/" + tokenValue,
                        UserDto.class
                );

        if(responseEntity.getBody()== null){
            //token is invalide
            //throw ome exception
            return null;
        }
        return responseEntity.getBody();
    }

}
