/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exposicion;

/**
 *
 * @author fasan
 */
public class Banco {
    
    private String nombreBanco;
    private int montoActual;
    
    public Banco() {
        
    }
    public Banco (String nombreBanco, int montoActual) {
        this.nombreBanco = nombreBanco;
        this.montoActual = montoActual;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public int getMontoActual() {
        return montoActual;
    }

    public void setMontoActual(int montoActual) {
        this.montoActual = montoActual;
    }
    
    public void hacerTransferencia(int montoTransferir, String bancoDestino) {
        if (montoTransferir > getMontoActual()) {
            System.out.println("No puede hacer transferencia de este monto\n\n");
        }
        else {
            //Ver si tienen el mismo banco
            if (bancoDestino.equalsIgnoreCase(getNombreBanco())) {
                System.out.println("No se le cobrara extra por transferencia del mismo banco");
                setMontoActual(getMontoActual()-montoTransferir);
                System.out.println("Transferencia completada\n\n");
            }
            else {
                System.out.println("Se le cobrara 50 Lempiras por transferencias a bancos externos");
                //Validar que tenga lo suficiente para transferir con el interes
                if (montoTransferir+50>getMontoActual()) {
                    System.out.println("No tiene el monto necesario para hacer esta transferencia\n\n");
                }
                else {
                    setMontoActual(getMontoActual()-montoTransferir-50);
                    System.out.println("Transferencia completada\n\n");
                }
            }
        }
    }
    
    public void prestamo(int ingreso, int edad) {
      
        if ((ingreso <15000&&ingreso>=7500) &&(edad >21)) {
            System.out.println("Es elegible para un prestamo de 50000 Lempiras\n\n");
        }
        else if((ingreso >=15000&&ingreso<60000)&&(edad>25)) {
            System.out.println("Es elegible para un prestamo de 200000 Lempiras\n\n");
        }
        else if ((ingreso>=60000&&ingreso<250000)&&(edad>27)) {
            System.out.println("Es elegible para un prestamo de 4500000 Lempiras\n\n");
        }
        else if ((ingreso >=250000)&&(edad>30)) {
            System.out.println("Es elegible para un prestamo de 1000000 Lempiras\n\n");
        }
        else {
            System.out.println("No es elegible para un prestamo\n\n");
        }
    }
}
