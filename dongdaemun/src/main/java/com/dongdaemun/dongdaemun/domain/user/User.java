package com.dongdaemun.dongdaemun.domain.user;

import com.dongdaemun.dongdaemun.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//이름 닉네임
@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    @Column(nullable = false)
    private String club;

    @Enumerated(EnumType.STRING) // 1.
    @Column(nullable = false)
    private Role role;

    @Builder
    public User(String name, String email, String picture, String club, Role role){
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.club = club;
        this.role = role;
    }


    public User update(String name, String picture){
        this.name = name;
        this.picture = picture;

        return this;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }
}

