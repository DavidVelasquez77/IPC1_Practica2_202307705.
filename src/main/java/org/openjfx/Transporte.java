package org.openjfx;

import java.util.List;
import java.util.ArrayList;

public class Transporte {
    private static List<String> tipos = new ArrayList<>();

    public static List<String> getTipos() {
        return tipos;
    }

    public static void addTipo(String tipo) {
        tipos.add(tipo);
    }
}