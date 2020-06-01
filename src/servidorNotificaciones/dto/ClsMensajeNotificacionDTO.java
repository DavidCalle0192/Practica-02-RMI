/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servidorNotificaciones.dto;

import java.io.Serializable;

/**
 *
 * @author JhonMZ
 */
public class ClsMensajeNotificacionDTO implements Serializable{
    private int id;
    private float ToC;

    public ClsMensajeNotificacionDTO(int id, float ToC) {
        this.id = id;
        this.ToC = ToC;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getToC() {
        return ToC;
    }

    public void setToC(float ToC) {
        this.ToC = ToC;
    }
    
    
}
