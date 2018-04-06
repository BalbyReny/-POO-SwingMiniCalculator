package prueba;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SmolCalculator extends JFrame implements ActionListener
{
    JPanel Keyboard = new JPanel();
    JPanel Display = new JPanel();
    JPanel Operations = new JPanel();
    JPanel Footer = new JPanel();
    JButton [][] Numbers = new JButton[3][3];
    JButton zero, one, two, three, four, five, six, seven, eight, nine, backspace, add, subs, mult, div, equal, decpt, clear;
    JTextField txt1, txt2;
    String temp="", tempAns="", operator="", lastOperator="";
    double ans=0, subAns=0;
    Boolean firstSolve=true;
    public static final Font FONT = new Font(Font.SANS_SERIF, Font.ITALIC, 21);
    
    SmolCalculator()
    {
        setVisible(true);
        setSize(350, 400);
        Keyboard.setVisible(true);
        Display.setVisible(true);
        Operations.setVisible(true);
        Footer.setVisible(true);
        setTitle("MiniCalc");
        Keyboard.setLayout(new GridLayout(4,4));
        Display.setLayout(new GridLayout(2,1));
        Operations.setLayout(new GridLayout(4,2));
        Footer.setLayout(new GridLayout(1,1));
        Display.setBorder(BorderFactory.createEmptyBorder(5,5,10,5));
        Keyboard.setBorder(BorderFactory.createEmptyBorder(0,10,5,10));
        Operations.setBorder(BorderFactory.createEmptyBorder(0,3,5,10));
        Footer.setBorder(BorderFactory.createEmptyBorder(5,10,10,10));
        setResizable(true);
        setLayout(new BorderLayout()); //* must edit, use a layout instead of doing maths with dimensions and coordinates
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        txt1 = new JTextField("");
        Display.add(txt1);
        txt1.setEnabled(false);
        txt1.setFont(FONT);
        txt2 = new JTextField("");
        Display.add(txt2);
        txt2.setEnabled(false);
        txt2.setFont(FONT);
        
        mult = new JButton("*");
        mult.addActionListener(this);
        mult.setFont(FONT);
        Operations.add(mult);

        div = new JButton("/");
        div.addActionListener(this);
        div.setFont(FONT);
        Operations.add(div);

        add = new JButton("+");
        add.addActionListener(this);
        add.setFont(FONT);
        Operations.add(add);

        subs = new JButton("-");
        subs.addActionListener(this);
        subs.setFont(FONT);
        Operations.add(subs);
    
        
        int c=9;
        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                Numbers[i][j]=new JButton(""+c);
                Numbers[i][j].addActionListener(this);
                Numbers[i][j].setFont(FONT);
                Keyboard.add(Numbers[i][j]);
                c--;
            }
        }
        
        zero = new JButton("0");
        zero.addActionListener(this);
        Keyboard.add(zero);
        zero.setFont(FONT);
        
        nine=Numbers[0][0];
        eight=Numbers[0][1];
        seven=Numbers[0][2];
        six=Numbers[1][0];
        five=Numbers[1][1];
        four=Numbers[1][2];
        three=Numbers[2][0];
        two=Numbers[2][1];
        one=Numbers[2][2];

        decpt = new JButton(".");
        decpt.addActionListener(this);
        decpt.setFont(FONT);
        Keyboard.add(decpt);
        
        equal = new JButton("=");
        equal.addActionListener(this);
        equal.setFont(FONT);
        Keyboard.add(equal);
   
        clear = new JButton("Clear");
        clear.addActionListener(this);
        clear.setFont(FONT);
        Footer.add(clear);
        
        add(BorderLayout.NORTH, Display);
        add(BorderLayout.CENTER, Keyboard);
        add(BorderLayout.EAST, Operations);
        add(BorderLayout.SOUTH, Footer);
        
        pack();
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==one){
                temp +="1";
                txt1.setText(temp);
                tempAns += "1";
        }
        if(e.getSource()==two){
                temp+= "2";
                txt1.setText(temp);
                tempAns +="2";
        }
        if(e.getSource()==three){
                temp+= "3";
                txt1.setText(temp);
                tempAns +="3";
        }
        if(e.getSource()==four){
                temp+= "4";
                txt1.setText(temp);
                tempAns +="4";
        }
        if(e.getSource()==five){
                temp+= "5";
                txt1.setText(temp);
                tempAns +="5";
        }
        if(e.getSource()==six){
                temp+= "6";
                txt1.setText(temp);
                tempAns +="6";
        }
        if(e.getSource()==seven){
                temp+= "7";
                txt1.setText(temp);
                tempAns +="7";
        }
        if(e.getSource()==eight){
                temp+= "8";
                txt1.setText(temp);
                tempAns +="8";
        }
        if(e.getSource()==nine){
                temp+= "9";
                txt1.setText(temp);
                tempAns +="9";
        }
        if(e.getSource()==zero){
                temp+= "0";
                txt1.setText(temp);
                tempAns +="0";
        }
        if(e.getSource()==decpt){
                temp+=".";
                txt1.setText(temp);
                tempAns +=".";
        }
        if(e.getSource()==add){
            temp+="+";
            txt2.setText(temp);
            operator+="+";
            if(firstSolve){
                subAns = Double.parseDouble(tempAns);
                firstSolve = false;
            }
            process();
        }
        if(e.getSource()==subs){
            temp+="-";
            txt2.setText(temp);
            operator+="-";
            if(firstSolve){
                subAns = Double.parseDouble(tempAns);
                firstSolve = false;
            }
            process();
        }
        if(e.getSource()==mult){
            temp+="*";
            txt2.setText(temp);
            operator+="*";
            if(firstSolve){
                subAns = Double.parseDouble(tempAns);
                firstSolve = false;
            }
            process();
        }
        if(e.getSource()==div){
            temp+="/";
            txt2.setText(temp);
            operator+="/";
            if(firstSolve){
                subAns = Double.parseDouble(tempAns);
                firstSolve = false;
            }
            process();
        }
        if(e.getSource()==clear){
            txt1.setText("");
            txt2.setText("");
            temp+="";
            tempAns="";
            operator = "";
            subAns = 0;
            firstSolve = true;
        }
        if(e.getSource()==equal){
            process();
            txt2.setText(""+ans);
            temp = "";
            tempAns = "";
        }
    }
    
    public void process()
    {
        ans = Double.parseDouble(tempAns);

        switch(lastOperator)
        {
            case "+":
                ans = subAns + ans;
                break;
            case "-":
                ans = subAns - ans;
                break;
            case "*":
                ans = subAns * ans;
                break;
            case "/":
                ans = subAns / ans;
                break;
            default:
                break;
        }

        lastOperator = operator;
        subAns = ans;
        operator="";
        tempAns="";
    }            
                
    public static void main(String[] xd)
    {
        SmolCalculator MyCalc = new SmolCalculator();        
    }   
}
