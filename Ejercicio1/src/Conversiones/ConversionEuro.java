/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conversiones;

import IConversion.IConversion;

/**
 *
 * @author ASUS
 */
public abstract class ConversionEuro implements IConversion{
    public abstract double euro_euro(double cantidad);
    public abstract double euro_libra(double cantidad);
    public abstract double euro_dolar(double cantidad);
    
    private double dolar;
    private double euro;
    private double libra;
    
     @Override
    public void convertir(double cantidad) {
        this.dolar = euro_dolar(cantidad);
        this.euro = euro_euro(cantidad);
        this.libra = euro_libra(cantidad);
    }

    @Override
    public double getDolar() {
        return dolar;
    }

    public void setDolar(double dolar) {
        this.dolar = dolar;
    }

    @Override
    public double getEuro() {
        return euro;
    }

    public void setEuro(double euro) {
        this.euro = euro;
    }

    @Override
    public double getLibra() {
        return libra;
    }

    public void setLibra(double libra) {
        this.libra = libra;
    }
    
    
}
