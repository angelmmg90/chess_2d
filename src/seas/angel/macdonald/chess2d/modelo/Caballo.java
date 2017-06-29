package seas.angel.macdonald.chess2d.modelo;

import seas.angel.macdonald.chess2d.vista.PanelTablero;
import java.io.Serializable;
import java.util.Objects;

/**
 * Clase que define la entidad Caballo
 * 
 * @author Ángel Mac Donald
 */
public class Caballo extends Pieza{
    
    /**
     * Método que comprueba si el mvto de la ficha es el correcto
     * 
     * @param tablero PanelTablero 
     * @param celdaDestino Celda 
     * 
     * @return Boolean para permitir el mvto o no
     */                     
    public Boolean move( PanelTablero tablero,Celda celdaDestino){
        if(tablero.celdaAnteriorSeleccionada != null){
            //Mvtos. diagonales
            Integer numFilas, numColumnas;
            numFilas = tablero.celdaAnteriorSeleccionada.getPosEnFilasTablero() - celdaDestino.getPosEnFilasTablero();
            numColumnas = tablero.celdaAnteriorSeleccionada.getPosEnColumnasTablero() - celdaDestino.getPosEnColumnasTablero();

            //Mvto. en "L" vertical --> 2 fil. +-1 col.
            if(Math.abs(numFilas) == 2 && Math.abs(numColumnas) == 1){
                //Si la celda destino tiene una ficha ejecutamos la función killPiece
                if(celdaDestino.getPieza() != null){
                   return killPiece(tablero, celdaDestino);
                }else{
                   return true;
                }  
            }else{
                //Mvto. en "L" horizontal --> 2 col. +- 1 fil
                if(Math.abs(numFilas) == 1 && Math.abs(numColumnas) == 2){
                    //Si la celda destino tiene una ficha ejecutamos la función killPiece
                    if(celdaDestino.getPieza() != null){
                       return killPiece(tablero, celdaDestino);
                    }else{
                       return true;
                    }  
                }else{
                    return false;
                }
            }
            
            
            
        }else{
            return false;
        }
    }
    /**
     * Método que comprueba si hay una ficha enemiga en la celdaDestino
     * 
     * @param tablero PanelTablero
     * @param celdaDestino Celda
     * 
     * @return Boolean para permitir la eliminación de la ficha o no
     */
    private Boolean killPiece(PanelTablero tablero, Celda celdaDestino){
        //Comprobamos si la ficha que hay en la celda destino es una ficha enemiga
        if(!Objects.equals(celdaDestino.getPieza().getBandoPieza(), tablero.celdaAnteriorSeleccionada.getPieza().getBandoPieza())){
            //Eliminamos la pieza de la celda destino
            tablero.acciones.deletePiece(celdaDestino.getPieza());
            
            
            //Actualizamos el Log
            if(tablero.player1.getTurnoJugador()){
                tablero.updateLog("---" + this.getName() + " Blanco/a ha eliminado  "
                        + celdaDestino.getPieza().getName() + " Negro/a ");
            }else{
                tablero.updateLog("---" + this.getName() + " Negro/a ha eliminado  "
                        + celdaDestino.getPieza().getName() + " Blanco/a");
            }
            
            //Limpiamos la celda destino.
            celdaDestino.clearCell();
            
            return true;
            
        }else{
            return false;
        }
    }
}
