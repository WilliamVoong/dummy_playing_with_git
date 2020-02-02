import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import java.util.Observer;

public class FifteenGame {
	private ArrayList<Cell> gameBoard; 
	public final static int GAME_SIZE = 4 ; 
	protected PropertyChangeSupport propertyChangeSupport;
	private String winning="hej"; 
	
	/**
	 * when creating a instance of the Game, it generates a new board which is represented
	 * in the arraylist cells. 
	 * The Fifteengame class handles the rules of the game, and also how cells are moving in the game in reaction to when you press a button. 
	 * 
	 */
	FifteenGame(){ 
		propertyChangeSupport= new PropertyChangeSupport(this);
		GameGenerator generator= new GameGenerator(GAME_SIZE); 
		gameBoard= new ArrayList<Cell>();
		int col=0;
		int row=0; 
	
		for(int i : generator) {
			Cell c = new Cell(col,row,i);
			c.addActionListener(new ActionListener() {   
				
				 public void actionPerformed(ActionEvent e) { // performs
					 if(  neighbourToBlank(c) ) {
						c.swapValue(findBlank());
					 }else {
						 Toolkit.getDefaultToolkit().beep();
					 }
					
					
	
					 if( true ) {
						setWinning(3);
						 //propertyChangeSupport.firePropertyChange("he", 0, 1);
						 
						 // <--- TODO should be a new window that pops up instead of console-msg.
					 }									// <--- TODO the popup should contain a winning msg and how many moves player made
					 
				}
			});
			
			gameBoard.add(c);
			
			row++;					// <--- gets new position of the next Cell.
			if(row==GAME_SIZE) {	// <--- Start from 0 again, when we reached end of row. 
				col++;				//
				row=0; 				//
			}
		}
	}
	public ArrayList<Cell> getCells(){
		return gameBoard;
	} 
	
	
	/**
	 * 
	 * @Input A Cell to check if neighbour with blank
	 * @return returns true if the input-Cell  is a vertical or horizontal neighbour, false otherwise. 
	 */
	private boolean neighbourToBlank(Cell c){
			Cell blank= findBlank(); 	
			 String oldwinning=winning;
			 winning="hejd�";
			 propertyChangeSupport.firePropertyChange("ancestor",oldwinning,winning);
			return c.getDistance(blank)==1.0;
			
			
	}
	
	/**
	 * 
	 * @return the Blank Cell in the board,  null otherwise. 
	 */
	private Cell findBlank() {
		for( Cell cInField  : gameBoard) {
			if(cInField.getValue().equals(0)) {
				return cInField; 
			}
		}
		return null;
	}
	/** 
	 * @return true if the board is in winningposition, false otherwise. 
	 */
	private Boolean winningcondtion(){
		for(int i=0; i<gameBoard.size(); i++ ){
			int expectedCellValue=i+1; // 1 2 3 4 osv. 
			boolean isWinningValue= (expectedCellValue==gameBoard.get(i).getValue()) || (i==gameBoard.size()-1 && gameBoard.get(i).getValue()==0);
			if(!isWinningValue) {
				return false;
			}	
		}
		return true;
	}
	 public void addPropertyChangeListener(PropertyChangeListener listener) {
	        propertyChangeSupport.addPropertyChangeListener(listener);
	 }
	 
	 public void setWinning(int wining) {
		 String oldwinning="hej";
		 this.winning= "hejd" + "a";
		 propertyChangeSupport.firePropertyChange("3", oldwinning, winning);
		 
		 
	 }
	 public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
		 propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
	   }

	

	
	
}
