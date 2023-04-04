package com.semi.book.dto;

import lombok.*;

import java.util.List;

@Data
@ToString
public class MemberDTO {
    private Long id;
    private String name;
    private String gender;
    private String userId;
    private String password;
    private String phone;
    private String address;
    private String email;
    private String createDate;
    private String lastUpdateDate;
    private String grade;
    private String state;
    private List<String> roles;

    /*DB 에서 가져온 하나의 칼럼 값을 Presentation Layer(또는 Controller Layer) 에 보내기 위해 만든 인터페이스*/
    /*JpaRepository 인터페이스를 상속 받은 repository 클래스의 리턴 값 타입으로 지정할 때 사용*/

    public interface MemberUserId{
        String getUserId();
    }
    public interface MemberPassword{
        String getPassword();
    }

}
