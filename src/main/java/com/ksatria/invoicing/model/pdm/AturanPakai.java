package com.ksatria.invoicing.model.pdm;

import lombok.*;
import org.openxava.annotations.TextArea;

import javax.persistence.Embeddable;

@Embeddable
@Getter @Setter
public class AturanPakai {
    private String metodePemberian;

    private String dosisObatDiberikan;

    private String unit;

    private String frekuensi;

    @TextArea
    private String aturanTambahan;
}
