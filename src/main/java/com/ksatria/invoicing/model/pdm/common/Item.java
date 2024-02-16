package com.ksatria.invoicing.model.pdm.common;

import com.ksatria.invoicing.model.pdm.AturanPakai;
import com.ksatria.invoicing.model.pdm.Obat;
import lombok.*;

import javax.persistence.*;

@Embeddable
@Getter
@Setter
public class Item {
    @ManyToOne(fetch = FetchType.LAZY)
    Obat obat;

    private int jumlah;

    @Embedded
    private AturanPakai aturanPakai;
}
