package AlmacenApp;


/**
* AlmacenApp/AlmacenOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Almacen.idl
* miercoles 7 de noviembre de 2018 09:31:40 PM COT
*/

public interface AlmacenOperations 
{
  boolean guardarAlmacen (int id_almacen, String nombre, String telefono, String direccion, String ciudad);
  boolean actualizarAlmacen (int id_almacen, String nombre, String telefono, String direccion, String ciudad);
  boolean eliminarAlmacen (int id_almacen);
  String consultarAlmacen (int id_almacen);
  void shoutdown ();
} // interface AlmacenOperations
