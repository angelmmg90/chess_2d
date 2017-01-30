package seas.angel.macdonald.chess2d.modelo;

import seas.angel.macdonald.chess2d.vista.PanelTablero;
import java.util.Objects;

/**
 * Clase que define la entidad Torre
 * 
 * @author Ángel Mac Donald Gainza
 */
public class Torre extends Pieza{
    
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
            //Mvto. en misma columna
            if(Objects.equals(tablero.celdaAnteriorSeleccionada.getPosEnColumnasTablero(), celdaDestino.getPosEnColumnasTablero())){
                //Comprobamos si la fila en la que está posicionada la celda destino es mayor que la fila en la que 
                //está posicionada la ficha que se ha seleccionado para hacer un recorrido del for distinto en cada uno de los casos
                if(tablero.celdaAnteriorSeleccionada.getPosEnFilasTablero() < celdaDestino.getPosEnFilasTablero()){
                    for (int fila = tablero.celdaAnteriorSeleccionada.getPosEnFilasTablero();
                        fila < celdaDestino.getPosEnFilasTablero(); fila++) {
                        
                        //Antes de comprobar si en el recorrido del mvto. de la ficha que hemos seleccionado
                        //hay alguna ficha del mismo bando, comprobamos si la celda que estamos analizando actualmente
                        //contiene una ficha o no
                        if(tablero.arrayDeCeldas[fila][tablero.celdaAnteriorSeleccionada.getPosEnColumnasTablero()].getPieza() != null){
                            if(tablero.celdaAnteriorSeleccionada.getPieza() != tablero.arrayDeCeldas[fila][tablero.celdaAnteriorSeleccionada.getPosEnColumnasTablero()].getPieza() ){
                                //Si la celda destino es distinta a la celda que recorremos
                                if(tablero.arrayDeCeldas[fila][tablero.celdaAnteriorSeleccionada.getPosEnColumnasTablero()] != celdaDestino && 
                                   !Objects.equals(tablero.arrayDeCeldas[fila][tablero.celdaAnteriorSeleccionada.getPosEnColumnasTablero()].getPieza().getBandoPieza(), tablero.celdaAnteriorSeleccionada.getPieza().getBandoPieza())
                                   || tablero.celdaAnteriorSeleccionada.getPieza() == tablero.arrayDeCeldas[fila][tablero.celdaAnteriorSeleccionada.getPosEnColumnasTablero()].getPieza()){

                                    return false;

                                }
                                //Antes de comprobar si en el recorrido del mvto. de la ficha que hemos seleccionado
                                //hay alguna ficha del mismo bando, comprobamos si la celda que estamos analizando actualmente
                                //contiene una ficha o no
                                if(tablero.arrayDeCeldas[fila][tablero.celdaAnteriorSeleccionada.getPosEnColumnasTablero()].getPieza() != null){
                                    if(Objects.equals(tablero.arrayDeCeldas[fila]
                                            [tablero.celdaAnteriorSeleccionada.getPosEnColumnasTablero()].getPieza().getBandoPieza(), 
                                            tablero.celdaAnteriorSeleccionada.getPieza().getBandoPieza())){
                                        //En caso de encontrar una ficha del mismo bando en el recorrido de la pieza seleccionada
                                        //evitamos que se realice el mvto.
                                        return false;

                                    }
                                }
                            }
                        }
                    }
                }else{
                    for (int fila =celdaDestino.getPosEnFilasTablero();
                        fila < tablero.celdaAnteriorSeleccionada.getPosEnFilasTablero() ; fila++) {
                        //Antes de comprobar si en el recorrido del mvto. de la ficha que hemos seleccionado
                        //hay alguna ficha del mismo bando, comprobamos si la celda que estamos analizando actualmente
                        //contiene una ficha o no
                        if(tablero.arrayDeCeldas[fila][tablero.celdaAnteriorSeleccionada.getPosEnColumnasTablero()].getPieza() != null){
                            
                            //Si la celda destino es distinta a la celda que recorremos
                            if(tablero.arrayDeCeldas[fila][tablero.celdaAnteriorSeleccionada.getPosEnColumnasTablero()] != celdaDestino && 
                              !Objects.equals(tablero.arrayDeCeldas[fila][tablero.celdaAnteriorSeleccionada.getPosEnColumnasTablero()].getPieza().getBandoPieza(), tablero.celdaAnteriorSeleccionada.getPieza().getBandoPieza())
                              || tablero.celdaAnteriorSeleccionada.getPieza() == tablero.arrayDeCeldas[fila][tablero.celdaAnteriorSeleccionada.getPosEnColumnasTablero()].getPieza()){
                                    
                                return false;
                                    
                            }
                            
                            
                            if(Objects.equals(tablero.arrayDeCeldas[fila]
                                    [tablero.celdaAnteriorSeleccionada.getPosEnColumnasTablero()].getPieza().getBandoPieza(), 
                                    tablero.celdaAnteriorSeleccionada.getPieza().getBandoPieza())){
                                //En caso de encontrar una ficha del mismo bando en el recorrido de la pieza seleccionada
                                //evitamos que se realice el mvto.
                                return false;

                            }
                        }
                        
                    }
                
                
                }
                
                //Si la celda destino tiene una ficha ejecutamos la función killPiece
                if(celdaDestino.getPieza() != null){
                   return killPiece(tablero, celdaDestino);
                }else{
                   return true;
                }
                
            //Mvto. en misma fila
            }else if(Objects.equals(tablero.celdaAnteriorSeleccionada.getPosEnFilasTablero(), celdaDestino.getPosEnFilasTablero())){
                 //Comprobamos si la fila en la que está posicionada la celda destino es mayor que la fila en la que 
                //está posicionada la ficha que se ha seleccionado para hacer un recorrido del for distinto en cada uno de los casos
                if(tablero.celdaAnteriorSeleccionada.getPosEnColumnasTablero() < celdaDestino.getPosEnColumnasTablero()){
                    
                    for (int columna = tablero.celdaAnteriorSeleccionada.getPosEnColumnasTablero()+1;
                        columna < celdaDestino.getPosEnColumnasTablero(); columna++) {
                        //Antes de comprobar si en el recorrido del mvto. de la ficha que hemos seleccionado
                        //hay alguna ficha del mismo bando, comprobamos si la celda que estamos analizando actualmente
                        //contiene una ficha o no
                        if(tablero.arrayDeCeldas[tablero.celdaAnteriorSeleccionada.getPosEnFilasTablero()][columna].getPieza() != null){
                            
                            if(Objects.equals(tablero.arrayDeCeldas[tablero.celdaAnteriorSeleccionada.getPosEnFilasTablero()]
                                    [columna].getPieza().getBandoPieza(), 
                                    tablero.celdaAnteriorSeleccionada.getPieza().getBandoPieza())){
                                //En caso de encontrar una ficha del mismo bando en el recorrido de la pieza seleccionada
                                //evitamos que se realice el mvto.
                                return false;

                            }
                        }
                    }
                    
                }else{
                    
                    for (int columna = celdaDestino.getPosEnColumnasTablero();
                        columna < tablero.celdaAnteriorSeleccionada.getPosEnColumnasTablero() ; columna++) {
                        //Antes de comprobar si en el recorrido del mvto. de la ficha que hemos seleccionado
                        //hay alguna ficha del mismo bando, comprobamos si la celda que estamos analizando actualmente
                        //contiene una ficha o no
                        if(tablero.arrayDeCeldas[tablero.celdaAnteriorSeleccionada.getPosEnFilasTablero()][columna].getPieza() != null){
                            
                            if(Objects.equals(tablero.arrayDeCeldas[tablero.celdaAnteriorSeleccionada.getPosEnFilasTablero()]
                                    [columna].getPieza().getBandoPieza(), 
                                    tablero.celdaAnteriorSeleccionada.getPieza().getBandoPieza())){
                                //En caso de encontrar una ficha del mismo bando en el recorrido de la pieza seleccionada
                                //evitamos que se realice el mvto.
                                return false;

                            }
                        }
                    }
                
                }
                
                
                //Si la celda destino tiene una ficha ejecutamos la función killPiece
                if(celdaDestino.getPieza() != null){
                   return killPiece(tablero, celdaDestino);
                }else{
                   return true;
                }
            }else{
               return false;
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
