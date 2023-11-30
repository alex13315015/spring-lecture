package com.ryan9025.jpa.entity;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "myBoard")
public class Board02 {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "boardId")
    private Integer id;

    private String subject;

    @Column(length = 2000)
    private String content;

}
