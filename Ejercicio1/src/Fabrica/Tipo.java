/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabrica;

import IConversion.IConversion;

/**
 *
 * @author ASUS
 */
public class Tipo {
    
    private IConversion convertidor;
    private double dolar;
    private double euro;
    private double libra;

    public Tipo(IConversion conversion) {
        this.convertidor = conversion;
    }
    
    public void ejecutar(double can){
        convertidor.convertir(can);
        this.setDolar(convertidor.getDolar());
        this.setEuro(convertidor.getEuro());
        this.setLibra(convertidor.getLibra());
    }

    public double getDolar() {
        return dolar;
    }

    public void setDolar(double dolar) {
        this.dolar = dolar;
    }

    public double getEuro() {
        return euro;
    }

    public void setEuro(double euro) {
        this.euro = euro;
    }

    public double getLibra() {
        return libra;
    }

    public void setLibra(double libra) {
        this.libra = libra;
    }
    
}
