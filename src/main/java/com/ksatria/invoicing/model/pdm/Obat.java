package com.ksatria.invoicing.model.pdm;

import lombok.*;
import org.openxava.model.Identifiable;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Obat extends Identifiable{
    private String id;

    private String nama;

    private String bentukSediaan;


}

