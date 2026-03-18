package Stream;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class App {

	public static void main(String[] args) {
		generateLayout();

	}
	
	public static void generateLayout() {
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
		JTextField inputA 		= new JTextField(20);

		panel.add(inputA, gbc);
		
		gbc.gridx = 0; //coluna
		gbc.gridy = 3; //linha
		panel.add(new JLabel("Gender: "), gbc);
		
		gbc.gridx = 0; //coluna
		gbc.gridy = 4; //linha
		JTextField inputB 		= new JTextField(20);
		
		panel.add(inputB, gbc);
		
		
		
		String[] c 				= {"Name", "Gender"};
		DefaultTableModel model = new DefaultTableModel(c, 0);
		JTable table 			= new JTable(model);
		gbc.gridx = 0; //coluna
		gbc.gridy = 8; //linha
		gbc.gridwidth = 2;
		panel.add(table,gbc);
		
		
		gbc.gridx = 0; //coluna
		gbc.gridy = 5; //linha
		gbc.gridwidth = 2;
		JButton button 			= new JButton("Clique aqui para enviar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectionButtonPressed(inputA, inputB, model);
			}
		}
				
				);
		panel.add(button, gbc);
		
		
		frame.add(panel);
		frame.setVisible(true);
	}
	public static void selectionButtonPressed(JTextField inputA, JTextField inputB, DefaultTableModel model) {
			
				String gender 			= inputB.getText();
				String name 			= inputA.getText();
			
				if (gender.isEmpty() || name.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Campo está vazio");
				} else {
					model.addRow(new Object[]{name, gender});
					inputA.setText("");
					inputB.setText("");
				}
	}

}
	
