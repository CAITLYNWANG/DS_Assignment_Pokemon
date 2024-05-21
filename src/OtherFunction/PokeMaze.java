package OtherFunction;
import util.StructureService;
import java.util.Stack;
public class PokeMaze {
    private static final char WALL = '#';
    private static final char GHASTLY = 'G';
    private static final char END = 'E';
    private static final char PLAYER = 'Y';

    //Initialize the start position
    private static int curRow = 1;
    private static int curCol = 1;
    private static Stack<int[]> pathStack = new Stack<>();
    private static final char[][] MAZE = {
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', 'S', '.', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '#', '#', '#', '#', '.', '#', '.', '#', '#', '#', '#', '#', '#', '#', '.', '#'},
            {'#', '.', '.', '.', '#', '.', '#', '.', '#', '.', '.', '.', '.', '.', '#', '.', '#'},
            {'#', '#', '#', '.', '#', '.', '#', '#', '#', 'G', '#', '.', '#', '.', '#', '#', '#'},
            {'#', '.', '.', '.', '#', '.', '.', '.', '#', '.', '.', '.', '#', '.', '.', '.', '#'},
            {'#', '#', '#', '#', '#', 'G', '#', '.', '#', '.', '#', '.', '#', '#', '#', '.', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', 'E', '#'}
    };
    private static void displayMaze(){
        for(int i = 0; i < MAZE.length; i++){
            for(int j = 0; j < MAZE[i].length; j++){
                if(i == curRow && j == curCol){
                    //Display player's current position
                    System.out.print(PLAYER + " ");
                }else{
                    System.out.print(MAZE[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    private static boolean movePlayer(String direction){
        int newRow = curRow;
        int newCol = curCol;

        switch(direction){
            case "up":
                //Keep moving if the player doesn't encounter a '#' or a 'G' or reach the end 'E'
                while(newRow > 0 && MAZE[newRow - 1][newCol] != WALL && MAZE[newRow - 1][newCol] != GHASTLY && MAZE[newRow - 1][newCol] != END){
                    newRow--;
                }
                break;
            case "down":
                while(newRow < MAZE.length - 1 && MAZE[newRow + 1][newCol] != WALL && MAZE[newRow + 1][newCol] != GHASTLY && MAZE[newRow + 1][newCol] != END){
                    newRow++;
                }
                break;
            case "left":
                while(newCol > 0 && MAZE[newRow][newCol - 1] != WALL && MAZE[newRow][newCol - 1] != GHASTLY && MAZE[newRow][newCol - 1] != END){
                    newCol--;
                }
                break;
            case "right":
                while(newCol < MAZE[0].length - 1 && MAZE[newRow][newCol + 1] != WALL && MAZE[newRow][newCol + 1] != GHASTLY && MAZE[newRow][newCol + 1] != END){
                    newCol++;
                }
                break;
        }

        if(MAZE[newRow][newCol] == WALL || (newRow == curRow && newCol == curCol)){
            //Player failed to move
            return false;
        }

        //Update the location
        curRow = newRow;
        curCol = newCol;
        //Record the path
        pathStack.push(new int[]{curRow, curCol});
        return true;
    }
    public static void mazeChallenge(){
        pathStack.push(new int[]{curRow, curCol});
        StructureService.lineSeperator();
        System.out.println("Welcome to the PokeMaze Challenge!");
        System.out.println("Find your way through the maze using stacks.");
        System.out.println("Legend: # - Wall, . - Path, S - Start, E - End, G - Ghastly");
        StructureService.lineSeperator();

        boolean isReached = false;
        while(!isReached){
            displayMaze();
            String direction = StructureService.readChoice("Enter direction (up, down, left, right): ", new String[]{"up", "down", "left", "right"}).trim().toLowerCase();
            if(movePlayer(direction)){
                if(MAZE[curRow][curCol] == END){
                    isReached = true;
                    System.out.println("Congratulations! You've reached the end of the maze.");
                }else if(MAZE[curRow][curCol] == GHASTLY){
                    displayMaze();
                    System.out.println("Oh no! You encountered a Ghastly and got caught.");
                    System.out.println("Game Over.");
                    break;
                }
            }else{
                System.out.println("Invalid move. Try again.");
            }
        }
    }
}
