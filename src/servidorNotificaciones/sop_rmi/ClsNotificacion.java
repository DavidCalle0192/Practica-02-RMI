/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servidorNotificaciones.sop_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import servidorNotificaciones.dto.ClsMensajeNotificacionDTO;

/**
 *
 * @author JhonMZ
 */
public class ClsNotificacion extends UnicastRemoteObject implements NotificacionesInt{

    public ClsNotificacion() throws RemoteException {
        super();
    }

    
    
    @Override
    public void notificarRegistro(ClsMensajeNotificacionDTO objNotificacion) throws RemoteException {
        System.out.println("El paciente con identificación "+objNotificacion.getId()+
                " presenta una ToC de " +objNotificacion.getToC()+" la cual esta fuera del rango normal");
    }
    
}
