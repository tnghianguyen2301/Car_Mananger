package DAO;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import org.w3c.dom.css.ElementCSSInlineStyle;

import DTO.HistoryCar;

public class CarHistoryModel extends AbstractTableModel {
	private String[] columnName = {"ID","Name","TradeMark","Type","Color","Status","AddPirce","ExportPrice","AddDate","ExportDate"};
	private ArrayList<HistoryCar> historyListTbM;
	public CarHistoryModel(HistoryProdutcsDAO hpDAO) {
		historyListTbM = hpDAO.getHistoryCarList();
	}

	@Override
	public int getRowCount() {
		int size;
		if(historyListTbM == null) {
			size = 0;
		}
		else {
			size = historyListTbM.size();
		}
		return size;
	}

	@Override
	public int getColumnCount() {
		return columnName.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object temp = null;
		if(columnIndex == 0) {
			temp = new Integer(historyListTbM.get(rowIndex).getHistory_id());
		}
		else if(columnIndex == 1) {
			temp = historyListTbM.get(rowIndex).getHistory_name();
		}
		else if(columnIndex == 2) {
			temp = historyListTbM.get(rowIndex).getHistory_trademark();
		}
		else if(columnIndex == 3) {
			temp = historyListTbM.get(rowIndex).getHistory_type();
		}
		else if(columnIndex == 4) {
			temp = historyListTbM.get(rowIndex).getHistory_color();
		}
		else if(columnIndex == 5) {
			temp = historyListTbM.get(rowIndex).getHistory_status();
		}
		else if (columnIndex == 6) {
			temp = new Double(historyListTbM.get(rowIndex).getHistory_add_price());
		}
		else if(columnIndex == 7) {
			temp = new Double(historyListTbM.get(rowIndex).getHistory_export_price());
		}
		else if(columnIndex == 8) {
			temp = historyListTbM.get(rowIndex).getHistory_add_date();
		}
		else if(columnIndex == 9) {
			temp = historyListTbM.get(rowIndex).getHistory_export_date();
		}
		return temp;
	}
	public String getColumnName(int col) {
		return columnName[col];
	}
	public Class getColumnClass(int col) {
		if(col == 0) {
			return Integer.class;
		}
		if(col == 6 && col == 7) {
			return Double.class;
		}
		if(col == 8 && col == 9) {
			return LocalDate.class;
		}
		else {
			return String.class;
		}
	}
}
