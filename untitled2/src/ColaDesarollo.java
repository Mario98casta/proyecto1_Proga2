import java.util.ArrayList;

public class ColaDesarollo extends  ColaServicio{
    public ColaDesarollo() {
    }
    public  static ArrayList<Tiket> my_list = new ArrayList<>();
    @Override
    public void AgregarTiket(Tiket tickets) {
        System.out.println("Agregando ticket a cola Desarrollo");
        my_list.add(tickets);
        System.out.println("Agregado a Desarrolo");
        System.out.println("tickes en Cola: "+my_list.size());
       /* for (Tiket t:my_list){
            System.out.println(t.toString()+"\n Agregado a Desarrollo");
        }
        */
    }

    @Override
    public void QuitarTiket(int index) {

            my_list.remove(index);

    }



}
