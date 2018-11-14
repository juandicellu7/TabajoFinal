
import Conexion.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import org.omg.CORBA.ORB;



/**
 *
 * @author juanflorez
 */
public class Factura extends FacturaApp.FacturaPOA{
    
    private ORB orb;
    Conexion conex = new Conexion();

    @Override
    public boolean guardarFactura(int id_factura, String id_pedido, String id_cliente, String id_producto, String id_almacen, String fecha, String detalle_factura, String ciudad, String cantidad_ordenada, String valor_venta) {
    boolean resultado = false;
        try {
            String sql= "insert into factura (id_factura, id_pedido, id_cliente, id_producto,id_almacen,fecha, detalle_factura,ciudad,cantidad_ordenada, valor_venta )values('"+id_factura+"','"+id_pedido+"','"+id_cliente+"','"+id_producto+"','"+id_almacen+"','"+fecha+"','"+detalle_factura+"','"+ciudad+"','"+cantidad_ordenada+"','"+valor_venta+"')";
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
    public boolean actualizarFactura(int id_factura, String id_pedido, String id_cliente, String id_producto, String id_almacen, String fecha, String detalle_factura, String ciudad, String cantidad_ordenada, String valor_venta) {
      boolean resultado = false;
        try {
           String sql ="Update factura set id_pedido='" + id_pedido + "',id_cliente='" + id_cliente + "',id_producto='" + id_producto + "',id_almacen='" + id_almacen + "',fecha='" + fecha + "',detalle_factura='" + detalle_factura + "',ciudad='" + ciudad + "',cantidad_ordenada='" + cantidad_ordenada + "',valor_venta='" + valor_venta + "'"
                    + " Where id_factura='" + id_factura + "'";
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
    public boolean eliminarFactura(int id_factura) {
    boolean resultado = false;
        try {
            String query = "Delete from factura where id_factura= " + id_factura;
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
    public String consultarFactura(int id_factura) {
    String resultado = "";
        try {
            String sqlConsultar = "Select* from factura where id_factura = "+ id_factura;
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
    
     public ResultSet cargarTablaFactura() {
        ResultSet resultado = null;
        try {
            String query = "Select id_factura, id_pedido, id_cliente, id_producto,id_almacen,fecha, detalle_factura,ciudad,cantidad_ordenada, valor_venta  from factura";
            conex.conexion();
            Statement st = conex.conex.createStatement();
            resultado = st.executeQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrieo un error " + e.getMessage());
        }
        return resultado;
    }
    
}
