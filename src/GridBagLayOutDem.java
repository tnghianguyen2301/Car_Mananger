import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class GridBagLayOutDem extends JFrame {
	JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;
	JPanel mainPanel, contentPanel;
	JPanel mainJPanel = new JPanel();
	LayoutManager layout;
	GridBagConstraints c;
	public GridBagLayOutDem() throws ClassNotFoundException, IOException, SQLException {
		layout = new GridBagLayout();
		c = new GridBagConstraints();
		this.setLayout(layout);
		// Button 1
		btn1 = new JButton("Button 1");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy= 0;
		c.gridwidth = 2;
		btn1.setPreferredSize(new Dimension(200, 60));
		this.add(btn1, c);
		
		btn2 = new JButton("Button 2");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		btn2.setPreferredSize(new Dimension(200, 60));
		this.add(btn2, c);
		
		btn3 = new JButton("Button 3");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		btn3.setPreferredSize(new Dimension(200, 60));
		this.add(btn3, c);
		
		btn4 = new JButton("Button 4");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		btn4.setPreferredSize(new Dimension(200, 60));
		this.add(btn4, c);
		
		btn5 = new JButton("Button 5");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		btn5.setPreferredSize(new Dimension(200, 60));
		this.add(btn5, c);
		
		btn6 = new JButton("Button 6");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 5;
		c.anchor = GridBagConstraints.NORTH;
		btn6.setPreferredSize(new Dimension(200, 60));
		this.add(btn6, c);
		
		btn7 = new JButton("Button 7");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 6;
		btn7.setPreferredSize(new Dimension(200, 60));
		this.add(btn7, c);
		
		btn8 = new JButton("Button 8");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 6;
		btn8.setPreferredSize(new Dimension(800, 60));
		this.add(btn8, c);
		ProductsPanel products = new ProductsPanel();
		contentPanel = products;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 1;
		c.gridheight = 5;
		contentPanel.setPreferredSize(new Dimension(800, 600));
		btn2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// Load panel1 vao vi tri cua contentPanel
				//System.out.println("Button 2");
				btn2.getParent().remove(contentPanel);
				btn2.getParent().revalidate();
				
				c.fill = GridBagConstraints.BOTH;
				c.gridx = 1;
				c.gridy = 1;
				c.gridheight = 5;
				
				try {
					btn2.getParent().add(new HistoryPanel(),c);
				} catch (ClassNotFoundException | IOException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				btn2.getParent().repaint();
			}			
		});
		
		this.add(contentPanel,c);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.pack();
	}
	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
		// TODO Auto-generated method stub
		new GridBagLayOutDem();
	}

}
