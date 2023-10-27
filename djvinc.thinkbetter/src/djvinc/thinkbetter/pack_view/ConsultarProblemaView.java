package djvinc.thinkbetter.pack_view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import djvinc.thinkbetter.pack_controle.EmpresaControle;
import djvinc.thinkbetter.pack_controle.ProblemaControle;
import djvinc.thinkbetter.pack_model.EmpresaModel;
import djvinc.thinkbetter.pack_model.ProblemaModel;

public class ConsultarProblemaView extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private ProblemaControle oProblemaControle;
	private final JTable table;
	/**
	 * Launch the application.
	 */
	public void abreConsultarProblema() {
		try {
			ConsultarProblemaView dialog = new ConsultarProblemaView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConsultarProblemaView() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblConsultarProblema = new JLabel("Consultar problema");
		lblConsultarProblema.setBounds(12, 12, 172, 15);
		contentPanel.add(lblConsultarProblema);
			String[] sNomesColunas = {"ID","DESCRIÇÃO", "ID EMPRESA"};
			DefaultTableModel oModeloTabela = new DefaultTableModel(sNomesColunas, 0);
			oProblemaControle = new ProblemaControle();
			
			for(ProblemaModel problema : oProblemaControle.consultarProblema()) {
				int iId = problema.getA02_idProblema();
				int iIdEmpresa = problema.getA02_idEmpresa();
				String sDesc = problema.getA02_descProblema();
				
				Object[] oDados = {iId, sDesc, iIdEmpresa};
				
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
				ExcluirProblemaView oExcluirProblema = new ExcluirProblemaView();
				
				oExcluirProblema.abreExcluirProblema();
			}
		});
		btnExcluir.setBounds(311, 40, 117, 25);
		contentPanel.add(btnExcluir);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AtualizarProblemaView oAtualizarProblema = new AtualizarProblemaView();
				
				oAtualizarProblema.abreAtualizarProblema();
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
