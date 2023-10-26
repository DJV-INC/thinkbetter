package djvinc.thinkbetter.pack_view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import djvinc.thinkbetter.pack_controle.EspecialistaControle;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastrarEspecialistaView extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public void abreCadastroEspecialista(){
		try {
			CadastrarEspecialistaView dialog = new CadastrarEspecialistaView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CadastrarEspecialistaView() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registrar - Especialista");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(10, 11, 123, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setBounds(10, 43, 46, 14);
		contentPanel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(10, 59, 414, 28);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tipo especialista:");
		lblNewLabel_1_1.setBounds(10, 103, 123, 14);
		contentPanel.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 122, 123, 28);
		contentPanel.add(textField_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Grupo:");
		lblNewLabel_1_1_1.setBounds(159, 103, 82, 14);
		contentPanel.add(lblNewLabel_1_1_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D"}));
		comboBox.setBounds(159, 122, 88, 28);
		contentPanel.add(comboBox);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Empresa\r\n:");
		lblNewLabel_1_1_1_1.setBounds(280, 103, 82, 14);
		contentPanel.add(lblNewLabel_1_1_1_1);
		
		
		
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Orange 4", "Accenture", "Adrenalina"}));
		comboBox_1.setBounds(280, 122, 88, 28);
		contentPanel.add(comboBox_1);
		
		JLabel lblEspecialistaCadastrado = new JLabel("Especialista cadastrado!");
		lblEspecialistaCadastrado.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEspecialistaCadastrado.setBounds(10, 203, 175, 14);
		contentPanel.add(lblEspecialistaCadastrado);
		lblEspecialistaCadastrado.setVisible(false);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						EspecialistaControle oEspecialistaControle = new EspecialistaControle();
					
						String tipo = textField_1.getText();
						String grupo = comboBox.getSelectedItem().toString();
						String empresa = comboBox_1.getSelectedItem().toString();
						
						oEspecialistaControle.inserirEspecialista(tipo, 1, 1);
						
						lblEspecialistaCadastrado.setVisible(true);
						
					}
				});
				
				
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
