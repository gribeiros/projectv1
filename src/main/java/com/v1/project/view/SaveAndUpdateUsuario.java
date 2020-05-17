package com.v1.project.view;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class SaveAndUpdateUsuario {

    private Long id;
    private String login;
    private String senha;
    private Long pessoa;

}
