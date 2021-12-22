package com.dongdaemun.dongdaemun.web.dto.myPage;

import com.dongdaemun.dongdaemun.domain.user.User;
import lombok.Getter;

import java.util.Optional;

@Getter
public class MyProfileResponseDto {

    private String name;
    private String email;
    private String club;

    public MyProfileResponseDto(Optional<User> user){
        user.ifPresent(value -> {
            this.name = value.getName();
            this.email = value.getEmail();
            this.club = value.getClub();
        });
    }

}