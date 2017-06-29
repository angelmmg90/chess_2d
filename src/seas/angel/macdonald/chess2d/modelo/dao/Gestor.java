package seas.angel.macdonald.chess2d.modelo.dao;

import seas.angel.macdonald.chess2d.vista.Pantalla;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import seas.angel.macdonald.chess2d.modelo.Partida;

/**
 * Clase que se encarga de guardar y cargar partidas.
 * 
 * @author Juan José Hernández Alonso
 * @author Ángel Mac Donald
 */
//  AGOSTO2016 - Ángel - Modificó la clase para adaptarla al uso de Chess 2D

public class Gestor {
    
    /**
     * Variable usada para guardar el fichero
     */
    private FileOutputStream fos;
    /**
     * Variable usada para cargar el fichero
     */
    private FileInputStream fis;
    /**
     * Variable usada para guardar el fichero
     */
    private ObjectOutputStream oos;
    /**
     * Variable usada para cargar el fichero
     */
    private ObjectInputStream ios;
    /**
     * Archivo que se guardará y cargará
     */
    private final String archivo;
    private final Pantalla pantalla;

    /**
     * Constructor parametrizado.
     *
     * @param pantalla Pantalla que contiene todos los datos de la partida, el tablero, los jugadores, etc....
     */
    public Gestor(Pantalla pantalla) {
        this.archivo = "partida.dat";
        this.pantalla = pantalla;
    }
    /**
     * Método que guarda la partida en el archivo.
     */
    public void guardar(){
        try {
            fos = new FileOutputStream(archivo);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(pantalla.getPartida());
            
            /*String boardUI[][];
            boardUI = pantalla.getPartida().getTablero().getBoardUI();
            try {
                System.out.println("\n\n\nTABLERO GUARDADO \n\n\n!!");
                String str = "|\t";
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        str += boardUI[i][j] + "\t";
                    }
                    System.out.println(str + "|");
                    str = "|\t";
                }
            } catch (Exception e) {
                System.out.println("Tablero vacío!!");
            }*/
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Gestor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Gestor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                oos.close();
                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(Gestor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    /**
     * Método que carga la partida en la pantalla.
     */
    public void cargar(){
        try {
            fis = new FileInputStream(archivo);
            ios = new ObjectInputStream(fis);
            pantalla.setPartida((Partida) ios.readObject());
            
            /*String boardUI[][];
            boardUI = pantalla.getPartida().getTablero().getBoardUI();
            try {
                System.out.println("\n\n\nTABLERO CARGADO EN GESTOR CARGA\n\n\n!!");
                String str = "|\t";
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        str += boardUI[i][j] + "\t";
                    }
                    System.out.println(str + "|");
                    str = "|\t";
                }
            } catch (Exception e) {
                System.out.println("Tablero vacío!!");
            }*/
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Gestor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Gestor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ios.close();
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(Gestor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
