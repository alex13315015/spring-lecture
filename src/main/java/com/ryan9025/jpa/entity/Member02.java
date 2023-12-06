package com.ryan9025.jpa.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Getter
//@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // private으로 생성안되게!
@AllArgsConstructor
@Builder
@DynamicUpdate
@Table(name = "memberManager")
public class Member02 {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(length = 30, unique = true)
    private String userID;

    @Column(length = 100, nullable = true)
    private String password;

    @Column(length = 100)
    private String nickName;

    private Integer age;

    @Column(length = 100)
    private String email;

    @Column(length = 20, nullable = true)
    private String role;


    public void updateMemberInfo(String nickname, int age, String email) {
        this.nickName = nickname;
        this.age = age;
        this.email = email;
    }
}
