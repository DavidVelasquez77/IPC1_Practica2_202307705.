package org.openjfx;

import javafx.beans.property.SimpleStringProperty;

public class Recorrido {
    private final SimpleStringProperty id;
    private final SimpleStringProperty inicio;
    private final SimpleStringProperty fin;
    private final SimpleStringProperty distancia;

    public Recorrido(String id, String inicio, String fin, String distancia) {
        this.id = new SimpleStringProperty(id);
        this.inicio = new SimpleStringProperty(inicio);
        this.fin = new SimpleStringProperty(fin);
        this.distancia = new SimpleStringProperty(distancia);
    }   

        public String getId() {
            return id.get();
        }

        public void setId(String id) {
            this.id.set(id);
        }

        public String getInicio() {
            return inicio.get();
        }

        public void setInicio(String inicio) {
            this.inicio.set(inicio);
        }

        public String getFin() {
            return fin.get();
        }

        public void setFin(String fin) {
            this.fin.set(fin);
        }

        public String getDistancia() {
            return distancia.get();
        }

        public void setDistancia(String distancia) {
            this.distancia.set(distancia);
        }
    }
    
    
