package djvinc.thinkbetter.pack_view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import djvinc.thinkbetter.pack_controle.GrauControle;

public class AtualizarGrauView extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private GrauControle oGrauControle;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textFieldId;

	/**
	 * Launch the application.
	 */
	public void abreAtualizarGrau() {
		try {
			AtualizarGrauView dialog = new AtualizarGrauView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AtualizarGrauView() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			{
				JLabel lblAtualizarGrau = new JLabel("Atualizar - Grau");
				lblAtualizarGrau.setBounds(12, 12, 186, 15);
				contentPanel.add(lblAtualizarGrau);
			}
			{
				JLabel lblIddoGrau = new JLabel("ID do Grau");
				lblIddoGrau.setBounds(12, 42, 135, 15);
				contentPanel.add(lblIddoGrau);
			}
			{
				textFieldId = new JTextField();
				textFieldId.setColumns(10);
				textFieldId.setBounds(12, 69, 209, 19);
				contentPanel.add(textFieldId);
			}
			{
				JLabel lblGrauCerteza = new JLabel("Grau de Certeza");
				lblGrauCerteza.setBounds(12, 100, 121, 15);
				contentPanel.add(lblGrauCerteza);
			}
			
				JComboBox comboBox_1 = new JComboBox();
				comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
				comboBox_1.setBounds(12, 127, 121, 24);
				contentPanel.add(comboBox_1);
			
			{
				JLabel lblGrauIncerteza = new JLabel("Grau de Incerteza");
				lblGrauIncerteza.setBounds(145, 100, 127, 15);
				contentPanel.add(lblGrauIncerteza);
			}
			
				JComboBox comboBox = new JComboBox();
				comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
				comboBox.setBounds(145, 127, 121, 24);
				contentPanel.add(comboBox);
			
			{
				JLabel lblCriterio = new JLabel("Critério");
				lblCriterio.setBounds(307, 100, 121, 15);
				contentPanel.add(lblCriterio);
			}
			
			{
				JLabel lblEspecialista = new JLabel("Especialista");
				lblEspecialista.setBounds(12, 177, 121, 15);
				contentPanel.add(lblEspecialista);
			}
			{
				textField = new JTextField();
				textField.setBounds(307, 130, 114, 19);
				contentPanel.add(textField);
				textField.setColumns(10);
			}
			{
				textField_1 = new JTextField();
				textField_1.setBounds(12, 204, 260, 19);
				contentPanel.add(textField_1);
				textField_1.setColumns(10);
			}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						oGrauControle = new GrauControle();
						
						int iId = Integer.parseInt(textFieldId.getText());
						int iGrauCerteza = Integer.parseInt(comboBox_1.getSelectedItem().toString());
						int iGrauIncerteza = Integer.parseInt(comboBox.getSelectedItem().toString());
						int iCriterio = Integer.parseInt(textField.getText());
						int iEspecialista = Integer.parseInt(textField.getText());
						
						oGrauControle.alterarGrau(iId, iGrauCerteza, iGrauIncerteza, iCriterio, iEspecialista);
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
}
