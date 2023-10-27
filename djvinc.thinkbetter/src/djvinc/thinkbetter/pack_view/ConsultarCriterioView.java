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

import djvinc.thinkbetter.pack_controle.CriterioControle;
import djvinc.thinkbetter.pack_model.CriterioModel;

public class ConsultarCriterioView extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private CriterioControle oCriterioControle;
	private final JTable table;

	/**
	 * Launch the application.
	 */
	public void abreConsultaCriterio() {
		try {
			ConsultarCriterioView dialog = new ConsultarCriterioView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConsultarCriterioView() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblConsultarCriterio = new JLabel("Consultar critério");
		lblConsultarCriterio.setBounds(12, 12, 172, 15);
		contentPanel.add(lblConsultarCriterio);
			String[] sNomesColunas = {"ID","DESCRIÇÃO", "TIPO", "ID PROBLEMA"};
			DefaultTableModel oModeloTabela = new DefaultTableModel(sNomesColunas, 0);
			oCriterioControle = new CriterioControle();
			
			for(CriterioModel criterio : oCriterioControle.consultarCriterio()) {
				int iId = criterio.getA05_idCriterio();
				String sDesc = criterio.getA05_descricao();
				String sTipo = criterio.getA05_tipo();
				int iIdProblema= criterio.getA05_idProblema();
				
				
				
				Object[] oDados = {iId, sDesc, sTipo, iIdProblema};
				
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
					ExcluirCriterioView oExcluirCriterio = new ExcluirCriterioView();
					
					oExcluirCriterio.abreExcluirCriterio();
				}
			});
			btnExcluir.setBounds(311, 40, 117, 25);
			contentPanel.add(btnExcluir);
			
			JButton btnAtualizar = new JButton("Atualizar");
			btnAtualizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					AtualizarCriterioView oAtualizarCriterio = new AtualizarCriterioView();
					
					oAtualizarCriterio.abreAtualizarCriterio();
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
