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
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		lblConsultarEmpresa.setBounds(12, 12, 172, 15);
		contentPanel.add(lblConsultarEmpresa);
			String[] sNomesColunas = {"ID", "NOMES"};
			DefaultTableModel oModeloTabela = new DefaultTableModel(sNomesColunas, 0);
			oEmpresaControle = new EmpresaControle();
			
			for(EmpresaModel oEmpresa : oEmpresaControle.consultarEmpresa()) {
				int sId = oEmpresa.getA01_codigo();
				String sNome = oEmpresa.getA01_nomeEmpresa();
				
				Object[] oDados = {sId, sNome};
				
				oModeloTabela.addRow(oDados);
			}
			
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 77, 416, 146);
		contentPanel.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setToolTipText("teste");
		table.setModel(oModeloTabela);
		
		table.setModel(oModeloTabela);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ExcluirEmpresaView oExcluirEmpresa = new ExcluirEmpresaView();
				oExcluirEmpresa.abreExcluirEmpresa();
			}
		});
		btnExcluir.setBounds(311, 40, 117, 25);
		contentPanel.add(btnExcluir);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AtualizarEmpresaView oAtualizarEmpresa = new AtualizarEmpresaView();
				
				oAtualizarEmpresa.abreAtualizarView();
			}
		});
		btnAtualizar.setBounds(12, 40, 117, 25);
		contentPanel.add(btnAtualizar);
		
		
		
		
		
		
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
