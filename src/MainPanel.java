
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class MainPanel extends JPanel{
	private static final int RADIUS = 10;
	private ArrayList[] routes;
	protected int[][] coordinates;
	private int MX = 70;
	private int MY = 70;

	
	public MainPanel(ArrayList[] routes,int[][] coordinates){
		this.routes = routes;
		this.coordinates = coordinates;
		setPreferredSize(new Dimension(800, 600));
		setBackground(Color.white);
	}
	
	public void createGUI(Graphics g){
		
		for(int i = 0; i < routes.length; i++){						
			for(int j = 0; j < (routes[i].size() - 1); j++){
				if(j == 0){					
					//Depot to first node
					createEdge(g, 
			        		coordinates[0][0] * (800 / MX), 
			        		coordinates[0][1] * (600 / MY), 
			        		coordinates[(int) routes[i].get(0)][0] * (800 / MX), 
			        		coordinates[(int) routes[i].get(0)][1] * (600 / MY)
			        		);		
					//First edge
					 createEdge(g, 
				        		coordinates[(int) routes[i].get(j)][0] * ((800 / MX) % 100), 
				        		coordinates[(int) routes[i].get(j)][1] * ((600 / MY) % 100), 
				        		coordinates[(int) routes[i].get(j+1)][0] * ((800 / MX) % 100), 
				        		coordinates[(int) routes[i].get(j+1)][1] * ((600 / MY) % 100)
				        		);
				}else{				
		        createEdge(g, 
		        		coordinates[(int) routes[i].get(j)][0] * ((800 / MX) % 100), 
		        		coordinates[(int) routes[i].get(j)][1] * ((600 / MY) % 100), 
		        		coordinates[(int) routes[i].get(j+1)][0] * ((800 / MX) % 100), 
		        		coordinates[(int) routes[i].get(j+1)][1] * ((600 / MY) % 100)
		        		);
				}
			}	
			//Last node to depot
			if(routes[i].size() != 0){
			createEndEdge(g, 
	        		coordinates[(int) routes[i].get(routes[i].size() - 1)][0] * ((800 / MX) % 100), 
	        		coordinates[(int) routes[i].get(routes[i].size() - 1)][1] * ((600 / MY) % 100), 
	        		coordinates[0][0] * ((800 / MX) % 100), 
	        		coordinates[0][1] * ((600 / MY) % 100),
	        		5,
	        		5
	        		);		
			}
		}
		
		for(int i = 1; i < coordinates.length; i++){			
			createNode(g,coordinates[i][0] * ((800 / MX) % 100), coordinates[i][1]*((600 / MY) % 100),i+"");	
		}	
		
		createDepot(g,coordinates[0][0] * ((800 / MX) % 100), coordinates[0][1]*((600 / MY) % 100),"");	

	}

	@Override
    public void paintComponent(Graphics g) {        
        super.paintComponent(g);
        createGUI(g);
        g.setColor(Color.black);
    }


	private void createNode(Graphics g,int x,int y,String num) {
		g.setColor(Color.BLACK);
		g.fillOval(x - RADIUS, y - RADIUS, 2*RADIUS, 2*RADIUS);
		
		g.setColor(Color.WHITE);
		FontMetrics fm = new JLabel().getFontMetrics(new JLabel().getFont());
		g.drawString(num, x - fm.stringWidth(num) / 2, y + (fm.getMaxAscent() - fm.getMaxDescent()) / 2);		
	}  
	
	private void createDepot(Graphics g,int x,int y,String num) {
		g.setColor(Color.BLACK);
		g.fillRect(x - RADIUS, y - RADIUS, 2*RADIUS, 2*RADIUS);
		
		g.setColor(Color.WHITE);
		FontMetrics fm = new JLabel().getFontMetrics(new JLabel().getFont());
		g.drawString(num, x - fm.stringWidth(num) / 2, y + (fm.getMaxAscent() - fm.getMaxDescent()) / 2);		
	}  
	
	private void createEdge(Graphics g2, int x1, int y1, int x2, int y2){
		Graphics2D g = (Graphics2D) g2;
	    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);		
		g.setColor(Color.BLACK);
		g.drawLine(x1, y1, x2, y2);		
	}
	
	private void createEndEdge(Graphics g, int x1, int y1, int x2, int y2, double al, double aw){		
		
		int mx = (x1 + x2) / 2 ;
		int my = (y1 + y2) / 2 ;
				
		 double x,y,length;
		    Point2D start = new Point2D.Double(x1,y1);
		    Point2D end = new Point2D.Double(x2,y2);
		    Point2D middle = new Point2D.Double(mx,my);
		    Point2D base = new Point2D.Double();
		    Point2D back_top = new Point2D.Double();
		    Point2D back_bottom = new Point2D.Double();
		    //   Compute length of line
		    length = Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1)); // I think, this
		    //   Compute normalized line vector
		    x = (x2-x1) / length;
		    y = (y2-y1) / length;
		    //   Compute points for arrow head
		    base.setLocation(mx-x*al, my-y*al);
		    back_top.setLocation(base.getX() - aw*y, base.getY() + aw*x);
		    back_bottom.setLocation(base.getX() + aw*y, base.getY() - aw*x);
		    // Draw lines
		    ((Graphics2D) g).draw(new Line2D.Double(start,end));
		    ((Graphics2D) g).draw(new Line2D.Double(middle,back_bottom));
		    ((Graphics2D) g).draw(new Line2D.Double(middle,back_top));
	}
	

}
