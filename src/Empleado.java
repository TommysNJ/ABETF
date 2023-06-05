public class Empleado {
    private String cedula;
    private String nombre;
    private double sueldo;
    private double aporte;
    private double impuesto;
    private double sueldoarecibir;
    private String numregistro;

    public Empleado(String cedula, String nombre, double sueldo, String numregistro) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.sueldo = sueldo;
        aporte = sueldo*0.0935;
        impuesto = setImpuesto(sueldo);
        sueldoarecibir= sueldo-aporte-impuesto;
        this.numregistro = "ER00"+numregistro;

    }

    public String getCedula() {
        return cedula;
    }

    public String getNumregistro() {
        return numregistro;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }


    public void setAporte(double sueldo) {
        aporte = sueldo*0.0935;
    }


    public double setImpuesto(double sueldo) {
        if (sueldo <= 5000){
            impuesto = 0;
        } else if (sueldo > 5000 && sueldo <= 10000){
            impuesto = sueldo*0.1;
        } else if (sueldo > 10000 && sueldo <=18000){
            impuesto = sueldo*0.2;
        } else if (sueldo > 18000){
            impuesto = sueldo*0.3;
        }
        return impuesto;
    }

    public void setSueldoarecibir(double sueldo) {
        sueldoarecibir = sueldo-aporte-impuesto;
    }

    @Override
    public String toString() {
        return "EMPLEADO\n" + "Cédula: " + cedula + "\nNúmero de registro: " + numregistro + "\nNombre: " + nombre + "\nSueldo: " + sueldo
                + "\nAporte: " + aporte + "\nImpuesto: " + impuesto + "\nSueldo a recibir: " + sueldoarecibir + "\n\n";
    }
}
