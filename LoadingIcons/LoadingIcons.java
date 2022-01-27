package LoadingIcons;

import LoadingIcons.*;

public class LoadingIcons implements AutoCloseable {
  String type = "";
  ProgressContainer cont;
  private String toPrint;
  private PrintThread prtthrd;
  LoadingIcons() {
    prtthrd = new PrintThread();
    prtthrd.start();
  }
  public void print (String toPrint) {
    this.toPrint = toPrint; 
    prtthrd.notify();
    
  }
  class PrintThread extends Thread {
    public void run() {
      while (true) {
        try {
          wait();
        } catch (Exception ex) {}
        System.out.print(toPrint);
      }
    }
  }
  class UpdaterThread extends Thread {
    private int findIndex(char arr[], int t)
    {
 
        // if array is Null
        if (arr == null) {
            return -1;
        }
 
        // find length of array
        int len = arr.length;
        int i = 0;
 
        // traverse in the array
        while (i < len) {
 
            // if the i-th element is t
            // then return the index
            if (arr[i] == t) {
                return (char) i;
            }
            else {
                i = i + 1;
            }
        }
        return -1;
    }
    public void run () {
      if (type == "bar") {
        do {
          System.out.print("|");
          double progress = (20 / cont.getTotal()) * cont.getProgress();
          for(int i = 0; i <= 20; i++){
            if(i <= progress + 1) {
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
      }else if(type == "spin") {
        char[] chars = {'|', '/', '-', '\\'};
        do {
          for (int i : chars) {
            System.out.print("\r" + Character.toString(chars[findIndex(chars, i)]) + " " + (int) ((cont.getProgress() / cont.getTotal()) * 100) + "%");
            try {
              Thread.sleep(200);
            }catch (Exception ex) {}
          }
        } while (cont.getProgress() <= cont.getTotal());
      }
    }
  }
  public void close () {
    System.out.print("\r                            \r");
  }
}
class ProgressBar extends LoadingIcons {
    /**
    * @param cont A ProgressBar object to pass the progress and total.
    *
    * This is the constructor to create a progress bar. It uses a thread to update itself, so you can continue with what you want to monitor progress on. You use the {@link ProgressContainer.setProgress(double toSet)} method to set the progress.
    */
    public ProgressBar(ProgressContainer cont){
      super();
      type = "bar";
      this.cont = cont;
      UpdaterThread thrd = new UpdaterThread();
      thrd.start();
    }
  }
  class SpinnerIcon extends LoadingIcons {
    /**
    * @param cont A ProgressBar object to pass the progress and total.
    *
    * This is the constructor to create a spinner icon. It uses a thread to update itself, so you can continue with what you want to monitor progress on. You use the {@link ProgressContainer.setProgress(double toSet)} 
    */
    public SpinnerIcon(ProgressContainer cont) {
      super();
      type = "spin";
      this.cont = cont;
      UpdaterThread thrd = new UpdaterThread();
      thrd.start();
    }
  }