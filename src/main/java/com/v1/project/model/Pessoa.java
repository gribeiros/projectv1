package com.v1.project.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Pessoa {

    private Long id;
    private String cpf;
    private Date data;
    private String endereco;
    private String nome;
    private String telefone;

}
