/*
 * Esta clase representa cada carta del juego, con todos sus atributos, constructor y métodos observadores
 */

package es.uvigo.esei.cubirds.core;

import java.util.List;

public class Carta {
    private String especie;
    private int bandadaP;
    private int bandadaG;

    public Carta(String especie, int bandadaP, int bandadaG) {
        this.especie = especie;
        this.bandadaP = bandadaP;
        this.bandadaG = bandadaG;
    } 

    public String getEspecie() {
        return especie;
    }

    public int getBandadaP() {
        return bandadaP;
    }

    public int getBandadaG() {
        return bandadaG;
    }

    public boolean sonIguales(Carta carta){
        return this.especie.equals(carta.getEspecie());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.especie).append(" ").append(this.bandadaP).append("/").append(bandadaG);
        return sb.toString();
    }

    public static boolean contieneCarta(Carta carta, List<Carta> lista) {
        boolean toRet = false;
        for (Carta c : lista) {
            if (c.sonIguales(carta)) {
                toRet = true;
            }
        }
        return toRet;
    }
    
}
