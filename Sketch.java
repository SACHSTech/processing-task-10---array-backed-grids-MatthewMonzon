import processing.core.PApplet;

public class Sketch extends PApplet {
	int CELL_WIDTH = 20;
  int CELL_HEIGHT = 20;
  int MARGIN = 5;
  int ROW_COUNT = 10;
  int COLUMN_COUNT = 10;
  int SCREEN_WIDTH = (CELL_WIDTH + MARGIN) * COLUMN_COUNT + MARGIN;
  int SCREEN_HEIGHT = (CELL_HEIGHT + MARGIN) * ROW_COUNT + MARGIN;

  int[][] intGrid = new int[ROW_COUNT][COLUMN_COUNT];

  int cellsSelected;
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
    // put your size call here
    size(SCREEN_WIDTH, SCREEN_HEIGHT);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(0,0,0);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */

   //draw grid
  public void draw() {
	  for (int column = 0; column < COLUMN_COUNT; column++) {
      for (int row = 0; row < ROW_COUNT; row++) {

        //if array is equal to 1 set color to green
        if (intGrid[row][column] == 1) {
          fill(0, 255, 0);
          rect(MARGIN + (column * (CELL_WIDTH + MARGIN)), MARGIN + (row * (CELL_HEIGHT + MARGIN)), CELL_WIDTH, CELL_HEIGHT);
       
        }

        else {
          fill(255, 255, 255);
          rect(MARGIN + (column * (CELL_WIDTH + MARGIN)), MARGIN + (row * (CELL_HEIGHT + MARGIN)), CELL_WIDTH, CELL_HEIGHT);
        }
      }
    }
  }


  

  public void mousePressed(){
    
  }
}
