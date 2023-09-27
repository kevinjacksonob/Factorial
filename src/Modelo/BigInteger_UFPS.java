/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Arrays;

/**
 *
 * @author madar
 */
public class BigInteger_UFPS {

    
    /**
     *  Numero="23456"
     * miNUmero={2,3,4,5,6};
     */
    private int miNumero[];
    
    public BigInteger_UFPS() {
        this.miNumero = new int[]{0};
    }

    public BigInteger_UFPS(String numero) {
        this.miNumero = new int[numero.length()];
        for (int i = 0; i < numero.length(); i++) {
            char digit = numero.charAt(i);
            this.miNumero[i] = Character.getNumericValue(digit);
        }
    }

    public int[] getMiNumero() {
        return miNumero;
    }
    
    
    /**
     * Mutiplica dos enteros BigInteger
     * @param dos
     * @return 
     */
    
    public BigInteger_UFPS multiply(BigInteger_UFPS dos)
    {
        int[] arreglo1 = miNumero.clone();
        int[] arreglo2 = dos.getMiNumero();
        
        int longitud1 = arreglo1.length;
        int longitud2 = arreglo2.length;
        
        int[] multiplicacion = new int[longitud1 + longitud2 - 1]; // Longitud resultante
        String resultado = "";
        for (int i = 0; i < longitud1; i++) {
            for (int j = 0; j < longitud2; j++) {
                multiplicacion[i + j] += arreglo1[i] * arreglo2[j];
            }
        }
        
        for (int i = multiplicacion.length - 1; i > 0; i--) {
            int carry = multiplicacion[i] / 10;
            multiplicacion[i] %= 10;
            multiplicacion[i - 1] += carry;
            resultado = multiplicacion[i] + resultado;
        }
        resultado = multiplicacion[0] + resultado;
       
        return new BigInteger_UFPS(resultado);
    
     
    }    
         
    
    /**
     * Retorna la representación entera del BigInteger_UFPS
     * @return un entero
     */
    public int intValue()
    {
        int value = 0;
        for (int digit : miNumero) {
            value = value * 10 + digit;
        }
        return value;
    }

    @Override
    public String toString() {
         StringBuilder sb = new StringBuilder();
        for (int digit : miNumero) {
            sb.append(digit);
        }
        return sb.toString();
    }
    
     private BigInteger_UFPS(int[] digits) {
        this.miNumero = digits;
    }
    
    
     public static void main(String[] args) {
        BigInteger_UFPS num1 = new BigInteger_UFPS("859"); 
        BigInteger_UFPS num2 = new BigInteger_UFPS("140"); 
        BigInteger_UFPS result = num1.multiply(num2); 
        System.out.println(result.toString()); 
    }
    
    
    
}
