import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent; // these 2 nt defined in java.
public class WindowDestroyer extends WindowAdapter {
	public void windowClosing(WindowEvent e){
		System.exit(0);
	}
	//public static void main(String[] args) {
	//}
}
