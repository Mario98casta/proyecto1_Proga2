public abstract class ColaServicio {
    TipoCola Colas;
//clase padre
    public ColaServicio() {
    }
//metoos a heredar
    public void AgregarTiket(Tiket tickets){
       // tikets.add(tickets);


    }

    public void QuitarTiket(){
       // tikets.remove(tikets.size()-1);
    }


    public abstract void QuitarTiket(int index);
}
