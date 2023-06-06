package com.sp.authservice.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoCache implements Serializable {
    private String name;

    private String email;

    private String password;

    private String phoneNo;

    private Integer otp;

    public UserInfoCache(UserSignUpDto userSignUpDto) {
        name = userSignUpDto.getName();
        email = userSignUpDto.getEmail();
        password = userSignUpDto.getPassword();
        phoneNo = userSignUpDto.getPhoneNo();
    }
}
