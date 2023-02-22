package com.semi.book.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Member implements UserDetails {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name="name" , length = 20 , nullable = false)
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name="gender" , nullable = false)
    private Gender gender;
    @Column(name = "user_id" , length = 30 ,unique = true , nullable = false)
    private String userId;
    @Column(name = "password" , length = 40 ,nullable = false)
    private String password;
    @Column(name = "phone_number" , length = 14 , nullable = false)
    private String phone;
    @Column(name = "address" , length = 100 , nullable = false)
    private String address;
    @Column(name = "email" , length = 100 , nullable = false)
    private String email;
    @CreatedDate
    private LocalDateTime createDate;
    @LastModifiedDate
    private LocalDateTime lastUpdatedDate;
    @Enumerated(EnumType.STRING)
    @Column(name="grade" , nullable = false)
    private Grade grade;
    @Enumerated(EnumType.STRING)
    @Column(name="state" , nullable = false)
    private State state;

    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return userId;
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
