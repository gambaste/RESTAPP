package it.gambastefano.template.dao;

import it.gambastefano.template.model.Oggetto;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class OggettoDao {

    private static Map<Integer, Oggetto> database = new HashMap<>();

    public OggettoDao() {
        if (database.isEmpty()) {
            Oggetto oggetto = new Oggetto();
            oggetto.setId(1);
            oggetto.setNome("Java");
            oggetto.setDataInizio(LocalDate.of(2026, 1, 8));
            database.put(oggetto.getId(), oggetto);
        }
    }

    public Oggetto get(Integer id) {
        return database.get(id);
    }

    public Integer set(Oggetto oggetto) {
        Integer maxKey = Collections.max(database.keySet());
        database.put(maxKey+1, oggetto);
        return maxKey+1;
    }

    public void remove(Integer id) {
        database.remove(id);
    }
}