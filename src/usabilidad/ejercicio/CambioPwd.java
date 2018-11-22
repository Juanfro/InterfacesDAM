package usabilidad.ejercicio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;

public class CambioPwd {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CambioPwd window = new CambioPwd();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CambioPwd() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 343, 217);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNuevaContrasea = new JLabel("Nueva Contraseña");
		GridBagConstraints gbc_lblNuevaContrasea = new GridBagConstraints();
		gbc_lblNuevaContrasea.anchor = GridBagConstraints.WEST;
		gbc_lblNuevaContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblNuevaContrasea.gridx = 1;
		gbc_lblNuevaContrasea.gridy = 1;
		frame.getContentPane().add(lblNuevaContrasea, gbc_lblNuevaContrasea);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		frame.getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblConfirmarContrasea = new JLabel("Confirmar Contraseña");
		GridBagConstraints gbc_lblConfirmarContrasea = new GridBagConstraints();
		gbc_lblConfirmarContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblConfirmarContrasea.anchor = GridBagConstraints.EAST;
		gbc_lblConfirmarContrasea.gridx = 1;
		gbc_lblConfirmarContrasea.gridy = 2;
		frame.getContentPane().add(lblConfirmarContrasea, gbc_lblConfirmarContrasea);
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 2;
		gbc_passwordField.gridy = 2;
		frame.getContentPane().add(passwordField, gbc_passwordField);
		
		JLabel lblLasContraseasNo = new JLabel("Las contraseñas no coinciden");
		lblLasContraseasNo.setForeground(Color.RED);
		GridBagConstraints gbc_lblLasContraseasNo = new GridBagConstraints();
		gbc_lblLasContraseasNo.insets = new Insets(0, 0, 5, 5);
		gbc_lblLasContraseasNo.gridx = 1;
		gbc_lblLasContraseasNo.gridy = 3;
		frame.getContentPane().add(lblLasContraseasNo, gbc_lblLasContraseasNo);
		
		JButton btnCambiar = new JButton("Cambiar");
		GridBagConstraints gbc_btnCambiar = new GridBagConstraints();
		gbc_btnCambiar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCambiar.anchor = GridBagConstraints.SOUTH;
		gbc_btnCambiar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCambiar.gridx = 2;
		gbc_btnCambiar.gridy = 3;
		frame.getContentPane().add(btnCambiar, gbc_btnCambiar);
	}

}
