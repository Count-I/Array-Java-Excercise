import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Persona[] personas=null;
        String Icontinue="si";
        int nPersonas;
        int pos=0;
        do {

            int option = elegirOperacion();
            switch (option) {
                case 1:
                    nPersonas=(int) pedirDoubleData("Cuantas personas desea registrar");
                    personas=new Persona[nPersonas];
                    for(int i=0;i<nPersonas;i++){
                        personas[i]= registrarPersona();
                        personas[i].setImc(
                                IMC.calcularImc(personas[i].getPeso(),personas[i].getTalla()));
                        personas[i].setEstado(
                                IMC.estadoImc(personas[i].getImc()));
                    }

                    break;
                case 2:
                    String name = pedirStringData("Ingrese el nombre de la persona que desea buscar");
                    for(int i=0;i<personas.length;i++){
                        if(personas[i].getNombre().equalsIgnoreCase(name)){
                            System.out.println("\nNombre: " + personas[i].getNombre() +
                                    "\nTalla: " + personas[i].getTalla()+
                                    "\nPeso: " + personas[i].getPeso()+
                                    "\nIMC: " + personas[i].getImc()

                            );
                        }
            }
                    break;
                case 3:
                    for(int i=0;i<personas.length;i++){
                        System.out.println("Estado: " + personas[i].getEstado() +
                                "\nNombre: " + personas[i].getNombre() +
                                "\nTalla: " + personas[i].getTalla()+
                                "\nPeso: " + personas[i].getPeso()+
                                "\nIMC: " + personas[i].getImc()
                        );
                    }

                    break;
                case 4:actualizarPersona(personas,pedirStringData("Ingrese el nombre de la persona"));
                case 5:System.out.println("Gracias por su visita");
                    Icontinue="no";
                    break;
                default:
                    System.out.println("something went wrong");
                    break;
            }
            pos++;
        }while(Icontinue.equalsIgnoreCase("si"));
    }
    public static int elegirOperacion(){
        String menu;
        menu="  Operaciones \n\nDigite el número de la operación que desee realizar\n";
        menu+="1: Registrar nueva persona \n";
        menu+="2: Buscar persona \n";
        menu+="3: Imprimir lista de personas \n";
        menu+="4: Actualizar persona \n";
        menu+="5: Salir \n";
        return Integer.parseInt(JOptionPane.showInputDialog(menu));
    }
    public static Persona registrarPersona(){
        return new Persona(pedirStringData("Ingrese el nombre de la persona"),
                pedirDoubleData("Ingrese el peso de la persona"),
                pedirDoubleData("Ingrese la talla de la persona"));
    }

    public static void actualizarPersona(Persona[] personas,String nombre){
        Persona persona = null;
        for(int i=0;i<personas.length;i++) {
            if (personas[i].getNombre().equalsIgnoreCase(nombre)) {
                persona = personas[i];
            }
        }
        switch (updateMenuOptions()){
            case 1:persona.setNombre(pedirStringData("ingrese el nuevo nombre de la persona"));
            case 2:persona.setPeso(pedirDoubleData("ingrese el nuevo peso"));
            case 3:persona.setTalla(pedirDoubleData("ingrese la nueva talla"));
            case 4:elegirOperacion();
        }

    }
    public static int updateMenuOptions(){
        String menu;
        menu="  IMC actualizar persona\n\nDigite el número de la operación que desee realizar\n";
        menu+="1: Cambiar nombre \n";
        menu+="2: Cambiar peso \n";
        menu+="3: Cambiar talla \n";
        menu+="4: Salir \n";
        return Integer.parseInt(JOptionPane.showInputDialog(menu));
    }
    public static String pedirStringData(String message){
        String data="";
        do{
            data = JOptionPane.showInputDialog(message);
            if(data.isBlank() || data.isEmpty() || data == null){
                JOptionPane.showMessageDialog(null,"Ingrese un dato valido");
            }
        }while(data.isBlank() || data.isEmpty() || data == null);
        return data;
    }
    public static double pedirDoubleData(String message){
        double data=0;
        do{
            data = Double.parseDouble(JOptionPane.showInputDialog(message));
            if(data<=0){
                JOptionPane.showMessageDialog(null,"Ingrese un dato valido");
            }
        }while(data<=0);
        return data;
    }
}