package org.octopusbaby.basketball.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Match {

    private int id;

    private String MatchTime;

    private int EventType;

    private int memberId;

    private int teamId;
}
