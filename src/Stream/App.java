package Stream;

import java.awt.*;

import javax.swing.*;

public class App {

	public static void main(String[] args) {
		generateLayout();

	}
	
	public static void generateLayout() {
		JFrame frame 			= new JFrame();
		frame.setTitle("Minha Aplicação");
		frame.setSize(800, 600);
		
		JPanel panel           	= new JPanel(new GridBagLayout());
		//GridBagConstraint como o componente se comporta dentro da grade do 
		//gridBagLayout
		GridBagConstraints gbc 	= new GridBagConstraints();
		gbc.insets				= new Insets(5,5,5,5);
		gbc.fill 				= GridBagConstraints.HORIZONTAL;
		
		gbc.gridx = 0; //coluna
		gbc.gridy = 1; //linha
		panel.add(new JLabel("Nome: "), gbc);
		
		gbc.gridx = 0; //coluna
		gbc.gridy = 2; //linha
		panel.add(new JTextField(20), gbc);
		
		frame.add(panel);
		frame.setVisible(true);
	}

}
