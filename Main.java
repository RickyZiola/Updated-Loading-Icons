/**
* @author FrederickAmpsUp
* This project is a remake of my previous loading icon class.
* This project will be a jar file that anyone can use.
* Please give credit if using.
*/

class Main {
  public static void main(String[] args) {
    ProgressContainer cont = new ProgressContainer(0, 100);
    ProgressBar icon = new ProgressBar(cont);
    for ( ; cont.getProgress() < cont.getTotal(); cont.setProgress(cont.getProgress() + 1)) {
      try {
        Thread.sleep(100);
      }catch(Exception ex){
        Thread.currentThread().interrupt();
      }
    }
  }
}