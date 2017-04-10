package ContadorDeExperiencia;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class Contador {

	private JFrame framePrincipal;
	private JPanel panelPrincipal;
	private JTable tableExp;
	private JScrollPane scrollPaneExp;
	private JTextField textFieldLevel;
	private JTextField textFieldTempoProximoLevel;
	private JLabel lblMACada;
	private JTextField textFieldDezMinutos;
	private JLabel lblMACada_1;
	private JTextField textFieldUmaHora;
	private static int contador=0;
	private JLabel lblReset;
	private boolean startPressionado = false;
	private String cronometroInicio;
	private String cronometroFinal;
	private JLabel lblInicio;
	private JLabel lblFim;
	private JTextField textFieldCronInicio;
	private JTextField textFieldCronFim;
	private JLabel lblNewLabel_1;
	
	Contador(){
		framePrincipal = new JFrame();
		
		framePrincipal.setIconImage(Toolkit.getDefaultToolkit().getImage(Contador.class.getResource("/icons/level-up.png")));
		framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePrincipal.setTitle("Contador de Exp");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		framePrincipal.setLocation(dim.width/2-framePrincipal.getSize().width/2-200, dim.height/2-framePrincipal.getSize().height/2-200);
		
		framePrincipal.setSize(392, 406);
		framePrincipal.setResizable(false);
		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(Color.BLACK);
		panelPrincipal.setSize(200, 200);
		framePrincipal.getContentPane().add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		tableExp = new JTable();
		tableExp.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Hor\u00E1rio", "M", "M por 10 min", "M por hora"
			}
		));
		tableExp.getColumnModel().getColumn(0).setPreferredWidth(60);
		tableExp.getColumnModel().getColumn(1).setPreferredWidth(60);
		tableExp.getColumnModel().getColumn(2).setPreferredWidth(85);
		tableExp.getColumnModel().getColumn(3).setPreferredWidth(75);
		tableExp.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		scrollPaneExp = new JScrollPane(tableExp);
		panelPrincipal.add(scrollPaneExp);
		tableExp.setFillsViewportHeight(true);
		scrollPaneExp.setBounds(28, 91, 327, 133);		
		
		JButton labelNewExp = new JButton("");
		labelNewExp.setBorderPainted(false);
		labelNewExp.setBorder(null);
		labelNewExp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				getExperiencia();
				labelNewExp.setIcon(new ImageIcon(Contador.class.getResource("/icons/add-circular-outlined-button(1).png")));
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				labelNewExp.setIcon(new ImageIcon(Contador.class.getResource("/icons/add-circular-outlined-button(1).png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				labelNewExp.setIcon(new ImageIcon(Contador.class.getResource("/icons/add-circular-outlined-button.png")));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				labelNewExp.setIcon(new ImageIcon(Contador.class.getResource("/icons/add-circular-outlined-button (2).png")));
			}
		});
		labelNewExp.setIcon(new ImageIcon(Contador.class.getResource("/icons/add-circular-outlined-button.png")));
		labelNewExp.setBounds(49, 16, 65, 64);
		labelNewExp.setBorder(null);
		labelNewExp.setContentAreaFilled(false);
		labelNewExp.setBorderPainted(false);
		labelNewExp.setFocusPainted(false);
		panelPrincipal.add(labelNewExp);
		
		textFieldLevel = new JTextField();
		textFieldLevel.setEditable(false);
		textFieldLevel.setBounds(28, 335, 60, 20);
		panelPrincipal.add(textFieldLevel);
		textFieldLevel.setColumns(10);
		
		JLabel lblTempoAtPrximo = new JLabel("Tempo at\u00E9 pr\u00F3ximo level:");
		lblTempoAtPrximo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTempoAtPrximo.setForeground(Color.WHITE);
		lblTempoAtPrximo.setBounds(182, 311, 154, 14);
		panelPrincipal.add(lblTempoAtPrximo);
		
		textFieldTempoProximoLevel = new JTextField();
		textFieldTempoProximoLevel.setEditable(false);
		textFieldTempoProximoLevel.setBounds(182, 335, 173, 20);
		panelPrincipal.add(textFieldTempoProximoLevel);
		textFieldTempoProximoLevel.setColumns(10);
		
		lblMACada = new JLabel("M a cada 10 minutos:");
		lblMACada.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMACada.setForeground(Color.WHITE);
		lblMACada.setBounds(28, 236, 148, 14);
		panelPrincipal.add(lblMACada);
		
		textFieldDezMinutos = new JTextField();
		textFieldDezMinutos.setEditable(false);
		textFieldDezMinutos.setBounds(175, 235, 45, 20);
		panelPrincipal.add(textFieldDezMinutos);
		textFieldDezMinutos.setColumns(10);
		
		lblMACada_1 = new JLabel("M a cada uma hora:");
		lblMACada_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMACada_1.setForeground(Color.WHITE);
		lblMACada_1.setBounds(28, 270, 137, 14);
		panelPrincipal.add(lblMACada_1);
		
		textFieldUmaHora = new JTextField();
		textFieldUmaHora.setEditable(false);
		textFieldUmaHora.setColumns(10);
		textFieldUmaHora.setBounds(175, 268, 45, 20);
		panelPrincipal.add(textFieldUmaHora);
		
		JLabel lblNewLabel = new JLabel("M do pr\u00F3ximo level");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblNewLabel.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setForeground(Color.WHITE);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				getLevel();
			}
		});
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(28, 310, 154, 14);
		panelPrincipal.add(lblNewLabel);
		
		lblReset = new JLabel("RESET");
		lblReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblReset.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblReset.setForeground(Color.WHITE);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				limparValores();
			}
		});
		lblReset.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblReset.setForeground(Color.WHITE);
		lblReset.setBounds(252, 257, 65, 14);
		panelPrincipal.add(lblReset);
		
		JLabel lblCronmetroDem = new JLabel("Cron\u00F4metro de 10M");
		lblCronmetroDem.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCronmetroDem.setForeground(Color.WHITE);
		lblCronmetroDem.setBounds(158, 16, 159, 14);
		panelPrincipal.add(lblCronmetroDem);
		
		JLabel lblIniciar = new JLabel("");
		lblIniciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(!startPressionado)
				{
					lblIniciar.setIcon(new ImageIcon(Contador.class.getResource("/icons/press-play-button (3).png")));
				}else{
					lblIniciar.setIcon(new ImageIcon(Contador.class.getResource("/icons/stop-circular-button (2).png")));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(!startPressionado)
				{
					lblIniciar.setIcon(new ImageIcon(Contador.class.getResource("/icons/press-play-button.png")));
				}else{
					lblIniciar.setIcon(new ImageIcon(Contador.class.getResource("/icons/stop-circular-button (3).png")));
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				if(contador == 0){
					JOptionPane.showMessageDialog(null, "Adcione pelo menos um valor para a tabela. \nEle será usado como quantidade inicial.");
				}else if(!startPressionado){
					textFieldCronInicio.setText("");
					textFieldCronFim.setText("");
					startPressionado = true;
					lblIniciar.setIcon(new ImageIcon(Contador.class.getResource("/icons/stop-circular-button (3).png")));
					cronometroInicio = getHorario();
					textFieldCronInicio.setText(cronometroInicio);
				}else{
					startPressionado = false;
					lblIniciar.setIcon(new ImageIcon(Contador.class.getResource("/icons/press-play-button.png")));
					cronometroFinal = getHorario();
					textFieldCronFim.setText(cronometroFinal);
					addNewExpDois(cronometroInicio);
				}
			}
		});
		lblIniciar.setIcon(new ImageIcon(Contador.class.getResource("/icons/press-play-button.png")));
		lblIniciar.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIniciar.setForeground(Color.GREEN);
		lblIniciar.setBounds(158, 41, 38, 32);
		panelPrincipal.add(lblIniciar);
		
		lblInicio = new JLabel("Inicio:");
		lblInicio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInicio.setForeground(Color.WHITE);
		lblInicio.setBounds(207, 41, 46, 14);
		panelPrincipal.add(lblInicio);
		
		lblFim = new JLabel("Fim:");
		lblFim.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFim.setForeground(Color.WHITE);
		lblFim.setBounds(207, 62, 46, 14);
		panelPrincipal.add(lblFim);
		
		textFieldCronInicio = new JTextField();
		textFieldCronInicio.setEditable(false);
		textFieldCronInicio.setBounds(245, 38, 65, 20);
		panelPrincipal.add(textFieldCronInicio);
		textFieldCronInicio.setColumns(10);
		
		textFieldCronFim = new JTextField();
		textFieldCronFim.setEditable(false);
		textFieldCronFim.setBounds(245, 60, 65, 20);
		panelPrincipal.add(textFieldCronFim);
		textFieldCronFim.setColumns(10);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_1.setIcon(new ImageIcon(Contador.class.getResource("/icons/rounded-info-button (3).png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_1.setIcon(new ImageIcon(Contador.class.getResource("/icons/rounded-info-button (2).png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Vinícius Scheffel - Capitalista\nvbscheffel@inf.ufrgs.br\nVersão 1.0.5\n15/02/2017");
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon(Contador.class.getResource("/icons/rounded-info-button (2).png")));
		lblNewLabel_1.setBounds(358, 3, 28, 24);
		panelPrincipal.add(lblNewLabel_1);
		
	}
	
	public void showUI(){
		framePrincipal.setVisible(true);
	}
	
	public void addNewExp(String exp){
		
		String hora;		
		DefaultTableModel model;
		contador++;
		
		hora = getHorario();
		String[] novaLinha = {hora, exp};
		model = (DefaultTableModel) tableExp.getModel();
		model.addRow(novaLinha);
		
		if(contador > 1){
			calcularValores();
			model.setValueAt(textFieldDezMinutos.getText(), contador-1, 2);
			model.setValueAt(textFieldUmaHora.getText(), contador-1, 3);
			tempoProximoLevel(exp);
		}
		
	}
	
	public void addNewExpDois(String horaInicial){
		
		String hora;
		DefaultTableModel model;
		contador++;
		
		
		hora = getHorario();
		model = (DefaultTableModel) tableExp.getModel();
		String[] novaLinha = {hora, String.valueOf((Integer.valueOf((String) model.getValueAt(contador-2, 1)) + 10)) };
		model.addRow(novaLinha);
		
		if(contador > 1){
			calcularValoresDois(horaInicial);
			model.setValueAt(textFieldDezMinutos.getText(), contador-1, 2);
			model.setValueAt(textFieldUmaHora.getText(), contador-1, 3);
			tempoProximoLevel(String.valueOf((Integer.valueOf((String) model.getValueAt(contador-2, 1)) + 10)));
		}
	}
	
	public void tempoProximoLevel(String experienciaAtual){
		
		int expPorMinuto;
		int expParaUpar;
		float tempoParaUpar; 
		boolean textoLevel=!textFieldLevel.getText().trim().isEmpty();
		boolean textoDezMinutos=!textFieldDezMinutos.getText().trim().isEmpty();
		if(textoLevel && textoDezMinutos){
			expPorMinuto = Integer.parseInt(textFieldDezMinutos.getText()) / 10;
			expParaUpar = Integer.parseInt(textFieldLevel.getText()) - Integer.valueOf(experienciaAtual);
			tempoParaUpar = expParaUpar / expPorMinuto;
			
			setTempoParaUpar(tempoParaUpar);
		}
	}
	
	public void setTempoParaUpar(float tempo){
		float hora;
		float minutos;
		
		if(tempo > 59){
			hora = tempo / 60;
			minutos = tempo % 60;
			textFieldTempoProximoLevel.setText((int)hora + " hora(s) e " + (int)minutos + " minuto(s).");
		}else{
			textFieldTempoProximoLevel.setText(tempo + " minuto(s)");
		}
	}
	
	public void setLevel(String level){
		this.textFieldLevel.setText(level);
	}
	
	private String getHorario(){
		Date date = new Date();   // given date
		int hora;
		int minuto;
		String horaStr;
		String minutoStr;
		String horaTotal;
		
		Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
		calendar.setTime(date);   // assigns calendar to given date 
		
		hora = calendar.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format
		if(hora < 10){
			horaStr = "0" + String.valueOf(hora);
		}else{
			horaStr = String.valueOf(hora);
		}
		
		minuto = calendar.get(Calendar.MINUTE);
		if(minuto < 10){
			minutoStr = "0" + String.valueOf(minuto);
		}else{
			minutoStr = String.valueOf(minuto);
		}
		
		horaTotal = horaStr + ":" + minutoStr;
		return horaTotal;
	}
	
	private void calcularValores(){
		int minutos = diferencaMinutos();
		int experiencia = diferencaExperiencia();
		int experienciaEmDezMinutos;
		int experienciaEmUmaHora;
		float experienciaPorMinuto;
		
		if(minutos != 0){
			experienciaPorMinuto = (float)experiencia / (float)minutos;
			experienciaEmDezMinutos = (int) (experienciaPorMinuto * 10);
			experienciaEmUmaHora = (int) (experienciaPorMinuto * 60);
			
			textFieldDezMinutos.setText(String.valueOf(experienciaEmDezMinutos));
			textFieldUmaHora.setText(String.valueOf(experienciaEmUmaHora));
		}
	}
	
	private void calcularValoresDois(String horaInicial){
		int minutos = diferencaMinutosDois(horaInicial);
		int experiencia = 10;
		int experienciaEmDezMinutos;
		int experienciaEmUmaHora;
		float experienciaPorMinuto;
		
		if(minutos != 0){
			experienciaPorMinuto = (float)experiencia / (float)minutos;
			experienciaEmDezMinutos = (int) (experienciaPorMinuto * 10);
			experienciaEmUmaHora = (int) (experienciaPorMinuto * 60);
			
			textFieldDezMinutos.setText(String.valueOf(experienciaEmDezMinutos));
			textFieldUmaHora.setText(String.valueOf(experienciaEmUmaHora));
		}
	}
	
	private int diferencaMinutos(){
		int hora, hora2;
		int minuto, minuto2;
		int diferencaEmMinutos;
		int diferencaHora;
		String horaStr;
		String minutoStr;
		String horario;
		
		DefaultTableModel model = (DefaultTableModel) tableExp.getModel();
		horario = (String)model.getValueAt(contador-1, 0);
		
		horaStr = "" + horario.charAt(0) + horario.charAt(1);
		minutoStr = "" + horario.charAt(3) + horario.charAt(4);
		hora = Integer.valueOf(horaStr);
		minuto = Integer.valueOf(minutoStr);
		
		horario = (String)model.getValueAt(contador-2, 0);
		
		horaStr = "" + horario.charAt(0) + horario.charAt(1);
		minutoStr = "" + horario.charAt(3) + horario.charAt(4);
		hora2 = Integer.valueOf(horaStr);
		minuto2 = Integer.valueOf(minutoStr);
		
		if(hora != hora2){
			diferencaHora = hora - hora2;
			if(minuto < minuto2){
				diferencaEmMinutos = (diferencaHora * 60) - (minuto2 - minuto);
			}else if(minuto > minuto2){
				diferencaEmMinutos = (diferencaHora * 60) + (minuto - minuto2);
			}else{
				diferencaEmMinutos = 60;
			}
		}else{
			diferencaEmMinutos = minuto - minuto2;
		}
		
		return diferencaEmMinutos;
	}
	
	private int diferencaMinutosDois(String horaInicial){
		int hora, hora2;
		int minuto, minuto2;
		int diferencaEmMinutos;
		int diferencaHora;
		String horaStr;
		String minutoStr;
		String horario;
		
		DefaultTableModel model = (DefaultTableModel) tableExp.getModel();
		horario = (String)model.getValueAt(contador-1, 0);
		
		horaStr = "" + horario.charAt(0) + horario.charAt(1);
		minutoStr = "" + horario.charAt(3) + horario.charAt(4);
		hora = Integer.valueOf(horaStr);
		minuto = Integer.valueOf(minutoStr);
		
		horario = horaInicial;
		
		horaStr = "" + horario.charAt(0) + horario.charAt(1);
		minutoStr = "" + horario.charAt(3) + horario.charAt(4);
		hora2 = Integer.valueOf(horaStr);
		minuto2 = Integer.valueOf(minutoStr);
		
		if(hora != hora2){
			diferencaHora = hora - hora2;
			if(minuto < minuto2){
				diferencaEmMinutos = (diferencaHora * 60) - (minuto2 - minuto);
			}else if(minuto > minuto2){
				diferencaEmMinutos = (diferencaHora * 60) + (minuto - minuto2);
			}else{
				diferencaEmMinutos = 60;
			}
		}else{
			diferencaEmMinutos = minuto - minuto2;
		}
		
		return diferencaEmMinutos;
	}
	
	private int diferencaExperiencia(){
		
		int experiencia, experiencia2;
		int diferencaExperiencia;
		String experienciaStr;
		
		DefaultTableModel model = (DefaultTableModel) tableExp.getModel();
		experienciaStr = (String)model.getValueAt(contador-1, 1);
		experiencia = Integer.valueOf(experienciaStr);
		
		experienciaStr = (String)model.getValueAt(contador-2, 1);
		experiencia2 = Integer.valueOf(experienciaStr);
		
		diferencaExperiencia = experiencia - experiencia2;
		
		return diferencaExperiencia;
	}
	
	private void limparValores(){
		
		DefaultTableModel model = (DefaultTableModel) tableExp.getModel();
		while(contador != 0){
			model.removeRow(contador-1);
			contador--;
		}
		
		textFieldDezMinutos.setText("");
		textFieldLevel.setText("");
		textFieldTempoProximoLevel.setText("");
		textFieldUmaHora.setText("");
		textFieldCronInicio.setText("");
		textFieldCronFim.setText("");
	}
	
	private void getExperiencia(){
		
		ExperienciaUI expUI;
		try {
			expUI = new ExperienciaUI(this);
			expUI.showUI();	
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void getLevel(){
		LevelUI levelUI = new LevelUI(this);
		levelUI.showUI();
	}
}
