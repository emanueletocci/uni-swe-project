package it.unisa.diem.swe.group07.rubrica.controllers;
import it.unisa.diem.swe.group07.rubrica.models.ContattoEsteso;
import it.unisa.diem.swe.group07.rubrica.models.Rubrica;
import javafx.collections.FXCollections;

import java.util.List;

public abstract class AbstractController {
    private Rubrica rubrica = new Rubrica();
    private List<ContattoEsteso> listaContatti;

    public Rubrica getRubrica() {
        return rubrica;
    }

    public List<ContattoEsteso> getListaContatti() {
        return listaContatti;
    }

    public void setListaContatti(List<ContattoEsteso> listaContatti) {
        this.listaContatti = listaContatti;
    }
}