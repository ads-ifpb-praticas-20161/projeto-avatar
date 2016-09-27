package com.mycompany.contrloedeestoque.util.log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @Date  23/09/2016
 * @author Wellington Lins Claudino Duarte   
 * @mail wellingtonlins2013@gmail.com
 */ 
public class Loader {
     private static Logger logger = LogManager.getLogger(Loader.class);
     
     public static void main(String[] args) {
         
         logger.error("uma mensagem de erro");
    }
}
