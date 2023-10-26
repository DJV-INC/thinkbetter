package djvinc.thinkbetter.pack_view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

public class CadastraGrauView extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public void abreCadastroGrau() {
		try {
			CadastraGrauView dialog = new CadastraGrauView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CadastraGrauView() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			{
				JLabel lblRegistrarEmpresa = new JLabel("Registrar - Grau");
				lblRegistrarEmpresa.setBounds(12, 12, 186, 15);
				contentPanel.add(lblRegistrarEmpresa);
			}
			{
				JLabel label = new JLabel("Grau de Certeza");
				label.setBounds(12, 64, 121, 15);
				contentPanel.add(label);
			}
			{
				JComboBox comboBox = new JComboBox();
				comboBox.setBounds(12, 91, 121, 24);
				contentPanel.add(comboBox);
			}
			{
				JLabel label = new JLabel("Grau de Incerteza");
				label.setBounds(145, 64, 127, 15);
				contentPanel.add(label);
			}
			{
				JComboBox comboBox = new JComboBox();
				comboBox.setBounds(145, 91, 121, 24);
				contentPanel.add(comboBox);
			}
			{
				JComboBox comboBox = new JComboBox();
				comboBox.setBounds(307, 91, 121, 24);
				contentPanel.add(comboBox);
			}
			{
				JLabel label = new JLabel("Critério");
				label.setBounds(307, 64, 121, 15);
				contentPanel.add(label);
			}
			{
				JComboBox comboBox = new JComboBox();
				comboBox.setBounds(12, 178, 309, 24);
				contentPanel.add(comboBox);
			}
			{
				JLabel label = new JLabel("Especialista");
				label.setBounds(12, 151, 121, 15);
				contentPanel.add(label);
			}
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
