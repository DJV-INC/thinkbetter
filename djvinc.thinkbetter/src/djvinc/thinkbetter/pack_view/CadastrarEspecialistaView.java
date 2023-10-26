package djvinc.thinkbetter.pack_view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

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
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 46, 123, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setBounds(10, 78, 46, 14);
		contentPanel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(10, 94, 414, 28);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tipo especialista:");
		lblNewLabel_1_1.setBounds(10, 138, 123, 14);
		contentPanel.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 157, 123, 28);
		contentPanel.add(textField_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Grupo:");
		lblNewLabel_1_1_1.setBounds(159, 138, 82, 14);
		contentPanel.add(lblNewLabel_1_1_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D"}));
		comboBox.setBounds(159, 157, 88, 28);
		contentPanel.add(comboBox);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Empresa\r\n:");
		lblNewLabel_1_1_1_1.setBounds(280, 138, 82, 14);
		contentPanel.add(lblNewLabel_1_1_1_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Orange 4", "Accenture", "Adrenalina"}));
		comboBox_1.setBounds(280, 157, 88, 28);
		contentPanel.add(comboBox_1);
		
		JLabel lblThinkbetter = new JLabel("THINKBETTER");
		lblThinkbetter.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblThinkbetter.setBounds(10, 11, 123, 14);
		contentPanel.add(lblThinkbetter);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
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
