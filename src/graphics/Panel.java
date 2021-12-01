package graphics;

import java.awt.Frame;
import java.util.ArrayList;

import graphics.screen.SPanel;
import processing.Army;
import processing.Board;
import processing.Order;

public class Panel extends SPanel{

	public Panel(Frame observer) {
		super(observer);
		this.screens.put("game",new GameDisplay(null,null,null,this));
		this.setScreen("game");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void updateDisplay(ArrayList<Board> boardList, ArrayList<Army> armyList, ArrayList<Order> displayedOrders) {
		((GameDisplay) screens.get("game")).updateDisplay(boardList, armyList, displayedOrders);
		
	}
}
