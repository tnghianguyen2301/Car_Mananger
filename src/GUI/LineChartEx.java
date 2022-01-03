package GUI;
import java.sql.*;
import java.io.*;
import org.jfree.ui.*;

import DTO.User;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.*;
import org.jfree.data.jdbc.JDBCCategoryDataset;

public class LineChartEx {
	public LineChartEx(User user) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated constructor stub
		String query = "SELECT month, turnover from car_report_turnover";
		JDBCCategoryDataset dataset = new JDBCCategoryDataset(
				"jdbc:mysql://localhost:3306/car_manager", "com.mysql.cj.jdbc.Driver",
				"root", "ronthanhyal123");

		dataset.executeQuery(query);
		JFreeChart chart = ChartFactory.createLineChart("Report Turnover", "Month", "Turnover",
				dataset, PlotOrientation.VERTICAL, true, true, false);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(700, 500));
		ApplicationFrame f = new ApplicationFrame("Chart");
		f.setContentPane(chartPanel);
		f.pack();
		f.setVisible(true);
		f.setTitle("Report Turnover");
		f.setLocationRelativeTo(null);
	}

	public static void main(String[] args) throws Exception {
		String query = "SELECT month, turnover from car_report_turnover";
		JDBCCategoryDataset dataset = new JDBCCategoryDataset(
				"jdbc:mysql://localhost:3306/car_manager", "com.mysql.cj.jdbc.Driver",
				"root", "ronthanhyal123");

		dataset.executeQuery(query);
		JFreeChart chart = ChartFactory.createLineChart("Report Turnover", "Month", "Turnover",
				dataset, PlotOrientation.VERTICAL, true, true, false);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(700, 500));
		ApplicationFrame f = new ApplicationFrame("Chart");
		f.setContentPane(chartPanel);
		f.pack();
		f.setVisible(true);
		f.setTitle("Report Turnover");
		f.setLocationRelativeTo(null);
	}
}
