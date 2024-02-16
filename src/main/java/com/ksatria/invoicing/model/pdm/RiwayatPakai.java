package com.ksatria.invoicing.model.pdm;

import com.ksatria.invoicing.model.Order;
import com.ksatria.invoicing.model.pdm.common.Resep;

import java.util.*;
import javax.persistence.*;

import lombok.*;
import org.openxava.annotations.CollectionView;
import org.openxava.annotations.ReferenceView;
import org.openxava.annotations.View;

@Entity
@Getter
@Setter
@View(
    members =
            "riwayatPakai {items}"
)

@View( name="Only",
    members= "items"
)
public class RiwayatPakai extends Resep {
    @ManyToOne
    Peresepan peresepan;
}
