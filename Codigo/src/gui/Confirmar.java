package gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

public class Confirmar{

	protected Object result;
	protected Shell shell;
	private Text txtComfirmarExcluso;

	/**
	 * Launch the application.
	 * @param args
	 */

	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open() {
		createContents();
		shell.open();
		shell.layout();
		Display display = Display.getDefault();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(SWT.MIN | SWT.APPLICATION_MODAL);
		shell.setSize(332, 175);
		shell.setText("Confirmar");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(10, 99, 75, 25);
		btnNewButton.setText("OK");
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Principal.getTblPrinc().remove(Principal.getTblPrinc().getSelectionIndex());
				shell.close();
			}
		});
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.setBounds(214, 99, 75, 25);
		btnNewButton_1.setText("Cancelar");
		
		txtComfirmarExcluso = new Text(shell, SWT.BORDER | SWT.CENTER);
		txtComfirmarExcluso.setEditable(false);
		txtComfirmarExcluso.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		txtComfirmarExcluso.setText("confirmar exclus\u00E3o?");
		txtComfirmarExcluso.setBounds(10, 10, 279, 53);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});
	}
}
