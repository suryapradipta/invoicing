package com.ksatria.invoicing.model.pdm;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.View;
import org.openxava.model.Identifiable;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Getter
@Setter
/*@View(name = "Simple",
    members =
        "nomorRekamMedis, nomorIHS, nik;" +
            "idPelanggan, nama, tanggalLahir;" +
            "tinggiBadan, beratBadan, luasPermukaanTubuh"
)*/
public class LembarIdentitas extends Identifiable {
    private String nomorRekamMedis;

    @Column(length = 11)
    private String nomorIHS;

    /*@Column(length = 16)
    private String nik;

    private String idPelanggan;

    private String nama;

    private LocalDate tanggalLahir;

    private int tinggiBadan;

    private double beratBadan;

    private double luasPermukaanTubuh;*/
}
