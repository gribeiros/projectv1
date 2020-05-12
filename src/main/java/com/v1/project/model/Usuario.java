package com.v1.project.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Usuario {

    private Long id;
    private String login;
    private String senha;
    private Pessoa pessoa;

}
