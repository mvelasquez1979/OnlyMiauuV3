package models;

import java.util.Date;

public class Gatos extends Animales{
    private String raza;

    // Constructor
    public Gatos(String nombre, int edad, String raza, String color, String sexo, Boolean esteril, Date fechaNac, String foto) {
        super(nombre, edad, color, sexo, esteril, fechaNac, foto); // Llamada al constructor de la clase base
        this.raza = raza;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo(); // Llama al método de la clase base
        System.out.println("Raza: " + raza);
    }

    // Getter
    public String getRaza() {
        return raza;
    }

    // Setter
    public void setRaza() {
        this.raza = raza;
    }


    // Metodo para Evaluar adopciones de gatos
    public String adoptar(Integer cantidad, Integer edad, Boolean trabaja, Float sueldo, Integer grupoF) {
        String criterio = "";
        switch (cantidad){
            case 1:
                if(edad >= 18 && trabaja){
                    criterio = "Cumple, válido para adoptar 1 gatito";
                }else{
                    criterio = "No cumple, vuelve cuando tengas 18 años y/o cuentes con un trabajo";
                }
                break;
            case 2:
                if(edad >= 18 && trabaja && sueldo >= 600000){
                    criterio = "Cumple, válido para adoptar 2 gatitos";
                }else{
                    criterio = "No cumple, se puede evaluar para adoptar 1 gatito ";
                }
                break;
            default:
                if(edad >= 18 && trabaja && sueldo >= 1800000){
                    criterio = "Cumple, válido para adoptar 2 gatitos";
                }else{
                criterio = "No cumple, se puede evaluar para adoptar 1 gatito ";
                }
                break;
        }
        return criterio;
    }
}