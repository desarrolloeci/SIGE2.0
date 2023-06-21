/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

/**
 *
 * @author andres.rojas
 */
public class ConvertDate {
    public static String getDate103(String date){
        
        return "CONVERT(date, '"+date+"', 103)";
    }
}
