
import Conexion.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import org.omg.CORBA.ORB;

/**
 *
 * @author juanflorez
 */
public class Pedido extends PedidoApp.PedidoPOA {
     private ORB orb;
    Conexion conex = new Conexion();

    @Override
    public boolean guardarPedido(int id_pedido, String fecha, String cantidad_producto, String precio_unitario) {
    boolean resultado = false;
        try {
            String sql= "insert into pedido (id_pedido, fecha, cantidad_producto, precio_unitario)values('"+id_pedido+"','"+fecha+"','"+cantidad_producto+"','"+precio_unitario+"')";
             conex.conexion();
            Statement st = conex.conex.createStatement();
            int valor= st.executeUpdate(sql);
            if(valor>0){
            resultado=true;
            }
            //se cierran todas la conecciones 
             conex.conex.close();
            st.close();
            
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Error al insertar" +e.getMessage());
        }
        return resultado;    
    }

    @Override
    public boolean actualizarPedido(int id_pedido, String fecha, String cantidad_producto, String precio_unitario) {
         boolean resultado = false;
        try {
           String sql ="Update pedido set fecha='" + fecha + "',cantidad_producto='" + cantidad_producto + "',precio_unitario='" + precio_unitario + "'"
                    + " Where id_pedido='" + id_pedido + "'";
            conex.conexion();
            Statement st = conex.conex.createStatement();
            int valor= st.executeUpdate(sql);
            if(valor>0){
            resultado=true;
            }
            //se cierran todas la conecciones 
             conex.conex.close();
            st.close();
            
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Error al insertar" +e.getMessage());
        }
        return resultado;   
    
    }

    @Override
    public boolean eliminarPedido(int id_pedido) {
    boolean resultado = false;
        try {
            String query = "Delete from pedido where id_pedido= " + id_pedido;
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
    public String consultarPedido(int id_pedido) {
    String resultado = "";
        try {
            String sqlConsultar = "Select* from pedido where id_pedido = "+ id_pedido;
           conex.conexion();
            Statement st = conex.conex.createStatement();
            ResultSet rs = st.executeQuery(sqlConsultar);
            while(rs.next()){
            resultado += rs.getString(2)+"-"
                    +rs.getString(3)+"-"
                    +rs.getString(4);
            }
            //se cierran las conexiones
            conex.conex.close();
            st.close();
        } catch (Exception e) {
            System.out.println("ERROR: "+ e.getMessage());
        }
      return resultado;    
    }

    @Override
    public void shoutdown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public ResultSet cargarTablaPedido() {
        ResultSet resultado = null;
        try {
            String query = "Select id_pedido, fecha, cantidad_producto, precio_unitario from pedido";
            conex.conexion();
            Statement st = conex.conex.createStatement();
            resultado = st.executeQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrieo un error " + e.getMessage());
        }
        return resultado;
    }
    
    
}
