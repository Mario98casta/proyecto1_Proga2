import java.util.LinkedList;
import java.util.Queue;

public class ColaMesa extends ColaServicio{
    public ColaMesa() {
    }

   public static Queue<Tiket> ColaMe = new LinkedList<>();

    @Override
    public void AgregarTiket(Tiket tickets) {
        System.out.println("Agregando Ticket a cola Mesa");
        ColaMe.add(tickets);
        System.out.println("Agregado a Mesa");
        System.out.println("Tickes en Cola: "+ColaMe.size());
        /*for (Tiket t:ColaMe){
           t.getId();
            System.out.println(t.toString()+"\n tiket "+ (t.getId()-1)+" Agregado a Mesa");
        }

         */

    }

    @Override
    public void QuitarTiket() {

       ColaMe.poll();
    }

    @Override
    public void QuitarTiket(int index) {

    }


}
