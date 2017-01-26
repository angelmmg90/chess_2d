package seas.angel.macdonald.chess2d.modelo;

import seas.angel.macdonald.chess2d.vista.PanelTablero;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import javax.imageio.ImageIO;

/**
 * Clase que define la entidad Rey
 * 
 * @author Ángel Mac Donald Gainza
 */
public class Rey extends Pieza{
    
    private Boolean estaEnJaque = false;
    /**
     * Almacenaremos todas las piezas que tienen en jaque al rey
     */
    private ArrayList<Pieza> piezasAmenazadoras = new ArrayList<Pieza>();
    
    /**
     * Método que comprueba si el mvto de la ficha es el correcto
     * 
     * @param tablero PanelTablero 
     * @param celdaDestino Celda 
     * @param player1 Jugador 
     * @param player2 Jugador
     * 
     * @return Boolean para permitir el mvto o no
     * @throws java.io.IOException A causa del enroque
     */  
    public Boolean move( PanelTablero tablero,Celda celdaDestino, Jugador player1, Jugador  player2) throws IOException{
        if(tablero.celdaAnteriorSeleccionada != null){
            //Mvto. en misma columna o en misma fila
            if(Objects.equals(tablero.celdaAnteriorSeleccionada.getPosEnColumnasTablero(), celdaDestino.getPosEnColumnasTablero())
                    || Objects.equals(tablero.celdaAnteriorSeleccionada.getPosEnFilasTablero(), celdaDestino.getPosEnFilasTablero())){
               //Mvto. en columnas
                if((celdaDestino.getPosEnColumnasTablero() - tablero.celdaAnteriorSeleccionada.getPosEnColumnasTablero())==1){
                   //Si la celda destino tiene una ficha ejecutamos la función killPiece
                    if(celdaDestino.getPieza() != null){
                       return killPiece(tablero, celdaDestino);
                    }else{
                       return true;
                    }
                }else if((celdaDestino.getPosEnColumnasTablero() - tablero.celdaAnteriorSeleccionada.getPosEnColumnasTablero())==-1){
                   //Si la celda destino tiene una ficha ejecutamos la función killPiece
                    if(celdaDestino.getPieza() != null){
                       return killPiece(tablero, celdaDestino);
                    }else{
                       return true;
                    }            
                //Enroques
                }else if((celdaDestino.getPosEnColumnasTablero() - tablero.celdaAnteriorSeleccionada.getPosEnColumnasTablero())==2){
                   //Si la celda destino está a dos columnas y está vacía hacemos enroque
                    if(celdaDestino.getPieza() == null){
                       return enroque(tablero, celdaDestino, 1, player1, player2);
                    }else{
                       return false;
                    }            
                    
                }else if((celdaDestino.getPosEnColumnasTablero() - tablero.celdaAnteriorSeleccionada.getPosEnColumnasTablero())==-2){
                   //Si la celda destino tiene una ficha ejecutamos la función killPiece
                    if(celdaDestino.getPieza() == null){
                       return enroque(tablero, celdaDestino, -1, player1, player2);
                    }else{
                       return false;
                    }            
                    
                
                //Mvto. en filas
                }else if((celdaDestino.getPosEnFilasTablero() - tablero.celdaAnteriorSeleccionada.getPosEnFilasTablero())==1){
                    //Si la celda destino tiene una ficha ejecutamos la función killPiece
                    if(celdaDestino.getPieza() != null){
                       return killPiece(tablero, celdaDestino);
                    }else{
                       return true;
                    }  
                }else if((celdaDestino.getPosEnFilasTablero() - tablero.celdaAnteriorSeleccionada.getPosEnFilasTablero())==-1){
                    //Si la celda destino tiene una ficha ejecutamos la función killPiece
                    if(celdaDestino.getPieza() != null){
                       return killPiece(tablero, celdaDestino);
                    }else{
                       return true;
                    }  
                }
            }else{
                //Mvto. en diagonal: +1 fil. + 1 col. | + 1 fil. - 1 col. | - 1 fil. + 1 col. | - 1 fil. - 1 col.
               if((celdaDestino.getPosEnFilasTablero() - tablero.celdaAnteriorSeleccionada.getPosEnFilasTablero())==1 
                    && (celdaDestino.getPosEnColumnasTablero() - tablero.celdaAnteriorSeleccionada.getPosEnColumnasTablero())==1){
                    //Si la celda destino tiene una ficha ejecutamos la función killPiece
                    if(celdaDestino.getPieza() != null){
                       return killPiece(tablero, celdaDestino);
                    }else{
                       return true;
                    }  
                }else if((celdaDestino.getPosEnFilasTablero() - tablero.celdaAnteriorSeleccionada.getPosEnFilasTablero())==1 
                        && (celdaDestino.getPosEnColumnasTablero() - tablero.celdaAnteriorSeleccionada.getPosEnColumnasTablero())==-1){
                    //Si la celda destino tiene una ficha ejecutamos la función killPiece
                    if(celdaDestino.getPieza() != null){
                       return killPiece(tablero, celdaDestino);
                    }else{
                       return true;
                    }  
                }else if((celdaDestino.getPosEnFilasTablero() - tablero.celdaAnteriorSeleccionada.getPosEnFilasTablero())==-1 
                        && (celdaDestino.getPosEnColumnasTablero() - tablero.celdaAnteriorSeleccionada.getPosEnColumnasTablero())==1){
                    //Si la celda destino tiene una ficha ejecutamos la función killPiece
                    if(celdaDestino.getPieza() != null){
                       return killPiece(tablero, celdaDestino);
                    }else{
                       return true;
                    }  
                }else if((celdaDestino.getPosEnFilasTablero() - tablero.celdaAnteriorSeleccionada.getPosEnFilasTablero())==-1 
                        && (celdaDestino.getPosEnColumnasTablero() - tablero.celdaAnteriorSeleccionada.getPosEnColumnasTablero())==-1){
                    //Si la celda destino tiene una ficha ejecutamos la función killPiece
                    if(celdaDestino.getPieza() != null){
                       return killPiece(tablero, celdaDestino);
                    }else{
                    
                        
                       return true;
                    }  
                }
            }
            
            
            
        }
        return false;
    }
    /**
     * Método que permite realizar el enroque al rey
     * 
     * @param tablero PanelTablero 
     * @param celdaDestino Celda 
     * @param sentido Integer para saber hacia que lado del tablero se realizará el enroque
     * @param player1 Jugador 
     * @param player2 Jugador
     * 
     * @return Boolean para realizar el enroque o no
     * @throws java.io.IOException A causa del intercambio de imagenes cuando se realiza el enroque
     */  
    public Boolean enroque (PanelTablero tablero, Celda celdaDestino, Integer sentido, Jugador player1, Jugador player2) throws IOException{
        
        //Se realiza el enroque siempre y cuando no se haya realizado ningún movimiento ni con el rey ni con la torre
        //Al ser un movimiento del rey, empezamos por comprobarlo
        //También comprobamos si el rey no está en jaque
        if(this.estaEnJaque == false){
            if(tablero.celdaAnteriorSeleccionada.getPieza().getNumeroMovimiento() == null){
                //Ahora hacemos distinción entre un bando u otro
                if(tablero.celdaAnteriorSeleccionada.getPosEnFilasTablero()==0){
                    //Detectamos hacia que lado del tablero se quiere hacer el enroque
                    if(sentido == 1){
                        //Ahora comprobamos si la torre de este bando se han movido para saber si podemos hacer el enroque
                        if(tablero.arrayDeCeldas[0][7].getPieza().getNumeroMovimiento()==null){
                            if(tablero.arrayDeCeldas[0][celdaDestino.getPosEnColumnasTablero()-1].getPieza() == null){
                                
                                //Sacamos la imagen de la ruta que tenemos de la celda anterior que se ha seleccionado
                                tablero.imagenAnterior = ImageIO.read(new File(tablero.arrayDeCeldas[0][7].getPieza().getRutaImagen()));
                                //Colocamos la imagen de la torre al lado de la del rey
                                tablero.setImageOfPieceOnButton(tablero.arrayDeCeldas[0][celdaDestino.getPosEnColumnasTablero()-1], tablero.imagenAnterior);
                                //Colocamos la pieza de la torre al lado de la celda destino del rey
                                tablero.arrayDeCeldas[0][celdaDestino.getPosEnColumnasTablero()-1].setPieza(tablero.arrayDeCeldas[0][7].getPieza());
                                
                                
                                
                                // Actualizamos las posiciones del tablero lógico
                                tablero.boardUI[0][7]="0";
                                // Modificamos listeners - celdaAnteriorSeleccionada
                                tablero.arrayDeCeldas[0][7].addListeners(tablero.pantalla, 
                                        tablero, true, player1, player2);
                                tablero.boardUI[0][celdaDestino.getPosEnColumnasTablero()-1]= tablero.arrayDeCeldas[0][7].getPieza().getTipoPieza().toString();
                                // Modificamos listeners - celdaDestino
                                tablero.arrayDeCeldas[0][celdaDestino.getPosEnColumnasTablero()-1].addListeners(tablero.pantalla,
                                        tablero, false, player1, player2);
                                
                                //Quitamos la imagen en la celda que se ha seleccionado anteriormente
                                tablero.setImageOfPieceOnButton(tablero.arrayDeCeldas[0][7], null);
                                //Limpiamos la celda anterior seleccionada
                                tablero.arrayDeCeldas[0][7].clearCell();
        
                
           
                                
                                //Actualizamos el Log
                                if(tablero.player1.getTurnoJugador()){
                                    tablero.updateLog("---El Rey Blanco ha realizado un enroque");
                                }else{
                                    tablero.updateLog("---El Rey Negro ha realizado un enroque");
                                }
                                
                                return true;
                            }else{
                                return false;
                            }
                        }else{
                            return false;
                        }


                    }else if(sentido == - 1){

                        //Ahora comprobamos si la torre de este bando se han movido para saber si podemos hacer el enroque
                        if(tablero.arrayDeCeldas[0][0].getPieza().getNumeroMovimiento()==null){
                            if(tablero.arrayDeCeldas[0][celdaDestino.getPosEnColumnasTablero()+1].getPieza() == null){
                                
                                
                                //Sacamos la imagen de la ruta que tenemos de la celda anterior que se ha seleccionado
                                tablero.imagenAnterior = ImageIO.read(new File(tablero.arrayDeCeldas[0][0].getPieza().getRutaImagen()));
                                //Colocamos la imagen de la torre al lado de la del rey
                                tablero.setImageOfPieceOnButton(tablero.arrayDeCeldas[0][celdaDestino.getPosEnColumnasTablero()+1], tablero.imagenAnterior);
                                //Colocamos la pieza de la torre al lado de la celda destino del rey
                                tablero.arrayDeCeldas[0][celdaDestino.getPosEnColumnasTablero()+1].setPieza(tablero.arrayDeCeldas[0][0].getPieza());
                                
                                
                                
                                // Actualizamos las posiciones del tablero lógico
                                tablero.boardUI[0][0]="0";
                                // Modificamos listeners - celdaAnteriorSeleccionada
                                tablero.arrayDeCeldas[0][0].addListeners(tablero.pantalla, 
                                        tablero, true, player1, player2);
                                tablero.boardUI[0][celdaDestino.getPosEnColumnasTablero()+1]= tablero.arrayDeCeldas[0][0].getPieza().getTipoPieza().toString();
                                // Modificamos listeners - celdaDestino
                                tablero.arrayDeCeldas[0][celdaDestino.getPosEnColumnasTablero()+1].addListeners(tablero.pantalla,
                                        tablero, false, player1, player2);
                                
                                //Quitamos la imagen en la celda que se ha seleccionado anteriormente
                                tablero.setImageOfPieceOnButton(tablero.arrayDeCeldas[0][0], null);
                                //Limpiamos la celda anterior seleccionada
                                tablero.arrayDeCeldas[0][0].clearCell();
                                
                                
                                //Actualizamos el Log
                                if(tablero.player1.getTurnoJugador()){
                                    tablero.updateLog("---El Rey Blanco ha realizado un enroque");
                                }else{
                                    tablero.updateLog("---El Rey Negro ha realizado un enroque");
                                }
                                
                                return true;
                            }else{
                                return false;
                            }
                        }else{
                            return false;
                        }

                    }



                }else if (tablero.celdaAnteriorSeleccionada.getPosEnFilasTablero() == 7){

                    //Detectamos hacia que lado del tablero se quiere hacer el enroque
                    if(sentido == 1){
                        //Ahora comprobamos si la torre de este bando se han movido para saber si podemos hacer el enroque
                        if(tablero.arrayDeCeldas[7][7].getPieza().getNumeroMovimiento()==null){
                            if(tablero.arrayDeCeldas[7][celdaDestino.getPosEnColumnasTablero()-1].getPieza() == null){
                                 
                                
                                //Sacamos la imagen de la ruta que tenemos de la celda anterior que se ha seleccionado
                                tablero.imagenAnterior = ImageIO.read(new File(tablero.arrayDeCeldas[7][7].getPieza().getRutaImagen()));
                                //Colocamos la imagen de la torre al lado de la del rey
                                tablero.setImageOfPieceOnButton(tablero.arrayDeCeldas[7][celdaDestino.getPosEnColumnasTablero()-1], tablero.imagenAnterior);
                                //Colocamos la pieza de la torre al lado de la celda destino del rey
                                tablero.arrayDeCeldas[7][celdaDestino.getPosEnColumnasTablero()-1].setPieza(tablero.arrayDeCeldas[7][7].getPieza());
                                
                                // Actualizamos las posiciones del tablero lógico
                                tablero.boardUI[7][7]="0";
                                // Modificamos listeners - celdaAnteriorSeleccionada
                                tablero.arrayDeCeldas[7][7].addListeners(tablero.pantalla,tablero, true, player1, player2);
                                tablero.boardUI[7][celdaDestino.getPosEnColumnasTablero()-1]= tablero.arrayDeCeldas[7][7].getPieza().getTipoPieza().toString();
                                // Modificamos listeners - celdaDestino
                                tablero.arrayDeCeldas[7][celdaDestino.getPosEnColumnasTablero()-1].addListeners(tablero.pantalla,
                                        tablero, false, player1, player2);

                                //Quitamos la imagen de la torre 
                                tablero.setImageOfPieceOnButton(tablero.arrayDeCeldas[7][7], null);
                                //Limpiamos la celda de la torre
                                tablero.arrayDeCeldas[7][7].clearCell();
                                
                                //Actualizamos el Log
                                if(tablero.player1.getTurnoJugador()){
                                    tablero.updateLog("---El Rey Blanco ha realizado un enroque");
                                }else{
                                    tablero.updateLog("---El Rey Negro ha realizado un enroque");
                                }
                                
                                return true;
                            }else{
                                return false;
                            }
                        }else{
                            return false;
                        }  


                    }else if(sentido == - 1){

                        //Ahora comprobamos si la torre de este bando se han movido para saber si podemos hacer el enroque
                        if(tablero.arrayDeCeldas[7][0].getPieza().getNumeroMovimiento()==null){
                            if(tablero.arrayDeCeldas[7][celdaDestino.getPosEnColumnasTablero()+1].getPieza() == null){
                                 
                                //Sacamos la imagen de la ruta que tenemos de la celda anterior que se ha seleccionado
                                tablero.imagenAnterior = ImageIO.read(new File(tablero.arrayDeCeldas[7][0].getPieza().getRutaImagen()));
                                //Colocamos la imagen de la torre al lado de la del rey
                                tablero.setImageOfPieceOnButton(tablero.arrayDeCeldas[7][celdaDestino.getPosEnColumnasTablero()+1], tablero.imagenAnterior);
                                //Colocamos la pieza de la torre al lado de la celda destino del rey
                                tablero.arrayDeCeldas[7][celdaDestino.getPosEnColumnasTablero()+1].setPieza(tablero.arrayDeCeldas[7][0].getPieza());
                                
                                
                                
                                
                                // Actualizamos las posiciones del tablero lógico
                                tablero.boardUI[7][0]="0";
                                // Modificamos listeners - celdaAnteriorSeleccionada
                                tablero.arrayDeCeldas[7][0].addListeners(tablero.pantalla, 
                                        tablero, true, player1, player2);
                                tablero.boardUI[7][celdaDestino.getPosEnColumnasTablero()+1]= tablero.arrayDeCeldas[7][0].getPieza().getTipoPieza().toString();
                                // Modificamos listeners - celdaDestino
                                tablero.arrayDeCeldas[7][celdaDestino.getPosEnColumnasTablero()+1].addListeners(tablero.pantalla,
                                        tablero, false, player1, player2);

                                //Quitamos la imagen en la celda que se ha seleccionado anteriormente
                                tablero.setImageOfPieceOnButton(tablero.arrayDeCeldas[7][0], null);
                                //Limpiamos la celda anterior seleccionada
                                tablero.arrayDeCeldas[7][0].clearCell();
                                
                                //Actualizamos el Log
                                if(tablero.player1.getTurnoJugador()){
                                    tablero.updateLog("---El Rey Blanco ha realizado un enroque");
                                }else{
                                    tablero.updateLog("---El Rey Negro ha realizado un enroque");
                                }
                                
                                return true;
                            }else{
                                return false;
                            }
                        }else{
                            return false;
                        }

                    }    





                }


            }
        }else{
            return false;
        }
        return false;
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
            tablero.acciones.deletePiece(celdaDestino.getPieza());;
            
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
    /**
     * Comprobamos si el rey está en Jaque
     * 
     * @param tablero PanelTablero
     * @param filaRey Integer 
     * @param columnaRey Integer
     * 
     * @return Boolean para saber si se está en jaque o no
     */
    public Boolean checkJaque(PanelTablero tablero, Integer filaRey, Integer columnaRey, boolean checkJaqueDirecto){
        
        //Tengo que saber la celda actual del rey, y comprobar en todas las direcciones para ver 
        //si hay alguna amenaza, comprobar en dirección diagonal, horizontal, vertical y en L.
        
        Integer fila, columna, checkLastPosition;
        fila= filaRey;
        columna = columnaRey;
        checkLastPosition = 0; // Para asegurarnos que comprobamos los extremos de las filas o columnas sólo una vez (para Amenazas en diagonal)
        
//AMENAZAS EN FILAS (aumentamos columnas) - En filas puede haber amenazas como TORRE, REINA, REY
        //*****************
        //Comprobaremos las posibles amenazas que tenga el rey desde la posición del mismo hasta el tope
        //de columnas positivas respecto la posición del rey --> 7
        Boolean exit=false; 
        if(columna < 7){
           columna++;
        }
        do {        
            //Si encontramos una ficha enemiga
            if(tablero.arrayDeCeldas[fila][columna].getPieza() != null
                    && !Objects.equals(tablero.arrayDeCeldas[fila][columna].getPieza().getBandoPieza(), this.getBandoPieza())){
                //Comprobamos si hay una amenaza en esta fila 
                if("Torre".equals(tablero.arrayDeCeldas[fila][columna].getPieza().getName())){
                    if(checkJaqueDirecto){
                        this.setEstaEnJaque(true);
                        storeThreatToKing(tablero, tablero.arrayDeCeldas[fila][columna].getPieza(), this);
                        this.setPiezasAmenazadoras(tablero.arrayDeCeldas[fila][columna].getPieza());
                    }
                    
                    return true;
                }else if("Reina".equals(tablero.arrayDeCeldas[fila][columna].getPieza().getName())){
                    if(checkJaqueDirecto){
                        this.setEstaEnJaque(true);
                        storeThreatToKing(tablero, tablero.arrayDeCeldas[fila][columna].getPieza(), this);
                        this.setPiezasAmenazadoras(tablero.arrayDeCeldas[fila][columna].getPieza());
                    }
                    return true;
                }else if("Rey".equals(tablero.arrayDeCeldas[fila][columna].getPieza().getName())){
                    if((columnaRey)-(tablero.arrayDeCeldas[fila][columna].getPosEnColumnasTablero())==-1){
                        if(checkJaqueDirecto){
                            this.setEstaEnJaque(true);
                            storeThreatToKing(tablero, tablero.arrayDeCeldas[fila][columna].getPieza(), this);
                            this.setPiezasAmenazadoras(tablero.arrayDeCeldas[fila][columna].getPieza());
                        }
                        return true;
                    }else{
                        exit = true; 
                    }
                }else{
                   exit = true;
                   columna = columnaRey;
                }
            }else if(tablero.arrayDeCeldas[fila][columna].getPieza() != null
                    && Objects.equals(tablero.arrayDeCeldas[fila][columna].getPieza().getBandoPieza(), this.getBandoPieza())
                    && !"Rey".equals(tablero.arrayDeCeldas[fila][columna].getPieza().getName())){
                
                exit = true;
                columna = columnaRey;
            }
            
            if(exit == false){
                if(columna < 7){
                    columna++;
                }else if(columna==7){
                    exit = true;
                    //Reestablecemos el valor de la columna
                    columna = columnaRey;
                }
            }



        } while (exit==false);
        
        //Comprobaremos las posibles amenazas que tenga el rey desde la posición del mismo hasta el tope
        //de columnas negativas respecto la posición del rey --> 0
        exit = false;
        if(columna > 0){
            columna --;
        }
        do {        
            //Si encontramos una ficha enemiga
            if(tablero.arrayDeCeldas[fila][columna].getPieza() != null
                    && !Objects.equals(tablero.arrayDeCeldas[fila][columna].getPieza().getBandoPieza(), this.getBandoPieza())){
                //Comprobamos si hay una amenaza en esta fila 
                if("Torre".equals(tablero.arrayDeCeldas[fila][columna].getPieza().getName())){
                    if(checkJaqueDirecto){
                        this.setEstaEnJaque(true);
                        storeThreatToKing(tablero, tablero.arrayDeCeldas[fila][columna].getPieza(), this);
                        this.setPiezasAmenazadoras(tablero.arrayDeCeldas[fila][columna].getPieza());
                    }
                    return true;
                }else if("Reina".equals(tablero.arrayDeCeldas[fila][columna].getPieza().getName())){
                    if(checkJaqueDirecto){
                        this.setEstaEnJaque(true);
                        storeThreatToKing(tablero, tablero.arrayDeCeldas[fila][columna].getPieza(), this);
                        this.setPiezasAmenazadoras(tablero.arrayDeCeldas[fila][columna].getPieza());
                    }
                    return true;
                }else if("Rey".equals(tablero.arrayDeCeldas[fila][columna].getPieza().getName())){
                    if((columnaRey)-(tablero.arrayDeCeldas[fila][columna].getPosEnColumnasTablero())==1){
                        if(checkJaqueDirecto){
                            this.setEstaEnJaque(true);
                            storeThreatToKing(tablero, tablero.arrayDeCeldas[fila][columna].getPieza(), this);
                            this.setPiezasAmenazadoras(tablero.arrayDeCeldas[fila][columna].getPieza());
                        }
                        return true;
                    }else{
                        exit = true; 
                    }
                }else{
                    exit = true;
                    columna = columnaRey;
                }
            }else if(tablero.arrayDeCeldas[fila][columna].getPieza() != null
                    && Objects.equals(tablero.arrayDeCeldas[fila][columna].getPieza().getBandoPieza(), this.getBandoPieza())
                    && !"Rey".equals(tablero.arrayDeCeldas[fila][columna].getPieza().getName())){
                
                exit = true;
                columna = columnaRey;
            }

            if(columna > 0){
                columna--;
            }else if(columna==0){
                exit = true;
                columna = columnaRey;
            }



        } while (exit==false);
        
//AMENAZAS EN COLUMNAS (aumentamos filas) - En columnas puede haber amenazas como TORRE, REINA, REY
        //*****************
        //Comprobaremos las posibles amenazas que tenga el rey desde la posición del mismo hasta el tope
        //de filas positivas desde la posición del rey --> 7
        columna = columnaRey; //Reseteamos el valor de la columna ya que es con la que se ha operado anteriormente
        exit = false;
        if(fila < 7){
            fila ++;
        }
        do {        
            //Si encontramos una ficha enemiga
            if(tablero.arrayDeCeldas[fila][columna].getPieza() != null
                    && !Objects.equals(tablero.arrayDeCeldas[fila][columna].getPieza().getBandoPieza(), this.getBandoPieza())){
                //Comprobamos si hay una amenaza en esta columna 
                if("Torre".equals(tablero.arrayDeCeldas[fila][columna].getPieza().getName())){
                    if(checkJaqueDirecto){
                        this.setEstaEnJaque(true);
                        storeThreatToKing(tablero, tablero.arrayDeCeldas[fila][columna].getPieza(), this);
                        this.setPiezasAmenazadoras(tablero.arrayDeCeldas[fila][columna].getPieza());
                    }
                    return true;
                }else if("Reina".equals(tablero.arrayDeCeldas[fila][columna].getPieza().getName())){
                    return true;
                }else if("Rey".equals(tablero.arrayDeCeldas[fila][columna].getPieza().getName())){
                    if((filaRey)-(tablero.arrayDeCeldas[fila][columna].getPosEnFilasTablero())==-1){
                        if(checkJaqueDirecto){
                            this.setEstaEnJaque(true);
                            storeThreatToKing(tablero, tablero.arrayDeCeldas[fila][columna].getPieza(), this);
                            this.setPiezasAmenazadoras(tablero.arrayDeCeldas[fila][columna].getPieza());
                        }
                        return true;
                    }else{
                        exit = true;   
                    }
                }else{
                    exit = true;
                    fila = filaRey;
                }
            }else if(tablero.arrayDeCeldas[fila][columna].getPieza() != null
                    && Objects.equals(tablero.arrayDeCeldas[fila][columna].getPieza().getBandoPieza(), this.getBandoPieza())
                    && !"Rey".equals(tablero.arrayDeCeldas[fila][columna].getPieza().getName())){
                
                exit = true;
                fila = filaRey;
            }
            if(exit == false){
                if(fila < 7){
                    fila++;
                }else if(fila==7){
                    exit = true;
                    fila = filaRey;
                }
            }
            



        } while (exit==false);
        
        //Comprobaremos las posibles amenazas que tenga el rey desde la posición del mismo hasta el tope
        //de filas negativas respecto la posición del rey --> 0
        
        exit = false;
        if(fila > 0){
            fila --;
        }
        do {        
            //Si encontramos una ficha enemiga
            if(tablero.arrayDeCeldas[fila][columna].getPieza() != null
                    && !Objects.equals(tablero.arrayDeCeldas[fila][columna].getPieza().getBandoPieza(), this.getBandoPieza())){
                //Comprobamos si hay una amenaza en esta columna 
                if("Torre".equals(tablero.arrayDeCeldas[fila][columna].getPieza().getName())){
                    if(checkJaqueDirecto){
                        this.setEstaEnJaque(true);
                        storeThreatToKing(tablero, tablero.arrayDeCeldas[fila][columna].getPieza(), this);
                        this.setPiezasAmenazadoras(tablero.arrayDeCeldas[fila][columna].getPieza());
                    }
                    return true;
                }else if("Reina".equals(tablero.arrayDeCeldas[fila][columna].getPieza().getName())){
                    if(checkJaqueDirecto){
                        this.setEstaEnJaque(true);
                        storeThreatToKing(tablero, tablero.arrayDeCeldas[fila][columna].getPieza(), this);
                        this.setPiezasAmenazadoras(tablero.arrayDeCeldas[fila][columna].getPieza());
                    }
                    return true;
                }else if("Rey".equals(tablero.arrayDeCeldas[fila][columna].getPieza().getName())){
                    if((filaRey)-(tablero.arrayDeCeldas[fila][columna].getPosEnFilasTablero())==1){
                        if(checkJaqueDirecto){
                            this.setEstaEnJaque(true);
                            storeThreatToKing(tablero, tablero.arrayDeCeldas[fila][columna].getPieza(), this);
                            this.setPiezasAmenazadoras(tablero.arrayDeCeldas[fila][columna].getPieza());
                        }
                        return true;
                    }else{
                        exit = true;  
                    }
                }else{
                    exit = true;
                    fila = filaRey;
                    columna = columnaRey;
                }
            }else if(tablero.arrayDeCeldas[fila][columna].getPieza() != null
                    && Objects.equals(tablero.arrayDeCeldas[fila][columna].getPieza().getBandoPieza(), this.getBandoPieza())
                    && !"Rey".equals(tablero.arrayDeCeldas[fila][columna].getPieza().getName())){
                exit = true;
                fila = filaRey;
                columna = columnaRey;
            }
            
            if(exit == false){
                if(fila > 0){
                    fila--;
                }else if(fila==0){
                    exit = true;
                    fila = filaRey;
                    columna = columnaRey;
                }
            }
            
        } while (exit==false);
        
        
        
        
//AMENAZAS EN DIAGONAL (aumentamos filas y columnas) - En diagonal puede haber amenazas como ALFIL, REINA, REY y PEÓN
        //*****************
        //Comprobaremos las posibles amenazas que tenga el rey desde la posición del mismo hasta el tope
        //de FILAS y COLUMNAS POSITIVAS desde la posición del rey --> 7 COLUMNAS y 7 FILAS
        fila = filaRey; //Reseteamos el valor de la fila ya que es con la que se ha operado anteriormente
        exit = false;
        if(fila < 7){
            fila ++;
        }
        if(columna < 7){
            columna ++;
        }
        do {        
            //Si encontramos una ficha enemiga
            if(tablero.arrayDeCeldas[fila][columna].getPieza() != null
                    && !Objects.equals(tablero.arrayDeCeldas[fila][columna].getPieza().getBandoPieza(), this.getBandoPieza())){
                //Comprobamos si hay una amenaza en esta columna 
                if("Alfil".equals(tablero.arrayDeCeldas[fila][columna].getPieza().getName())){
                    if(checkJaqueDirecto){
                        this.setEstaEnJaque(true);
                        storeThreatToKing(tablero, tablero.arrayDeCeldas[fila][columna].getPieza(), this);
                        this.setPiezasAmenazadoras(tablero.arrayDeCeldas[fila][columna].getPieza());
                    }
                    return true;
                }else if("Reina".equals(tablero.arrayDeCeldas[fila][columna].getPieza().getName())){
                    if(checkJaqueDirecto){
                        this.setEstaEnJaque(true);
                        storeThreatToKing(tablero, tablero.arrayDeCeldas[fila][columna].getPieza(), this);
                        this.setPiezasAmenazadoras(tablero.arrayDeCeldas[fila][columna].getPieza());
                    }
                    return true;
                }else if("Peón".equals(tablero.arrayDeCeldas[fila][columna].getPieza().getName())){
                    
                    
                    if(tablero.arrayDeCeldas[fila][columna].getPieza().getCeldaOrigen().getPosEnFilasTablero() > filaRey
                            && tablero.arrayDeCeldas[fila][columna].getPosEnFilasTablero() > filaRey 
                            || tablero.arrayDeCeldas[fila][columna].getPieza().getCeldaOrigen().getPosEnFilasTablero() < filaRey
                            && tablero.arrayDeCeldas[fila][columna].getPosEnFilasTablero() < filaRey){
                            
                            if(((filaRey)-(tablero.arrayDeCeldas[fila][columna].getPosEnFilasTablero())==-1)
                            && (columnaRey) - (tablero.arrayDeCeldas[fila][columna].getPosEnColumnasTablero())==-1){
                                if(checkJaqueDirecto){
                                    this.setEstaEnJaque(true);
                                    storeThreatToKing(tablero, tablero.arrayDeCeldas[fila][columna].getPieza(), this);
                                    this.setPiezasAmenazadoras(tablero.arrayDeCeldas[fila][columna].getPieza());
                                }
                                return true;
                            }else{
                                exit = true;
                            }
                    }else{
                        exit = true;
                    }
                }else if("Rey".equals(tablero.arrayDeCeldas[fila][columna].getPieza().getName())){
                    if(((filaRey)-(tablero.arrayDeCeldas[fila][columna].getPosEnFilasTablero())==-1)
                            && (columnaRey) - (tablero.arrayDeCeldas[fila][columna].getPosEnColumnasTablero())==-1){
                        if(checkJaqueDirecto){
                            this.setEstaEnJaque(true);
                            storeThreatToKing(tablero, tablero.arrayDeCeldas[fila][columna].getPieza(), this);
                            this.setPiezasAmenazadoras(tablero.arrayDeCeldas[fila][columna].getPieza());
                        }
                        return true;  
                    }else{
                        exit = true;
                    }
                }else{
                    exit = true;
                    fila = filaRey;
                    columna = columnaRey;
                }
            }else if(tablero.arrayDeCeldas[fila][columna].getPieza() != null
                    && Objects.equals(tablero.arrayDeCeldas[fila][columna].getPieza().getBandoPieza(), this.getBandoPieza())
                    && !"Rey".equals(tablero.arrayDeCeldas[fila][columna].getPieza().getName())){
                exit = true;
                fila = filaRey;
                columna = columnaRey;
            }
            if(exit == false){
                if(fila < 7){
                    fila++;
                }else{
                    checkLastPosition++;
                }
                if(columna < 7){
                    columna ++;
                }else{
                    checkLastPosition++;
                }
                if(fila > 7 || columna > 7 || checkLastPosition > 0){
                    exit = true;
                    fila = filaRey;
                    columna = columnaRey;
                    checkLastPosition = 0;
                }
            }
            



        } while (exit==false);
        
        //Comprobaremos las posibles amenazas que tenga el rey desde la posición del mismo hasta el tope
        //de FILAS y COLUMNAS NEGATIVAS desde la posición del rey --> 0 FILAS y 0 COLUMNAS
       
        exit = false;
        if(fila > 0){
            fila --;
        }
        if(columna > 0){
            columna --;
        }
        do {        
            //Si encontramos una ficha enemiga
            if(tablero.arrayDeCeldas[fila][columna].getPieza() != null
                    && !Objects.equals(tablero.arrayDeCeldas[fila][columna].getPieza().getBandoPieza(), this.getBandoPieza())){
                //Comprobamos si hay una amenaza en esta columna 
                if("Alfil".equals(tablero.arrayDeCeldas[fila][columna].getPieza().getName())){
                    if(checkJaqueDirecto){
                        this.setEstaEnJaque(true);
                        storeThreatToKing(tablero, tablero.arrayDeCeldas[fila][columna].getPieza(), this);
                        this.setPiezasAmenazadoras(tablero.arrayDeCeldas[fila][columna].getPieza());
                    }
                    return true;
                }else if("Reina".equals(tablero.arrayDeCeldas[fila][columna].getPieza().getName())){
                    if(checkJaqueDirecto){
                        this.setEstaEnJaque(true);
                        storeThreatToKing(tablero, tablero.arrayDeCeldas[fila][columna].getPieza(), this);
                        this.setPiezasAmenazadoras(tablero.arrayDeCeldas[fila][columna].getPieza());
                    }
                    return true;
                }else if("Peón".equals(tablero.arrayDeCeldas[fila][columna].getPieza().getName())){
                    
                    if(tablero.arrayDeCeldas[fila][columna].getPieza().getCeldaOrigen().getPosEnFilasTablero() > filaRey
                            && tablero.arrayDeCeldas[fila][columna].getPosEnFilasTablero() > filaRey 
                            || tablero.arrayDeCeldas[fila][columna].getPieza().getCeldaOrigen().getPosEnFilasTablero() < filaRey
                            && tablero.arrayDeCeldas[fila][columna].getPosEnFilasTablero() < filaRey){
                            
                            if(((filaRey)-(tablero.arrayDeCeldas[fila][columna].getPosEnFilasTablero())==1)
                            && (columnaRey) - (tablero.arrayDeCeldas[fila][columna].getPosEnColumnasTablero())==1){
                                if(checkJaqueDirecto){
                                    this.setEstaEnJaque(true);
                                    storeThreatToKing(tablero, tablero.arrayDeCeldas[fila][columna].getPieza(), this);
                                    this.setPiezasAmenazadoras(tablero.arrayDeCeldas[fila][columna].getPieza());
                                }
                                return true;  
                            }else{
                                exit = true;
                            
                            }
                    }else{
                        exit = true;
                    }
                }else if("Rey".equals(tablero.arrayDeCeldas[fila][columna].getPieza().getName())){
                    if(((filaRey)-(tablero.arrayDeCeldas[fila][columna].getPosEnFilasTablero())==1)
                            && (columnaRey) - (tablero.arrayDeCeldas[fila][columna].getPosEnColumnasTablero())==1){
                        if(checkJaqueDirecto){
                            this.setEstaEnJaque(true);
                            storeThreatToKing(tablero, tablero.arrayDeCeldas[fila][columna].getPieza(), this);
                            this.setPiezasAmenazadoras(tablero.arrayDeCeldas[fila][columna].getPieza());
                        }
                        return true;   
                    }else{
                        exit = true;
                    }
                }else{
                    exit = true;
                    fila = filaRey;
                    columna = columnaRey;
                }
            }else if(tablero.arrayDeCeldas[fila][columna].getPieza() != null
                    && Objects.equals(tablero.arrayDeCeldas[fila][columna].getPieza().getBandoPieza(), this.getBandoPieza())
                    && !"Rey".equals(tablero.arrayDeCeldas[fila][columna].getPieza().getName())){
                exit = true;
                fila = filaRey;
                columna = columnaRey;
            }
            if(exit == false){
                if(fila > 0){
                    fila--;
                }else{
                    checkLastPosition++;
                }
                if(columna > 0){
                    columna--;
                }else{
                    checkLastPosition++;
                }
                if(fila < 0 || columna < 0 || checkLastPosition > 0){
                    exit = true;
                    fila = filaRey;
                    columna = columnaRey;
                    checkLastPosition = 0;
                }
            }
            



        } while (exit==false);
        
        
        //Comprobaremos las posibles amenazas que tenga el rey desde la posición del mismo hasta el tope
        //de FILAS POSITIVAS y COLUMNAS NEGATIVAS desde la posición del rey --> 7 FILAS y 0 COLUMNAS
        fila = filaRey;
        columna = columnaRey;
        exit = false;
        if(fila < 7){
            fila ++;
        }
        if(columna > 0){
            columna --;
        }
        do {        
            //Si encontramos una ficha enemiga
            if(tablero.arrayDeCeldas[fila][columna].getPieza() != null
                    && !Objects.equals(tablero.arrayDeCeldas[fila][columna].getPieza().getBandoPieza(), this.getBandoPieza())){
                //Comprobamos si hay una amenaza en esta columna 
                if("Alfil".equals(tablero.arrayDeCeldas[fila][columna].getPieza().getName())){
                    if(checkJaqueDirecto){
                        this.setEstaEnJaque(true);
                        storeThreatToKing(tablero, tablero.arrayDeCeldas[fila][columna].getPieza(), this);
                        this.setPiezasAmenazadoras(tablero.arrayDeCeldas[fila][columna].getPieza());
                    }
                    return true;
                }else if("Reina".equals(tablero.arrayDeCeldas[fila][columna].getPieza().getName())){
                    if(checkJaqueDirecto){
                        this.setEstaEnJaque(true);
                        storeThreatToKing(tablero, tablero.arrayDeCeldas[fila][columna].getPieza(), this);
                        this.setPiezasAmenazadoras(tablero.arrayDeCeldas[fila][columna].getPieza());
                    }
                    return true;
                }else if("Peón".equals(tablero.arrayDeCeldas[fila][columna].getPieza().getName())){
                    
                    if(tablero.arrayDeCeldas[fila][columna].getPieza().getCeldaOrigen().getPosEnFilasTablero() > filaRey
                            && tablero.arrayDeCeldas[fila][columna].getPosEnFilasTablero() > filaRey 
                            || tablero.arrayDeCeldas[fila][columna].getPieza().getCeldaOrigen().getPosEnFilasTablero() < filaRey
                            && tablero.arrayDeCeldas[fila][columna].getPosEnFilasTablero() < filaRey){
                            
                            if(((filaRey)-(tablero.arrayDeCeldas[fila][columna].getPosEnFilasTablero())==-1)
                                && (columnaRey) - (tablero.arrayDeCeldas[fila][columna].getPosEnColumnasTablero())==1){
                                if(checkJaqueDirecto){
                                    this.setEstaEnJaque(true);
                                    storeThreatToKing(tablero, tablero.arrayDeCeldas[fila][columna].getPieza(), this);
                                    this.setPiezasAmenazadoras(tablero.arrayDeCeldas[fila][columna].getPieza());
                                }
                                return true;  
                            }else{
                                exit = true;
                            }
                    }else{
                        exit = true;
                    }
                }else if("Rey".equals(tablero.arrayDeCeldas[fila][columna].getPieza().getName())){
                    if(((filaRey)-(tablero.arrayDeCeldas[fila][columna].getPosEnFilasTablero())==-1)
                            && (columnaRey) - (tablero.arrayDeCeldas[fila][columna].getPosEnColumnasTablero())==1){
                        if(checkJaqueDirecto){
                            this.setEstaEnJaque(true);
                            storeThreatToKing(tablero, tablero.arrayDeCeldas[fila][columna].getPieza(), this);
                            this.setPiezasAmenazadoras(tablero.arrayDeCeldas[fila][columna].getPieza());
                        }
                        return true;   
                    }else{
                        exit = true;
                    }
                }else{
                    exit = true;
                    fila = filaRey;
                    columna = columnaRey;
                }
            }else if(tablero.arrayDeCeldas[fila][columna].getPieza() != null
                    && Objects.equals(tablero.arrayDeCeldas[fila][columna].getPieza().getBandoPieza(), this.getBandoPieza())
                    && !"Rey".equals(tablero.arrayDeCeldas[fila][columna].getPieza().getName())){
                exit = true;
                fila = filaRey;
                columna = columnaRey;
            }
            if(exit == false){
                if(fila < 7){
                    fila++;
                }else{
                    checkLastPosition++;
                }
                if(columna > 0){
                    columna--;
                }else{
                    checkLastPosition++;
                }
                
                if(fila > 7 || columna < 0 || checkLastPosition > 0){
                    exit = true;
                    fila = filaRey;
                    columna = columnaRey;
                    checkLastPosition = 0;
                }
            }
            



        } while (exit==false);
        
        //Comprobaremos las posibles amenazas que tenga el rey desde la posición del mismo hasta el tope
        //de FILAS NEGATIVAS y COLUMNAS POSITIVAS desde la posición del rey --> 0 FILAS y 7 COLUMNAS
        
        exit = false;
        if(fila > 0){
            fila --;
        }
        if(columna < 7){
            columna ++;
        }
        do {        
            //Si encontramos una ficha enemiga
            if(tablero.arrayDeCeldas[fila][columna].getPieza() != null
                    && !Objects.equals(tablero.arrayDeCeldas[fila][columna].getPieza().getBandoPieza(), this.getBandoPieza())){
                //Comprobamos si hay una amenaza en esta columna 
                if("Alfil".equals(tablero.arrayDeCeldas[fila][columna].getPieza().getName())){
                    if(checkJaqueDirecto){
                        this.setEstaEnJaque(true);
                        storeThreatToKing(tablero, tablero.arrayDeCeldas[fila][columna].getPieza(), this);
                        this.setPiezasAmenazadoras(tablero.arrayDeCeldas[fila][columna].getPieza());
                    }
                    return true;
                }else if("Reina".equals(tablero.arrayDeCeldas[fila][columna].getPieza().getName())){
                    if(checkJaqueDirecto){
                        this.setEstaEnJaque(true);
                        storeThreatToKing(tablero, tablero.arrayDeCeldas[fila][columna].getPieza(), this);
                        this.setPiezasAmenazadoras(tablero.arrayDeCeldas[fila][columna].getPieza());
                    }
                    return true;
                }else if("Peón".equals(tablero.arrayDeCeldas[fila][columna].getPieza().getName())){
                    if(tablero.arrayDeCeldas[fila][columna].getPieza().getCeldaOrigen().getPosEnFilasTablero() > filaRey
                            && tablero.arrayDeCeldas[fila][columna].getPosEnFilasTablero() > filaRey 
                            || tablero.arrayDeCeldas[fila][columna].getPieza().getCeldaOrigen().getPosEnFilasTablero() < filaRey
                            && tablero.arrayDeCeldas[fila][columna].getPosEnFilasTablero() < filaRey){
                            
                            if(((filaRey)-(tablero.arrayDeCeldas[fila][columna].getPosEnFilasTablero())==1)
                                && (columnaRey) - (tablero.arrayDeCeldas[fila][columna].getPosEnColumnasTablero())==-1){
                                if(checkJaqueDirecto){
                                    this.setEstaEnJaque(true);
                                    storeThreatToKing(tablero, tablero.arrayDeCeldas[fila][columna].getPieza(), this);
                                    this.setPiezasAmenazadoras(tablero.arrayDeCeldas[fila][columna].getPieza());
                                }
                                return true;  
                            }else{
                                exit = true;
                            }
                    }else{
                        exit = true;
                    }
                    
                }else if("Rey".equals(tablero.arrayDeCeldas[fila][columna].getPieza().getName())){
                    if(((filaRey)-(tablero.arrayDeCeldas[fila][columna].getPosEnFilasTablero())==1)
                            && (columnaRey) - (tablero.arrayDeCeldas[fila][columna].getPosEnColumnasTablero())==-1){
                        if(checkJaqueDirecto){
                            this.setEstaEnJaque(true);
                            storeThreatToKing(tablero, tablero.arrayDeCeldas[fila][columna].getPieza(), this);
                            this.setPiezasAmenazadoras(tablero.arrayDeCeldas[fila][columna].getPieza());
                        }
                        return true;   
                    }else{
                        exit = true;
                    }
                }else{
                    exit = true;
                    fila = filaRey;
                    columna = columnaRey;
                }
            }else if(tablero.arrayDeCeldas[fila][columna].getPieza() != null
                    && Objects.equals(tablero.arrayDeCeldas[fila][columna].getPieza().getBandoPieza(), this.getBandoPieza())
                    && !"Rey".equals(tablero.arrayDeCeldas[fila][columna].getPieza().getName())){
                exit = true;
                fila = filaRey;
                columna = columnaRey;
            }
            if(exit == false){
                if(fila > 0){
                    fila--;
                }else{
                    checkLastPosition++;
                }
                if(columna < 7){
                    columna++;
                }else{
                    checkLastPosition++;
                }
                if(fila < 0 || columna > 7 || checkLastPosition > 0){
                    exit = true;
                    fila = filaRey;
                    columna = columnaRey;
                    checkLastPosition = 0;
                }
            }
            



        } while (exit==false);
        
        
  //Mvto. en "L" vertical --> 2 fil. +-1 col.
          /*  if(Math.abs(numFilas) == 2 && Math.abs(numColumnas) == 1){
                //Si la celda destino tiene una ficha ejecutamos la función killPiece
                if(celdaDestino.getPieza() != null){
                   return killPiece(tablero, celdaDestino);
                }else{
                   return true;
                }  */      
        
//AMENAZAS EN L (aumentamos filas y columnas) - En L puede haber amenazas como CABALLO
        //*****************
        //Comprobaremos las posibles amenazas que tenga el rey desde la posición del mismo hasta el tope
        //de FILAS y COLUMNAS  (MVTO. en L VERTICAL positivo y negativo) en L desde la posición del rey --> +-2 FILAS y  +-1 COLUMNAS
        fila = filaRey; 
        columna = columnaRey;
        Boolean cambioSentidoFila = false;
        Boolean cambioSentidoColumna = false;
        exit = false;
        do {
            fila = filaRey; 
            columna = columnaRey;
            if(cambioSentidoFila == false && cambioSentidoColumna == false){
                fila = fila + 2;
                columna = columna + 1;
            }else if(cambioSentidoFila == false && cambioSentidoColumna == true){
                fila = fila + 2;
                columna = columna - 1;
            }else if(cambioSentidoFila == true && cambioSentidoColumna == false){
                fila = fila - 2;
                columna = columna + 1;
            }else if(cambioSentidoFila == true && cambioSentidoColumna == true){
                fila = fila - 2;
                columna = columna - 1;
            }
            if(cambioSentidoFila && cambioSentidoColumna){
               exit = true;
            }
            if(fila <= 7 && fila >= 0 && columna <= 7 && columna >=0){
                if(tablero.arrayDeCeldas[fila][columna].getPieza() != null
                    && !Objects.equals(tablero.arrayDeCeldas[fila][columna].getPieza().getBandoPieza(), this.getBandoPieza())){
                    //Comprobamos si hay una amenaza en esta columna 
                    if("Caballo".equals(tablero.arrayDeCeldas[fila][columna].getPieza().getName())){
                        if(checkJaqueDirecto){
                            this.setEstaEnJaque(true);
                            storeThreatToKing(tablero, tablero.arrayDeCeldas[fila][columna].getPieza(), this);
                            this.setPiezasAmenazadoras(tablero.arrayDeCeldas[fila][columna].getPieza());
                        }
                        return true;
                        
                    }else{
                        if(cambioSentidoFila && cambioSentidoColumna == false){
                            cambioSentidoColumna = true;
                        }else if(cambioSentidoFila == false && cambioSentidoColumna == false){
                            cambioSentidoColumna = true;
                        }else if(cambioSentidoFila == false){
                            cambioSentidoFila = true;
                            if(cambioSentidoColumna){
                                cambioSentidoColumna = false;
                            }
                            
                        }
                        
                        
                    }
                }else{
                    if(cambioSentidoFila && cambioSentidoColumna == false){
                        cambioSentidoColumna = true;
                    }else if(cambioSentidoFila == false && cambioSentidoColumna == false){
                        cambioSentidoColumna = true;
                    }else if(cambioSentidoFila == false){
                        cambioSentidoFila = true;
                        if(cambioSentidoColumna){
                            cambioSentidoColumna = false;
                        }

                    }

                    
                }
            }else{
                if(cambioSentidoFila && cambioSentidoColumna == false){
                    cambioSentidoColumna = true;
                }else if(cambioSentidoFila == false && cambioSentidoColumna == false){
                    cambioSentidoColumna = true;
                }else if(cambioSentidoFila == false){
                    cambioSentidoFila = true;
                    if(cambioSentidoColumna){
                        cambioSentidoColumna = false;
                    }

                }
                        
                
            }
            
        } while (exit==false);
        
        //Comprobaremos las posibles amenazas que tenga el rey desde la posición del mismo hasta el tope
        //de FILAS y COLUMNAS  (MVTO. en L HORIZONTAL positivo y negativo) en L desde la posición del rey --> +-1 FILAS y  +-2 COLUMNAS
        fila = filaRey; 
        columna = columnaRey;
        cambioSentidoFila = false;
        cambioSentidoColumna = false;
        exit = false;
        do {
            fila = filaRey; 
            columna = columnaRey;
            if(cambioSentidoFila == false && cambioSentidoColumna == false){
                fila = fila + 1;
                columna = columna + 2;
            }else if(cambioSentidoFila == false && cambioSentidoColumna == true){
                fila = fila + 1;
                columna = columna - 2;
            }else if(cambioSentidoFila == true && cambioSentidoColumna == false){
                fila = fila - 1;
                columna = columna + 2;
            }else if(cambioSentidoFila == true && cambioSentidoColumna == true){
                fila = fila - 1;
                columna = columna - 2;
            }
            if(cambioSentidoFila && cambioSentidoColumna){
               exit = true;
            }
            if(fila <= 7 && fila >= 0 && columna <= 7 && columna >=0){
                if(tablero.arrayDeCeldas[fila][columna].getPieza() != null
                    && !Objects.equals(tablero.arrayDeCeldas[fila][columna].getPieza().getBandoPieza(), this.getBandoPieza())){
                    //Comprobamos si hay una amenaza en esta columna 
                    if("Caballo".equals(tablero.arrayDeCeldas[fila][columna].getPieza().getName())){
                        if(checkJaqueDirecto){
                            this.setEstaEnJaque(true);
                            storeThreatToKing(tablero, tablero.arrayDeCeldas[fila][columna].getPieza(), this);
                            this.setPiezasAmenazadoras(tablero.arrayDeCeldas[fila][columna].getPieza());
                        }
                        return true;
                        
                    }else{
                        if(cambioSentidoFila && cambioSentidoColumna == false){
                            cambioSentidoColumna = true;
                        }else if(cambioSentidoFila == false && cambioSentidoColumna == false){
                            cambioSentidoColumna = true;
                        }else if(cambioSentidoFila == false){
                            cambioSentidoFila = true;
                            if(cambioSentidoColumna){
                                cambioSentidoColumna = false;
                            }
                            
                        }
                        
                        
                    }
                }else{
                    if(cambioSentidoFila && cambioSentidoColumna == false){
                        cambioSentidoColumna = true;
                    }else if(cambioSentidoFila == false && cambioSentidoColumna == false){
                        cambioSentidoColumna = true;
                    }else if(cambioSentidoFila == false){
                        cambioSentidoFila = true;
                        if(cambioSentidoColumna){
                            cambioSentidoColumna = false;
                        }

                    }

                    
                }
            }else{
                if(cambioSentidoFila && cambioSentidoColumna == false){
                    cambioSentidoColumna = true;
                }else if(cambioSentidoFila == false && cambioSentidoColumna == false){
                    cambioSentidoColumna = true;
                }else if(cambioSentidoFila == false){
                    cambioSentidoFila = true;
                    if(cambioSentidoColumna){
                        cambioSentidoColumna = false;
                    }

                }
                        
                
            }
            
        } while (exit==false);
       
        
        return false;
            
    }   
    /**
     * Comprobamos si el rey está en Jaque Mate
     * 
     * @param tablero PanelTablero
     * @param reyAmenazado Rey que está en Jaque
     * 
     * @return Boolean para saber si se está en jaque mate o no
     */
    public Boolean checkJaqueMate(PanelTablero tablero, Rey reyAmenazado){
        Pieza pAmenazadora = null;
        
        boolean hayRescate = false;
        boolean esJaqueMate = true;
        boolean flagRescate = false;
        //A comparar fichas Blancas
        if(reyAmenazado.getBandoPieza()==1){
            //Ahora recorreremos todas las fichas que AMENAZAN con JAQUE al rey de las blancas
            for (int i = 0; i < reyAmenazado.getPiezasAmenazadoras().size(); i++) {
                //Recorremos todas las fichas blancas, comprobamos si el siguiente posible movimiento coindice
                //con alguna celda de la trayectoria amenazante de la ficha atacante.
                for (int j = 0; j < 8; j++) {
                    for (int k = 0; k < 8; k++) {
                        if(tablero.arrayDeCeldas[j][k].getPieza()!=null){
                            //Comprobamos si alguna ficha del rey Amenazado puede interponerse en la trayectoria
                            //de la ficha atacante
                                if(Objects.equals(tablero.arrayDeCeldas[j][k].getPieza().getBandoPieza(), reyAmenazado.getBandoPieza())){
                                //Tengo una ficha del bando contrario y todas las fichas que tienen en jaque al rey
                                //Recorro todas las piezas que tienen en jaque al rey
                                for (int l = 0; l < reyAmenazado.getPiezasAmenazadoras().size(); l++) {
                                    pAmenazadora = reyAmenazado.getPiezasAmenazadoras().get(l);
                                    //Recorro las filas y columnas de la trayectoria amenazante de la ficha que tiene en jaque al rey
                                    for (int m = 0; m < pAmenazadora.getFilaAmenazaRey().size(); m++) {
                                        
                                            if(!tablero.arrayDeCeldas[j][k].getPieza().getFilaPosible().isEmpty()
                                                    && !tablero.arrayDeCeldas[j][k].getPieza().getColumnaPosible().isEmpty()){
                                                //Si en ambos casos devuelve algo significa que la trayectoria 
                                                //de la ficha que tiene en jaque el rey puede ser interrumpida
                                                //por una ficha del bando que está siendo atacado, dicha ficha tiene
                                                //que ser una distinta al rey, únicamente puede ser el rey si el mismo 
                                                //puede matar a la ficha atacante.(osea cuando pAmenazadora.getFilaAmenazaRey().size == 1 y pAmenazadora.getColumnaAmenazaRey().size == 1)
                                                
                                                
                                                
                                                //Con tan sólo saber el tamaño del arraylist de filas posibles es suficiente 
                                                for (int p = 0; p < tablero.arrayDeCeldas[j][k].getPieza().getFilaPosible().size(); p++) {
                                                    //Comprobamos si coincide alguna celda de la trayectoria de la ficha atacante con
                                                    //algún posible mvto de las fichas del bando atacado.
                                                    if((pAmenazadora.getFilaAmenazaRey().get(m) == tablero.arrayDeCeldas[j][k].getPieza().getFilaPosible().get(p)) 
                                                            && (pAmenazadora.getColumnaAmenazaRey().get(m) == tablero.arrayDeCeldas[j][k].getPieza().getColumnaPosible().get(p))){
                                                            //Si estamos analizando el propio rey amenazado y la ficha atacante está a un mvto del rey
                                                            if("Rey".equals(tablero.arrayDeCeldas[j][k].getPieza().getName()) && m == 0){
                                                                flagRescate = true;
                                                                hayRescate = true;
                                                                esJaqueMate = false;
                                                                //del rey atacado no estamos ante jaque mate
                                                            }else{
                                                                //Cualquier otra pieza que no sea el rey
                                                                if(!"Rey".equals(tablero.arrayDeCeldas[j][k].getPieza().getName())){
                                                                    flagRescate = true;
                                                                    hayRescate = true;
                                                                    esJaqueMate = false;
                                                                    //Al encontrar una pieza del bando atacado que pueda interceptar la trayectoria
                                                                    //del rey atacado no estamos ante jaque mate

                                                                }
                                                            }
                                                        
                                                    }else{
                                                        if(flagRescate){
                                                            hayRescate = true;
                                                            esJaqueMate = false;
                                                        }
                                                        
                                                    }

                                                }
                                            }
                                            

                                        
                                    }
                                    //Una vez hemos comprobado todos los mvtos posibles de las ficha que estamos analizando
                                    //y no se ha encontrado ningún tipo de rescate ante el jaque impedimos el mvto con esa pieza ya que 
                                    //el jugador sólo puede mover el rey u otra ficha que impida el jaque mate
                                    if(hayRescate == false){
                                        if(!"Rey".equals(tablero.arrayDeCeldas[j][k].getPieza().getName())){
                                            tablero.arrayDeCeldas[j][k].getPieza().setMovePiece(false);
                                        }
                                          
                                    }
                                }
                            }
                        }
                        hayRescate = false;
                        flagRescate = false;
                    }
                }
            }
            
            if(esJaqueMate==true){
                return true;
            }
        //A comparar fichas Negras
        }else if(reyAmenazado.getBandoPieza()==2){
            //Ahora recorreremos todas las fichas que AMENAZAN con JAQUE al rey de las negras
            //Ahora recorreremos todas las fichas que AMENAZAN con JAQUE al rey de las blancas
            for (int i = 0; i < reyAmenazado.getPiezasAmenazadoras().size(); i++) {
                //Recorremos todas las fichas blancas, comprobamos si el siguiente posible movimiento coindice
                //con alguna celda de la trayectoria amenazante de la ficha atacante.
                for (int j = 0; j < 8; j++) {
                    for (int k = 0; k < 8; k++) {
                        if(tablero.arrayDeCeldas[j][k].getPieza()!=null){
                            //Comprobamos si alguna ficha del rey Amenazado puede interponerse en la trayectoria
                            //de la ficha atacante
                            if(Objects.equals(tablero.arrayDeCeldas[j][k].getPieza().getBandoPieza(), reyAmenazado.getBandoPieza())){
                                //Tengo una ficha del bando contrario y todas las fichas que tienen en jaque al rey
                                //Recorro todas las piezas que tienen en jaque al rey
                                for (int l = 0; l < reyAmenazado.getPiezasAmenazadoras().size(); l++) {
                                    pAmenazadora = reyAmenazado.getPiezasAmenazadoras().get(l);
                                    //Recorro las filas y columnas de la trayectoria amenazante de la ficha que tiene en jaque al rey
                                    for (int m = 0; m < pAmenazadora.getFilaAmenazaRey().size(); m++) {
                                        
                                            if(!tablero.arrayDeCeldas[j][k].getPieza().getFilaPosible().isEmpty()
                                                    && !tablero.arrayDeCeldas[j][k].getPieza().getColumnaPosible().isEmpty()){
                                                //Si en ambos casos devuelve algo significa que la trayectoria 
                                                //de la ficha que tiene en jaque el rey puede ser interrumpida
                                                //por una ficha del bando que está siendo atacado, dicha ficha tiene
                                                //que ser una distinta al rey, únicamente puede ser el rey si el mismo 
                                                //puede matar a la ficha atacante.(osea cuando pAmenazadora.getFilaAmenazaRey().size == 1 y pAmenazadora.getColumnaAmenazaRey().size == 1)
                                                
                                                
                                                
                                                //Con tan sólo saber el tamaño del arraylist de filas posibles es suficiente 
                                                for (int p = 0; p < tablero.arrayDeCeldas[j][k].getPieza().getFilaPosible().size(); p++) {
                                                    //Comprobamos si coincide alguna celda de la trayectoria de la ficha atacante con
                                                    //algún posible mvto de las fichas del bando atacado.
                                                    if((pAmenazadora.getFilaAmenazaRey().get(m) == tablero.arrayDeCeldas[j][k].getPieza().getFilaPosible().get(p)) 
                                                            && (pAmenazadora.getColumnaAmenazaRey().get(m) == tablero.arrayDeCeldas[j][k].getPieza().getColumnaPosible().get(p))){
                                                        //Si estamos analizando el propio rey amenazado y la ficha atacante está a un mvto del rey
                                                        if("Rey".equals(tablero.arrayDeCeldas[j][k].getPieza().getName()) && m == 0){
                                                            //Comprobamos que la posición de la ficha atacante que está a un mvto del rey no está en jaque
                                                            if(reyAmenazado.checkJaque(tablero, pAmenazadora.getPosEnFilasTablero(), pAmenazadora.getPosEnColumnasTablero(), false)==false){
                                                                flagRescate = true;
                                                                hayRescate = true;
                                                                esJaqueMate = false;
                                                            }
                                                            
                                                            //del rey atacado no estamos ante jaque mate
                                                        }else{
                                                            //Cualquier otra pieza que no sea el rey
                                                            if(!"Rey".equals(tablero.arrayDeCeldas[j][k].getPieza().getName())){
                                                                flagRescate = true;
                                                                hayRescate = true;
                                                                esJaqueMate = false;
                                                                //Al encontrar una pieza del bando atacado que pueda interceptar la trayectoria
                                                                //del rey atacado no estamos ante jaque mate
                                                                
                                                            }
                                                        }
                                                        
                                                    }else{
                                                        if(flagRescate){
                                                            hayRescate = true;
                                                            esJaqueMate = false;
                                                        }
                                                        
                                                    }

                                                }
                                            }
                                    }
                                    //Una vez hemos comprobado todos los mvtos posibles de las ficha que estamos analizando
                                    //y no se ha encontrado ningún tipo de rescate ante el jaque impedimos el mvto con esa pieza ya que 
                                    //el jugador sólo puede mover el rey u otra ficha que impida el jaque mate
                                    if(hayRescate == false){
                                        if(!"Rey".equals(tablero.arrayDeCeldas[j][k].getPieza().getName())){
                                            tablero.arrayDeCeldas[j][k].getPieza().setMovePiece(false);
                                        }
                                          
                                    }
                                }
                            }
                        }
                        hayRescate = false;
                        flagRescate = false;
                        
                    }
                }
            }
            
            if(esJaqueMate==true){
                return true;
            }
            
        }
        
        return false;
        
    }
    
    /**
     * Limpiamos el ArrayList de piezas amenazadoras
     * 
     */
    public void borrarPiezasAmenazadoras(){
        this.piezasAmenazadoras.clear();
    }
    
    /**
     * Getter de la estaEnJaque.
     *
     * @return Boolean estaEnJaque.
     */
    public Boolean getEstaEnJaque() {
        return estaEnJaque;
    }
    /**
     * Setter de estaEnJaque.
     *
     * @param estaEnJaque Boolean
     */
    public void setEstaEnJaque(Boolean estaEnJaque) {
        this.estaEnJaque = estaEnJaque;
    } 
    /**
     * Getter de la piezasAmenazadoras.
     *
     * @return ArrayList piezasAmenazadoras.
     */
    public ArrayList<Pieza> getPiezasAmenazadoras() {
        return piezasAmenazadoras;
    }
    /**
     * Setter de piezasAmenazadoras.
     *
     * @param piezasAmenazadoras Pieza
     */
    public void setPiezasAmenazadoras(Pieza piezasAmenazadoras) {
        this.piezasAmenazadoras.add(piezasAmenazadoras);
    }
    
    

    
    
    
    
}

