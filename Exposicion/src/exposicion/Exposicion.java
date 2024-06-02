/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package exposicion;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author fasan
 */
public class Exposicion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese su nombre: ");
        String nombre = entrada.nextLine();
        System.out.println("Ingrese su edad: ");
        int edad = entrada.nextInt();
        //Validar la edad
        while (edad < 18) {
            System.out.println("Tiene que ser mayor de 18. Ingrese su edad: ");
            edad = entrada.nextInt();
        }
        System.out.println("Ingrese su ingreso mensual: ");
        int ingreso = entrada.nextInt();
        //Crear objeto persona
        Persona persona1 = new Persona(nombre,ingreso,edad);
        //Pedir el banco deseado por el usuario
        System.out.println("Bancos Disponibles: \n1) Ficohsa\n2) BAC\n3) Banco Atlantida");
        System.out.println("Ingrese su banco deseado: ");
        int bancoDeseado = entrada.nextInt();
        while (bancoDeseado<1||bancoDeseado>3) {
            System.out.println("Ingrese una opcion correcta: ");
            bancoDeseado = entrada.nextInt();
        }
        String bancoNombre = "";
        //Switch de string del banco
        switch (bancoDeseado) {
            case 1 -> {
                bancoNombre = "Ficohsa";
                break;
            }
            case 2 -> {
                bancoNombre = "BAC";
                break;
            }
            case 3 -> {
                bancoNombre = "Banco Atlantida";
                break;
            }
        }
        //Pedir el deposito inicial
        System.out.println("Ingrese cantidad de deposito inicial deseado: ");
        int depositoInicial = entrada.nextInt();
        while (depositoInicial<0) {
            System.out.println("Deposite una cantidad mayor a 0: ");
            depositoInicial = entrada.nextInt();
        }
        //Crear objeto del banco
        Banco banco = new Banco();
        banco.setNombreBanco(bancoNombre);
        banco.setMontoActual(depositoInicial);
        //Iniciar Menu
        //Inicializar opcion del menu
        int opcion;
        do {
            System.out.println("---Bienvenido a la App bancaria de "+banco.getNombreBanco()+"---");
            System.out.println("Opcion 1: Ver sus datos\nOpcion 2: Ver su monto actual");
            System.out.println("Opcion 3: Ver monto en dolares\nOpcion 4: Hacer deposito");
            System.out.println("Opcion 5: Hacer transferencia\nOpcion 6: Ver si es elegible para un prestamo\nOpcion 7: Salir");
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1-> {
                    System.out.println(persona1.toString());
                    System.out.println("\n\n");
                    break;
                }
                case 2 -> {
                    System.out.println("Su monto actual es: "+banco.getMontoActual()+" Lempiras\n\n");
                    break;
                }
                case 3 -> {
                    double dolares;
                    dolares = (double) banco.getMontoActual()/24.5;
                    System.out.println("Su monto actual: "+dolares+" Dolares\n\n");
                    break;
                }
                case 4 -> {
                    System.out.println("Cuanto desea depositar? ");
                    int depositoActual = entrada.nextInt();
                    banco.setMontoActual(banco.getMontoActual()+depositoActual);
                    System.out.println("\n\n");
                    break;
                }
                case 5 -> {
                    System.out.println("Transferencia a:\n1)Ficohsa\n2)BAC\n3)Banco Atlantida\nIngrese la opcion deseada: ");
                    int bancoTransferencia = entrada.nextInt();
                    while (bancoTransferencia<1||bancoTransferencia>3) {
                        System.out.println("Ingrese una opcion valida: ");
                        bancoTransferencia = entrada.nextInt();
                    }
                    //Crear nombre del banco a transferir
                    String bancoDestino = "";
                    switch (bancoTransferencia) {
                        case 1-> {
                            bancoDestino = "Ficohsa";
                            break;
                        }
                        case 2-> {
                            bancoDestino = "BAC";
                            break;
                        }
                        case 3-> {
                            bancoDestino = "Banco Atlantida";
                            break;
                        }
                        
                    }
                    //Pedir la cantidad a transferir
                    System.out.println("Ingrese el monto a transferir: ");
                    int transferir = entrada.nextInt();
                    while (transferir<0) {
                        System.out.println("Ingrese una opcion valida a transferir");
                        transferir = entrada.nextInt();
                    }
                    banco.hacerTransferencia(transferir, bancoDestino);
                    break;
                }
                //Sacar prestamo
                case 6-> {
                    banco.prestamo(persona1.getIngreso(), persona1.getEdad());
                    break;
                }
                case 7-> {
                    System.out.println("Ha salido de la aplicacion");
                    break;
                }
                default -> {
                    System.out.println("Ingrese una opcion valida");
                    break;
                }
            }
        } while (opcion!=7);
        
    }
    
}
