package djvinc.thinkbetter.pack_view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import djvinc.thinkbetter.pack_controle.EspecialistaControle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ExcluirEspecialistaView extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private EspecialistaControle oEspecialistaControle;

	/**
	 * Launch the application.
	 */
	public void abreExcluirEspecialista() {
		try {
			ExcluirEspecialistaView dialog = new ExcluirEspecialistaView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ExcluirEspecialistaView() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblExcluirEspecialista = new JLabel("Excluir - Especialista");
		lblExcluirEspecialista.setBounds(12, 12, 147, 15);
		contentPanel.add(lblExcluirEspecialista);
		
		JLabel lblIdDaEspecialista = new JLabel("ID do Especialista");
		lblIdDaEspecialista.setBounds(12, 75, 147, 15);
		contentPanel.add(lblIdDaEspecialista);
		
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
						oEspecialistaControle = new EspecialistaControle();
						
						oEspecialistaControle.excluirEspecialista(Integer.parseInt(textField.getText()));
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
