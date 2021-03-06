package FacturaApp;


/**
* FacturaApp/FacturaHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Factura.idl
* miercoles 14 de noviembre de 2018 09:27:39 AM COT
*/

abstract public class FacturaHelper
{
  private static String  _id = "IDL:FacturaApp/Factura:1.0";

  public static void insert (org.omg.CORBA.Any a, FacturaApp.Factura that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static FacturaApp.Factura extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (FacturaApp.FacturaHelper.id (), "Factura");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static FacturaApp.Factura read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_FacturaStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, FacturaApp.Factura value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static FacturaApp.Factura narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof FacturaApp.Factura)
      return (FacturaApp.Factura)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      FacturaApp._FacturaStub stub = new FacturaApp._FacturaStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static FacturaApp.Factura unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof FacturaApp.Factura)
      return (FacturaApp.Factura)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      FacturaApp._FacturaStub stub = new FacturaApp._FacturaStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
