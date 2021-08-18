/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlantillaUtil;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public class onMemoryDataBase {
    public static final Map<String, String> ProcesoDocumentos = new HashMap<>();
    public static final int[] Clientes = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 
        10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

    public static String getEstadoArchivo(String fileName) {
        if (ProcesoDocumentos.containsKey(fileName)) {
            return ProcesoDocumentos.get(fileName);
        }
        return null;
    }

    public static void setArchivoProcesado(String fileName) {
        ProcesoDocumentos.put(fileName, "Procesado");
    }

    public static boolean clienteExiste(int id) {
        for (int i : Clientes) {
            if (i == id) {
                return true;
            }
        }
        return false;
    }
}
