package djvinc.thinkbetter.pack_view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import djvinc.thinkbetter.pack_controle.EmpresaControle;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.concurrent.TimeUnit;

public class CadastraEmpresaView extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public void abreCadastroEmpresa() {
		try {
			CadastraEmpresaView dialog = new CadastraEmpresaView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CadastraEmpresaView() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblRegistrarEmpresa = new JLabel("Registrar - Empresa");
			lblRegistrarEmpresa.setBounds(12, 12, 186, 15);
			contentPanel.add(lblRegistrarEmpresa);
		}
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(12, 39, 70, 15);
		contentPanel.add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(12, 66, 416, 29);
		contentPanel.add(textField);
		textField.setColumns(10);
		JLabel lblEmpresaCadastrada = new JLabel("Empresa cadastrada!");
		lblEmpresaCadastrada.setBounds(12, 208, 151, 15);
		contentPanel.add(lblEmpresaCadastrada);
		lblEmpresaCadastrada.setVisible(false);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						EmpresaControle oEmpresaControle = new EmpresaControle();
						
						String nome = textField.getText();
						
						oEmpresaControle.inserirEmpresa(nome);
						
						
						lblEmpresaCadastrada.setVisible(true);
						
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
