import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 class Number implements ActionListener{
    JFrame jf=new JFrame();
    JTextField f1;
    int x;
    int y,count=0,score=100;
    Number(){
       
        Random r=new Random();
        x=r.nextInt(100);
        System.out.println(x);
        JLabel l1=new JLabel("guess the number : ");
        f1=new JTextField();
        l1.setBounds(20,20,200,30);
        f1.setBounds(150,20,100,30);
        jf.add(l1);
        jf.add(f1);
        JButton jb=new JButton("submit");
        jb.setBounds(60,50,100,30);
        jf.add(jb);
        jb.addActionListener(this);
        jf.setSize(300,300);
        jf.setLayout(null);
        jf.setVisible(true);
        jf.setLocation(250,100)
    } 
    public void actionPerformed(ActionEvent e)
    {
        String data = f1.getText(); 
        y= Integer.parseInt(data);
        count++;
        
        JFrame sub_frame = new JFrame("Sub Frame");
        sub_frame.setSize(200,200);
        JLabel label;
        if(y==x){
            String k1="number of attempts taken = "+count;
            label = new JLabel(k1+"   Equal-->SUCCEDED   ");
            JLabel l2=new JLabel("score si - "+score);
         
            sub_frame.add(label);
            sub_frame.add(l2);
            sub_frame.setVisible(true); 
            sub_frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            sub_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            return;
        }
        if(count>=5){
          label = new JLabel( "YOU FAILED THIS ROUND");
            sub_frame.add(label);
            sub_frame.setVisible(true); 
            sub_frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            sub_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            return;
        }
        else if(y>x){
            label = new JLabel("too high");
        }
        else{
            label = new JLabel("too low");;
        }
        score=score-10;
        sub_frame.add(label);
        sub_frame.setVisible(true);  
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
    public static void main(String args[]){
       Number n =new Number();
    }
}