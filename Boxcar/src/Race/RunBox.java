package Race;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import Race.Box;

public class RunBox extends JFrame {

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




