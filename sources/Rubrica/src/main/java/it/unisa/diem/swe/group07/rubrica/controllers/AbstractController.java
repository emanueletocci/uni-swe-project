package it.unisa.diem.swe.group07.rubrica.controllers;
import it.unisa.diem.swe.group07.rubrica.models.ContattoEsteso;
import it.unisa.diem.swe.group07.rubrica.models.Rubrica;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public abstract class AbstractController {
    private Rubrica rubrica = new Rubrica();
    private ObservableList<ContattoEsteso> listaContatti = FXCollections.observableArrayList();

    public Rubrica getRubrica() {
        return rubrica;
    }
    public void setRubrica(Rubrica rubrica) {
        this.rubrica = rubrica;
    }
    public ObservableList<ContattoEsteso> getListaContatti() {
        return listaContatti;
    }

    public void setListaContatti(ObservableList<ContattoEsteso> listaContatti) {
        this.listaContatti = listaContatti;
    }
}