package seas.angel.macdonald.chess2d.modelo;


import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase que define la entidad Tablero que implementa la interfaz serializable para poder realizar posteriormente el grabado de datos correctamente
 * 
 * @author Ángel Mac Donald
 */
public class Tablero implements Serializable{

   
   /**
     * Variable que conforma parte de la dimensión del tablero - Filas
     */
   public static final int ROWS = 8;
   /**
     * Variable que conforma parte de la dimensión del tablero - Columnas
     */
   public static final int COLS = ROWS;
   /**
     * Variable que conforma el espaciado entre las celdas
     */
   public static final int GAP = 0;
   /**
    * Matriz de Celdas que contiene todas las celdas del tablero
    */
   private  Celda[][] arrayDeCeldas;
   /**
    * Matriz de String que contiene el tipo de piezas (peón, alfil, caballo, ...) que contendrán las celdas del tablero (matriz lógica)
    */
   private  String[][] boardUI;
   /**
    * ArrayList de las piezas que están fuera del juego
    */
   private  ArrayList<Pieza> arrayDePiezasMuertas;
   /**
    * ArrayList de las piezas que podrá elegir el jugador que lleve al peón hasta el extremo del tablero
    */
   private ArrayList<Pieza> arraySelectorPiezas;
   
   /**
     * Constructor por defecto que inicializa la matriz de celdas, la matriz lógica, el arrayList de piezas muertas y el arrayList de piezas 
     * a seleccionar por el jugador que lleve el peón al etremo del tablero.
     */
   public Tablero(){
       arrayDeCeldas = new Celda[ROWS][COLS];
       boardUI = new String[ROWS][COLS];
       arrayDePiezasMuertas = new ArrayList<>();
       arraySelectorPiezas = new ArrayList<>();
   }
   /**
     * Constructor que recibe la matriz de celdas como parametro. Utilizado para
     * cargar partidas.
     *
     * @param arrayDeCeldas Celda[][] arrayDeCeldas.
     */
    public Tablero(Celda[][] arrayDeCeldas) {
        this.arrayDeCeldas = arrayDeCeldas;
    }
    /**
     * Constructor que recibe la matriz de celdas como parametro. Utilizado para
     * cargar partidas.
     *
     * @param boardUI String[][] boardUI.
     */
    public Tablero(String[][] boardUI) {
        this.boardUI = boardUI;
    }

    /**
     * Getter de arrayDePiezasMuertas.
     *
     * @return ArrayList arrayDePiezasMuertas.
     */
    public ArrayList<Pieza> getArrayDePiezasMuertas() {
        return arrayDePiezasMuertas;
    }
    /**
     * Setter de arrayDePiezasMuertas.
     *
     * @param arrayDePiezasMuertas ArrayList.
     */
    public void setArrayDePiezasMuertas(ArrayList<Pieza> arrayDePiezasMuertas) {
        this.arrayDePiezasMuertas = arrayDePiezasMuertas;
    }
    /**
     * Getter de arraySelectorPiezas.
     *
     * @return ArrayList arraySelectorPiezas.
     */
    public ArrayList<Pieza> getArraySelectorPiezas() {
        return arraySelectorPiezas;
    }
    /**
     * Setter de arraySelectorPiezas.
     *
     * @param arraySelectorPiezas ArrayList.
     */
    public void setArraySelectorPiezas(ArrayList<Pieza> arraySelectorPiezas) {
        this.arraySelectorPiezas = arraySelectorPiezas;
    }
    /**
     * Getter de arrayDeCeldas.
     *
     * @return Celda[][] arrayDeCeldas.
     */
    public  Celda[][] getCeldas(){
        return arrayDeCeldas;
    }
    /**
     * Setter de aArrayDeCeldas.
     *
     * @param aArrayDeCeldas Celda[][].
     */
    public  void setCeldas(Celda[][] aArrayDeCeldas) {
        arrayDeCeldas = aArrayDeCeldas;
    }
    /**
     * Getter de boardUI.
     *
     * @return String[][] boardUI.
     */
    public  String[][] getBoardUI(){
        return boardUI;
    }
    /**
     * Setter de aBoardUI.
     *
     * @param aBoardUI String[][].
     */
    public  void setBoardUI(String[][] aBoardUI) {
        boardUI = aBoardUI;
    }
   
    
   
}