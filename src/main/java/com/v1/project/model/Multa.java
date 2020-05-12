package com.v1.project.model;

import lombok.*;

import java.util.Date;

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
