import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Funcionamiento {
    private List<Empleado> listaEmpleados = new ArrayList<>();

    public boolean agregar (Empleado empleado){ //Función para registrar empleados en la lista
        boolean control = false; //Boolean para confirmar si se agregó o no
        if (searchById(empleado.getCedula())==-1){
            control=true;
            listaEmpleados.add(empleado);
        }
        return control;
    }


    public int searchById(String cedula){//Función de busqueda binaria, para encontrar empleados por cédula
        listaEmpleados.sort(Comparator.comparing(Empleado::getCedula));


        int inicio = 0;
        int tope = listaEmpleados.size() - 1;
        while (inicio <= tope) {
            int medio = (inicio + tope) / 2;
            Empleado em = listaEmpleados.get(medio);
            int comparison = em.getCedula().compareTo(cedula);
            if (comparison == 0) {
                return medio;//Retorna la posición
            } else if (comparison < 0) {
                inicio = medio + 1;
            } else {
                tope = medio - 1;
            }
        }
        return -1;
    }

    public Empleado imprimirEmpleado (String cedula){ //Función de impresión por cédula
        int posicion = searchById(cedula);
        if (posicion!=-1){
            return listaEmpleados.get(posicion);
        }
        return null;
    }

    public void ModificarEmpleados (String cedula, String Nombre,double sueldo){//Función para modificar los datos del empleado
        int posicion=searchById(cedula);//Se lo busca por cédula, en busqueda binaria
        if (posicion!=-1){
            listaEmpleados.get(posicion).setNombre(Nombre);
            listaEmpleados.get(posicion).setSueldo(sueldo);
            listaEmpleados.get(posicion).setImpuesto(sueldo);
            listaEmpleados.get(posicion).setAporte(sueldo);
            listaEmpleados.get(posicion).setSueldoarecibir(sueldo);
        }
    }

    public void modificarEmpleadoPorNumRegis (String cedula, String nombre, double sueldo,String numregistro){//Función para modificar los datos del empleado

        Empleado posicion = busquedaNumRegistroLista(numregistro);//Se lo busca por Número de registro, en busqueda secuencial
        if (posicion!=null){
            posicion.setNombre(nombre);
            posicion.setCedula(cedula);
            posicion.setSueldo(sueldo);
            posicion.setImpuesto(sueldo);
            posicion.setAporte(sueldo);
            posicion.setSueldoarecibir(sueldo);
        }
    }

    public void eliminarEmpleado  (String cedula){//Función para eliminar empleados, se realiza una busqueda secuencial
        for (int i = 0; i < listaEmpleados.size(); i++) {
            Empleado empleado = listaEmpleados.get(i);
            if (empleado.getCedula().equals(cedula)) {
                listaEmpleados.remove(i);
                break;
            }
        }
    }


    public Empleado busquedaNumRegistroLista (String numRegis){//Función para buscar a un empleado por su número de registro

        for (int i=0; i< listaEmpleados.size();i++){
            Empleado empleado = listaEmpleados.get(i);
            if (empleado.getNumregistro().equalsIgnoreCase(numRegis)){
                return empleado;
            }
        }

            return null;

    }
    public List<Empleado> busquedaNombreLista (String nombre){//Función para buscar a todos los empleados con un mismo nombre
        List<Empleado> E= new ArrayList<>();
        for (int i=0; i< listaEmpleados.size();i++){
            Empleado empleado = listaEmpleados.get(i);
            if (empleado.getNombre().equalsIgnoreCase(nombre)){
                E.add(empleado);
            }
        }
        if(!E.isEmpty()){
            return E;}
        else{
            return null;
        }
    }

    @Override
    public String toString() {
        return "Lista Empleados\n" + listaEmpleados;
    }
}
