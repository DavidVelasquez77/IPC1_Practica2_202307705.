package org.openjfx;

public class Viaje {
    private String puntoInicial;
    private String puntoFinal;
    private String transporte;

    public Viaje(String puntoInicial, String puntoFinal, String transporte) {
        this.puntoInicial = puntoInicial;
        this.puntoFinal = puntoFinal;
        this.transporte = transporte;
    }

    public String getPuntoInicial() {
        return puntoInicial;
    }

    public void setPuntoInicial(String puntoInicial) {
        this.puntoInicial = puntoInicial;
    }

    public String getPuntoFinal() {
        return puntoFinal;
    }

    public void setPuntoFinal(String puntoFinal) {
        this.puntoFinal = puntoFinal;
    }

    public String getTransporte() {
        return transporte;
    }

    public void setTransporte(String transporte) {
        this.transporte = transporte;
    }

    @Override
    public String toString() {
        return "Viaje{" +
            "puntoInicial='" + puntoInicial + '\'' +
            ", puntoFinal='" + puntoFinal + '\'' +
            ", tipoDeTransporte='" + transporte + '\'' +
            '}';
    }
}
