
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CalculatorGUI {
  String lastCommand = "=";
  String lastResult = "" + 0;
  String result = "" + 0;
  boolean start = true;
  
  // ���ð�ť
  private Button[] btn;
  private Button keyequal, keyplus, keyminus;
  private Button keyperiod, keymult, keydiv;
  private Panel buttonArea;

  // ��ʾ��
  private Label answer;

  //���캯����ʼ���������
  public CalculatorGUI() {
    answer = new Label("0.0",Label.RIGHT);
    btn = new Button[10];
    for (int i = 0; i < 10; ++i) {
        btn[i] = new Button("" + i);
    }
    keyequal = new Button("=");
    keyplus = new Button("+");
    keyminus = new Button("-");
    keymult = new Button("*");
    keydiv = new Button("/");
    keyperiod = new Button(".");
    buttonArea = new Panel();
  }

  //��������Ĳ���
  public void launchFrame() {
    buttonArea.setLayout(new GridLayout(4,4));

    buttonArea.add(btn[7]);
    buttonArea.add(btn[8]);
    buttonArea.add(btn[9]);
    buttonArea.add(keyplus);
    buttonArea.add(btn[4]);
    buttonArea.add(btn[5]);
    buttonArea.add(btn[6]);
    buttonArea.add(keyminus);
    buttonArea.add(btn[1]);
    buttonArea.add(btn[2]);
    buttonArea.add(btn[3]);
    buttonArea.add(keymult);
    buttonArea.add(btn[0]);
    buttonArea.add(keyperiod);
    buttonArea.add(keyequal);
    buttonArea.add(keydiv);

    for (int i = 0; i < 10; ++i) {
        btn[i].addActionListener(new myListener());
    }
    keyplus.addActionListener(new myListener());
    keyminus.addActionListener(new myListener());
    keymult.addActionListener(new myListener());
    keyperiod.addActionListener(new myListener());
    keyequal.addActionListener(new myListener());
    keydiv.addActionListener(new myListener());
    
    // ����һ�����
    JFrame f = new JFrame("Calculator");
    f.setSize(200, 200);

    f.add(answer, BorderLayout.NORTH);
    f.add(buttonArea, BorderLayout.CENTER);
    f.setVisible (true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  //ʵ����һ���µ�CalculatorGUI����Ȼ�����launchFrame����
  public static void main(String args[]) {
    CalculatorGUI calcGUI = new CalculatorGUI();
    calcGUI.launchFrame();
  }
 
  //�ڲ���
  class myListener implements ActionListener
  {
    	 public void actionPerformed(ActionEvent e) {
    		 
  		String command = e.getActionCommand();
  		//�ж��Ƿ�Ϊ��һ������
  		if (start) {
       	 answer.setText(command); 
            result = command;
            start = false;
        }
        else {
         //�����=��ֱ��������
       	 if(command=="=") {
       		 answer.setText(result);
       	 }
       	 else {
           		answer.setText(answer.getText()+command); 
           		Calculator cal = new Calculator(result, command);
           		//��������
                if (lastCommand.equals("+")) {
                    result = cal.opAdd(command);
                }
                else if (lastCommand.equals("-")) {
                    result = cal.opSubtract(command);
                }
                else if (lastCommand.equals("*")) {
                    result = cal.opMultiply(command);
                }
                else if (lastCommand.equals("/")) {
                    result = cal.opDivide(command);
                }
                //��������
                else if (lastCommand.equals("=")) {
               	 if(command.equals("0")||command.equals("1")||command.equals("2")||command.equals("3")
               			 ||command.equals("4")||command.equals("5")||command.equals("6")
               			 ||command.equals("7")||command.equals("8")||command.equals("9")) {
                    result = command;
                    answer.setText(result);
               	 }
               	 else {
               	 }
                }
                //��С�������������
                else if(lastCommand.equals(".")) {
                	if(command.equals("0")||command.equals("1")||command.equals("2")||command.equals("3")
                  			 ||command.equals("4")||command.equals("5")||command.equals("6")
                  			 ||command.equals("7")||command.equals("8")||command.equals("9")) {
                			result = result + "." + command;
                	}
                }
                else {
               	 }
           }      
       	 }
  		//����ָ��
        lastCommand = command;
  	 }
  }
  
}
