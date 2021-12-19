package com.dongdaemun.dongdaemun.config.auth.dto;

import com.dongdaemun.dongdaemun.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;
    private String club;

    public SessionUser(User user){
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
        this.club = user.getClub();

    }
}

