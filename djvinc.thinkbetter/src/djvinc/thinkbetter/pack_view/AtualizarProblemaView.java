package djvinc.thinkbetter.pack_view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import djvinc.thinkbetter.pack_controle.ProblemaControle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AtualizarProblemaView extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private ProblemaControle oProblemaControle;
	private JTextField textField;
	private JTextField textFieldId;

	/**
	 * Launch the application.
	 */
	public void abreAtualizarProblema() {
		try {
			AtualizarProblemaView dialog = new AtualizarProblemaView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AtualizarProblemaView() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblAtualizarProblema = new JLabel("Atualizar - Problema");
			lblAtualizarProblema.setBounds(12, 12, 186, 15);
			contentPanel.add(lblAtualizarProblema);
		}
		{
			JLabel lblDescrioDoProblema = new JLabel("Descrição do problema");
			lblDescrioDoProblema.setBounds(12, 68, 186, 15);
			contentPanel.add(lblDescrioDoProblema);
		}
		
		{
			JLabel lblIdDoProblema = new JLabel("ID do Problema");
			lblIdDoProblema.setBounds(12, 39, 135, 15);
			contentPanel.add(lblIdDoProblema);
		}
		{
			textFieldId = new JTextField();
			textFieldId.setColumns(10);
			textFieldId.setBounds(126, 39, 209, 19);
			contentPanel.add(textFieldId);
		}
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(12, 95, 404, 99);
		contentPanel.add(textPane);
		
		{
			JLabel lblEmpresa = new JLabel("Empresa");
			lblEmpresa.setBounds(12, 206, 70, 15);
			contentPanel.add(lblEmpresa);
		}
		{
			textField = new JTextField();
			textField.setBounds(82, 206, 168, 19);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						oProblemaControle = new ProblemaControle();
						
						oProblemaControle.alterarProblema(Integer.parseInt(textFieldId.getText()), 
								Integer.parseInt(textField.getText()),
								textPane.getText());
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
