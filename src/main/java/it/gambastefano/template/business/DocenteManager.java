package it.gambastefano.template.business;

import it.gambastefano.template.dto.DocenteResponseDto;
import it.gambastefano.template.model.Docente;

public class DocenteManager {

    public static DocenteResponseDto getDocente(Integer id) {
        // Mock implementation
        if (id == 1) {
            DocenteResponseDto dto = new DocenteResponseDto();
            dto.setNome("Mario");
            dto.setCognome("Rossi");
            return dto;
        }
        return null;
    }

    public static Docente getDocenteEntity(Integer id) {
        // Mock implementation
        if (id == 1) {
            Docente docente = new Docente();
            docente.setId(1);
            docente.setNome("Mario");
            docente.setCognome("Rossi");
            return docente;
        }
        return null;
    }
}
