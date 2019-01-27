import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
class panel extends JPanel implements ActionListener
{
JButton b,c,d,e,v;
JTextField jl;
String m,l="";
char aa[]=new char[10];
char ab[]=new char[10];
panel()
{
jl=new JTextField(5);
setLayout(new GridLayout(6,3));
JButton eq=new JButton("=");
JButton c1=new JButton("c");
JButton b1=new JButton("1");
JButton b2=new JButton("2");
JButton b3=new JButton("3");
JButton b4=new JButton("4");
JButton b5=new JButton("5");
JButton b6=new JButton("6");
JButton b7=new JButton("7");
JButton b8=new JButton("8");
JButton b9=new JButton("9");
JButton bb=new JButton("0");
b=new JButton("+");
c=new JButton("-");
d=new JButton("*");
e=new JButton("/");
v=new JButton("Del");
add(jl);
add(b1);
add(b2);
add(b3);
add(b4);
add(b5);
add(b6);
add(b7);
add(b8);
add(b9);
add(bb);
add(b);
add(c);
add(d);
add(e);
add(eq);
add(v);
add(c1);
c1.addActionListener(this);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
b5.addActionListener(this);
b6.addActionListener(this);
b7.addActionListener(this);
b8.addActionListener(this);
b9.addActionListener(this);
bb.addActionListener(this);
b.addActionListener(this);
c.addActionListener(this);
d.addActionListener(this);
e.addActionListener(this);
eq.addActionListener(this);
v.addActionListener(this);
}
public void actionPerformed(ActionEvent ai)
{
m=ai.getActionCommand();
if(m.equals("1"))
l=l+"1";
if(m.equals("2"))
l=l+"2";
if(m.equals("3"))
l=l+"3";
if(m.equals("4"))
l=l+"4";
if(m.equals("5"))
l=l+"5";
if(m.equals("6"))
l=l+"6";
if(m.equals("7"))
l=l+"7";
if(m.equals("8"))
l=l+"8";
if(m.equals("9"))
l=l+"9";
if(m.equals("0"))
l=l+"0";
if(m.equals("+"))
l=l+"+";
if(m.equals("-"))
l=l+"-";
if(m.equals("*"))
l=l+"*";
if(m.equals("/"))
l=l+"/";
jl.setText(l);
if(m.equals("Del"))
{
String str=jl.getText();
jl.setText(" ");
for(int i=0;i<str.length()-1;i++)
{
jl.setText(jl.getText()+str.charAt(i));
l=jl.getText();
}
}
if(m.equals("="))
{
String an=jl.getText();
if(an.contains("+"))
{
int ii=an.indexOf('+');
an.getChars(0,ii,aa,0);
String af1=new String(aa);
String aaf=af1.trim();

int j=an.length();
an.getChars(ii+1,j,ab,0);
String af2=new String(ab);
String aff2= af2.trim();
int iii=Integer.parseInt(aaf);
int ii2=Integer.parseInt(aff2);
int ii3=iii+ii2;
String ssn=Integer.toString(ii3);
jl.setText(ssn);
}
else if(an.contains("*"))
{
int ii=an.indexOf('*');
an.getChars(0,ii,aa,0);
String af1=new String(aa);
String aaf=af1.trim();
int j=an.length();
an.getChars(ii+1,j,ab,0);

String af2=new String(ab);
String aff2= af2.trim();
int iii=Integer.parseInt(aaf);
int ii2=Integer.parseInt(aff2);
int ii3=iii*ii2;
String ssn=Integer.toString(ii3);
jl.setText(ssn);
}
else if(an.contains("-"))
{
int ii=an.indexOf('-');
an.getChars(0,ii,aa,0);
String af1=new String(aa);
String aaf=af1.trim();
int j=an.length();
an.getChars(ii+1,j,ab,0);

String af2=new String(ab);
String aff2= af2.trim();
int iii=Integer.parseInt(aaf);
int ii2=Integer.parseInt(aff2);
int ii3=iii-ii2;
String ssn=Integer.toString(ii3);
jl.setText(ssn);
}
else
{
int ii=an.indexOf('/');
an.getChars(0,ii,aa,0);
String af1=new String(aa);
String aaf=af1.trim();
int j=an.length();
an.getChars(ii+1,j,ab,0);

String af2=new String(ab);
String aff2= af2.trim();
float iii=Float.parseFloat(aaf);
float ii2=Float.parseFloat(aff2);
float ii3=iii/ii2;
String ssn=Float.toString(ii3);
jl.setText(ssn);
}
}
if(m.equals("c"))
jl.setText("");
l=jl.getText();
}
}
class calc extends JFrame
{
Container i;
calc(String s)
{
super(s);
i=getContentPane();
i.setLayout(new FlowLayout(FlowLayout.LEFT));
add(new panel());
setSize(190,200);
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
public class cal
{
public static void main(String arg[])
{
new calc("calculator");
}
}
