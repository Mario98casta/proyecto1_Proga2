public class Tiket {
   public String NitUsuario;
    private static int id=1;
   public int Id ;
    public String Problema;
   public String Estado;


//creo constructor de tiket
    public Tiket(String nitUsuario, String problema) {
        this.NitUsuario = nitUsuario;
        this.Id = id;
        id++;
        this.Problema = problema;
        this.Estado ="Creado";
    }

    public String getNitUsuario() {
        return NitUsuario;
    }

    public void setNitUsuario(String nitUsuario) {
        NitUsuario = nitUsuario;
    }

    public String getProblema() {
        return Problema;
    }

    public void setProblema(String problema) {
        Problema = problema;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Tiket.id = id;
    }

    @Override
    public String toString() {
         String idimprimir = "";
        if (Id<100){
            idimprimir=("0000"+Id);
            if (Id<10){
                idimprimir=("00000"+Id);
            }
        }


        return "------------------------------------------------------------------------------------------------------------------------------------"+
                "\n Tiket:      " + idimprimir +
                "\n NitUsuario: " + NitUsuario  +
                "\n Problema:   " + Problema +
                "\n Estado:     " + Estado+
                "\n------------------------------------------------------------------------------------------------------------------------------------";
    }
}
