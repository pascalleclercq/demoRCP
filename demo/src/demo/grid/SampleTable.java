package demo.grid;

import java.security.acl.LastOwnerException;

import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.forms.widgets.FormToolkit;

import demo.pojo.Personne;
import demo.pojo.PersonneService;

public class SampleTable extends Composite {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Table table;
	private TableViewer tableViewer;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public SampleTable(Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		setLayout(new FillLayout(SWT.HORIZONTAL));

		Composite composite = new Composite(this, SWT.NONE);
		toolkit.adapt(composite);
		toolkit.paintBordersFor(composite);
		TableColumnLayout tcl_composite = new TableColumnLayout();
		composite.setLayout(tcl_composite);

		tableViewer = new TableViewer(composite, SWT.BORDER
				| SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		toolkit.paintBordersFor(table);

		TableViewerColumn tableViewerColumn = new TableViewerColumn(
				tableViewer, SWT.NONE);
		tableViewerColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				
				return ((Personne)element).getPrenom();
			}
		});
		TableColumn col1 = tableViewerColumn.getColumn();
		tcl_composite.setColumnData(col1, new ColumnWeightData(1,
				ColumnWeightData.MINIMUM_WIDTH, true));
		col1.setText("Col 1");
		FirstNameEditingSupport firstNameEditingSupport = new FirstNameEditingSupport(
				tableViewer);
		tableViewerColumn.setEditingSupport(firstNameEditingSupport);
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn col2 = tableViewerColumn_1.getColumn();
		tcl_composite.setColumnData(col2, new ColumnWeightData(1,
				ColumnWeightData.MINIMUM_WIDTH, true));
		col2.setText("Col 2");
		tableViewer.setContentProvider(new ArrayContentProvider());
		tableViewerColumn_1.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				
				return ((Personne)element).getNom();
			}
		});
		LasrNameEditingSupport lasrNameEditingSupport = new LasrNameEditingSupport(tableViewer);
		tableViewerColumn_1.setEditingSupport(lasrNameEditingSupport);
		tableViewer.setInput(PersonneService.getPersonnes());
	}
	public TableViewer getTableViewer() {
		return tableViewer;
	}
}
