public class LoadingIcons {
  double progress;
  double total;
  String type = "";

  class UpdaterThread extends Thread {
    public void run () {
      if (type == "bar") {
        System.out.print("Initializing bar icon. Progress, total: ");
        System.out.print(progress);
        System.out.print(", ");
        System.out.print(total);
        for(int i = 0; i < 1000; i++)
          System.out.print("\b");

        System.out.println();
      }
    }
  }
}
class ProgressBar extends LoadingIcons {
    ProgressBar(ProgressContainer cont){
      progress = cont.getProgress();
      total = cont.getTotal();
      type = "bar";
      UpdaterThread thrd = new UpdaterThread();
      thrd.start();
    }
  }