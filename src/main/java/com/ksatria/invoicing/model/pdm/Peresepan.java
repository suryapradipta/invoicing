package com.ksatria.invoicing.model.pdm;

import com.ksatria.invoicing.model.Invoice;
import com.ksatria.invoicing.model.pdm.common.Resep;
import lombok.*;
import org.openxava.annotations.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
/*@View(
    extendsView = "super.DEFAULT",
    members = "riwayatPakai {riwayatPakais}"
)*/
@View(
    members =
        "idResep;" +
            "peresepan {" +
            "lembarIdentitas;" +
            "items" +
            "};" +
            "riwayat {riwayatPakais}"
)
public class Peresepan extends Resep {

    @OneToMany(mappedBy = "peresepan")
    @CollectionView("Only")
    Collection<RiwayatPakai> riwayatPakais;
}
