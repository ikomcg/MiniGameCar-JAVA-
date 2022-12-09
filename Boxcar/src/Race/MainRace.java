package Race;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Race.RunBox.race;

public class MainRace extends JFrame {
	
	public static void main(String[] args) {
	
	     RunBox rb = new RunBox();
	     
	     
	}

}
class RunBox extends JFrame {

	public Image bg = new ImageIcon(Box.class.getResource("/Race/back.png")).getImage().getScaledInstance(400, 800, Image.SCALE_SMOOTH);
	public Image fl = new ImageIcon(Box.class.getResource("/Race/fl.png")).getImage().getScaledInstance(218, 20, Image.SCALE_SMOOTH);
	public Image car1 = new ImageIcon(Box.class.getResource("/Race/car.png")).getImage().getScaledInstance(50, 70, Image.SCALE_SMOOTH);
	public Image car2 = new ImageIcon(Box.class.getResource("/Race/car002.png")).getImage().getScaledInstance(110, 70, Image.SCALE_SMOOTH);
	public JButton button;
	
	Image image;
	Graphics graphics;
	Box background,finish,player1, player2,win;
	
	RunBox(){
		
	
		background = new Box(5,5,400,795, bg);
		finish = new Box(102,30,200,40,fl);
		player1 = new Box(250,660,102,95,car1);
		player2 = new Box(100,660,102,95,car2);
	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400,800);			
		this.addKeyListener(new race());
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	
	public void paint(Graphics g) {
		image = createImage(this.getWidth(),this.getHeight());
		graphics = image.getGraphics();
		g.drawImage(image,0,0,this);
		
	
		background.drawImage(g);
		finish.drawImage(g);
		player1.drawImage(g);		
		player2.drawImage(g);
		
		
		
	}
	
	public void FINISH() {
		if (player1.intersects(finish)) {
			  
			JOptionPane.showMessageDialog(null,"RED CAR WIN!");
		   }
		 if (player2.intersects(finish)) {
				
	         JOptionPane.showMessageDialog(null,"BLUE CAR WIN!");
			}
		
	}
	public class race extends KeyAdapter{
	   public void keyPressed(KeyEvent e) {
		player1.keyPressed(e);
		player2.keyPressed(e);
		FINISH();
		repaint();
	 }
	}
}
class Box extends Rectangle {
	
	Image image;
	Color color;
	
	Box (int x , int y , int width, int height, Image image){
		
		this.x = x;
		this.y = y;
		this.width = width-35;
		this.height = height-35;
		this.image = image;
		
	}
	
	public void keyPressed(KeyEvent e) {
		
		int s = (int)(Math.random()*(10-1+1)+1); 
		
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			
			if(this.y>=30) {		
				this.y=y-s;
			}
							
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			if(this.y<=660) {
			this.y=y+10;
			}
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (this.x>=100) {
			this.x=x-10;
		    }
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (this.x<=270) {
			this.x=x+8;
		   }
		}
		
	}
	
	public void drawImage(Graphics g) {	
		
		g.drawImage(image, this.x, this.y, color, null);
	}

}