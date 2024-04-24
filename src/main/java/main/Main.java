package main;

import Vista.*;
import Controlador.ControladorInicio;
import arboles.ArbolABB;
import arboles.ArbolAVL;
import java.util.ArrayList;
import ordenamientos.Ordenamientos;

public class Main {
    /*
    public static void main(String[] args) {
        Ordenamientos ordenar = new Ordenamientos();
        Utilidades utilx = new Utilidades();
        String cadena = """
                        Existen distintos tipos de cirugía del ojo con rayos láser. lasik - queratomileusis in situ asistida por rayos láser - es una de las más comunes. muchos pacientes que se someten a lasik terminan con una agudeza visual de 20 - 20. pero, como todos los procedimientos médicos, tiene sus propios riesgos y beneficios. sólo su oculista puede indicarle si es un buen candidato para la cirugía de los ojos con rayos láser.
                        La enfermedad diabética del ojo, es un grupo de problemas que afecta a quienes tienen diabetes, incluyendo la retinopatía diabética, las cataratas y el glaucoma. El problema más común es la retinopatía diabética, que afecta a 5. 3 millones de personas en los Estados Unidos de los 18 años de edad en adelante.
                        La retinopatía diabética es una amenaza potencial a la visión, en la cual los vasos sanguíneos dentro de la retina son dañados por los niveles altos de azúcar asociados con la diabetes. Esto desarrolla una fuga de fluídos dentro de la retina y la obstrucción del paso de la sangre. Ambos pueden resultar en pérdida de la visión.
                        El melanoma es un tipo de cáncer muy agresivo que se puede diseminar rápidamente.
                        El melanoma es el tipo de tumor ocular más común en adultos: aún así, el melanoma primario del ojo es raro.
                        Un factor de riesgo importante es la exposición excesiva a la luz del sol. la ocurrencia del melanoma ha aumentando considerablemente en las últimas décadas, resultando afectadas con mayor frecuencia las personas de ojos azules y piel clara.
                        La deficiencia de vitamina a es una causa común en áreas del mundo en donde es común la desnutrición, pero esto es raro en los Estados Unidos.
                        gotas para humedecer, llamadas lágrimas artificiales.
                        inclinación palpebral del ojo. Es la dirección de la inclinación de una línea trazada desde el ángulo externo hasta el ángulo interno del ojo.
                        La inclinación anormal del ojo puede estar asociada con algunos trastornos genéticos y síndromes, de los cuales el más común asociado con la inclinación palpebral es el síndrome de down. las personas con este síndrome a menudo también presentan un pliegue epicántico en el ángulo interno del ojo.
                        nota: los rangos de los valores normales pueden variar ligeramente entre diferentes laboratorios. hable con el médico acerca del significado de los resultados específicos de su examen.
                       """;



        //CREO  QUE ESTA MAL
        //ArrayList<String> testF = (utilx.medirTiempoejecucionOrdenamiento(cadenaLimpia, "ordenaMerge", ordenar::ordenaMerge));
        //System.out.println(testF);
        //System.out.println(utilx.elElementoSeEncuentra(testF, palabraAbuscar));
        
        //MezclaHomogenea FALTA
        
        ArbolABB arbolitoABB = new ArbolABB("");
        ArrayList<String> x = utilx.medirTiempoejecucionOrdenamiento(cadenaLimpia, "ArbolABB", dataList -> {
            for (String elemento : dataList) {  arbolitoABB.insertar(elemento);  }
        });
        try {  arbolitoABB.buscar(palabraAbuscar); } catch (Exception e){  System.out.println(e);  }
        
        
        
        ArbolAVL arbolitoAVL = new ArbolAVL("");
         ArrayList<String> y = utilx.medirTiempoejecucionOrdenamiento(cadenaLimpia, "arbolitoAVL", dataList -> {
            for (String elemento : dataList) {  arbolitoAVL.insertar(elemento);  }
        });
        try {  arbolitoAVL.buscar(palabraAbuscar); } catch (Exception e){  System.out.println(e);  }
        
        //Arboles B FALTA

    }
*/
    public static void main(String[] args){
        Inicio inicio = new Inicio();
        @SuppressWarnings("unused")
        ControladorInicio controladorInicio = new ControladorInicio(inicio);
        inicio.setVisible(true);
    }
}
