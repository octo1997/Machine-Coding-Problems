import com.local.services.LiftManager;

public class Main {
    public static void main(String[] args) {
        LiftManager.getInstance().startService(2, 10);
    }
}