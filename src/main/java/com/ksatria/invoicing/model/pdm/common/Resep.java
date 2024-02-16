package com.ksatria.invoicing.model.pdm.common;

import com.ksatria.invoicing.model.pdm.LembarIdentitas;
import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.ListProperties;
import org.openxava.annotations.ReferenceView;
import org.openxava.annotations.TextArea;
import org.openxava.annotations.View;
import org.openxava.model.Identifiable;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.Collection;

@Entity
@Getter
@Setter
/*@View(members =
    "idResep;" +
        "peresepan {" +
            "lembarIdentitas;" +
            "items" +
        "}"
)*/
abstract public class Resep extends Identifiable {
    @ManyToOne(fetch = FetchType.LAZY)
//    @ReferenceView("Simple")
    private LembarIdentitas lembarIdentitas;

    private String idResep;

    @ElementCollection
    @ListProperties("obat.id, obat.nama, obat.bentukSediaan, jumlah, aturanPakai.metodePemberian, aturanPakai.dosisObatDiberikan, aturanPakai.unit, aturanPakai.frekuensi, aturanPakai.aturanTambahan ")
    Collection<Item> items;
}
