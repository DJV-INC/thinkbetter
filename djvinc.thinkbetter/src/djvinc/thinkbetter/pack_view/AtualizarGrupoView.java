package djvinc.thinkbetter.pack_view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import djvinc.thinkbetter.pack_controle.GrupoControle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AtualizarGrupoView extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private GrupoControle oGrupoControle;
	private JTextField textFieldId;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public void abreAtualizarGrupo() {
		try {
			AtualizarGrupoView dialog = new AtualizarGrupoView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AtualizarGrupoView() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			{
				JLabel lblAtualizarGrupo = new JLabel("Atualizar - Grupo");
				lblAtualizarGrupo.setBounds(12, 12, 186, 15);
				contentPanel.add(lblAtualizarGrupo);
			}
			{
				JLabel lblIdDoGrupo = new JLabel("ID do Grupo");
				lblIdDoGrupo.setBounds(12, 39, 135, 15);
				contentPanel.add(lblIdDoGrupo);
			}
			{
				textFieldId = new JTextField();
				textFieldId.setColumns(10);
				textFieldId.setBounds(12, 58, 209, 29);
				contentPanel.add(textFieldId);
			}
			JLabel lblNome = new JLabel("Nome");
			lblNome.setBounds(12, 99, 70, 15);
			contentPanel.add(lblNome);
			
			textField = new JTextField();
			textField.setBounds(12, 126, 416, 29);
			contentPanel.add(textField);
			textField.setColumns(10);
			{
				JLabel lblNome_1 = new JLabel("Problema");
				lblNome_1.setBounds(12, 167, 70, 15);
				contentPanel.add(lblNome_1);
			}
			{
				textField_1 = new JTextField();
				textField_1.setBounds(12, 194, 416, 29);
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
						oGrupoControle = new GrupoControle();
						
						oGrupoControle.alterarGrupo(Integer.parseInt(textFieldId.getText()), 
								textField.getText(), 
								Integer.parseInt(textField_1.getText()));
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
