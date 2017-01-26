package seas.angel.macdonald.chess2d.vista;

import java.io.Serializable;
import javax.swing.DefaultListModel;
import javax.swing.JList;



/**
 * Clase de la ventana (dialog) del Log del juego.
 *
 * @author Ángel Mac Donald Gainza
 */
public class Log extends javax.swing.JDialog implements Serializable{

    /**
     * El modelo del JList
     */
    DefaultListModel<String> listModel;
    /**
     * Constructor del Log del juego
     * 
     * @param pantalla Pantalla que contiene la información del juego.
     */
    public Log(Pantalla pantalla) {
        listModel = new DefaultListModel<>();
        initComponents();
        setLocationByPlatform(true);
        setVisible(true);
        setResizable(false);
        setLocation(pantalla.getX() + pantalla.getWidth(), pantalla.getY());
        lstLog.setModel(listModel);
        pack();
    }
    
    /**
     * Método que se encarga de limpiar el log
     * 
     */
    public void clearLog(){
        if(listModel != null){
            listModel.removeAllElements();
        }
        
    }
    /**
     * Método para visualizar siempre el último item del JList
     */
    public void setBottomLog(){
        int lastIndex = lstLog.getModel().getSize() - 1;
        if (lastIndex >= 0) {
            lstLog.ensureIndexIsVisible(lastIndex);
        }
    }
    
    /**
     * Getter lstLog
     * 
     * @return lstLog JList
     */
    public JList getLstLog() {
        return lstLog;
    }
    /**
     * Setter lstLog
     * 
     * @param lineLog String nuevo elemento para añadir al modelo del JList
     */
    public void setLstLog(String lineLog) {
        listModel.addElement(lineLog);  
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstLog = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro del juego");
        setResizable(false);

        lstLog.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lstLog);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lstLog;
    // End of variables declaration//GEN-END:variables
}