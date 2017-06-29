package seas.angel.macdonald.chess2d.modelo;

import seas.angel.macdonald.chess2d.vista.Pantalla;
import seas.angel.macdonald.chess2d.vista.Log;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 * Clase que contiene todos los elementos que intervienen en una partida, implementa la interfaz serializable para grabar el juego en un archivo
 * 
 * @author Ángel Mac Donald
 */
public class Partida implements Serializable{
    
    /**
     * Variable que almacena el tablero del juego
     */
    private Tablero tablero;
    /**
     * Variable que almacena los datos del jugador1
     */
    private Jugador jugador1;
    /**
     * Variable que almacena los datos del jugador2
     */
    private Jugador jugador2;
    /**
     * Variable de la pantalla del Log del juego
     */
    private transient  Log gameLogScreen;
    /**
     * Variable que almacena el contenido del Log del juego
     */
    private ArrayList<String> gameLog;
    /**
     * Variable que nos indica que la partida ha acabado
     */
    private boolean gameOver;
    
    /**
     * Constructor parametrizado.
     *
     * @param nombre1 String nombre jugador 1.
     * @param tipoPiezas1 String tipoPiezas del jugador 1.
     * @param nombre2 String nombre jugador 2.
     * @param tipoPiezas2 String tipoPiezas del jugador 2.
     */
    public Partida(String nombre1, String tipoPiezas1, String nombre2, String tipoPiezas2) {
        tablero = new Tablero();
        jugador1 = new Jugador(nombre1, tipoPiezas1, true);
        jugador2 = new Jugador(nombre2, tipoPiezas2, false);
        gameLog = new ArrayList<>();
        gameOver = false;
    }
    
    /**
     * Método para crear el Screen Log correspondiente a cada partida.
     * @param pantalla Pantalla
     * @throws java.io.IOException A causa del icono que se pone en la screen del log
     */
    public void createScreenLog(Pantalla pantalla) throws IOException{
        gameLogScreen = new Log(pantalla);
        gameLogScreen.setIconImage(ImageIO.read(new File("src/seas/angel/macdonald/chess2d/recursos/icon_chess_2d.png")));
    }
    /**
     * Método con el que cargamos el Log del juego
     * 
     * @param log ArrayList que contiene el Log actualizado 
     */
    public void cargarLog(ArrayList<String> log) {
        
        gameLogScreen.clearLog();
        
        
        for (int i = 0; i < log.size(); i++) {
            String lineLog = log.get(i);
            if(lineLog != null){
                gameLogScreen.setLstLog(log.get(i));
            }
            
        
        } 
        //El scroll se sitúa en la última posición
        gameLogScreen.setBottomLog();
    }
    
    
    /**
     * Getter del gameLogScreen.
     *
     * @return Log gameLogScreen.
     */
    public Log getGameLogScreen() {
        return gameLogScreen;
    }
    /**
     * Setter del gameLogScreen.
     *
     * @param gameLogScreen Log
     */
    public void setGameLogScreen(Log gameLogScreen) {
        this.gameLogScreen = gameLogScreen;
    }
    /**
     * Getter del tablero.
     *
     * @return Tablero tablero.
     */
    public Tablero getTablero() {
        return tablero;
    }
    /**
     * Setter del tablero.
     *
     * @param tablero Tablero.
     */
    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }
    /**
     * Getter del jugador 1.
     *
     * @return Jugador jugador1.
     */
    public Jugador getJugador1() {
        return jugador1;
    }
    /**
     * Setter del jugador 1.
     *
     * @param jugador1 Jugador.
     */
    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }
    /**
     * Getter del jugador 2.
     *
     * @return jugador2
     */
    public Jugador getJugador2() {
        return jugador2;
    }
    /**
     * Setter del jugador 2.
     *
     * @param jugador2 Jugador.
     */
    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }
    /**
     * Getter del gameLog.
     *
     * @return gameLog ArrayList
     */
    public ArrayList<String> getGameLog() {
        return gameLog;
    }
    /**
     * Setter del gameLog.
     *
     * @param gameLog ArrayList
     */
    public void setGameLog(ArrayList<String> gameLog) {
        this.gameLog = gameLog;
    }

    /**
     * Getter del gameOver.
     *
     * @return gameOver boolean que nos indica si el juego ha acabado o no
     */
    public boolean isGameOver() {
        return gameOver;
    }
    
    /**
     * Setter del gameOver.
     *
     * @param gameOver boolean que nos indica si el juego se ha acabado o no
     */
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
    
    
    
}
