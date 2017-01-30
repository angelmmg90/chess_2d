package seas.angel.macdonald.chess2d.modelo;

import java.io.Serializable;

/**
 * Clase que representa a la entidad jugador y que implementa la interfaz
 * serializable para poder grabarla en archivos.
 * 
 * @author Ángel Mac Donald Gainza
 */
public class Jugador implements Serializable{
    
    /**
     * Variable que indica el nombre del jugador
     */
    private String name;
    /**
     * Variable que indica el tipo de fichas que lleva el jugador (BLANCAS-NEGRAS)
     */
    private String tipoPiezas;
    /**
     * Con la siguiente variable establecemos el estado del jugador
     */
    private Boolean turno;
    
    
    /**
     * Constructor parametrizado.
     *
     * @param name String nombre del jugador.
     * @param tipoPiezas String tipo de piezas (BLANCAS-NEGRAS)
     * @param turno boolean indicador de posesion del turno.
     */
    public Jugador(String name, String tipoPiezas, boolean turno){
        this.name = name;
        this.tipoPiezas = tipoPiezas;
        this.turno = turno;
    }
    
    
    /**
     * Getter del nombre.
     *
     * @return String nombre.
     */
    public String getName() {
        return name;
    }
    /**
     * Getter del turno.
     *
     * @return Boolean turno.
     */
    public Boolean getTurnoJugador() {
        return turno;
    }
    /**
     * Setter del turno.
     *
     * @param turno boolean.
     */
    public void setTurnoJugador(Boolean turno) {
        this.turno = turno;
    }
    /**
     * Setter del nombre.
     *
     * @param name String.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Getter del tipoPiezas.
     *
     * @return String tipoPiezas.
     */
    public String getTipoPiezas() {
        return tipoPiezas;
    }
    /**
     * Setter del tipoPiezas.
     *
     * @param tipoPiezas String.
     */
    public void setTipoPiezas(String tipoPiezas) {
        this.tipoPiezas = tipoPiezas;
    }
    
    
}