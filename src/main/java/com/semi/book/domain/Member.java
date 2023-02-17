package com.semi.book.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@ToString
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
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

    @Builder
    public Member(Long id, String name, Gender gender, String userId, String password, String phone, String address, String email, LocalDateTime createDate, LocalDateTime lastUpdatedDate, Grade grade, State state) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.userId = userId;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.createDate = createDate;
        this.lastUpdatedDate = lastUpdatedDate;
        this.grade = grade;
        this.state = state;
    }
}
