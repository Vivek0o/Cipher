import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField; 

class MyListner implements ActionListener, KeyListener{
    static JLabel lb;
    static JTable jt;
    public void actionPerformed(ActionEvent e){
    if(e.getActionCommand().equals("Image")){
        JFileChooser jc = new JFileChooser();
        jc.showOpenDialog(null);
        String filepath = jc.getSelectedFile().getPath();
        GUIForm.image_path=filepath;
    }
    else if(e.getActionCommand().equals("Reset")){
        GUIForm.t1.setText(null);
        GUIForm.t2.setText(null);
        GUIForm.t3.setText(null);
        GUIForm.jcb.setSelectedItem("Machine Learning");
        GUIForm.d1.setText(null);
    }
    else if(e.getActionCommand().equals("Submit")){
        //checking 
        if(GUIForm.t1.getText().equals("")||
           GUIForm.t2.getText().equals("")||
           GUIForm.t3.getText().equals("")||
           GUIForm.jcb.getSelectedItem().toString().equals("")||
           GUIForm.image_path.equals("")){
        GUIForm.d1.setText("All Fields are Required");
        GUIForm.d1.setForeground(new Color(255,0,0));
        return;
        }

        JFrame preview = new JFrame("Preview");
        lb = new JLabel();
        preview.setLayout(null);
        preview.add(lb);
        lb.setBounds(145,20,150,150);
        lb.setIcon(new ImageIcon(new ImageIcon(GUIForm.image_path).getImage().getScaledInstance(150,150, Image.SCALE_DEFAULT)));
        String [] header={"Name","CGPA","Qualification","Specialization","Email"};
        String is_selected="No";
        if(GUIForm.c1.isSelected()){
            is_selected="Yes";
        }
        String [][] form_result={{
        GUIForm.t1.getText().toString(),
        GUIForm.t2.getText().toString(),
        GUIForm.t3.getText().toString(),
        GUIForm.jcb.getSelectedItem().toString(),
        is_selected
        }};
        jt = new JTable(form_result,header);
        JScrollPane jsp = new JScrollPane(jt, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        preview.add(jsp);
        jsp.setBounds(5,200,420,50);
        JPanel bottom = new JPanel();
        preview.add(bottom);
        bottom.setBounds(120,300,200,200);
        JButton next = new JButton("Next");
        MyListner myListner = new MyListner();
        JButton img_upd = new JButton("Reselect");
        preview.add(img_upd);
        img_upd.setBounds(145,170,150,20);
        img_upd.addActionListener(myListner);
        next.addActionListener(myListner);
        bottom.add(next);
        JButton previous = new JButton("Previous");
        bottom.add(previous);
        preview.setSize(440,400);
        preview.setLocationRelativeTo(null);
        preview.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        preview.setVisible(true);
    }
    else if(e.getActionCommand().equals("Reselect")){
        JFileChooser jc = new JFileChooser();
        jc.showOpenDialog(null);
        String filepath = jc.getSelectedFile().getPath();
        GUIForm.image_path=filepath;
        lb.setIcon(new ImageIcon(new ImageIcon(GUIForm.image_path).getImage().getScaledInstance(150,150, Image.SCALE_DEFAULT)));
    }
    else if(e.getActionCommand().equals("Next")){
        GUIForm.t1.setText(jt.getValueAt(0,0).toString());
        GUIForm.t2.setText(jt.getValueAt(0,1).toString());
        GUIForm.t3.setText(jt.getValueAt(0,2).toString());
        GUIForm.jcb.setSelectedItem(jt.getValueAt(0,3).toString());
        if(jt.getValueAt(0,4).toString().equals("Yes")){
            GUIForm.c1.setSelected(true);
        }
        else{
            GUIForm.c1.setSelected(false);
        }
        //Printing Updated values
        System.out.println(GUIForm.t1.getText());
        System.out.println(GUIForm.t2.getText());
        System.out.println(GUIForm.t3.getText());
        System.out.println(GUIForm.jcb.getSelectedItem().toString());
        System.out.println(GUIForm.image_path);
        System.out.println(GUIForm.c1.isSelected());
    }
    else if(e.getActionCommand().equals("Previous")){
        System.out.println("Under Construction");
    }
    }
}

public class GUIForm {
    static JButton b0,b1,b2;
    static JLabel l1,l2,l3,l4,d1;
    static JTextField t1,t2,t3;
    static JPasswordField p1;
    static JCheckBox c1;
    static String [] arr = {"Machine Learning", "Data Science", "Full Stack", "Cyber Security"};
    static JFrame jf = new JFrame("Placement Registration");
    static JComboBox <String> jcb = new JComboBox<>(arr);
    
    static String image_path="";
    public static void main(String[] args) {
        jcb.setSelectedItem("Machine Learning");
        b0 = new JButton("Image");
        b1 = new JButton("Submit");
        b2 = new JButton("Reset");
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        p1 = new JPasswordField();
        l1 = new JLabel("Name");
        l1.setForeground(new Color(255,255,255));
        l2 = new JLabel("CGPA");
        l2.setForeground(new Color(255,255,255));
        l3 = new JLabel("Qualification");
        l3.setForeground(new Color(255,255,255));
        l4 = new JLabel("Specialization");
        l4.setForeground(new Color(255,255,255));
        d1 = new JLabel("");
        d1.setForeground(new Color(255,255,255));
        jf.setLayout(null);

        jf.add(l1);
        l1.setBounds(50, 50,200,50);
        l1.setFont(new Font("Serif",1,20));
        jf.add(l2);
        l2.setBounds(50,100,200,50);
        l2.setFont(new Font("Serif", 1, 20));
        jf.add(l3);
        l3.setBounds(50,150,200,50);
        l3.setFont(new Font("Serif",1,20));
        jf.add(l4);
        l4.setBounds(50,200,200,50);
        l4.setFont(new Font("Serif",1,20));

        jf.add(t1);
        t1.setBounds(200,60,100,30);
        jf.add(t2);
        t2.setBounds(200,110,100,30);
        jf.add(t3);
        t3.setBounds(200,160,100,30);
        jf.add(jcb);
        jcb.setBounds(200,210,100,30);
    
        jf.add(b0);
        b0.setBounds(120,260,100,30);
        
        c1=new JCheckBox("Opt for Emails");
        jf.add(c1);
        c1.setBounds(120,330,150,20);
        c1.setBackground(new Color(36, 27, 46));
        c1.setForeground(new Color(255,255,255));

        jf.add(d1);
        d1.setFont(new Font("Serif",3,16));
        d1.setBounds(90,290,200,50);

        jf.add(b1);
        b1.setBounds(50, 370, 100, 40);
        jf.add(b2);
        b2.setBounds(200, 370, 100, 40);


        MyListner myListner=new MyListner();
        b0.addActionListener(myListner);
        b1.addActionListener(myListner);
        b2.addActionListener(myListner);


        jf.setSize(350,500);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.getContentPane().setBackground(new Color(36, 27, 46));
        jf.setVisible(true);
    }
}
