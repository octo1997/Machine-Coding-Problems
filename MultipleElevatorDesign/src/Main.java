import com.entities.Building;
import com.entities.Direction;
import com.entities.ElevatorEvent;
import com.entities.Floor;
import com.services.DispatcherService;

import java.util.Scanner;

import static com.entities.Direction.DOWN;
import static com.entities.Direction.UP;
import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {
        DispatcherService dispatcherService = DispatcherService.getInstance();
        dispatcherService.setBuilding(new Building(1, 6));
        Thread th1 = new Thread(() -> {
            int car = getFloor(dispatcherService.getBuilding(), 3).callCar(UP);
            dispatcherService.getBuilding().getCars().get(car).goToFloor(5);
            System.out.println("Passenger p1 delivered by car " + car);
        });th1.start();

        Thread th2 = new Thread(() -> {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            int car = getFloor(dispatcherService.getBuilding(), 2).callCar(DOWN);
            dispatcherService.getBuilding().getCars().get(car).goToFloor(0);
            System.out.println("Passenger p2 delivered by car " + car);
        });th2.start();
        Thread th3 = new Thread(() -> {
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            int car = getFloor(dispatcherService.getBuilding(), 4).callCar(DOWN);
            dispatcherService.getBuilding().getCars().get(car).goToFloor(0);
            System.out.println("Passenger p3 delivered by car " + car);
        });th3.start();
        Thread th4 = new Thread(() -> {
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            int car = getFloor(dispatcherService.getBuilding(), 0).callCar(UP);
            dispatcherService.getBuilding().getCars().get(car).goToFloor(5);
            System.out.println("Passenger p4 delivered by car " + car);
        });th4.start();



    }

    private static Floor getFloor(Building building, int ind){
        return building.getFloors().get(ind);
    }
}