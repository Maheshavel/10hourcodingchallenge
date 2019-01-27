import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class panel extends JPanel implements ActionListener
{
String h="";
JButton jb[]=new JButton[10];
Icon io[]=new ImageIcon[10];
JButton sq[][]=new JButton[10][10];
String st[]=new String[10];
char d[]=new char[10];
int in=0;
panel()
{
setLayout(new GridLayout(8,8));
for(int i=0;i<8;i++)
{
for(int j=0;j<8;j++)
{
if((i>=2)&&(i<=5))
{
sq[i][j]=new JButton();
sq[i][j].setActionCommand("b"+i+j);
}
else if(i==1)
{
Icon on=new ImageIcon("wpawn.png");
sq[i][j]=new JButton(on);
sq[i][j].setActionCommand("b"+i+j);
}
else if(i==6)
{
Icon no=new ImageIcon("bpawn.png");
sq[i][j]=new JButton(no);
sq[i][j].setActionCommand("b"+i+j);
}
else if(i==7)
{
  if((j==0)||(j==7))
   {
       Icon cn=new ImageIcon("brook.jpg");
        sq[i][j]=new JButton(cn);
       sq[i][j].setActionCommand("b"+i+j);
       
    }
  else if((j==1)||(j==6))
    {
        Icon cn1=new ImageIcon("bknight.jpg");
        sq[i][j]=new JButton(cn1);
        sq[i][j].setActionCommand("b"+i+j);
      }
   else if((j==2)||(j==5))
     {
        Icon cn2=new ImageIcon("bbishop.jpg");
        sq[i][j]=new JButton(cn2);
       sq[i][j].setActionCommand("b"+i+j);
      }
    else if(j==3)
    {
     Icon cn3=new ImageIcon("bking.jpg");
        sq[i][j]=new JButton(cn3);
        sq[i][j].setActionCommand("b"+i+j);
      }
    else
     {
         Icon cn4=new ImageIcon("bqueen.jpg");
        sq[i][j]=new JButton(cn4);
        sq[i][j].setActionCommand("b"+i+j);
      }
}
else
{
  if((j==0)||(j==7))
   {
       Icon cn=new ImageIcon("wrook.jpg");
        sq[i][j]=new JButton(cn);
       sq[i][j].setActionCommand("b"+i+j); 
    }
  else if((j==1)||(j==6))
    {
        Icon cn1=new ImageIcon("wknight.png");
        sq[i][j]=new JButton(cn1);
        sq[i][j].setActionCommand("b"+i+j);
      }
   else if((j==2)||(j==5))
     {
        Icon cn2=new ImageIcon("wbishop.jpg");
        sq[i][j]=new JButton(cn2);
       sq[i][j].setActionCommand("b"+i+j); 
      }
    else if(j==3)
    {
     Icon cn3=new ImageIcon("wking.jpg");
        sq[i][j]=new JButton(cn3);
        sq[i][j].setActionCommand("b"+i+j);
      }
    else
     {
         Icon cn4=new ImageIcon("wqueen.jpg");
        sq[i][j]=new JButton(cn4);
        sq[i][j].setActionCommand("b"+i+j);
      }
}
if((i+j)%2!=0)
{
sq[i][j].setBackground(Color.black);
}
add(sq[i][j]);
sq[i][j].addActionListener(this);
}
}
}
public void actionPerformed(ActionEvent ae)
{
int g1,g2,q1,q2;
String ng="";
jb[in]=(JButton)ae.getSource();
h+=ae.getActionCommand();
io[in]=jb[in].getIcon();
int f=h.indexOf('b');
char arr=h.charAt(f+1);
char ara=h.charAt(f+2);
 g2=Character.getNumericValue(arr);
q2=Character.getNumericValue(ara);
if(in>0)
{
int r=h.lastIndexOf('b');
System.out.println("b lastindex"+r);
char ar1=h.charAt(r+1);
char ar2=h.charAt(r+2);
g1=Character.getNumericValue(ar1);
q1=Character.getNumericValue(ar2);
System.out.println(h);
  if(!(io[in-1]==null))
  { 
       if(((io[in-1].toString()).equals("bknight.jpg"))||((io[in-1].toString()).equals("wknight.png")))
         {
           if(knight(q1,q2,g1,g2))
             {
              jb[in].setIcon(io[in-1]);
                jb[0].setIcon(null);
                in=0;
	h="";
             }
              else
               {
                 in=0;
                 h="";
               }
         }
         else if(((io[in-1].toString()).equals("bbishop.jpg"))||((io[in-1].toString()).equals("wbishop.jpg")))
         {
             if(bishop(q1,q2,g1,g2))
              {
                jb[in].setIcon(io[in-1]);
                jb[0].setIcon(null);
                in=0;
	h="";
              }
               else
               {
                 in=0;
                 h="";
               }
         }
         else if(((io[in-1].toString()).equals("brook.jpg"))||((io[in-1].toString()).equals("wrook.jpg")))
         {
             if(rook(q1,q2,g1,g2))
             {
               jb[in].setIcon(io[in-1]);
               jb[0].setIcon(null);
               in=0;
               h="";
             }
              else
               {
                 in=0;
                 h="";
               }
         }
         else if((io[in-1].toString()).equals("bpawn.png"))
          {
              if(bpawn(q1,q2,g1,g2))
              {
                jb[in].setIcon(io[in-1]);
                jb[0].setIcon(null);
                in=0;
	h="";
               }
                else
               {
                  if((bp1(q1,q2,g1,g2))&&(!(io[in]==null)))
                  {
                   jb[in].setIcon(io[in-1]);
                    jb[0].setIcon(null);
                  in=0;
                   h="";
                  }
                   else
                   {
                    in=0;
                    h="";
                   }
                }
          }
         else if((io[in-1].toString()).equals("wpawn.png"))
         {
            if(wpawn(q1,q2,g1,g2))
              {
                 jb[in].setIcon(io[in-1]);
                jb[0].setIcon(null);
                in=0;
                h="";
             }
            else
            {
                if((wp1(q1,q2,g1,g2))&&(!(io[in]==null)))
               {
                  jb[in].setIcon(io[in-1]);
                 jb[0].setIcon(null);
                  in=0;
                h="";
                }
                  else
                 {
                   in=0;
                   h="";
                  }
           }
        }
        else if(((io[in-1].toString()).equals("bking.jpg"))||((io[in-1].toString()).equals("wking.jpg")))
         {
             if(king(q1,q2,g1,g2))
              {
                  jb[in].setIcon(io[in-1]);
                   jb[0].setIcon(null);
                   in=0;
                    h="";
               }
               else
               {
                 in=0;
                 h="";
               }
           }
           else if(((io[in-1].toString()).equals("bqueen.jpg"))||((io[in-1].toString()).equals("wqueen.jpg")))
           {
               if(queen(q1,q2,g1,g2))    
                {            
                  jb[in].setIcon(io[in-1]);
                  jb[0].setIcon(null);
                  in=0;
                   h="";
                  }
                   else
               {
                 in=0;
                 h="";
               }
           }
       
     }
    else
    {
    in=0;
     h="";
     JOptionPane.showConfirmDialog(jb[in],"A coin can fill the empty space but not viceversa","invalid move",JOptionPane.WARNING_MESSAGE);
    // System.out.println("empty");
    }
    
}
else
{
in++;
System.out.println("empty");
}
}                                                                                                                                                                                                                                                                                                                                                                 
public boolean knight(int a,int b,int c,int d)
{      
boolean bo=false;      
if(((c==d+2)&&(a==b+1))||((c==d+1)&&(a==b+2))||((c==d-2)&&(a==b-1))||((c==d-1)&&(a==b-2))||((c==d-1)&&(a==b+2))||((c==d-2)&&(a==b+1))||((c==d+2)&&(a==b-1))||((c==d+1)&&(a==b-2)))
bo=true;
return bo;
}
public boolean bishop(int a,int b,int c,int d)
{
boolean bo=false;
if(((b-a)==(d-c))||((b-a)==(c-d)))
bo=true;
return bo;
}
public boolean rook(int a,int b,int c,int d)
{
boolean bo=false;
if((a==b)||(c==d))
bo=true;
return bo;
}
public boolean bpawn(int a,int b,int c,int d)
{
boolean bo=false;
if(d==6)
{
   if((a==b)&&((c==(d-1))||(c==(d-2))))
     bo=true;
}
else
{
    if((a==b)&&(c==(d-1)))
     bo=true;
}
return bo;
}
public boolean wpawn(int a,int b,int c,int d)
{
boolean bo=false;
if(d==1)
{
   if((a==b)&&((c==d+1)||(c==d+2)))
     bo=true;
}
else 
{  
    if((a==b)&&(c==d+1)) 
     bo=true;
}
     return bo;
}
public boolean wp1(int a,int b,int c,int d)
{
boolean bo=false;
  if(((a==b+1)&&(c==d+1))||((a==b-1)&&(c==d+1)))
  bo=true;
   return bo;
}
public boolean bp1(int a,int b,int c,int d)
{
boolean bo=false;
  if(((a==b+1)&&(c==d-1))||((a==b-1)&&(c==d-1)))
  bo=true;
   return bo;
}
public boolean king(int a,int b,int c,int d)
{
boolean bo=false;
if(((a==b)&&((c-d==1)||(c-d==-1)))||((c==d)&&((a-b==1)||(a-b==-1)))||((a-b==1)&&(c-d==1))||((a-b==-1)&&(c-d==-1))||((a-b==1)&&(c-d==-1))||((a-b==-1)&&(c-d==1)))
bo=true;
return bo;
}
public boolean queen(int a,int b,int c,int d)
{
boolean bo=false;
if(((a==b)||(c==d))||((b-a)==(d-c))||((b-a)==(c-d)))
bo=true;
return bo;
}
}
class ch extends JFrame
{
Container c;
ch(String s)
{
super(s);
c=getContentPane();
c.add(new panel());
setSize(700,700);
setVisible(true);
addWindowListener(new WindowAdapter()
{
public void windowClosing(WindowEvent w)
{
System.exit(0);
}
});
}
}
public class chess23
{
public static void main(String arg[])
{
new ch("chesssss");
}
}
