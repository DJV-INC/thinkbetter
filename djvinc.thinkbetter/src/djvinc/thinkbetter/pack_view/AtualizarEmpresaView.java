package djvinc.thinkbetter.pack_view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import djvinc.thinkbetter.pack_controle.EmpresaControle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AtualizarEmpresaView extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private EmpresaControle oEmpresaControle;
	private JTextField textFieldId;

	/**
	 * Launch the application.
	 */
	public void abreAtualizarView() {
		try {
			AtualizarEmpresaView dialog = new AtualizarEmpresaView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AtualizarEmpresaView() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblAtualizarEmpresa = new JLabel("Atualizar - Empresa");
			lblAtualizarEmpresa.setBounds(12, 12, 186, 15);
			contentPanel.add(lblAtualizarEmpresa);
		}
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(12, 107, 70, 15);
		contentPanel.add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(12, 134, 416, 29);
		contentPanel.add(textField);
		textField.setColumns(10);
		{
			JLabel lblIdDaEmpresa = new JLabel("ID da Empresa");
			lblIdDaEmpresa.setBounds(12, 39, 135, 15);
			contentPanel.add(lblIdDaEmpresa);
		}
		{
			textFieldId = new JTextField();
			textFieldId.setColumns(10);
			textFieldId.setBounds(12, 66, 209, 29);
			contentPanel.add(textFieldId);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						oEmpresaControle = new EmpresaControle();
						
						oEmpresaControle.atualizarEmpresa(Integer.parseInt(textFieldId.getText()), textField.getText());
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
