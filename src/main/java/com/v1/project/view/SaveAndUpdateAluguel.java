package com.v1.project.view;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class SaveAndUpdateAluguel {

    private Long id;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date data;
    private Long bicicleta;
    private Long metodoDePagamento;
    private Long multa;
    private Long status;
    private Long usuario;

}
