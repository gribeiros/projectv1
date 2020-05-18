package com.v1.project.util;

import com.v1.project.model.Multa;


import java.sql.Date;
import java.time.LocalDate;

public class CalculaMuta {

    private static final Long VALOR = 2L;
    private static final Long DAY = 86400000L;

    public CalculaMuta(Date tempo) {
    }

    public static Multa aplicaMulta(Date date) {
        Date utilDate = Date.valueOf(LocalDate.now());

        Long atraso = (date.getTime() - utilDate.getTime()) / DAY;

        Long valorMulta = VALOR * atraso;

        Multa multa = new Multa( utilDate, valorMulta);

        return multa;
    }

}
