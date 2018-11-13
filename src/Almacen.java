
import Conexion.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import org.omg.CORBA.ORB;


public class Almacen extends AlmacenApp.AlmacenPOA {
    
    private ORB orb;
    Conexion conex = new Conexion();

    @Override
    public boolean guardarAlmacen(int id_almacen, String nombre, String telefono, String direccion, String ciudad) {
        boolean resultado = false;
        try {
            String query = "Insert into almacen(id_almacen,nombre,direccion,telefono,ciudad)"
                    + "values ('" + id_almacen + "','" + nombre + "','" + direccion + "','" + telefono + "','" + ciudad + "')";
            conex.conexion();
            Statement st = conex.conex.createStatement();
            int valor = st.executeUpdate(query);
            if (valor > 0) {
                resultado = true;
            }
            //se cierran todas la conecciones 
            conex.conex.close();
            st.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar" + e.getMessage());
        }
        return resultado;    
    }

    @Override
    public boolean actualizarAlmacen(int id_almacen, String nombre, String telefono, String direccion, String ciudad) {
        boolean resultado = false;
        try {
            String query ="Update almacen set nombre='" + nombre + "',telefono='" + telefono + "',telefono='" + telefono + "',ciudad='" + ciudad + "'"
                    + " Where id_almacen='" + id_almacen + "'";
            conex.conexion();
            Statement st = conex.conex.createStatement();
            int valor = st.executeUpdate(query);
            if (valor > 0) {
                resultado = true;
            }
            //se cierran todas la conecciones 
            conex.conex.close();
            st.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar" + e.getMessage());
        }
        return resultado;  
    }

    @Override
    public boolean eliminarAlmacen(int id_almacen) {
         boolean resultado = false;
        try {
            String query = "Delete from almacen where id_almacen= " + id_almacen;
            conex.conexion();
            Statement st = conex.conex.createStatement();
            int valor = st.executeUpdate(query);
            if (valor > 0) {
                resultado = true;
            }
            //se cierran todas la conecciones 
            conex.conex.close();
            st.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar" + e.getMessage());
        }
        return resultado; 
        }

    @Override
    public String consultarAlmacen(int id_almacen) {
     Almacen objAlmacen = new Almacen();
        JOptionPane.showMessageDialog(null, objAlmacen.consultarAlmacen(5));
        return null;    
    }

    @Override
    public void shoutdown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ResultSet cargarTablaAlmacen() {
        ResultSet resultado = null;
        try {
            String query = "Select id_almacen,nombre,direccion,telefono,ciudad from Almacen";
            conex.conexion();
            Statement st = conex.conex.createStatement();
            resultado = st.executeQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrieo un error " + e.getMessage());
        }
        return resultado;
    }
    
}
