/*
 * Esta clase representa el montón de descartes. Funcionalidades a implementar:
 * - Constructor para crear un montón
 * - añadir carta
 */
package es.uvigo.esei.cubirds.core;

import java.util.Stack;

public class MontonDescartes {
    private Stack<Carta> descartes;

    public MontonDescartes(){
        descartes = new Stack<>();
    }
    /**
     * Añade numCartas unidades de la carta pasada como parámetro al montón de descartes
     * @param carta
     * @param numCartas
     */
    public void addDescarte(Carta carta,int numCartas){
        for (int i = 0; i < numCartas; i++) {
            descartes.push(carta);
        }
    }
    /**
     * Añade la carta pasada como parámetro al montón de descartes
     * @param carta 
     */
    public void addDescarte(Carta carta){
        descartes.push(carta);
    }
}
