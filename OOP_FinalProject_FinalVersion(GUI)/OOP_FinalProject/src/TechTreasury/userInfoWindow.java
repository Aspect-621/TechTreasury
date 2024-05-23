package TechTreasury;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import TechTreasury.MainWindow.GradientPanel;

public class userInfoWindow extends userData {

	private JFrame userInfo;

	public userInfoWindow(String username, String password) {
		userData loggedInUserData =  findUser(username);
		CreateCustomItems createItem = new CreateCustomItems();

		userInfo = new JFrame();
		userInfo.setTitle("Information Center");
		userInfo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		userInfo.setSize(1200, 800);
		userInfo.setLocationRelativeTo(null);
		userInfo.setResizable(false);
		Font Inria = createItem.CreateFont(30);
		Font Inria2 = createItem.CreateFont(50);

		JPanel parentPanelData = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Dimension arcs = new Dimension(15,15);
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;
				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


				//Draws the rounded opaque panel with borders.
				graphics.setColor(getBackground());
				graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint background
				graphics.setColor(getForeground());
				graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint border
			}
		};
		parentPanelData.setBackground(Color.WHITE);
		parentPanelData.setBounds(50, 50, 1100, 650);
		parentPanelData.setOpaque(false);
		parentPanelData.setLayout(null);

		JButton backButton = createItem.createCustomButton("BACK", new Color(158, 231, 248), Color.BLACK);
		backButton.setBounds(25, 650, 200, 100);
		backButton.setFont(Inria);
		backButton.setBackground(new Color(158, 231, 248));
		backButton.setForeground(Color.BLACK);
		backButton.setOpaque(false);
		backButton.setBorderPainted(false);
		userInfo.add(backButton, BorderLayout.CENTER);


		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// Close the current JFrame
					JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(parentPanelData);
					currentFrame.dispose();
				
	                SwingUtilities.invokeLater(new Runnable() {
	                    @Override
	                    public void run() {
	                        TransactWindow transact = new TransactWindow(username,password);
	                        transact.show(); 
	                    }
	                });
					
	
				}
					catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			});
		
		JPanel sidePanel = new JPanel();	
		sidePanel.setBounds(700, -10, 500, 800);
		sidePanel.setBackground(Color.GREEN);
		sidePanel.setOpaque(false);
		sidePanel.setLayout(null);

		ImageIcon rectImage = new ImageIcon("assets/Images/RectangleShadow_1.png");
		JLabel rectImageLabel= new JLabel(rectImage);
		rectImageLabel.setBounds(0, 0, 500, 800);

		

		ImageIcon originalIconWhite = new ImageIcon("assets/Images/swift.png");
		ImageIcon resizedIconWhite = createItem.resizeImageIcon(originalIconWhite, 300, 300);
		JLabel swiftIconWhiteLabel= new JLabel(resizedIconWhite);
		swiftIconWhiteLabel.setBackground(Color.GREEN);
		swiftIconWhiteLabel.setOpaque(false);
		swiftIconWhiteLabel.setBounds(75, 100, 450, 500);


		ImageIcon originalIconBlack  = new ImageIcon("assets/Images/swiftBlack.png");
		ImageIcon resizedIconBlack = createItem.resizeImageIcon(originalIconBlack, 300, 300);
		JLabel swiftIconBlackLabel= new JLabel(resizedIconBlack);
		swiftIconBlackLabel.setBackground(Color.GREEN);
		swiftIconBlackLabel.setOpaque(false);
		swiftIconBlackLabel.setBounds(75, 108, 450, 500);

		JLabel swiftLabelText= new JLabel("SWIFT");
		swiftLabelText.setBackground(Color.GREEN);
		swiftLabelText.setOpaque(false);
		swiftLabelText.setBounds(225, 280, 450, 500);
		swiftLabelText.setFont(Inria2);

		
		ImageIcon originalIconJPN  = new ImageIcon("assets/Images/jpnText.png");
		ImageIcon resizedIconJPN = createItem.resizeImageIcon(originalIconJPN, 100, 25);
		JLabel JPNLabel = new JLabel(resizedIconJPN);
		JPNLabel.setBackground(Color.GREEN);
		JPNLabel.setOpaque(false);
		JPNLabel.setBounds(75, 320, 450, 500);
		
		sidePanel.add(JPNLabel);
		sidePanel.add(swiftLabelText);
		sidePanel.add(swiftIconWhiteLabel);
		sidePanel.add(swiftIconBlackLabel);

		sidePanel.add(rectImageLabel);

		userInfo.add(sidePanel);

		userInfo.add(parentPanelData);

		JLabel fNameLabel = new JLabel("First Name: "+loggedInUserData.getfName());
		fNameLabel.setFont(Inria);
		fNameLabel.setBounds(50, 50, 500, 50);
		parentPanelData.add(fNameLabel);

		JLabel mNameLabel = new JLabel("Middle Name: "+loggedInUserData.getmName());
		mNameLabel.setFont(Inria);
		mNameLabel.setBounds(50, 100, 500, 50);
		parentPanelData.add(mNameLabel);

		JLabel lNameLabel = new JLabel("Last Name: "+loggedInUserData.getlName());
		lNameLabel.setFont(Inria);
		lNameLabel.setBounds(50, 150, 500, 50);
		parentPanelData.add(lNameLabel);

		JLabel addressLabel = new JLabel("Address: "+loggedInUserData.getAddress());
		addressLabel.setFont(Inria);
		addressLabel.setBounds(50, 200, 500, 50);
		parentPanelData.add(addressLabel);

		JLabel birthLabel = new JLabel("Birth Date: "+loggedInUserData.getBirthDate());
		birthLabel.setFont(Inria);
		birthLabel.setBounds(50, 250, 500, 50);
		parentPanelData.add(birthLabel);

		JLabel genderLabel = new JLabel("Gender: "+loggedInUserData.getGender());
		genderLabel.setFont(Inria);
		genderLabel.setBounds(50, 300, 500, 50);
		parentPanelData.add(genderLabel);

		JLabel fatherNameLabel = new JLabel("Father Name: "+loggedInUserData.getFatherName());
		fatherNameLabel.setFont(Inria);
		fatherNameLabel.setBounds(50, 350, 500, 50);
		parentPanelData.add(fatherNameLabel);

		JLabel motherNameLabel = new JLabel("Mother Name: "+loggedInUserData.getMotherName());
		motherNameLabel.setFont(Inria);
		motherNameLabel.setBounds(50, 400, 500, 50);
		parentPanelData.add(motherNameLabel);

		JLabel contactNumberLabel = new JLabel("Contact Number: "+loggedInUserData.getContactNumber());
		contactNumberLabel.setFont(Inria);
		contactNumberLabel.setBounds(50, 450, 500, 50);
		parentPanelData.add(contactNumberLabel);


		GradientPanel backgroundPanel = new GradientPanel();

		userInfo.add(backgroundPanel, BorderLayout.CENTER);

	}
	


		
	class GradientPanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;
			int width = getWidth();
			int height = getHeight();

			// Define the gradient colors and direction
			Color color1 = new Color(82, 212, 240);
			Color color2 = new Color(158, 231, 248);
			GradientPaint hompageGradient = new GradientPaint(0, 0, color1, 180, height, color2);

			g2d.setPaint(hompageGradient);
			g2d.fillRect(0, 0, width, height);
		}
	}


	public void show() {
		userInfo.setVisible(true);
	}




}
