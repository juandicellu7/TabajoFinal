
import Conexion.*;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import org.omg.CORBA.ORB;

/**
 *
 * @author juanflorez
 */
public class Producto extends ProductoApp.ProductoPOA {

    private ORB orb;
    Conexion conex = new Conexion();

    @Override
    public boolean guardarProducto(int id_producto, String descripcion, String cantidad_producto, String precio) {

        boolean resultado = false;
        try {
            String query = "Insert into producto(id_producto,descripcion,cantidad_producto,precio)"
                    + "values ('" + id_producto + "','" + descripcion + "','" + cantidad_producto + "','" + precio + "')";
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
    public boolean actualizarProducto(int id_producto, String descripcion, String cantidad_producto, String precio) {
        boolean resultado = false;
        try {
            String query = "Update producto set descripcion='" + descripcion + "',cantidad_producto='" + cantidad_producto + "',precio='" + precio + "'"
                    + " Where id_producto='" + id_producto + "'";
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
            JOptionPane.showMessageDialog(null, "Error al actualizar" + e.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean eliminarProducto(int id_producto) {
        boolean resultado = false;
        try {
            String query = "Delete from producto where idproducto= " + id_producto;
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
    public String consultarProducto(int id_producto) {
        String resultado = "";
        try {
            String query = "Select * from producto where id_producto = " + id_producto;
            conex.conexion();
            Statement st = conex.conex.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                resultado += rs.getString(2) + "-"
                        + rs.getString(3) + "-"
                        + rs.getString(4);
            }
            //se cierran las conexiones
            conex.conex.close();
            st.close();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return resultado;
    }

    @Override
    public void shoutdown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ResultSet cargarTablaProducto() {
        ResultSet resultado = null;
        try {
            String query = "Select id_producto, descripcion, cantidad_producto, precio from producto";
            conex.conexion();
            Statement st = conex.conex.createStatement();
            resultado = st.executeQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrieo un error al cargar table de producto" + e.getMessage());
        }
        return resultado;
    }

}
