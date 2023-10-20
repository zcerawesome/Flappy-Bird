import java.io.IOException;
import java.util.EmptyStackException;

public class Player{

  private int x, y;
  
  static char pointer = 'O';

  static char[][] Bird = new char[25][75];


  public void MainIdea(int X, int Y, int gravus, int barrierLocation, int space){
    this.x = X + gravus;
    this.y = Y;
    for(int i = 0; i < 25; i++){
      for(int j = 0; j < 75; j++){
        Bird[i][j] = ' ';
      }
    }
    Bird[x][y] = pointer;
    blockade(space, barrierLocation);
    if(checkWin()){
        throw new EmptyStackException();
    }
    print();
  }


  public void print(){
    for(int i = 0; i < 25; i++){
      for(int j = 0; j < 75; j++){
        if(j >= 25){
          System.out.print(Bird[i][j]);
        } else{
          System.out.print(" ");
        }
        
      }
      System.out.println();
    }
  }

  public boolean checkWin(){
        if(Bird[x][y] == '|'){
            return true;
        }
        return false;
  }

  public void blockade(int middle, int collumn){
    for(int i = 0; i < 25; i++){
        if(i > (middle-2) && i < (middle+2)){
            Bird[i][collumn-1] = ' ';
        }  else{
            Bird[i][collumn-1] = '|';
        }
    }
  }

  public int[] getLocation(){
    int[] toReturn = {x, y};
    return toReturn;
  }
  
}