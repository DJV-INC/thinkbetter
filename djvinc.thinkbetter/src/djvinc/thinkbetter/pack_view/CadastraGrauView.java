package djvinc.thinkbetter.pack_view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import djvinc.thinkbetter.pack_controle.GrauControle;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

public class CadastraGrauView extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public void abreCadastroGrau() {
		try {
			CadastraGrauView dialog = new CadastraGrauView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CadastraGrauView() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			{
				JLabel lblRegistrarEmpresa = new JLabel("Registrar - Grau");
				lblRegistrarEmpresa.setBounds(12, 12, 186, 15);
				contentPanel.add(lblRegistrarEmpresa);
			}
			{
				JLabel label = new JLabel("Grau de Certeza");
				label.setBounds(12, 64, 121, 15);
				contentPanel.add(label);
			}
			
				JComboBox comboBox_1 = new JComboBox();
				comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
				comboBox_1.setBounds(12, 91, 121, 24);
				contentPanel.add(comboBox_1);
			
			{
				JLabel label = new JLabel("Grau de Incerteza");
				label.setBounds(145, 64, 127, 15);
				contentPanel.add(label);
			}
			
				JComboBox comboBox = new JComboBox();
				comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
				comboBox.setBounds(145, 91, 121, 24);
				contentPanel.add(comboBox);
			
			{
				JLabel label = new JLabel("Critério");
				label.setBounds(307, 64, 121, 15);
				contentPanel.add(label);
			}
			
			{
				JLabel label = new JLabel("Especialista");
				label.setBounds(12, 141, 121, 15);
				contentPanel.add(label);
			}
			
				JLabel lblGrauRegistrado = new JLabel("Grau registrado");
				lblGrauRegistrado.setBounds(12, 203, 121, 15);
				contentPanel.add(lblGrauRegistrado);
				{
					textField = new JTextField();
					textField.setBounds(307, 94, 114, 19);
					contentPanel.add(textField);
					textField.setColumns(10);
				}
				{
					textField_1 = new JTextField();
					textField_1.setBounds(12, 168, 260, 19);
					contentPanel.add(textField_1);
					textField_1.setColumns(10);
				}
				lblGrauRegistrado.setVisible(false);
			
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						GrauControle oGrauControle = new GrauControle();
					
						int grauCerteza = Integer.parseInt(comboBox_1.getSelectedItem().toString());
						int grauIncerteza = Integer.parseInt(comboBox.getSelectedItem().toString());
						int criterio = Integer.parseInt(textField.getText());
						int especialista = Integer.parseInt(textField.getText());
						
						oGrauControle.inserirGrau(grauCerteza, grauIncerteza, criterio, especialista);
						lblGrauRegistrado.setVisible(true);
						
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
