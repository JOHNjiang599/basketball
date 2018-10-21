package org.octopusbaby.basketball.entity;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User implements Serializable {

    private int id;

    private String userName;//用户名

    private String password;//用户密码

    private String userType;
}
