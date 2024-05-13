package usuarios.empleados;

import banco.Banco;
import banco.Sucursal;
import usuarios.Inversionista;
import usuarios.Usuario;
import usuarios.utils.Rol;

import java.util.ArrayList;
import java.util.Scanner;

    public class GerenteSucursal extends Usuario {

        String userName;
        String contasena;
        public GerenteSucursal(String userName, String contrasena, String nombre, String apellidoMaterno, String apellidoPaterno, String fechaDeNacimiento, String ciudad, String estado, String curp, String direccion, String RFC, double salario, Rol rol, Sucursal sucursal, String sexo) {
            super(nombre, apellidoMaterno, apellidoPaterno, fechaDeNacimiento, ciudad, estado, curp, direccion, RFC, salario, Rol.GERENTE_SUCURSAL, sucursal, sexo, userName, contrasena);
            this.userName= userName;
            this.contasena = contrasena;
        }

        public static void generarClaveSeguridad(Usuario usuarioActual) {
            Scanner leer = new Scanner(System.in);

            if (usuarioActual.getRol() != Rol.GERENTE_SUCURSAL) {
                System.out.println("Acceso denegado. Usuario no admitido");
                return;
            }else{

                System.out.println("\n----- G E N E R A CI O N   D E   C L A V E   D E   S E G U R I D A D   P A R A   E L   I N V E R S I O N I S T A -----");
                System.out.println("Ingrese el RFC del inversionista:");
                String buscarRFC = leer.nextLine();

                if (usuarioActual.getSucursal().equals(Sucursal.ACUEDUCTO)) {
                    ArrayList<Usuario> inversionistasAcueducto = Banco.usuariosAcueducto.get(Rol.INVERSIONISTA);
                    for (Usuario inversionista : inversionistasAcueducto) {
                        if (inversionista.getRFC().equals(buscarRFC)) {
                            System.out.println("\nClave de seguridad:");
                            String nuevaClave = leer.nextLine();

                            Inversionista newInversionista = (Inversionista) inversionista;
                            newInversionista.setLlaveSeguridad(nuevaClave);

                            System.out.println("Se asigno la clave de seguridad");
                            return;
                        }
                    }
                } else if (usuarioActual.getSucursal().equals(Sucursal.MADERO)) {
                    ArrayList<Usuario> inversionistasMadero = Banco.usuariosMadero.get(Rol.INVERSIONISTA);
                    for (Usuario inversionista : inversionistasMadero) {
                        if (inversionista.getRFC().equals(buscarRFC)) {
                            System.out.println("\nClave de seguridad:");
                            String nuevaClave = leer.nextLine();

                            Inversionista newInversionista = (Inversionista) inversionista;
                            newInversionista.setLlaveSeguridad(nuevaClave);


                            System.out.println("Se asigno la clave de seguridad");
                            return;
                        }
                    }
                }
                System.out.println("\nUsuario no encontrado.");
            }
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getContasena() {
            return contasena;
        }

        public void setContasena(String contasena) {
            this.contasena = contasena;
        }


    }
