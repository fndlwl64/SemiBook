package com.semi.book.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
@Getter
@Entity
public class Member {
    @Id
    private Long member_no;
    private String name;
    private String id;
}
