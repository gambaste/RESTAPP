package it.gambastefano.template.dto;

import java.time.LocalDate;
import java.util.List;

public class OggettoRequestDto {
    private String nome;
    private LocalDate dataInizio;
    private List<Integer> docentiId;

    public List<Integer> getDocentiId() {
        return docentiId;
    }

    public void setDocentiId(List<Integer> docentiId) {
        this.docentiId = docentiId;
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
}
