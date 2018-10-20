package org.octopusbaby.basketball.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Team {

    private int teamId;//球队编号

    private String teamName;//球队名称

    private Member member;//一对多
}
