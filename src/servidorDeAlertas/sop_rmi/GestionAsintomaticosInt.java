
package servidorDeAlertas.sop_rmi;

import servidorDeAlertas.dto.ClsAsintomaticoDTO;
import java.rmi.Remote;
import java.rmi.RemoteException;


//Hereda de la clase Remote, lo cual la convierte en interfaz remota
public interface GestionAsintomaticosInt extends Remote
{
    //Definicion del primer método remoto
    public boolean registrarUsuario(int id, String tipo_id, String nombres, String apellidos, float temperatura) throws RemoteException;
    //cada definición del método debe especificar que puede lanzar la excepción java.rmi.RemoteException
    
    /*//Definicion del segundo método remoto
    public int consultarCantidadUsuarios() throws RemoteException; 
    //cada definición del método debe especificar que puede lanzar la excepción java.rmi.RemoteException
    */
    //Definicion del tercer método remoto
    public ClsAsintomaticoDTO consultarUsuario(int id)throws RemoteException;
     //cada definición del método debe especificar que puede lanzar la excepción java.rmi.RemoteException

    //public boolean registrarUsuario(String nombres, String apellidos, int numHabitacion, int edad);
    
}


