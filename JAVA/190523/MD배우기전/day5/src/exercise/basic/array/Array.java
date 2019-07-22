package exercise.basic.array;

import java.util.Random;

public class Array {
	private String title;
	private int row;
	private int col;
	private int[][] array;
	
	Array(String title,int row, int col){
		this.title=title;
		this.row=row;
		this.col=col;
		this.array = new int[row][col];
	}

	public int getRow() {return row;}
	public void setRow(int row) {this.row = row;}
	
	public int getCol(){return col;}
	public void setCol(int col){this.col = col;}
	
	public int[][] getArray(){return array;}
	
	public void setArray(int array[][]){
		this.array=array;
	}
	
	public void makeArrayData(){
		
		//int [][] array = new int[this.getRow()][this.getCol()];
		//이중배열 H1 참고
		for(int r=0;r<row;r++) {
			for(int c=0;c<col;c++) {
				array[r][c]=this.getRandomNumber();
			}
		}
		this.setArray(this.array);
	}
	private int getRandomNumber() {
		
		Random r = new Random();
		int rnum = r.nextInt(this.row*this.col)+1;
		return rnum;
	}
	
	public void printArray() {
		for(int r=0;r<row;r++) {
			for(int c=0;c<col;c++) {
			System.out.print(array[r][c] +" ");
			}
			System.out.println();
		}
	}
	public void findMatchNumber(Array src, Array desc) {
		int count = 0;
		for(int r =0;r<row;r++) {
			for(int c=0;c<col;c++) {
				if(src.array[r][c]==desc.array[r][c]) {
					count++;
					System.out.printf("일치하는 숫자 : [%d] [%d] = %d\n",r,c,array[r][c]);;
				}
			}
		}
		System.out.printf("## 일치하는 숫자 갯수 : %d\n",count);
		
				
	}
	
	
}
