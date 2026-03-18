package Stream;

import java.util.HashMap;
import java.util.List;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.PersonController;
import dao.IObjectDAO;
import dao.PersonDAO;
import model.Person;

public class App {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			IObjectDAO<Person> dao			  = new PersonDAO();
			PersonController personController = new PersonController(dao);
			
			generateLayout(personController);
		 });
	}
	
	public static void generateLayout(PersonController personController) {
		JFrame frame 			= new JFrame();
		frame.setTitle("Minha Aplicação");
		frame.setSize(800, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel           	= new JPanel(new GridBagLayout());
		//GridBagConstraint como o componente se comporta dentro da grade do 
		//gridBagLayout
		GridBagConstraints gbc 	= new GridBagConstraints();
		gbc.insets				= new Insets(5,5,5,5);
		gbc.fill 				= GridBagConstraints.HORIZONTAL;
		
		gbc.gridx = 0; //coluna
		gbc.gridy = 1; //linha
		panel.add(new JLabel("Name: "), gbc);
		
		gbc.gridx = 0; //coluna
		gbc.gridy = 2; //linha
		gbc.gridwidth = 2;
		JTextField inputA 		= new JTextField(20);

		panel.add(inputA, gbc);
		
		gbc.gridx = 0; //coluna
		gbc.gridy = 3; //linha
		panel.add(new JLabel("Gender: "), gbc);
		
		gbc.gridx = 0; //coluna
		gbc.gridy = 4; //linha
		gbc.gridwidth = 2;
		JTextField inputB 		= new JTextField(20);
		
		panel.add(inputB, gbc);
		
		
		
		//Criação da tabela
		String[] c 				= {"Name", "Gender"};
		DefaultTableModel model = new DefaultTableModel(c, 0);
		JTable table 			= new JTable(model);
		gbc.gridx = 0; //coluna
		gbc.gridy = 8; //linha
		gbc.gridwidth = 2;
		panel.add(new JScrollPane(table), gbc); 

		
		//Criação do primeiro botão
		gbc.gridx = 0; //coluna
		gbc.gridy = 5; //linha
		gbc.gridwidth = 2;
		JButton button 			= new JButton("Click here to add");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectionButtonPressed(inputA, inputB, model, personController);
			}
		}
				
				);
		panel.add(button, gbc);
		
		//Criação do segundo botão
		gbc.gridx = 0; //coluna
		gbc.gridy = 6; //linha
		gbc.gridwidth = 2;
		JButton button2 		= new JButton("Click here to sort a list only with Women");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectionButtoToFilter(inputA, inputB, model, personController, gbc, panel, table);
			}
		}
				
				);
		panel.add(button2, gbc);
		
		
		frame.add(panel);
		frame.setVisible(true);
	}
	
	
	
	
	public static void selectionButtonPressed(JTextField inputA, JTextField inputB, DefaultTableModel model, 
			PersonController personController) {
			
				String name 			= inputA.getText();
				String genderString 	= inputB.getText();
			
				if (genderString.isEmpty() || name.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Campo está vazio");
				} else {
					model.addRow(new Object[]{name, genderString});
					personController.addToList(name, genderString.charAt(0));
					inputA.setText("");
					inputB.setText("");
				}
	}
	
	public static void selectionButtoToFilter(JTextField inputA, JTextField inputB, DefaultTableModel model, PersonController personController, 
			GridBagConstraints gbc, JPanel panel, JTable table) {
	
		model.setRowCount(0);
		
		
		HashMap<String, Character> list = personController.filterListPeople();
		
	
		list.forEach((key,value) -> model.addRow(new Object[]{key, value}));
	     
	}
}
	
