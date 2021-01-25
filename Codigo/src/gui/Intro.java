package gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;

public class Intro {

	protected Shell shlIntro;

	/**
	 * Launch the application.
	 * @param args
	 */

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlIntro.open();
		shlIntro.layout();
		while (!shlIntro.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlIntro = new Shell();
		shlIntro.setSize(450, 300);
		shlIntro.setText("Intro");
		
		Composite pnlPrinc = new Composite(shlIntro, SWT.NONE);
		pnlPrinc.setBounds(0, 0, 434, 262);

	}
}
