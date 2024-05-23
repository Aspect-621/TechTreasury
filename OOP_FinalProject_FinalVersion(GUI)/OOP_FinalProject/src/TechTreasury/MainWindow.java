package TechTreasury;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import javax.swing.event.*;
import java.awt.*;
import javax.swing.*;

import java.io.File;


public class MainWindow {
	private JFrame homepageParent;
	public MainWindow() {
		CreateCustomItems createItem = new CreateCustomItems();
		homepageParent = new JFrame();
		homepageParent.setTitle("Swift");
		homepageParent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		homepageParent.setSize(1200, 800);
		homepageParent.setLocationRelativeTo(null);
		homepageParent.setResizable(false);

		JPanel swiftIcon = new JPanel();
		swiftIcon.setLayout(new BorderLayout()); 
		swiftIcon.setBackground(Color.GREEN);
		swiftIcon.setOpaque(false); 
		swiftIcon.setBounds(0, 80, 600, 400);




		JPanel parentUserInput = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Dimension arcs = new Dimension(15,15);
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;
				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				graphics.setColor(getBackground());
				graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);
				graphics.setColor(getForeground());
				graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);
			}
		};
		parentUserInput.setBackground(Color.WHITE);
		parentUserInput.setBounds(600, 80, 525, 500);
		parentUserInput.setOpaque(false);
		parentUserInput.setLayout(null);

		Font InterMediumFont = createItem.CreateInterMediumFontFont(25);

			JLabel usernameLabel= new JLabel();
			usernameLabel.setText("USERNAME");
			usernameLabel.setFont(InterMediumFont);
			usernameLabel.setBackground(Color.PINK);
			usernameLabel.setOpaque(false);

			usernameLabel.setBounds(50, 50, 180, 50);
			parentUserInput.add(usernameLabel);

			JLabel passwordLabel= new JLabel();
			passwordLabel.setText("PASSWORD");
			passwordLabel.setFont(InterMediumFont);
			passwordLabel.setBackground(Color.PINK);
			passwordLabel.setOpaque(false);

			passwordLabel.setBounds(50, 170, 180, 50);
			parentUserInput.add(passwordLabel);
			homepageParent.add(parentUserInput);

	

		JTextField usernameTextField = new JTextField(100);
		Color textFieldColor = new Color(237, 237, 237);
		usernameTextField.setBackground(textFieldColor);
		usernameTextField.setFont(new Font("Arial", Font.PLAIN,40));
		usernameTextField.setBounds(40, 90, 450, 70);
		parentUserInput.add(usernameTextField);

		JPasswordField passwordTextField = new JPasswordField(100);
		passwordTextField.setBackground(textFieldColor);
		passwordTextField.setFont(new Font("Arial", Font.PLAIN,40));
		passwordTextField.setBounds(40, 210, 450, 70);
		parentUserInput.add(passwordTextField);

		JCheckBox showPassword = new JCheckBox("Show Password");
		showPassword.setBounds(40, 270, 450, 50);
		showPassword.setOpaque(false);
		parentUserInput.add(showPassword);

		showPassword.addActionListener(e -> {
			if (showPassword.isSelected()) {
				passwordTextField.setEchoChar((char) 0);
			} else {
				passwordTextField.setEchoChar('*');
			}
		});




		Font logInFont = createItem.CreateFont(30);
		JButton logInButton = new JButton("LOGIN") {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Dimension arcs = new Dimension(50, 50);
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;
				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				graphics.setColor(getBackground());
				graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height); 
				graphics.setColor(getForeground());
				graphics.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);
				FontMetrics metrics = graphics.getFontMetrics();
				int x = (getWidth() - metrics.stringWidth(getText())) / 2;
				int y = ((getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
				graphics.setColor(getForeground());
				graphics.drawString(getText(), x, y);
			}
		};

		logInButton.setFont(logInFont);
		logInButton.setBackground(new Color(32, 175, 255));
		logInButton.setForeground(Color.BLACK);
		logInButton.setOpaque(false);

	
		parentUserInput.add(logInButton);
		logInButton.setBorderPainted(false);
		logInButton.setBounds(40, 330, 200, 50);


			Font InterMedium = createItem.CreateInterMediumFontFont(13);
			JLabel createAccount= new JLabel();
			createAccount.setText("CREATE ACCOUNT");
			createAccount.setFont(InterMedium);
			createAccount.setBackground(Color.PINK);
			createAccount.setOpaque(false);

			createAccount.setBounds(40, 370, 180, 50);
			parentUserInput.add(createAccount);
			createAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			createAccount.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                	homepageParent.dispose();
					registerWindow registry = new registerWindow();
					registry.show(); 
		
                }
            });
			
			
			JLabel forgotPassword= new JLabel();
			forgotPassword.setText("FORGOT PASSWORD");
			forgotPassword.setFont(InterMedium);
			forgotPassword.setBackground(Color.PINK);
			forgotPassword.setOpaque(false);
			forgotPassword.setBounds(200, 370, 180, 50);
			/*
			parentUserInput.add(forgotPassword);
			*/
			homepageParent.add(parentUserInput);

	



		logInButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String username = usernameTextField.getText();
					@SuppressWarnings("deprecation")
					String password = passwordTextField.getText();

					loginUser logUser = new loginUser(username,password);
					boolean loggedIn = logUser.loggedIn();
					if (loggedIn) {
						JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(parentUserInput);
						currentFrame.dispose();
					
		                SwingUtilities.invokeLater(new Runnable() {
		                    @Override
		                    public void run() {
		                        TransactWindow transact = new TransactWindow(username,password);
		                        transact.show(); 
		                    }
		                });
						
						
					}
					else {
						
						JLabel prompt= new JLabel();
						prompt.setText("Username or Password is Incorrect!");
						prompt.setBackground(Color.PINK);
						prompt.setOpaque(false);
						prompt.setBounds(200, 270, 300, 50);
						parentUserInput.add(prompt);
					}
				}
					catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			});



						ImageIcon swiftieIcon = new ImageIcon("assets/Images/swift.png");
						JLabel swiftLabelWhite= new JLabel(swiftieIcon);
						swiftIcon.add(swiftLabelWhite);

						JPanel swiftIconBlack = new JPanel();
						swiftIconBlack.setBackground(Color.GREEN);
						swiftIconBlack.setOpaque(false); 
						swiftIconBlack.setBounds(0, 95, 600, 400);

						ImageIcon swiftieIconBlack = new ImageIcon("assets/Images/swiftBlack.png");
						JLabel swiftLabelBlack= new JLabel(swiftieIconBlack);
						swiftIconBlack.add(swiftLabelBlack);

						Font InriaSerif = createItem.CreateFont(30);

							JLabel swiftLabel= new JLabel("~~~~~ SWIFT ~~~~~");
							JPanel swiftLabelPanel = new JPanel();
							swiftLabelPanel.setBackground(Color.GREEN);
							swiftLabelPanel.setOpaque(false); 
							swiftLabelPanel.setBounds(0, 500, 600, 400);
							swiftLabelPanel.add(swiftLabel);
							swiftLabel.setFont(InriaSerif);
							homepageParent.add(swiftLabelPanel);




						GradientPanel backgroundPanel = new GradientPanel();
						homepageParent.add(swiftIcon);
						homepageParent.add(swiftIconBlack);
						homepageParent.add(backgroundPanel, BorderLayout.CENTER);
		}





		public void show() {
			homepageParent.setVisible(true);
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




	}
