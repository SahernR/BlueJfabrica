import java.util.*;
/**
 * Write a description of class Fabrica here.
 *
 * @author (Sebastian Ahern)
 * @version (18-08-2022)
 */
public class Fabrica
{
    // instance variables - replace the example below with your own
    private int [] metales;
    private ArrayList<String> estados;
    private int cantidadOk = 0;
    private int cantidadMinima = 50;
    private int canterror = 0;
    /**
     * Constructor for objects of class Fabrica
     */
    public Fabrica()
    {
        // initialise instance variables
        metales = new int[5];
        estados = new ArrayList();
    }
    
    public String agregarMaterial(int cantidad, int contenedor)
    {
        if(contenedor < 0)
        {
            return "El contenedor debe ser mayor a 0";
        }
        
        if(contenedor >= 5) 
        {
            return "Solo tenemos 5 contenedores"; 
        }

        if (cantidad < 0)
        {
            return "La cantidad de material no puede ser menor a cero"; 
        }
        metales[contenedor] = cantidad;
        return "Material agregado..."; 
    }
    
    public int getFallidos() 
    {
        
        if (estados.size() <= 0) 
        {
            return -1;
        }
        
        for (int i = 0; i < estados.size(); i++) 
        { 
            if(estados.get(i).equals("ERROR")) 
            {
            canterror++; 
            }
        }
        return canterror; 
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    
    public int getOKs() 
    {
        if (estados.size() <= 0) 
        {
            return -1;
        }
        for (int i = 0; i < estados.size(); i++) 
        {
        if(estados.get(i).equals("OK"))
        {
            cantidadOk++; 
        }
        }
        return cantidadOk; 
    }
    
    public String fabricar()
    {
        StringBuilder salida = new StringBuilder();
        salida.append("-Reporte de Fabricacion-");
        for (int j=0; j<=5; j++)
        {
            if (metales[j] < cantidadMinima)
            {
                salida.append("material insuficiente"); 
                estados.add("ERROR");
            }
            else
            {
                salida.append("Fabricado"); 
                estados.add("OK");
            }
        }
        return salida.toString(); 
    }
}
