package GUI;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BarChartEx extends JFrame {
	 private static JDBCCategoryDataset dataset;

    public BarChartEx() throws SQLException {

        initUI();
    }

    private void initUI() throws SQLException {

        CategoryDataset dataset = createDataset();

        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel);

        pack();
        setTitle("Report Quantity Car Type Sell In Month");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
			try {
				ex = new BarChartEx();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            ex.setVisible(true);
        });
    }
}