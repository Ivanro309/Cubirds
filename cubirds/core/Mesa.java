/*
 * Esta clase representa la mesa común a todos los jugadores. Funcionalidades a implementar:
 * - Constructor que cree la mesa
 * - Colocar la mesa inicial cumpliendo las restricciones
 * - Rellenar fila de la mesa cumpliendo las restricciones
 * - Insertar cartas
 * - Eliminar cartas rodeadas
 * - Mostrar mesa
 */
package es.uvigo.esei.cubirds.core;
import java.util.List;
import java.util.LinkedList;

public class Mesa {

    private final int MAX_FILAS = 4;
    private List<Carta>[] mesa;

    public Mesa() {
        this.mesa = new LinkedList[MAX_FILAS];
        for (int i = 0; i < mesa.length; i++) {
            mesa[i] = new LinkedList<>();
        }
    }

    public void colocarMesaInicial(Baraja baraja) {
        for (int i = 0; i < MAX_FILAS; i++) {
            while (mesa[i].size() < 3) {
                Carta cartaIntroducir = baraja.sacarCarta();
                if (Carta.contieneCarta(cartaIntroducir, mesa[i])) {
                    baraja.insertarCarta(cartaIntroducir);
                } else {
                    mesa[i].add(cartaIntroducir);
                }
            }
        }
    }

    public void insertar(Carta carta, int fila, boolean extremo, int numCartas, Baraja baraja) {
        cartasRodeadas(carta, fila, extremo);
        for (int i = 0; i < numCartas; i++) {
            insertar(carta, fila, extremo);
        }
        rellenar(baraja, fila);
    }

    public void insertar(Carta carta, int fila, boolean extremo) {
        if (extremo) {
            mesa[fila].add(carta);
        } else {
            mesa[fila].add(0, carta);
        }
    }

    public List<Carta> cartasRodeadas(Carta carta, int fila, boolean extremo) {
        List<Carta> toRet = new LinkedList<>();
        if (Carta.contieneCarta(carta, mesa[fila])) {
            if (extremo) {
                for (int i = mesa[fila].size() - 1; i >= 0 && !mesa[fila].get(i).sonIguales(carta); i--) {
                    toRet.add(mesa[fila].get(i));
                }
            } else {
                for (int i = 0; i < mesa[fila].size() && !mesa[fila].get(i).sonIguales(carta); i++) {
                    toRet.add(mesa[fila].get(i));
                }
            }
            for (Carta cartasRodeadas : toRet) {
                mesa[fila].remove(cartasRodeadas);
            }
        }
        System.out.println(toRet);
        return toRet;
    }
    
    public void rellenar(Baraja baraja, int fila){
        boolean rellenar = true;
        for (int i = 0; i < mesa[fila].size() - 1; i++) {
            if(!mesa[fila].get(i).sonIguales(mesa[fila].get(i + 1)))
                rellenar = false;
        }
        if(rellenar){
            while(rellenar){
                Carta cartaIntroducir = baraja.sacarCarta();
                if (cartaIntroducir.sonIguales(mesa[fila].get(0))) {
                    baraja.insertarCarta(cartaIntroducir);
                } else {
                    mesa[fila].add(cartaIntroducir);
                    rellenar = false;
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Mesa: \n");
        for (int i = 0; i < MAX_FILAS; i++) {
            for (Carta carta : mesa[i]) {
                sb.append(carta);
                sb.append(carta.getEspecie().equals("Curruca de caña") ? "\t" : "\t\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
