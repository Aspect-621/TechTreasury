package TechTreasury;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.RenderingHints;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class CreateCustomItems {

    public static JButton createCustomButton(String text, Color background, Color foreground) {
        return new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g); // Call this to paint the icon
                Dimension arcs = new Dimension(50, 50);
                int buttonWidth = getWidth();
                int buttonHeight = getHeight();
                Graphics2D graphics = (Graphics2D) g.create();
                graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Draw the rounded opaque panel with borders
                graphics.setColor(background);
                graphics.fillRoundRect(0, 0, buttonWidth - 1, buttonHeight - 1, arcs.width, arcs.height); // paint background
                graphics.setColor(foreground);
                graphics.drawRoundRect(0, 0, buttonWidth - 1, buttonHeight - 1, arcs.width, arcs.height); // paint border

                // Draw text in the center
                FontMetrics metrics = graphics.getFontMetrics();
                int textX = (buttonWidth - metrics.stringWidth(getText())) / 2;
                int textY = ((buttonHeight - metrics.getHeight()) / 2) + metrics.getAscent();
                graphics.setColor(foreground);
                graphics.drawString(getText(), textX, textY);
                
                graphics.dispose(); // Dispose of the Graphics2D object
            }
        };
}
	public static JButton createCustomButton(String text, Color background, Color foreground, ImageIcon icon) {
		return new JButton(text) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g); // Call this to paint the icon
				Dimension arcs = new Dimension(50, 50);
				int buttonWidth = getWidth();
				int buttonHeight = getHeight();
				Graphics2D graphics = (Graphics2D) g.create();
				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				// Draw the rounded opaque panel with borders
				graphics.setColor(background);
				graphics.fillRoundRect(0, 0, buttonWidth - 1, buttonHeight - 1, arcs.width, arcs.height); // paint background
				graphics.setColor(foreground);
				graphics.drawRoundRect(0, 0, buttonWidth - 1, buttonHeight - 1, arcs.width, arcs.height); // paint border
				int iconX = 20; // X position of the icon
				int iconY = 15; // Y position of the icon
				if (icon != null) {
					icon.paintIcon(this, graphics, iconX, iconY);
				}

				FontMetrics metrics = graphics.getFontMetrics();
				int textX = iconX + icon.getIconWidth() + 5; // Place text 5 pixels to the right of the icon
				int textY = ((buttonHeight - metrics.getHeight()) / 2) + metrics.getAscent();
				graphics.setColor(foreground);
				graphics.drawString(getText(), textX, textY);

				graphics.dispose(); // Dispose of the Graphics2D object
			}
		};
	}
	
	
	public static ImageIcon resizeImageIcon(ImageIcon icon, int width, int height) {
		Image image = icon.getImage(); // Get the image from the ImageIcon
		Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH); // Scale the image
		return new ImageIcon(resizedImage); // Create a new ImageIcon with the resized image
	}
	
	public Font CreateFont(int fontSize) {
		try {
			Font InriaSerifFont = Font.createFont(Font.TRUETYPE_FONT, new File("assets/font/InriaSerif.ttf")).deriveFont(Font.PLAIN, fontSize);
			GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(InriaSerifFont);
			return InriaSerifFont;

		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Font CreateInterMediumFontFont(int fontSize) {
		try {
			Font InterMediumFont = Font.createFont(Font.TRUETYPE_FONT, new File("assets/font/InterMedium.ttf")).deriveFont(Font.ITALIC, fontSize);
			GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(InterMediumFont);
			return InterMediumFont;

		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
			return null;
		}
	}

	
}
