package servidorDeAlertas.sop_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import servidorDeAlertas.dto.ClsAsintomaticoDTO;
import servidorDeAlertas.utilidades.UtilidadesRegistroC;
import servidorNotificaciones.sop_rmi.NotificacionesInt;
/*/*
Clase que implementa la interface remota GestorUsuariosInt
*/

public class ClsGestionAsintomaticos extends UnicastRemoteObject implements GestionAsintomaticosInt
{  
    private ArrayList<ClsAsintomaticoDTO> misUsuarios;
    private NotificacionesInt objReferenciaRemotaNotificacion;
    
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
        ClsAsintomaticoDTO objAsintomatico = null;
        for (ClsAsintomaticoDTO clsAsintomaticoDTO : misUsuarios) {
            if(clsAsintomaticoDTO.getId() == id){
                objAsintomatico = clsAsintomaticoDTO;
                break;
            }
        }
        return objAsintomatico;
    }

    @Override
    public boolean enviarIndicador(int id, float ToC) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void consultarReferenciaRemotaDeNotificacion(String dir_Ip, int numPuerto)
    {
        System.out.println(" ");
        System.out.println("Desde consultarReferenciaRemotaDeNotificacion()...");
        objReferenciaRemotaNotificacion = (NotificacionesInt) UtilidadesRegistroC.obtenerObjRemoto(dir_Ip, numPuerto, "ObjetoRemotoNotificaciones");
    }
}
