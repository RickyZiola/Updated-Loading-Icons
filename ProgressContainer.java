public class ProgressContainer {
  double progress;
  double total;
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
}