package demo.grid;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;

import demo.pojo.Personne;

public class FirstNameEditingSupport extends EditingSupport {

	private final TableViewer viewer;

	public FirstNameEditingSupport(TableViewer viewer) {
		super(viewer);
		this.viewer = viewer;
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
		return ((Personne) element).getPrenom();
	}

	@Override
	protected void setValue(Object element, Object value) {
		((Personne) element).setPrenom((String) value);

	}
}
