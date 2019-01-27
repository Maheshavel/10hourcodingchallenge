import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class panel extends JPanel implements ActionListener,ItemListener
{
JTextField t1,t2,t3;
JLabel l1,l2,l4,l5,l6,l7,l8,l9,l17,l18,l19;
JButton b1,b2;
JComboBox c1,c2,c3;
String s1,s2,s3,s7,s5,s6;
String month[]={"jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
String day[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"};
String year[]={"2017","2018","2019","2020","2021","2022","2023","2024","2025"};
panel()
{
setLayout(new GridLayout(8,2));
t1=new JTextField(10);
t2=new JTextField(10);
t3=new JTextField(10);
l7=new JLabel();
l8=new JLabel();
l9=new JLabel();
l17=new JLabel("open stock");
l18=new JLabel("sold");
l19=new JLabel("stock");

//l3=new JLabel("Enter Date");
l4=new JLabel("Day");
l5=new JLabel("Month");
l6=new JLabel("Year");
l1=new JLabel("Quantity sold");
l2=new JLabel("Quantity remaining");
b1=new JButton("Update");
b2=new JButton("Retrieve");
c1=new JComboBox(day);
c2=new JComboBox(month);
c3=new JComboBox(year);
//add(l3);
add(l4);
add(c1);
add(l5);
add(c2);
add(l6);
add(c3);
add(l1);
add(t1);
add(l2);
add(t2);
add(b1);
add(b2);
add(l7);
add(l8);
add(l9);
add(l17);
add(l18);
add(l19);
b1.addActionListener(this);
b2.addActionListener(this);
c1.addItemListener(this);
c2.addItemListener(this);
c3.addItemListener(this);
}
   
    @Override
public void actionPerformed(ActionEvent ae)
{
String st=ae.getActionCommand();
s1=t1.getText();
s2=t2.getText();
int i1=Integer.parseInt(s1);
int i2=Integer.parseInt(s2);
int i3=i1-i2;
String s4=Integer.toString(i3);
try
{
    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
if(st.equals("Retrieve"))
{
    String d=l9.getText();
        Statement s=con.createStatement();//=con.prepareStatement("select opening_stock,sold,ending_stock from stock where date_of_sale=");
        //s.executeUpdate("insert into table values(`"+s3+"`,"+i1+","+i2+","+i3+")");
        ResultSet r=s.executeQuery("select opening_stock,sold,ending_stock from stock where date_of_sale='"+d+"' ");
       if(r.next())
       { 
            s5=Integer.toString(r.getInt(1));
            s6=Integer.toString(r.getInt(2));
            s7=Integer.toString(r.getInt(3));
            
            l17.setText("Opening_stock"+s5);
            l18.setText("Sold"+s6);
            l19.setText("Ending_stock"+s7);
        System.out.println(s5+"\t"+s6+"\t"+s7+"\t"+d);
       }
       else
       {
           System.out.println("no data found"+d);
       }
        s.close();
        con.close();
        l7.setText("retrieved");
        
    }
    if(st.equals("Update"))
    {   
        String sr=l9.getText().toString();
        String sr1=t1.getText();
        String sr2=t2.getText();
        String sr3=t3.getText();
         PreparedStatement s=con.prepareStatement("insert into stock(date_of_sale,opening_stock,sold,Ending_stock)values(?,?,?,?)");;
         ResultSet r=s.executeQuery();
         s.setString(1,sr);
         s.setString(2,sr1);
         s.setString(3,sr2);
         s.setString(4,sr3);
         s.close();
         con.close();
         l8.setText("updated");
    }
}
    catch(SQLException e1)
    {
       System.out.print("SQL error"+e1);
    }
    catch(ClassNotFoundException e)
    {
       System.out.print("Class not found  error"+e);
    }
}
    @Override
public void itemStateChanged(ItemEvent ie)
{
String a1=c1.getSelectedItem().toString();
String a2=c2.getSelectedItem().toString();
String a3=c3.getSelectedItem().toString();
s3=a1+" "+a2+" "+a3;
l9.setText(a1+" "+a2+" "+a3);
}

}
class db extends JFrame
{
    panel jp;
Container i;
db(String s)
{
super(s);
i=getContentPane();
i.setLayout(new FlowLayout(FlowLayout.CENTER,10,200));
jp=new panel();
i.add(jp);
//add(new panel());
setSize(1000,1000);
setVisible(true);
addWindowListener(new WindowAdapterImpl());
}

    private static class WindowAdapterImpl extends WindowAdapter {

        public WindowAdapterImpl() {
        }
        @Override
        public void windowClosing(WindowEvent w) {
            System.exit(0);
        }
    }
}
public class Stock1
{
public static void main(String arg[])
{
        new db("stock");
}
}