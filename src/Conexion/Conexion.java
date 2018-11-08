package Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author juanflorez
 */
public class Conexion {
    
    public Connection conex;
  
  public Connection conexion(){
      try {
          Class.forName("com.mysql.jdbc.Driver");
          conex=DriverManager.getConnection("jdbc:mysql://localhost/conexiontrabajof","root","");
          System.out.println("Conexion establecida");
      } catch (Exception e) {
          System.out.println("Conexion no establecida");
      }
      return conex;
  }
    
}
