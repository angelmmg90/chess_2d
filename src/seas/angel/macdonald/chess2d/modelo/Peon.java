package seas.angel.macdonald.chess2d.modelo;

import seas.angel.macdonald.chess2d.vista.PanelTablero;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * Clase que define la entidad Peón
 * 
 * @author Ángel Mac Donald Gainza
 */
public class Peon extends Pieza{
                    
    /**
     * Método que comprueba si el mvto de la ficha es el correcto
     * 
     * @param tablero PanelTablero 
     * @param celdaDestino Celda 
     * 
     * @return Boolean para permitir el mvto o no
     * @throws java.io.IOException A causa de la ficha que se selecciona cuando el usuario lleva el peon al extremo del tablero
     */               
    public Boolean move( PanelTablero tablero,Celda celdaDestino) throws IOException{
        /*if(tablero.celdaAnteriorSeleccionada == celdaDestino){
            return false;
        }*/
        if(tablero.celdaAnteriorSeleccionada != null){
            //Mvto. en misma columna
            if(Objects.equals(tablero.celdaAnteriorSeleccionada.getPosEnColumnasTablero(), 
                celdaDestino.getPosEnColumnasTablero())){
                //Comprobamos si la fila en la que está posicionada la celda destino es mayor que la fila en la que 
                //está posicionada la ficha que se ha seleccionado para hacer un recorrido del for distinto en cada uno de los casos
                if(tablero.celdaAnteriorSeleccionada.getPosEnFilasTablero() < celdaDestino.getPosEnFilasTablero()){
                    for (int fila = tablero.celdaAnteriorSeleccionada.getPosEnFilasTablero()+1;
                        fila <= celdaDestino.getPosEnFilasTablero(); fila++) {
                        //Antes de comprobar si en el recorrido del mvto. de la ficha que hemos seleccionado
                        //hay alguna ficha del mismo bando, comprobamos si la celda que estamos analizando actualmente
                        //contiene una ficha o no
                        if(tablero.arrayDeCeldas[fila][tablero.celdaAnteriorSeleccionada.getPosEnColumnasTablero()].getPieza() != null){
                            
                            //En caso de encontrar una ficha delante ya sea del mismo bando o del bando contrario evitamos el mvto.
                            return false;

                            
                        }
                    }
                }else{
                    for (int fila =celdaDestino.getPosEnFilasTablero();
                        fila < tablero.celdaAnteriorSeleccionada.getPosEnFilasTablero() ; fila++) {
                        //Antes de comprobar si en el recorrido del mvto. de la ficha que hemos seleccionado
                        //hay alguna ficha del mismo bando, comprobamos si la celda que estamos analizando actualmente
                        //contiene una ficha o no
                        if(tablero.arrayDeCeldas[fila][tablero.celdaAnteriorSeleccionada.getPosEnColumnasTablero()].getPieza() != null){
                            
                            //En caso de encontrar una ficha delante ya sea del mismo bando o del bando contrario evitamos el mvto.
                            return false;
                        }
                        
                    }
                
                
                }
                
                    //Comprobamos si la pieza está en la celda origen
                    if(Objects.equals(tablero.celdaAnteriorSeleccionada.getPosEnFilasTablero(), 
                    tablero.celdaAnteriorSeleccionada.getPieza().getCeldaOrigen().getPosEnFilasTablero())){
                        //Comprobamos en que lado del tablero están las fichas
                        if(tablero.celdaAnteriorSeleccionada.getPieza().getCeldaOrigen().getPosEnFilasTablero()==1){
                            //Mvto. de 2 fila o 1 fila, a elección del jugador
                            if((celdaDestino.getPosEnFilasTablero() - tablero.celdaAnteriorSeleccionada.getPosEnFilasTablero())==1 
                                    || (celdaDestino.getPosEnFilasTablero() - tablero.celdaAnteriorSeleccionada.getPosEnFilasTablero())==2){
                                
                                return true;
                            }else{
                                return false;
                            }
                        }else if(tablero.celdaAnteriorSeleccionada.getPieza().getCeldaOrigen().getPosEnFilasTablero()==6){
                            //Mvto. de 2 fila o 1 fila, a elección del jugador
                            if((celdaDestino.getPosEnFilasTablero() - tablero.celdaAnteriorSeleccionada.getPosEnFilasTablero())==-1 
                                    || (celdaDestino.getPosEnFilasTablero() - tablero.celdaAnteriorSeleccionada.getPosEnFilasTablero())==-2){
                                
                                return true;
                            }else{
                                return false;
                            }
                        }
                        
                    }else{
                        //Para el resto de ocasiones cuando el peón esté por otras celdas que no sean su origen
                        //Comprobamos primeramente la posición de de la cual parte originalmente
                        if(tablero.celdaAnteriorSeleccionada.getPieza().getCeldaOrigen().getPosEnFilasTablero()==1){
                             //Mvto. de 1 fila
                            if((celdaDestino.getPosEnFilasTablero() - tablero.celdaAnteriorSeleccionada.getPosEnFilasTablero())==1){
                                
                                if(celdaDestino.getPosEnFilasTablero() == 7){
                                    return changePawnForAnotherPiece(tablero);
                                }else{
                                    return true;
                                }
                                
                            }else{
                                return false;
                            }
                        }else if(tablero.celdaAnteriorSeleccionada.getPieza().getCeldaOrigen().getPosEnFilasTablero()==6){
                            //Mvto. de 1 fila
                            if((celdaDestino.getPosEnFilasTablero() - tablero.celdaAnteriorSeleccionada.getPosEnFilasTablero())==-1){
                                
                                if(celdaDestino.getPosEnFilasTablero() == 0){
                                    return changePawnForAnotherPiece(tablero);
                                }else{
                                    return true;
                                }
                                
                                
                            }else{
                                return false;
                            }
                        }
                        
                    }

                }else{
                    //Para el resto de ocasiones cuando el peón esté por otras celdas que no sean su origen
                    //Comprobamos primeramente la posición de de la cual parte
                    if(tablero.celdaAnteriorSeleccionada.getPieza().getCeldaOrigen().getPosEnFilasTablero()==1){
                         //Mvto. de 1 fila
                        if((celdaDestino.getPosEnFilasTablero() - tablero.celdaAnteriorSeleccionada.getPosEnFilasTablero())==1){

                            //Si la celda destino tiene una ficha ejecutamos la función killPiece
                            if(celdaDestino.getPieza() != null){
                                if(celdaDestino.getPosEnFilasTablero() == 7){
                                    if(killPiece(tablero, celdaDestino)){
                                        return changePawnForAnotherPiece(tablero);
                                    }else{
                                        return false;
                                    }
                                }else{
                                    return killPiece(tablero, celdaDestino);
                                }
                               
                            }else{
                               return false;
                            }
                        }else{
                            return false;
                        }
                    }else if(tablero.celdaAnteriorSeleccionada.getPieza().getCeldaOrigen().getPosEnFilasTablero()==6){
                        //Mvto. de 1 fila
                        if((celdaDestino.getPosEnFilasTablero() - tablero.celdaAnteriorSeleccionada.getPosEnFilasTablero())==-1){

                            //Si la celda destino tiene una ficha ejecutamos la función killPiece
                            if(celdaDestino.getPieza() != null){
                               if(celdaDestino.getPosEnFilasTablero() == 0){
                                    if(killPiece(tablero, celdaDestino)){
                                        return changePawnForAnotherPiece(tablero);
                                    }else{
                                        return false;
                                    }
                                }else{
                                    return killPiece(tablero, celdaDestino);
                                }
                            }else{
                               return false;
                            }

                        }else{
                            return false;
                        }
                    }
                }       
        }
        return false;
    }
    /**
     * Método que se encarga de cambiar el peón por alguna de las ficha elegidas por el usuario en caso de que el peón llegue al extremo del tablero
     * 
     * @param tablero PanelTablero
     * 
     * @return boolean para saber si se ha realizado el cambio o no
     */
    private boolean changePawnForAnotherPiece(PanelTablero tablero) throws IOException{
        Torre t = new Torre();
        Alfil a = new Alfil();
        Reina r = new Reina();
        Caballo c = new Caballo();
        ArrayList<Pieza> piezasASeleccionar;
        final ImageIcon caballoIcon; 
        final ImageIcon reinaIcon; 
        final ImageIcon alfilIcon; 
        final ImageIcon torreIcon;
        BufferedImage image;
        piezasASeleccionar = tablero.pantalla.getPartida().getTablero().getArraySelectorPiezas();
        
        
        for (int i = 0; i < piezasASeleccionar.size(); i++) {
            if(Objects.equals(piezasASeleccionar.get(i).getBandoPieza(), tablero.celdaAnteriorSeleccionada.getPieza().getBandoPieza())){
                switch(piezasASeleccionar.get(i).getName()){
                    case "Torre":
                        t = (Torre) piezasASeleccionar.get(i);
                        break;
                    case "Reina":
                        r = (Reina) piezasASeleccionar.get(i);
                        break;
                    case "Caballo":
                        c = (Caballo) piezasASeleccionar.get(i);
                        break;
                    case "Alfil":
                        a = (Alfil) piezasASeleccionar.get(i);
                        break;
                }
            }
            
            
        }
        
        //Asignamos las rutas a los iconos
        torreIcon = new ImageIcon(t.getRutaImagen());
        caballoIcon = new ImageIcon(c.getRutaImagen());
        alfilIcon = new ImageIcon(a.getRutaImagen());
        reinaIcon = new ImageIcon(r.getRutaImagen());
        
        int seleccion = JOptionPane.showOptionDialog(
                                                    null,
                                                    "Seleccione una nueva pieza:", 
                                                    "Selector de piezas",
                                                    JOptionPane.YES_NO_CANCEL_OPTION,
                                                    JOptionPane.QUESTION_MESSAGE,
                                                    null,    // null para icono por defecto.
                                                    new Object[] { torreIcon, caballoIcon, alfilIcon, reinaIcon },   // null para YES, NO y CANCEL
                                                    "opcion 1");
                                                 
                                                   if(seleccion != -1){
                                                       tablero.acciones.deletePiece(tablero.celdaAnteriorSeleccionada.getPieza());
                                                       switch(seleccion){
                                                            case 0: //Torre
                                                                image = ImageIO.read(new File(t.getRutaImagen()));
                                                                tablero.celdaAnteriorSeleccionada.setRutaImagenCelda(t.getRutaImagen());
                                                                tablero.celdaAnteriorSeleccionada.setPieza(t);
                                                                tablero.celdaAnteriorSeleccionada.setImage(image);
                                                                //tablero.setImageOfPieceOnButton(tablero.celdaAnteriorSeleccionada.getCelda(), image);
                                                                c = null;
                                                                a = null;
                                                                r = null;
                                                                break;
                                                            case 1: //Caballo
                                                                image = ImageIO.read(new File(c.getRutaImagen()));
                                                                tablero.celdaAnteriorSeleccionada.setRutaImagenCelda(c.getRutaImagen());
                                                                tablero.celdaAnteriorSeleccionada.setPieza(c);
                                                                tablero.celdaAnteriorSeleccionada.setImage(image);
                                                                t = null;
                                                                a = null;
                                                                r = null;
                                                                break;
                                                            case 2: //Alfil
                                                                image = ImageIO.read(new File(a.getRutaImagen()));
                                                                tablero.celdaAnteriorSeleccionada.setRutaImagenCelda(a.getRutaImagen());
                                                                tablero.celdaAnteriorSeleccionada.setPieza(a);
                                                                tablero.celdaAnteriorSeleccionada.setImage(image);
                                                                c = null;
                                                                t = null;
                                                                r = null;
                                                                break;
                                                            case 3: //Reina
                                                                image = ImageIO.read(new File(r.getRutaImagen()));
                                                                tablero.celdaAnteriorSeleccionada.setRutaImagenCelda(r.getRutaImagen());
                                                                tablero.celdaAnteriorSeleccionada.setPieza(r);
                                                                tablero.celdaAnteriorSeleccionada.setImage(image);
                                                                c = null;
                                                                a = null;
                                                                t = null;
                                                                break;
                                                        }  
                                                       return true;
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
        Integer numFilas, numColumnas;
        numFilas = tablero.celdaAnteriorSeleccionada.getPosEnFilasTablero() - celdaDestino.getPosEnFilasTablero();
        numColumnas = tablero.celdaAnteriorSeleccionada.getPosEnColumnasTablero() - celdaDestino.getPosEnColumnasTablero();
        //Si la celda destino es la diagonal en 1 fila y 1 columna
        if(Math.abs(numFilas) == 1 && Math.abs(numColumnas) == 1){
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
        }else{
            return false;
        }
        
    }
    
}

