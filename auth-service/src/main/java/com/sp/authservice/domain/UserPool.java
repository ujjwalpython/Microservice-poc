package com.sp.authservice.domain;

import com.sp.authservice.Dto.UserInfoCache;
import com.sp.authservice.Dto.UserSignUpDto;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "user_pools")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class UserPool implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 60)
    private String name;

    @Column(nullable = false, length = 120, unique = true)
    private String email;
    @Column(nullable = false, length = 60)
    private String password;

    @Column()
    private String phoneNo;

    public UserPool(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UserPool(UserInfoCache userSignUpDto) {
        name = userSignUpDto.getName();
        email = userSignUpDto.getEmail();
        password = userSignUpDto.getPassword();
        phoneNo = userSignUpDto.getPhoneNo();
    }


    @Column()
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    List<SimpleGrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("USER"));
        return authorities;
    }
    
    @Override
    public String getUsername() {
        return this.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
