/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.util.Calendar;

/**
 *
 * @author Wal-Mart
 */
public class UtilFecha {
    
    public String obtenerFechaActualTexto(){
        Calendar fechaActual = Calendar.getInstance();
        String dia = formatoFecha(fechaActual.get(Calendar.DATE));
        String mes = formatoFecha(fechaActual.get(Calendar.MONTH));
        String annio = Integer.toString(fechaActual.get(Calendar.YEAR));
        return annio +"-"+mes+"-"+dia;
    
    }  
    private String formatoFecha(int num){
        if (num > 9){
            return Integer.toString(num);
        }else{    
            return "0"+Integer.toString(num);
        }
    }
    
    
}
