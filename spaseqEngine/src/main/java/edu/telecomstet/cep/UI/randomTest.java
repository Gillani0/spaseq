/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.telecomstet.cep.UI;

import java.util.Random;

/**
 *
 * @author sydgillani
 */
public class randomTest {
     public static void main(String args[]){
       
           Random rand = new Random();
      for(int i=0;i<20;i++){   
         int max=20;
                 int min=1;
       

    // nextInt is normally exclusive of the top value,
    // so add 1 to make it inclusive
    int randomNum = rand.nextInt((max - min) + 1) + min;
    
    if(randomNum%2==0){
        System.out.println("Even One "+randomNum );
    }else{
        System.out.println("ODD ONE "+randomNum ); 
    }
    
    
    
     }
     }
}
