package djvinc.thinkbetter.pack_view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import djvinc.thinkbetter.pack_controle.CriterioControle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ExcluirCriterioView extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private CriterioControle oCriterioControle;

	/**
	 * Launch the application.
	 */
	public void abreExcluirCriterio() {
		try {
			ExcluirCriterioView dialog = new ExcluirCriterioView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ExcluirCriterioView() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblExcluirCriterio = new JLabel("Excluir - Critério");
		lblExcluirCriterio.setBounds(12, 12, 147, 15);
		contentPanel.add(lblExcluirCriterio);
		
		JLabel lblIdDoCriterio = new JLabel("ID do Critério");
		lblIdDoCriterio.setBounds(12, 75, 147, 15);
		contentPanel.add(lblIdDoCriterio);
		
		textField = new JTextField();
		textField.setBounds(12, 102, 147, 19);
		contentPanel.add(textField);
		textField.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						oCriterioControle = new CriterioControle();
						
						oCriterioControle.excluirCriterio(Integer.parseInt(textField.getText()));
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
