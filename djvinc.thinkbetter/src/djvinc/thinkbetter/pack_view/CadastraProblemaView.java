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
import javax.swing.JTextField;

public class CadastraProblemaView extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

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
			JLabel lblRegistrarProblema = new JLabel("Registrar - Problema");
			lblRegistrarProblema.setBounds(12, 12, 186, 15);
			contentPanel.add(lblRegistrarProblema);
		}
		{
			JLabel lblDescrioDoProblema = new JLabel("Descrição do problema");
			lblDescrioDoProblema.setBounds(12, 39, 186, 15);
			contentPanel.add(lblDescrioDoProblema);
		}
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(12, 66, 404, 99);
		contentPanel.add(textPane);
		
		{
			JLabel lblEmpresa = new JLabel("Empresa");
			lblEmpresa.setBounds(12, 177, 70, 15);
			contentPanel.add(lblEmpresa);
		}
		
		JLabel lblProblemaRegistrado = new JLabel("Problema registrado!");
		lblProblemaRegistrado.setBounds(257, 204, 159, 15);
		contentPanel.add(lblProblemaRegistrado);
		{
			textField = new JTextField();
			textField.setBounds(12, 204, 168, 19);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
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
						
						int iId = Integer.parseInt(textField.getText());
						String sDescProblema = textPane.getText();
						
						
						
						oProblemaControle.inserirProblema(iId, sDescProblema);
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
