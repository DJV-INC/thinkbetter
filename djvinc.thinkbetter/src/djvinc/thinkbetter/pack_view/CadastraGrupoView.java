package djvinc.thinkbetter.pack_view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import djvinc.thinkbetter.pack_controle.GrupoControle;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class CadastraGrupoView extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public void abreCadastroGrupo() {
		try {
			CadastraGrupoView dialog = new CadastraGrupoView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CadastraGrupoView() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			{
				JLabel lblRegistrarGrupo = new JLabel("Registrar - Grupo");
				lblRegistrarGrupo.setBounds(12, 12, 186, 15);
				contentPanel.add(lblRegistrarGrupo);
			}
			JLabel lblNome = new JLabel("Nome");
			lblNome.setBounds(12, 39, 70, 15);
			contentPanel.add(lblNome);
			
			textField = new JTextField();
			textField.setBounds(12, 66, 416, 29);
			contentPanel.add(textField);
			textField.setColumns(10);
			{
				JLabel lblProblema = new JLabel("Problema");
				lblProblema.setBounds(12, 107, 70, 15);
				contentPanel.add(lblProblema);
			}
			
			
			JLabel lblGrupoRegistrado = new JLabel("Grupo registrado");
			lblGrupoRegistrado.setBounds(12, 202, 186, 15);
			contentPanel.add(lblGrupoRegistrado);
			{
				textField_1 = new JTextField();
				textField_1.setBounds(12, 134, 416, 29);
				contentPanel.add(textField_1);
				textField_1.setColumns(10);
			}
			lblGrupoRegistrado.setVisible(false);
			
			
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						GrupoControle oGrupoControle = new GrupoControle();
						
						String sNome = textField.getText();
						int iProblema = Integer.parseInt(textField_1.getText());
						
						oGrupoControle.inserirGrupo(sNome, iProblema);
						
						lblGrupoRegistrado.setVisible(true);
						
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
