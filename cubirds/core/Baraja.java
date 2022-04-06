
/*
 * Esta clase representa la baraja de juego, necesitará implementar las siguientes funcionalidades
 *  - Un constructor con las cartas de la baraja
 *  - Barajar las cartas
 *  - Devolver el número de cartas de la baraja
 *  - Coger una carta de la baraja
 *  - Insertar una carta en la baraja
 */
package es.uvigo.esei.cubirds.core;

import java.util.Queue;
import java.util.ArrayDeque;

public class Baraja {
    private Queue<Carta> baraja;
    public int cont=0;
    /**
     * Crea y mezcla la baraja.
     */
    public Baraja(){
        baraja = new ArrayDeque<>();
        for (int i = 0; i < 20; i++) {
            baraja.add(new Carta("Curruca de caña", 6, 9));
            cont++;
        }
        for (int i = 0; i < 7; i++) {
            baraja.add(new Carta("Flamenco", 2, 3));
        }
        for (int i = 0; i < 20; i++) {
            baraja.add(new Carta("Petirrojo", 6, 9));
        }
        for (int i = 0; i < 10; i++) {
            baraja.add(new Carta("Tucán", 3, 4));
        }
        for (int i = 0; i < 13; i++) {
            baraja.add(new Carta("Pato", 4, 6));
        }
        for (int i = 0; i < 17; i++) {
            baraja.add(new Carta("Urraca", 5, 7));
        }
        for (int i = 0; i < 10; i++) {
            baraja.add(new Carta("Lechuza", 3, 4));
        }
        for (int i = 0; i < 13; i++) {
            baraja.add(new Carta("Guacamayo", 4, 6));
        }
        barajar(110);
    }
    /**
     * Mezcla la baraja
     * @param numCartas Numero de cartas que tiene la baraja.
     */
    public void barajar(int numCartas){
        Carta[] cartas = new Carta[numCartas];
        for (int i = 0; i < numCartas; i++) {
            cartas[i] = this.sacarCarta();
        }
        for (int i = 0; i < numCartas; i++) {
            int random = (int)(Math.random()*numCartas);
            Carta aux = cartas[i];
            cartas[i] = cartas[random];
            cartas[random] = aux;
        }
        for (int i = 0; i < numCartas; i++) {
            baraja.add(cartas[i]);
        }
    }
    /**
     * Devuelve la carta que está en la cima de la baraja
     * @return  
     */
    public Carta sacarCarta(){
        return baraja.remove();
    }
    /**
     * Introduce la carta pasada como parámetro en la baraja
     * @param carta  
     */
    public void insertarCarta(Carta carta){
        baraja.add(carta);
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        int cont = 0;
        while(!baraja.isEmpty()){
            sb.append(baraja.remove().toString()).append("\n");
            cont ++;
        }
        sb.append(cont);
        return sb.toString();
    }
}
