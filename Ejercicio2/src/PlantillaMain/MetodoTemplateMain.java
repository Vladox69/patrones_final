/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlantillaMain;

import PlantillaImpl.FarmaciaProcesoArchivo;
import PlantillaImpl.GroceryProcesoArchivo;
import java.io.File;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author ASUS
 */
public class MetodoTemplateMain extends TimerTask{
    
    /**
     * @param args the command line arguments
     */
    private static final String[] rutas = new String[]{"C:/files/drugstore", "C:/files/grocery"};
    private static final String LOG_DIR = "C:/files/logs";
    private static final String PROCESS_DIR = "C:/files/process";
    public static void main(String[] args) {
        new MetodoTemplateMain().start();
    }

    public void start() {
        try {
            Timer timer = new Timer();
            timer.schedule(this, new Date(), (long) 1000 * 10);
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("> Vigilancia iniciada");
        File f = new File(rutas[0]);
        if(!f.exists()){
            throw new RuntimeException("La ruta '"+rutas[0]+"'no existe");
        }
        File[] drugstoreFiles = f.listFiles();
        for (File file : drugstoreFiles) {
            try {
                System.out.println("> Archivo encontrado > " + file.getName());
                new FarmaciaProcesoArchivo(file,LOG_DIR,PROCESS_DIR).execute();
                System.out.println("Archivo procesado > " + file.getName());
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        
        f = new File(rutas[1]);
        if(!f.exists()){
            throw new RuntimeException("La ruta '"+rutas[1]+"' no existe");
        }
        System.out.println("> Leyendo ruta " + rutas[1]);
        File[] groceryFiles = f.listFiles();
        for (File file : groceryFiles) {
            try {
                System.out.println("> Archivo encontrado > " + file.getName());
                new GroceryProcesoArchivo(file,LOG_DIR,PROCESS_DIR).execute();
                System.out.println("Archivo procesado > " + file.getName());
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
