import java.io.*;
import LoadingIcons.LoadingIcons;
import LoadingIcons.ProgressContainer;

/**
 * @author FrederickAmpsUp This project is a remake of my previous loading icon
 *         class. This project will be a jar file that anyone can use. Please
 *         give credit if using.
 */

class Main {
  public static int countLines(String filename) throws IOException {
    try (FileReader input = new FileReader(filename); LineNumberReader count = new LineNumberReader(input);) {
      while (count.skip(Long.MAX_VALUE) > 0) {
        // Loop just in case the file is > Long.MAX_VALUE or skip() decides to not read
        // the entire file
      }

      return count.getLineNumber() + 1; // +1 because line index starts at 0
    }
  }

  public static void main(String[] args) throws Throwable {
    ProgressContainer cont = new ProgressContainer(0, 100);
    try (SpinnerIcon icon = new SpinnerIcon(cont)) {
      for (; cont.getProgress() < 100; cont.setProgress(cont.getProgress() + 0.1)) {
        Thread.sleep(10);
        icon.print("HELLO WORLD");
      }
      Thread.sleep(1000);
    }
    System.out.println(countLines("LoadingIcons.java"));
  }
}