package gui;

import swing2swt.layout.BoxLayout;

import java.io.File;
import java.io.IOException;

import org.eclipse.swt.SWT;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TableColumn;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormLayout;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Principal {
	private static Text txtBusca;
	private static  Table tblPrinc;
	private static String[] colTitle = {"ISSN","Nome","Edição","Estrato","Data Limite","Data Evento","Favorito"};
	private static File arquivo = new File("database.txt");
	static FillColuna fil = new FillColuna();

	/**
	 * Launch the application.
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		arquivo.createNewFile();
		Display display = Display.getDefault();
		Shell shlVenuepublication = new Shell(SWT.MIN);
		shlVenuepublication.setSize(463, 310);
		shlVenuepublication.setText("Venue2Publication");
		shlVenuepublication.setLayout(new BoxLayout(0));
		Composite pnlPrinc = new Composite(shlVenuepublication, SWT.NONE);
		pnlPrinc.setLayout(new FormLayout());
		
		Composite pnlBusca = new Composite(pnlPrinc, SWT.NONE);
		FormData fd_pnlBusca = new FormData();
		fd_pnlBusca.bottom = new FormAttachment(0, 66);
		fd_pnlBusca.right = new FormAttachment(0, 434);
		fd_pnlBusca.top = new FormAttachment(0);
		fd_pnlBusca.left = new FormAttachment(0, 72);
		pnlBusca.setLayoutData(fd_pnlBusca);
		pnlBusca.setLayout(new GridLayout(2, false));
		
		Label lblBusca = new Label(pnlBusca, SWT.NONE);
		lblBusca.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, true, 1, 1));
		lblBusca.setText("Busca por tags");
		new Label(pnlBusca, SWT.NONE);
		
		txtBusca = new Text(pnlBusca, SWT.BORDER);
		txtBusca.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 1));
		
		Button btnBusca = new Button(pnlBusca, SWT.NONE);
		btnBusca.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, true, 1, 1));
		btnBusca.setText("&Buscar");
		btnBusca.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TableBusca edit = new TableBusca();
				edit.open(txtBusca.getText().toString() );
			}
		});
		Composite pnlBotoes = new Composite(pnlPrinc, SWT.NONE);
		FormData fd_pnlBotoes = new FormData();
		fd_pnlBotoes.bottom = new FormAttachment(0, 262);
		fd_pnlBotoes.right = new FormAttachment(0, 73);
		fd_pnlBotoes.top = new FormAttachment(0);
		fd_pnlBotoes.left = new FormAttachment(0);
		pnlBotoes.setLayoutData(fd_pnlBotoes);
		pnlBotoes.setLayout(new GridLayout(1, false));
		
		Button btnInserir = new Button(pnlBotoes, SWT.NONE);
		btnInserir.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Edit edit = new Edit();
				edit.open("insert");
			}
		});
		btnInserir.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, true, 1, 1));
		btnInserir.setText("&Inserir");
		
		Button btnAlterar = new Button(pnlBotoes, SWT.NONE);
		btnAlterar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(tblPrinc.getSelectionIndex() != -1) {
					Edit edit = new Edit();
					edit.open("edit");
				}
			}
		});
		btnAlterar.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, true, 1, 1));
		btnAlterar.setText("&Alterar");
		
		
		Button btnExcluir = new Button(pnlBotoes, SWT.NONE);
		btnExcluir.addListener(SWT.Selection, new Listener() {
		      public void handleEvent(Event e) {
		    	  if(tblPrinc.getSelectionIndex() != -1) {
		    		  Confirmar com =  new Confirmar();
		    		  if(com != null)
		    			  com.open();
		    	  }
		      }
		});
		btnExcluir.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, true, 1, 1));
		btnExcluir.setText("&Excluir");
		
		tblPrinc = new Table(pnlPrinc, SWT.BORDER | SWT.FULL_SELECTION | SWT.V_SCROLL
		        | SWT.H_SCROLL);
		FormData fd_tblPrinc = new FormData();
		fd_tblPrinc.height = 3;
		fd_tblPrinc.width = 7;
		fd_tblPrinc.bottom = new FormAttachment(0, 262);
		fd_tblPrinc.right = new FormAttachment(0, 434);
		fd_tblPrinc.top = new FormAttachment(0, 61);
		fd_tblPrinc.left = new FormAttachment(0, 72);
		for (int loopIndex = 0; loopIndex < colTitle.length; loopIndex++) {
		      TableColumn column = new TableColumn(tblPrinc, SWT.NONE);
		      column.setText(colTitle[loopIndex]);
		}
		FillColuna.Test(getArquivo(),tblPrinc);
		for (int loopIndex = 0; loopIndex < colTitle.length; loopIndex++) {
			tblPrinc.getColumn(loopIndex).pack();
		}
		tblPrinc.setLayoutData(fd_tblPrinc);
		tblPrinc.setHeaderVisible(true);
		tblPrinc.setLinesVisible(true);
		
		shlVenuepublication.open();
		shlVenuepublication.layout();
		shlVenuepublication.addListener(SWT.Close, new Listener() {
		    public void handleEvent(Event e) {
		    	try {
					FillColuna.FillArquivo(tblPrinc, arquivo);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		while (!shlVenuepublication.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	public static Table getTblPrinc() {
		// TODO Auto-generated method stub
		return tblPrinc;
	}

	public static File getArquivo() {
		return arquivo;
	}

	public static void setArquivo(File arquivo) {
		Principal.arquivo = arquivo;
	}
}