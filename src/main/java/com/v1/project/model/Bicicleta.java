package com.v1.project.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Bicicleta {

    private Long id;
    private Marca marca;
    private Modelo modelo;
    private Cor cor;

}
