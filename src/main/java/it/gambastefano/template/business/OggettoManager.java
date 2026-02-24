package it.gambastefano.template.business;

import it.gambastefano.template.dao.OggettoDao;
import it.gambastefano.template.dto.OggettoRequestDto;
import it.gambastefano.template.dto.OggettoResponseDto;
import it.gambastefano.template.dto.DocenteResponseDto;
import it.gambastefano.template.model.Oggetto;
import it.gambastefano.template.model.Docente;

import java.util.HashSet;
import java.util.Set;

public class OggettoManager {

    public static OggettoResponseDto getOggetto(Integer id) {
        System.out.println("OggettoManager -> getOggetto");
        OggettoResponseDto res = null;

        OggettoDao dao = new OggettoDao();
        Oggetto c = dao.get(id);

        if (c != null) {
            res = new OggettoResponseDto();
            res.setNome(c.getNome());
        }

        return res;
    }

    public static boolean deleteOggetto(Integer id) {
        OggettoDao dao = new OggettoDao();
        Oggetto c = dao.get(id);
        if (c == null) {
            return false;
        }

        dao.remove(id);
        return true;
    }

    private static boolean validateOggetto(OggettoRequestDto oggetto) {
        if (oggetto.getNome() == null || oggetto.getNome().isBlank()) {
            return false;
        }

        if (oggetto.getDataInizio() == null) {
            return false;
        }

        if (oggetto.getDocentiId() != null && !oggetto.getDocentiId().isEmpty()) {
            for (Integer idDocente : oggetto.getDocentiId()) {
                DocenteResponseDto docente = DocenteManager.getDocente(idDocente);
                if (docente == null) {
                    return false;
                }
            }
        }

        return true;
    }

    public static Integer createOggetto(OggettoRequestDto oggettoReq) {
        boolean isValid = validateOggetto(oggettoReq);

        if (isValid) {
            Oggetto c = new Oggetto();
            c.setNome(oggettoReq.getNome());
            c.setDataInizio(oggettoReq.getDataInizio());

            if (oggettoReq.getDocentiId() != null) {
                Set<Docente> docenti = new HashSet<>();

                for (Integer idDocente : oggettoReq.getDocentiId()) {
                    Docente docente = DocenteManager.getDocenteEntity(idDocente);
                    docenti.add(docente);
                }

                c.setInsegnanti(docenti);
            }

            OggettoDao dao = new OggettoDao();

            return dao.set(c);
        }

        return null;
    }

    public static boolean updateOggetto(Integer id, OggettoRequestDto oggettoReq) {
        OggettoDao dao = new OggettoDao();
        Oggetto c = dao.get(id);
        if (c == null) {
            return false;
        }

        boolean isValid = validateOggetto(oggettoReq);

        if (isValid) {
            c.setNome(oggettoReq.getNome());
            c.setDataInizio(oggettoReq.getDataInizio());
            // c.setDateFine(oggettoReq.getDataFine()); // Removed as per user rejection

            dao.set(c);
            return true;
        }

        return false;
    }
}
