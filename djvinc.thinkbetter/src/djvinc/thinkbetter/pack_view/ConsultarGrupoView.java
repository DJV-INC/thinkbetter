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

import djvinc.thinkbetter.pack_controle.GrupoControle;
import djvinc.thinkbetter.pack_model.GrupoModel;

public class ConsultarGrupoView extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private GrupoControle oGrupoControle;
	private final JTable table;

	/**
	 * Launch the application.
	 */
	public void abreConsultaGrupo() {
		try {
			ConsultarGrupoView dialog = new ConsultarGrupoView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConsultarGrupoView() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblConsultarGrupo = new JLabel("Consultar Grupo");
		lblConsultarGrupo.setBounds(12, 12, 172, 15);
		contentPanel.add(lblConsultarGrupo);
			String[] sNomesColunas = {"ID","NOME", "ID PROBLEMA"};
			DefaultTableModel oModeloTabela = new DefaultTableModel(sNomesColunas, 0);
			oGrupoControle = new GrupoControle();
			
			for(GrupoModel oGrupo : oGrupoControle.consultarGrupo()) {
				int iId = oGrupo.getA03_idGrupo();
				String sNome = oGrupo.getA03_nomeGrupo();
				int iIdProblema = oGrupo.getA03_idProblema();
				
				
				Object[] oDados = {iId, sNome, iIdProblema};
				
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
					AtualizarGrupoView oAtualizarGrupo = new AtualizarGrupoView();
					oAtualizarGrupo.abreAtualizarGrupo();
				}
			});
			btnAtualizar.setBounds(12, 40, 117, 25);
			contentPanel.add(btnAtualizar);
			
			JButton btnExcluir = new JButton("Excluir");
			btnExcluir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ExcluirGrupoView oExcluirGrupo = new ExcluirGrupoView();
					
					oExcluirGrupo.abreExcluirGrupo();
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
