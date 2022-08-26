import java.util.ArrayList;
/*
cola donde entraran todos los tikets atendidos.
 */
public class ColaAtendidos extends ColaServicio{
    //constructor
    public ColaAtendidos() {
    }
    //el array list donde se ejecutara
    ArrayList<Tiket> Tiketes = new ArrayList<>();
    //metodo eredado por la clase padre
    @Override
    public void AgregarTiket(Tiket tickets) {
        System.out.println("tickets atendidos");
        Tiketes.add(tickets);
        System.out.println(Tiketes.size());
        for (Tiket t:Tiketes){
            System.out.println(t.toString());
        }
    }
    //metodo heredado por la clase padre

    @Override
    public void QuitarTiket(int index) {

    }

}
