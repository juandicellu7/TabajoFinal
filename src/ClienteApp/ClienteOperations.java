package ClienteApp;


/**
* ClienteApp/ClienteOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Cliente.idl
* viernes 2 de noviembre de 2018 11:25:11 AM COT
*/

public interface ClienteOperations 
{
  boolean guardarCliente (int id_cliente, String nombres, String apellidos, String numero_identificacion, String genero, String telefono, String ciudad);
  boolean actualizarCliente (int id_cliente, String nombres, String apellidos, String numero_identificacion, String genero, String telefono, String ciudad);
  boolean eliminarCliente (int id_cliente);
  String consultarCliente (int id_cliente);
  void shoutdown ();
} // interface ClienteOperations