package tarjetas;

import banco.Banco;
import usuarios.Cliente;
import tarjetas.utils.EstadoSolicitud;
import tarjetas.utils.TipoTarjetaCredito;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class SolicitudTarjeta {
    private Cliente clienteSolicitando;
    private TipoTarjetaCredito tipoTarjeta;
    private EstadoSolicitud status;
    LocalDateTime fechaDeSolicitud;
    int idSolicitud ;
    private static int ID_SOLICITUD;

    static ArrayList<SolicitudTarjeta> listaSolicitudes;

    public SolicitudTarjeta(Cliente clienteSolicitando, TipoTarjetaCredito tipoTarjeta, EstadoSolicitud status, LocalDateTime fechaDeSolicitud) {
        this.clienteSolicitando = clienteSolicitando;
        this.tipoTarjeta = tipoTarjeta;
        this.status = status;
        this.fechaDeSolicitud = fechaDeSolicitud;
        this.idSolicitud = ID_SOLICITUD;
        ID_SOLICITUD++;
    }
    public static void mostrarListaSolicitudes(){
        for (SolicitudTarjeta solicitud : Banco.listaSolicitudes) {
            System.out.println("\nNum. de solicitud: " + solicitud.getIdSolicitud());
            System.out.println("Nombre del solicitante: " + solicitud.getClienteSolicitando().getNombre());
            System.out.println("Su tarjeta es de tipo: " + solicitud.getTipoTarjeta());
            System.out.println("Status de la tarjeta: " + solicitud.getStatus());
            System.out.println("La tarjeta se solicito: " + solicitud.getFechaHoraFormateada());
            System.out.println();
        }
    }
    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setStatus(EstadoSolicitud status) {
        this.status = status;
    }

    public Cliente getClienteSolicitando() {
        return clienteSolicitando;
    }

    public TipoTarjetaCredito getTipoTarjeta() {
        return tipoTarjeta;
    }

    public EstadoSolicitud getStatus() {
        return status;
    }

    public LocalDateTime getFechaDeSolicitud() {
        return fechaDeSolicitud;
    }

    public String getFechaHoraFormateada() {
        DateTimeFormatter formatterFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        String fechaFormateada = fechaDeSolicitud.format(formatterFecha);
        String horaFormateada = fechaDeSolicitud.format(formatterHora);

        String fechaHoraBonita = String.format("%s a las %s", fechaFormateada, horaFormateada);

        return fechaHoraBonita;
    }

}
