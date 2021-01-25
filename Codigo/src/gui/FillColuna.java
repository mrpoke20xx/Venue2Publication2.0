package gui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

public class FillColuna {
	
	public static void Test(File arquivo, Table tblPrinc) {
		try {
			Scanner scan = new Scanner(arquivo);
			while(scan.hasNext()) {
				
				String lin = scan.nextLine();
				String[] lin2 = lin.split(",");
				TableItem item = new TableItem(tblPrinc, SWT.NONE);
				if(lin2.length >= 0) {
					item.setText(lin2[0]);
					item.setText(1,lin2[1]);
					item.setText(2,lin2[2]);
					item.setText(3,lin2[3]);
					item.setText(4,lin2[4]);
					item.setText(5,lin2[5]);
					item.setText(6,lin2[6]);
				}
			}
			scan.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public static void Test2(File arquivo, Table tblBusca, String Busca) {
		try {
			Scanner scan = new Scanner(arquivo);
			while(scan.hasNext()) {
				
				String lin = scan.nextLine();
				String[] lin2 = lin.split(",");
				
				boolean achou = false;
				for(int i = 0; i < lin2.length;i++) {
					if(Busca.equals(lin2[i]) && !Busca.equals("")) {
						achou = true;
						
					}
				}
				if(lin2.length >= 0 && achou == true) {
					TableItem item = new TableItem(tblBusca, SWT.NONE);
					item.setText(lin2[0]);
					item.setText(1,lin2[1]);
					item.setText(2,lin2[2]);
					item.setText(3,lin2[3]);
					item.setText(4,lin2[4]);
					item.setText(5,lin2[5]);
					item.setText(6,lin2[6]);
				}
			}
			scan.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public static void ADD(Table tblPrinc,String txtISSN,String txtNome,int spnEdicao,String cmbEstrato,DateTime dateLimite,DateTime dateEvento,String favorito) {
		try {
				TableItem item = new TableItem(tblPrinc, SWT.NONE);
				item.setText(txtISSN);
				item.setText(1,txtNome);
				item.setText(2,String.valueOf(spnEdicao));
				item.setText(3,cmbEstrato.toString());
				item.setText(4,dateLimite.getDay() + "/" + (dateLimite.getMonth()+1) + "/" + dateLimite.getYear());
				item.setText(5,dateEvento.getDay() + "/" + (dateEvento.getMonth()+1) + "/" + dateEvento.getYear());
				item.setText(6,favorito.toString());
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public static void Alter(TableItem i,String txtNome,int spnEdicao,String cmbEstrato,DateTime dateLimite,DateTime dateEvento,String favorito) {
		try {
			i.setText(1,txtNome);
			i.setText(2,String.valueOf(spnEdicao));
			i.setText(3,cmbEstrato.toString());
			i.setText(4,dateLimite.getDay() + "/" + (dateLimite.getMonth()+1) + "/" + dateLimite.getYear());
			i.setText(5,dateEvento.getDay() + "/" + (dateEvento.getMonth()+1) + "/" + dateEvento.getYear());
			i.setText(6,favorito.toString());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public static boolean Validador(DateTime dateLimite,DateTime dataEvento) {
		if(dateLimite.getYear() <= dataEvento.getYear())
			return true;
		else
			return false;
	}
	public static void FillArquivo(Table tblPrinc,File arquivo) throws IOException {
		File arquivoSUP = new File("databaseSUP.txt");
		FileWriter fw2 = new FileWriter (arquivoSUP);
		TableItem[] items = tblPrinc.getItems();
		BufferedWriter escritores = new BufferedWriter(fw2);
		try {
			for(int i = 0;i < tblPrinc.getItemCount();i++) {
				for(int n = 0; n < 7;n++) {
					if(n==6) {
						escritores.write(items[i].getText(n));
					}
					else {
						escritores.write(items[i].getText(n)+",");
					}
				}
				escritores.newLine();
			}
			arquivo.delete();
			escritores.close();
			fw2.close();
			arquivoSUP.renameTo(new File("database.txt"));
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
