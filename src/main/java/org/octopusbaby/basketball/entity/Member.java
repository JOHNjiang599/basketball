package org.octopusbaby.basketball.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Member {

    private int memberId;//球员编号，即球衣号

    private String memberName;//球员名称

    private boolean firstStart;//是否首发
}
