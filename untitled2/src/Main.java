import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        ArrayList<Bitacora> bitacora = new ArrayList<>();
        ArrayList<Tiket> tiketes = new ArrayList<>();
        ColaMesa AMesa;
        AMesa = new ColaMesa();
        ColaSoporte Asoport;
        Asoport = new ColaSoporte();
        ColaDesarollo Adesa;
        Adesa = new ColaDesarollo();
        ColaAtendidos Atendidos;
        Atendidos = new ColaAtendidos();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        do {
            menu();
            try {
                opcion = scanner.nextInt();

            } catch (Exception e) {
                System.out.println("Ingrese Numeros");
                scanner = new Scanner(System.in);
                opcion = 10000000;
            }

            switch (opcion) {
                case 1: {
                    int nitus = 0;
                    String Nusuario;
                    scanner.nextLine();
                    do {

                        System.out.println("creando Ticket");
                        System.out.println("Ingrese nit de usario creador de Ticket");
                        Nusuario = scanner.nextLine();
                        nitus = Nusuario.length();
                        //validamos que el nit no contenga letras con un for recoriendo el string
                        for (int i = 0; i < Nusuario.length(); i++) {
                            char c = Nusuario.charAt(i);
                            //con este if valido que solo sean numeros 0123456789
                            if (!(c >= '0' && c <= '9')) {
                                //si ingresa aqui cambia
                                nitus = 10;
                            }
                        }//fin de for
                        if (nitus != 6) {
                            System.out.println("El nit es invalido .");
                            System.out.println("El nit debe  contener 6 digitos ");
                        }
                    } while (nitus != 6);
                    System.out.println("Ingrese  su problema");
                    String suproblema = scanner.nextLine();
                    Tiket tiket = new Tiket(Nusuario, suproblema);
                    //creando datos para cola de servicio
                    tiketes.add(tiket);
                    System.out.println("Su tiket ha sido creado:");
                    System.out.println(tiket);
                    //creando datos para vitacora
                    Bitacora bit = new Bitacora(tiket);
                    bitacora.add(bit);
                    System.out.println("Asignando Ticket: ");
                    tiket.setEstado("Asignado ");
                    System.out.println(tiket);
                    Bitacora bit2 = new Bitacora(tiket);
                    bitacora.add(bit2);
                    bit2.setEvento(TipoEvento.Asignar);
                    AMesa.AgregarTiket(tiket);

                }
                break;
                case 2:

                    int opcionm = 0;
                    do {
                        menum();
                        try {
                            opcionm = scanner.nextInt();

                        } catch (Exception e) {
                            System.out.println("Opcion Invalida");
                            scanner = new Scanner(System.in);
                            opcionm = 10000000;
                        }
                        switch (opcionm) {
                            case 1:
                                if (!ColaMesa.ColaMe.isEmpty()) {
                                    int go = 0;
                                    int TAMA = ColaMesa.ColaMe.size();
                                    System.out.println("Tickets en espera: " + TAMA);
                                    Tiket nuvoT = ColaMesa.ColaMe.peek();
                                    System.out.println("Ticket a trabajar: " + nuvoT.toString());

                                    do {
                                        System.out.println("Ingrese Opcion: ");
                                        System.out.println("1.Solucionar ");
                                        System.out.println("2.Tranferir a Soporte Tecnico");
                                        try {
                                            go = scanner.nextInt();

                                        } catch (Exception e) {
                                            System.out.println("Opcion Invalida");
                                            scanner = new Scanner(System.in);

                                        }
                                    } while (go != 2 & go != 1);
                                    if (go == 1) {

                                        System.out.println("el tiket a sido solucionado.");
                                        nuvoT.setEstado("solucionado");
                                        Atendidos.AgregarTiket(nuvoT);
                                        Bitacora bit3 = new Bitacora(nuvoT);
                                        bitacora.add(bit3);
                                        bit3.setEvento(TipoEvento.solucion);
                                        AMesa.QuitarTiket();

                                    } else {
                                        System.out.println("Su tiket a sido reasignado Soporte tecnico");
                                        Asoport.AgregarTiket(nuvoT);
                                        Bitacora bit4 = new Bitacora(nuvoT);
                                        bitacora.add(bit4);
                                        bit4.setEvento(TipoEvento.mover);
                                        AMesa.QuitarTiket();


                                    }
                                } else {
                                    System.out.println("la mesa no tiene tickes a solucionar");
                                }//fin de while si esta vacia
                                break;
                            case 2:
                                if (!ColaSoporte.PilaSo.isEmpty()) {
                                    int go = 0;
                                    int TAMA = ColaSoporte.PilaSo.size();
                                    System.out.println("Tickets en espera: " + TAMA);
                                    Tiket nuvoT = ColaSoporte.PilaSo.peek();
                                    System.out.println("Ticket a trabajar: " + nuvoT.toString());

                                    do {
                                        System.out.println("Ingrese Opcion: ");
                                        System.out.println("1.Solucionar ");
                                        System.out.println("2.Tranferir a Desarrollador");
                                        try {
                                            go = scanner.nextInt();

                                        } catch (Exception e) {
                                            System.out.println("Opcion Invalida");
                                            scanner = new Scanner(System.in);

                                        }
                                    } while (go != 2 & go != 1);
                                    if (go == 1) {
                                        System.out.println("El tiket a sido solucionado.");
                                        nuvoT.setEstado("Solucionado");
                                        Atendidos.AgregarTiket(nuvoT);
                                        Bitacora bit5 = new Bitacora(nuvoT);
                                        bitacora.add(bit5);
                                        bit5.setEvento(TipoEvento.solucion);
                                        Asoport.QuitarTiket();

                                    } else {
                                        System.out.println("Su tiket a sido reasignado Desarrolador");
                                        Adesa.AgregarTiket(nuvoT);
                                        Bitacora bit6 = new Bitacora(nuvoT);
                                        bitacora.add(bit6);
                                        bit6.setEvento(TipoEvento.mover);
                                        Asoport.QuitarTiket();

                                    }
                                } else {
                                    System.out.println("Soporte no tiene tickes a solucionar");
                                }//fin de while si esta vacia


                                break;
                            case 3:
                                if (!ColaDesarollo.my_list.isEmpty()) {
                                    int go = 0;
                                    int TAMA = ColaDesarollo.my_list.size();
                                    System.out.println("Tickets en Espera: " + TAMA);
                                    int index = (int)(Math.random() * ColaDesarollo.my_list.size());
                                    Tiket nuvoT = ColaDesarollo.my_list.get(index);
                                    System.out.println("Ticket a Trabajar: " + nuvoT.toString());

                                    do {
                                        System.out.println("1.Solucionar ");

                                        try {
                                            go = scanner.nextInt();

                                        } catch (Exception e) {
                                            System.out.println("Opcion Invalida");
                                            System.out.println("El Progamador debe de dar una Solucion:");
                                            scanner = new Scanner(System.in);

                                        }
                                    } while (go != 1);

                                        System.out.println("El tiket a sido solucionado.");
                                        nuvoT.setEstado("solucionado");
                                        Atendidos.AgregarTiket(nuvoT);
                                        Bitacora bit7 = new Bitacora(nuvoT);
                                        bitacora.add(bit7);
                                        bit7.setEvento(TipoEvento.solucion);
                                        Adesa.QuitarTiket();


                                } else {
                                    System.out.println("Desarrollo no tiene tickes a solucionar");
                                }//fin de while si esta vacia


                                break;
                            case 4:
                                opcionm = 0;
                                break;
                            case 5:
                                JsonParser parser;
                                parser = new JsonParser();
                                try  {
                                    Object obj  =parser.parse(new FileReader("informacion.json")) ;
                                    JsonObject jsonObject;
                                    jsonObject = (JsonObject) obj;
                                    System.out.println("json leido"+jsonObject);
                                }catch (FileNotFoundException e){ }
                                catch (IOException e){ }


                                  /*JsonObject ob = (JsonObject) new JsonParser().parse(new FileReader("C:\\Users\\Fernando\\OneDrive\\Escritorio\\prograll\\proyecto\\informacion.json"));
                                    //JsonObject js = (JsonObject) ob;
                                    //String firstName = (String)js.toString();

                                   */

                                break;
                            default:
                                System.out.println("Opcion invalida");

                        }

                    } while (opcionm != 0);

                    break;
                case 3:
                    System.out.println("Tickets:");
                    for (Tiket R : tiketes) {
                        System.out.println(R.toString());
                    }

                    break;
                case 4:

                    System.out.println("Bitacora:");
                    for (Bitacora e : bitacora) {
                        System.out.println(e.toString());
                    }
                    break;
                case 5:
                    opcion = 0;
                default:
                    System.out.println("opcion invalida");
            }//fin de switch
        } while (opcion != 0);


    }

    private static void menu() {
        System.out.println("Sistema de manejo de ticket");
        System.out.println("1. Crear ticket");
        System.out.println("2. Solucionar Tiket");
        System.out.println("3. imprimir Tickets");
        System.out.println("4. imprimir Bitacora");
        System.out.println("5. salir ");
        System.out.println(" ingrese Opcion: ");
    }

    private static void menum() {
        System.out.println("Atender tickets");
        System.out.println("1. cola mesa");
        System.out.println("2. Cola Soporte");
        System.out.println("3. cola Desarrollador");
        System.out.println("4. Regresar a menu principal");
    }
}