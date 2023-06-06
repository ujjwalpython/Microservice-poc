package com.sp.authservice.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sp.authservice.domain.UserPool;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoggerUserInfoDto {
    private String name;

    private String email;

    private String phoneNo;

    private List<String> userRoles;

    public LoggerUserInfoDto(UserPool userPool) {
        name = userPool.getName();
        email = userPool.getEmail();
        phoneNo = userPool.getPhoneNo();;
        userRoles = userPool.getAuthorities().stream().map(grantedAuthority -> grantedAuthority.getAuthority()).toList();
    }
}
