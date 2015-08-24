/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testgra;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.*;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author kurs
 */
public class gui extends JFrame implements ActionListener, KeyListener{
    JLabel label;
    Font font,font2,font3;
     JButton guzik;
   int x;
    int y=100;
       
    Graphics g2d ;
      boolean[] gora = new boolean[52];
      boolean wlacznik=true;
      int[] ex1=new int[52] ;
      int[] ey1=new int[52] ;
 long StartTime;
   
  public gui(){
     font=new Font("Serif",Font.PLAIN,96);//ustawiamy font napisu Game Over
         StartTime=System.currentTimeMillis(); //czas zaczecia gry    
       
         label=new JLabel("napis");
      
       guzik=new JButton("naisnij");
       setSize(740,500);     
       
       setLayout(null);
       label.setBounds(700, 20, 80, 20);
       
       font3=new Font("Serif",Font.PLAIN,22);
       label.setFont(font3);
       guzik.setBounds(200, 122, 80, 20);
       add(label);
              add(guzik);
       guzik.setVisible(false);
       
       this.addKeyListener(this);
       guzik.addKeyListener(this);
       guzik.addActionListener(this);
       for (int i=0;i<52;i++){
       ex1[i] = (int)(Math.random()*this.getWidth());
      ey1[i] = 0;
      x=350;
  y=250; 

     
}
   
    }
  public void cloakscreen(){
      if(wlacznik)
  label.setText(Double.toString((System.currentTimeMillis()-StartTime)/1000));
  }
          
  public void Kolizja(){
   Graphics g2d = this.getGraphics();
      for(int i=0;i<52;i++){
  if (Math.abs(x-ex1[i])<35 &&Math.abs(y-ey1[i])<35) {

     g2d.setFont(font);
          g2d.drawString("Game Over", 100, 300); //wrzucamy napis na scrren
           font2=new Font("Serif",Font.PLAIN,12);
          g2d.setFont(font2);
 g2d.drawString("Nacisnij spacje aby kontynlowac", 100, 350);
          wlacznik=false; 
      
  
  } }}
  public void restart(){
      Graphics g2d = this.getGraphics();
   g2d.setColor(getBackground());
   g2d.fillRect(0, 0, 740, 500);//zamazujemy ekran tlem aby byl czysty nowy ekran
  for (int i=0;i<52;i++){// losujemy nowe poczatkowe wspolrzedne kol oraz ustawiamy dla wszsytkich gora na false
       ex1[i] = (int)(Math.random()*this.getWidth());
      ey1[i] = 0;
      gora[i]=false;
      
        }
  x=350;
  y=250; 
  
  StartTime=System.currentTimeMillis();//ustawiamy czas poczatkowy na aktualny dzieki czemu od nowa pojdzie petla w clasie wykonawczej Testgra
  
  }
   public void Mypaint(Color a){            //rysowanie tylko kolka gracza
      Graphics g2d = this.getGraphics();
	  
g2d.setColor (a);

g2d.fillOval(x, y, 40, 40);
}
public void CreateEnemyEnV(int a){ //rysowanie tylko wrogiego kola
Graphics g2d = this.getGraphics();
    g2d.setColor(getBackground());//ustawiamy na kolor tla aby zetrzec
    g2d.fillOval(ex1[a],ey1[a], 40, 40);//scieramy ostatnie kolko izmieniamy kolor
g2d.setColor(Color.blue);


 if (wlacznik)
     if(a%2==0) //co drugie zmieniamy kierunek
     if (ex1[a] <this.getWidth()&& ey1[a]<this.getHeight() &&gora[a]==false){
ex1[a]=ex1[a]+2;
ey1[a]=ey1[a]+2;

}else if (ex1[a] <0|| ey1[a]<0) {
      gora[a] = false;
 
  }else{   gora[a] = true;
  ex1[a]=ex1[a]-2;
ey1[a]=ey1[a]-2;}
     else if (a%2!=0){ //co drugi ma zmieniony kierunek
         if (ex1[a] >0&& ey1[a]<this.getHeight() &&gora[a]==false){
ex1[a]=ex1[a]-2;
ey1[a]=ey1[a]+2;

}else if (ex1[a] >this.getWidth()|| ey1[a]<0) {
      gora[a] = false;
 
  }else{   gora[a] = true;
  ex1[a]=ex1[a]+2;
ey1[a]=ey1[a]-2;}
     }
g2d.fillOval(ex1[a],ey1[a], 40, 40);
}
    @Override
    public void actionPerformed(ActionEvent e) {
        Mypaint(Color.RED);
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent e) {
         
       
        char czytnik;
      czytnik=e.getKeyChar();
      
      System.out.println(czytnik);
      Mypaint(getBackground()); //starcie grafiki wczesniejszej
     if (wlacznik)
      switch (czytnik ){
             case 'w' :{ y=y-7;
                          break;}
             case'a':
                        { x=x-7;  break;   }
             case'd': {  x=x+7;  break;  }
             case's': {  y=y+7;  break;  }
      }
       
     
      Mypaint(Color.RED);
       if (czytnik==' ' ){
          wlacznik=true;
          restart();
      
      }
          //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {         //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
         //To change body of generated methods, choose Tools | Templates.
    }
    
   /* public static void main(String arg[]){

java.awt.EventQueue.invokeLater(new Runnable(){
    public void run(){
    new gui().setVisible(true);
    
    
    }
    });

} */
}
