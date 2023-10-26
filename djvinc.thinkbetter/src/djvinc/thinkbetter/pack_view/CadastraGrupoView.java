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
				JLabel lblRegistrarEmpresa = new JLabel("Registrar - Grupo");
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
			{
				JLabel lblNome_1 = new JLabel("Problema");
				lblNome_1.setBounds(12, 107, 70, 15);
				contentPanel.add(lblNome_1);
			}
			
			JComboBox comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"I cant take my eyes off you"}));
			comboBox.setBounds(12, 134, 412, 24);
			contentPanel.add(comboBox);
			
			
			JLabel lblGrupoRegistrado = new JLabel("Grupo registrado");
			lblGrupoRegistrado.setBounds(12, 202, 186, 15);
			contentPanel.add(lblGrupoRegistrado);
			lblGrupoRegistrado.setVisible(false);
			
			
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						GrupoControle oGrupoControle = new GrupoControle();
						
						String nome = textField.getText();
						//String problema = comboBox.getSelectedItem().toString();
						
						oGrupoControle.inserirGrupo(nome, 2);;
						
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
