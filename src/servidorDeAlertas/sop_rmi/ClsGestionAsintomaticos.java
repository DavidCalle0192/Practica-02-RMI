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
    public boolean registrarUsuario(int id, String tipo_id, String nombres, String apellidos, float temperatura) throws RemoteException
    {
        System.out.println("Entrando a registrar paciente");
        boolean bandera=false;
        
        if(misUsuarios.size() < 5)
        {
            ClsAsintomaticoDTO nuevo = new ClsAsintomaticoDTO(id,tipo_id,nombres,apellidos,temperatura);
            bandera=misUsuarios.add(nuevo);
            System.out.println("Tipo de id: " + tipo_id + ", Nombres: " + nombres + ", Apellidos: " +apellidos + ", Dirección: " +temperatura);
        }
        
        return bandera;
    }
    
    @Override
    public ClsAsintomaticoDTO consultarUsuario(int id) throws RemoteException {
        return this.misUsuarios.get(0);
    }
    /*
    @Override
    public boolean registrarUsuario(int identificacion, String nombres, String apellidos) throws RemoteException
    {
        System.out.println("Entrando a registrar usuario");
        boolean bandera=false;
        
        if(misUsuarios.size() < 5)
        {
            UsuarioDTO nuevo = new UsuarioDTO(identificacion,nombres,apellidos);
            bandera=misUsuarios.add(nuevo);
            System.out.println("Usuario registrado: identificación: " + identificacion + ", nombres: " + nombres + ", apellidos. " +apellidos );
        }
        
        return bandera;
    }
    /*
    @Override
    public int consultarCantidadUsuarios() throws RemoteException
    {
        System.out.println("Entrando a Cantidad");
        return misUsuarios.size();
    }*/

    
    public void consultarReferenciaRemotaDeNotificacion(String dir_Ip, int numPuerto)
    {
        System.out.println(" ");
        System.out.println("Desde consultarReferenciaRemotaDeNotificacion()...");
        objReferenciaRemotaNotificacion = (NotificacionesInt) UtilidadesRegistroC.obtenerObjRemoto(dir_Ip, numPuerto, "ObjetoRemotoNotificaciones");
    }
}
