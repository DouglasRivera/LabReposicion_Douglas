/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labreposicion_douglasrubi;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author river
 */
public class Hack_Regular implements Serializable {
    int Codigo;
    int NivelRiesgo;
    int HacksExitosos;
    File Archivo;
    
    private static final long SerialVersionUID = 444L;
    
    public Hack_Regular() {
        try {
            Archivo = new File("Hack_Regular.txt");
        } catch (Exception ex) {
            Logger.getLogger(Hack_Regular.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Hack_Regular(int Codigo, int NivelRiesgo, int HacksExitosos) {
        this.Codigo = Codigo;
        this.NivelRiesgo = NivelRiesgo;
        this.HacksExitosos = HacksExitosos;
        try {
            Archivo = new File(
                    "Hack_Regularas.txt");
        } catch (Exception ex) {
            Logger.getLogger(Hack_Regular.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public int getNivelRiesgo() {
        return NivelRiesgo;
    }

    public void setNivelRiesgo(int NivelRiesgo) {
        this.NivelRiesgo = NivelRiesgo;
    }

    public int getHacksExitosos() {
        return HacksExitosos;
    }

    public void setHacksExitosos(int HacksExitosos) {
        this.HacksExitosos = HacksExitosos;
    }

    public File getArchivo() {
        return Archivo;
    }

    public void setArchivo(File Archivo) {
        this.Archivo = Archivo;
    }
    
     public void ReadFileScanner(File archivo) {
        Scanner sc = null;//Hacemos lo mismo, leemos con el scanner
        try {
            sc = new Scanner(archivo);
            while (sc.hasNext()) {
                String[] next = sc.nextLine().split("|"); 
                System.out.println(next);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error en la lectura.");
        }
        sc.close();
    }
    
    
     public void ReadFileScanner() {
        Scanner sc = null;//Hacemos lo mismo, leemos con el scanner
        try {
            sc = new Scanner(Archivo);
            while (sc.hasNext()) {
                String[] next = sc.nextLine().split("|"); 
                
                System.out.println(next);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error en la lectura.");
        }
        sc.close();
    }
     public ArrayList<Hack_Regular> ReadFileScannerArrayList() {
        Scanner sc = null;//Hacemos lo mismo, leemos con el scanner
        ArrayList<Hack_Regular> Hack = new ArrayList<>();
        try {
            sc = new Scanner(Archivo);
            while (sc.hasNext()) {
                String temp = sc.nextLine();
                System.out.println(temp);
                System.out.println(temp.split(",").length);
                String[] next = temp.split(","); 
                Hack.add(new Hack_Regular(Integer.parseInt(next[3]), Integer.parseInt(next[2]), Integer.parseInt(next[1])));
                
                // .out.println(next);
               
            }
            return Hack;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error en la lectura.");
            return Hack;
        } finally {
             sc.close();
        }
        
    }
    
    public void WriteFile(int Codigo, int NivelRiesgo, int HacksExitosos) {
        File archivo = null;
        FileWriter fw = null;
        BufferedWriter bw = null; 
        try {
            fw = new FileWriter(Archivo, true);
            bw = new BufferedWriter(fw);
            bw.write(Codigo + "," + NivelRiesgo + "," + HacksExitosos);
            bw.newLine();
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error en la escritura.");
        }
    }
    
    public void WriteFile() {
        FileWriter fw = null;
        BufferedWriter bw = null; 
        try {
            fw = new FileWriter(Archivo, true);
            bw = new BufferedWriter(fw);
           bw.write(Codigo + "," + NivelRiesgo + "," + HacksExitosos);
            bw.newLine();
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error en la escritura.");
        }
    }
    
     public void WriteFileMod(ArrayList<Hack_Regular> hacks) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(Archivo, false);
            bw = new BufferedWriter(fw);
            for (Hack_Regular hack : hacks) {
            bw.write(hack.getCodigo()+ "," + hack.getNivelRiesgo()+ "," + hack.getHacksExitosos());
            bw.newLine();
            }
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error en la escritura");
        }
    }
}
