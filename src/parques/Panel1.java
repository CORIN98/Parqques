/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parques;

import java.awt.BorderLayout;
import java.awt.Image;
import java.io.File;
import java.util.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *Esta clase se encarga de realizar todo en cuanto al usuario
 * @author johan
 */
public class Panel1 extends javax.swing.JPanel {

    private Persona persona;
    private DefaultTableModel table_model_personas;
    private LocalDate fechan;
    private String part1,part2,part3,foto,fecha12;
    private File file;
    private Timestamp ahora12;
    private Date fecha121;
    Panelprincipal panel1=new  Panelprincipal();
   
    private int bandera = 0;

    /**
     * Creates new form panel1
     */
    public Panel1() {
        initComponents();
        /*eliminar.setVisible(false);
        editar.setVisible(false);*/
    }
    /**
     * Método para generar la tabla personas
     * @param table_model_personas 
     */
    public void setTableModel(DefaultTableModel table_model_personas){
        this. table_model_personas =  table_model_personas;
    }
    /**
     * Método para generar la tabla personas
     */
    public void refreshTableModel()
    {
       ArrayList<Persona> lista_personas=Repositorio.obtenerTodos();
       while(table_model_personas.getRowCount()>0){
            table_model_personas.removeRow(0);
       }
       
       for(Persona p: lista_personas){         
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      
            String fecha1 = sdf.format(p.getFechanac());
            String[] data = {Integer.toString(p.getCedula()),p.getNombre(), p.getApellido(), fecha1, Integer.toString(p.getEdad())};
            table_model_personas.addRow(data);
       }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        agregar1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nombre_txt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        apellido_txt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        edad_txt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        agregar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cedula_txt = new javax.swing.JTextField();
        foto_txt = new javax.swing.JLabel();
        contrasena_txt = new javax.swing.JPasswordField();
        DateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        agregar1.setBackground(new java.awt.Color(153, 153, 0));
        agregar1.setForeground(new java.awt.Color(255, 255, 255));
        agregar1.setText("AGREGAR");
        agregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar1ActionPerformed(evt);
            }
        });

        jLabel9.setText("(mes)");

        setBackground(java.awt.SystemColor.activeCaptionBorder);
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRO DE JUGADORES");
        add(jLabel1);
        jLabel1.setBounds(160, 60, 500, 51);

        jLabel12.setFont(new java.awt.Font("Jokerman", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Contraseña");
        add(jLabel12);
        jLabel12.setBounds(60, 420, 140, 28);

        jLabel2.setFont(new java.awt.Font("Jokerman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre");
        add(jLabel2);
        jLabel2.setBounds(220, 240, 110, 28);

        nombre_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombre_txtKeyTyped(evt);
            }
        });
        add(nombre_txt);
        nombre_txt.setBounds(400, 240, 280, 30);

        jLabel3.setFont(new java.awt.Font("Jokerman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Apellido");
        add(jLabel3);
        jLabel3.setBounds(220, 290, 110, 28);

        apellido_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                apellido_txtKeyTyped(evt);
            }
        });
        add(apellido_txt);
        apellido_txt.setBounds(400, 290, 280, 30);

        jLabel4.setFont(new java.awt.Font("Jokerman", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Fecha de nacimiento");
        add(jLabel4);
        jLabel4.setBounds(220, 360, 220, 28);

        jLabel5.setFont(new java.awt.Font("Jokerman", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Edad");
        add(jLabel5);
        jLabel5.setBounds(60, 360, 50, 28);

        edad_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                edad_txtKeyTyped(evt);
            }
        });
        add(edad_txt);
        edad_txt.setBounds(130, 360, 49, 30);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono.png"))); // NOI18N
        jLabel11.setText("jLabel11");
        add(jLabel11);
        jLabel11.setBounds(30, 0, 190, 160);

        agregar.setBackground(new java.awt.Color(153, 153, 0));
        agregar.setForeground(new java.awt.Color(255, 255, 255));
        agregar.setText("REGISTRAR");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });
        add(agregar);
        agregar.setBounds(60, 490, 150, 30);

        jLabel7.setFont(new java.awt.Font("Jokerman", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Número Cedula");
        add(jLabel7);
        jLabel7.setBounds(220, 180, 170, 40);

        cedula_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cedula_txtKeyTyped(evt);
            }
        });
        add(cedula_txt);
        cedula_txt.setBounds(400, 180, 280, 30);

        foto_txt.setForeground(new java.awt.Color(255, 255, 255));
        foto_txt.setText("FOTO");
        foto_txt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                foto_txtMouseClicked(evt);
            }
        });
        add(foto_txt);
        foto_txt.setBounds(59, 180, 130, 130);
        add(contrasena_txt);
        contrasena_txt.setBounds(190, 420, 180, 30);
        add(DateChooser1);
        DateChooser1.setBounds(460, 360, 209, 30);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo1.jpg"))); // NOI18N
        jLabel8.setText("jLabel8");
        add(jLabel8);
        jLabel8.setBounds(-100, -30, 1130, 870);

        jLabel10.setText("jLabel10");
        add(jLabel10);
        jLabel10.setBounds(70, 60, 40, 14);
    }// </editor-fold>//GEN-END:initComponents
/**
 * Metodo para agregar usuario
 * @param evt 
 */
    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
      int error=0;
      Date parsed=null;
      java.sql.Date fecha1 = null;
     SimpleDateFormat plantilla = new SimpleDateFormat("dd-MM-yyyy"); 
     try{
         fecha12=plantilla.format(DateChooser1.getDate());   
        System.out.println(fecha12+"ddfddsfghjkljhgf");      
        bandera = 0;  
         try {
            parsed = (Date) plantilla.parse(fecha12);
        } catch (ParseException ex) {
            Logger.getLogger(Panel1.class.getName()).log(Level.SEVERE, null, ex);
        }
     }catch(java.lang.NullPointerException s){
            error++;
            JOptionPane.showMessageDialog(this, "Por favor complete todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
     }
     
        if (apellido_txt.getText().isEmpty() || nombre_txt.getText().isEmpty() || edad_txt.getText().isEmpty() || contrasena_txt.getText().isEmpty()) {
            bandera = 1;
            if(error!=1)
            JOptionPane.showMessageDialog(this, "Por favor complete todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        } else {

           
            LocalDateTime ahora = LocalDateTime.now();
            ahora12 = Timestamp.valueOf(ahora);
        
            
       
        fecha1=new java.sql.Date(parsed.getTime());
            
            
            System.out.printf("\nEl dia es es %s y naci en un %s%n", fecha1, ahora12);
                
         
        if(Repositorio.validarcedula(Integer.parseInt(cedula_txt.getText()))==1){
            bandera=2;
             JOptionPane.showMessageDialog(this, "Usted ya esta registrado", "Error", JOptionPane.ERROR_MESSAGE);
              this.resetPersona();
            nombre_txt.setText("");
            apellido_txt.setText("");
            edad_txt.setText("");
            contrasena_txt.setText("");
        }
        }
        System.out.println(bandera);
        if (bandera != 1 && bandera != 2) {
            persona = Persona.crear(0, Integer.parseInt(cedula_txt.getText()), Integer.parseInt(edad_txt.getText()), nombre_txt.getText(), apellido_txt.getText(), fecha1, ahora12,foto,contrasena_txt.getText());
            Repositorio.crear(persona);

            JOptionPane.showMessageDialog(this, "Jugador Creado", "Bien", JOptionPane.INFORMATION_MESSAGE);
            Iniciars panel1=new Iniciars();
            panel1.setSize(1000, 800);
            panel1.setLocation(0, 0);

            removeAll();
            add(panel1,BorderLayout.CENTER);
            revalidate();
            repaint();
        }
    }//GEN-LAST:event_agregarActionPerformed

    private void agregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_agregar1ActionPerformed

    private void resetPersona() {
        persona.setId(0);
        persona.setCedula(0);
        persona.setNombre("");
        persona.setApellido("");
        persona.setContrasena("");
        persona.setEdad(0);
       
        persona.setFecharegistro(ahora12);
        popularPersona(persona);
    }


/**
 * Método que valida el tamaño del número de cédula
 * @param evt 
 */
    private void cedula_txtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cedula_txtKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c) && (cedula_txt.getText().length() < 10)) {

        } else {
            if (cedula_txt.getText().length() == 10) {
                evt.consume();
                JOptionPane.showMessageDialog(null, "Ya no puede exceder el maximo de digitos", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                if (Character.isLetter(c) || (c >= 32 && c <= 47) || (c >= 58 && c <= 63)) {
                    evt.consume();
                    JOptionPane.showMessageDialog(null, "Solo se admiten numeros enteros", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }

        }
    }//GEN-LAST:event_cedula_txtKeyTyped
/**
 * Método que valida que sólo se acepten letras en el nombre
 * @param evt 
 */
    private void nombre_txtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombre_txtKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            JOptionPane.showMessageDialog(null, "Solo se admiten letras", "Error", JOptionPane.ERROR_MESSAGE);
            evt.consume();
        }
    }//GEN-LAST:event_nombre_txtKeyTyped
/**
 * Método que valida que sólo se acepten letras en el apellido
 * @param evt 
 */
    private void apellido_txtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apellido_txtKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            JOptionPane.showMessageDialog(null, "Solo se admiten letras", "Error", JOptionPane.ERROR_MESSAGE);
            evt.consume();
        }
    }//GEN-LAST:event_apellido_txtKeyTyped


    private void edad_txtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edad_txtKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c) && (edad_txt.getText().length() < 2)) {

        } else {
            if (edad_txt.getText().length() == 2) {
                JOptionPane.showMessageDialog(null, "Ya no puede exceder el maximo de digitos", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                if (Character.isLetter(c) || (c >= 32 && c <= 47) || (c >= 58 && c <= 63)) {
                    evt.consume();
                    JOptionPane.showMessageDialog(null, "Solo se admiten numeros enteros", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        }
    }//GEN-LAST:event_edad_txtKeyTyped

    private void foto_txtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_foto_txtMouseClicked
        JFileChooser archivo=new JFileChooser();
        int ventana=archivo.showOpenDialog(null);
        if(ventana==JFileChooser.APPROVE_OPTION){
            file=archivo.getSelectedFile();
            foto=String.valueOf(file);
            Image foto1=getToolkit().getImage(foto);
            foto_txt.setIcon(new ImageIcon(foto1));
            
           
        }
    }//GEN-LAST:event_foto_txtMouseClicked


    private void popularPersona(Persona persona) {
        cedula_txt.setText(String.valueOf(persona.getCedula()));
        edad_txt.setText(String.valueOf(persona.getEdad()));
        nombre_txt.setText(persona.getNombre());
        apellido_txt.setText(persona.getApellido());
        
        String[] parts = String.valueOf(persona.getFechanac()).split("-");
        try{
        part1 = parts[0]; // 123
        part2 = parts[1];
        part3 = parts[2];
        }catch(java.lang.ArrayIndexOutOfBoundsException sd){
            
        }
       /* ano_txt.setText(part1);
        mes_txt.setText(part2);
        dia_txt.setText(part3);

        if (persona.getId() != 0) {
            eliminar.setVisible(true);
            editar.setVisible(true);
        } else {
            eliminar.setVisible(false);
            editar.setVisible(true);
        }*/
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateChooser1;
    private javax.swing.JButton agregar;
    private javax.swing.JButton agregar1;
    private javax.swing.JTextField apellido_txt;
    private javax.swing.JTextField cedula_txt;
    private javax.swing.JPasswordField contrasena_txt;
    private javax.swing.JTextField edad_txt;
    private javax.swing.JLabel foto_txt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField nombre_txt;
    // End of variables declaration//GEN-END:variables
}
