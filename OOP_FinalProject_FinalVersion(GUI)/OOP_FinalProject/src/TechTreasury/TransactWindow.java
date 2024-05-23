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

public class TransactWindow extends userData {


	private JFrame pickTransact;
	public TransactWindow(String username, String password) {

		userData loggedInUserData =  findUser(username);
		CreateCustomItems createItem = new CreateCustomItems();
		pickTransact = new JFrame();
		pickTransact.setTitle("Transaction Page");
		pickTransact.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pickTransact.setSize(1200, 800);
		pickTransact.setLocationRelativeTo(null);
		pickTransact.setResizable(false);
		Font Inria = createItem.CreateFont(40);
		JPanel backgroundPanel = new JPanel();
		backgroundPanel.setLayout(new BorderLayout()); 
		backgroundPanel.setBackground(Color.GREEN);
		backgroundPanel.setOpaque(false); 
		backgroundPanel.setBounds(0, 0, 1200, 800);
		backgroundPanel.setLayout(null);


		JPanel backgroundPanelTop = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Dimension arcs = new Dimension(45,45);
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;
				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


				Graphics2D g2d = (Graphics2D) graphics.create(); // Create a copy of the graphics context

				// Define the gradient colors and direction
				Color color1 = new Color(158, 231, 248);
				Color color2 = new Color(48, 131, 255);
				GradientPaint gradient = new GradientPaint(0, 0, color1, width, height, color2);

				// Set the paint to the gradient
				g2d.setPaint(gradient);

				// Fill the rounded rectangle with the gradient
				g2d.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);

				// Draw the border
				graphics.setColor(getForeground());
				graphics.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);

				g2d.dispose(); // Dispose of the graphics context to release resources
			}
		};
		backgroundPanelTop.setBackground(Color.PINK);
		backgroundPanelTop.setBounds(0, -100, 1184, 300);
		backgroundPanelTop.setOpaque(false);
		backgroundPanelTop.setLayout(null);

		JPanel ParentPanelButtons = new JPanel();
		ParentPanelButtons.setBackground(Color.PINK);
		ParentPanelButtons.setOpaque(false); 
		ParentPanelButtons.setBounds(0, 300, 1200, 450);
		ParentPanelButtons.setLayout(null);

		ImageIcon withdrawIcon = new ImageIcon("assets/Images/withdraw.png");
		ImageIcon depositIcon = new ImageIcon("assets/Images/deposit.png");
		ImageIcon checkBalIcon = new ImageIcon("assets/Images/checkBal.png");
		ImageIcon sendMoneyIcon = new ImageIcon("assets/Images/sendMoney.png");
		ImageIcon aboutIcon = new ImageIcon("assets/Images/about.png");


		JButton withdrawButton = createItem.createCustomButton("WITHDRAW", new Color(158, 231, 248), Color.BLACK,withdrawIcon);
		JButton checkBalButton = createItem.createCustomButton("CHECK BALANCE", new Color(158, 231, 248), Color.BLACK,checkBalIcon);
		JButton depositButton = createItem.createCustomButton("DEPOSIT", new Color(158, 231, 248), Color.BLACK,depositIcon);
		JButton sendMoneyButton = createItem.createCustomButton("SEND MONEY", new Color(158, 231, 248), Color.BLACK,sendMoneyIcon);
		JButton aboutButton = createItem.createCustomButton("ABOUT", new Color(158, 231, 248), Color.BLACK,aboutIcon);

		withdrawButton.setFont(Inria);
		withdrawButton.setBackground(new Color(158, 231, 248));
		withdrawButton.setForeground(Color.BLACK);
		withdrawButton.setOpaque(false);
		withdrawButton.setBorderPainted(false);
		withdrawButton.setBounds(150, 50, 400, 100);


		checkBalButton.setFont(Inria);
		checkBalButton.setBackground(new Color(158, 231, 248));
		checkBalButton.setForeground(Color.BLACK);
		checkBalButton.setOpaque(false);
		checkBalButton.setBorderPainted(false);
		checkBalButton.setBounds(650, 50, 400, 100);

		depositButton.setFont(Inria);
		depositButton.setBackground(new Color(158, 231, 248));
		depositButton.setForeground(Color.BLACK);
		depositButton.setOpaque(false);
		depositButton.setBorderPainted(false);
		depositButton.setBounds(150, 180, 400, 100);

		sendMoneyButton.setFont(Inria);
		sendMoneyButton.setBackground(new Color(158, 231, 248));
		sendMoneyButton.setForeground(Color.BLACK);
		sendMoneyButton.setOpaque(false);
		sendMoneyButton.setBorderPainted(false);
		sendMoneyButton.setBounds(650, 180, 400, 100);

		aboutButton.setFont(Inria);
		aboutButton.setBackground(new Color(158, 231, 248));
		aboutButton.setForeground(Color.BLACK);
		aboutButton.setOpaque(false);
		aboutButton.setBorderPainted(false);
		aboutButton.setBounds(400, 300, 400, 100);


		JPanel swiftATM = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Dimension arcs = new Dimension(45,45);
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;
				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


				Graphics2D g2d = (Graphics2D) graphics.create(); // Create a copy of the graphics context

				// Define the gradient colors and direction
				Color color1 = new Color(158, 231, 248);
				Color color2 = new Color(48, 131, 255);
				GradientPaint gradient = new GradientPaint(0, 0, color1, width, height, color2);

				// Set the paint to the gradient
				g2d.setPaint(gradient);

				// Fill the rounded rectangle with the gradient
				g2d.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);

				// Draw the border
				graphics.setColor(getForeground());
				graphics.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);

				g2d.dispose(); // Dispose of the graphics context to release resources
			}
		};

		swiftATM.setBackground(Color.PINK);
		swiftATM.setBounds(350, 20, 500, 300);
		swiftATM.setOpaque(false);
		swiftATM.setLayout(null);

		ImageIcon originalIconWhite = new ImageIcon("assets/Images/swift.png");
		ImageIcon resizedIconWhite = createItem.resizeImageIcon(originalIconWhite, 50, 50);
		JLabel swiftLabelWhite= new JLabel(resizedIconWhite);
		JPanel swiftIcon = new JPanel();
		swiftIcon.setLayout(new BorderLayout()); 
		swiftIcon.setBackground(Color.GREEN);
		swiftIcon.setOpaque(false); 
		swiftIcon.setBounds(20, 20, 50, 50);
		swiftIcon.add(swiftLabelWhite);

		ImageIcon originalIconBlack = new ImageIcon("assets/Images/swiftBlack.png");
		ImageIcon resizedIconBlack = createItem.resizeImageIcon(originalIconBlack, 50, 50);
		JLabel swiftLabelBlack= new JLabel(resizedIconBlack);
		JPanel swiftIconBlack = new JPanel();
		swiftIconBlack.setLayout(new BorderLayout()); 
		swiftIconBlack.setBackground(Color.GREEN);
		swiftIconBlack.setOpaque(false); 
		swiftIconBlack.setBounds(20, 22, 50, 50);
		swiftIconBlack.add(swiftLabelBlack);

		swiftATM.add(swiftIcon);
		swiftATM.add(swiftIconBlack);

		try {
			Font InknutAntiquaLight = Font.createFont(Font.TRUETYPE_FONT, new File("assets/font/InknutAntiquaLight.ttf")).deriveFont(Font.PLAIN, 20);
			GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(InknutAntiquaLight);

			JLabel swiftLabelText= new JLabel();
			swiftLabelText.setText("SWIFT");
			swiftLabelText.setFont(InknutAntiquaLight);
			swiftLabelText.setBackground(Color.PINK);
			swiftLabelText.setOpaque(false);

			swiftLabelText.setBounds(80, 22, 90, 50);

			swiftATM.add(swiftLabelText);

		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
		}


		try {
			Font InriaSerif = Font.createFont(Font.TRUETYPE_FONT, new File("assets/font/InriaSerif.ttf")).deriveFont(Font.PLAIN, 20);
			GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(InriaSerif);

			JLabel swiftDebit= new JLabel();
			swiftDebit.setText("DEBIT");
			swiftDebit.setFont(InriaSerif);
			swiftDebit.setBackground(Color.PINK);
			swiftDebit.setOpaque(false);

			swiftDebit.setBounds(165, 22, 90, 50);

			swiftATM.add(swiftDebit);

		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
		}


		ImageIcon chip = new ImageIcon("assets/Images/chip.png");
		ImageIcon resizedIconchip = createItem.resizeImageIcon(chip, 66, 48);
		JLabel swiftLabelChip= new JLabel(resizedIconchip);
		swiftLabelChip.setBounds(20, 100, 99, 72);
		swiftATM.add(swiftLabelChip);

		String accNumber =  String.valueOf(loggedInUserData.loggedAccountNumber());
		try {
			Font InriaSerif = Font.createFont(Font.TRUETYPE_FONT, new File("assets/font/InriaSerif.ttf")).deriveFont(Font.PLAIN, 25);
			GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(InriaSerif);

			JLabel atmNumber= new JLabel();
			atmNumber.setText(accNumber);
			atmNumber.setFont(InriaSerif);
			atmNumber.setBackground(Color.PINK);
			atmNumber.setOpaque(false);

			atmNumber.setBounds(20, 150, 150, 72);

			swiftATM.add(atmNumber);

		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
		}

		String FullName =loggedInUserData.getfName() +" " + loggedInUserData.getmName() + " " + loggedInUserData.getlName();


		try {
			Font InriaSerif = Font.createFont(Font.TRUETYPE_FONT, new File("assets/font/InriaSerif.ttf")).deriveFont(Font.PLAIN, 25);
			GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(InriaSerif);

			JLabel atmUser= new JLabel();
			atmUser.setText(FullName);
			atmUser.setFont(InriaSerif);
			atmUser.setBackground(Color.PINK);
			atmUser.setOpaque(false);

			atmUser.setBounds(20, 200, 500, 72);

			swiftATM.add(atmUser);

		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
		}

		
		

		backgroundPanel.add(swiftATM);


		ParentPanelButtons.add(withdrawButton);
		ParentPanelButtons.add(checkBalButton);
		ParentPanelButtons.add(depositButton);
		ParentPanelButtons.add(sendMoneyButton);
		ParentPanelButtons.add(aboutButton);

		aboutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// Close the current JFrame
					JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(ParentPanelButtons);
					currentFrame.dispose();
				
	                SwingUtilities.invokeLater(new Runnable() {
	                    @Override
	                    public void run() {
	                		userInfoWindow  infoWindow = new userInfoWindow(username,password);
	                		infoWindow.show();
	                    }
	                });
					
	
				}
					catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			});
		
		withdrawButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// Close the current JFrame
					JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(ParentPanelButtons);
					currentFrame.dispose();
				
	                SwingUtilities.invokeLater(new Runnable() {
	                    @Override
	                    public void run() {
	                		withdrawWindow  withdraw = new withdrawWindow(username,password,1);
	                		withdraw.show();
	                    }
	                });
				}
					catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			});
		
		checkBalButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// Close the current JFrame
					JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(ParentPanelButtons);
					currentFrame.dispose();
				
	                SwingUtilities.invokeLater(new Runnable() {
	                    @Override
	                    public void run() {
	                		withdrawWindow  withdraw = new withdrawWindow(username,password,2);
	                		withdraw.show();
	                    }
	                });
				}
					catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			});
		depositButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// Close the current JFrame
					JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(ParentPanelButtons);
					currentFrame.dispose();
				
	                SwingUtilities.invokeLater(new Runnable() {
	                    @Override
	                    public void run() {
	                		withdrawWindow  withdraw = new withdrawWindow(username,password,3);
	                		withdraw.show();
	                    }
	                });
				}
					catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			});
		
		sendMoneyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// Close the current JFrame
					JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(ParentPanelButtons);
					currentFrame.dispose();
				
	                SwingUtilities.invokeLater(new Runnable() {
	                    @Override
	                    public void run() {
	                		withdrawWindow  withdraw = new withdrawWindow(username,password,4);
	                		withdraw.show();
	                    }
	                });
				}
					catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			});

		
		
		backgroundPanel.add(ParentPanelButtons);
		backgroundPanel.add(backgroundPanelTop);



		pickTransact.add(backgroundPanel, BorderLayout.CENTER);


	}



	public void show() {
		pickTransact.setVisible(true);
	}






}


