/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exposicion;

/**
 *
 * @author fasan
 */
public class Persona {
    String nombre;
    int ingreso;
    int edad;
    public Persona () {
        
    }
    
    public Persona (String nombre, int ingreso, int edad) {
        this.nombre = nombre;
        this.ingreso = ingreso;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIngreso() {
        return ingreso;
    }

    public void setIngreso(int ingreso) {
        this.ingreso = ingreso;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    @Override
    public String toString() {
        return "Nombre: "+getNombre()+"\nEdad: "+getEdad()+"\nIngreso: "+getIngreso()+"L";
    }
}
