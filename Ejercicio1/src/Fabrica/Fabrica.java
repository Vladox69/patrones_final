/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabrica;

import Monedas.Dolar;
import Monedas.Euro;
import Monedas.Libra;

/**
 *
 * @author ASUS
 */
public class Fabrica {
    public Tipo obtenerTipo(String convertidor){
        if(convertidor == null){
            return null;
        }else if(convertidor.equalsIgnoreCase("EURO")){
            return new Tipo(new Euro());
        }else if(convertidor.equalsIgnoreCase("DOLAR")){
            return new Tipo(new Dolar());
        }else if(convertidor.equalsIgnoreCase("LIBRA")){
            return new Tipo(new Libra());
        }else{
            return null;
        }
    }
}
