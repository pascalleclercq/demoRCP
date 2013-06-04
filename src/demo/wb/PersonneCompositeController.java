package demo.wb;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.swt.SWT;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.PojoObservables;

import demo.pojo.Personne;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.core.databinding.beans.PojoProperties;


public class PersonneCompositeController {
	private PersonneComposite m_personneComposite;
	private DataBindingContext m_bindingContext;
	private demo.pojo.Personne personne = new demo.pojo.Personne();

	public PersonneCompositeController(PersonneComposite personneComposite, demo.pojo.Personne newPersonne) {
		m_personneComposite = personneComposite;
		setPersonne(newPersonne);
		m_bindingContext = initDataBindings();
	}

	public PersonneCompositeController(PersonneComposite personneComposite) {
		m_personneComposite = personneComposite;
		if (personne != null) {
			m_bindingContext = initDataBindings();
		}
	}

	public demo.pojo.Personne getPersonne() {
		return personne;
	}

	public void setPersonne(demo.pojo.Personne newPersonne) {
		setPersonne(newPersonne, true);
	}

	public void setPersonne(demo.pojo.Personne newPersonne, boolean update) {
		personne = newPersonne;
		if (update) {
			if (m_bindingContext != null) {
				m_bindingContext.dispose();
				m_bindingContext = null;
			}
			if (personne != null) {
				m_bindingContext = initDataBindings();
			}
		}
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue nomObserveWidget = SWTObservables.observeText(m_personneComposite.getNomText(), SWT.Modify);
		IObservableValue nomObserveValue = PojoObservables.observeValue(personne, "nom");
		bindingContext.bindValue(nomObserveWidget, nomObserveValue, null, null);
		//
		IObservableValue prenomObserveWidget = SWTObservables.observeText(m_personneComposite.getPrenomText(), SWT.Modify);
		IObservableValue prenomObserveValue = PojoObservables.observeValue(personne, "prenom");
		bindingContext.bindValue(prenomObserveWidget, prenomObserveValue, null, null);
		//
		
		IObservableValue observeSelectionPersonneCompositegetDtNaissanceTextObserveWidget = WidgetProperties.selection().observe(m_personneComposite.getDtNaissanceText());
		IObservableValue datePersonnegetDtNaissanceObserveValue = PojoObservables.observeValue(personne, "dtNaissance");
		bindingContext.bindValue(observeSelectionPersonneCompositegetDtNaissanceTextObserveWidget, datePersonnegetDtNaissanceObserveValue, null, null);
		//
		return bindingContext;
	}
}