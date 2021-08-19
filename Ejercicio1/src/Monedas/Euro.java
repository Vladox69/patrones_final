/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Monedas;

import Conversiones.ConversionEuro;

/**
 *
 * @author ASUS
 */
public class Euro extends ConversionEuro{
    
    double valor;
    
    @Override
    public double euro_euro(double cantidad) {
        this.valor=cantidad;
        return this.valor;
    }

    @Override
    public double euro_libra(double cantidad) {
        this.valor=cantidad*0.85;
        return this.valor;
    }

    @Override
    public double euro_dolar(double cantidad) {
        this.valor=cantidad*1.18;
        return this.valor;
    }
    
}
