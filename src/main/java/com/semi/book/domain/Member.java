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
    @CreatedDate
    private LocalDateTime createDate;
    @LastModifiedDate
    private LocalDateTime lastUpdatedDate;
    @Enumerated(EnumType.STRING)
    private Grade grade;
    @Enumerated(EnumType.STRING)
    private State state;

    @Builder

    public Member(String name, Gender gender, String userId, String password, String phone, String address, LocalDateTime createDate, LocalDateTime lastUpdatedDate, Grade grade, State state) {
        this.name = name;
        this.gender = gender;
        this.userId = userId;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.createDate = createDate;
        this.lastUpdatedDate = lastUpdatedDate;
        this.grade = grade;
        this.state = state;
    }
}
