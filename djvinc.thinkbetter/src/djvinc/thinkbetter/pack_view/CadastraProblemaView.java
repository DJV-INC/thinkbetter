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

import djvinc.thinkbetter.pack_controle.ProblemaControle;

import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class CadastraProblemaView extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public void abreCadastroProblema() {
		try {
			CadastraProblemaView dialog = new CadastraProblemaView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CadastraProblemaView() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblRegistrarEmpresa = new JLabel("Registrar - Problema");
			lblRegistrarEmpresa.setBounds(12, 12, 186, 15);
			contentPanel.add(lblRegistrarEmpresa);
		}
		{
			JLabel lblDescrioDoProblema = new JLabel("Descrição do problema");
			lblDescrioDoProblema.setBounds(12, 39, 186, 15);
			contentPanel.add(lblDescrioDoProblema);
		}
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(12, 66, 404, 99);
		contentPanel.add(textPane);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Orange 4", "Accenture"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(12, 199, 186, 24);
		contentPanel.add(comboBox);
		
		{
			JLabel lblEmpresa = new JLabel("Empresa");
			lblEmpresa.setBounds(12, 177, 70, 15);
			contentPanel.add(lblEmpresa);
		}
		
		JLabel lblProblemaRegistrado = new JLabel("Problema registrado!");
		lblProblemaRegistrado.setBounds(257, 204, 142, 15);
		contentPanel.add(lblProblemaRegistrado);
		lblProblemaRegistrado.setVisible(false);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ProblemaControle oProblemaControle = new ProblemaControle();
						
						String descProblema = textPane.getText();
						
						//Pensando no select funcional com id da empresa, talvez
						//String idEmpresa = comboBox.getSelectedItem().toString();
						
						oProblemaControle.inserirProblema(1, descProblema);
						lblProblemaRegistrado.setVisible(true);
						
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
