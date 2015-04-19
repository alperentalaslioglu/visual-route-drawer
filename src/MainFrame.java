
import java.util.ArrayList;
import javax.swing.JFrame;


public class MainFrame extends JFrame {
	private MainPanel mainPanel;
	
	public MainFrame(ArrayList[] routes,int[][] coordinates){		
		mainPanel = new MainPanel(routes,coordinates);
		this.add(mainPanel);			
		setTitle("Route GUI");
		setResizable(false);
		pack();		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);		
	}
}
