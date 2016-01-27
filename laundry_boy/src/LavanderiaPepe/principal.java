package LavanderiaPepe;

/**
 * Created by e-okcenter on 26/01/2016.
 */
public class principal {
    public static void main(String[] args){
        Servicios objeto1 = new Servicios();
        objeto1.elegirServicio();

        System.out.println(objeto1.dato_final_de_usuario);


    }
}
