package TechTreasury;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.print.attribute.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

import TechTreasury.userInfoWindow.GradientPanel;

public class withdrawWindow extends userData{

	private JFrame withdrawForm;
	private String username;
	private String password;
	private int loggedAccountNumber;
	private GradientPanel backgroundLeftSidePanel;
	private Timer timerSixty;
	userData loggedInUserData =  findUser(username);
	CreateCustomItems createItem = new CreateCustomItems();
	transact newTransaction = new transact();
	private double balance;
	public withdrawWindow(String usernameLocal, String password,int choice) {
		userData loggedInUserData =  findUser(usernameLocal);
		this.username = usernameLocal;
		this.password=password;
		this.balance = loggedInUserData.getCurrentBal();
		this.loggedAccountNumber=loggedInUserData.loggedAccountNumber();
		withdrawForm = new JFrame();
		withdrawForm.setTitle("Withdraw Page");
		withdrawForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		withdrawForm.setSize(1200, 800);
		withdrawForm.setLocationRelativeTo(null);
		withdrawForm.setResizable(false);
		Font Inria = createItem.CreateFont(30);
		JPanel backgroundPanel = new JPanel();
		backgroundPanel.setLayout(new BorderLayout()); 
		backgroundPanel.setBackground(Color.GREEN);
		backgroundPanel.setOpaque(false); 
		backgroundPanel.setBounds(0, 0, 1200, 800);
		backgroundPanel.setLayout(null);

		JTextField amountTextField = new JTextField(100);
		Color textFieldColor = new Color(237, 237, 237);
		amountTextField.setBackground(textFieldColor);
		amountTextField.setFont(new Font("Arial", Font.PLAIN,40));
		amountTextField.setBounds(500, 250, 450, 70);

		JLabel amountLabel = new JLabel("AMOUNT");
		amountLabel.setBounds(500, 300, 450, 70);

		if (choice !=2) {
			backgroundPanel.add(amountTextField);
			backgroundPanel.add(amountLabel);

		}


		JTextField accountTextField = new JTextField(100);
		accountTextField.setBackground(textFieldColor);
		accountTextField.setFont(new Font("Arial", Font.PLAIN,40));
		accountTextField.setBounds(500, 100, 450, 70);

		JLabel accountLabel = new JLabel("SEND TO (Account Number)");
		accountLabel.setBounds(500, 150, 450, 70);


		if (choice==4) {

			backgroundPanel.add(accountTextField);
			backgroundPanel.add(accountLabel);

		}
		amountTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
					e.consume();
				}
			}
		});

		JPasswordField pinNumberTextField = new JPasswordField(100);
		pinNumberTextField.setBackground(textFieldColor);
		pinNumberTextField.setFont(new Font("Arial", Font.PLAIN,40));
		pinNumberTextField.setBounds(500, 400, 450, 70);
		backgroundPanel.add(pinNumberTextField);

		JLabel pinLabel = new JLabel("PIN");
		pinLabel.setBounds(500, 450, 450, 70);
		backgroundPanel.add(pinLabel);

		pinNumberTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
					e.consume();
				}
			}
		});


		JPanel sidePanel = new JPanel();	
		sidePanel.setBounds(0, -10, 300, 800);
		sidePanel.setBackground(Color.PINK);
		sidePanel.setOpaque(false);
		sidePanel.setLayout(null);

		JPanel withdrawIcon = new JPanel() {
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
		withdrawIcon.setBackground(new Color(158, 231, 248));
		withdrawIcon.setBounds(50, 50, 400, 125);
		withdrawIcon.setOpaque(false);
		withdrawIcon.setLayout(null);

		GradientPanel backgroundLeftSidePanel = new GradientPanel();
		this.backgroundLeftSidePanel= backgroundLeftSidePanel;
		backgroundLeftSidePanel.setBounds(0, 0, 400, 800);

		sidePanel.add(backgroundLeftSidePanel);


		ImageIcon withdrawImg = new ImageIcon("assets/Images/withdraw.png");
		JLabel withdrawLabel = new JLabel();
		withdrawLabel.setIcon(withdrawImg);
		withdrawLabel.setText("WITHDRAW");
		withdrawLabel.setFont(Inria);
		withdrawLabel.setBounds(25, 25, 850, 80);

		ImageIcon depositImg = new ImageIcon("assets/Images/deposit.png");
		JLabel depositLabel = new JLabel();
		depositLabel.setIcon(depositImg);
		depositLabel.setText("DEPOSIT");
		depositLabel.setFont(Inria);
		depositLabel.setBounds(25, 25, 850, 80);

		ImageIcon checkBalImg = new ImageIcon("assets/Images/checkBal.png");
		JLabel checkLabel = new JLabel();
		checkLabel.setIcon(checkBalImg);
		checkLabel.setText("CHECK BALANCE");
		checkLabel.setFont(Inria);
		checkLabel.setBounds(25, 25, 850, 80);

		ImageIcon sendMoneyImg = new ImageIcon("assets/Images/sendMoney.png");
		JLabel sendMoneyLabel = new JLabel();
		sendMoneyLabel.setIcon(sendMoneyImg);
		sendMoneyLabel.setText("SEND MONEY");
		sendMoneyLabel.setFont(Inria);
		sendMoneyLabel.setBounds(25, 25, 850, 80);

		switch (choice) {
		case 1:
			withdrawIcon.add(withdrawLabel);
			break;
		case 2:
			withdrawIcon.add(checkLabel);
			break;
		case 3:
			withdrawIcon.add(depositLabel);
			break;
		case 4:
			withdrawIcon.add(sendMoneyLabel);
			break;


		}



		withdrawForm.add(withdrawIcon, BorderLayout.CENTER);

		withdrawForm.add(backgroundPanel, BorderLayout.CENTER);




		JButton backButton = new JButton("BACK") {
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
		backButton.setOpaque(false);
		backButton.setBorderPainted(false);
		backButton.setFont(Inria);
		backButton.setBackground(new Color(32, 175, 255));
		backButton.setBorderPainted(false);
		backButton.setBounds(75, 600, 150, 100);

		
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					withdrawForm.dispose();
					   TransactWindow transact = new TransactWindow(username,password);
                       transact.show(); 
                       timerSixty.stop();
                       timerSixty = null;

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		JLabel timerLabel = new JLabel();

		JFrame frame1 = new JFrame("Time's UP!");
		frame1.setSize(300, 100);
		frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame1.setLocationRelativeTo(null);
		JLabel label = new JLabel("Time's UP!");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		frame1.add(label, BorderLayout.CENTER);

		final int[] seconds = {3};

		 timerSixty = new Timer(1000, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        timerLabel.setText("Seconds Left: " + seconds[0]);
		        seconds[0]--;

		        if (seconds[0] < 0) {
		            ((Timer) e.getSource()).stop();
		            frame1.setVisible(true);
		            
		            Timer disposeTimer = new Timer(3000, new ActionListener() {
		                @Override
		                public void actionPerformed(ActionEvent e) {
		                    frame1.dispose();
		                    withdrawForm.dispose();
		                	MainWindow main = new MainWindow();
		            		main.show();
		                }
		            });
		            disposeTimer.setRepeats(false);
		            disposeTimer.start();
		        }
		    }
		});
		 timerSixty.start();
		timerLabel.setBounds(75, 670, 150, 100);


		backgroundPanel.add(timerLabel);
		backgroundPanel.add(backButton);
		backgroundPanel.add(sidePanel);





		JButton submitButton = new JButton("SUBMIT") {
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
		submitButton.setOpaque(false);
		submitButton.setBorderPainted(false);
		submitButton.setFont(Inria);
		submitButton.setBackground(new Color(32, 175, 255));
		//submitButton.setForeground(Color.BLACK);
		submitButton.setBorderPainted(false);
		submitButton.setBounds(500, 500, 450, 100);

		backgroundPanel.add(submitButton);
		loggedInUserData.getCurrentBal();



		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String amountText = amountTextField.getText();
					String accountText = accountTextField.getText();
					int sentAccountNumber = 100;


					if (choice==2) {
						amountText="100";
					}

					if(choice==4) {
						sentAccountNumber=Integer.parseInt(accountText);
					}




					String pinNum = pinNumberTextField.getText();
					System.out.println(sentAccountNumber);
					System.out.println(pinNum);
					double endAmount;
					double Amount = Double.parseDouble(amountText);
					double amount = Double.parseDouble(amountText);

					if (choice == 1) {
						endAmount = loggedInUserData.getCurrentBal() - amount;
						if (endAmount < 0) {
							insufficientFunds();
							return;
						}
					} else if (choice == 4) {

						endAmount = loggedInUserData.getCurrentBal() - amount;
						if (endAmount < 0) {
							insufficientFunds();

							return; 
						}
					} else {

					}

					@SuppressWarnings("deprecation")
					boolean passCorrect = loggedInUserData.checkPin(pinNum);
					switch (choice) {
					case 1:

						if (Amount % 100 == 0) {
							if (passCorrect) {
								correctPass(Amount, "Withdraw", 1);
							} else {
								IncorrectPasword();
							}
						} else {
							multipleOfHundred();
						}
						break;

					case 2:

						if (passCorrect) {
							correctPass(0, "Check Balance", 2);
						} else {
							IncorrectPasword();
						}
						break;

					case 3:
						double depositAmount = Amount * (-1);

						if (passCorrect) {
							correctPass(depositAmount, "Deposit", 3);
						} else {
							IncorrectPasword();
						}
						break;

					case 4:
						if (passCorrect) {
							double deposit = Amount *(-1);
							newTransaction.updateBalance(sentAccountNumber, deposit);
							correctPass(Amount, "Send Money", 4);
						} else {
							IncorrectPasword();
						}

						break;


					}

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});



	}
	public void show() {
		withdrawForm.setVisible(true);
	}
	public void insufficientFunds() {
		JFrame frame = new JFrame("Insufficient Funds");
		frame.setSize(300, 100);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		JLabel label = new JLabel("Insufficient Funds!");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		frame.add(label, BorderLayout.CENTER);

		Timer timer = new Timer(3000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		timer.start();
		timer.setRepeats(false);
	}
	public void multipleOfHundred() {
		JFrame frame = new JFrame("Please Enter in Multiples of 100!");
		frame.setSize(300, 100);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		JLabel label = new JLabel("Please Enter in Multiples of 100!");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		frame.add(label, BorderLayout.CENTER);

		Timer timer = new Timer(3000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		timer.start();
		timer.setRepeats(false);
	}
	public void correctPass(double Amount, String transact, int choice) {
		JFrame successWithdraw = new JFrame(transact +" Successful!");
		successWithdraw.setSize(300, 100);
		successWithdraw.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		successWithdraw.setLocationRelativeTo(null);
		successWithdraw.setVisible(true);
		JLabel label = new JLabel();

		switch (choice) {


		case 1:
			label.setText("You have successfully Withdrawn: " + Amount);
			break;
		case 2:
			label.setText("Your current Balance is:" + balance);

			break;
		case 3:
			double finalAmount = Amount *(-1);
			label.setText("You have successfully Deposited: " + finalAmount);

			break;
		case 4:
			label.setText("You have successfully Sent: " + Amount);

			break;
		}

		label.setHorizontalAlignment(SwingConstants.CENTER);
		successWithdraw.add(label, BorderLayout.CENTER);
		newTransaction.updateBalance(loggedAccountNumber, Amount);
		Timer timer1 = new Timer(3000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(backgroundLeftSidePanel);
				successWithdraw.dispose();
				currentFrame.dispose();
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						TransactWindow transact = new TransactWindow(username, password);
						transact.show(); 
					}
				});
			}
		});
		timer1.start();

		timer1.setRepeats(false);
	}
	public void IncorrectPasword() {
		JFrame frame = new JFrame("Incorrect Password!");
		frame.setSize(300, 100);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		JLabel label = new JLabel("PIN is incorrect!");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		frame.add(label, BorderLayout.CENTER);

		Timer timer = new Timer(3000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		timer.setRepeats(false);
		timer.start();
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
