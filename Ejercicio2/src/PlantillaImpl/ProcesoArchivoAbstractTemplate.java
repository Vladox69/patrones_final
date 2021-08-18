/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlantillaImpl;

import PlantillaUtil.onMemoryDataBase;
import java.io.File;

/**
 *
 * @author ASUS
 */
public abstract class ProcesoArchivoAbstractTemplate {
    protected File archivo;
    protected String rutaRegistro;
    protected String moverRuta;

    public ProcesoArchivoAbstractTemplate(File archivo, String rutaRegistro, String moverCamino) {
        this.archivo = archivo;
        this.rutaRegistro = rutaRegistro;
        this.moverRuta = moverCamino;
    }
    
    public final void execute() throws Exception {
        validacionNombre();
        validacionProceso();
        procesarArchivo();
        crearLog();
        moverDocumento();
        marcarDocProcesado();
    }

    protected abstract void validacionNombre() throws Exception;

    protected void validacionProceso() throws Exception {
        String estadoArchivo = onMemoryDataBase.getEstadoArchivo(archivo.getName());
        if (estadoArchivo != null && estadoArchivo.equals("Procesado")) {
            throw new Exception("El archivo '" + archivo.getName() + "' ya fue procesado");
        }
    }

    protected abstract void procesarArchivo() throws Exception;

    protected abstract void crearLog() throws Exception;

    private void moverDocumento() throws Exception {
        String nuevaRuta = moverRuta+"/"+archivo.getName();
        boolean cambio = archivo.renameTo(new File(nuevaRuta));
    }
    
    protected void marcarDocProcesado() throws Exception{
        onMemoryDataBase.setArchivoProcesado(archivo.getName());
    }
}
