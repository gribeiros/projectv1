package com.v1.project.model;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Multa {

    private Long id;
    private Date data;
    private Long valor;

}
