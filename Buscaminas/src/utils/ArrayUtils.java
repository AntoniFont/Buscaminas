/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author DaniPC
 */
public class ArrayUtils {
    
    //metodos
    public static boolean arrayContieneEntero(int [] array, int num) {
        for(int x : array) {
            if(x == num) {
                    return true;
            }
        }
        return false;
    }
}
