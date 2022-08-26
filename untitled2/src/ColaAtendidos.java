import java.util.ArrayList;

public class ColaAtendidos extends ColaServicio{
    public ColaAtendidos() {
    }
    ArrayList<Tiket> Tiketes = new ArrayList<>();
    @Override
    public void AgregarTiket(Tiket tickets) {
        System.out.println("tickets atendidos");
        Tiketes.add(tickets);
        System.out.println(Tiketes.size());
        for (Tiket t:Tiketes){
            System.out.println(t.toString());
        }
    }

    @Override
    public void QuitarTiket(int index) {

    }

}
