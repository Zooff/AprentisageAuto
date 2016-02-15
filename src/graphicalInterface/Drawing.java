package graphicalInterface;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Drawing extends JPanel implements MouseListener, MouseMotionListener{
	
	private int x1, x2, y1, y2 = -1;
	
	private BufferedImage img;
	private Graphics2D g2;
	
	public Drawing(){
		super();
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		
		reset();
	}
	
	public void reset(){
		x1 = x2 = y1 = y2 = -1;
		img = newDraw();
		repaint();
	}
	
	public BufferedImage getImg(){
		return img;
	}
	
	public BufferedImage newDraw(){
		img = new BufferedImage(200, 150, BufferedImage.TYPE_INT_ARGB);
	
		/*for (int x = 0; x < 200; x++) {
			for (int y = 0; y < 150; y++) {
				img.setRGB(x, y, 0xFFFFFFFF);
			}
		}*/
		
		g2 = img.createGraphics();
		g2.setBackground(Color.WHITE);
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(4));
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		return img;
	}
	
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (x1 != -1 && y1 != -1 && x2 != -1 && y2 != -1) {
            g2.drawLine(x1, y1, x2, y2);
        }

        g.drawImage(img, 0, 0, g2.getBackground(), this);
    }
	
	@Override
	public void mouseDragged(MouseEvent e) {
		x2 = x1;
		y2 = y1;
		x1 = e.getX();
		y1 = e.getY();
		
		if(x1 < 0 || x1 > 200 || y1 < 0 || y1 > 150) {
			JOptionPane.showMessageDialog(null, "Don't exit the draw area !", "Warning", JOptionPane.ERROR_MESSAGE);
			reset();
		}
		
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		x1 = e.getX();
		y1 = e.getY();
		x2 = x1;
		y2 = y1;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		x2 = e.getX();
		y2 = e.getY();
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		x1 = e.getX();
		y1 = e.getY();
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}
