package djvinc.thinkbetter.pack_view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MenuView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public void iniciaTela() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuView frame = new MenuView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblThinkbetter = new JLabel("THINKBETTER");
		lblThinkbetter.setBounds(12, 12, 113, 15);
		contentPane.add(lblThinkbetter);
		
		JComboBox RegistrarCombo = new JComboBox();

		RegistrarCombo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if(e.getStateChange() == ItemEvent.SELECTED) {
					if(RegistrarCombo.getSelectedItem().toString().equals("Empresa")) {
						CadastraEmpresaView cadastraEmpresa = new CadastraEmpresaView();		
						cadastraEmpresa.abreCadastroEmpresa();
					}
					
					if(RegistrarCombo.getSelectedItem().toString().equals("Problema")) {
						CadastraProblemaView cadastraProblema = new CadastraProblemaView();		
						cadastraProblema.abreCadastroProblema();
					}
					
					if(RegistrarCombo.getSelectedItem().toString().equals("Grupo")) {
						CadastraGrupoView cadastraGrupo = new CadastraGrupoView();		
						cadastraGrupo.abreCadastroGrupo();
					}
					
					if(RegistrarCombo.getSelectedItem().toString().equals("Especialista")) {
						CadastrarEspecialistaView cadastraEspecialista = new CadastrarEspecialistaView();		
						cadastraEspecialista.abreCadastroEspecialista();
					}
					
					if(RegistrarCombo.getSelectedItem().toString().equals("Critério")) {
						CadastraCriterioView cadastraCriterio = new CadastraCriterioView();		
						cadastraCriterio.abreCadastroCriterio();
					}
					
					if(RegistrarCombo.getSelectedItem().toString().equals("Grau")) {
						CadastraGrauView cadastraGrau = new CadastraGrauView();		
						cadastraGrau.abreCadastroGrau();
					}
					
				
				
				}
				
			}
		});
		
		
		
		RegistrarCombo.addMouseListener(new MouseAdapter() {
		});
		RegistrarCombo.setModel(new DefaultComboBoxModel(new String[] {"Escolha", "Empresa", "Problema", "Grupo", "Especialista", "Critério", "Grau"}));
		RegistrarCombo.setBounds(12, 71, 94, 24);
		contentPane.add(RegistrarCombo);
		
		JComboBox ConsultarCombo = new JComboBox();
		ConsultarCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarEmpresaView oConsultarEmpresaView = new ConsultarEmpresaView();
				
				oConsultarEmpresaView.abreConsultarEmpresa();
			}
		});
		ConsultarCombo.setModel(new DefaultComboBoxModel(new String[] {"Escolha", "Empresa", "Problema", "Grupo", "Especialista", "Critério", "Grau"}));
		ConsultarCombo.setBounds(121, 71, 94, 24);
		contentPane.add(ConsultarCombo);
		
		JLabel lblRegistrar = new JLabel("Registrar");
		lblRegistrar.setBounds(12, 44, 70, 15);
		contentPane.add(lblRegistrar);
		
		JLabel lblRegistrar_1 = new JLabel("Consultar");
		lblRegistrar_1.setBounds(121, 44, 70, 15);
		contentPane.add(lblRegistrar_1);
	}
}
