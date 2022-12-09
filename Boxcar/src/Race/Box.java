package Race;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

class Box extends Rectangle {
	
	Image image;
	Color color;
	
	Box (int x , int y , int width, int height, Image image){
		
		this.x = x;
		this.y = y;
		this.width = width-35;
		this.height = height-35;
		this.image =image;
		
	}
	
	public void keyPressed(KeyEvent e) {
		
		int s = (int)(Math.random()*(10-1+1)+1); 
		
	
		
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			if(this.y>=30) {		
				this.y=y-s;
			}
							
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			if(this.y<=660) {
			this.y=y+10;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (this.x>=100) {
			this.x=x-10;
		    }
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (this.x<=270) {
			this.x=x+8;
		   }
		}
		
	}
	
	public void drawImage(Graphics g) {	
		g.drawImage(image, this.x,this.y,color,null);
	}

}