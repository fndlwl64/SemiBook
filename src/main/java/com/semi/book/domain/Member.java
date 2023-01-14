package com.semi.book.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Member {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String user_id;
    @Enumerated(EnumType.STRING)
    private Grade grade;
}
