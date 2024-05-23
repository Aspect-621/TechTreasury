package TechTreasury;
import javax.swing.SwingUtilities;
public class MainMethod {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				
 		MainWindow main = new MainWindow();
		main.show();

			}

		});

	}

}
