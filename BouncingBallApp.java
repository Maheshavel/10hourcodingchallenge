import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class BouncingBallApp extends JFrame
{
    //start of main method
    public static void main(String[] args)
    {
       //crate container
       Container container = new Container();
       //crate BouncingBallApp instance
       BouncingBallApp bBalls = new BouncingBallApp();
        //set the window closing feature(close with X click)
       bBalls.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       //crate boucing ball panel(BBP) instance and add
       BouncingBallPanel BBP = new BouncingBallPanel();
       container.add(BBP);
       //make the BBP the MouseListner
       bBalls.addMouseListener(BBP);
       //set window background and size
       bBalls.setBackground(Color.WHITE);
       bBalls.setSize(400, 300);
       BBP.setSize(400, 300);
       BBP.setLayout(null);
       bBalls.setContentPane(BBP);
       //set window visible
       bBalls.setVisible(true);
    }//end of main method
}//end of Class BouncingBall App


class BouncingBallPanel extends JPanel implements MouseListener
{
    //create an empty array for 20 Ball objects
    public Ball[] array; 
    private int count = 0;
    Random generator = new Random();

    public BouncingBallPanel()
    {
        array = new Ball[20];
    }

        public void mouseClicked(MouseEvent event)
    {
        array[count] = new Ball(this);
        count++;
        if( count == 1)
        {
            final Runnable update = new Runnable()
            {
                public void run()
                {
                    for (int j = 0; j < array.length; j++)
                    {
                        if(array[j] != null)
                        {
                            array[j].move();
                        }//end of if
                    }//end of for 
                }//end of run method
            };//end of runnalbe update
            (new Thread(new Ball(this))).start();
            Runnable graphic = new Runnable()
            {
                public void run()
                {
                    while(true)
                    {
                        try
                        {
                            EventQueue.invokeLater(update);
                            Thread.sleep(generator.nextInt(10 +100));
                        }catch (InterruptedException exp){}
                    }//end of while
                }//end of run 
            };//end of runnable
            new Thread(graphic).start();
        }//end of if  
    }//end of mouseClicked method

    //empty interfaces for mouse events
    public void mouseExited(MouseEvent event){}
    public void mouseReleased(MouseEvent event){}
    public void mouseEntered(MouseEvent event){}
    public void mousePressed(MouseEvent event){}   

    //paint component method
    public void paintComponent(Graphics g)
    {
     super.paintComponent(g);
     Graphics2D g2d = (Graphics2D) g;
     //loop for each ball and draw all balls in array
     for(int i = 0; i < array.length; i++)
     {
        if(array[i] != null)
        {
         g2d.setColor(array[i].getColor());
         g2d.fillOval((int)array[i].getX(), (int)array[i].getY(), (int)array[i].getDiameter(), (int)array[i].getDiameter());
        }
     }//end of for loop
    }//end of paintComponent loop
}//end of Class BouncingBallPanel

class Ball implements Runnable
{
    //set up variables
    private double x;
    private double y;
    private int deltaX;
    private int deltaY;
    private double diameter;
    private Color color;
    BouncingBallPanel BBP2;

    Random random = new Random();

    public Ball(BouncingBallPanel a) 
    {
        x = random.nextInt(400);
        y = random.nextInt(300);
        deltaX = 1 + random.nextInt(10);
        deltaY = 1 + random.nextInt(10);
        diameter = 5 + random.nextInt(20);
        color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        BBP2 = a;
    }// end of constructor

    public double getX() 
    {
        return x;
    }

    public double getY() {
            return y;
    }

    public double getDiameter() {
        return diameter;
    }

    public Color getColor() {
        return color;
    }

    public void move() {
        x += deltaX;
        y += deltaY;

        if (x > 400 - getDiameter()|| x <0) 
        {
            deltaX = -deltaX;
        }

        if (y > 300 - getDiameter() || y < 0)
        {
            deltaY = -deltaY;
        }

    }// end of method move
    @Override
    public void run()
    {
        while(true)
         { 
            move();
            BBP2.repaint();       
            try{
               Thread.currentThread().sleep(10 + random.nextInt(100));
            }catch(InterruptedException exp){} 
           }//end of while 
    }//end of run method
}//end of Ball