/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Monedas;

import Conversiones.ConversionDolar;

/**
 *
 * @author ASUS
 */
public class Dolar extends ConversionDolar {

    double valor;

    @Override
    public double dolar_euro(double cantidad) {
        this.valor = cantidad * 0.85;
        return valor;
    }

    @Override
    public double dolar_libra(double cantidad) {
        this.valor = cantidad * 0.72;
        return valor;
    }

    @Override
    public double dolar_dolar(double cantidad) {
        this.valor = cantidad;
        return this.valor;
    }
}
