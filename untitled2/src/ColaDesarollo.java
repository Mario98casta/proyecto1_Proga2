import java.util.ArrayList;

public class ColaDesarollo extends  ColaServicio{
    //constructor
    public ColaDesarollo() {
    }
    //array para guardar los objetos
    public  static ArrayList<Tiket> my_list = new ArrayList<>();
    //agregar tiket
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
//quitar ticket
    @Override
    public void QuitarTiket(int index) {

            my_list.remove(index);

    }



}
