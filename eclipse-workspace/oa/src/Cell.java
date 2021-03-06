import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;

import javax.swing.JButton;
/*
 * Each cell is a button with additional information on which position it is in. 
 * Also stores which value each cell has (not necessary as we can just get the value directly from JButton through the string) 
 *  
 */
public class Cell extends JButton {
	private int col; 
	private int row;
	private Integer value=0;
	
	Cell(int row, int col,Integer value ){
		super(value.toString());
		this.value=value; 
		this.col=col;
		this.row=row; 
		
	
	}

	public Integer getValue() {
		return value; 
	}
	
	public int getCol() {
		return col; 
	}
	
	public int getRow() {
		return row; 
	}
	public void setRow(int i) {
		this.row=i;
	}
	public void setCol(int i) {
		this.col=i;
	}
	
	/**
	 * The function swaps the value field between this cell and the other, but also the labels of the button. 
	 * 
	 * @param b The cell to swap values with.
	 */
	public void swapValue(Cell b) {
		Integer temp;
		temp=value;
		setValue(b.getValue());
		b.setValue(temp);
		b.setLabel(b.getValue().toString());
		setLabel(getValue().toString());
		
	}
	public void setValue(int value) {
		this.value=value; 
	}
	
	/**
	 * 
	 * @param b = the cell that we compare the distance to
	 * @return the distance to this cell and cell b. 
	 */
	public double getDistance(Cell b) {
		return  Math.sqrt( (col-b.col)*(col-b.col)  + (row-b.row)*(row-b.row) ); 
		
	}
	

	
	
	
}
