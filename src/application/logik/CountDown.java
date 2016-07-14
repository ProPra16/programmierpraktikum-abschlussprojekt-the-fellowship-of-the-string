//http://www.java-forum.org/thema/countdown-timer-fuer-spiel.96377/
import java.util.Timer;
import java.util.TimerTask;


public class CountDown {
private int count = 10;

public CountDown() {
Timer timer = new Timer();
TimerTask task = new TimerTask() {
@Override
public void run() {
System.out.println(count);
if (count > 0)
count--;

if (count == 0)
System.exit(0);
}
};
timer.schedule(task, 0, 1000);
}

public static void main(String[] args) {
new CountDown();
}
}
