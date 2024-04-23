package Controlador;

import Vista.Inicio;
import Vista.Creditos;
import ordenamientos.Ordenamientos;
import main.Utilidades;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class ControladorInicio implements ActionListener{
    private Inicio inicio;
    private ControladorCreditos controladorCreditos;
    private Creditos creditos;
    private String cadena;
    
    public ControladorInicio(Inicio inicio){
        this.inicio = inicio;
        this.inicio.buscarBtn.addActionListener(this);
        this.inicio.creditosBtn.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == inicio.buscarBtn){
            //String textoArchivo = "";
            String textoArchivo = """
                                El diagnóstico diferencial con la orquipididimitis es el más frecuente e importante y es el que retrasa, en muchas ocasiones, el tratamiento correcto de la torsión testicular. La edad de presentación y la ausencia dc síntomas y - o hallazgos significativos en orina y liquido prostatovesicular son datos importantes y valorables para descartar este proceso7 - 0 - I2 De hecho, la orquiepididimitis se presenta raramente por debajo de los dieciocho años, en cambio, en esta época de la vida (infancia y pubertad), sí es frecuente la torsión del cordón espermático (Fig. 5. A). En favor de la orquiepididimitis se describe generalmente un comienzo doloroso menos brusco, pero acompañado de un cuadro febril y tumefacción localizada en epidídimo y - o dídimo, pero con el cordón espermático libre. La próstata al tacto rectal es muchas veces dolorosa’7 ~ ~ El diagnóstico diferencial, y aunque ello ocurra con menos frecuencia se debe hacer con el apendicocele escrotal por persistencia del conducto peritoneo vaginals ~ González68 señala que en su experiencial, alrededor de un 10% de nínos con hernia inguinoescrotal por persistencia del conducto peritoneo vaginal presentaron concomitantemente una torsión del cordón, sugiriendo como posibilidad causal una inserción anómala de la túnica vaginal alrededor del cordón espermático. Por último, también se debe diferenciar de otros procesos testiculares 8, como neoplasias de evolución aguda, hematoceles, hematomas de las bolsas, infartos espontáneos del testículo, torsión de los apéndices testiculares, quistes del cordón o epidídimo, edema escrotal idiopático y en el recién nacido, con la vaginalitis por meconio.
                                se denomina esterilidad conyugal a la incapacidad de obtener un embarazo, conservar el producto de esa concepción y parir un hijo, estado la mujer en período de actividad genital. Esta incapacidad de concebir se considera luego de mantener durante un año vida sexual regular sin anticoncepción.
                                La esterilidad se considera primaria cuando no ha sobrevenido la concepción después de un lapso de uno o más años de vida sexual sin el uso de ninguna medida anticoncepcional. se llama secundaria cuando uno o dos embarazos normales son seguidos por dos años o más de esterilidad involuntaria (aunque no tenga ningún hijo vivo). Las causas de ambas son idénticas.
                                se denomina infertilidad a la incapacidad de la mujer para dar a luz con vida, aunque la gestación se lleve a cabo fácilmente (es el aborto habitual o recurrente).
                                Una unión estéril no es con frecuencia el resultado de defectos en uno solo de sus miembros, sino que muchas veces es el resultado de la suma total de varios factores en ambos. Por lo tanto, es importante que ambos miembros de la pareja asuma el problema y esté dispuesta a someterse a los procedimientos de investigación y tratamiento.
                                Tubo - peritoneal: incluye a las trompas en todas sus funciones: como elemento de transporte de los gametos, como activador del proceso de fecundación y transporte del huevo fecundado a la cavidad uterina. Importante son las infecciones agudas o crónicas de las trompas. otro factor importante es la endometriosis tubaria, que produce procesos inflamatorios a veces muy extensos. El factor peritoneal: cirugías abdominales previas, en donde pueden haber quedado bridas intra - abdominales, que pueden ocluir la entrada del óvulo desde el ovario hacia las trompas.
                                  """;
            
            obtenerPalabra();
            // textoArchivo = obtenerTextoArchivo();
            realizarOrdenamientos(textoArchivo);
            limpiarCampos();
        }
        else{
            mostrarCreditos();
        }
    }
    
    public void obtenerPalabra(){
        this.cadena = inicio.palabraTextField.getText();
    }
    
    public void limpiarCampos(){
        inicio.palabraTextField.setText("");
    }
    
    public String obtenerTextoArchivo(){
        String ruta = "H:\\Mi unidad\\UADY-LIS\\4° Semestre\\Estructuras de Datos\\ProyectoEstructuras\\medline_CDs.txt";
        String textoArchivo = "";
        
        try{
            File archivo = new File(ruta);
            Scanner scanner = new Scanner(archivo);
            
            while(scanner.hasNextLine()){
                textoArchivo += scanner.nextLine();
            }
            
            scanner.close();
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "Archivo No Encontrado");
        }
        
        return textoArchivo;
    }
    
    public void realizarOrdenamientos(String texto){
        Ordenamientos ordenamientos = new Ordenamientos();
        Utilidades utilidades = new Utilidades();
        
        ArrayList<String> cadenaLimpia = utilidades.tokenizador(texto);
        
        ArrayList<String> testA = (utilidades.medirTiempoejecucionOrdenamiento(cadenaLimpia, "burbujaMenor", ordenamientos::burbujaMayor));
        System.out.println(utilidades.elElementoSeEncuentra(testA, this.cadena));
        
        ArrayList<String> testB = (utilidades.medirTiempoejecucionOrdenamiento(cadenaLimpia, "insercion", ordenamientos::insercion));
        System.out.println(utilidades.elElementoSeEncuentra(testB, this.cadena));

        ArrayList<String> testC = (utilidades.medirTiempoejecucionOrdenamiento(cadenaLimpia, "shellsort", ordenamientos::shellsort));
        System.out.println(utilidades.elElementoSeEncuentra(testC, this.cadena));

        ArrayList<String> testD = (utilidades.medirTiempoejecucionOrdenamiento(cadenaLimpia, "QuickSort", ordenamientos::QuickSort));
        System.out.println(utilidades.elElementoSeEncuentra(testD, this.cadena));
    }
    
    public void mostrarCreditos(){
        this.creditos = new Creditos();
        this.controladorCreditos = new ControladorCreditos(inicio, creditos);
        inicio.setVisible(false);
        creditos.setVisible(true);
    }
}
