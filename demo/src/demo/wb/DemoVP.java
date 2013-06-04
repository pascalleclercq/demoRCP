package demo.wb;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import demo.grid.SampleTable;
import demo.pojo.Personne;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.core.databinding.beans.PojoProperties;

public class DemoVP extends ViewPart {
	private DataBindingContext m_bindingContext;

	public static final String ID = "demo.wb.DemoVP"; //$NON-NLS-1$

	public DemoVP() {
	}

	PersonneComposite personneComposite ;
	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new FillLayout(SWT.VERTICAL));
		{
			sampleTable = new SampleTable(container, SWT.NONE);
		}
		{
			personneComposite = new PersonneComposite(container, SWT.NONE);
		}

		createActions();
		initializeToolBar();
		initializeMenu();
		m_bindingContext = initDataBindings();
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

	/**
	 * Initialize the toolbar.
	 */
	private void initializeToolBar() {
		IToolBarManager toolbarManager = getViewSite().getActionBars()
				.getToolBarManager();
	}

	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
		IMenuManager menuManager = getViewSite().getActionBars()
				.getMenuManager();
	}

	@Override
	public void setFocus() {
		// Set the focus
	}

	private Personne personne;
	private SampleTable sampleTable;

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
	
	
	
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue observeSingleSelectionSampleTablegetTableViewer = ViewerProperties.singleSelection().observe(sampleTable.getTableViewer());
		IObservableValue personnePersonneCompositeObserveValue = PojoProperties.value("personne").observe(personneComposite);
		bindingContext.bindValue(observeSingleSelectionSampleTablegetTableViewer, personnePersonneCompositeObserveValue, null, null);
		//
		return bindingContext;
	}
}
