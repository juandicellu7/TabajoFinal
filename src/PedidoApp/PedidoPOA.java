package PedidoApp;


/**
* PedidoApp/PedidoPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Pedido.idl
* sabado 3 de noviembre de 2018 11:41:46 AM COT
*/

public abstract class PedidoPOA extends org.omg.PortableServer.Servant
 implements PedidoApp.PedidoOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("guardarPedido", new java.lang.Integer (0));
    _methods.put ("actualizarPedido", new java.lang.Integer (1));
    _methods.put ("eliminarPedido", new java.lang.Integer (2));
    _methods.put ("consultarPedido", new java.lang.Integer (3));
    _methods.put ("shoutdown", new java.lang.Integer (4));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // PedidoApp/Pedido/guardarPedido
       {
         int id_pedido = in.read_long ();
         String fecha = in.read_wstring ();
         String cantidad_producto = in.read_wstring ();
         String precio_unitario = in.read_wstring ();
         boolean $result = false;
         $result = this.guardarPedido (id_pedido, fecha, cantidad_producto, precio_unitario);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 1:  // PedidoApp/Pedido/actualizarPedido
       {
         int id_pedido = in.read_long ();
         String fecha = in.read_wstring ();
         String cantidad_producto = in.read_wstring ();
         String precio_unitario = in.read_wstring ();
         boolean $result = false;
         $result = this.actualizarPedido (id_pedido, fecha, cantidad_producto, precio_unitario);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 2:  // PedidoApp/Pedido/eliminarPedido
       {
         int id_pedido = in.read_long ();
         boolean $result = false;
         $result = this.eliminarPedido (id_pedido);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 3:  // PedidoApp/Pedido/consultarPedido
       {
         int id_pedido = in.read_long ();
         String $result = null;
         $result = this.consultarPedido (id_pedido);
         out = $rh.createReply();
         out.write_wstring ($result);
         break;
       }

       case 4:  // PedidoApp/Pedido/shoutdown
       {
         this.shoutdown ();
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:PedidoApp/Pedido:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Pedido _this() 
  {
    return PedidoHelper.narrow(
    super._this_object());
  }

  public Pedido _this(org.omg.CORBA.ORB orb) 
  {
    return PedidoHelper.narrow(
    super._this_object(orb));
  }


} // class PedidoPOA
