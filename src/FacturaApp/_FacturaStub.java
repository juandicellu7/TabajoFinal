package FacturaApp;


/**
* FacturaApp/_FacturaStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Factura.idl
* miercoles 14 de noviembre de 2018 09:27:39 AM COT
*/

public class _FacturaStub extends org.omg.CORBA.portable.ObjectImpl implements FacturaApp.Factura
{

  public boolean guardarFactura (int id_factura, String id_pedido, String id_cliente, String id_producto, String id_almacen, String fecha, String detalle_factura, String ciudad, String cantidad_ordenada, String valor_venta)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("guardarFactura", true);
                $out.write_long (id_factura);
                $out.write_wstring (id_pedido);
                $out.write_wstring (id_cliente);
                $out.write_wstring (id_producto);
                $out.write_wstring (id_almacen);
                $out.write_wstring (fecha);
                $out.write_wstring (detalle_factura);
                $out.write_wstring (ciudad);
                $out.write_wstring (cantidad_ordenada);
                $out.write_wstring (valor_venta);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return guardarFactura (id_factura, id_pedido, id_cliente, id_producto, id_almacen, fecha, detalle_factura, ciudad, cantidad_ordenada, valor_venta        );
            } finally {
                _releaseReply ($in);
            }
  } // guardarFactura

  public boolean actualizarFactura (int id_factura, String id_pedido, String id_cliente, String id_producto, String id_almacen, String fecha, String detalle_factura, String ciudad, String cantidad_ordenada, String valor_venta)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("actualizarFactura", true);
                $out.write_long (id_factura);
                $out.write_wstring (id_pedido);
                $out.write_wstring (id_cliente);
                $out.write_wstring (id_producto);
                $out.write_wstring (id_almacen);
                $out.write_wstring (fecha);
                $out.write_wstring (detalle_factura);
                $out.write_wstring (ciudad);
                $out.write_wstring (cantidad_ordenada);
                $out.write_wstring (valor_venta);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return actualizarFactura (id_factura, id_pedido, id_cliente, id_producto, id_almacen, fecha, detalle_factura, ciudad, cantidad_ordenada, valor_venta        );
            } finally {
                _releaseReply ($in);
            }
  } // actualizarFactura

  public boolean eliminarFactura (int id_factura)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("eliminarFactura", true);
                $out.write_long (id_factura);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return eliminarFactura (id_factura        );
            } finally {
                _releaseReply ($in);
            }
  } // eliminarFactura

  public String consultarFactura (int id_factura)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("consultarFactura", true);
                $out.write_long (id_factura);
                $in = _invoke ($out);
                String $result = $in.read_wstring ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return consultarFactura (id_factura        );
            } finally {
                _releaseReply ($in);
            }
  } // consultarFactura

  public void shoutdown ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("shoutdown", false);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                shoutdown (        );
            } finally {
                _releaseReply ($in);
            }
  } // shoutdown

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:FacturaApp/Factura:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _FacturaStub