package LavanderiaPepe;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Created by e-okcenter on 26/01/2016.
 */
public class Servicios {



   // boolean Delimitador;
    String servicio_seleccionado,dato_final_de_usuario,fechaFyF,fechaPedido_formateado;//fecha formateada y final mas dato final de usuario
    int speed_service,type_of_service,precio_unitario,precio_agregado,precio_total;
    Scanner entrada = new Scanner(System.in);
    Calendar fecha_actual = GregorianCalendar.getInstance();
    Date tiempo_de_pedido,tiempo_de_entrega;
    DateFormat convertirDtoString = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");



    public void elegirServicio(){
                    System.out.println("Elige una de estas opciones para brindarte tu servicio preferido\n ");
                 System.out.println("Servicio de Lavado --> precio : 40 pesos (presione el numero 1)\n " + "Servicio de Planchado --> precio : 50 pesos (presione el numero 2)\n " + "Servicio de Lavado y Planchado --> precio : 90 pesos (presione el numero 3)\n " );
                type_of_service = entrada.nextInt();
                    System.out.println("Servicio normal(tres dias aproximadamente) presione 1\n" + "Servicio Express(Un dia aproximadamente) presione 2");
                speed_service = entrada.nextInt();
                tiempo_de_pedido = fecha_actual.getTime();//saco la fecha de pedido


        switch (type_of_service){
            case 1:
                servicio_seleccionado = "Ha seleccionado el servicio de lavado ";
                precio_unitario = 40;
            case 2:
                servicio_seleccionado = "Ha seleccionado el servicio de planchado";
                precio_unitario = 50;
            case 3:
                servicio_seleccionado =  "Ha seleccionado el servicio de lavado y planchado";
                precio_unitario = 90;
            default:
                System.out.println("Por favor debe elegir un numero valido");
        }

        if(speed_service == 1){
            System.out.println("Ha elegido El servicio normal");
            //lo dejo como referencia pero no hay suma alguna aqui
            precio_agregado = 0;
            precio_total = precio_unitario + precio_agregado;
            tiempo_de_entrega=fechaDeEntrega(tiempo_de_pedido, 3);
            fechaPedido_formateado = convertirDtoString.format(tiempo_de_pedido);
            fechaFyF = convertirDtoString.format(tiempo_de_entrega);
            dato_final_de_usuario = servicio_seleccionado + "con un costo de\n" + precio_unitario +"\nLo eligio el dia: "+fechaPedido_formateado + "\n para entregar el: " + fechaFyF;




        }
        else if (speed_service==2){
            System.out.println("Ha elegido el servicio express");
            precio_agregado = 50;
            precio_total = precio_unitario + precio_agregado;
            tiempo_de_entrega=fechaDeEntrega(tiempo_de_pedido, 1);
            fechaPedido_formateado = convertirDtoString.format(tiempo_de_pedido);
            fechaFyF = convertirDtoString.format(tiempo_de_entrega);
            dato_final_de_usuario = servicio_seleccionado + "con un costo de\n" + precio_unitario + "\nademas ha elegido el servicio express con un total de \n " + precio_total +"\nLo eligio el dia: "+fechaPedido_formateado + "\n para entregar el: " + fechaFyF;



        }



    }

    public Date fechaDeEntrega(Date entrada, int dias){
        Calendar fechadellegada = Calendar.getInstance();
        fechadellegada.setTime(entrada);
        fechadellegada.add(Calendar.DAY_OF_YEAR,dias);
        return fechadellegada.getTime();
    }
}
