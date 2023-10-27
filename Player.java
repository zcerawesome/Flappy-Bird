import java.util.EmptyStackException;

import java.util.Scanner;
import java.io.File;

public class Player{

  private int x, y;
  
  static char pointer = 'O';

  static Scanner scanner;

  static char[][] Bird = new char[25][75];


  public void MainIdea(int X, int Y, int gravus, int barrierLocation, int space){
    this.x = X + gravus;
    this.y = Y;
    for(int i = 0; i < 25; i++){
      for(int j = 0; j < 75; j++){
        Bird[i][j] = ' ';
      }
    }
    int gravity = 0;
    File obj = new File("Gravatus.txt");
    try{
      scanner = new Scanner(obj);
      gravity = Integer.parseInt(scanner.nextLine());
    } catch(Exception e){}
    
    if(gravity < 0){
      pointer = '*';
    } else{pointer = 'O';}
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
        if(j >= 22){
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
