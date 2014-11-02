/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.UserInterface;

import Model.ExchangeRate;
import Model.Money;

/**
 *
 * @author Ciro
 */
public class MoneyDisplay {

    public static void display(Money money, ExchangeRate rate) {
        System.out.println("El tipo de cambio de " + rate.getCurrencyFrom() + " a " + 
                rate.getCurrencyTo() + " es: " + rate.getRate());
        System.out.println("Su cambio es: " + money.toString());
    }
    
}
