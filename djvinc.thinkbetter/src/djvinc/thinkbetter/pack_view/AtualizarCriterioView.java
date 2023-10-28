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
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import djvinc.thinkbetter.pack_controle.CriterioControle;

public class AtualizarCriterioView extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private CriterioControle oCriterioControle;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textFieldId;

	/**
	 * Launch the application.
	 */
	public void abreAtualizarCriterio() {
		try {
			AtualizarCriterioView dialog = new AtualizarCriterioView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AtualizarCriterioView() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			{
				JLabel lblAtualizarEmpresa = new JLabel("Atualizar - Critério");
				lblAtualizarEmpresa.setBounds(12, 12, 186, 15);
				contentPanel.add(lblAtualizarEmpresa);
			}
			
			{
				JLabel lblIdDoCriterio = new JLabel("ID do Critério");
				lblIdDoCriterio.setBounds(12, 39, 135, 15);
				contentPanel.add(lblIdDoCriterio);
			}
			{
				textFieldId = new JTextField();
				textFieldId.setColumns(10);
				textFieldId.setBounds(124, 39, 209, 20);
				contentPanel.add(textFieldId);
			}
			{
				JLabel lblDescricaoDoCriterio = new JLabel("Descrição do critério");
				lblDescricaoDoCriterio.setBounds(12, 71, 173, 15);
				contentPanel.add(lblDescricaoDoCriterio);
			}
		
				JTextPane textPane = new JTextPane();
				textPane.setBounds(12, 98, 416, 64);
				contentPanel.add(textPane);
			
			{
				JLabel lblTipoCriterio = new JLabel("Tipo do critério");
				lblTipoCriterio.setBounds(14, 174, 134, 15);
				contentPanel.add(lblTipoCriterio);
			}
			{
				JLabel lblProblema = new JLabel("Problema");
				lblProblema.setBounds(161, 174, 134, 15);
				contentPanel.add(lblProblema);
			}
			
			textField = new JTextField();
			textField.setBounds(12, 203, 124, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
			{
				textField_1 = new JTextField();
				textField_1.setColumns(10);
				textField_1.setBounds(156, 203, 124, 20);
				contentPanel.add(textField_1);
			}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						oCriterioControle = new CriterioControle();
						
						int iId = Integer.parseInt(textFieldId.getText());
						String sDesc = textPane.getText();
						String sTipo = textField.getText();
						int iIdProblema = Integer.parseInt(textField_1.getText());
						
						oCriterioControle.alterarCriterio(iId, sDesc, sTipo, iIdProblema);
						
						
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
}
