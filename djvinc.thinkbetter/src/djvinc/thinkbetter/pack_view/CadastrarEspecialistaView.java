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
	private JTextField textField_1;
	private JTextField textFieldG;
	private JTextField textFieldE;

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
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 11, 175, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblTipoEspecialista = new JLabel("Tipo especialista:");
		lblTipoEspecialista.setBounds(10, 37, 137, 14);
		contentPanel.add(lblTipoEspecialista);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 63, 305, 28);
		contentPanel.add(textField_1);
		
		JLabel lblIdGrupo = new JLabel("Grupo:");
		lblIdGrupo.setBounds(10, 103, 82, 14);
		contentPanel.add(lblIdGrupo);
		
		JLabel lblIdEmpresa = new JLabel("Empresa\r\n:");
		lblIdEmpresa.setBounds(137, 103, 82, 14);
		contentPanel.add(lblIdEmpresa);
		
		JLabel lblEspecialistaCadastrado = new JLabel("Especialista cadastrado!");
		lblEspecialistaCadastrado.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEspecialistaCadastrado.setBounds(10, 203, 175, 14);
		contentPanel.add(lblEspecialistaCadastrado);
		
		textFieldG = new JTextField();
		textFieldG.setBounds(10, 122, 88, 28);
		contentPanel.add(textFieldG);
		textFieldG.setColumns(10);
		
		textFieldE = new JTextField();
		textFieldE.setBounds(137, 122, 114, 28);
		contentPanel.add(textFieldE);
		textFieldE.setColumns(10);
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
					
						String sTipo = textField_1.getText();
						int iGrupo = Integer.parseInt(textFieldG.getText());
						int iEmpresa = Integer.parseInt(textFieldE.getText());
						
						oEspecialistaControle.inserirEspecialista(sTipo, iGrupo, iEmpresa);
						
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
