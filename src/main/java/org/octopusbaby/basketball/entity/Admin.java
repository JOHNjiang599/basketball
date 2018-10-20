package org.octopusbaby.basketball.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Admin {

    private int id;

    private String user;//管理员用户名

    private String password;//管理员密码

    private int type;
}
