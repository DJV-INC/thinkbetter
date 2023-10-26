package djvinc.thinkbetter.pack_view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JComboBox;

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
		{
			JComboBox comboBox = new JComboBox();
			comboBox.setBounds(12, 199, 186, 24);
			contentPanel.add(comboBox);
		}
		{
			JLabel lblEmpresa = new JLabel("Empresa");
			lblEmpresa.setBounds(12, 177, 70, 15);
			contentPanel.add(lblEmpresa);
		}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
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
