package ContadorDeExperiencia;

import java.awt.Frame;
import java.awt.Label;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

class p4 extends Frame implements KeyListener
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int i=17;
    int j=90;
    boolean s1=false;
    boolean s2=false;

    public p4()
    {
        Frame f=new Frame("Pad");

        f.setSize(400,400);
        f.setLayout(null);
        Label l=new Label();
        l.setBounds(34,34,88,88);
        f.add(l);

        f.setVisible(true);
        f.addKeyListener(this);
    }

    public static void main(String arg[]){
        new p4();
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

    public void keyTyped(KeyEvent e) {
        //System.out.println("Ty");
    }

    /** Handle the key pressed event from the text field. */
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
            JOptionPane.showMessageDialog(null, "ola");
        }
    }

    /** Handle the key released event from the text field. */

}