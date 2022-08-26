import java.util.Stack;

public class ColaSoporte extends ColaServicio{
    public ColaSoporte() {
    }
    public static Stack<Tiket> PilaSo = new Stack<>();
    @Override
    public void AgregarTiket(Tiket tickets) {
        System.out.println("Agregando ticket a cola Soporte");
        PilaSo.push(tickets);
        System.out.println("Agregado a Soporte");
        System.out.println("tickes en Cola: "+PilaSo.size());

       /* for (Tiket t:PilaSo){
            System.out.println(t.toString()+"\n Agregado a Soporte");
        }

        */

    }

    @Override
    public void QuitarTiket() {

        PilaSo.pop();
    }

    @Override
    public void QuitarTiket(int index) {

    }


}
