package FacturaApp;

/**
* FacturaApp/FacturaHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Factura.idl
* miercoles 14 de noviembre de 2018 09:27:39 AM COT
*/

public final class FacturaHolder implements org.omg.CORBA.portable.Streamable
{
  public FacturaApp.Factura value = null;

  public FacturaHolder ()
  {
  }

  public FacturaHolder (FacturaApp.Factura initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = FacturaApp.FacturaHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    FacturaApp.FacturaHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return FacturaApp.FacturaHelper.type ();
  }

}
