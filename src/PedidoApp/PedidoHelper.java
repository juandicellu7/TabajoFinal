package PedidoApp;


/**
* PedidoApp/PedidoHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Pedido.idl
* s�bado 3 de noviembre de 2018 11:41:46 AM COT
*/

abstract public class PedidoHelper
{
  private static String  _id = "IDL:PedidoApp/Pedido:1.0";

  public static void insert (org.omg.CORBA.Any a, PedidoApp.Pedido that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static PedidoApp.Pedido extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (PedidoApp.PedidoHelper.id (), "Pedido");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static PedidoApp.Pedido read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_PedidoStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, PedidoApp.Pedido value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static PedidoApp.Pedido narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof PedidoApp.Pedido)
      return (PedidoApp.Pedido)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      PedidoApp._PedidoStub stub = new PedidoApp._PedidoStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static PedidoApp.Pedido unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof PedidoApp.Pedido)
      return (PedidoApp.Pedido)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      PedidoApp._PedidoStub stub = new PedidoApp._PedidoStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}