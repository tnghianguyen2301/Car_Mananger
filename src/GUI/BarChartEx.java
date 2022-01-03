package GUI;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;

import DTO.User;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;

public class BarChartEx extends JFrame {
	 private static JDBCCategoryDataset dataset;
	 private User user;
	 /**
	  * @wbp.nonvisual location=419,54
	  */
    public BarChartEx(User user) throws SQLException {

        initUI(user);
    }

    public BarChartEx() {
		// TODO Auto-generated constructor stub
	}

	private void initUI(User user) throws SQLException {
    	this.user = user;
        CategoryDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        getContentPane().add(chartPanel, BorderLayout.NORTH);
        getContentPane().setBounds(900, 50, 20, 20);
        pack();
        setTitle("Report Quantity Car Type Sell In Month");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private CategoryDataset createDataset() throws SQLException {

    	 String url = "jdbc:mysql://localhost:3306/car_manager";
         String user = "root";
         String password = "ronthanhyal123";

         try (Connection con = DriverManager.getConnection(url, user, password)) {

             dataset = new JDBCCategoryDataset(con);
             dataset.executeQuery("SELECT car_type, car_quantity FROM car_report");
         }

        return dataset;
    }

    private JFreeChart createChart(CategoryDataset dataset) {

        JFreeChart barChart = ChartFactory.createBarChart(
                "Report Quantity Car Type Sell In Month",
                "Type",
                "Quantity",
                dataset,
                PlotOrientation.VERTICAL,
                false, false, false);

        return barChart;
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

        	BarChartEx ex = null;
			ex = new BarChartEx();
            ex.setVisible(true);
        });
    }
}