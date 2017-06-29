package seas.angel.macdonald.chess2d.controlador;

import java.util.ArrayList;
import seas.angel.macdonald.chess2d.modelo.Partida;
import seas.angel.macdonald.chess2d.modelo.Pieza;

/**
 * Clase que controla las acciones del juego.
 * 
 * @author Ángel Mac Donald
 * 
 */
public class Chess2dControlador {
    
    private final Partida partida;

    /**
     * Constructor parametrizado que recibe una partida.
     *
     * @param partida Partida.
     */
    public Chess2dControlador(Partida partida) {
        this.partida = partida;
    }
    
    /**
     * Método que elimina del trablero la pieza que recibe y la añadimos a un arrayList de piezasMuertas
     * 
     * @param pieceToDelete Pieza a eliminar
     */
    public void deletePiece (Pieza pieceToDelete){
        ArrayList<Pieza> piezasMuertas;
        pieceToDelete.setPosEnFilasTablero(null);
        pieceToDelete.setPosEnColumnasTablero(null);
        pieceToDelete.setEstaMuerta(true);
        piezasMuertas = partida.getTablero().getArrayDePiezasMuertas();
        piezasMuertas.add(pieceToDelete);
        partida.getTablero().setArrayDePiezasMuertas(piezasMuertas);
                
        
        
    }
    
    
    
}
