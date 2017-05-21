import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RectangleArt extends JPanel{
	private static final long serialVersionUID = 1L;
	public static Dimension size;
	public static ArrayList<Rectangle2D> myRectangles = new ArrayList<>();
	public RectangleArt() {
		super();
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(3.0f,
				BasicStroke.CAP_ROUND,
				BasicStroke.JOIN_ROUND));
		g2.setColor(Color.BLACK);
		
		int boxesWidth = 150;
		int boxesHeight = 100;
		
		for(int x = 0; x < boxesWidth; x++) {
			for(int y = 0; y < boxesHeight; y++) {
				int v = 255 /(boxesWidth + boxesHeight) * (x + y);
				Color c = new Color(v, 40, 0, 225);
				g2.setColor(c);
				Rectangle2D r = new Rectangle2D.Double(
				x * size.getWidth()	 / boxesWidth,
				y * size.getHeight() / boxesHeight,
				size.getWidth() / boxesWidth,
				size.getHeight() / boxesHeight);
				g2.fill(r);
			}
		}
	
		
		for(Rectangle2D r: myRectangles) {
			g2.fill(r);
		}
			g2.setPaint(Color.BLUE);
		GeneralPath path = new GeneralPath(GeneralPath.WIND_EVEN_ODD);

		path.moveTo(150, 400);
		path.lineTo(720, 200);
		path.lineTo(1290, 400);
		path.lineTo(150, 400);
		
		g2.fill(path);
	}

	public void setupDisplay() {
		JFrame application = new JFrame();
		application.add(this);
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.setSize(1440, 900);
		application.setExtendedState(JFrame.MAXIMIZED_BOTH);
		application.setUndecorated(true);
		application.setVisible(true);
		size = application.getSize();
	}
	public static void main(String[] args) {
		RectangleArt program = new RectangleArt();
		program.setupDisplay();
		program.repaint();
		myRectangles.add(new Rectangle2D.Double(300, 400, 800, 800));
	}
}
