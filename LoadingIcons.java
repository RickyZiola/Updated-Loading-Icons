public class LoadingIcons {
  double progress;
  double total;
  String type = "";
  ProgressContainer cont;

  class UpdaterThread extends Thread {
    public void run () {
      if (type == "bar") {
        do {
          System.out.print("|");
          for(int i = 1; i <= 20; i++){
            if((cont.getProgress() + 0.1) / cont.getTotal() >= i / 20) {
              System.out.print("█");
            }else{
              System.out.print(" ");
            }
            System.out.print("|\r");
          }
        } while (cont.getProgress() <= cont.getTotal());
      }
    }
  }
}
class ProgressBar extends LoadingIcons {
    /**
    @param cont A ProgressBar object to pass the progress and total
    */
    ProgressBar(ProgressContainer cont){
      progress = cont.getProgress();
      total = cont.getTotal();
      type = "bar";
      this.cont = cont;
      UpdaterThread thrd = new UpdaterThread();
      thrd.start();
    }
  }