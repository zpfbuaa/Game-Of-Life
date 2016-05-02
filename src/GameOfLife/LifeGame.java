package GameOfLife;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LifeGame extends JFrame{
	private final World world;
	public LifeGame(int rows,int columns)
	{
		world=new World(rows, columns);
		new Thread(world).start();
		add(world);
	}
	public static void main(String[]args)
	{
		LifeGame frame=new LifeGame(40, 50);
		
		JMenuBar menu=new JMenuBar();
		frame.setJMenuBar(menu);
		
		JMenu options =new JMenu("Options");
		menu.add(options);
		
		JMenuItem arrow=options.add("Arrow");
		arrow.addActionListener(frame.new ArrowActionListener());
		JMenuItem square=options.add("Square");
		square.addActionListener(frame.new SquareActionListener());
		
		JMenu help=new JMenu("Help");
		menu.add(help);
		
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1007,859);
		frame.setTitle("Game of Life");
		frame.setVisible(true);
		frame.setResizable(false);
	}
	class ArrowActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			world.setArrow();
		}
	}
	class SquareActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			world.setSquare();
		}
	}
}
