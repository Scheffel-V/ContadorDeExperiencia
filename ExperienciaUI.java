package ContadorDeExperiencia;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.text.NumberFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class ExperienciaUI {
	
	private JFrame framePrincipal;
	private JPanel panelPrincipal;
	private JFormattedTextField textFieldValor;
	int i=17;
    int j=90;
    boolean s1=false;
    boolean s2=false;
	
	public ExperienciaUI(Contador contador) throws ParseException {
		framePrincipal = new JFrame();
		framePrincipal.setIconImage(Toolkit.getDefaultToolkit().getImage(Contador.class.getResource("/icons/level-up.png")));
		framePrincipal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		framePrincipal.setTitle("Experi\u00EAncia Atual");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		framePrincipal.setLocation(dim.width/2-framePrincipal.getSize().width/2-200, dim.height/2-framePrincipal.getSize().height/2-200);
		
		
		framePrincipal.setSize(272, 158);
		framePrincipal.setResizable(false);
		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(Color.BLACK);
		panelPrincipal.setSize(200, 200);
		framePrincipal.getContentPane().add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		JLabel lblInformeAQuantidade = new JLabel("Informe a quantidade atual de M:");
		lblInformeAQuantidade.setForeground(Color.WHITE);
		lblInformeAQuantidade.setBounds(47, 25, 232, 14);
		panelPrincipal.add(lblInformeAQuantidade);
		
		NumberFormat format = NumberFormat.getInstance();
		format.setGroupingUsed(false);
		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setValueClass(Integer.class);
		formatter.setMinimum(0);
		formatter.setMaximum(Integer.MAX_VALUE);
		formatter.setAllowsInvalid(false);
		
		textFieldValor = new JFormattedTextField(formatter);
		textFieldValor.setBounds(74, 50, 95, 20);
		panelPrincipal.add(textFieldValor);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getExperiencia(contador);
			}
		});
		btnOk.setBounds(95, 81, 53, 23);
		panelPrincipal.add(btnOk);
		
		framePrincipal.getRootPane().setDefaultButton(btnOk);
		
	    
	}
    
	public void keyReleased(KeyEvent e) {
        //System.out.println("re"+e.getKeyChar());

        if(i==e.getKeyCode())
        {
            s1=false;
        }

        if(j==e.getKeyCode())
        {
            s2=false;
        }
    }
	
	 public void keyPressed(KeyEvent e) {
	        System.out.println("pre"+e.getKeyCode());
	        
	        if(i==e.getKeyCode())
	        {
	            s1=true;
	        }

	        if(j==e.getKeyCode())
	        {
	            s2=true;
	        }

	        if(s1==true && s2==true)
	        {
	            System.out.println("EXIT NOW");
	        }
	 }
	 
	public void showUI(){
		framePrincipal.setVisible(true);
	}
	
	private void getExperiencia(Contador contador){
		
		if(textFieldValor.getText().trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "Valor inválido.");
		}else{
			contador.addNewExp(textFieldValor.getText());
			this.framePrincipal.dispose();
		}
	}
}
