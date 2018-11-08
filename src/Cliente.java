import Conexion.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import org.omg.CORBA.ORB;

/**
 *
 * @author juanflorez
 */
public class Cliente extends ClienteApp.ClientePOA{
    
    private ORB orb;
    Conexion conex = new Conexion();

    @Override
    public boolean guardarCliente(int id_cliente, String nombres, String apellidos, String numero_identificacion, String genero, String telefono, String ciudad) {
     boolean resultado = false;
        try {
            String query = "Insert into cliente(id_cliente,nombres,apellidos,numero_identificacion,genero,telefono,ciudad)"
                    + "values ('" + id_cliente + "','" + nombres + "','" + apellidos + "','" + numero_identificacion + "','" + genero + "','" + telefono + "','" + ciudad + "')";
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
    public boolean actualizarCliente(int id_cliente, String nombres, String apellidos, String numero_identificacion, String genero, String telefono, String ciudad) {
    boolean resultado = false;
        try {
            String query ="Update cliente set nombres='" + nombres + "',apellidos='" + apellidos + "',numero_identificacion='" + numero_identificacion + "',genero='" + genero + "',telefono='" + telefono + "',ciudad='" + ciudad + "'"
                    + " Where id_cliente='" + id_cliente + "'";
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
    public boolean eliminarCliente(int id_cliente) {
       boolean resultado = false;
        try {
            String query = "Delete from cliente where id_cliente= " + id_cliente;
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
    public String consultarCliente(int id_cliente) {
        Cliente objCliente = new Cliente();
        JOptionPane.showMessageDialog(null, objCliente.consultarCliente(5));
        return null;
    }

    @Override
    public void shoutdown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ResultSet cargarTablaCliente() {
        ResultSet resultado = null;
        try {
            String query = "Select id_cliente,nombres,apellidos,numero_identificacion,genero,telefono,ciudad from cliente";
            conex.conexion();
            Statement st = conex.conex.createStatement();
            resultado = st.executeQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrieo un error " + e.getMessage());
        }
        return resultado;
    }
    
}
