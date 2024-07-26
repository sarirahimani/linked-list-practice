package assignment1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DLinkedListGUI extends JFrame implements ActionListener{
 
	private JTextArea output;
	private JLabel remLabel, remFBLabel, remDataLabel, aIndexLabel, aDataLabel1, aDataLabel2, addFrontLabel, addLabel;
	private JTextField dataInput1,dataInput2,dataInput3, indexInput;
	private JPanel inPanel, outPanel, mainPanel;
	private JButton addIndex, addFront, addBack, remove, front, back;
	private DLinkedList<Integer> numList = new DLinkedList<Integer>(); 
	private int data1;
	private int data2;
	private int data3;
	private int index;
	
	public DLinkedListGUI() {
		
		data1=0;
		data2=0;
		data3=0;
		index=0;
		
		inPanel = new JPanel();
		inPanel.setLayout(new GridLayout(20,1));
		
		outPanel = new JPanel();
		outPanel.setLayout(new FlowLayout());
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout());
		
		remLabel = new JLabel("Remove:");
		remFBLabel= new JLabel("Remove from the front/back:"); 
		remDataLabel= new JLabel("Data:");
		aIndexLabel= new JLabel("Index:");
		aDataLabel1= new JLabel("Data:");
		aDataLabel2= new JLabel("Data:");
		addFrontLabel= new JLabel("Add to the front/back:");
		addLabel= new JLabel("Add at an index:");
	
		output=new JTextArea(20,20);
	
		addIndex=new JButton("Add at Index!");
		addIndex.addActionListener(this);
		addFront =new JButton("Add to Front!");
		addFront.addActionListener(this);
		addBack=new JButton("Add to Back!");
		addBack.addActionListener(this);
		remove=new JButton("Remove!");
		remove.addActionListener(this);
		front =new JButton("Front!");
		front.addActionListener(this);
		back=new JButton("Back!");
		back.addActionListener(this);
	
		dataInput1 = new JTextField(15);
		dataInput1.addActionListener(this);
	
		dataInput2 = new JTextField(15);
		dataInput2.addActionListener(this);
	
		dataInput3 = new JTextField(15);
		dataInput3.addActionListener(this);
	
		indexInput = new JTextField(15);
		indexInput.addActionListener(this);
	
		inPanel.add(addLabel);
		inPanel.add(aDataLabel1);
		inPanel.add(dataInput1);
		inPanel.add(aIndexLabel);
		inPanel.add(indexInput);
		inPanel.add(addIndex);
	
		inPanel.add(addFrontLabel);
		inPanel.add(aDataLabel2);
		inPanel.add(dataInput2);
		inPanel.add(addFront);
		inPanel.add(addBack);
	
	
		inPanel.add(remLabel);
		inPanel.add(remDataLabel);
		inPanel.add(dataInput3);
		inPanel.add(remove);
	
		inPanel.add(remFBLabel);
		inPanel.add(front);
		inPanel.add(back);
	
		outPanel.add(new JScrollPane(output));

		mainPanel.add(inPanel);
		mainPanel.add(outPanel);
		this.add(mainPanel);
	
	}
 

	public void actionPerformed(ActionEvent actEvent) {
	try {
		 if(actEvent.getSource()==addIndex) {
			 
			 String  initialData1= dataInput1.getText();
			 data1=Integer.parseInt(initialData1);
				
			 String  initialIndex= indexInput.getText();
			 index=Integer.parseInt(initialIndex);
			 
			 numList.addAfter(data1,index);
			 String out="List is composed of:\n"+numList.toString()+"\n";
			 output.append(out);
			 
		 }else if(actEvent.getSource()==addFront) {
			 
			 String  initialData2= dataInput2.getText();
			 data2=Integer.parseInt(initialData2);
			 numList.addFront(data2);
			 String out="List is composed of:\n"+numList.toString()+"\n";
			 output.append(out);
		 }else if(actEvent.getSource()==addBack) {
			 
			 String  initialData2= dataInput2.getText();
			 data2=Integer.parseInt(initialData2);
			 numList.addBack(data2);
			 String out="List is composed of: \n"+numList.toString()+"\n";
			 output.append(out);
		 }else if(actEvent.getSource()== remove) {
			 
			 String  initialData3= dataInput3.getText();
			 data3=Integer.parseInt(initialData3);
			 numList.remove(data3);
			 String out="List is composed of: \n"+numList.toString()+"\n";
			 output.append(out);
		 }else if(actEvent.getSource()==front) {
			 numList.removeFirst();
			 String out="List is composed of: \n"+numList.toString()+"\n";
			 output.append(out);
		 }else if(actEvent.getSource()==back) {
			 numList.removeLast();
			 String out="List is composed of: \n"+numList.toString()+"\n";
			 output.append(out);
		 }
		 
		 
	}catch(NumberFormatException numFormEx) {
		JOptionPane.showMessageDialog(null, "Not valid input");
	}	 
			 
}
		 
		 
			


 public static void main(String[] args) {

		
		DLinkedListGUI gui = new DLinkedListGUI();
		
		
		gui.setVisible(true); 
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		gui.setSize(600,600);  
		gui.setTitle("Doubly Linked List GUI"); 
		gui.setResizable(false);
	}

		
}
