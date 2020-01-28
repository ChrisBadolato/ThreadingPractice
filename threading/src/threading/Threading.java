/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threading;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Chris Badolato
 */
public class Threading extends TimerTask{

    /**
     * @param args the command line arguments
     */
    Thread printa = new Thread(new PrintChar('a', 20));
    Thread printb = new Thread(new PrintChar('b', 20));
    Thread printNum = new Thread(new PrintNum(20));
    
    private char displayChar;
    Timer timer;
    public static void main(String[] args) {
            
            //can thread this way, or the way the code is doing it
       /* 
        PrintChar printa = new PrintChar('a', 20);
        PrintChar printb = new PrintChar('b', 20);
        PrintNum printNum = new PrintNum(5);
        
        printa.start();
        printb.start();
        printNum.start();
        */
       new Threading('C');
       new Threading('h');
       new Threading('r');
       new Threading('i');
       new Threading('s');
       
       
    }
    public Threading(char c){
        //printa.start();
       // printb.start();
       // printNum.start();
       displayChar = c;
       timer = new Timer();
            //start thread execution after 0msec delay
       timer.schedule(this, 100);
    }

    @Override
    public void run() {
        for(int i =0; i < 10; i++){
            System.out.print(displayChar);         
            
        }
        timer.cancel();
    }
    
}

class PrintChar extends Thread{
    private char charToPrint;
    private int times;
    
    public PrintChar(char c, int t){
        charToPrint = c;
        times = t;
    }
    @Override
    public void run(){
        for(int i =0; i < times; i++){
            System.out.print(charToPrint);
        }
    }
}

class PrintNum extends Thread{
    
    private int lastNum;
    
    public PrintNum(int n){
    
        lastNum = n;
    }
    @Override
    public void run(){
        for(int i =0; i < lastNum; i++){
            System.out.print(" " + i);         
            Thread.yield();
        }
    }
}

