package ContadorDeExperiencia;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.NumberFormatter;

public class LevelUI {

	private JFrame framePrincipal;
	private JPanel panelPrincipal;
	private JFormattedTextField textFieldValor;
	
	public LevelUI(Contador contador) {
		framePrincipal = new JFrame();
		framePrincipal.setIconImage(Toolkit.getDefaultToolkit().getImage(Contador.class.getResource("/icons/level-up.png")));
		framePrincipal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		framePrincipal.setTitle("M do pr\u00F3ximo level");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		framePrincipal.setLocation(dim.width/2-framePrincipal.getSize().width/2-200, dim.height/2-framePrincipal.getSize().height/2-200);
		
		framePrincipal.setSize(296, 176);
		framePrincipal.setResizable(false);
		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(Color.BLACK);
		panelPrincipal.setSize(200, 200);
		framePrincipal.getContentPane().add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		JLabel lblInformeAQuantidade = new JLabel("Informe a quantia de M do pr\u00F3ximo level:");
		lblInformeAQuantidade.setForeground(Color.WHITE);
		lblInformeAQuantidade.setBounds(44, 26, 240, 14);
		panelPrincipal.add(lblInformeAQuantidade);
		
		NumberFormat format = NumberFormat.getInstance();
		format.setGroupingUsed(false);
		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setValueClass(Integer.class);
		formatter.setMinimum(0);
		formatter.setMaximum(Integer.MAX_VALUE);
		formatter.setAllowsInvalid(false);
		// If you want the value to be committed on each keystroke instead of focus lost
		//formatter.setCommitsOnValidEdit(true);
		textFieldValor = new JFormattedTextField(formatter);
		textFieldValor.setBounds(111, 51, 63, 20);
		panelPrincipal.add(textFieldValor);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setLevel(contador);
			}
		});
		btnOk.setBounds(115, 82, 53, 23);
		panelPrincipal.add(btnOk);
	}
	
	public void showUI(){
		framePrincipal.setVisible(true);
	}
	
	private void setLevel(Contador contador){
		
		if(textFieldValor.getText().trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "Quantia inválida.");
		}else{
			int level = Integer.parseInt(textFieldValor.getText());
			if(level == 0 || level < 0){
				JOptionPane.showMessageDialog(null, "Quantia inválida.");
			}else{
				contador.setLevel(String.valueOf(level));
				this.framePrincipal.dispose();
			}	
		}
	}
}

