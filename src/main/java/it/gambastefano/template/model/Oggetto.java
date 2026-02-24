package it.gambastefano.template.model;

import java.time.LocalDate;
import java.util.Set;

public class Oggetto {
    private Integer id;
    private String nome;
    private LocalDate dataInizio;
    private Set<Docente> insegnanti;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public Set<Docente> getInsegnanti() {
        return insegnanti;
    }

    public void setInsegnanti(Set<Docente> insegnanti) {
        this.insegnanti = insegnanti;
    }
}
