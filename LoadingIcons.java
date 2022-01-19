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
          int i;
          for(i = 1; i <= 20; i++){
            if((cont.getProgress()) / (cont.getTotal()) < i / 20) {
              System.out.print("█");
            }else{
              System.out.print(" ");
            }
          }
          try {
            Thread.sleep(10);
          } catch (Exception ex) {
            Thread.currentThread().interrupt();
          }
          System.out.print("| " + cont.getProgress() + cont.getTotal() + "\r");
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