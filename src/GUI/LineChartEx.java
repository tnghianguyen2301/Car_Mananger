package GUI;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		JPanel panel = new JPanel();
		JButton back_Main = new JButton("Back");
		chartPanel.setPreferredSize(new java.awt.Dimension(700, 500));
		ApplicationFrame f = new ApplicationFrame("Chart");
		panel.add(chartPanel);
		panel.add(back_Main);
		panel.setBackground(Color.WHITE);
		f.setContentPane(panel);
		f.pack();
		f.setVisible(true);
		f.setTitle("Report Turnover");
		f.setLocationRelativeTo(null);
		back_Main.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					new Manage(user);
				} catch (ClassNotFoundException | IOException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				f.setVisible(true);
				f.dispose();
			}
		});
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
