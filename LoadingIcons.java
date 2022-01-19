public class LoadingIcons {
  String type = "";
  ProgressContainer cont;

  class UpdaterThread extends Thread {
    public void run () {
      if (type == "bar") {
        do {
          System.out.print("|");
          for(int i = 1; i <= 20; i++){
            if(cont.getTotal() / (cont.getProgress() + 0.001) * 100 <= 20 / i * 100) {
              System.out.print("█");
            }else{
              System.out.print(" ");
            }
          }
          try {
            Thread.sleep(1);
          } catch (Exception ex) {
            Thread.currentThread().interrupt();
          }
          System.out.print("| " + (int) (cont.getProgress() / cont.getTotal() * 100) + "%\r");
        } while (cont.getProgress() <= cont.getTotal());
      }
    }
  }
}
class ProgressBar extends LoadingIcons {
    /**
    * @param cont A ProgressBar object to pass the progress and total.
    *
    * This is the constructor to create a progress bar. It uses a thread to update itself, so you can continue with what you want to monitor progress on. You use the {@link ProgressContainer.setProgress(double toSet)} method to set the progress.
    */
    ProgressBar(ProgressContainer cont){
      type = "bar";
      this.cont = cont;
      UpdaterThread thrd = new UpdaterThread();
      thrd.start();
    }
  }