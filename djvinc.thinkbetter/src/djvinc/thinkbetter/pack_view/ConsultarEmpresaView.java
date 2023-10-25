package djvinc.thinkbetter.pack_view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import djvinc.thinkbetter.pack_controle.EmpresaControle;
import djvinc.thinkbetter.pack_model.EmpresaModel;

import javax.swing.JLabel;
import javax.swing.JSeparator;

public class ConsultarEmpresaView extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private EmpresaControle oEmpresaControle;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public void abreConsultarEmpresa() {
		try {
			ConsultarEmpresaView dialog = new ConsultarEmpresaView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConsultarEmpresaView() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblConsultarEmpresa = new JLabel("Consultar empresa");
		lblConsultarEmpresa.setBounds(22, 12, 172, 15);
		contentPanel.add(lblConsultarEmpresa);
		{
			table = new JTable();
			String[] sNomesColunas = {"ID", "NOMES"};
			DefaultTableModel oModeloTabela = new DefaultTableModel(sNomesColunas, 0);
			table.setModel(oModeloTabela);
			table.setBounds(22, 39, 406, 184);
			contentPanel.add(table);
			oEmpresaControle = new EmpresaControle();
			
			for(EmpresaModel empresa : oEmpresaControle.consultarEmpresa()) {
				String sId = String.valueOf(empresa.getA01_codigo());
				String sNome = empresa.getA01_nomeEmpresa();
				
				String[] sDados = {sId, sNome};
				
				oModeloTabela.addRow(sDados);
			}
			
			table.setModel(oModeloTabela);
			
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
