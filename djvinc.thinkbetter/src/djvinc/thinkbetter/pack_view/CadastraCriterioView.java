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

import djvinc.thinkbetter.pack_controle.CriterioControle;

import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

public class CadastraCriterioView extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

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
		
				JTextPane textPane = new JTextPane();
				textPane.setBounds(12, 66, 416, 64);
				contentPanel.add(textPane);
			
			
				JComboBox comboBox = new JComboBox();
				comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
				comboBox.setBounds(159, 168, 134, 24);
				contentPanel.add(comboBox);
			
			{
				JLabel label = new JLabel("Tipo do critério");
				label.setBounds(12, 141, 134, 15);
				contentPanel.add(label);
			}
			{
				JLabel label = new JLabel("Problema");
				label.setBounds(159, 141, 134, 15);
				contentPanel.add(label);
			}
			
			JLabel lblCriterioRegistrado = new JLabel("Critério registrado");
			lblCriterioRegistrado.setBounds(12, 203, 135, 15);
			contentPanel.add(lblCriterioRegistrado);
			
			textField = new JTextField();
			textField.setBounds(10, 170, 124, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
			lblCriterioRegistrado.setVisible(false);
				
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						CriterioControle oCriterioControle = new CriterioControle();
					
						String descCriterio = textPane.getText();
						String problema = comboBox.getSelectedItem().toString();
						String tipoCriterio = textField.getText();
						
						oCriterioControle.inserirCriterio(descCriterio, tipoCriterio, 1);
						lblCriterioRegistrado.setVisible(true);
						
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
