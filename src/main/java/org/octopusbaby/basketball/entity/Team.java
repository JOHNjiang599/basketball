package org.octopusbaby.basketball.entity;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Team implements Serializable {

    private int teamId;//球队编号

    private String teamName;//球队名称

    private Member member;//一对多属性
}
