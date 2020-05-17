package com.v1.project.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Multa {

    private Long id;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date data;
    private Long valor;

}
