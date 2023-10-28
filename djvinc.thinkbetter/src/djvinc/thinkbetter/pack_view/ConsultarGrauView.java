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

import djvinc.thinkbetter.pack_controle.GrauControle;
import djvinc.thinkbetter.pack_model.GrauModel;

public class ConsultarGrauView extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private GrauControle oGrauControle;
	private final JTable table;

	/**
	 * Launch the application.
	 */
	public void abreConsultaGrau() {
		try {
			ConsultarGrauView dialog = new ConsultarGrauView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConsultarGrauView() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblConsultarCriterio = new JLabel("Consultar grau");
		lblConsultarCriterio.setBounds(12, 12, 172, 15);
		contentPanel.add(lblConsultarCriterio);
			String[] sNomesColunas = {"ID","CERTEZA", "INCERTEZA", "ID CRITERIO", "ID ESPECIALISTA"};
			DefaultTableModel oModeloTabela = new DefaultTableModel(sNomesColunas, 0);
			oGrauControle = new GrauControle();
			
			for(GrauModel oGrau : oGrauControle.consultarGrau()) {
				int iId = oGrau.getA06_idGrau();
				int iCerteza = oGrau.getA06_grauCerteza();
				int iIncerteza = oGrau.getA06_grauIncerteza();
				int iIdCriterio = oGrau.getA06_idCriterio();
				int iIdEspecialista = oGrau.getA06_idEspecialista();
				
				
				
				
				Object[] oDados = {iId, iCerteza, iIncerteza, iIdCriterio, iIdEspecialista};
				
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
			
			JButton btnAtualizar = new JButton("Atualizar");
			btnAtualizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					AtualizarGrauView oAtualizarGrau = new AtualizarGrauView();
					
					oAtualizarGrau.abreAtualizarGrau();
				}
			});
			btnAtualizar.setBounds(12, 40, 117, 25);
			contentPanel.add(btnAtualizar);
			
			
			JButton btnExcluir = new JButton("Excluir");
			btnExcluir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ExcluirGrauView oExcluirGrau = new ExcluirGrauView();
					
					oExcluirGrau.abreExcluirGrau();
				}
			});
			btnExcluir.setBounds(311, 40, 117, 25);
			contentPanel.add(btnExcluir);
			
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
