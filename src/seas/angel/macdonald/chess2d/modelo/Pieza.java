package seas.angel.macdonald.chess2d.modelo;

import seas.angel.macdonald.chess2d.vista.PanelTablero;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.JButton;

/**
 * Clase que define la entidad de todas las Piezas, implementa la interfaz Serializable para poder realizar el grabado en los archivos.
 * 
 * @author Ángel Mac Donald Gainza
 */
public class Pieza extends JButton implements Serializable{
    /**
     * Identificador único de la pieza
     */
    private Integer idPieza;
    /**
     * Con la siguiente variable sabemos si es un peón, caballo, alfil, etc...
     */
    private Integer tipoPieza;
    /**
     * Para saber la posición en filas de la ficha en el tablero
     */
    private Integer posEnFilasTablero;
    /**
     * Para saber la posición en columnas de la ficha en el tablero
     */
    private Integer posEnColumnasTablero;
    /**
     * Para saber el nombre de la pieza
     */
    private String  name;
    /**
     * La ruta de la imagen de la pieza en cuestión
     */
    private String  rutaImagen;
    private Integer mvtoEnFilas;
    private Integer mvtoEnColumnas;
    /**
     * Para saber si la ficha está fuera de juego
     */
    private Boolean estaMuerta;
    /**
     * Para identificar el bando de la pieza, si 
     * 1.BLANCAS
     * 2.NEGRAS
     */
    private Integer bandoPieza; 
    /**
     * Para saber el punto de partida de la ficha
     */
    private Celda celdaOrigen; 
    /**
     * Para saber el número de movimientos realizados por una ficha
     */
    private Integer numeroMovimiento;
    /**
     * Guardaremos las filas de los posibles movimientos
     */
    private ArrayList filaPosible = new ArrayList(); 
    /**
     * Guardaremos las columnas de los posibles movimientos 
     */
    private ArrayList columnaPosible = new ArrayList(); 
    /**
     * Guardaremos las filas de la amenaza al Rey
     */
    private ArrayList filaAmenazaRey = new ArrayList();
    /**
     * Guardaremos las columnas de la amenaza al Rey
     */
    private ArrayList columnaAmenazaRey = new ArrayList(); 
    /**
     * Variable que marcará si se puede mover la pieza nos vendrá bien para restringir el mvto de las piezas cuando haya algún jaque
     */
    private Boolean movePiece;
    
    
    /**
     * Getter de tipoPieza.
     *
     * @return Integer tipoPieza.
     */
    public Integer getTipoPieza() {
        return tipoPieza;
    }
    /**
     * Setter de tipoPieza.
     *
     * @param tipoPieza Integer
     */
    public void setTipoPieza(Integer tipoPieza) {
        this.tipoPieza = tipoPieza;
    }
    /**
     * Getter de movePiece.
     *
     * @return Boolean movePiece.
     */
    public Boolean getMovePiece() {
        return movePiece;
    }
    /**
     * Setter de movePiece.
     *
     * @param movePiece Boolean
     */
    public void setMovePiece(Boolean movePiece) {
        this.movePiece = movePiece;
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
     * Getter de posEnColumnasTablero.
     *
     * @return Integer posEnColumnasTablero.
     */
    public Integer getPosEnColumnasTablero() {
        return posEnColumnasTablero;
    }
    /**
     * Getter de bandoPieza.
     * 
     * @return Integer bandoPieza: 1.Blancas 2.Negras
     */
    public Integer getBandoPieza() {
        return bandoPieza;
    }
    /**
     * Setter de bandoPieza.
     *
     * @param bandoPieza Integer
     */
    public void setBandoPieza(Integer bandoPieza) {
        this.bandoPieza = bandoPieza;
    }
    /**
     * Getter de celdaOrigen.
     *
     * @return Celda celdaOrigen.
     */
    public Celda getCeldaOrigen() {
        return celdaOrigen;
    }
    /**
     * Setter de celdaOrigen.
     *
     * @param celdaOrigen Celda
     */
    public void setCeldaOrigen(Celda celdaOrigen) {
        this.celdaOrigen = celdaOrigen;
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
     * Getter de idPieza.
     *
     * @return Integer idPieza.
     */
    public Integer getIdPieza() {
        return idPieza;
    }
    /**
     * Getter de numeroMovimiento.
     *
     * @return Integer numeroMovimiento.
     */
    public Integer getNumeroMovimiento() {
        return numeroMovimiento;
    }
    /**
     * Setter de numeroMovimiento.
     *
     * @param numeroMovimiento Integer
     */
    public void setNumeroMovimiento(Integer numeroMovimiento) {
        this.numeroMovimiento = numeroMovimiento;
    }
    /**
     * Getter de filaPosible.
     *
     * @return ArrayList filaPosible.
     */
    public ArrayList getFilaPosible() {
        return filaPosible;
    }
    /**
     * Setter de filaPosible.
     *
     * @param filaPosible Integer
     */
    public void setFilaPosible(Integer filaPosible) {
        this.filaPosible.add(filaPosible);
    }
    /**
     * Getter de columnaPosible.
     *
     * @return ArrayList columnaPosible.
     */
    public ArrayList getColumnaPosible() {
        return columnaPosible;
    }
    /**
     * Setter de columnaPosible.
     *
     * @param columnaPosible Integer
     */
    public void setColumnaPosible(Integer columnaPosible) {
        this.columnaPosible.add(columnaPosible);
    }
    /**
     * Getter de filaAmenazaRey.
     *
     * @return ArrayList filaAmenazaRey.
     */
    public ArrayList getFilaAmenazaRey() {
        return filaAmenazaRey;
    }
    /**
     * Setter de filaAmenazaRey.
     *
     * @param filaAmenazaRey Integer
     */
    public void setFilaAmenazaRey(Integer filaAmenazaRey) {
        this.filaAmenazaRey.add(filaAmenazaRey);
    }
    /**
     * Getter de columnaAmenazaRey.
     *
     * @return ArrayList columnaAmenazaRey.
     */
    public ArrayList getColumnaAmenazaRey() {
        return columnaAmenazaRey;
    }
    /**
     * Setter de columnaAmenazaRey.
     *
     * @param columnaAmenazaRey Integer
     */
    public void setColumnaAmenazaRey(Integer columnaAmenazaRey) {
        this.columnaAmenazaRey.add(columnaAmenazaRey);
    }
    /**
     * @param idPieza the idPieza to set
     */
    public void setIdPieza(Integer idPieza) {
        this.idPieza = idPieza;
    }
    /**
     * Getter de rutaImagen.
     *
     * @return String rutaImagen.
     */
    public String getRutaImagen() {
        return rutaImagen;
    }
    /**
     * Setter de rutaImagen.
     *
     * @param rutaImagen String
     */
    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }
    /**
     * Getter de name.
     *
     * @return String name.
     */
    @Override
    public String getName() {
        return name;
    }
    /**
     * Setter de name.
     *
     * @param name String
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Getter de mvtoEnFilas.
     *
     * @return Integer mvtoEnFilas.
     */
    public Integer getMvtoEnFilas() {
        return mvtoEnFilas;
    }
    /**
     * Setter de mvtoEnFilas.
     *
     * @param mvtoEnFilas Integer
     */
    public void setMvtoEnFilas(Integer mvtoEnFilas) {
        this.mvtoEnFilas = mvtoEnFilas;
    }
    /**
     * Getter de mvtoEnColumnas.
     *
     * @return Integer mvtoEnColumnas.
     */
    public Integer getMvtoEnColumnas() {
        return mvtoEnColumnas;
    }
    /**
     * Setter de mvtoEnColumnas.
     *
     * @param mvtoEnColumnas Integer
     */
    public void setMvtoEnColumnas(Integer mvtoEnColumnas) {
        this.mvtoEnColumnas = mvtoEnColumnas;
    }
    /**
     * Getter de estaMuerta.
     *
     * @return Boolean estaMuerta.
     */
    public Boolean getEstaMuerta() {
        return estaMuerta;
    }
    /**
     * Setter de estaMuerta.
     *
     * @param estaMuerta Boolean
     */
    public void setEstaMuerta(Boolean estaMuerta) {
        this.estaMuerta = estaMuerta;
    }
    
    
    /**
     * Método que nos comprueba los posibles movimientos de cada una de las fichas
     * 
     * @param tablero PanelTablero que contiene tanto los datos de la pantalla, del tablero y la partida
     * @param pieza  Pieza que vamos a analizar
     */
    public void checkPossiblesMovesAndStoreThem(PanelTablero tablero, Pieza pieza){
        Integer fila, columna,x;
        Boolean piezaEncontrada = false;
        fila = pieza.getPosEnFilasTablero();
        columna = pieza.getPosEnColumnasTablero();
        
        //Limpiamos el array list de posibles filas y columnas antes de comenzar
        pieza.getFilaPosible().clear();
        pieza.getColumnaPosible().clear();
        
        switch(pieza.getName()){
            case "Caballo":
                
                   
                
                //L EN VERTICAL 
                //2 filas 1 columna
                
                    
                    if(columna+1<=7 && fila+2<=7){
                        if(tablero.arrayDeCeldas[fila+2][columna+1].getPieza()!=null
                            && !Objects.equals(tablero.arrayDeCeldas[fila+2][columna+1].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                            //Si hay un ficha y es del bando contrario
                            pieza.setFilaPosible(fila+2);
                            pieza.setColumnaPosible(columna+1);
                        }else if(tablero.arrayDeCeldas[fila+2][columna+1].getPieza()==null){
                            pieza.setFilaPosible(fila+2);
                            pieza.setColumnaPosible(columna+1);
                        }
                    }
                    
                    if(fila+2<=7 && columna-1>=0){
                        //2 filas -1 columna
                        if(tablero.arrayDeCeldas[fila+2][columna-1].getPieza()!=null
                                && !Objects.equals(tablero.arrayDeCeldas[fila+2][columna-1].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                            //Si hay un ficha y es del bando contrario
                            pieza.setFilaPosible(fila+2);
                            pieza.setColumnaPosible(columna-1);
                        }else if(tablero.arrayDeCeldas[fila+2][columna-1].getPieza()==null){
                            pieza.setFilaPosible(fila+2);
                            pieza.setColumnaPosible(columna-1);
                        }
                    }
                    
                    if(fila-2>=0 && columna+1<=7){
                        //-2 filas 1 columna
                        if(tablero.arrayDeCeldas[fila-2][columna+1].getPieza()!=null
                                && !Objects.equals(tablero.arrayDeCeldas[fila-2][columna+1].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                            //Si hay un ficha y es del bando contrario
                            pieza.setFilaPosible(fila-2);
                            pieza.setColumnaPosible(columna+1);
                        }else if(tablero.arrayDeCeldas[fila-2][columna+1].getPieza()==null){
                            pieza.setFilaPosible(fila-2);
                            pieza.setColumnaPosible(columna+1);
                        }
                    }
                    
                    
                    if(fila-2>=0 && columna-1>=0){
                        //-2 filas -1 columna
                        if(tablero.arrayDeCeldas[fila-2][columna-1].getPieza()!=null
                                && !Objects.equals(tablero.arrayDeCeldas[fila-2][columna-1].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                            //Si hay un ficha y es del bando contrario
                            pieza.setFilaPosible(fila-2);
                            pieza.setColumnaPosible(columna-1);
                        }else if(tablero.arrayDeCeldas[fila-2][columna-1].getPieza()==null){
                            pieza.setFilaPosible(fila-2);
                            pieza.setColumnaPosible(columna-1);
                        }    
                    }
                    
                    
                
                
                    
                //L EN HORIZONTAL
                //1 filas 2 columna
                
                    
                    if(fila+1<=7 && columna+2<=7){
                        if(tablero.arrayDeCeldas[fila+1][columna+2].getPieza()!=null
                            && !Objects.equals(tablero.arrayDeCeldas[fila+1][columna+2].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                            //Si hay un ficha y es del bando contrario
                            pieza.setFilaPosible(fila+1);
                            pieza.setColumnaPosible(columna+2);
                        }else if(tablero.arrayDeCeldas[fila+1][columna+2].getPieza()==null){
                            pieza.setFilaPosible(fila+1);
                            pieza.setColumnaPosible(columna+2);
                        }   
                    }
                     
                    if(fila-1>=0 && columna-2>=0){
                        //-1 filas -2 columna
                        if(tablero.arrayDeCeldas[fila-1][columna-2].getPieza()!=null
                                && !Objects.equals(tablero.arrayDeCeldas[fila-1][columna-2].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                            //Si hay un ficha y es del bando contrario
                            pieza.setFilaPosible(fila-1);
                            pieza.setColumnaPosible(columna-2);
                        }else if(tablero.arrayDeCeldas[fila-1][columna-2].getPieza()==null){
                            pieza.setFilaPosible(fila-1);
                            pieza.setColumnaPosible(columna-2);
                        }  
                    }
                     
                    if(fila-1>=0 && columna+2<=7){
                        //-1 filas 2 columna
                        if(tablero.arrayDeCeldas[fila-1][columna+2].getPieza()!=null
                                && !Objects.equals(tablero.arrayDeCeldas[fila-1][columna+2].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                            //Si hay un ficha y es del bando contrario
                            pieza.setFilaPosible(fila-1);
                            pieza.setColumnaPosible(columna+2);
                        }else if(tablero.arrayDeCeldas[fila-1][columna+2].getPieza()==null){
                            pieza.setFilaPosible(fila-1);
                            pieza.setColumnaPosible(columna+2);
                        } 
                    }
                    
                    if(fila+1<=7 && columna-2>=0){
                        //1 filas -2 columna
                        if(tablero.arrayDeCeldas[fila+1][columna-2].getPieza()!=null
                                && !Objects.equals(tablero.arrayDeCeldas[fila+1][columna-2].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                            //Si hay un ficha y es del bando contrario
                            pieza.setFilaPosible(fila+1);
                            pieza.setColumnaPosible(columna-2);
                        }else if(tablero.arrayDeCeldas[fila+1][columna-2].getPieza()==null){
                            pieza.setFilaPosible(fila+1);
                            pieza.setColumnaPosible(columna-2);
                        }   
                    }
                    
                
                
                break;
            case "Rey":
                
                if(pieza.getPosEnFilasTablero()==0
                        && Objects.equals(pieza.getPosEnColumnasTablero(), pieza.getCeldaOrigen().getPosEnColumnasTablero())){
                    
                    //FILAS
                    //Fila + 1
                    //Si hay una ficha y la misma es del bando contrario
                    if(tablero.arrayDeCeldas[fila+1][columna].getPieza() != null 
                            && !Objects.equals(tablero.arrayDeCeldas[fila+1][columna].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                        pieza.setFilaPosible(fila+1);
                        pieza.setColumnaPosible(columna);
                    //Si hay una celda vacía
                    }else if(tablero.arrayDeCeldas[fila+1][columna].getPieza()==null){
                        pieza.setFilaPosible(fila+1);
                        pieza.setColumnaPosible(columna);
                    }


                    //COLUMNAS
                    //Columna + 1
                    //Si hay una Columna y la misma es del bando contrario
                    if(tablero.arrayDeCeldas[fila][columna+1].getPieza() != null 
                            && !Objects.equals(tablero.arrayDeCeldas[fila][columna+1].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                        pieza.setFilaPosible(fila);
                        pieza.setColumnaPosible(columna+1);
                    //Si hay una celda vacía
                    }else if(tablero.arrayDeCeldas[fila][columna+1].getPieza()==null){
                        pieza.setFilaPosible(fila);
                        pieza.setColumnaPosible(columna+1);
                    }
                    //COLUMNA - 1
                    //Si hay una Columna y la misma es del bando contrario
                    if(tablero.arrayDeCeldas[fila][columna-1].getPieza() != null 
                            && !Objects.equals(tablero.arrayDeCeldas[fila][columna-1].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                        pieza.setFilaPosible(fila);
                        pieza.setColumnaPosible(columna-1);
                    //Si hay una celda vacía
                    }else if(tablero.arrayDeCeldas[fila][columna-1].getPieza()==null){
                        pieza.setFilaPosible(fila);
                        pieza.setColumnaPosible(columna-1);
                    }
                    
                    //DIAGONALES
                    //COLUMNA - 1 y FILA + 1
                    //Si hay una Columna y la misma es del bando contrario
                    if(tablero.arrayDeCeldas[fila+1][columna-1].getPieza() != null 
                            && !Objects.equals(tablero.arrayDeCeldas[fila+1][columna-1].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                        pieza.setFilaPosible(fila+1);
                        pieza.setColumnaPosible(columna-1);
                    //Si hay una celda vacía
                    }else if(tablero.arrayDeCeldas[fila+1][columna-1].getPieza()==null){
                        pieza.setFilaPosible(fila+1);
                        pieza.setColumnaPosible(columna-1);
                    }
                       
                    
                    //COLUMNA + 1 y FILA + 1
                    if(tablero.arrayDeCeldas[fila+1][columna+1].getPieza() != null 
                            && !Objects.equals(tablero.arrayDeCeldas[fila+1][columna+1].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                        pieza.setFilaPosible(fila+1);
                        pieza.setColumnaPosible(columna+1);
                    //Si hay una celda vacía
                    }else if(tablero.arrayDeCeldas[fila+1][columna+1].getPieza()==null){
                        pieza.setFilaPosible(fila+1);
                        pieza.setColumnaPosible(columna+1);
                    }
                    
                }else if(pieza.getPosEnFilasTablero()==7
                        && Objects.equals(pieza.getPosEnColumnasTablero(), pieza.getCeldaOrigen().getPosEnColumnasTablero())){
                    //FILAS
                    
                    if(!Objects.equals(pieza.getPosEnFilasTablero(), pieza.getCeldaOrigen().getPosEnFilasTablero())){
                    //FILA - 1
                    //Si hay una ficha y la misma es del bando contrario
                    if(tablero.arrayDeCeldas[fila-1][columna].getPieza() != null 
                            && !Objects.equals(tablero.arrayDeCeldas[fila-1][columna].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                            pieza.setFilaPosible(fila-1);
                            pieza.setColumnaPosible(columna);
                        //Si hay una celda vacía
                        }else if(tablero.arrayDeCeldas[fila-1][columna].getPieza()==null){
                            pieza.setFilaPosible(fila-1);
                            pieza.setColumnaPosible(columna);
                        }
                    }


                    //COLUMNAS
                    //COLUMNA + 1
                    //Si hay una Columna y la misma es del bando contrario
                    if(tablero.arrayDeCeldas[fila][columna+1].getPieza() != null 
                            && !Objects.equals(tablero.arrayDeCeldas[fila][columna+1].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                        pieza.setFilaPosible(fila);
                        pieza.setColumnaPosible(columna+1);
                    //Si hay una celda vacía
                    }else if(tablero.arrayDeCeldas[fila][columna+1].getPieza()==null){
                        pieza.setFilaPosible(fila);
                        pieza.setColumnaPosible(columna+1);
                    }
                    //COLUMNA - 1
                    //Si hay una Columna y la misma es del bando contrario
                    if(tablero.arrayDeCeldas[fila][columna-1].getPieza() != null 
                            && !Objects.equals(tablero.arrayDeCeldas[fila][columna-1].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                        pieza.setFilaPosible(fila);
                        pieza.setColumnaPosible(columna-1);
                    //Si hay una celda vacía
                    }else if(tablero.arrayDeCeldas[fila][columna-1].getPieza()==null){
                        pieza.setFilaPosible(fila);
                        pieza.setColumnaPosible(columna-1);
                    }
                    
                    
                    //DIAGONALES
                    //COLUMNA - 1 y FILA - 1
                    //Si hay una Columna y la misma es del bando contrario
                    if(tablero.arrayDeCeldas[fila-1][columna-1].getPieza() != null 
                            && !Objects.equals(tablero.arrayDeCeldas[fila-1][columna-1].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                        pieza.setFilaPosible(fila-1);
                        pieza.setColumnaPosible(columna-1);
                    //Si hay una celda vacía
                    }else if(tablero.arrayDeCeldas[fila-1][columna-1].getPieza()==null){
                        pieza.setFilaPosible(fila-1);
                        pieza.setColumnaPosible(columna-1);
                    }
                       
                    
                    //COLUMNA + 1 y FILA - 1
                    if(tablero.arrayDeCeldas[fila-1][columna+1].getPieza() != null 
                            && !Objects.equals(tablero.arrayDeCeldas[fila-1][columna+1].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                        pieza.setFilaPosible(fila-1);
                        pieza.setColumnaPosible(columna+1);
                    //Si hay una celda vacía
                    }else if(tablero.arrayDeCeldas[fila-1][columna+1].getPieza()==null){
                        pieza.setFilaPosible(fila-1);
                        pieza.setColumnaPosible(columna+1);
                    }
                    
                    
                }else if(pieza.getPosEnFilasTablero()==0
                        && pieza.getPosEnColumnasTablero()==0){
                    
                    //FILAS
                    //Fila + 1
                    //Si hay una ficha y la misma es del bando contrario
                    if(tablero.arrayDeCeldas[fila+1][columna].getPieza() != null 
                            && !Objects.equals(tablero.arrayDeCeldas[fila+1][columna].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                        pieza.setFilaPosible(fila+1);
                        pieza.setColumnaPosible(columna);
                    //Si hay una celda vacía
                    }else if(tablero.arrayDeCeldas[fila+1][columna].getPieza()==null){
                        pieza.setFilaPosible(fila+1);
                        pieza.setColumnaPosible(columna);
                    }


                    //COLUMNAS
                    //Columna + 1
                    //Si hay una Columna y la misma es del bando contrario
                    if(tablero.arrayDeCeldas[fila][columna+1].getPieza() != null 
                            && !Objects.equals(tablero.arrayDeCeldas[fila][columna+1].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                        pieza.setFilaPosible(fila);
                        pieza.setColumnaPosible(columna+1);
                    //Si hay una celda vacía
                    }else if(tablero.arrayDeCeldas[fila][columna+1].getPieza()==null){
                        pieza.setFilaPosible(fila);
                        pieza.setColumnaPosible(columna+1);
                    }
                    
                    //DIAGONALES
                    //COLUMNA + 1 y FILA + 1
                    //Si hay una Columna y la misma es del bando contrario
                    if(tablero.arrayDeCeldas[fila+1][columna+1].getPieza() != null 
                            && !Objects.equals(tablero.arrayDeCeldas[fila+1][columna+1].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                        pieza.setFilaPosible(fila+1);
                        pieza.setColumnaPosible(columna+1);
                    //Si hay una celda vacía
                    }else if(tablero.arrayDeCeldas[fila+1][columna+1].getPieza()==null){
                        pieza.setFilaPosible(fila+1);
                        pieza.setColumnaPosible(columna+1);
                    }
                       
                    
                }else if(pieza.getPosEnFilasTablero()==0
                        && pieza.getPosEnColumnasTablero()==7){
                    
                    //FILAS
                    //Fila + 1
                    //Si hay una ficha y la misma es del bando contrario
                    if(tablero.arrayDeCeldas[fila+1][columna].getPieza() != null 
                            && !Objects.equals(tablero.arrayDeCeldas[fila+1][columna].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                        pieza.setFilaPosible(fila+1);
                        pieza.setColumnaPosible(columna);
                    //Si hay una celda vacía
                    }else if(tablero.arrayDeCeldas[fila+1][columna].getPieza()==null){
                        pieza.setFilaPosible(fila+1);
                        pieza.setColumnaPosible(columna);
                    }
                    


                    //COLUMNAS
                    //COLUMNA - 1
                    //Si hay una Columna y la misma es del bando contrario
                    if(tablero.arrayDeCeldas[fila][columna-1].getPieza() != null 
                            && !Objects.equals(tablero.arrayDeCeldas[fila][columna-1].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                        pieza.setFilaPosible(fila);
                        pieza.setColumnaPosible(columna-1);
                    //Si hay una celda vacía
                    }else if(tablero.arrayDeCeldas[fila][columna-1].getPieza()==null){
                        pieza.setFilaPosible(fila);
                        pieza.setColumnaPosible(columna-1);
                    }
                    
                    //DIAGONALES
                    //COLUMNA - 1 y FILA + 1
                    //Si hay una Columna y la misma es del bando contrario
                    if(tablero.arrayDeCeldas[fila+1][columna-1].getPieza() != null 
                            && !Objects.equals(tablero.arrayDeCeldas[fila+1][columna-1].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                        pieza.setFilaPosible(fila+1);
                        pieza.setColumnaPosible(columna-1);
                    //Si hay una celda vacía
                    }else if(tablero.arrayDeCeldas[fila+1][columna-1].getPieza()==null){
                        pieza.setFilaPosible(fila+1);
                        pieza.setColumnaPosible(columna-1);
                    }
                    
                }else if(pieza.getPosEnFilasTablero()==7
                        && pieza.getPosEnColumnasTablero()==0){
                    
                    //FILAS
                    
                    if(!Objects.equals(pieza.getPosEnFilasTablero(), pieza.getCeldaOrigen().getPosEnFilasTablero())){
                        //Fila - 1
                    //Si hay una ficha y la misma es del bando contrario
                    if(tablero.arrayDeCeldas[fila-1][columna].getPieza() != null 
                            && !Objects.equals(tablero.arrayDeCeldas[fila-1][columna].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                            pieza.setFilaPosible(fila-1);
                            pieza.setColumnaPosible(columna);
                        //Si hay una celda vacía
                        }else if(tablero.arrayDeCeldas[fila-1][columna].getPieza()==null){
                            pieza.setFilaPosible(fila-1);
                            pieza.setColumnaPosible(columna);
                        }
                    }


                    //COLUMNAS
                    //Columna + 1
                    //Si hay una Columna y la misma es del bando contrario
                    if(tablero.arrayDeCeldas[fila][columna+1].getPieza() != null 
                            && !Objects.equals(tablero.arrayDeCeldas[fila][columna+1].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                        pieza.setFilaPosible(fila);
                        pieza.setColumnaPosible(columna+1);
                    //Si hay una celda vacía
                    }else if(tablero.arrayDeCeldas[fila][columna+1].getPieza()==null){
                        pieza.setFilaPosible(fila);
                        pieza.setColumnaPosible(columna+1);
                    }
                    
                    //DIAGONALES
                    //COLUMNA + 1 y FILA - 1
                    //Si hay una Columna y la misma es del bando contrario
                    if(tablero.arrayDeCeldas[fila-1][columna+1].getPieza() != null 
                            && !Objects.equals(tablero.arrayDeCeldas[fila-1][columna+1].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                        pieza.setFilaPosible(fila-1);
                        pieza.setColumnaPosible(columna+1);
                    //Si hay una celda vacía
                    }else if(tablero.arrayDeCeldas[fila-1][columna+1].getPieza()==null){
                        pieza.setFilaPosible(fila-1);
                        pieza.setColumnaPosible(columna+1);
                    }
                    
                }else if(pieza.getPosEnFilasTablero()==7
                        && pieza.getPosEnColumnasTablero()==7){
                    
                    //FILAS
                    
                    if(!Objects.equals(pieza.getPosEnFilasTablero(), pieza.getCeldaOrigen().getPosEnFilasTablero())){
                    //Fila - 1
                    //Si hay una ficha y la misma es del bando contrario
                    if(tablero.arrayDeCeldas[fila-1][columna].getPieza() != null 
                            && !Objects.equals(tablero.arrayDeCeldas[fila-1][columna].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                            pieza.setFilaPosible(fila-1);
                            pieza.setColumnaPosible(columna);
                        //Si hay una celda vacía
                        }else if(tablero.arrayDeCeldas[fila-1][columna].getPieza()==null){
                            pieza.setFilaPosible(fila-1);
                            pieza.setColumnaPosible(columna);
                        }
                    }


                    //COLUMNAS
                    
                    //Columna - 1
                    //Si hay una Columna y la misma es del bando contrario
                    if(tablero.arrayDeCeldas[fila][columna-1].getPieza() != null 
                            && !Objects.equals(tablero.arrayDeCeldas[fila][columna-1].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                        pieza.setFilaPosible(fila);
                        pieza.setColumnaPosible(columna-1);
                    //Si hay una celda vacía
                    }else if(tablero.arrayDeCeldas[fila][columna-1].getPieza()==null){
                        pieza.setFilaPosible(fila);
                        pieza.setColumnaPosible(columna-1);
                    }
                    
                    //DIAGONALES
                    //COLUMNA - 1 y FILA - 1
                    //Si hay una Columna y la misma es del bando contrario
                    if(tablero.arrayDeCeldas[fila-1][columna-1].getPieza() != null 
                            && !Objects.equals(tablero.arrayDeCeldas[fila-1][columna-1].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                        pieza.setFilaPosible(fila-1);
                        pieza.setColumnaPosible(columna-1);
                    //Si hay una celda vacía
                    }else if(tablero.arrayDeCeldas[fila-1][columna-1].getPieza()==null){
                        pieza.setFilaPosible(fila-1);
                        pieza.setColumnaPosible(columna-1);
                    }
                    
                }else{
                    //FILAS
                    //FILA + 1
                    if((fila+1) <= 7){
                        //Si hay una ficha y la misma es del bando contrario
                        if(tablero.arrayDeCeldas[fila+1][columna].getPieza() != null 
                                && !Objects.equals(tablero.arrayDeCeldas[fila+1][columna].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                            pieza.setFilaPosible(fila+1);
                            pieza.setColumnaPosible(columna);
                        //Si hay una celda vacía
                        }else if(tablero.arrayDeCeldas[fila+1][columna].getPieza()==null){
                            pieza.setFilaPosible(fila+1);
                            pieza.setColumnaPosible(columna);
                        }
                    }
                    //FILA - 1
                    if(!Objects.equals(pieza.getPosEnFilasTablero(), pieza.getCeldaOrigen().getPosEnFilasTablero())){
                        if(fila-1 >=0){
                            //Fila - 1
                            //Si hay una ficha y la misma es del bando contrario
                            if(tablero.arrayDeCeldas[fila-1][columna].getPieza() != null 
                                && !Objects.equals(tablero.arrayDeCeldas[fila-1][columna].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                                pieza.setFilaPosible(fila-1);
                                pieza.setColumnaPosible(columna);
                            //Si hay una celda vacía
                            }else if(tablero.arrayDeCeldas[fila-1][columna].getPieza()==null){
                                pieza.setFilaPosible(fila-1);
                                pieza.setColumnaPosible(columna);
                            }
                        }
                        
                    }


                    //COLUMNAS
                    //COLUMNA + 1
                    if((columna+1)<=7){
                        //Si hay una Columna y la misma es del bando contrario
                        if(tablero.arrayDeCeldas[fila][columna+1].getPieza() != null 
                                && !Objects.equals(tablero.arrayDeCeldas[fila][columna+1].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                            pieza.setFilaPosible(fila);
                            pieza.setColumnaPosible(columna+1);
                        //Si hay una celda vacía
                        }else if(tablero.arrayDeCeldas[fila][columna+1].getPieza()==null){
                            pieza.setFilaPosible(fila);
                            pieza.setColumnaPosible(columna+1);
                        }
                    }
                    
                    //COLUMNA - 1
                    if((columna-1)>=0){
                       //Si hay una Columna y la misma es del bando contrario
                        if(tablero.arrayDeCeldas[fila][columna-1].getPieza() != null 
                                && !Objects.equals(tablero.arrayDeCeldas[fila][columna-1].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                            pieza.setFilaPosible(fila);
                            pieza.setColumnaPosible(columna-1);
                        //Si hay una celda vacía
                        }else if(tablero.arrayDeCeldas[fila][columna-1].getPieza()==null){
                            pieza.setFilaPosible(fila);
                            pieza.setColumnaPosible(columna-1);
                        } 
                    }
                    
                    
                    //DIAGONALES
                    //COLUMNA - 1 y FILA + 1
                    if((columna-1)>=0 && (fila+1)<=7){
                        //Si hay una Columna y la misma es del bando contrario
                        if(tablero.arrayDeCeldas[fila+1][columna-1].getPieza() != null 
                                && !Objects.equals(tablero.arrayDeCeldas[fila+1][columna-1].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                            pieza.setFilaPosible(fila+1);
                            pieza.setColumnaPosible(columna-1);
                        //Si hay una celda vacía
                        }else if(tablero.arrayDeCeldas[fila+1][columna-1].getPieza()==null){
                            pieza.setFilaPosible(fila+1);
                            pieza.setColumnaPosible(columna-1);
                        }
                    }
                    
                       
                    
                    //COLUMNA + 1 y FILA + 1
                    if((columna+1)<=7 && (fila+1)<=7){
                        if(tablero.arrayDeCeldas[fila+1][columna+1].getPieza() != null 
                            && !Objects.equals(tablero.arrayDeCeldas[fila+1][columna+1].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                            pieza.setFilaPosible(fila+1);
                            pieza.setColumnaPosible(columna+1);
                        //Si hay una celda vacía
                        }else if(tablero.arrayDeCeldas[fila+1][columna+1].getPieza()==null){
                            pieza.setFilaPosible(fila+1);
                            pieza.setColumnaPosible(columna+1);
                        }
                    }
                    
                    //COLUMNA - 1 y FILA - 1
                    if((columna-1)>=0 && (fila-1)>=0){
                        //Si hay una Columna y la misma es del bando contrario
                        if(tablero.arrayDeCeldas[fila-1][columna-1].getPieza() != null 
                                && !Objects.equals(tablero.arrayDeCeldas[fila-1][columna-1].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                            pieza.setFilaPosible(fila-1);
                            pieza.setColumnaPosible(columna-1);
                        //Si hay una celda vacía
                        }else if(tablero.arrayDeCeldas[fila-1][columna-1].getPieza()==null){
                            pieza.setFilaPosible(fila-1);
                            pieza.setColumnaPosible(columna-1);
                        }
                    }
                    
                    //COLUMNA + 1 y FILA - 1
                    if((columna+1)<=7 && (fila-1)>=0){
                        //Si hay una Columna y la misma es del bando contrario
                        if(tablero.arrayDeCeldas[fila-1][columna+1].getPieza() != null 
                                && !Objects.equals(tablero.arrayDeCeldas[fila-1][columna+1].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                            pieza.setFilaPosible(fila-1);
                            pieza.setColumnaPosible(columna+1);
                        //Si hay una celda vacía
                        }else if(tablero.arrayDeCeldas[fila-1][columna+1].getPieza()==null){
                            pieza.setFilaPosible(fila-1);
                            pieza.setColumnaPosible(columna+1);
                        }
                    }
                    
                    
                }
                
                break;
            case "Peón":
                //Si el péon está en la posición inicial
                if(Objects.equals(pieza.getCeldaOrigen().getPosEnFilasTablero(), fila)){
                    if(pieza.getCeldaOrigen().getPosEnFilasTablero()==1){
                        //Tiene como posiciones posibles las dos siguientes filas en la misma columna
                        if((fila+1) <= 7 && tablero.arrayDeCeldas[fila+1][columna].getPieza()==null){
                            pieza.setFilaPosible(fila+1);
                            pieza.setColumnaPosible(columna);
                        }
                        if((fila+2) <= 7 && tablero.arrayDeCeldas[fila+2][columna].getPieza()==null){
                            pieza.setFilaPosible(fila+2);
                            pieza.setColumnaPosible(columna);
                        }
                        
                        //Para posiciones iniciales que no pueden aumentar o disminuir una columna
                        if(pieza.getPosEnColumnasTablero()==0){
                            if((fila+1) <= 7  && (columna+1) <= 7){
                                if(tablero.arrayDeCeldas[fila+1][columna+1].getPieza()!=null && 
                                    !Objects.equals(tablero.arrayDeCeldas[fila+1][columna+1].getPieza().getBandoPieza(),pieza.getBandoPieza())){
                                    pieza.setFilaPosible(fila+1);
                                    pieza.setColumnaPosible(columna+1);
                                }
                            }
                            
                            if(pieza.getBandoPieza()==1){
                                //Además de tener como posibles ocupaciones las celdas añadidas anteriormente
                                //Tendrá las columnas de los lados si en la misma hay situada una ficha enemiga
                                if((fila-1) >= 0  && (columna+1) <= 7 && tablero.arrayDeCeldas[fila-1][columna+1].getPieza()!=null && 
                                        !Objects.equals(tablero.arrayDeCeldas[fila-1][columna+1].getPieza().getBandoPieza(),pieza.getBandoPieza())){
                                    pieza.setFilaPosible(fila-1);
                                    pieza.setColumnaPosible(columna+1);
                                }else if(!Objects.equals(pieza.getCeldaOrigen().getPosEnColumnasTablero(), 
                                        pieza.getPosEnColumnasTablero())){
                                    if((fila-1) >= 0  && (columna+1) <= 7){
                                        if(tablero.arrayDeCeldas[fila-1][columna+1].getPieza()!=null
                                            && !Objects.equals(tablero.arrayDeCeldas[fila-1][columna+1].getPieza().getBandoPieza(),pieza.getBandoPieza())){
                                            pieza.setFilaPosible(fila-1);
                                            pieza.setColumnaPosible(columna+1);
                                        }
                                    }   
                                }  
                            }else if(pieza.getBandoPieza()==2){
                                //Además de tener como posibles ocupaciones las celdas añadidas anteriormente
                                //Tendrá las columnas de los lados si en la misma hay situada una ficha enemiga
                                if((fila+1) <= 7  && (columna+1) <= 7 && tablero.arrayDeCeldas[fila+1][columna+1].getPieza()!=null && 
                                        !Objects.equals(tablero.arrayDeCeldas[fila+1][columna+1].getPieza().getBandoPieza(),pieza.getBandoPieza())){
                                    pieza.setFilaPosible(fila+1);
                                    pieza.setColumnaPosible(columna+1);
                                }else if(!Objects.equals(pieza.getCeldaOrigen().getPosEnColumnasTablero(), 
                                        pieza.getPosEnColumnasTablero())){
                                    if((fila+1) <= 7  && (columna+1) <= 7){
                                        if(tablero.arrayDeCeldas[fila+1][columna+1].getPieza()!=null
                                            && !Objects.equals(tablero.arrayDeCeldas[fila+1][columna+1].getPieza().getBandoPieza(),pieza.getBandoPieza())){
                                            pieza.setFilaPosible(fila+1);
                                            pieza.setColumnaPosible(columna+1);
                                        }
                                    }
                                } 
                            }
                               
                        }else if (pieza.getPosEnColumnasTablero()==7){
                            if(!Objects.equals(pieza.getCeldaOrigen().getPosEnColumnasTablero(), 
                                    pieza.getPosEnColumnasTablero())){
                                if((fila+1) <= 7  && (columna-1) >= 0){
                                    if(tablero.arrayDeCeldas[fila+1][columna-1].getPieza()!=null
                                        && !Objects.equals(tablero.arrayDeCeldas[fila+1][columna-1].getPieza().getBandoPieza(),pieza.getBandoPieza())){
                                        pieza.setFilaPosible(fila+1);
                                        pieza.setColumnaPosible(columna-1);
                                    }
                                }
                            }
                            
                            if(pieza.getBandoPieza()==1){
                                
                                //Además de tener como posibles ocupaciones las celdas añadidas anteriormente
                                //Tendrá las columnas de los lados si en la misma hay situada una ficha enemiga
                                if((fila-1) >= 0  && (columna-1) >= 0 && tablero.arrayDeCeldas[fila-1][columna-1].getPieza()!=null && 
                                        !Objects.equals(tablero.arrayDeCeldas[fila-1][columna-1].getPieza().getBandoPieza(),pieza.getBandoPieza())){
                                    pieza.setFilaPosible(fila-1);
                                    pieza.setColumnaPosible(columna-1);
                                }else if(!Objects.equals(pieza.getCeldaOrigen().getPosEnColumnasTablero(), 
                                        pieza.getPosEnColumnasTablero())){
                                    
                                    if((fila-1) >= 0  && (columna-1) >= 0){
                                        if(tablero.arrayDeCeldas[fila-1][columna-1].getPieza()!=null
                                            && !Objects.equals(tablero.arrayDeCeldas[fila-1][columna-1].getPieza().getBandoPieza(),pieza.getBandoPieza())){
                                            pieza.setFilaPosible(fila-1);
                                            pieza.setColumnaPosible(columna-1);
                                        }
                                    }
                                }  
                                
                            }else if(pieza.getBandoPieza()==2){
                                //Además de tener como posibles ocupaciones las celdas añadidas anteriormente
                                //Tendrá las columnas de los lados si en la misma hay situada una ficha enemiga
                                if((fila+1) <= 7  && (columna-1) >= 0 && tablero.arrayDeCeldas[fila+1][columna-1].getPieza()!=null && 
                                        !Objects.equals(tablero.arrayDeCeldas[fila+1][columna-1].getPieza().getBandoPieza(),pieza.getBandoPieza())){
                                    pieza.setFilaPosible(fila+1);
                                    pieza.setColumnaPosible(columna-1);
                                }else if(!Objects.equals(pieza.getCeldaOrigen().getPosEnColumnasTablero(), 
                                        pieza.getPosEnColumnasTablero())){
                                    if((fila+1) <= 7  && (columna-1) >= 0){
                                        if(tablero.arrayDeCeldas[fila+1][columna-1].getPieza()!=null
                                            && !Objects.equals(tablero.arrayDeCeldas[fila+1][columna-1].getPieza().getBandoPieza(),pieza.getBandoPieza())){
                                            pieza.setFilaPosible(fila+1);
                                            pieza.setColumnaPosible(columna-1);
                                        }
                                    }
                                } 
                            }
                        }else{
                            //Además de tener como posibles ocupaciones las celdas añadidas anteriormente
                            //Tendrá las columnas de los lados si en la misma hay situada una ficha enemiga
                            if((fila+1) <= 7  && (columna+1) <= 7 && tablero.arrayDeCeldas[fila+1][columna+1].getPieza()!=null && 
                                    !Objects.equals(tablero.arrayDeCeldas[fila+1][columna+1].getPieza().getBandoPieza(),pieza.getBandoPieza())){
                                pieza.setFilaPosible(fila+1);
                                pieza.setColumnaPosible(columna+1);
                            }else if(!Objects.equals(pieza.getCeldaOrigen().getPosEnColumnasTablero(), 
                                    pieza.getPosEnColumnasTablero())){
                                if((fila+1) <= 7  && (columna-1) >= 0){
                                    if(tablero.arrayDeCeldas[fila+1][columna-1].getPieza()!=null
                                        && !Objects.equals(tablero.arrayDeCeldas[fila+1][columna-1].getPieza().getBandoPieza(),pieza.getBandoPieza())){
                                        pieza.setFilaPosible(fila+1);
                                        pieza.setColumnaPosible(columna-1);
                                    }
                                }   
                            }  
                        }
                        
                        
                          
                    }else if(pieza.getCeldaOrigen().getPosEnFilasTablero()==6){
                        if((fila-1) >= 0){
                           //Tiene como posiciones posibles las dos siguientes filas en la misma columna
                            if(tablero.arrayDeCeldas[fila-1][columna].getPieza()==null){
                                pieza.setFilaPosible(fila-1);
                                pieza.setColumnaPosible(columna);
                            } 
                        }
                        
                        if((fila-2) >= 0){
                            if(tablero.arrayDeCeldas[fila-2][columna].getPieza()==null){
                                pieza.setFilaPosible(fila-2);
                                pieza.setColumnaPosible(columna);
                            }
                        }
                        
                        
                        //Para posiciones iniciales que no pueden aumentar o disminuir una columna
                        if(pieza.getPosEnColumnasTablero()==0){
                            if((fila-1) >= 0  && (columna+1) <= 7){
                               if(tablero.arrayDeCeldas[fila-1][columna+1].getPieza()!=null && 
                                    !Objects.equals(tablero.arrayDeCeldas[fila-1][columna+1].getPieza().getBandoPieza(),pieza.getBandoPieza())){
                                    pieza.setFilaPosible(fila-1);
                                    pieza.setColumnaPosible(columna+1);
                               } 
                            }
                            
                            
                            if(pieza.getBandoPieza()==1){
                                //Además de tener como posibles ocupaciones las celdas añadidas anteriormente
                                //Tendrá las columnas de los lados si en la misma hay situada una ficha enemiga
                                if((fila-1) >= 0  && (columna+1) <= 7 && tablero.arrayDeCeldas[fila-1][columna+1].getPieza()!=null && 
                                        !Objects.equals(tablero.arrayDeCeldas[fila-1][columna+1].getPieza().getBandoPieza(),pieza.getBandoPieza())){
                                    pieza.setFilaPosible(fila-1);
                                    pieza.setColumnaPosible(columna+1);
                                }else if(!Objects.equals(pieza.getCeldaOrigen().getPosEnColumnasTablero(), 
                                        pieza.getPosEnColumnasTablero())){
                                    if((fila-1) >= 0  && (columna+1) <= 7){
                                        if(tablero.arrayDeCeldas[fila-1][columna+1].getPieza()!=null
                                            && !Objects.equals(tablero.arrayDeCeldas[fila-1][columna+1].getPieza().getBandoPieza(),pieza.getBandoPieza())){
                                            pieza.setFilaPosible(fila-1);
                                            pieza.setColumnaPosible(columna+1);
                                        }    
                                    }
                                    
                                }  
                            }else if(pieza.getBandoPieza()==2){
                                //Además de tener como posibles ocupaciones las celdas añadidas anteriormente
                                //Tendrá las columnas de los lados si en la misma hay situada una ficha enemiga
                                if((fila+1) <= 7  && (columna+1) <= 7 && tablero.arrayDeCeldas[fila+1][columna+1].getPieza()!=null && 
                                        !Objects.equals(tablero.arrayDeCeldas[fila+1][columna+1].getPieza().getBandoPieza(),pieza.getBandoPieza())){
                                    pieza.setFilaPosible(fila+1);
                                    pieza.setColumnaPosible(columna+1);
                                }else if(!Objects.equals(pieza.getCeldaOrigen().getPosEnColumnasTablero(), 
                                        pieza.getPosEnColumnasTablero())){
                                    if((fila+1) <= 7  && (columna+1) <= 7){
                                        if(tablero.arrayDeCeldas[fila+1][columna+1].getPieza()!=null
                                            && !Objects.equals(tablero.arrayDeCeldas[fila+1][columna+1].getPieza().getBandoPieza(),pieza.getBandoPieza())){
                                            pieza.setFilaPosible(fila+1);
                                            pieza.setColumnaPosible(columna+1);
                                        }
                                    }
                                    
                                } 
                            }
                               
                        }else if (pieza.getPosEnColumnasTablero()==7){
                            if(!Objects.equals(pieza.getCeldaOrigen().getPosEnColumnasTablero(), 
                                    pieza.getPosEnColumnasTablero())){
                                if((fila+1) <= 7  && (columna-1) >= 0 ){
                                    if(tablero.arrayDeCeldas[fila+1][columna-1].getPieza()!=null
                                        && !Objects.equals(tablero.arrayDeCeldas[fila+1][columna-1].getPieza().getBandoPieza(),pieza.getBandoPieza())){
                                        pieza.setFilaPosible(fila+1);
                                        pieza.setColumnaPosible(columna-1);
                                    }
                                }
                            }
                            
                            if(pieza.getBandoPieza()==1){
                                
                                //Además de tener como posibles ocupaciones las celdas añadidas anteriormente
                                //Tendrá las columnas de los lados si en la misma hay situada una ficha enemiga
                                if((fila-1) >= 0  && (columna-1) >= 0 && tablero.arrayDeCeldas[fila-1][columna-1].getPieza()!=null && 
                                        !Objects.equals(tablero.arrayDeCeldas[fila-1][columna-1].getPieza().getBandoPieza(),pieza.getBandoPieza())){
                                    pieza.setFilaPosible(fila-1);
                                    pieza.setColumnaPosible(columna-1);
                                }else if(!Objects.equals(pieza.getCeldaOrigen().getPosEnColumnasTablero(), 
                                        pieza.getPosEnColumnasTablero())){

                                    if((fila-1) >= 0  && (columna-1) >= 0 ){
                                        if(tablero.arrayDeCeldas[fila-1][columna-1].getPieza()!=null
                                            && !Objects.equals(tablero.arrayDeCeldas[fila-1][columna-1].getPieza().getBandoPieza(),pieza.getBandoPieza())){
                                            pieza.setFilaPosible(fila-1);
                                            pieza.setColumnaPosible(columna-1);
                                        }
                                    }
                                }  
                                
                                
                            }else if(pieza.getBandoPieza()==2){
                                
                                //Además de tener como posibles ocupaciones las celdas añadidas anteriormente
                                //Tendrá las columnas de los lados si en la misma hay situada una ficha enemiga
                                if((fila+1) <= 7  && (columna-1) >= 0 && tablero.arrayDeCeldas[fila+1][columna-1].getPieza()!=null && 
                                        !Objects.equals(tablero.arrayDeCeldas[fila+1][columna-1].getPieza().getBandoPieza(),pieza.getBandoPieza())){
                                    pieza.setFilaPosible(fila+1);
                                    pieza.setColumnaPosible(columna-1);
                                }else if(!Objects.equals(pieza.getCeldaOrigen().getPosEnColumnasTablero(), 
                                        pieza.getPosEnColumnasTablero())){

                                    if((fila+1) <= 7  && (columna-1) >= 0 ){
                                        if(tablero.arrayDeCeldas[fila+1][columna-1].getPieza()!=null
                                            && !Objects.equals(tablero.arrayDeCeldas[fila+1][columna-1].getPieza().getBandoPieza(),pieza.getBandoPieza())){
                                            pieza.setFilaPosible(fila+1);
                                            pieza.setColumnaPosible(columna-1);
                                        }
                                    }
                                } 
                                
                            }
                        }else{
                            
                            //Además de tener como posibles ocupaciones las celdas añadidas anteriormente
                            //Tendrá las columnas de los lados si en la misma hay situada una ficha enemiga
                            if((fila-1) >= 0  && (columna+1) <= 7 && tablero.arrayDeCeldas[fila-1][columna+1].getPieza()!=null && 
                                    !Objects.equals(tablero.arrayDeCeldas[fila-1][columna+1].getPieza().getBandoPieza(),pieza.getBandoPieza())){
                                pieza.setFilaPosible(fila-1);
                                pieza.setColumnaPosible(columna+1);
                            }else if(!Objects.equals(pieza.getCeldaOrigen().getPosEnColumnasTablero(), 
                                    pieza.getPosEnColumnasTablero())){  

                                if((fila-1) >= 0  && (columna-1) >= 0 ){
                                    if(tablero.arrayDeCeldas[fila-1][columna-1].getPieza()!=null
                                        && !Objects.equals(tablero.arrayDeCeldas[fila-1][columna-1].getPieza().getBandoPieza(),pieza.getBandoPieza())){
                                        pieza.setFilaPosible(fila-1);
                                        pieza.setColumnaPosible(columna-1);
                                    }
                                }
                            }
                            
                        }
                        
                        
                    }
                    
                }else{
                    //Si ya ha se ha movido la pieza
                    if(pieza.getCeldaOrigen().getPosEnFilasTablero()==1){
                        if(pieza.getPosEnColumnasTablero()!= 7 ){
                            
                            if((fila+1) <= 7 && (columna+1) <= 7){
                                if(tablero.arrayDeCeldas[fila+1][columna+1].getPieza()!=null && 
                                    !Objects.equals(tablero.arrayDeCeldas[fila+1][columna+1].getPieza().getBandoPieza(),pieza.getBandoPieza())){
                                    pieza.setFilaPosible(fila+1);
                                    pieza.setColumnaPosible(columna+1);
                                }
                            }
                            
                            
                            if(pieza.getPosEnColumnasTablero()!= 0){
                                
                               if((fila+1) <= 7  && (columna-1) >= 0 ){
                                    if(tablero.arrayDeCeldas[fila+1][columna-1].getPieza()!=null && 
                                    !Objects.equals(tablero.arrayDeCeldas[fila+1][columna-1].getPieza().getBandoPieza(),pieza.getBandoPieza())){
                                        pieza.setFilaPosible(fila+1);
                                        pieza.setColumnaPosible(columna-1);
                                    }
                               }

                            }
                            
                            if(tablero.arrayDeCeldas[fila+1][columna].getPieza()==null){
                                pieza.setFilaPosible(fila+1);
                                pieza.setColumnaPosible(columna);
                            }
                            
                        }else if(pieza.getPosEnColumnasTablero() != 0){
                            if((fila+1) <= 7  && (columna-1) >= 0 ){
                                if(tablero.arrayDeCeldas[fila+1][columna-1].getPieza()!=null
                                    && !Objects.equals(tablero.arrayDeCeldas[fila+1][columna-1].getPieza().getBandoPieza(),pieza.getBandoPieza())){
                                    pieza.setFilaPosible(fila+1);
                                    pieza.setColumnaPosible(columna-1);

                                }
                            }
                            
                            
                            if(pieza.getPosEnColumnasTablero()!=7){
                                if((fila+1) <= 7  && (columna+1) <= 7 ){
                                    if(tablero.arrayDeCeldas[fila+1][columna+1].getPieza()!=null && 
                                    !Objects.equals(tablero.arrayDeCeldas[fila+1][columna+1].getPieza().getBandoPieza(),pieza.getBandoPieza())){
                                        pieza.setFilaPosible(fila+1);
                                        pieza.setColumnaPosible(columna+1);
                                    }
                                }
                                
                            }
                            
                            if((fila+1) <= 7){
                                if(tablero.arrayDeCeldas[fila+1][columna].getPieza()==null){
                                    pieza.setFilaPosible(fila+1);
                                    pieza.setColumnaPosible(columna);
                                }
                            }
                            
                        }
                        
                    }
                    if(pieza.getCeldaOrigen().getPosEnFilasTablero()==6){
                        if(pieza.getPosEnColumnasTablero()!= 7 ){
                            
                            if((fila-1) >= 0  && (columna+1) <= 7 ){
                                if(tablero.arrayDeCeldas[fila-1][columna+1].getPieza()!=null && 
                                    !Objects.equals(tablero.arrayDeCeldas[fila-1][columna+1].getPieza().getBandoPieza(),pieza.getBandoPieza())){
                                    pieza.setFilaPosible(fila-1);
                                    pieza.setColumnaPosible(columna+1);    



                                }
                            }
                            
                            if(pieza.getPosEnColumnasTablero()!= 0){
                                
                                if((fila-1) >= 0  && (columna-1) >= 0 ){
                                    if(tablero.arrayDeCeldas[fila-1][columna-1].getPieza()!=null && 
                                    !Objects.equals(tablero.arrayDeCeldas[fila-1][columna-1].getPieza().getBandoPieza(),pieza.getBandoPieza())){
                                        pieza.setFilaPosible(fila-1);
                                        pieza.setColumnaPosible(columna-1);
                                    }
                                }

                            }
                            
                            if((fila-1) >= 0){
                                if(tablero.arrayDeCeldas[fila-1][columna].getPieza()==null){
                                    pieza.setFilaPosible(fila-1);
                                    pieza.setColumnaPosible(columna);
                                }
                            }
                        }else if(pieza.getPosEnColumnasTablero() != 0){
                            
                            if((fila-1) >= 0  && (columna-1) >= 0 ){
                                if(tablero.arrayDeCeldas[fila-1][columna-1].getPieza()!=null
                                    && !Objects.equals(tablero.arrayDeCeldas[fila-1][columna-1].getPieza().getBandoPieza(),pieza.getBandoPieza())){
                                    pieza.setFilaPosible(fila-1);
                                    pieza.setColumnaPosible(columna-1);



                                }
                            }
                            
                            if(pieza.getPosEnColumnasTablero()!=7){
                                
                                if((fila-1) >= 0  && (columna+1) <= 7 ){
                                    if(tablero.arrayDeCeldas[fila-1][columna+1].getPieza()!=null && 
                                    !Objects.equals(tablero.arrayDeCeldas[fila-1][columna+1].getPieza().getBandoPieza(),pieza.getBandoPieza())){
                                        pieza.setFilaPosible(fila-1);
                                        pieza.setColumnaPosible(columna+1);
                                    }
                                }
                            }
                            
                            if((fila-1) >= 0 ){
                                if(tablero.arrayDeCeldas[fila-1][columna].getPieza()==null){
                                    pieza.setFilaPosible(fila-1);
                                    pieza.setColumnaPosible(columna);
                                }
                            }
                        }
                    
                    }   
                    
                }
                
                
                break;
            case "Torre":
                //Comprobamos los posibles movimientos en filas y columnas desde la posición actual de la ficha
            //MVTO. EN FILA - aumentamos o disminuimos columnas
                for (int i = columna; i < 8; i++) {
                    if(tablero.arrayDeCeldas[fila][i].getPieza()!=pieza){
                        //Si encontramos una celda vacía y no hemos encontrado
                        //anteriormente una celda ocupada
                        if(tablero.arrayDeCeldas[fila][i].getPieza()==null 
                                && piezaEncontrada == false){
                            
                            pieza.setFilaPosible(fila);
                            pieza.setColumnaPosible(i);
                        }else if(tablero.arrayDeCeldas[fila][i].getPieza()!=null){
                            //Si el bando de la pieza que estamos analizando es distinto de la pieza que está en la celda que estamos recorriendo
                            if(!Objects.equals(tablero.arrayDeCeldas[fila][i].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                                //Si no hemos encontrado ninguna pieza anteriormente y el bando de la pieza que 
                                //hemos encontrado ahora es distinto al de la pieza que estamos analizando
                                //guardamos la pisición de la pieza enemiga entre las posibles posiciones que puede
                                //tener la pieza en cuestión
                                if(piezaEncontrada==false){
                                    pieza.setFilaPosible(fila);
                                    pieza.setColumnaPosible(i);
                                    piezaEncontrada = true;
                                    //Salimos del bucle
                                    i = 7;
                                    
                                }
                            }else{
                                piezaEncontrada = true;
                                //Salimos del bucle
                                i = 7;
                            }
                        }
                    }
                }
                piezaEncontrada = false;
                for (int i = columna; i >= 0; i--) {
                    if(tablero.arrayDeCeldas[fila][i].getPieza()!=pieza){
                        //Si encontramos una celda vacía y no hemos encontrado
                        //anteriormente una celda ocupada
                        if(tablero.arrayDeCeldas[fila][i].getPieza()==null 
                                && piezaEncontrada == false){
                            
                            pieza.setFilaPosible(fila);
                            pieza.setColumnaPosible(i);
                        }else if(tablero.arrayDeCeldas[fila][i].getPieza()!=null){
                            //Si el bando de la pieza que estamos analizando es distinto de la pieza que está en la celda que estamos recorriendo
                            if(!Objects.equals(tablero.arrayDeCeldas[fila][i].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                                //Si no hemos encontrado ninguna pieza anteriormente y el bando de la pieza que 
                                //hemos encontrado ahora es distinto al de la pieza que estamos analizando
                                //guardamos la pisición de la pieza enemiga entre las posibles posiciones que puede
                                //tener la pieza en cuestión
                                if(piezaEncontrada==false){
                                    pieza.setFilaPosible(fila);
                                    pieza.setColumnaPosible(i);
                                    piezaEncontrada = true;
                                    //Salimos del bucle
                                    i = 0;
                                    
                                }
                            }else{
                                piezaEncontrada = true;
                                //Salimos del bucle
                                i = 0;
                            }
                        }
                    }
                }
                piezaEncontrada = false;
            //MVTO. EN COLUMNA - aumentamos o disminuimos filas
                for (int i = fila; i < 8; i++) {
                    if(tablero.arrayDeCeldas[i][columna].getPieza()!=pieza){
                        //Si encontramos una celda vacía y no hemos encontrado
                        //anteriormente una celda ocupada
                        if(tablero.arrayDeCeldas[i][columna].getPieza()==null 
                                && piezaEncontrada == false){
                            
                            pieza.setFilaPosible(i);
                            pieza.setColumnaPosible(columna);
                            
                        }else if(tablero.arrayDeCeldas[i][columna].getPieza()!=null){
                            //Si el bando de la pieza que estamos analizando es distinto de la pieza que está en la celda que estamos recorriendo
                            if(!Objects.equals(tablero.arrayDeCeldas[i][columna].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                                //Si no hemos encontrado ninguna pieza anteriormente y el bando de la pieza que 
                                //hemos encontrado ahora es distinto al de la pieza que estamos analizando
                                //guardamos la pisición de la pieza enemiga entre las posibles posiciones que puede
                                //tener la pieza en cuestión
                                if(piezaEncontrada==false){
                                    
                                    pieza.setFilaPosible(i);
                                    pieza.setColumnaPosible(columna);
                                    piezaEncontrada = true;
                                    //Salimos del bucle
                                    i = 7;
                                    
                                }
                            }else{
                                piezaEncontrada = true;
                                //Salimos del bucle
                                i = 7;
                            }
                        }
                    }
                }
                piezaEncontrada = false;
                for (int i = fila; i >= 0; i--) {
                    if(tablero.arrayDeCeldas[i][columna].getPieza()!=pieza){
                        //Si encontramos una celda vacía y no hemos encontrado
                        //anteriormente una celda ocupada
                        if(tablero.arrayDeCeldas[i][columna].getPieza()==null 
                                && piezaEncontrada == false){
                            
                            pieza.setFilaPosible(i);
                            pieza.setColumnaPosible(columna);
                            
                        }else if(tablero.arrayDeCeldas[i][columna].getPieza()!=null){
                            //Si el bando de la pieza que estamos analizando es distinto de la pieza que está en la celda que estamos recorriendo
                            if(!Objects.equals(tablero.arrayDeCeldas[i][columna].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                                //Si no hemos encontrado ninguna pieza anteriormente y el bando de la pieza que 
                                //hemos encontrado ahora es distinto al de la pieza que estamos analizando
                                //guardamos la pisición de la pieza enemiga entre las posibles posiciones que puede
                                //tener la pieza en cuestión
                                if(piezaEncontrada==false){
                                    
                                    pieza.setFilaPosible(i);
                                    pieza.setColumnaPosible(columna);
                                    piezaEncontrada = true;
                                    //Salimos del bucle
                                    break;
                                    
                                }
                            }else{
                                piezaEncontrada = true;
                                //Salimos del bucle
                                break;
                            }
                        }
                    }
                }
                break;
            case "Alfil":
            //MVTO. EN DIAGONAL - aumentamos o disminuimos filas y columnas
                
                x = fila;
                for (int j = columna; j < 8; j++) {
                    if(tablero.arrayDeCeldas[x][j].getPieza()!=pieza){
                        //Si encontramos una celda vacía y no hemos encontrado
                        //anteriormente una celda ocupada
                        if(tablero.arrayDeCeldas[x][j].getPieza()==null 
                                && piezaEncontrada == false){
                            pieza.setFilaPosible(x);
                            pieza.setColumnaPosible(j);
                        }else if(tablero.arrayDeCeldas[x][j].getPieza()!=null){
                            //Si el bando de la pieza que estamos analizando es distinto de la pieza que está en la celda que estamos recorriendo
                            if(!Objects.equals(tablero.arrayDeCeldas[x][j].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                                //Si no hemos encontrado ninguna pieza anteriormente y el bando de la pieza que 
                                //hemos encontrado ahora es distinto al de la pieza que estamos analizando
                                //guardamos la pisición de la pieza enemiga entre las posibles posiciones que puede
                                //tener la pieza en cuestión
                                if(piezaEncontrada==false){
                                    pieza.setFilaPosible(x);
                                    pieza.setColumnaPosible(j);
                                    piezaEncontrada = true;
                                    //Salimos del bucle 
                                    j = 7;

                                }
                            }else{
                                piezaEncontrada = true;
                                //Salimos del bucle
                                j = 7;
                            }
                        }


                    }
                    if(x < 7){
                        x++;
                    }else{
                        j=7;
                    }
                    
                }
                
                x= fila;
                
                for (int j = columna; j >= 0; j--) {
                    if(tablero.arrayDeCeldas[fila][j].getPieza()!=pieza){
                        //Si encontramos una celda vacía y no hemos encontrado
                        //anteriormente una celda ocupada
                        if(tablero.arrayDeCeldas[x][j].getPieza()==null 
                                && piezaEncontrada == false){
                            pieza.setFilaPosible(x);
                            pieza.setColumnaPosible(j);
                        }else if(tablero.arrayDeCeldas[x][j].getPieza()!=null){
                            //Si el bando de la pieza que estamos analizando es distinto de la pieza que está en la celda que estamos recorriendo
                            if(!Objects.equals(tablero.arrayDeCeldas[x][j].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                                //Si no hemos encontrado ninguna pieza anteriormente y el bando de la pieza que 
                                //hemos encontrado ahora es distinto al de la pieza que estamos analizando
                                //guardamos la pisición de la pieza enemiga entre las posibles posiciones que puede
                                //tener la pieza en cuestión
                                if(piezaEncontrada==false){
                                    pieza.setFilaPosible(x);
                                    pieza.setColumnaPosible(j);
                                    piezaEncontrada = true;
                                    //Salimos del bucle
                                    j = 0;

                                }
                            }else{
                                piezaEncontrada = true;
                                //Salimos del bucle
                                j = 0;
                            }
                        }


                    }
                    if(x < 7){
                        x++;
                    }else{
                        j=0;
                    }
                }
                
                x = fila;
                
                for (int j = columna; j < 8; j++) {
                    if(tablero.arrayDeCeldas[x][j].getPieza()!=pieza){
                        //Si encontramos una celda vacía y no hemos encontrado
                        //anteriormente una celda ocupada
                        if(tablero.arrayDeCeldas[x][j].getPieza()==null 
                                && piezaEncontrada == false){
                            pieza.setFilaPosible(x);
                            pieza.setColumnaPosible(j);
                        }else if(tablero.arrayDeCeldas[x][j].getPieza()!=null){
                            //Si el bando de la pieza que estamos analizando es distinto de la pieza que está en la celda que estamos recorriendo
                            if(!Objects.equals(tablero.arrayDeCeldas[x][j].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                                //Si no hemos encontrado ninguna pieza anteriormente y el bando de la pieza que 
                                //hemos encontrado ahora es distinto al de la pieza que estamos analizando
                                //guardamos la pisición de la pieza enemiga entre las posibles posiciones que puede
                                //tener la pieza en cuestión
                                if(piezaEncontrada==false){
                                    pieza.setFilaPosible(x);
                                    pieza.setColumnaPosible(j);
                                    piezaEncontrada = true;
                                    //Salimos del bucle
                                    j = 7;

                                }
                            }else{
                                piezaEncontrada = true;
                                //Salimos del bucle
                                j = 7;
                            }
                        }


                    }
                    if(x > 0){
                        x--;
                    }else{
                        j=7;
                    }
                }
                
                x = fila;
                
                
                for (int j = columna; j >= 0; j--) {
                    if(tablero.arrayDeCeldas[x][j].getPieza()!=pieza){
                        //Si encontramos una celda vacía y no hemos encontrado
                        //anteriormente una celda ocupada
                        if(tablero.arrayDeCeldas[x][j].getPieza()==null 
                                && piezaEncontrada == false){
                            pieza.setFilaPosible(x);
                            pieza.setColumnaPosible(j);
                        }else if(tablero.arrayDeCeldas[x][j].getPieza()!=null){
                            //Si el bando de la pieza que estamos analizando es distinto de la pieza que está en la celda que estamos recorriendo
                            if(!Objects.equals(tablero.arrayDeCeldas[x][j].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                                //Si no hemos encontrado ninguna pieza anteriormente y el bando de la pieza que 
                                //hemos encontrado ahora es distinto al de la pieza que estamos analizando
                                //guardamos la pisición de la pieza enemiga entre las posibles posiciones que puede
                                //tener la pieza en cuestión
                                if(piezaEncontrada==false){
                                    pieza.setFilaPosible(x);
                                    pieza.setColumnaPosible(j);
                                    piezaEncontrada = true;
                                    //Salimos del bucle
                                    j = 0;

                                }
                            }else{
                                piezaEncontrada = true;
                                //Salimos del bucle
                                j = 0;
                            }
                        }


                    }
                    if(x > 0){
                        x--;
                    }else{
                        j=0;
                    }
                }
                
                break;
                
            case "Reina":
                //Comprobamos los posibles movimientos en filas y columnas desde la posición actual de la ficha
            //MVTO. EN FILA - aumentamos o disminuimos columnas
                for (int i = columna; i < 8; i++) {
                    if(tablero.arrayDeCeldas[fila][i].getPieza()!=pieza){
                        //Si encontramos una celda vacía y no hemos encontrado
                        //anteriormente una celda ocupada
                        if(tablero.arrayDeCeldas[fila][i].getPieza()==null 
                                && piezaEncontrada == false){
                            
                            pieza.setFilaPosible(fila);
                            pieza.setColumnaPosible(i);
                        }else if(tablero.arrayDeCeldas[fila][i].getPieza()!=null){
                            //Si el bando de la pieza que estamos analizando es distinto de la pieza que está en la celda que estamos recorriendo
                            if(!Objects.equals(tablero.arrayDeCeldas[fila][i].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                                //Si no hemos encontrado ninguna pieza anteriormente y el bando de la pieza que 
                                //hemos encontrado ahora es distinto al de la pieza que estamos analizando
                                //guardamos la pisición de la pieza enemiga entre las posibles posiciones que puede
                                //tener la pieza en cuestión
                                if(piezaEncontrada==false){
                                    pieza.setFilaPosible(fila);
                                    pieza.setColumnaPosible(i);
                                    piezaEncontrada = true;
                                    //Salimos del bucle
                                    i = 7;
                                    
                                }
                            }else{
                                piezaEncontrada = true;
                                //Salimos del bucle
                                i = 7;
                            }
                        }
                    }
                }
                piezaEncontrada = false;
                for (int i = columna; i >= 0; i--) {
                    if(tablero.arrayDeCeldas[fila][i].getPieza()!=pieza){
                        //Si encontramos una celda vacía y no hemos encontrado
                        //anteriormente una celda ocupada
                        if(tablero.arrayDeCeldas[fila][i].getPieza()==null 
                                && piezaEncontrada == false){
                            
                            pieza.setFilaPosible(fila);
                            pieza.setColumnaPosible(i);
                        }else if(tablero.arrayDeCeldas[fila][i].getPieza()!=null){
                            //Si el bando de la pieza que estamos analizando es distinto de la pieza que está en la celda que estamos recorriendo
                            if(!Objects.equals(tablero.arrayDeCeldas[fila][i].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                                //Si no hemos encontrado ninguna pieza anteriormente y el bando de la pieza que 
                                //hemos encontrado ahora es distinto al de la pieza que estamos analizando
                                //guardamos la pisición de la pieza enemiga entre las posibles posiciones que puede
                                //tener la pieza en cuestión
                                if(piezaEncontrada==false){
                                    pieza.setFilaPosible(fila);
                                    pieza.setColumnaPosible(i);
                                    piezaEncontrada = true;
                                    //Salimos del bucle
                                    i = 0;
                                    
                                }
                            }else{
                                piezaEncontrada = true;
                                //Salimos del bucle
                                i = 0;
                            }
                        }
                    }
                }
                piezaEncontrada = false;
            //MVTO. EN COLUMNA - aumentamos o disminuimos filas
                for (int i = fila; i < 8; i++) {
                    if(tablero.arrayDeCeldas[i][columna].getPieza()!=pieza){
                        //Si encontramos una celda vacía y no hemos encontrado
                        //anteriormente una celda ocupada
                        if(tablero.arrayDeCeldas[i][columna].getPieza()==null 
                                && piezaEncontrada == false){
                            
                            pieza.setFilaPosible(i);
                            pieza.setColumnaPosible(columna);
                            
                        }else if(tablero.arrayDeCeldas[i][columna].getPieza()!=null){
                            //Si el bando de la pieza que estamos analizando es distinto de la pieza que está en la celda que estamos recorriendo
                            if(!Objects.equals(tablero.arrayDeCeldas[i][columna].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                                //Si no hemos encontrado ninguna pieza anteriormente y el bando de la pieza que 
                                //hemos encontrado ahora es distinto al de la pieza que estamos analizando
                                //guardamos la pisición de la pieza enemiga entre las posibles posiciones que puede
                                //tener la pieza en cuestión
                                if(piezaEncontrada==false){
                                    
                                    pieza.setFilaPosible(i);
                                    pieza.setColumnaPosible(columna);
                                    piezaEncontrada = true;
                                    //Salimos del bucle
                                    i = 7;
                                    
                                }
                            }else{
                                piezaEncontrada = true;
                                //Salimos del bucle
                                i = 7;
                            }
                        }
                    }
                }
                piezaEncontrada = false;
                for (int i = fila; i >= 0; i--) {
                    if(tablero.arrayDeCeldas[i][columna].getPieza()!=pieza){
                        //Si encontramos una celda vacía y no hemos encontrado
                        //anteriormente una celda ocupada
                        if(tablero.arrayDeCeldas[i][columna].getPieza()==null 
                                && piezaEncontrada == false){
                            
                            pieza.setFilaPosible(i);
                            pieza.setColumnaPosible(columna);
                            
                        }else if(tablero.arrayDeCeldas[i][columna].getPieza()!=null){
                            //Si el bando de la pieza que estamos analizando es distinto de la pieza que está en la celda que estamos recorriendo
                            if(!Objects.equals(tablero.arrayDeCeldas[i][columna].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                                //Si no hemos encontrado ninguna pieza anteriormente y el bando de la pieza que 
                                //hemos encontrado ahora es distinto al de la pieza que estamos analizando
                                //guardamos la pisición de la pieza enemiga entre las posibles posiciones que puede
                                //tener la pieza en cuestión
                                if(piezaEncontrada==false){
                                    
                                    pieza.setFilaPosible(i);
                                    pieza.setColumnaPosible(columna);
                                    piezaEncontrada = true;
                                    //Salimos del bucle
                                    i=0;
                                    
                                }
                            }else{
                                piezaEncontrada = true;
                                //Salimos del bucle
                                i=0;
                            }
                        }
                    }
                }
            //MVTO. EN DIAGONAL - aumentamos o disminuimos filas y columnas
                x = fila;
                for (int j = columna; j < 8; j++) {
                    if(tablero.arrayDeCeldas[x][j].getPieza()!=pieza){
                        //Si encontramos una celda vacía y no hemos encontrado
                        //anteriormente una celda ocupada
                        if(tablero.arrayDeCeldas[x][j].getPieza()==null 
                                && piezaEncontrada == false){
                            pieza.setFilaPosible(x);
                            pieza.setColumnaPosible(j);
                        }else if(tablero.arrayDeCeldas[x][j].getPieza()!=null){
                            //Si el bando de la pieza que estamos analizando es distinto de la pieza que está en la celda que estamos recorriendo
                            if(!Objects.equals(tablero.arrayDeCeldas[x][j].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                                //Si no hemos encontrado ninguna pieza anteriormente y el bando de la pieza que 
                                //hemos encontrado ahora es distinto al de la pieza que estamos analizando
                                //guardamos la pisición de la pieza enemiga entre las posibles posiciones que puede
                                //tener la pieza en cuestión
                                if(piezaEncontrada==false){
                                    pieza.setFilaPosible(x);
                                    pieza.setColumnaPosible(j);
                                    piezaEncontrada = true;
                                    //Salimos del bucle 
                                    j = 7;

                                }
                            }else{
                                piezaEncontrada = true;
                                //Salimos del bucle
                                j = 7;
                            }
                        }


                    }
                    if(x < 7){
                        x++;
                    }else{
                        j=7;
                    }
                    
                }
                piezaEncontrada = false;
                x= fila;
                
                for (int j = columna; j >= 0; j--) {
                    if(tablero.arrayDeCeldas[x][j].getPieza()!=pieza){
                        //Si encontramos una celda vacía y no hemos encontrado
                        //anteriormente una celda ocupada
                        if(tablero.arrayDeCeldas[x][j].getPieza()==null 
                                && piezaEncontrada == false){
                            pieza.setFilaPosible(x);
                            pieza.setColumnaPosible(j);
                        }else if(tablero.arrayDeCeldas[x][j].getPieza()!=null){
                            //Si el bando de la pieza que estamos analizando es distinto de la pieza que está en la celda que estamos recorriendo
                            if(!Objects.equals(tablero.arrayDeCeldas[x][j].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                                //Si no hemos encontrado ninguna pieza anteriormente y el bando de la pieza que 
                                //hemos encontrado ahora es distinto al de la pieza que estamos analizando
                                //guardamos la pisición de la pieza enemiga entre las posibles posiciones que puede
                                //tener la pieza en cuestión
                                if(piezaEncontrada==false){
                                    pieza.setFilaPosible(x);
                                    pieza.setColumnaPosible(j);
                                    piezaEncontrada = true;
                                    //Salimos del bucle
                                    j = 0;

                                }
                            }else{
                                piezaEncontrada = true;
                                //Salimos del bucle
                                j = 0;
                            }
                        }


                    }
                    if(x < 7){
                        x++;
                    }else{
                        j=0;
                    }
                }
                piezaEncontrada = false;
                x = fila;
                
                for (int j = columna; j < 8; j++) {
                    if(tablero.arrayDeCeldas[x][j].getPieza()!=pieza){
                        //Si encontramos una celda vacía y no hemos encontrado
                        //anteriormente una celda ocupada
                        if(tablero.arrayDeCeldas[x][j].getPieza()==null 
                                && piezaEncontrada == false){
                            pieza.setFilaPosible(x);
                            pieza.setColumnaPosible(j);
                        }else if(tablero.arrayDeCeldas[x][j].getPieza()!=null){
                            //Si el bando de la pieza que estamos analizando es distinto de la pieza que está en la celda que estamos recorriendo
                            if(!Objects.equals(tablero.arrayDeCeldas[x][j].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                                //Si no hemos encontrado ninguna pieza anteriormente y el bando de la pieza que 
                                //hemos encontrado ahora es distinto al de la pieza que estamos analizando
                                //guardamos la pisición de la pieza enemiga entre las posibles posiciones que puede
                                //tener la pieza en cuestión
                                if(piezaEncontrada==false){
                                    pieza.setFilaPosible(x);
                                    pieza.setColumnaPosible(j);
                                    piezaEncontrada = true;
                                    //Salimos del bucle
                                    j = 7;

                                }
                            }else{
                                piezaEncontrada = true;
                                //Salimos del bucle
                                j = 7;
                            }
                        }


                    }
                    if(x > 0){
                        x--;
                    }else{
                        j=7;
                    }
                }
                piezaEncontrada = false;
                x = fila;
                
                
                for (int j = columna; j >= 0; j--) {
                    if(tablero.arrayDeCeldas[x][j].getPieza()!=pieza){
                        //Si encontramos una celda vacía y no hemos encontrado
                        //anteriormente una celda ocupada
                        if(tablero.arrayDeCeldas[x][j].getPieza()==null 
                                && piezaEncontrada == false){
                            pieza.setFilaPosible(x);
                            pieza.setColumnaPosible(j);
                        }else if(tablero.arrayDeCeldas[x][j].getPieza()!=null){
                            //Si el bando de la pieza que estamos analizando es distinto de la pieza que está en la celda que estamos recorriendo
                            if(!Objects.equals(tablero.arrayDeCeldas[x][j].getPieza().getBandoPieza(), pieza.getBandoPieza())){
                                //Si no hemos encontrado ninguna pieza anteriormente y el bando de la pieza que 
                                //hemos encontrado ahora es distinto al de la pieza que estamos analizando
                                //guardamos la pisición de la pieza enemiga entre las posibles posiciones que puede
                                //tener la pieza en cuestión
                                if(piezaEncontrada==false){
                                    pieza.setFilaPosible(x);
                                    pieza.setColumnaPosible(j);
                                    piezaEncontrada = true;
                                    //Salimos del bucle
                                    j = 0;

                                }
                            }else{
                                piezaEncontrada = true;
                                //Salimos del bucle
                                j = 0;
                            }
                        }


                    }
                    if(x > 0){
                        x--;
                    }else{
                        j=0;
                    }
                }
                
                break;
        }
    }
    /**
     * Guardamos la trayectoria atacante de la pieza que amenaza al rey enemigo
     * 
     * @param tablero PanelTablero que contiene tanto los datos de la pantalla, del tablero y la partida
     * @param fichaAtacante Pieza que está amenanzando al rey
     * @param reyAtacado Pieza del rey atacado
     */
    public void storeThreatToKing(PanelTablero tablero, Pieza fichaAtacante, Pieza reyAtacado){
        int columnaFichaAtacante, filaFichaAtacante, columnaReyAtacado, filaReyAtacado;
        columnaFichaAtacante = fichaAtacante.getPosEnColumnasTablero();
        filaFichaAtacante = fichaAtacante.getPosEnFilasTablero();
        columnaReyAtacado = reyAtacado.getPosEnColumnasTablero();
        filaReyAtacado = reyAtacado.getPosEnFilasTablero();
        
        //Limpiamos las filas y columnas de amenaza que pudieran existir anteriormente
        fichaAtacante.getFilaAmenazaRey().clear();
        fichaAtacante.getColumnaAmenazaRey().clear();
        
        switch(fichaAtacante.getName()){
            case "Rey": //FALTA COMPROBAR SI TODO EL CÓDIGO DEL REY FUNCIONA
                //FILA
                //Si estamos en la misma fila que el rey atacado guardamos la trayectoria aumentando las columnas
                if(Objects.equals(fichaAtacante.getPosEnFilasTablero(), reyAtacado.getPosEnFilasTablero())){
                    //Repetimos el bucle hasta que las columna del rey atacado no coincida con la 
                    //columna de la ficha atacante
                    do {
                        
                        if(columnaReyAtacado>columnaFichaAtacante){
                            fichaAtacante.setFilaAmenazaRey(filaFichaAtacante);
                            fichaAtacante.setColumnaAmenazaRey(columnaFichaAtacante);
                            if(columnaReyAtacado != columnaFichaAtacante){
                                columnaFichaAtacante++;
                            }
                            
                        }else if (columnaReyAtacado<columnaFichaAtacante){
                            fichaAtacante.setFilaAmenazaRey(filaFichaAtacante);
                            fichaAtacante.setColumnaAmenazaRey(columnaFichaAtacante);
                            if(columnaReyAtacado != columnaFichaAtacante){
                                columnaFichaAtacante--;
                            }
                            
                        }
                        
                    } while (columnaReyAtacado!=columnaFichaAtacante);
                //COLUMNA
                //Si estamos en la misma columna que el rey atacado guardamos la trayectoria aumentando las filas    
                }else if(Objects.equals(fichaAtacante.getPosEnColumnasTablero(), reyAtacado.getPosEnColumnasTablero())){
                    //Repetimos el bucle hasta que la fila del rey atacado no coincida con la 
                    //fila de la ficha atacante
                    do {
                        
                        if(filaReyAtacado>filaFichaAtacante){
                            fichaAtacante.setFilaAmenazaRey(filaFichaAtacante);
                            fichaAtacante.setColumnaAmenazaRey(columnaFichaAtacante);
                            if(filaReyAtacado != filaFichaAtacante){
                                filaFichaAtacante++;
                            }
                            
                        }else if (filaReyAtacado<filaFichaAtacante){
                            fichaAtacante.setFilaAmenazaRey(filaFichaAtacante);
                            fichaAtacante.setColumnaAmenazaRey(columnaFichaAtacante);
                            if(filaReyAtacado != filaFichaAtacante){
                                filaFichaAtacante--;
                            }
                            
                        }
                        
                    } while (filaReyAtacado!=filaFichaAtacante);
                 
                //DIAGONALES    
                }else{
                    
                    
                    
                    
                    //+1 FILA + 1 COLUMNA
                    if((reyAtacado.getPosEnFilasTablero() - fichaAtacante.getPosEnFilasTablero())==1 
                    && (reyAtacado.getPosEnColumnasTablero() - fichaAtacante.getPosEnColumnasTablero())==1){  
                        
                        fichaAtacante.setFilaAmenazaRey(filaFichaAtacante);
                        fichaAtacante.setColumnaAmenazaRey(columnaFichaAtacante);
                        
                    //+1 FILA - 1 COLUMNA    
                    }else if((reyAtacado.getPosEnFilasTablero() - fichaAtacante.getPosEnFilasTablero())==1 
                        && (reyAtacado.getPosEnColumnasTablero() - fichaAtacante.getPosEnColumnasTablero())==-1){
                        
                        fichaAtacante.setFilaAmenazaRey(filaFichaAtacante);
                        fichaAtacante.setColumnaAmenazaRey(columnaFichaAtacante); 
                    
                    //-1 FILA + 1 COLUMNA    
                    }else if((reyAtacado.getPosEnFilasTablero() - fichaAtacante.getPosEnFilasTablero())==-1 
                        && (reyAtacado.getPosEnColumnasTablero() - fichaAtacante.getPosEnColumnasTablero())==1){
                    
                        fichaAtacante.setFilaAmenazaRey(filaFichaAtacante);
                        fichaAtacante.setColumnaAmenazaRey(columnaFichaAtacante);
                    
                    //-1 FILA - 1 COLUMNA
                    }else if((reyAtacado.getPosEnFilasTablero() - fichaAtacante.getPosEnFilasTablero())==-1 
                        && (reyAtacado.getPosEnColumnasTablero() - fichaAtacante.getPosEnColumnasTablero())==-1){
                    
                        fichaAtacante.setFilaAmenazaRey(filaFichaAtacante);
                        fichaAtacante.setColumnaAmenazaRey(columnaFichaAtacante);
                    
                    }
                    
                    
                }
                break;
            case "Reina": //FALTA COMPROBAR SI TODO EL CÓDIGO DEL PEÓN FUNCIONA
                //MVTOS COMO LA TORRE
                if(Objects.equals(fichaAtacante.getPosEnFilasTablero(), reyAtacado.getPosEnFilasTablero())
                    || Objects.equals(fichaAtacante.getPosEnColumnasTablero(), reyAtacado.getPosEnColumnasTablero())){
                    //FILA
                    //Si estamos en la misma fila que el rey atacado guardamos la trayectoria aumentando las columnas
                    if(Objects.equals(fichaAtacante.getPosEnFilasTablero(), reyAtacado.getPosEnFilasTablero())){

                        //Repetimos el bucle hasta que las columna del rey atacado no coincida con la 
                        //columna de la ficha atacante
                        do {

                            if(columnaReyAtacado>columnaFichaAtacante){
                                fichaAtacante.setFilaAmenazaRey(filaFichaAtacante);
                                fichaAtacante.setColumnaAmenazaRey(columnaFichaAtacante);
                                if(columnaReyAtacado != columnaFichaAtacante){
                                    columnaFichaAtacante++;
                                }

                            }else if (columnaReyAtacado<columnaFichaAtacante){
                                fichaAtacante.setFilaAmenazaRey(filaFichaAtacante);
                                fichaAtacante.setColumnaAmenazaRey(columnaFichaAtacante);
                                if(columnaReyAtacado != columnaFichaAtacante){
                                    columnaFichaAtacante--;
                                }

                            }

                        } while (columnaReyAtacado!=columnaFichaAtacante);

                    //COLUMNA
                    //Si estamos en la misma columna que el rey atacado guardamos la trayectoria aumentando las filas    
                    }else if(Objects.equals(fichaAtacante.getPosEnColumnasTablero(), reyAtacado.getPosEnColumnasTablero())){
                        //Repetimos el bucle hasta que la fila del rey atacado no coincida con la 
                        //fila de la ficha atacante
                        do {

                            if(filaReyAtacado>filaFichaAtacante){
                                fichaAtacante.setFilaAmenazaRey(filaFichaAtacante);
                                fichaAtacante.setColumnaAmenazaRey(columnaFichaAtacante);
                                if(filaReyAtacado != filaFichaAtacante){
                                    filaFichaAtacante++;
                                }

                            }else if (filaReyAtacado<filaFichaAtacante){
                                fichaAtacante.setFilaAmenazaRey(filaFichaAtacante);
                                fichaAtacante.setColumnaAmenazaRey(columnaFichaAtacante);
                                if(filaReyAtacado != filaFichaAtacante){
                                    filaFichaAtacante--;
                                }

                            }

                        } while (filaReyAtacado!=filaFichaAtacante);
                    }
                //MVTOS COMO EL ALFIL
                }else{
                    do{
                        fichaAtacante.setFilaAmenazaRey(filaFichaAtacante);
                        fichaAtacante.setColumnaAmenazaRey(columnaFichaAtacante);

                        if(filaReyAtacado>filaFichaAtacante){
                            if(filaReyAtacado != filaFichaAtacante){
                                filaFichaAtacante++;
                            }

                        }else if (filaReyAtacado<filaFichaAtacante){
                            if(filaReyAtacado != filaFichaAtacante){
                                filaFichaAtacante--;
                            }

                        }

                        if(columnaReyAtacado>columnaFichaAtacante){
                            if(columnaReyAtacado != columnaFichaAtacante){
                                columnaFichaAtacante++;
                            }

                        }else if (columnaReyAtacado<columnaFichaAtacante){
                            if(columnaReyAtacado != columnaFichaAtacante){
                                columnaFichaAtacante--;
                            }

                        }



                    }while(columnaFichaAtacante != columnaReyAtacado && filaFichaAtacante != filaReyAtacado);
                }
                
                
                break;
            case "Alfil": //FALTA COMPROBAR SI TODO EL CÓDIGO DEL PEÓN FUNCIONA
                
                do{
                    fichaAtacante.setFilaAmenazaRey(filaFichaAtacante);
                    fichaAtacante.setColumnaAmenazaRey(columnaFichaAtacante);
                    
                    if(filaReyAtacado>filaFichaAtacante){
                        if(filaReyAtacado != filaFichaAtacante){
                            filaFichaAtacante++;
                        }

                    }else if (filaReyAtacado<filaFichaAtacante){
                        if(filaReyAtacado != filaFichaAtacante){
                            filaFichaAtacante--;
                        }

                    }
                    
                    if(columnaReyAtacado>columnaFichaAtacante){
                        if(columnaReyAtacado != columnaFichaAtacante){
                            columnaFichaAtacante++;
                        }

                    }else if (columnaReyAtacado<columnaFichaAtacante){
                        if(columnaReyAtacado != columnaFichaAtacante){
                            columnaFichaAtacante--;
                        }

                    }
                    
                    
                    
                }while(columnaFichaAtacante != columnaReyAtacado && filaFichaAtacante != filaReyAtacado);
                
                
                break;
            case "Torre":
                //FILA
                //Si estamos en la misma fila que el rey atacado guardamos la trayectoria aumentando las columnas
                if(Objects.equals(fichaAtacante.getPosEnFilasTablero(), reyAtacado.getPosEnFilasTablero())){
                    
                    //Repetimos el bucle hasta que las columna del rey atacado no coincida con la 
                    //columna de la ficha atacante
                    do {
                        
                        if(columnaReyAtacado>columnaFichaAtacante){
                            fichaAtacante.setFilaAmenazaRey(filaFichaAtacante);
                            fichaAtacante.setColumnaAmenazaRey(columnaFichaAtacante);
                            if(columnaReyAtacado != columnaFichaAtacante){
                                columnaFichaAtacante++;
                            }
                            
                        }else if (columnaReyAtacado<columnaFichaAtacante){
                            fichaAtacante.setFilaAmenazaRey(filaFichaAtacante);
                            fichaAtacante.setColumnaAmenazaRey(columnaFichaAtacante);
                            if(columnaReyAtacado != columnaFichaAtacante){
                                columnaFichaAtacante--;
                            }
                            
                        }
                        
                    } while (columnaReyAtacado!=columnaFichaAtacante);
                    
                //COLUMNA
                //Si estamos en la misma columna que el rey atacado guardamos la trayectoria aumentando las filas    
                }else if(Objects.equals(fichaAtacante.getPosEnColumnasTablero(), reyAtacado.getPosEnColumnasTablero())){
                    //Repetimos el bucle hasta que la fila del rey atacado no coincida con la 
                    //fila de la ficha atacante
                    do {
                        
                        if(filaReyAtacado>filaFichaAtacante){
                            fichaAtacante.setFilaAmenazaRey(filaFichaAtacante);
                            fichaAtacante.setColumnaAmenazaRey(columnaFichaAtacante);
                            if(filaReyAtacado != filaFichaAtacante){
                                filaFichaAtacante++;
                            }
                            
                        }else if (filaReyAtacado<filaFichaAtacante){
                            fichaAtacante.setFilaAmenazaRey(filaFichaAtacante);
                            fichaAtacante.setColumnaAmenazaRey(columnaFichaAtacante);
                            if(filaReyAtacado != filaFichaAtacante){
                                filaFichaAtacante--;
                            }
                            
                        }
                        
                    } while (filaReyAtacado!=filaFichaAtacante);
                }
                
                
                break;
            case "Peón": //FALTA COMPROBAR SI TODO EL CÓDIGO DEL PEÓN FUNCIONA
                
                //+1 FILA + 1 COLUMNA
                if((reyAtacado.getPosEnFilasTablero() - fichaAtacante.getPosEnFilasTablero())==1 
                && (reyAtacado.getPosEnColumnasTablero() - fichaAtacante.getPosEnColumnasTablero())==1){  

                    fichaAtacante.setFilaAmenazaRey(filaFichaAtacante);
                    fichaAtacante.setColumnaAmenazaRey(columnaFichaAtacante);

                //+1 FILA - 1 COLUMNA    
                }else if((reyAtacado.getPosEnFilasTablero() - fichaAtacante.getPosEnFilasTablero())==1 
                    && (reyAtacado.getPosEnColumnasTablero() - fichaAtacante.getPosEnColumnasTablero())==-1){

                    fichaAtacante.setFilaAmenazaRey(filaFichaAtacante);
                    fichaAtacante.setColumnaAmenazaRey(columnaFichaAtacante); 

                //-1 FILA + 1 COLUMNA    
                }else if((reyAtacado.getPosEnFilasTablero() - fichaAtacante.getPosEnFilasTablero())==-1 
                    && (reyAtacado.getPosEnColumnasTablero() - fichaAtacante.getPosEnColumnasTablero())==1){

                    fichaAtacante.setFilaAmenazaRey(filaFichaAtacante);
                    fichaAtacante.setColumnaAmenazaRey(columnaFichaAtacante);

                //-1 FILA - 1 COLUMNA
                }else if((reyAtacado.getPosEnFilasTablero() - fichaAtacante.getPosEnFilasTablero())==-1 
                    && (reyAtacado.getPosEnColumnasTablero() - fichaAtacante.getPosEnColumnasTablero())==-1){

                    fichaAtacante.setFilaAmenazaRey(filaFichaAtacante);
                    fichaAtacante.setColumnaAmenazaRey(columnaFichaAtacante);

                }
                break;
            case "Caballo": //FALTA COMPROBAR SI TODO EL CÓDIGO DEL PEÓN FUNCIONA
                
                fichaAtacante.setFilaAmenazaRey(filaFichaAtacante);
                fichaAtacante.setColumnaAmenazaRey(columnaFichaAtacante);

                
                break;
                
                
        }
    }
}

