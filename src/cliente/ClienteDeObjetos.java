package cliente;

import cliente.utilidades.UtilidadesRegistroC;
import cliente.utilidades.UtilidadesConsola;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import servidorDeAlertas.sop_rmi.GestionAsintomaticosInt;
import servidorDeAlertas.dto.ClsAsintomaticoDTO;

public class ClienteDeObjetos {

    //objeto remoto
    private static GestionAsintomaticosInt objRemoto;

    //para validar que el id del paciente no se repita
    private static ArrayList listadoId = new ArrayList();

    public static void main(String[] args) throws RemoteException {
        int numPuertoRMIRegistry = 0;
        String direccionIpRMIRegistry = "";

        System.out.println("Cual es el la dirección ip donde se encuentra  el rmiregistry ");
        direccionIpRMIRegistry = cliente.utilidades.UtilidadesConsola.leerCadena();
        System.out.println("Cual es el número de puerto por el cual escucha el rmiregistry ");
        numPuertoRMIRegistry = cliente.utilidades.UtilidadesConsola.leerEntero();

        objRemoto = (GestionAsintomaticosInt) UtilidadesRegistroC.obtenerObjRemoto(direccionIpRMIRegistry, numPuertoRMIRegistry, "ObjetoRemotoUsuarios");
        MenuPrincipal();

    }

    private static void MenuPrincipal() throws RemoteException {
                //lista de pacientes almacenada en un array
        //ArrayList listadoPacientes=new ArrayList();
        int aux = 0;//variable para validar la opción 2
        int aux2 = 0;//variable para controlar la cantidad de pacientes registrados
        int opcion = 0;
        ClsAsintomaticoDTO objAsintomatico = new ClsAsintomaticoDTO();
        do {
            System.out.println("========Menu=========");
            System.out.println("1. Registrar Paciente");
            System.out.println("2. Consultar Paciente");
            System.out.println("3. Enviar Indicador  ");
            System.out.println("4. Salir");

            opcion = UtilidadesConsola.leerEntero();

            switch (opcion) {
                case 1:
                    aux = 1;
                    if (aux2 == 5) {

                        System.out.println("La cantidad de pacientes registrados es 5");
                    } else {

                        System.out.println("Validando Existencia de un paciente con el mismo ID");
                        System.out.println("Ingrese el id: ");
                        Scanner leer = new Scanner(System.in);
                        int dni = leer.nextInt();
                        if (listadoId.contains(dni)) {
                            System.out.println("Existe un paciente con ese id!");
                            System.out.println();
                            System.out.println("Existe un paciente con ese id!");
                        } else {
                            listadoId.add(dni);
                            System.out.println("No existen pacientes con ese ID, se procedera a la creación del nuevo registro.");
                            Opcion1(dni,objAsintomatico);
                        }
                    }

                    aux2++;

                    break;
                case 2:
                    if (aux == 1) {
                        Opcion2(objAsintomatico);
                    } else {
                        System.out.println("No existen pacientes registrados.");
                    }

                    break;
                case 3:
                        if (aux == 1){
                        System.out.println("Ingrese la temperatura: ");
                        float temperatura = UtilidadesConsola.leerDecimal();
                        System.out.println("Temperatura registrada. ");
                        Opcion3(objAsintomatico.getId(),temperatura);
                        }else{
                            System.out.println("No existen pacientes registrados.");
                        }
                        

                    break;
                case 4:
                    System.out.println("Salir...");
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }

        } while (opcion != 4);
    }

    private static void Opcion1(int id,ClsAsintomaticoDTO objAsintomatico) throws RemoteException {

        
        System.out.println("==Registro del Paciente==");

        //SOLICITAR DATOS DEL PACIENTE
        //System.out.println("Ingrese el id del paciente");
        //int id = UtilidadesConsola.leerEntero();
        objAsintomatico.setId(id);

        System.out.println("Ingrese el tipo de id ");
        String tipo_id = UtilidadesConsola.leerCadena();
        objAsintomatico.setTipo_id(tipo_id);
        
        System.out.println("Ingrese el nombre del paciente ");
        String nombres = UtilidadesConsola.leerCadena();
        objAsintomatico.setNombres(nombres);

        System.out.println("Ingrese el apellido del paciente ");
        String apellidos = UtilidadesConsola.leerCadena();
        objAsintomatico.setApellidos(apellidos);
        
        System.out.println("Ingrese la dirección del paciente ");
        String direccion = UtilidadesConsola.leerCadena();
        objAsintomatico.setDireccion(direccion);

        boolean valor = objRemoto.registrarAsintomatico(objAsintomatico);
        if (valor) {
            System.out.println("Registro realizado satisfactoriamente...");
        } else {
            System.out.println("no se pudo realizar el registro...");
        }
    }

    private static void Opcion2(ClsAsintomaticoDTO objAsintomatico) {

        try {
            System.out.println("==Consulta de un Paciente==");
            System.out.println("Ingrese el id del paciente");
            int id = UtilidadesConsola.leerEntero();

            
            ClsAsintomaticoDTO objUsuario = objRemoto.consultarAsintomatico(id);
            if (objUsuario != null) {
                System.out.println("Tipo ID: " + objUsuario.getTipo_id());
                System.out.println("Nombres: " + objUsuario.getNombres());
                System.out.println("Apellidos: " + objUsuario.getApellidos());
                System.out.println("Dirección: " + objUsuario.getDireccion());

            } else {
                System.out.println("Usuario no encontrado");
            }
        } catch (RemoteException e) {
            System.out.println("La operacion no se pudo completar, intente nuevamente...");
        }
    }
    
     private static boolean Opcion3(int id, float ToC) throws RemoteException{
     

         System.out.println("Enviando id y temperatura del paciente");
         boolean objAsintomatico = objRemoto.enviarIndicador(id,ToC);
         return true;
         
     }
}
