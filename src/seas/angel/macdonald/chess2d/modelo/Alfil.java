package seas.angel.macdonald.chess2d.modelo;

import seas.angel.macdonald.chess2d.vista.PanelTablero;
import java.util.Objects;

/**
 * Clase que define la entidad Alfil
 * 
 * @author Ángel Mac Donald Gainza
 */
public class Alfil extends Pieza{

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
            Integer numFilas, numColumnas, columna, filaTope;
            
            numFilas = tablero.celdaAnteriorSeleccionada.getPosEnFilasTablero() - celdaDestino.getPosEnFilasTablero();
            numColumnas = tablero.celdaAnteriorSeleccionada.getPosEnColumnasTablero() - celdaDestino.getPosEnColumnasTablero();
            columna = tablero.celdaAnteriorSeleccionada.getPosEnColumnasTablero();
            
            if(numFilas > tablero.celdaAnteriorSeleccionada.getPosEnFilasTablero()){
                filaTope = numFilas + tablero.celdaAnteriorSeleccionada.getPosEnFilasTablero();
            }else{
                filaTope = tablero.celdaAnteriorSeleccionada.getPosEnFilasTablero() - numFilas;
            }
            
            //Si el número de filas y columnas desde la celda origen hasta la celda destino mismo
            if(Objects.equals(Math.abs(numFilas), Math.abs(numColumnas))){
                
                
                
                //Comprobamos primeramente la posición de de la cual parte para saber si restar o sumar filas
                if(tablero.celdaAnteriorSeleccionada.getPosEnFilasTablero() < celdaDestino.getPosEnFilasTablero()){
                    for(int fila = tablero.celdaAnteriorSeleccionada.getPosEnFilasTablero();
                        fila <= filaTope; fila++){ 
                    
                        //Antes de comprobar si en el recorrido del mvto. de la ficha que hemos seleccionado
                        //hay alguna ficha del mismo bando, comprobamos si la celda que estamos analizando actualmente
                        //contiene una ficha o no
                        if(tablero.arrayDeCeldas[fila][columna].getPieza() != null){
                            if(tablero.celdaAnteriorSeleccionada.getPieza() != tablero.arrayDeCeldas[fila][columna].getPieza() ){
                                //Si la celda destino es distinta a la celda que recorremos
                                if(tablero.arrayDeCeldas[fila][columna] != celdaDestino && 
                                        !Objects.equals(tablero.arrayDeCeldas[fila][columna].getPieza().getBandoPieza(), tablero.celdaAnteriorSeleccionada.getPieza().getBandoPieza())
                                        || tablero.celdaAnteriorSeleccionada.getPieza() == tablero.arrayDeCeldas[fila][columna].getPieza()){
                                    
                                    return false;
                                    
                                }
                                if(Objects.equals(tablero.arrayDeCeldas[fila][columna].getPieza().getBandoPieza(), 
                                        tablero.celdaAnteriorSeleccionada.getPieza().getBandoPieza())){
                                    //En caso de encontrar una ficha del mismo bando en el recorrido de la pieza seleccionada
                                    //evitamos que se realice el mvto.
                                    return false;

                                }
                            }
                        }
                        if(celdaDestino.getPosEnColumnasTablero() >tablero.celdaAnteriorSeleccionada.getPosEnColumnasTablero()){
                            columna++;
                        }else{
                            columna--;
                        }
                        
                    
                    }
                }else{
                    Integer fila = tablero.celdaAnteriorSeleccionada.getPosEnFilasTablero();
                    Boolean exit = false;
                    if(tablero.celdaAnteriorSeleccionada.getPieza() != celdaDestino.getPieza()){
                        do {
                            //Antes de comprobar si en el recorrido del mvto. de la ficha que hemos seleccionado
                            //hay alguna ficha del mismo bando, comprobamos si la celda que estamos analizando actualmente
                            //contiene una ficha o no
                            if(tablero.arrayDeCeldas[fila][columna].getPieza() != null){
                                if(tablero.celdaAnteriorSeleccionada.getPieza() != tablero.arrayDeCeldas[fila][columna].getPieza()){
                                    /*if(Objects.equals(tablero.arrayDeCeldas[fila][columna].getPieza().getBandoPieza(), 
                                            tablero.celdaAnteriorSeleccionada.getPieza().getBandoPieza())){*/
                                        //En caso de encontrar una ficha del mismo bando en el recorrido de la pieza seleccionada
                                        //evitamos que se realice el mvto.
                                        return false;

                                    //}
                                }
                            }
                            
                            if(celdaDestino.getPosEnFilasTablero() >tablero.celdaAnteriorSeleccionada.getPosEnFilasTablero()){
                                fila++;
                            }else if (fila != 0 ){
                                fila--;
                            }
                            
                            
                            if(celdaDestino.getPosEnColumnasTablero() >tablero.celdaAnteriorSeleccionada.getPosEnColumnasTablero()){
                                columna++;
                            }else if(columna != 0){
                                columna--;
                            }
                            

                            if(Objects.equals(filaTope,fila)){
                                exit = true;
                            }
                        } while (exit==false);
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
