package com.v1.project.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Pessoa {

    private Long id;
    private String cpf;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date data;
    private String endereco;
    private String nome;
    private String telefone;

}
