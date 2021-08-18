/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlantillaImpl;

import PlantillaUtil.onMemoryDataBase;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 *
 * @author ASUS
 */
public class FarmaciaProcesoArchivo extends ProcesoArchivoAbstractTemplate{
    private String log = "";

    public FarmaciaProcesoArchivo(File archivo, String rutaRegistro, String moverCamino) {
        super(archivo, rutaRegistro, moverCamino);
    }
 

    @Override
    protected void validacionNombre() throws Exception {
       String nombreArchivo = archivo.getName();
        if (!nombreArchivo.endsWith(".drug")) {
            throw new Exception("Nombre del archivo no valido"
                    + ", debe terminar con .drug");
        }
        if (nombreArchivo.length() != 16) {
            throw new Exception("El documento no tiene el formato esperado");
        }
    }

    @Override
    protected void procesarArchivo() throws Exception {
     FileInputStream input = new FileInputStream(archivo);
        try {
            byte[] contenidoArchivo = new byte[input.available()];
            input.read(contenidoArchivo);
            String mensaje = new String(contenidoArchivo);
            String[] lineas = mensaje.split("\n");
            for (String linea : lineas) {
                String id = linea.substring(0,3);
                String clientes = linea.substring(3,5);
                double monto = Double.parseDouble(linea.substring(5,8));
                String fecha = linea.substring(8,16);
                boolean existe = onMemoryDataBase.clienteExiste(Integer.parseInt(clientes));                        
                if (!existe) {
                    log += id + " E" + clientes + "\t\t" + fecha
                            + " El cliente no existe\n";
                } else if (monto > 200) {
                    log += id + " E" + clientes + "\t\t" + fecha
                            + " El monto supera el maximo\n";
                } else {

                    log += id + " E" + clientes + "\t\t" + fecha
                            + " Aplicado exitosamente\n";
                }
            }
        } finally {
            try {
                input.close();
            } catch (Exception e) {
            }
        }
    }

    @Override
    protected void crearLog() throws Exception {
       FileOutputStream out = null;
        try {
            File outArchivo = new File(rutaRegistro + "/" + archivo.getName());
            if (!outArchivo.exists()) {
                outArchivo.createNewFile();
            }
            out = new FileOutputStream(outArchivo, false);
            out.write(log.getBytes());
            out.flush();
        } finally {
            out.close();
        }
    }
}
