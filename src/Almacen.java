
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarAlmacen(int id_almacen, String nombre, String telefono, String direccion, String ciudad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarAlmacen(int id_almacen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String consultarAlmacen(int id_almacen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
