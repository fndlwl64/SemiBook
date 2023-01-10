package com.semi.book.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
@Getter
@Setter
@Entity
public class Member {
    @Id
    private Long member_no;
    private String member_name;
    private String member_id;
}
