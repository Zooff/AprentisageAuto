package graphicalInterface;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuBar extends JMenuBar implements ActionListener{
	
	private JMenu file;
	private JMenuItem load;
	
	public MenuBar(){
		super();
		
		file = new JMenu("File");
		
		load = new JMenuItem("Reload File");
		load.setAccelerator(KeyStroke.getKeyStroke('L', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		load.addActionListener(this);
		
		file.add(load);
		this.add(file);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(load)){
			Constant.TDATA.Load("resources/test.txt");
		}
	}

}
