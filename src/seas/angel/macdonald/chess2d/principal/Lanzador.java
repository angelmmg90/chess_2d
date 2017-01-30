package seas.angel.macdonald.chess2d.principal;

import seas.angel.macdonald.chess2d.vista.Pantalla;
import seas.angel.macdonald.chess2d.vista.SplashScreen;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Clase lanzadora de la aplicacion.
 * 
 * @author Ángel Mac Donald Gainza
 */
public class Lanzador {
    
    /**
     * Método main.
     *
     * @param args String[] parámetros.
     * @throws java.io.IOException A causa del icono de la ventana pantalla
     */
    public static void main(String args[]) throws  IOException {
        SplashScreen splash = new SplashScreen(1000);
        // Normally, we'd call splash.showSplash() and get on with the program.
        // But, since this is only a test...
        splash.showSplashAndExit();
        Pantalla p = new Pantalla();
        
        
        
        p.setTitle("Chess 2D");
        p.setIconImage(ImageIO.read(new File("src/seas/angel/macdonald/chess2d/recursos/icon_chess_2d.png")));

        //p.setLocationRelativeTo(null);
        p.setSize(600,600);
        p.setVisible(true);
        
        
        
        
        
    }
    
}
