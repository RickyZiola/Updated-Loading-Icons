package LoadingIcons;

public class ProgressContainer {
  private double progress;
  private double total;
  public ProgressContainer (double progress, double total){
    this.progress = progress;
    this.total = total;
  }
  public double getProgress () {
    return progress;
  } 
  public double getTotal () {
    return total;
  }
  public void setProgress (double toSet) {
    progress = toSet;
  }
}