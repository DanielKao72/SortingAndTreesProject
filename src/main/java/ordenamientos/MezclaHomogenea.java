package ordenamientos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.Utilidades;

public class MezclaHomogenea {

    public void IniciarMezclaHomogenea(ArrayList<String> data) {
        Utilidades.sobreEscribirArchivoParaDejarloVacio("F.txt");
        PrintWriter File;
        try {
            File = new PrintWriter(new FileWriter("F.txt"));
            for (String line : data) {
                File.println(line);
            }
            File.close();
        } catch (IOException ex) {
            Logger.getLogger(MezclaHomogenea.class.getName()).log(Level.SEVERE, null, ex);
        }

        Utilidades.sobreEscribirArchivoParaDejarloVacio("F1.txt");
        Utilidades.sobreEscribirArchivoParaDejarloVacio("F2.txt");

        String F = "F.txt", F1 = "F1.txt", F2 = "F2.txt";
        try {
            MezclaDirecta(F, F1, F2);
        } catch (IOException ex) {
            Logger.getLogger(MezclaHomogenea.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int tamañoArchivo(String F) {
        int cont = 0;
        Scanner file = null;
        try {
            file = new Scanner(new FileReader(F));
            while (file.hasNextLine()) {
                file.nextLine();
                cont++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MezclaHomogenea.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cont;
    }

    public void MezclaDirecta(String F, String F1, String F2) throws IOException {
        int n = tamañoArchivo(F);
        int part = 1;
        while (part < n) {
            particionar(F, F1, F2, part);
            fusionar(F, F1, F2, part);
            part *= 2; //part = part *2;
        }
    }

    public void particionar(String F, String F1, String F2, int part) {
        try {
            int k, l;
            Scanner lectura = null;
            PrintWriter escritura1 = null, escritura2 = null;
            lectura = new Scanner(new FileReader(F));
            escritura1 = new PrintWriter(F1);
            escritura2 = new PrintWriter(F2);
            while (lectura.hasNextLine()) {
                k = 0;
                while (k < part) {
                    if (lectura.hasNextLine()) {
                        escritura1.println(lectura.nextLine());
                    }
                    k++;
                }
                l = 0;
                while (l < part) {
                    if (lectura.hasNextLine()) {
                        escritura2.println(lectura.nextLine());
                    }
                    l++;
                }
            }
            lectura.close();
            escritura1.close();
            escritura2.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MezclaHomogenea.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void fusionar(String F, String F1, String F2, int part) throws IOException {
        try {
            int k, l;
            String r1 = "", r2 = "";
            boolean b1 = true, b2 = true;
            Scanner File1, File2;
            PrintWriter File;
            File1 = new Scanner(new FileReader(F1));
            File2 = new Scanner(new FileReader(F2));
            File = new PrintWriter(new FileWriter(F));

            if (File1.hasNextLine()) {
                r1 = File1.nextLine();
                b1 = false;
            }

            if (File2.hasNextLine()) {
                r2 = File2.nextLine();
                b2 = false;
            }

            while ((File1.hasNextLine() || !b1) && (File2.hasNextLine() || !b2)) {
                k = 0;
                l = 0;
                while (k < part && !b1 && l < part && !b2) {
                    if (r1.compareTo(r2) < 0) {
                        File.println(r1);
                        b1 = true;
                        k++;
                        if (File1.hasNextLine()) {
                            r1 = File1.nextLine();
                            b1 = false;
                        }
                    } else {
                        File.println(r2);
                        b2 = true;
                        l++;
                        if (File2.hasNextLine()) {
                            r2 = File2.nextLine();
                            b2 = false;
                        }
                    }
                }

                if (k < part) {
                    while (k < part && !b1) {
                        File.println(r1);
                        b1 = true;
                        k++;
                        if (File1.hasNextLine()) {
                            r1 = File1.nextLine();
                            b1 = false;
                        }
                    }
                }

                if (l < part) {
                    while (l < part && !b2) {
                        File.println(r2);
                        b2 = true;
                        l++;
                        if (File2.hasNextLine()) {
                            r2 = File2.nextLine();
                            b2 = false;
                        }
                    }
                }
            }

            if (!b1) {
                File.println(r1);
            }
            if (!b2) {
                File.println(r2);
            }
            while (File1.hasNextLine()) {
                File.println(File1.nextLine());
            }
            while (File2.hasNextLine()) {
                File.println(File2.nextLine());
            }
            File1.close();
            File2.close();
            File.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MezclaHomogenea.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MezclaHomogenea.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
