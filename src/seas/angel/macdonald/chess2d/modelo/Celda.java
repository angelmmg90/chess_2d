package seas.angel.macdonald.chess2d.modelo;

import seas.angel.macdonald.chess2d.vista.PanelTablero;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Clase que define la entidad Celda, implementa la interfaz serializable para poder realizar el grabado de archivos
 * 
 * @author Ángel Mac Donald Gainza
 */
public class Celda extends JButton  implements Serializable{
    
    private static Jugador p1;
    private static Jugador p2;
    MouseListener listener;
    private Boolean mvtoRealizado = false;
    private Pieza pieza;
    private String rutaImagenCelda;
    private Boolean cellIsEmpty;
    private Boolean isClicked;
    private Boolean isPressed;
    private Boolean isPressedCellEmpty;
    private Boolean isReleased;
    private Boolean isEntered;
    private Boolean isExited;
    public static Celda cellEntered;
    public static Celda cellReleased;
    
    /**
     * Variable que almacena la imagen a implementar, se declara como transient para que no se tenga en cuenta a la hora 
     * de serializar el objeto
     */
    private transient BufferedImage image;
    /**
     * Variable para conocer la posición en filas de la ficha en el tablero
     */
    private Integer posEnFilasTablero;
    /**
     * Variable que nos permite saber la posición en columnas de la ficha en el tablero
     */
    private Integer posEnColumnasTablero;
    
    
    
    /**
     * Método que nos permite añadir a cada una de las celdas los Listeners
     * 
     * @param frameTable JFrame de la pantalla del tablero
     * @param context Object del contexto 
     * @param cellEmpty Boolean para saber si la celda está vacía o no
     * @param player1 Jugador player1
     * @param player2 Jugador player2
     */
    public void addListeners(JFrame frameTable, Object context, Boolean cellEmpty,
            Jugador player1,Jugador player2){
        p1=player1;
        p2=player2;
        this.addMouseListener(new MouseListener() {
                    PanelTablero tablero = (PanelTablero)context;
                    
                    /**
                     * Cuando se clickea una celda
                     * @param e 
                     */
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        isClicked = cellIsEmpty;
                    }
                    /**
                     * Cuando se presiona en alguna celda
                     * @param e MouseEvent
                     */
                    @Override
                    public void mousePressed(MouseEvent e) {
                        isPressed = true;
                        if(!cellIsEmpty){ 
                            isPressedCellEmpty = false;
                            Toolkit toolkit = Toolkit.getDefaultToolkit();
                            Image image = toolkit.getImage(pieza.getRutaImagen());
                            setRutaImagenCelda(pieza.getRutaImagen());
                            tablero.celdaAnteriorSeleccionada = getCelda();
                            System.out.printf("\n");
                            System.out.printf("la ruta de la imagen es " + tablero.celdaAnteriorSeleccionada.getRutaImagenCelda());
                            Cursor c = toolkit.createCustomCursor(image , new Point(tablero.getX(), tablero.getY()), "img");
                            frameTable.setCursor (c);
                        }else{
                            isPressedCellEmpty = true;
                        }
                    }
                    /**
                     * Cuando se libera una pieza en alguna celda
                     * @param e MouseEvent
                     */
                    @Override
                    public void mouseReleased(MouseEvent e) {
                       
                       if(cellEntered != null){
                                if(!isPressedCellEmpty){
                                    try {
                                        
                                        //En caso de que tengamos una celda anterior con una pieza seleccionado
                                        if(tablero.celdaAnteriorSeleccionada!=null && !tablero.pantalla.getPartida().isGameOver()){
                                            String tipoPieza = tablero.celdaAnteriorSeleccionada.getPieza().getTipoPieza().toString();
                                            Integer bandoPieza = tablero.celdaAnteriorSeleccionada.getPieza().getBandoPieza();
                                            int filaAMostrar = 8-cellEntered.getCelda().getPosEnFilasTablero();
                                            String columnaAMostrar = cellEntered.getCelda().getPosEnColumnasTablero().toString();
                                            switch (columnaAMostrar){
                                                case "0":
                                                    columnaAMostrar = "A";
                                                    break;
                                                case "1":
                                                    columnaAMostrar = "B";
                                                    break;
                                                case "2":
                                                    columnaAMostrar = "C";
                                                    break;
                                                case "3":
                                                    columnaAMostrar = "D";
                                                    break;
                                                case "4":
                                                    columnaAMostrar = "E";
                                                    break;
                                                case "5":
                                                    columnaAMostrar = "F";
                                                    break;
                                                case "6":
                                                    columnaAMostrar = "G";
                                                    break;
                                                case "7":
                                                    columnaAMostrar = "H";
                                                    break;
                                            }
                                            
                                            switch (tipoPieza){
                                                //Peón
                                                case "11":
                                                    Peon peon = (Peon)tablero.celdaAnteriorSeleccionada.getPieza();
                                                    
                                           
                                                    //Para poder realizar el mvto de la pieza comprobamos si dicha pieza puede moverse y si 
                                                    //el estado del jugador está activo (es decir si es su turno), y en caso de Jaque analizaremos el mvto de la pieza
                                                    //ya que sólo se podrá realizar el mvto de ficha que pueda impedir el jaque del rey
                                                    if(peon.getMovePiece() && p1.getTurnoJugador() && analyzeMovementPieceOnJaque(tablero, bandoPieza)){
                                                        
                                                        if(peon.move((PanelTablero)context, cellEntered)){
                                                            mvtoRealizado = true;
                                                            //Número de mvtos. realizados con esta ficha
                                                            if(peon.getNumeroMovimiento()==null){
                                                                peon.setNumeroMovimiento(1);
                                                            }else{
                                                                peon.setNumeroMovimiento(peon.getNumeroMovimiento() + 1);
                                                            }
                                                            
                                                            
                                                            
                                                            //Actualizamos el Log
                                                            if(p1.getTurnoJugador()){
                                                                tablero.updateLog(p1.getName() + "(Blancas): "+ tablero.celdaAnteriorSeleccionada.getPieza().getName()
                                                                        + " movido a celda " + filaAMostrar + "-"
                                                                        + columnaAMostrar );
                                                                        
                                                            }else{
                                                                tablero.updateLog(p2.getName() + "(Negras): "+ tablero.celdaAnteriorSeleccionada.getPieza().getName()
                                                                        + " movido a celda " + filaAMostrar + "-"
                                                                        + columnaAMostrar );
                                                            }
                                                            
                                                            // Actualizamos las posiciones del tablero 
                                                            tablero.reloadBoardUI(cellEntered.getCelda());
                                                            
                                                            
                                                            
                                                            if(!tablero.pantalla.getPartida().isGameOver()){
                                                                changeTurn(p1, p2);

                                                                //Actualizamos el Log
                                                                if(p1.getTurnoJugador()){
                                                                    tablero.updateLog("---El turno pasa a " + p1.getName() + "(Blancas)");
                                                                }else{
                                                                    tablero.updateLog("---El turno pasa a " + p2.getName() + "(Negras)");
                                                                }
                                                            }
                                                            
                                                        }
                                                        
                                                        
                                                    }else{
                                                        mvtoRealizado = false;
                                                    }
                                                    
                                                    
                                                    
                                                    break;
                                                    
                                                //Peón
                                                case "21":
                                                    peon = (Peon)tablero.celdaAnteriorSeleccionada.getPieza();
                                                    //Para poder realizar el mvto de la pieza comprobamos si dicha pieza puede moverse y si 
                                                    //el estado del jugador está activo (es decir si es su turno)
                                                    if(peon.getMovePiece() && p2.getTurnoJugador() && analyzeMovementPieceOnJaque(tablero, bandoPieza)){
                                                        
                                                        if(peon.move((PanelTablero)context, cellEntered)){
                                                            mvtoRealizado = true;
                                                            //Número de mvtos. realizados con esta ficha
                                                            if(peon.getNumeroMovimiento()==null){
                                                                peon.setNumeroMovimiento(1);
                                                            }else{
                                                                peon.setNumeroMovimiento(peon.getNumeroMovimiento() + 1);
                                                            }

                                                            //Actualizamos el Log
                                                            if(p1.getTurnoJugador()){
                                                                tablero.updateLog(p1.getName() + "(Blancas): "+ tablero.celdaAnteriorSeleccionada.getPieza().getName()
                                                                        + " movido a celda " + filaAMostrar + "-"
                                                                        + columnaAMostrar );
                                                                        
                                                            }else{
                                                                tablero.updateLog(p2.getName() + "(Negras): "+ tablero.celdaAnteriorSeleccionada.getPieza().getName()
                                                                        + " movido a celda " + filaAMostrar + "-"
                                                                        + columnaAMostrar );
                                                            }
                                                            
                                                            // Actualizamos las posiciones del tablero 
                                                            tablero.reloadBoardUI(cellEntered.getCelda());
                                                            
                                                            
                                                            
                                                            if(!tablero.pantalla.getPartida().isGameOver()){
                                                                changeTurn(p1, p2);

                                                                //Actualizamos el Log
                                                                if(p1.getTurnoJugador()){
                                                                    tablero.updateLog("---El turno pasa a " + p1.getName() + "(Blancas)");
                                                                }else{
                                                                    tablero.updateLog("---El turno pasa a " + p2.getName() + "(Negras)");
                                                                }
                                                            }
                                                        }
                                                        
                                                        
                                                    }else{
                                                        mvtoRealizado = false;
                                                    }
                                                    
                                                    
                                                    
                                                    break;
                                                //Torre
                                                case "12":
                                                    Torre torre = (Torre)tablero.celdaAnteriorSeleccionada.getPieza();
                                                    //Para poder realizar el mvto de la pieza comprobamos si dicha pieza puede moverse y si 
                                                    //el estado del jugador está activo (es decir si es su turno)
                                                    if(torre.getMovePiece() && p1.getTurnoJugador() && analyzeMovementPieceOnJaque(tablero, bandoPieza)){
                                                        
                                                        if(torre.move((PanelTablero)context, cellEntered)){
                                                            mvtoRealizado = true;
                                                            //Número de mvtos. realizados con esta ficha
                                                            if(torre.getNumeroMovimiento()==null){
                                                                torre.setNumeroMovimiento(1);
                                                            }else{
                                                                torre.setNumeroMovimiento(torre.getNumeroMovimiento() + 1);
                                                            }
                                                            
                                                            //Actualizamos el Log
                                                            if(p1.getTurnoJugador()){
                                                                tablero.updateLog(p1.getName() + "(Blancas): "+ tablero.celdaAnteriorSeleccionada.getPieza().getName()
                                                                        + " movido a celda " + filaAMostrar + "-"
                                                                        + columnaAMostrar );
                                                                        
                                                            }else{
                                                                tablero.updateLog(p2.getName() + "(Negras): "+ tablero.celdaAnteriorSeleccionada.getPieza().getName()
                                                                        + " movido a celda " + filaAMostrar + "-"
                                                                        + columnaAMostrar );
                                                            }
                                                            
                                                            // Actualizamos las posiciones del tablero 
                                                            tablero.reloadBoardUI(cellEntered.getCelda());
                                                            
                                                            
                                                            
                                                            if(!tablero.pantalla.getPartida().isGameOver()){
                                                                changeTurn(p1, p2);

                                                                //Actualizamos el Log
                                                                if(p1.getTurnoJugador()){
                                                                    tablero.updateLog("---El turno pasa a " + p1.getName() + "(Blancas)");
                                                                }else{
                                                                    tablero.updateLog("---El turno pasa a " + p2.getName() + "(Negras)");
                                                                }
                                                            }

                                                        }
                                                    }else{
                                                        mvtoRealizado = false;
                                                    }
                                                    
                                                    
                                                    
                                                    break;
                                                //Torre
                                                case "22":
                                                    torre = (Torre)tablero.celdaAnteriorSeleccionada.getPieza();
                                                    //Para poder realizar el mvto de la pieza comprobamos si dicha pieza puede moverse y si 
                                                    //el estado del jugador está activo (es decir si es su turno)
                                                    if(torre.getMovePiece() && p2.getTurnoJugador() && analyzeMovementPieceOnJaque(tablero, bandoPieza)){
                                                        
                                                        if(torre.move((PanelTablero)context, cellEntered)){
                                                            mvtoRealizado = true;
                                                            //Número de mvtos. realizados con esta ficha
                                                            if(torre.getNumeroMovimiento()==null){
                                                                torre.setNumeroMovimiento(1);
                                                            }else{
                                                                torre.setNumeroMovimiento(torre.getNumeroMovimiento() + 1);
                                                            }
                                                            
                                                            
                                                            //Actualizamos el Log
                                                            if(p1.getTurnoJugador()){
                                                                tablero.updateLog(p1.getName() + "(Blancas): "+ tablero.celdaAnteriorSeleccionada.getPieza().getName()
                                                                        + " movido a celda " + filaAMostrar + "-"
                                                                        + columnaAMostrar );
                                                                        
                                                            }else{
                                                                tablero.updateLog(p2.getName() + "(Negras): "+ tablero.celdaAnteriorSeleccionada.getPieza().getName()
                                                                        + " movido a celda " + filaAMostrar + "-"
                                                                        + columnaAMostrar );
                                                            }
                                                            
                                                            // Actualizamos las posiciones del tablero 
                                                            tablero.reloadBoardUI(cellEntered.getCelda());
                                                            
                                                            
                                                            
                                                            if(!tablero.pantalla.getPartida().isGameOver()){
                                                                changeTurn(p1, p2);

                                                                //Actualizamos el Log
                                                                if(p1.getTurnoJugador()){
                                                                    tablero.updateLog("---El turno pasa a " + p1.getName() + "(Blancas)");
                                                                }else{
                                                                    tablero.updateLog("---El turno pasa a " + p2.getName() + "(Negras)");
                                                                }
                                                            }
                                                        }
                                                    }else{
                                                        mvtoRealizado = false;
                                                    }
                                                    
                                                    
                                                    
                                                    break;
                                                //Caballo
                                                case "13":
                                                    Caballo caballo = (Caballo)tablero.celdaAnteriorSeleccionada.getPieza();
                                                    //Para poder realizar el mvto de la pieza comprobamos si dicha pieza puede moverse y si 
                                                    //el estado del jugador está activo (es decir si es su turno)
                                                    if(caballo.getMovePiece() && p1.getTurnoJugador() && analyzeMovementPieceOnJaque(tablero, bandoPieza)){
                                                        
                                                        if(caballo.move((PanelTablero)context, cellEntered)){
                                                            mvtoRealizado = true;
                                                            //Número de mvtos. realizados con esta ficha
                                                            if(caballo.getNumeroMovimiento()==null){
                                                                caballo.setNumeroMovimiento(1);
                                                            }else{
                                                                caballo.setNumeroMovimiento(caballo.getNumeroMovimiento() + 1);
                                                            }
                                                            
                                                            
                                                            //Actualizamos el Log
                                                            if(p1.getTurnoJugador()){
                                                                tablero.updateLog(p1.getName() + "(Blancas): "+ tablero.celdaAnteriorSeleccionada.getPieza().getName()
                                                                        + " movido a celda " + filaAMostrar + "-"
                                                                        + columnaAMostrar );
                                                                        
                                                            }else{
                                                                tablero.updateLog(p2.getName() + "(Negras): "+ tablero.celdaAnteriorSeleccionada.getPieza().getName()
                                                                        + " movido a celda " + filaAMostrar + "-"
                                                                        + columnaAMostrar );
                                                            }
                                                            
                                                            // Actualizamos las posiciones del tablero 
                                                            tablero.reloadBoardUI(cellEntered.getCelda());
                                                            
                                                            
                                                            
                                                            if(!tablero.pantalla.getPartida().isGameOver()){
                                                                changeTurn(p1, p2);

                                                                //Actualizamos el Log
                                                                if(p1.getTurnoJugador()){
                                                                    tablero.updateLog("---El turno pasa a " + p1.getName() + "(Blancas)");
                                                                }else{
                                                                    tablero.updateLog("---El turno pasa a " + p2.getName() + "(Negras)");
                                                                }
                                                            }
                                                        }
                                                    }else{
                                                        mvtoRealizado = false;
                                                    }
                                                    
                                                    
                                                    
                                                    break;
                                                //Caballo
                                                case "23":
                                                    caballo = (Caballo)tablero.celdaAnteriorSeleccionada.getPieza();
                                                    //Para poder realizar el mvto de la pieza comprobamos si dicha pieza puede moverse y si 
                                                    //el estado del jugador está activo (es decir si es su turno)
                                                    if(caballo.getMovePiece() && p2.getTurnoJugador() && analyzeMovementPieceOnJaque(tablero, bandoPieza)){
                                                        
                                                        if(caballo.move((PanelTablero)context, cellEntered)){
                                                            mvtoRealizado = true;
                                                            //Número de mvtos. realizados con esta ficha
                                                            if(caballo.getNumeroMovimiento()==null){
                                                                caballo.setNumeroMovimiento(1);
                                                            }else{
                                                                caballo.setNumeroMovimiento(caballo.getNumeroMovimiento() + 1);
                                                            }
                                                            
                                                            
                                                            //Actualizamos el Log
                                                            if(p1.getTurnoJugador()){
                                                                tablero.updateLog(p1.getName() + "(Blancas): "+ tablero.celdaAnteriorSeleccionada.getPieza().getName()
                                                                        + " movido a celda " + filaAMostrar + "-"
                                                                        + columnaAMostrar );
                                                                        
                                                            }else{
                                                                tablero.updateLog(p2.getName() + "(Negras): "+ tablero.celdaAnteriorSeleccionada.getPieza().getName()
                                                                        + " movido a celda " + filaAMostrar + "-"
                                                                        + columnaAMostrar );
                                                            }
                                                            
                                                            // Actualizamos las posiciones del tablero 
                                                            tablero.reloadBoardUI(cellEntered.getCelda());
                                                            
                                                            
                                                            
                                                            if(!tablero.pantalla.getPartida().isGameOver()){
                                                                changeTurn(p1, p2);

                                                                //Actualizamos el Log
                                                                if(p1.getTurnoJugador()){
                                                                    tablero.updateLog("---El turno pasa a " + p1.getName() + "(Blancas)");
                                                                }else{
                                                                    tablero.updateLog("---El turno pasa a " + p2.getName() + "(Negras)");
                                                                }
                                                            }
                                                        }
                                                    }else{
                                                        mvtoRealizado = false;
                                                    }
                                                    
                                                   
                                                    
                                                    break;
                                                //Alfil
                                                case "14":
                                                    Alfil alfil = (Alfil)tablero.celdaAnteriorSeleccionada.getPieza();
                                                    //Para poder realizar el mvto de la pieza comprobamos si dicha pieza puede moverse y si 
                                                    //el estado del jugador está activo (es decir si es su turno)
                                                    if(alfil.getMovePiece() && p1.getTurnoJugador() && analyzeMovementPieceOnJaque(tablero, bandoPieza)){
                                                        
                                                        if(alfil.move((PanelTablero)context, cellEntered)){
                                                            mvtoRealizado = true;
                                                            //Número de mvtos. realizados con esta ficha
                                                            if(alfil.getNumeroMovimiento()==null){
                                                                alfil.setNumeroMovimiento(1);
                                                            }else{
                                                                alfil.setNumeroMovimiento(alfil.getNumeroMovimiento() + 1);
                                                            }
                                                            
                                                            //Actualizamos el Log
                                                            if(p1.getTurnoJugador()){
                                                                tablero.updateLog(p1.getName() + "(Blancas): "+ tablero.celdaAnteriorSeleccionada.getPieza().getName()
                                                                        + " movido a celda " + filaAMostrar + "-"
                                                                        + columnaAMostrar );
                                                                        
                                                            }else{
                                                                tablero.updateLog(p2.getName() + "(Negras): "+ tablero.celdaAnteriorSeleccionada.getPieza().getName()
                                                                        + " movido a celda " + filaAMostrar + "-"
                                                                        + columnaAMostrar );
                                                            }
                                                            
                                                            // Actualizamos las posiciones del tablero 
                                                            tablero.reloadBoardUI(cellEntered.getCelda());
                                                            
                                                            
                                                            
                                                            if(!tablero.pantalla.getPartida().isGameOver()){
                                                                changeTurn(p1, p2);

                                                                //Actualizamos el Log
                                                                if(p1.getTurnoJugador()){
                                                                    tablero.updateLog("---El turno pasa a " + p1.getName() + "(Blancas)");
                                                                }else{
                                                                    tablero.updateLog("---El turno pasa a " + p2.getName() + "(Negras)");
                                                                }
                                                            }
                                                            
                                                        }else{
                                                            mvtoRealizado = false;
                                                        }
                                                    }
                                                    
                                                    
                                                    
                                                    break;
                                                //Alfil
                                                case "24":
                                                    alfil = (Alfil)tablero.celdaAnteriorSeleccionada.getPieza();
                                                    //Para poder realizar el mvto de la pieza comprobamos si dicha pieza puede moverse y si 
                                                    //el estado del jugador está activo (es decir si es su turno)
                                                    if(alfil.getMovePiece() && p2.getTurnoJugador() && analyzeMovementPieceOnJaque(tablero, bandoPieza)){
                                                        
                                                        if(alfil.move((PanelTablero)context, cellEntered)){
                                                            mvtoRealizado = true;
                                                            //Número de mvtos. realizados con esta ficha
                                                            if(alfil.getNumeroMovimiento()==null){
                                                                alfil.setNumeroMovimiento(1);
                                                            }else{
                                                                alfil.setNumeroMovimiento(alfil.getNumeroMovimiento() + 1);
                                                            }
                                                            
                                                            //Actualizamos el Log
                                                            if(p1.getTurnoJugador()){
                                                                tablero.updateLog(p1.getName() + "(Blancas): "+ tablero.celdaAnteriorSeleccionada.getPieza().getName()
                                                                        + " movido a celda " + filaAMostrar + "-"
                                                                        + columnaAMostrar );
                                                                        
                                                            }else{
                                                                tablero.updateLog(p2.getName() + "(Negras): "+ tablero.celdaAnteriorSeleccionada.getPieza().getName()
                                                                        + " movido a celda " + filaAMostrar + "-"
                                                                        + columnaAMostrar );
                                                            }
                                                            
                                                            // Actualizamos las posiciones del tablero 
                                                            tablero.reloadBoardUI(cellEntered.getCelda());
                                                            
                                                            
                                                            
                                                            if(!tablero.pantalla.getPartida().isGameOver()){
                                                                changeTurn(p1, p2);

                                                                //Actualizamos el Log
                                                                if(p1.getTurnoJugador()){
                                                                    tablero.updateLog("---El turno pasa a " + p1.getName() + "(Blancas)");
                                                                }else{
                                                                    tablero.updateLog("---El turno pasa a " + p2.getName() + "(Negras)");
                                                                }
                                                            }
                                                        } 
                                                    }else{
                                                        mvtoRealizado = false;
                                                    }
                                                    
                                                    
                                                    
                                                    break;
                                                //Reina
                                                case "15":
                                                    Reina reina = (Reina)tablero.celdaAnteriorSeleccionada.getPieza();
                                                    //Para poder realizar el mvto de la pieza comprobamos si dicha pieza puede moverse y si 
                                                    //el estado del jugador está activo (es decir si es su turno)
                                                    if(reina.getMovePiece() && p1.getTurnoJugador() && analyzeMovementPieceOnJaque(tablero, bandoPieza)){
                                                        
                                                        if(reina.move((PanelTablero)context, cellEntered)){
                                                            mvtoRealizado = true;
                                                            //Número de mvtos. realizados con esta ficha
                                                            if(reina.getNumeroMovimiento()==null){
                                                                reina.setNumeroMovimiento(1);
                                                            }else{
                                                                reina.setNumeroMovimiento(reina.getNumeroMovimiento() + 1);
                                                            }
                                                            
                                                            //Actualizamos el Log
                                                            if(p1.getTurnoJugador()){
                                                                tablero.updateLog(p1.getName() + "(Blancas): "+ tablero.celdaAnteriorSeleccionada.getPieza().getName()
                                                                        + " movido a celda " + filaAMostrar + "-"
                                                                        + columnaAMostrar );
                                                                        
                                                            }else{
                                                                tablero.updateLog(p2.getName() + "(Negras): "+ tablero.celdaAnteriorSeleccionada.getPieza().getName()
                                                                        + " movido a celda " + filaAMostrar + "-"
                                                                        + columnaAMostrar );
                                                            }
                                                            
                                                            // Actualizamos las posiciones del tablero 
                                                            tablero.reloadBoardUI(cellEntered.getCelda());
                                                            
                                                            
                                                            
                                                            if(!tablero.pantalla.getPartida().isGameOver()){
                                                                changeTurn(p1, p2);

                                                                //Actualizamos el Log
                                                                if(p1.getTurnoJugador()){
                                                                    tablero.updateLog("---El turno pasa a " + p1.getName() + "(Blancas)");
                                                                }else{
                                                                    tablero.updateLog("---El turno pasa a " + p2.getName() + "(Negras)");
                                                                }
                                                            }

                                                        } 
                                                    }else{
                                                        mvtoRealizado = false;
                                                    }
                                                    
                                                    
                                                    
                                                    break;
                                                //Reina
                                                case "25":
                                                    reina = (Reina)tablero.celdaAnteriorSeleccionada.getPieza();
                                                    //Para poder realizar el mvto de la pieza comprobamos si dicha pieza puede moverse y si 
                                                    //el estado del jugador está activo (es decir si es su turno)
                                                    if(reina.getMovePiece() && p2.getTurnoJugador() && analyzeMovementPieceOnJaque(tablero, bandoPieza)){
                                                        
                                                        if(reina.move((PanelTablero)context, cellEntered)){
                                                            mvtoRealizado = true;
                                                            //Número de mvtos. realizados con esta ficha
                                                            if(reina.getNumeroMovimiento()==null){
                                                                reina.setNumeroMovimiento(1);
                                                            }else{
                                                                reina.setNumeroMovimiento(reina.getNumeroMovimiento() + 1);
                                                            }
                                                            
                                                            //Actualizamos el Log
                                                            if(p1.getTurnoJugador()){
                                                                tablero.updateLog(p1.getName() + "(Blancas): "+ tablero.celdaAnteriorSeleccionada.getPieza().getName()
                                                                        + " movido a celda " + filaAMostrar + "-"
                                                                        + columnaAMostrar );
                                                                        
                                                            }else{
                                                                tablero.updateLog(p2.getName() + "(Negras): "+ tablero.celdaAnteriorSeleccionada.getPieza().getName()
                                                                        + " movido a celda " + filaAMostrar + "-"
                                                                        + columnaAMostrar );
                                                            }
                                                            
                                                            // Actualizamos las posiciones del tablero 
                                                            tablero.reloadBoardUI(cellEntered.getCelda());
                                                            
                                                            
                                                            
                                                            if(!tablero.pantalla.getPartida().isGameOver()){
                                                                changeTurn(p1, p2);

                                                                //Actualizamos el Log
                                                                if(p1.getTurnoJugador()){
                                                                    tablero.updateLog("---El turno pasa a " + p1.getName() + "(Blancas)");
                                                                }else{
                                                                    tablero.updateLog("---El turno pasa a " + p2.getName() + "(Negras)");
                                                                }
                                                            }
                                                        }
                                                    }else{
                                                        mvtoRealizado = false;
                                                    }
                                                    
                                                    
                                                    
                                                    break;
                                                //Rey
                                                case "16":
                                                    Rey rey = (Rey)tablero.celdaAnteriorSeleccionada.getPieza();
                                                    //Para poder realizar el mvto de la pieza comprobamos si dicha pieza puede moverse y si 
                                                    //el estado del jugador está activo (es decir si es su turno)
                                                    if(rey.getMovePiece() && p1.getTurnoJugador() && analyzeMovementPieceOnJaque(tablero, bandoPieza)){
                                                        //Analizamos la celda de destino del rey antes de realizar el mvto
                                                        //Si la celda destino deja al rey en jaque impedimos el mvto
                                                        if(rey.checkJaque(tablero, cellEntered.getPosEnFilasTablero(), cellEntered.getPosEnColumnasTablero(), false)==false){
                                                            mvtoRealizado = true;
                                                            if(rey.move((PanelTablero)context, cellEntered, player1, player2)){

                                                                //Número de mvtos. realizados con esta ficha
                                                                if(rey.getNumeroMovimiento()==null){
                                                                    rey.setNumeroMovimiento(1);
                                                                }else{
                                                                    rey.setNumeroMovimiento(rey.getNumeroMovimiento() + 1);
                                                                }

                                                                //Actualizamos el Log
                                                                if(p1.getTurnoJugador()){
                                                                    tablero.updateLog(p1.getName() + "(Blancas): "+ tablero.celdaAnteriorSeleccionada.getPieza().getName()
                                                                            + " movido a celda " + filaAMostrar + "-"
                                                                            + columnaAMostrar );

                                                                }else{
                                                                    tablero.updateLog(p2.getName() + "(Negras): "+ tablero.celdaAnteriorSeleccionada.getPieza().getName()
                                                                            + " movido a celda " + filaAMostrar + "-"
                                                                            + columnaAMostrar );
                                                                }
                                                            
                                                                // Actualizamos las posiciones del tablero 
                                                                tablero.reloadBoardUI(cellEntered.getCelda());


                                                                if(!tablero.pantalla.getPartida().isGameOver()){
                                                                    changeTurn(p1, p2);

                                                                    //Actualizamos el Log
                                                                    if(p1.getTurnoJugador()){
                                                                        tablero.updateLog("---El turno pasa a " + p1.getName() + "(Blancas)");
                                                                    }else{
                                                                        tablero.updateLog("---El turno pasa a " + p2.getName() + "(Negras)");
                                                                    }
                                                                }
                                                                
                                                            }
                                                        }else{
                                                            mvtoRealizado = false;
                                                        }
                                                        
                                                    }else{
                                                        mvtoRealizado = false;
                                                    }
                                                    
                                                    
                                                    
                                                    
                                                    break;
                                                //Rey
                                                case "26":
                                                    rey = (Rey)tablero.celdaAnteriorSeleccionada.getPieza();
                                                    //Para poder realizar el mvto de la pieza comprobamos si dicha pieza puede moverse y si 
                                                    //el estado del jugador está activo (es decir si es su turno)
                                                    if(rey.getMovePiece() && p2.getTurnoJugador() && analyzeMovementPieceOnJaque(tablero, bandoPieza)){
                                                        //Analizamos la celda de destino del rey antes de realizar el mvto
                                                        //Si la celda destino deja al rey en jaque impedimos el mvto
                                                        if(rey.checkJaque(tablero, cellEntered.getPosEnFilasTablero(), cellEntered.getPosEnColumnasTablero(), false)==false){
                                                            mvtoRealizado = true;
                                                            if(rey.move((PanelTablero)context, cellEntered, player1, player2)){

                                                                //Número de mvtos. realizados con esta ficha
                                                                if(rey.getNumeroMovimiento()==null){
                                                                    rey.setNumeroMovimiento(1);
                                                                }else{
                                                                    rey.setNumeroMovimiento(rey.getNumeroMovimiento() + 1);
                                                                }

                                                                
                                                                //Actualizamos el Log
                                                                if(p1.getTurnoJugador()){
                                                                    tablero.updateLog(p1.getName() + "(Blancas): "+ tablero.celdaAnteriorSeleccionada.getPieza().getName()
                                                                            + " movido a celda " + filaAMostrar + "-"
                                                                            + columnaAMostrar );

                                                                }else{
                                                                    tablero.updateLog(p2.getName() + "(Negras): "+ tablero.celdaAnteriorSeleccionada.getPieza().getName()
                                                                            + " movido a celda " + filaAMostrar + "-"
                                                                            + columnaAMostrar );
                                                                }

                                                                // Actualizamos las posiciones del tablero 
                                                                tablero.reloadBoardUI(cellEntered.getCelda());



                                                                if(!tablero.pantalla.getPartida().isGameOver()){
                                                                    changeTurn(p1, p2);

                                                                    //Actualizamos el Log
                                                                    if(p1.getTurnoJugador()){
                                                                        tablero.updateLog("---El turno pasa a " + p1.getName() + "(Blancas)");
                                                                    }else{
                                                                        tablero.updateLog("---El turno pasa a " + p2.getName() + "(Negras)");
                                                                    }
                                                                }
                                                            }
                                                        }else{
                                                            mvtoRealizado = false;
                                                        }
                                                        
                                                    }else{
                                                        mvtoRealizado = false;
                                                    }
                                                    
                                                    
                                                    
                                                    
                                                    break;
                                            }
                                            
                                            
                                            
                                            
                                            
                                            tablero.celdaAnteriorSeleccionada = null;
                                            
                                            
                                            System.out.print("\n\nEstado de los Jugadores");
                                            System.out.print("\nP1: "+ p1.getTurnoJugador());
                                            System.out.print("\nP2: "+ p2.getTurnoJugador());
                                            System.out.print("\nMvto realizado: "+ mvtoRealizado);
                                            System.out.print("\nFilaReyBlanco: "+ tablero.filaReyBlancoEnJaque);
                                            System.out.print("\nColumnaReyBlanco: "+ tablero.columnaReyBlancoEnJaque);
                                            
                                            
                                            
                                            
                                        }
                                        
                                        
                                        
                                        //t.setImageOfPieceOnButton(tablero.arrayDeCeldas[tablero.filaNueva][tablero.columnaNueva].getCelda(), tablero.imagenAnterior);



                                        //Image scaled = tablero.imagenAnterior.getScaledInstance(50,50,java.awt.Image.SCALE_SMOOTH);
                                        //getCelda().setIcon(new ImageIcon(scaled));
                                        //this.getRutaImagenCelda
                                    } catch (IOException ex) {
                                        Logger.getLogger(Celda.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    isPressed = false;
                                    isReleased = false;
                                    isEntered = false;
                                    isClicked = false;
                                }
                            //}
                            
                        }
                       
                       //Reestablecemos el cursor a su estado original
                       frameTable.setCursor (Cursor.getDefaultCursor());
                    }
                    /**
                     * Cuando se entra a la celda
                     * @param e MouseEvent
                     */
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        
                        if(tablero.celdaAnteriorSeleccionada!=null){
                            cellEntered = (Celda) e.getSource();
                        }
                        
                        
                        /*if(tablero.celdaAnteriorSeleccionada != null){
                            if(Objects.equals(tablero.celdaAnteriorSeleccionada.getPosEnColumnasTablero(), checkCellEntered.getPosEnColumnasTablero())){
                                cellEntered = (Celda) e.getSource();
                            }
                        }*/
                        
                        
                        /*System.out.println("\n INICIO");
                        System.out.println("Posición fila celda selección anterior " + cellEntered.getPosEnFilasTablero());
                        System.out.println("Posición columna celda selección anterior " + cellEntered.getPosEnColumnasTablero());
                        System.out.println("\n FIN");*/
                        
                        //isExited = false;
                        
                       
                       
                       
                        
                        
                    }
                    /**
                     * Cuando se sale de la celda
                     * 
                     * @param e MouseEvent 
                     */
                    @Override
                    public void mouseExited(MouseEvent e) {
                        //isExited = true;
                        //isEntered = false;
                    }
                });
    
    }
    
    /**
     * Método con el que analizamos los mvtos de las fichas en caso de que el rey se encuentre en jaque para saber si se puede evitar o no
     * 
     * @param tablero PanelTablero donde tenemos toda la información del tablero y de la partida
     * @param bando Integer bando de la ficha 1. Blancas y 2. Negras
     * 
     * @return boolean para saber si existe alguna ficha que se puede interponer en la trayectoria de la ficha atacante
     */
    public boolean analyzeMovementPieceOnJaque (PanelTablero tablero, Integer bando){
        Pieza pAmenazadora;
        if(bando == 1){
            //Si el rey está en jaque nos tenemos que asegurar que la ficha que se mueva sea para impedir el jaque (si puede)
            if(tablero.filaReyBlancoEnJaque != null){
                Rey reyAmenazado = (Rey)tablero.arrayDeCeldas[tablero.filaReyBlancoEnJaque][tablero.columnaReyBlancoEnJaque].getPieza();
                if(reyAmenazado.getEstaEnJaque()){
                    int filaDestino, columnaDestino;
                    filaDestino = cellEntered.getPosEnFilasTablero();
                    columnaDestino = cellEntered.getPosEnColumnasTablero();
                    for (int i = 0; i < reyAmenazado.getPiezasAmenazadoras().size(); i++) {
                        pAmenazadora = reyAmenazado.getPiezasAmenazadoras().get(i);
                        for (int m = 0; m < pAmenazadora.getFilaAmenazaRey().size(); m++) {
                            if(!"Rey".equals(tablero.celdaAnteriorSeleccionada.getPieza().getName())){
                                //Comprobamos si la celda destino coincide con alguna de las celdas que forman parte de la trayectoria de la ficha que amenaza al rey
                                if((int)pAmenazadora.getFilaAmenazaRey().get(m) == filaDestino
                                    && (int)pAmenazadora.getColumnaAmenazaRey().get(m) == columnaDestino){
                                    //Reseteamos las variables
                                    tablero.filaReyBlancoEnJaque = null;
                                    tablero.columnaReyBlancoEnJaque = null;
                                    reyAmenazado.setEstaEnJaque(false);
                                    //En caso de que coincide que la celda destino se interpone en la trayectoria amenazante permitimos el mvto
                                    return true;
                                }else{
                                    //Nos aseguramos que hemos comprobado todas las posiciones de cada una de las fichas atacantes
                                    if(i==reyAmenazado.getPiezasAmenazadoras().size()-1 && m == pAmenazadora.getFilaAmenazaRey().size()-1){
                                        //En caso de que no coincide la celda destino con ninguna celda de la trayectoria amenazante impedimos el mvto
                                        return false;
                                    }

                                }
                            }
                            
                        }
                    }
                }
            }
        }else{
            //Si el rey está en jaque nos tenemos que asegurar que la ficha que se mueva sea para impedir el jaque (si puede)
            if(tablero.filaReyNegroEnJaque != null){
                Rey reyAmenazado = (Rey)tablero.arrayDeCeldas[tablero.filaReyNegroEnJaque][tablero.columnaReyNegroEnJaque].getPieza();
                if(reyAmenazado.getEstaEnJaque()){
                    int filaDestino, columnaDestino;
                    filaDestino = cellEntered.getPosEnFilasTablero();
                    columnaDestino = cellEntered.getPosEnColumnasTablero();
                    for (int i = 0; i < reyAmenazado.getPiezasAmenazadoras().size(); i++) {
                        pAmenazadora = reyAmenazado.getPiezasAmenazadoras().get(i);
                        for (int m = 0; m < pAmenazadora.getFilaAmenazaRey().size(); m++) {
                            if(!"Rey".equals(tablero.celdaAnteriorSeleccionada.getPieza().getName())){
                                //Comprobamos si la celda destino coincide con alguna de las celdas que forman parte de la trayectoria de la ficha que amenaza al rey
                                if((int)pAmenazadora.getFilaAmenazaRey().get(m) == filaDestino
                                    && (int)pAmenazadora.getColumnaAmenazaRey().get(m) == columnaDestino){
                                    //Reseteamos las variables
                                    tablero.filaReyNegroEnJaque = null;
                                    tablero.columnaReyNegroEnJaque = null;
                                    reyAmenazado.setEstaEnJaque(false);
                                    //En caso de que coincide que la celda destino se interpone en la trayectoria amenazante permitimos el mvto
                                    return true;
                                }else{
                                    //Nos aseguramos que hemos comprobado todas las posiciones de cada una de las fichas atacantes
                                    if(i==reyAmenazado.getPiezasAmenazadoras().size()-1 && m == pAmenazadora.getFilaAmenazaRey().size()-1){
                                        //En caso de que no coincide la celda destino con ninguna celda de la trayectoria amenazante impedimos el mvto
                                        return false;
                                    }
                                }
                            }
                            
                        }
                    }
                }
            }
        }
        
        //En caso de que no haya que analizar ningún tipo de mvto en situación de jaque dejamos que el jugador mueva libremente la pieza
        return true;
    }
    /**
     * Método con el que cambiamos el turno al otro jugador
     * 
     * @param player1 Jugador 
     * @param player2 Jugador
     */
    public void changeTurn(Jugador player1, Jugador player2){
        if(player1.getTurnoJugador()){
            player1.setTurnoJugador(false);
            player2.setTurnoJugador(true);
            mvtoRealizado = false;
        }else{
            if(player2.getTurnoJugador()){
                player2.setTurnoJugador(false);
                player1.setTurnoJugador(true);
                mvtoRealizado = false;
            }
        }
        
        p1 = player1;
        p2 = player2;
        
        
        
    }
    /**
     * Método con el que limpiamos la celda y la misma se quedaría vacía
     */
    public void clearCell (){
        this.pieza = null;
        this.image = null;
        this.rutaImagenCelda = null;
        this.cellIsEmpty = true;
    }
    
    
    /**
     * Getter de la celda.
     *
     * @return Celda this.
     */
    public Celda getCelda() {
        return this;
    }
    /**
     * Getter de posEnFilasTablero.
     *
     * @return Integer posEnFilasTablero.
     */
    public Integer getPosEnFilasTablero() {
        return posEnFilasTablero;
    }
    /**
     * Setter de posEnFilasTablero.
     *
     * @param posEnFilasTablero Integer
     */
    public void setPosEnFilasTablero(Integer posEnFilasTablero) {
        this.posEnFilasTablero = posEnFilasTablero;
    }
    /**
     * Getter de la posEnColumnasTablero.
     *
     * @return Integer posEnColumnasTablero.
     */
    public Integer getPosEnColumnasTablero() {
        return posEnColumnasTablero;
    }
    /**
     * Setter de posEnColumnasTablero.
     *
     * @param posEnColumnasTablero Integer
     */
    public void setPosEnColumnasTablero(Integer posEnColumnasTablero) {
        this.posEnColumnasTablero = posEnColumnasTablero;
    }
    /**
     * Getter de la rutaImagenCelda.
     *
     * @return String rutaImagenCelda.
     */
    public String getRutaImagenCelda() {
        return rutaImagenCelda;
    }
    /**
     * Setter de rutaImagenCelda.
     *
     * @param rutaImagenCelda String
     */
    public void setRutaImagenCelda(String rutaImagenCelda) {
        this.rutaImagenCelda = rutaImagenCelda;
    }
    /**
     * Getter del listener.
     *
     * @return MouseListener listener.
     */
    public MouseListener getListener() {
        return listener;
    }
    /**
     * Setter del listener.
     *
     * @param listener MouseListener
     */
    public void setListener(MouseListener listener) {
        this.listener = listener;
    }
    /**
     * Getter de isClicked.
     *
     * @return Boolean isClicked.
     */
    public Boolean getIsClicked() {
        return isClicked;
    }
    /**
     * Setter del isClicked.
     *
     * @param isClicked Boolean
     */
    public void setIsClicked(Boolean isClicked) {
        this.isClicked = isClicked;
    }
    /**
     * Getter de isPressed.
     *
     * @return Boolean isPressed.
     */
    public Boolean getIsPressed() {
        return isPressed;
    }
    /**
     * Getter de cellIsEmpty.
     *
     * @return Boolean cellIsEmpty.
     */
    public Boolean getCellIsEmpty() {
        return cellIsEmpty;
    }
    /**
     * Setter del estadoCelda.
     *
     * @param estadoCelda Boolean
     */
    public void setCellIsEmpty(Boolean estadoCelda) {
        this.cellIsEmpty = estadoCelda;
    }
    /**
     * Setter del isPressed.
     *
     * @param isPressed Boolean
     */
    public void setIsPressed(Boolean isPressed) {
        this.isPressed = isPressed;
    }
    /**
     * Getter de isReleased.
     *
     * @return Boolean isReleased.
     */
    public Boolean getIsReleased() {
        return isReleased;
    }
    /**
     * Getter de isExited.
     *
     * @return Boolean isExited.
     */
    public Boolean getIsExited() {
        return isExited;
    }
    /**
     * Setter del isExited.
     *
     * @param isExited Boolean
     */
    public void setIsExited(Boolean isExited) {
        this.isExited = isExited;
    }
    /**
     * Getter de pieza.
     *
     * @return Pieza pieza.
     */
    public Pieza getPieza() {
        return pieza;
    }
    /**
     * Setter del pieza.
     *
     * @param pieza Pieza
     */
    public void setPieza(Pieza pieza) {
        this.pieza = pieza;
        this.setCellIsEmpty(false);
    }
    /**
     * Setter del isRelease.
     *
     * @param isRelease Boolean
     */
    public void setIsReleased(Boolean isRelease) {
        this.isReleased = isRelease;
    }
    /**
     * Getter de image.
     *
     * @return BufferedImage image.
     */
    public BufferedImage getImage() {
        return image;
    }
    /**
     * Setter del image.
     *
     * @param image BufferedImage
     */
    public void setImage(BufferedImage image) {
        this.image = image;
    }
    /**
     * Getter de isEntered.
     *
     * @return Boolean isEntered.
     */
    public Boolean getIsEntered() {
        return isEntered;
    }
    /**
     * Setter del isEntered.
     *
     * @param isEntered Boolean
     */
    public void setIsEntered(Boolean isEntered) {
        this.isEntered = isEntered;
    }

    


    
}