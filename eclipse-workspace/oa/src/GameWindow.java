import java.awt.Component;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.xml.bind.Marshaller.Listener;


/**
 * 
 * Creates the gamepanel, with no Cells (buttons), the buttons are added later in Main
 * 
 */
public class GameWindow extends JFrame implements PropertyChangeListener  {
	private JFrame frame; 
	private JPanel panel; 
	public final static int WINDOW_HEIGHT=600;
	public final static int WINDOW_WIDTH=600;
	
	
	GameWindow(){
		
		GridLayout grid= new GridLayout(4,4);
		frame= new JFrame("fifteen game");
		
		
		setPanel(new JPanel(grid));
		
		a listener = new a();
		getPanel().setVisible(true);

		frame.add(getPanel()); 
		frame.setSize(WINDOW_HEIGHT, WINDOW_WIDTH);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	public Component add(Component c) {
		getPanel().add(c);
		getPanel().repaint();
		return getPanel();
	}
	@Override
	public void propertyChange(PropertyChangeEvent event) {
		//if (event.getPropertyName().equals("MyTextProperty")) {
            System.out.println("hej");
        //}
		
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}


	
	
	
}
