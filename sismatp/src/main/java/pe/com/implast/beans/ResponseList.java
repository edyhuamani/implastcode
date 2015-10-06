package pe.com.implast.beans;

import java.util.List;

public class ResponseList<T> {
	
	private List<T> rows;

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}
}
