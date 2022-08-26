import java.util.Stack;

public class ColaSoporte extends ColaServicio{
    //constructor
    public ColaSoporte() {
    }
    //pila
    public static Stack<Tiket> PilaSo = new Stack<>();
    //agregar tiket
    @Override
    public void AgregarTiket(Tiket tickets) {
        System.out.println("Agregando ticket a cola Soporte");
        PilaSo.push(tickets);
        System.out.println("Agregado a Soporte");
        System.out.println("tickes en Cola: "+PilaSo.size());
    }
        //quitar tiket
    @Override
    public void QuitarTiket() {

        PilaSo.pop();
    }

    @Override
    public void QuitarTiket(int index) {

    }


}
