package gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import swing2swt.layout.BorderLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import java.io.BufferedWriter;
import java.io.FileWriter;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.TableItem;

public class Edit {

	protected Shell shlEdit;
	private Text txtNome;
	private Text txtISSN;
	private String operation;

	/**
	 * Launch the application.
	 * @param args
	 */

	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open(String op) {
		operation = op;
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

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlEdit = new Shell(SWT.MIN | SWT.APPLICATION_MODAL);
		shlEdit.setSize(373, 407);
		shlEdit.setText("Venue2Publication");
		GridLayout gl_shlVenuepublication = new GridLayout(1, false);
		gl_shlVenuepublication.verticalSpacing = 0;
		gl_shlVenuepublication.marginWidth = 0;
		gl_shlVenuepublication.marginHeight = 0;
		gl_shlVenuepublication.horizontalSpacing = 0;
		shlEdit.setLayout(gl_shlVenuepublication);

		Composite pnlDados = new Composite(shlEdit, SWT.NONE);
		pnlDados.setLayout(new GridLayout(2, false));
		GridData gd_pnlDados = new GridData(SWT.CENTER, SWT.TOP, true, true, 1, 1);
		gd_pnlDados.heightHint = 296;
		gd_pnlDados.widthHint = 361;
		pnlDados.setLayoutData(gd_pnlDados);

		Label lblISSN = new Label(pnlDados, SWT.NONE);
		lblISSN.setText("ISSN");

		txtISSN = new Text(pnlDados, SWT.BORDER);
		txtISSN.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		txtISSN.addListener(SWT.Verify, new Listener() {
		      public void handleEvent(Event e) {
		          String string = e.text;
		          char[] chars = new char[string.length()];
		          string.getChars(0, chars.length, chars, 0);
		          for (int i = 0; i < chars.length; i++) {
		            if (!('0' <= chars[i] && chars[i] <= '9')) {
		              e.doit = false;
		              return;
		            }
		          }
		        }
		      });
		if (operation == "edit") {
			txtISSN.setEditable(false);
		}

		Label lblNome = new Label(pnlDados, SWT.NONE);
		lblNome.setText("Nome");

		txtNome = new Text(pnlDados, SWT.BORDER);
		txtNome.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));


		Label lblEdicao = new Label(pnlDados, SWT.NONE);
		lblEdicao.setText("Edi\u00E7\u00E3o");

		Spinner spnEdicao = new Spinner(pnlDados, SWT.BORDER);

		Label lblEstrato = new Label(pnlDados, SWT.NONE);
		lblEstrato.setText("Estrato");

		Combo cmbEstrato = new Combo(pnlDados, SWT.NONE | SWT.READ_ONLY);
		cmbEstrato.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		cmbEstrato.add("A1");
		cmbEstrato.add("A2");
		cmbEstrato.add("B1");
		cmbEstrato.add("B2");
		cmbEstrato.add("B3");
		cmbEstrato.add("B4");
		cmbEstrato.add("B5");
		cmbEstrato.add("C");

		Label lblDataLimite = new Label(pnlDados, SWT.NONE);
		lblDataLimite.setText("Data Limite");

		DateTime dateLimite = new DateTime(pnlDados, SWT.BORDER);

		Label lblDataEvento = new Label(pnlDados, SWT.NONE);
		lblDataEvento.setText("Data Evento");

		DateTime dateEvento = new DateTime(pnlDados, SWT.BORDER);

		Label lblFavorito = new Label(pnlDados, SWT.NONE);
		lblFavorito.setText("Favorito");

		Button chkFavorito = new Button(pnlDados, SWT.CHECK);

		Composite pnlBotoes = new Composite(shlEdit, SWT.NONE);
		pnlBotoes.setLayout(new BorderLayout(0, 0));
		GridData gd_pnlBotoes = new GridData(SWT.CENTER, SWT.BOTTOM, true, false, 1, 1);
		gd_pnlBotoes.widthHint = 361;
		gd_pnlBotoes.heightHint = 60;
		pnlBotoes.setLayoutData(gd_pnlBotoes);

		if (operation == "edit" && Principal.getTblPrinc().getSelectionIndex() != -1) {
			TableItem[] item = Principal.getTblPrinc().getSelection();
			txtISSN.setText(item[0].getText(0));
			txtNome.setText(item[0].getText(1));
			spnEdicao.setSelection(Integer.parseInt(item[0].getText(2)));
			cmbEstrato.setText(item[0].getText(3));
			dateLimite.setData(item[0].getText(4));
			dateEvento.setData(item[0].getText(5));
			chkFavorito.setSelection(Boolean.valueOf(item[0].getText(6)));
		}
		Button btnCancelar = new Button(pnlBotoes, SWT.NONE);
		btnCancelar.setLayoutData(BorderLayout.EAST);
		btnCancelar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlEdit.close();
			}
		});
		btnCancelar.setText("Ca&ncelar");

		Button btnConfirmar = new Button(pnlBotoes, SWT.NONE);
		btnConfirmar.setLayoutData(BorderLayout.CENTER);
		
		btnConfirmar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					FileWriter fw = new FileWriter (Principal.getArquivo(),true);
					BufferedWriter escritor = new BufferedWriter(fw);
					boolean validate = FillColuna.Validador(dateLimite,dateEvento);
					if (validate == false) {
						System.out.println("Data Invalida");
					}
					else if(escritor != null && validate == true) {
						if (operation == "edit") {
							FillColuna.Alter(Principal.getTblPrinc().getItem(Principal.getTblPrinc().getSelectionIndex()), txtNome.getText(), spnEdicao.getSelection(), cmbEstrato.getText(), dateLimite, dateEvento, String.valueOf(chkFavorito.getSelection()));
						}
						else if (operation == "insert") {
							escritor.write(txtISSN.getText() + ",");
							escritor.write(txtNome.getText() + ",");
							escritor.write(spnEdicao.getSelection() + ",");
							escritor.write(cmbEstrato.getText() + ",");
							escritor.write(dateLimite.getDay() + "/" + (dateLimite.getMonth()+1) + "/" + dateLimite.getYear() + ",");
							escritor.write(dateEvento.getDay() + "/" + (dateEvento.getMonth()+1) + "/" + dateEvento.getYear() + ",");
							escritor.write(String.valueOf(chkFavorito.getSelection()));
							FillColuna.ADD(Principal.getTblPrinc(), txtISSN.getText(), txtNome.getText(), spnEdicao.getSelection(), cmbEstrato.getText(), dateLimite, dateEvento, String.valueOf(chkFavorito.getSelection()));
							escritor.newLine();
							
						}
						escritor.close();
						fw.close();
						shlEdit.close();
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnConfirmar.setText("&Confirmar");
	}
}
