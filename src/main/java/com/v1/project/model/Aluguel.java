package com.v1.project.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Aluguel {

    private Long id;
    private Date data;
    private Bicicleta bicicleta;
    private MetodoDePagamento metodoDePagamento;
    private Multa multa;
    private Status status;
    private Usuario usuario;

}
