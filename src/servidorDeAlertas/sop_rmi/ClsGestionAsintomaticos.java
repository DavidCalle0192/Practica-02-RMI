package servidorDeAlertas.sop_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import servidorDeAlertas.dto.ClsAsintomaticoDTO;
/*/*
Clase que implementa la interface remota GestorUsuariosInt
*/

public class ClsGestionAsintomaticos extends UnicastRemoteObject implements GestionAsintomaticosInt
{  
    private ArrayList<ClsAsintomaticoDTO> misUsuarios;

    public ClsGestionAsintomaticos() throws RemoteException
    {
        super(); //invoca al constructor de la clase base       
        this.misUsuarios = new ArrayList();
    }
 

    @Override
    public boolean registrarAsintomatico(ClsAsintomaticoDTO objAsintomatico) throws RemoteException {
    
        System.out.println("Entrando a registrar paciente");
        boolean bandera=false;
        
        if(misUsuarios.size() < 5)
        {
            //ClsAsintomaticoDTO nuevo = new ClsAsintomaticoDTO();
            bandera=misUsuarios.add(objAsintomatico);
            System.out.println("Tipo de id: " + objAsintomatico.getTipo_id() + ", Nombres: " + objAsintomatico.getNombres() + ", Apellidos: " +objAsintomatico.getApellidos());
        }
        
        return bandera;
    }

    @Override
    public ClsAsintomaticoDTO consultarAsintomatico(int id) throws RemoteException {
    
        return this.misUsuarios.get(id);
    }

    @Override
    public boolean enviarIndicador(int id, float ToC) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
       
}
