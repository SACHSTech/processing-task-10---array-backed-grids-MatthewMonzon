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

  public void mousePressed() {

    // changes colour clicked cell and surroundung 
    for (int column = 0; column < COLUMN_COUNT; column++) {
      for (int row = 0; row < ROW_COUNT; row++) {
        
        if (mouseX / (CELL_WIDTH + MARGIN) == column && mouseY / (CELL_HEIGHT + MARGIN) == row) {

          // conditions that change colour of top cell
          if (row > 0 && intGrid[row-1][column] == 0) {

            intGrid[row-1][column] = 1;
            cellsSelected++;
          }
          
          else if (row > 0 && intGrid[row-1][column] == 1) {

            intGrid[row-1][column] = 0;
            cellsSelected--;
          }

          // conditions that change color of bottom cell
          if (row < ROW_COUNT - 1 && intGrid[row+1][column] == 0) {

            intGrid[row+1][column] = 1;
            cellsSelected++;
          }

          else if (row < ROW_COUNT - 1 && intGrid[row+1][column] == 1) {

            intGrid[row+1][column] = 0;
            cellsSelected--;
          
          }

          // conditions that change color of left cell
          if (column > 0 && intGrid[row][column-1] == 0) {

            intGrid[row][column-1] = 1;
            cellsSelected++;
          }

          else if (column > 0 && intGrid[row][column-1] == 1) {
          
            intGrid[row][column-1] = 0;
            cellsSelected--;
          }

          // conditions that change color of right cell
          if (column < COLUMN_COUNT - 1 && intGrid[row][column+1] == 0) {

            intGrid[row][column+1] = 1;
            cellsSelected++;
          }

          else if (column < COLUMN_COUNT - 1 && intGrid[row][column+1] == 1) {

            intGrid[row][column+1] = 0;
            cellsSelected--;
          }
          
          // conditions that change color of cell pressed
          if (intGrid[row][column] == 0) {

            intGrid[row][column] = 1;
            cellsSelected++;
          }

          else if (intGrid[row][column] == 1) {

            intGrid[row][column] = 0;
            cellsSelected--;
          }

          // print number of cells selected to the screen
          println( "Total of " + cellsSelected + " cells are selected.");
          
        }
      }
    }

    // prints out number of cells selected in each row
    for (int row = 0; row < ROW_COUNT; row++) {
      
      // counts green cells in row
      int rowCounter = 0;

      // counts the number of continuous cells in a row
      int intCurrentContinuous = 0;

      // largest count of continuous cells in a row
      int intMaximum = 0;

      // loops through each column in a row
      for (int column = 0; column < COLUMN_COUNT; column++) {
        
        // updates row and continuous counter
        if (intGrid[row][column] == 1) {
          rowCounter++;
          intCurrentContinuous++;

          // replace maxiumum with new highest current continuous
          if (intCurrentContinuous > intMaximum) {
            intMaximum = intCurrentContinuous;
          }
        }

        // reset continuous counter if green cell is not detected consecutively 
        else {
          intCurrentContinuous = 0;
        }
      }

      // prints out number of continuous blocks if there are more than 2 in a row
      if (intMaximum > 2) {
        System.out.println("There are " + intMaximum + " continuous blocks selected on row " + row + ".");
      }

      System.out.println("Row " + row + " has " + rowCounter + " cells selected.");
    }

    // prints out number of cells selected in each column
    for (int column = 0; column < ROW_COUNT; column++) {
      
      // counts number of green cells in a column
      int intColumnCounter = 0;
      for (int row = 0; row < COLUMN_COUNT; row++) {
        if (intGrid[row][column] == 1) {
          intColumnCounter++;
        }
      }
      System.out.println("Column " + column + " has " + intColumnCounter + " cells selected.");
    }
    
  }
}