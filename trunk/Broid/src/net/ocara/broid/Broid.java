package net.ocara.broid;

import net.ocara.broid.util.CNPJ;
import net.ocara.broid.util.CPF;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Broid extends Activity {
	
	Button validaButton;
	Button limpaButton;
	Button geraCpfButton;
	Button geraCnpjButton;
	EditText validaText;
	String validaType;	
	String validaResult;
	String cpfCnpj;	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	Eula.show(this);
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        validaText = (EditText) findViewById(R.id.ValidaText);
        
        validaButton = (Button) findViewById(R.id.ValidaButton);
        validaButton.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View arg0) {
        		
        		validaType =  "CPF ou CNPJ ";
        		validaResult =  " INVÁLIDO!";
        		cpfCnpj = String.valueOf(validaText.getText());
        		
        		if (cpfCnpj.length() == 11
        				&& CPF.validaCPF(cpfCnpj)) {
        			validaType = "CPF ";
        			validaResult = " VÁLIDO!";        		
        		} else if (cpfCnpj.length() == 14
        				&& CNPJ.validaCNPJ(cpfCnpj)) {
        			validaType = "CNPJ ";
        			validaResult = " VÁLIDO!";
        		}
        		
        		new AlertDialog.Builder(Broid.this)
        		.setTitle("Resultado:")
        		.setMessage(validaType + cpfCnpj + validaResult)
        		.setNeutralButton("OK", new DialogInterface.OnClickListener(){
        			public void onClick(DialogInterface dialog, int wichButton) {		        				
        			}		        		
        		}).show();
        	}
        });
        
        limpaButton = (Button) findViewById(R.id.LimpaButton);
        limpaButton.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View arg0) {
        		validaText.setText("");
        	}
        });
        
        geraCpfButton = (Button) findViewById(R.id.GeraCPFButton);
        geraCpfButton.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View arg0) {
        		validaText.setText(CPF.geraCPF());
        	}
        });
        
        geraCnpjButton = (Button) findViewById(R.id.GeraCNPJButton);
        geraCnpjButton.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View arg0) {
        		validaText.setText(CNPJ.geraCNPJ());
        	}
        });
    }
}