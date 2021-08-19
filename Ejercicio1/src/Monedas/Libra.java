/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Monedas;

import Conversiones.ConversionLibra;


/**
 *
 * @author ASUS
 */
public class Libra extends ConversionLibra{
    double valor;
    
    
    
    @Override
    public double libra_euro(double cantidad) {
        this.valor=cantidad*1.18;
        return this.valor;
    }

    @Override
    public double libra_libra(double cantidad) {
        this.valor=cantidad;
        return this.valor;
    }

    @Override
    public double libra_dolar(double cantidad) {
        this.valor=cantidad*1.39;
        return this.valor;
    }
    
    
}
