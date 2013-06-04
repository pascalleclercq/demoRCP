package demo.grid;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.widgets.Composite;

import demo.pojo.Personne;
public class LasrNameEditingSupport extends EditingSupport {

	private final TableViewer viewer;
	public LasrNameEditingSupport(TableViewer viewer) {
		super(viewer);
		this.viewer=viewer;
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		return new TextCellEditor(viewer.getTable());
	}

	@Override
	protected boolean canEdit(Object element) {
		return true;
	}

	@Override
	protected Object getValue(Object element) {
		return ((Personne) element).getNom();
	}

	@Override
	protected void setValue(Object element, Object value) {
		((Personne) element).setNom((String)value);

	}

}
