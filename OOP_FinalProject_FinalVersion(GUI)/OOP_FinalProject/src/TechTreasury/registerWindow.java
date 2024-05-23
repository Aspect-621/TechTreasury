package TechTreasury;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class registerWindow extends userData{

	private JFrame registerWindow;

	public registerWindow() {
		CreateCustomItems createItem = new CreateCustomItems();
		Font Inria = createItem.CreateFont(50);
		registerWindow = new JFrame();
		registerWindow.setTitle("Withdraw Page");
		registerWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		registerWindow.setSize(1200, 800);
		registerWindow.setLocationRelativeTo(null);
		registerWindow.setResizable(false);
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


		JLabel swiftLabel = new JLabel("~~~~~ SWIFT ~~~~~");
		swiftLabel.setFont(Inria);
		swiftLabel.setBackground(Color.WHITE);
		swiftLabel.setOpaque(false); 
		swiftLabel.setBounds(375,100, 500, 100);
		
		
		ImageIcon jpnImage= new ImageIcon("assets/Images/jpnText.png");
		JLabel jpnLabel = new JLabel(jpnImage);
		jpnLabel.setLayout(null);
		jpnLabel.setFont(Inria);
		jpnLabel.setBackground(Color.WHITE);
		jpnLabel.setOpaque(false); 
		jpnLabel.setBounds(350,150, 500, 100);
		
		backgroundPanelTop.add(jpnLabel);
		backgroundPanelTop.add(swiftLabel);
		backgroundPanel.add(backgroundPanelTop);
		
		JPanel parentUserInput = new JPanel() {
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
		parentUserInput.setBackground(Color.WHITE);
		parentUserInput.setBounds(40, 150, 1100, 600);
		parentUserInput.setOpaque(false);
		parentUserInput.setLayout(null);

		Font Inria15 = createItem.CreateFont(30);

		
		JLabel fnameLabel = new JLabel("First Name: ");
		fnameLabel.setLayout(null);
		fnameLabel.setFont(Inria15);
		fnameLabel.setBackground(Color.PINK);
		fnameLabel.setOpaque(false); 
		fnameLabel.setBounds(10,10, 250, 50);
		
		
		JLabel mNameLabel = new JLabel("Middle Name:");
		mNameLabel.setLayout(null);
		mNameLabel.setFont(Inria15);
		mNameLabel.setBackground(Color.PINK);
		mNameLabel.setOpaque(false); 
		mNameLabel.setBounds(10, 70, 250, 50);

		JLabel lNameLabel = new JLabel("Last Name:");
		lNameLabel.setLayout(null);
		lNameLabel.setFont(Inria15);
		lNameLabel.setBackground(Color.PINK);
		lNameLabel.setOpaque(false); 
		lNameLabel.setBounds(10, 130, 250, 50);

		JLabel birthDateLabel = new JLabel("Birth Date:");
		birthDateLabel.setLayout(null);
		birthDateLabel.setFont(Inria15);
		birthDateLabel.setBackground(Color.PINK);
		birthDateLabel.setOpaque(false); 
		birthDateLabel.setBounds(10, 190, 250, 50);

		JLabel genderLabel = new JLabel("Gender:");
		genderLabel.setLayout(null);
		genderLabel.setFont(Inria15);
		genderLabel.setBackground(Color.PINK);
		genderLabel.setOpaque(false); 
		genderLabel.setBounds(10, 250, 250, 50);

		JLabel addressLabel = new JLabel("Address:");
		addressLabel.setLayout(null);
		addressLabel.setFont(Inria15);
		addressLabel.setBackground(Color.PINK);
		addressLabel.setOpaque(false); 
		addressLabel.setBounds(10, 310, 250, 50);

		JLabel fatherNameLabel = new JLabel("Father's Name:");
		fatherNameLabel.setLayout(null);
		fatherNameLabel.setFont(Inria15);
		fatherNameLabel.setBackground(Color.PINK);
		fatherNameLabel.setOpaque(false); 
		fatherNameLabel.setBounds(550, 250, 250, 50);

		JLabel motherNameLabel = new JLabel("Mother's Name:");
		motherNameLabel.setLayout(null);
		motherNameLabel.setFont(Inria15);
		motherNameLabel.setBackground(Color.PINK);
		motherNameLabel.setOpaque(false); 
		motherNameLabel.setBounds(550, 310, 250, 50);

		JLabel contactNumberLabel = new JLabel("Contact Number:");
		contactNumberLabel.setLayout(null);
		contactNumberLabel.setFont(Inria15);
		contactNumberLabel.setBackground(Color.PINK);
		contactNumberLabel.setOpaque(false); 
		contactNumberLabel.setBounds(550, 10, 250, 50);

		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setLayout(null);
		usernameLabel.setFont(Inria15);
		usernameLabel.setBackground(Color.PINK);
		usernameLabel.setOpaque(false); 
		usernameLabel.setBounds(550, 70, 250, 50);

		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setLayout(null);
		passwordLabel.setFont(Inria15);
		passwordLabel.setBackground(Color.PINK);
		passwordLabel.setOpaque(false); 
		passwordLabel.setBounds(550, 130, 250, 50);

		JLabel pinCodeLabel = new JLabel("PIN Code:");
		pinCodeLabel.setLayout(null);
		pinCodeLabel.setFont(Inria15);
		pinCodeLabel.setBackground(Color.PINK);
		pinCodeLabel.setOpaque(false); 
		pinCodeLabel.setBounds(550, 190, 250, 50);

		JTextField fnameField = new JTextField();
		fnameField.setBounds(260, 10,  270, 50);

		JTextField mNameField = new JTextField();
		mNameField.setBounds(260, 70,  270, 50);

		JTextField lNameField = new JTextField();
		lNameField.setBounds(260, 130,  270, 50);

		JTextField birthDateField = new JTextField();
		birthDateField.setBounds(260, 190,  270, 50);

		JTextField genderField = new JTextField();
		genderField.setBounds(260, 250,  270, 50);

		JTextField addressField = new JTextField();
		addressField.setBounds(260, 310,  270, 50);

		JTextField fatherNameField = new JTextField();
		fatherNameField.setBounds(810, 250,  270, 50);

		JTextField motherNameField = new JTextField();
		motherNameField.setBounds(810, 310,  270, 50);

		JTextField contactNumberField = new JTextField();
		contactNumberField.setBounds(810, 10,  270, 50);

		JTextField usernameField = new JTextField();
		usernameField.setBounds(810, 70,  270, 50);

		JTextField passwordField = new JTextField();
		passwordField.setBounds(810, 130,  270, 50);

		JTextField pinCodeField = new JTextField();
		pinCodeField.setBounds(810, 190,  270, 50);

		
		parentUserInput.add(fnameField);
		parentUserInput.add(mNameField);
		parentUserInput.add(lNameField);
		parentUserInput.add(birthDateField);
		parentUserInput.add(genderField);
		parentUserInput.add(addressField);
		parentUserInput.add(fatherNameField);
		parentUserInput.add(motherNameField);
		parentUserInput.add(contactNumberField);
		parentUserInput.add(usernameField);
		parentUserInput.add(passwordField);
		parentUserInput.add(pinCodeField);

		parentUserInput.add(fnameLabel);
		parentUserInput.add(mNameLabel);
		parentUserInput.add(lNameLabel);
		parentUserInput.add(birthDateLabel);
		parentUserInput.add(genderLabel);
		parentUserInput.add(addressLabel);
		parentUserInput.add(fatherNameLabel);
		parentUserInput.add(motherNameLabel);
		parentUserInput.add(contactNumberLabel);
		parentUserInput.add(usernameLabel);
		parentUserInput.add(passwordLabel);
		parentUserInput.add(pinCodeLabel);


		Font logInFont = createItem.CreateFont(30);
		JButton registerButton = new JButton("REGISTER") {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Dimension arcs = new Dimension(50, 50);
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;
				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				// Draws the rounded opaque panel with borders.
				graphics.setColor(getBackground());
				graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height); // paint background
				graphics.setColor(getForeground());
				graphics.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height); // paint border

				// Draw text in the center
				FontMetrics metrics = graphics.getFontMetrics();
				int x = (getWidth() - metrics.stringWidth(getText())) / 2;
				int y = ((getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
				graphics.setColor(getForeground());
				graphics.drawString(getText(), x, y);
			}
		};

		registerButton.setFont(logInFont);
		registerButton.setBackground(new Color(32, 175, 255));
		registerButton.setForeground(Color.BLACK);
		registerButton.setOpaque(false);
		registerButton.setBorderPainted(false);
		registerButton.setBounds(440, 430, 200, 50);
		parentUserInput.add(registerButton);
		pinCodeField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
					e.consume();
				}
			}
		});
		contactNumberField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
					e.consume();
				}
			}
		});
		
		fnameField.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (!Character.isLetter(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_SPACE) {
		            e.consume();
		        }
		    }
		});
		
		mNameField.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (!Character.isLetter(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_SPACE) {
		            e.consume();
		        }
		    }
		});
		lNameField.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (!Character.isLetter(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_SPACE) {
		            e.consume();
		        }
		    }
		});
		
		genderField.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (!Character.isLetter(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_SPACE) {
		            e.consume();
		        }
		    }
		});	
		fatherNameField.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (!Character.isLetter(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_SPACE) {
		            e.consume();
		        }
		    }
		});
		motherNameField.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (!Character.isLetter(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_SPACE) {
		            e.consume();
		        }
		    }
		});
		
		registerButton.addActionListener(new ActionListener() {
		    private int accountFinal;
		    private String checkedName;

		    @Override
		    public void actionPerformed(ActionEvent e) {
		        try {
		            String username = usernameField.getText().trim(); 
		

		            if (fnameField.getText().trim().isEmpty() ||
		            	    mNameField.getText().trim().isEmpty() ||
		            	    lNameField.getText().trim().isEmpty() ||
		            	    birthDateField.getText().trim().isEmpty() ||
		            	    genderField.getText().trim().isEmpty() ||
		            	    addressField.getText().trim().isEmpty() ||
		            	    fatherNameField.getText().trim().isEmpty() ||
		            	    motherNameField.getText().trim().isEmpty() ||
		            	    contactNumberField.getText().trim().isEmpty() ||
		            	    usernameField.getText().trim().isEmpty() ||
		            	    passwordField.getText().trim().isEmpty() ||
		            	    pinCodeField.getText().trim().isEmpty()) {
		            	    // Prompt error message for empty fields
		            	    JOptionPane.showMessageDialog(null, "All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
		            	    return; // Exit the method
		            	}

		            userData checkName = new userData();
		            this.accountFinal = checkName.createAccountNumber();
		            do {
		                this.checkedName = checkName.checkName(username);
		            } while (username == null);

		            double currentBal = 500;
		            String fName = fnameField.getText();
		            String mName = mNameField.getText();
		            String lName = lNameField.getText();
		            String birthDate = birthDateField.getText();
		            String gender = genderField.getText();
		            String address = addressField.getText();
		            String fatherName = fatherNameField.getText();
		            String motherName = motherNameField.getText();
		            String contactNumber = contactNumberField.getText();
		            String password = passwordField.getText();
		            String pinCode = pinCodeField.getText();
		            
		            // Create user data if all fields are valid
		            userData newUser = new userData(checkedName, password, pinCode, fName, mName, lName, birthDate, gender, address, fatherName, motherName, contactNumber, accountFinal, currentBal);
		            newUser.updateText();
		            newUser.createUser();
		            
		    		JFrame frame = new JFrame("Registered Succesfully");
		    		frame.setSize(300, 100);
		    		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    		frame.setLocationRelativeTo(null);
		    		frame.setVisible(true);
		    		JLabel label = new JLabel("Registered Succesfully!");
		    		label.setHorizontalAlignment(SwingConstants.CENTER);
		    		frame.add(label, BorderLayout.CENTER);

		    		Timer timer = new Timer(3000, new ActionListener() {
		    			@Override
		    			public void actionPerformed(ActionEvent e) {
		    				frame.dispose();
		    				registerWindow.dispose();
		    				MainWindow main = new MainWindow();
		    				main.show();
		    				
		    			}
		    		});
		    		timer.start();
		    		timer.setRepeats(false);
		    		
		    		
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		    }
		});

		
		
		
		
		
		registerWindow.add(parentUserInput);
		registerWindow.add(backgroundPanel);
	}

	public void show() {
		registerWindow.setVisible(true);
	}



}
