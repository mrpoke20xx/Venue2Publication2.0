package gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class TableBusca {
	
	protected Shell shlEdit;
	private String operation1;

	private static  Table tblBusca;
	private static String[] colTitles = {"ISSN","Nome","Edição","Estrato","Data Limite","Data Evento","Favorito"};
	public void open(String op) {
		operation1 = op;
		Display display = Display.getDefault();
		createContents();
		shlEdit.open();
		shlEdit.layout();
		while (!shlEdit.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	protected void createContents() {
		shlEdit = new Shell(SWT.MIN | SWT.APPLICATION_MODAL);
		shlEdit.setSize(373, 407);
		shlEdit.setText("Venue2Publication");
		GridLayout gl_shlVenuepublication = new GridLayout(1,false);
		gl_shlVenuepublication.verticalSpacing = 0;
		gl_shlVenuepublication.marginWidth = 0;
		gl_shlVenuepublication.marginHeight = 0;
		gl_shlVenuepublication.horizontalSpacing = 0;
		shlEdit.setLayout(gl_shlVenuepublication);

		Composite pnlDados = new Composite(shlEdit, SWT.NONE);
		pnlDados.setLayout(new GridLayout(1, false));
		GridData gd_pnlDados = new GridData(SWT.CENTER, SWT.TOP, true, true, 1, 1);
		gd_pnlDados.heightHint = 296;
		pnlDados.setLayoutData(gd_pnlDados);
		
		tblBusca = new Table(pnlDados, SWT.BORDER | SWT.FULL_SELECTION | SWT.V_SCROLL
		        			| SWT.H_SCROLL);
		FormData fd_tblPrinc = new FormData();
		fd_tblPrinc.bottom = new FormAttachment(0, 262);
		fd_tblPrinc.right = new FormAttachment(0, 434);
		fd_tblPrinc.top = new FormAttachment(0, 61);
		fd_tblPrinc.left = new FormAttachment(0, 72);
		for (int loopIndex = 0; loopIndex < colTitles.length; loopIndex++) {
		      TableColumn column = new TableColumn(tblBusca, SWT.NONE);
		      column.setText(colTitles[loopIndex]);
		}
		FillColuna.Test2(Principal.getArquivo(),tblBusca, operation1);
		for (int loopIndex = 0; loopIndex < colTitles.length; loopIndex++) {
			tblBusca.getColumn(loopIndex).pack();
		}
		tblBusca.setHeaderVisible(true);
		tblBusca.setLinesVisible(true);
	}
}
