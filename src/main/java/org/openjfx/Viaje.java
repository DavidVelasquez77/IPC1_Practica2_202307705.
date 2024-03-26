package org.openjfx;

public class Viaje {
    private String puntoInicial;
    private String puntoFinal;
    private String transporte;
    private double capacidadGasolina;
    private double consumoGasolina;
    private double recorridoTotal = 0;

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

        // Getters y setters para los nuevos campos
        public double getCapacidadGasolina() {
            return capacidadGasolina;
        }
    
        public void setCapacidadGasolina(double capacidadGasolina) {
            this.capacidadGasolina = capacidadGasolina;
        }
    
        public double getConsumoGasolina() {
            return consumoGasolina;
        }
    
        public void setConsumoGasolina(double consumoGasolina) {
            this.consumoGasolina = consumoGasolina;
        }
        public double getRecorridoTotal() {
            return recorridoTotal;
        }

        public void incrementarRecorridoTotal(double incremento) {
            this.recorridoTotal += incremento;
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
