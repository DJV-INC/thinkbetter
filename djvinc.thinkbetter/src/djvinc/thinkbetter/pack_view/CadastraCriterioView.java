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

public class CadastraCriterioView extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public void abreCadastroCriterio() {
		try {
			CadastraCriterioView dialog = new CadastraCriterioView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CadastraCriterioView() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			{
				JLabel lblRegistrarEmpresa = new JLabel("Registrar - Critério");
				lblRegistrarEmpresa.setBounds(12, 12, 186, 15);
				contentPanel.add(lblRegistrarEmpresa);
			}
			{
				JLabel lblDescrioDoCritrio = new JLabel("Descrição do critério");
				lblDescrioDoCritrio.setBounds(12, 39, 173, 15);
				contentPanel.add(lblDescrioDoCritrio);
			}
			{
				JTextPane textPane = new JTextPane();
				textPane.setBounds(12, 66, 416, 94);
				contentPanel.add(textPane);
			}
			{
				JComboBox comboBox = new JComboBox();
				comboBox.setBounds(12, 199, 134, 24);
				contentPanel.add(comboBox);
			}
			{
				JComboBox comboBox = new JComboBox();
				comboBox.setBounds(159, 199, 134, 24);
				contentPanel.add(comboBox);
			}
			{
				JLabel label = new JLabel("Tipo do critério");
				label.setBounds(12, 172, 134, 15);
				contentPanel.add(label);
			}
			{
				JLabel label = new JLabel("Problema");
				label.setBounds(159, 172, 134, 15);
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
