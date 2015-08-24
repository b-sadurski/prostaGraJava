/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testgra;

import java.awt.Color;

/**
 *
 * @author kurs
 */
public class Testgra {
    static int i;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        gui obraz=new gui();
        i=0;
        obraz.setVisible(true);
       
        try{
        while(1==1){
            obraz.Mypaint(obraz.getBackground()); 
            obraz.Mypaint(Color.RED);
            //rysowanie gracza ze scieraniem
            //scieranie przy przesowaniu juz jest realizowane w metodzie keylistenera
                  
               i= (int)((System.currentTimeMillis()-obraz.StartTime)/4000);
        for(int b=0;b<i+1;b++)  //petla odpalajaca rysowanie kolek w zaleznosci od czasu gry
        if( obraz.wlacznik)
             obraz.CreateEnemyEnV(b);
             
        obraz.Kolizja();       //odstep miedzy klatkami gry to 10 ms
        for (i=0;i<11;i++){//odstep miedzy zegarem 1 ms (aby kolka mniej zacieraly zegar)
         obraz.cloakscreen();
         Thread.sleep(1);
        }        
       
        
        }    
        }catch(Exception e){
            
        }
        
    }
    
}
