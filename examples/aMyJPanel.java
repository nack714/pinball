import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Map.Entry;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
class aMyJPanel extends JPanel {
	BufferedImage image;
	int x = 0, y = 0;
	//ImageIcon missionImg = new ImageIcon("/home/nicolas/Bureau/mission.png");

	// ArrayList<aPolygon> list = new ArrayList<>();

	public void paintComponent(Graphics g) {
		if (!(g == null)) {
			super.paintComponent(g);
			if (image != null) {
				g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		}
		try {
			for (Entry<String, aPolygon> entry : aMyTest.map.entrySet()) {
				aPolygon pol = entry.getValue();
				if (this.equals(pol.myJPanel) && pol.isActive() && pol.x != -1) {
					// System.out.println(pol.img.equals(null));
					g.drawImage(pol.img.getImage(), pol.x, pol.y, pol.img.getIconWidth(), pol.img.getIconHeight(),
							pol.img.getImageObserver());// 125, 30, 39,85
					// g.drawRect(pol.x, pol.y, pol.img.getIconWidth(), pol.img.getIconHeight());
				}
			}
		} catch (Exception e) {
			/*
			 * System.out.println("ERR : "); e.printStackTrace();
			 */
		}

		try {
			if (aMyTest.game != null && aMyTest.game.missionManager != null
					&& aMyTest.game.missionManager.getJPanel() != null) {
				if (g != null && this.equals(aMyTest.game.missionManager.getJPanel())) {
					g.drawImage(aMyTest.game.missionManager.getImg().getImage(), aMyTest.game.missionManager.getImgX(),
							aMyTest.game.missionManager.getImgY(), aMyTest.game.missionManager.getImg().getIconHeight(),
							aMyTest.game.missionManager.getImg().getIconWidth(), aMyTest.game.missionManager.getImg().getImageObserver());
				}
			}else {
				//System.out.println("1 " + aMyTest.game);
				//System.out.println("2 " + aMyTest.game.missionManager);
				//System.out.println("3 " + aMyTest.game.missionManager.mission);
				//System.out.println("4 " + aMyTest.game.missionManager.mission.getJPanel());
			}
		} catch (Exception e) {

			//System.out.println("ERR : ");
			//wwwwwwwwwwwwe.printStackTrace();

		}
	}

	public void repaint() {
		super.repaint();
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}
}