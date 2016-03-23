

public class Queen {
	private int row;
	private int column;
	public Queen(int r, int c){
		row = r;
		column  = c;
	}
	public boolean mythreat(Queen q){
		boolean mythreat=false;
		

		if(row==q.getRow() || column==q.getColumn())
			mythreat=true;
		else if(Math.abs(column-q.getColumn()) == Math.abs(row-q.getRow()))
			mythreat=true;
		return mythreat;
	}
	

	public void moveDown(int spaces){
		row+=spaces;
		if(row>7 && row%7!=0){
			row=(row%7)-1;
		}
		else if(row>7 && row%7==0){
			row=7;
		}
	}

	public void setRow(int r){

		row = r;
	}
	public int getRow(){

		return row;
	}
	public String toString(){

		return "("+row+", "+ column+")";
	}
	public int getColumn(){
		return
				column;
	}
	public void setColumn(int c){

		column = c;
	}


}
