public class ProgressContainer {
  private double progress;
  private double total;
  ProgressContainer (double progress, double total){
    this.progress = progress;
    this.total = total;
  }
  double getProgress () {
    return progress;
  } 
  double getTotal () {
    return total;
  }
  void setProgress (double toSet) {
    progress = toSet;
  }
}