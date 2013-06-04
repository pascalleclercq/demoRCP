package demo.wb;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import demo.pojo.Personne;

public class PersonneComposite extends Composite {

	private PersonneCompositeController m_controller;
	private DateTime dtNaissanceText;
	private Text nomText;
	private Text prenomText;

	public PersonneComposite(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(2, false));

		new Label(this, SWT.NONE).setText("DtNaissance:");

		dtNaissanceText = new DateTime(this, SWT.BORDER | SWT.SINGLE);
		dtNaissanceText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false));

		new Label(this, SWT.NONE).setText("Nom:");

		nomText = new Text(this, SWT.BORDER | SWT.SINGLE);
		nomText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		new Label(this, SWT.NONE).setText("Prenom:");

		prenomText = new Text(this, SWT.BORDER | SWT.SINGLE);
		prenomText
				.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		m_controller = new PersonneCompositeController(this);
	}

	public Personne getPersonne() {
		return m_controller.getPersonne();
	}
	public void setPersonne(Personne personne){
		
		m_controller.setPersonne(personne);
	}
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public DateTime getDtNaissanceText() {
		return dtNaissanceText;
	}

	public Text getNomText() {
		return nomText;
	}

	public Text getPrenomText() {
		return prenomText;
	}

}
