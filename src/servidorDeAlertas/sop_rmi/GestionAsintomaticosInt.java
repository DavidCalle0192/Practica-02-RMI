
package servidorDeAlertas.sop_rmi;

import servidorDeAlertas.dto.ClsAsintomaticoDTO;
import java.rmi.Remote;
import java.rmi.RemoteException;


//Hereda de la clase Remote, lo cual la convierte en interfaz remota
public interface GestionAsintomaticosInt extends Remote
{
   
 public boolean registrarAsintomatico(ClsAsintomaticoDTO objAsintomatico) throws RemoteException;
 public ClsAsintomaticoDTO consultarAsintomatico(int id) throws RemoteException;
 public boolean enviarIndicador(int id, float ToC) throws RemoteException;

    
}


