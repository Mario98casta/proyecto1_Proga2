import java.time.LocalDate;
import java.time.LocalTime;
/*
clase donde gaurdare todos los cambios que se le apliquen alos tikets
 */
public class Bitacora {

    String nitSoporte;
    LocalDate FechaAc;
    LocalTime HoraAc;
    String mensaje;
    TipoEvento evento;
//construtores
    public Bitacora(String nitSoporte, String mensaje, TipoEvento eve) {
        this.nitSoporte = nitSoporte;
        this.mensaje = mensaje;
        this.evento=eve;
    }

    public Bitacora(Tiket tiket) {
        this.nitSoporte=tiket.getNitUsuario();
        this.mensaje= tiket.getProblema();
       this.FechaAc= LocalDate.now();
       this.HoraAc= LocalTime.now();
        this.evento= TipoEvento.Crear;
    }
//metodos setters y getters
    public String getNitSoporte() {
        return nitSoporte;
    }

    public void setNitSoporte(String nitSoporte) {
        this.nitSoporte = nitSoporte;
    }

    public LocalDate getFechaAc() {
        return FechaAc;
    }

    public void setFechaAc(LocalDate fechaAc) {
        FechaAc = fechaAc;
    }

    public LocalTime getHoraAc() {
        return HoraAc;
    }

    public void setHoraAc(LocalTime horaAc) {
        HoraAc = horaAc;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public TipoEvento getEvento() {
        return evento;
    }

    public void setEvento(TipoEvento evento) {
        this.evento = evento;
    }
//tostring para imprimir en consola
    @Override
    public String toString() {
        return "------------------------------------------------------------------------------------------------------------------------------------"+
                "\n *   *   *   *   *   *   *   *   *   *   *   *   * Bitacora *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *" +
                "\n itSoporte:" + nitSoporte +
                "\n Fecha: " + FechaAc +
                "\n Hora: " + HoraAc +
                "\n mensaje: " + mensaje +
                "\n evento: " + evento +
                "\n------------------------------------------------------------------------------------------------------------------------------------";

    }
}
