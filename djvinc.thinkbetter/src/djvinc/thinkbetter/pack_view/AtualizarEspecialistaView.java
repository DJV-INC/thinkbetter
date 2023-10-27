package djvinc.thinkbetter.pack_view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import djvinc.thinkbetter.pack_controle.EspecialistaControle;

public class AtualizarEspecialistaView extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private EspecialistaControle oEspecialistaControle;
	private JTextField textField_1;
	private JTextField textFieldG;
	private JTextField textFieldE;
	private JTextField textFieldId;

	/**
	 * Launch the application.
	 */
	public void abreAtualizarEspecialista() {
		try {
			AtualizarEspecialistaView dialog = new AtualizarEspecialistaView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AtualizarEspecialistaView() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registrar - Especialista");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 11, 175, 14);
		contentPanel.add(lblNewLabel);
		
		{
			JLabel lblIdDaEmpresa = new JLabel("ID do Especialista");
			lblIdDaEmpresa.setBounds(12, 39, 135, 15);
			contentPanel.add(lblIdDaEmpresa);
		}
		{
			textFieldId = new JTextField();
			textFieldId.setColumns(10);
			textFieldId.setBounds(12, 66, 209, 29);
			contentPanel.add(textFieldId);
		}
		
		JLabel lblTipoEspecialista = new JLabel("Tipo especialista:");
		lblTipoEspecialista.setBounds(10, 110, 137, 14);
		contentPanel.add(lblTipoEspecialista);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 136, 305, 28);
		contentPanel.add(textField_1);
		
		JLabel lblIdGrupo = new JLabel("Grupo:");
		lblIdGrupo.setBounds(10, 176, 82, 14);
		contentPanel.add(lblIdGrupo);
		
		JLabel lblIdEmpresa = new JLabel("Empresa\r\n:");
		lblIdEmpresa.setBounds(137, 176, 82, 14);
		contentPanel.add(lblIdEmpresa);
		
		textFieldG = new JTextField();
		textFieldG.setBounds(10, 195, 88, 28);
		contentPanel.add(textFieldG);
		textFieldG.setColumns(10);
		
		textFieldE = new JTextField();
		textFieldE.setBounds(137, 195, 114, 28);
		contentPanel.add(textFieldE);
		textFieldE.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						oEspecialistaControle = new EspecialistaControle();
						
						oEspecialistaControle.alterarEspecialista(Integer.parseInt(textFieldId.getText()),
								textField_1.getText(), 
								Integer.parseInt(textFieldG.getText()),
								Integer.parseInt(textFieldE.getText()));
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
