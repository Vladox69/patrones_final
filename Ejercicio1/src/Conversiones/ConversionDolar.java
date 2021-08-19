/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conversiones;

/**
 *
 * @author ASUS
 */
public abstract class ConversionDolar implements IConversion.IConversion{
    
    public abstract double dolar_euro(double cantidad);
    public abstract double dolar_libra(double cantidad);
    public abstract double dolar_dolar(double cantidad);
    
    private double dolar;
    private double euro;
    private double libra;
    
     @Override
    public void convertir(double can) {
        this.dolar = dolar_dolar(can);
        this.euro = dolar_euro(can);
        this.libra = dolar_libra(can);
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
