package djvinc.thinkbetter.pack_view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import djvinc.thinkbetter.pack_controle.ProblemaControle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ExcluirProblemaView extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private ProblemaControle oProblemaControle;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public void abreExcluirProblema() {
		try {
			ExcluirProblemaView dialog = new ExcluirProblemaView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ExcluirProblemaView() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblExcluirProblema = new JLabel("Excluir - Problema");
		lblExcluirProblema.setBounds(12, 12, 147, 15);
		contentPanel.add(lblExcluirProblema);
		
		JLabel lblIdDoProblema = new JLabel("ID do Problema");
		lblIdDoProblema.setBounds(12, 75, 147, 15);
		contentPanel.add(lblIdDoProblema);
		
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
						oProblemaControle = new ProblemaControle();
						
						oProblemaControle.excluirProblema(Integer.parseInt(textField.getText()));
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
