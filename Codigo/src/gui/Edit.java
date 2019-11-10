package gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import swing2swt.layout.BorderLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Spinner;

public class Edit {

	protected Shell shlVenuepublication;
	private Text txtNome;
	private Text txtISSN;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Edit window = new Edit();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlVenuepublication.open();
		shlVenuepublication.layout();
		while (!shlVenuepublication.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlVenuepublication = new Shell();
		shlVenuepublication.setSize(373, 407);
		shlVenuepublication.setText("Venue2Publication");
		GridLayout gl_shlVenuepublication = new GridLayout(1, false);
		gl_shlVenuepublication.verticalSpacing = 0;
		gl_shlVenuepublication.marginWidth = 0;
		gl_shlVenuepublication.marginHeight = 0;
		gl_shlVenuepublication.horizontalSpacing = 0;
		shlVenuepublication.setLayout(gl_shlVenuepublication);
		
		Composite pnlDados = new Composite(shlVenuepublication, SWT.NONE);
		pnlDados.setLayout(new GridLayout(2, false));
		GridData gd_pnlDados = new GridData(SWT.CENTER, SWT.TOP, true, true, 1, 1);
		gd_pnlDados.heightHint = 296;
		gd_pnlDados.widthHint = 361;
		pnlDados.setLayoutData(gd_pnlDados);
		
		Label lblISSN = new Label(pnlDados, SWT.NONE);
		lblISSN.setText("ISSN");
		
		txtISSN = new Text(pnlDados, SWT.BORDER);
		txtISSN.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblNome = new Label(pnlDados, SWT.NONE);
		lblNome.setText("Nome");
		
		txtNome = new Text(pnlDados, SWT.BORDER);
		txtNome.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblEdicao = new Label(pnlDados, SWT.NONE);
		lblEdicao.setText("Edi\u00E7\u00E3o");
		
		Spinner spnEdicao = new Spinner(pnlDados, SWT.BORDER);
		
		Label lblEstrato = new Label(pnlDados, SWT.NONE);
		lblEstrato.setText("Estrato");
		
		Combo cmbEstrato = new Combo(pnlDados, SWT.NONE);
		cmbEstrato.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblDataLimite = new Label(pnlDados, SWT.NONE);
		lblDataLimite.setText("Data Limite");
		
		DateTime dateLimite = new DateTime(pnlDados, SWT.BORDER);
		
		Label lblDataEvento = new Label(pnlDados, SWT.NONE);
		lblDataEvento.setText("Data Evento");
		
		DateTime dateEvento = new DateTime(pnlDados, SWT.BORDER);
		
		Label lblFavorito = new Label(pnlDados, SWT.NONE);
		lblFavorito.setText("Favorito");
		
		Button chkFavorito = new Button(pnlDados, SWT.CHECK);
		
		Composite pnlBotoes = new Composite(shlVenuepublication, SWT.NONE);
		pnlBotoes.setLayout(new BorderLayout(0, 0));
		GridData gd_pnlBotoes = new GridData(SWT.CENTER, SWT.BOTTOM, true, false, 1, 1);
		gd_pnlBotoes.widthHint = 361;
		gd_pnlBotoes.heightHint = 60;
		pnlBotoes.setLayoutData(gd_pnlBotoes);
		
		Button btnCancelar = new Button(pnlBotoes, SWT.NONE);
		btnCancelar.setLayoutData(BorderLayout.EAST);
		btnCancelar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnCancelar.setText("Cancelar");
		
		Button btnConfirmar = new Button(pnlBotoes, SWT.NONE);
		btnConfirmar.setLayoutData(BorderLayout.CENTER);
		btnConfirmar.setText("Confirmar");

	}

}
