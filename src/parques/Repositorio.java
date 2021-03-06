package parques;

import co.edu.unicundinamarca.database.DBManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
/**
 * Clase que se encarga de conectarse con la base de datos en especial con la tabla personas
 * @author johan
 */
public class Repositorio {
	
    private static DBManager database = new DBManager();
      static Statement sentencia;
      static ResultSet resultado;
      
   /**
    * Método crear persona en la base de datos
    * @param persona 
    */
    public static void crear (Persona persona) {
        
        try {
            String query = "INSERT INTO jugador (cedula, nombre,apellido, fechanac, edad, foto,contrasena,categoria, fecharegistro) VALUES (?, ?, ?, ?, ?, ?, ?,?, ?);";
            //Colocar esos interrogantes l
            PreparedStatement sentenciaP = database.open().prepareStatement(query);
            sentenciaP.setInt(1, persona.getCedula());
            sentenciaP.setString(2, persona.getNombre());
            sentenciaP.setString(3, persona.getApellido());
            sentenciaP.setDate(4, persona.getFechanac());
            sentenciaP.setInt(5, persona.getEdad());
            sentenciaP.setString(6, persona.getFoto());
            sentenciaP.setString(7, persona.getContrasena());
            sentenciaP.setString(8, persona.getCategoria());
            sentenciaP.setTimestamp(9, persona.getFecharegistro());
            sentenciaP.executeUpdate();
            sentenciaP.close();
            database.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
    public static void historialJuegos (Jugador jugador) {
        
        try {
            String query = "INSERT INTO jugador (cedula,puntos, fechar) VALUES (?, ?, ?);";
            //Colocar esos interrogantes l
            PreparedStatement sentenciaP = database.open().prepareStatement(query);
            sentenciaP.setInt(1, jugador.getCedula());
            sentenciaP.setInt(2, jugador.getPuntos());
            sentenciaP.setTimestamp(3, jugador.getFecharegistro());
            
            sentenciaP.executeUpdate();
            sentenciaP.close();
            database.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

 
 
    /**
     * Método buscar persona en la base de datos donde sea igual a la cédula ingresada
     * @param documento
     * @return 
     */
       public static Persona buscar(String documento) {
        try {
            String query = "SELECT * FROM jugador WHERE cedula = ?;";
            PreparedStatement sentenciaP = database.open().prepareStatement(query);
            sentenciaP.setString(1, documento);

            ResultSet resultado = sentenciaP.executeQuery();

            while (resultado.next()) {
                return Persona.crear(resultado.getInt("id"), resultado.getInt("cedula"), resultado.getInt("edad"), resultado.getString("nombre"), resultado.getString("apellido"), resultado.getDate("fechanac"),  resultado.getTimestamp("fecharegistro"),resultado.getString("foto"),resultado.getString("contrasena"),resultado.getString("categoria"));
            }
            
            sentenciaP.close();
            database.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
/**
 * Método que valida que la cédula ha sido encontrada 
 * @param cedula
 * @return 
 */
    public static int validarcedula(int cedula) {
         int bandera=0; 
       try {
            //aqui ese select me selecciona la tabla ese where me indica donde recreador = String recreador1 si lo encuentra
            String query = "SELECT * FROM jugador WHERE cedula = '" + cedula+ "';";
            PreparedStatement sentenciaP = database.open().prepareStatement(query);// esto es para preparar lo del mysql eso si lo copie del ejercicio anterior hast
            ResultSet resultado = sentenciaP.executeQuery();
            
            while (resultado.next()) {//aqui copie
             if (resultado.getInt("cedula")==cedula) {
                 bandera++;
             }
         }
            } catch (Exception e) {
            System.out.println(e.getMessage());
            }
       if(bandera>0){
           return 1;
       }else{
           return 0;
       }
    }
       public static int validaruser(int cedula, String contrasena) {
        int bandera=0; 
       try {
            //aqui ese select me selecciona la tabla ese where me indica donde recreador = String recreador1 si lo encuentra
           String query = "SELECT * FROM jugador;";
            PreparedStatement sentenciaP = database.open().prepareStatement(query);// esto es para preparar lo del mysql eso si lo copie del ejercicio anterior hast
            ResultSet resultado = sentenciaP.executeQuery();
            
            while (resultado.next()) {//aqui copie
                System.out.println(resultado.getInt("cedula")+"----"+cedula+"---"+resultado.getString("contrasena")+"---"+contrasena);
             if (resultado.getInt("cedula")==cedula) {
                 String aux1=resultado.getString("contrasena");
                 System.out.println("ENTRO1"+aux1);           
                 if(aux1 == null ? contrasena == null : aux1.equals(contrasena)){
                   System.out.println("ENTRO2");
                 bandera++;
                 }
             }
         }
            } catch (Exception e) {
            System.out.println(e.getMessage());
            }
       if(bandera>0){
           return 1;
       }else{
           return 0;
       }
    }
       
       public static ArrayList<Persona> obtenerTodos(String categoria) {
        ArrayList<Persona> personas = new ArrayList<Persona>();

        try {
            String query = "SELECT * FROM jugador;";
            PreparedStatement sentenciaP = database.open().prepareStatement(query);
            ResultSet resultado = sentenciaP.executeQuery();
      
            if(categoria=="Todos"){    
            while (resultado.next()) {
                 personas.add(Persona.crear(resultado.getInt("id"),resultado.getInt("cedula"),resultado.getInt("edad"),resultado.getString("nombre"),resultado.getString("apellido"),
                        resultado.getDate("fechanac"),resultado.getTimestamp("fecharegistro"),resultado.getString("foto"),resultado.getString("contrasena"),resultado.getString("categoria")));
                }
            }else{
              
            
                
               while (resultado.next()) {
                 String categoriaB=resultado.getString("categoria");
                 if(categoria.equals(categoriaB)){
                 personas.add(Persona.crear(resultado.getInt("id"),resultado.getInt("cedula"),resultado.getInt("edad"),resultado.getString("nombre"),resultado.getString("apellido"),
                        resultado.getDate("fechanac"),resultado.getTimestamp("fecharegistro"),resultado.getString("foto"),resultado.getString("contrasena"),resultado.getString("categoria")));
                }
               }
            
            }
           
            sentenciaP.close();
            database.close();

            return personas;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return personas;
    }
}


