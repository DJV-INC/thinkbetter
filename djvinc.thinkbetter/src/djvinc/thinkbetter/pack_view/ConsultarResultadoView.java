package djvinc.thinkbetter.pack_view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import djvinc.thinkbetter.pack_controle.ResultadoControle;
import djvinc.thinkbetter.pack_model.ResultadoModel;

public class ConsultarResultadoView extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private ResultadoControle oResultadoControle;
	private final JTable table;

	/**
	 * Launch the application.
	 */
	public void abreConsultaResultado() {
		try {
			ConsultarResultadoView dialog = new ConsultarResultadoView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConsultarResultadoView() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblConsultarResultado = new JLabel("Consultar resultado");
		lblConsultarResultado.setBounds(22, 12, 172, 15);
		contentPanel.add(lblConsultarResultado);
			String[] sNomesColunas = {"ID","RESULTADO", "DESCRIÇÃO"};
			DefaultTableModel oModeloTabela = new DefaultTableModel(sNomesColunas, 0);
			oResultadoControle = new ResultadoControle();
			
			for(ResultadoModel resultado : oResultadoControle.consultarResultado()) {
				int iId = resultado.getA07_idResultado();
				int iResultado = resultado.getA07_resultado();
				String iDesc = resultado.getA07_descricao();
				
				
				Object[] oDados = {iId, iResultado, iDesc};
				
				oModeloTabela.addRow(oDados);
			}
			
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(22, 39, 406, 184);
			contentPanel.add(scrollPane);
			table = new JTable();
			scrollPane.setViewportView(table);
			table.setToolTipText("teste");
			table.setModel(oModeloTabela);
			table.setModel(oModeloTabela);
			
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
