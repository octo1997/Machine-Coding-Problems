import com.local.entities.VehicleType;
import com.local.services.ParkingService;

import java.util.Scanner;

import static com.local.services.AMBParkingManager.*;

public class Main {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ParkingService parkingService = new ParkingService();

        Scanner scanner = new Scanner(System.in);
        boolean stop = true;
        while(stop) {
            String cmd = scanner.next();

            switch (cmd) {
                case create_parking_lot -> {
                    parkingService.createParkingLot(scanner.next(), scanner.nextInt(), scanner.nextInt());
                    break;
                }
                case display ->{
                    switch (scanner.next()) {
                        case free_count-> {
                            parkingService.printFreeSlotsCount(VehicleType.valueOf(scanner.next()));
                            break;
                        }
                        case free_slots-> {
                            parkingService.printFreeSlotsCount(VehicleType.valueOf(scanner.next()));
                            break;
                        }
                        case occupied_slots-> {
                            parkingService.printOccupiedSlots(VehicleType.valueOf(scanner.next()));
                            break;
                        }
                        default ->{break;}
                    }
                }
                case park_vehicle -> {
                    parkingService.parkVehicle(VehicleType.valueOf(scanner.next()), scanner.next(), scanner.next());
                    break;
                }
                case unpark_vehicle -> {
                    parkingService.unparkVehicle(scanner.next());
                    break;
                }
                case exit -> {
                    stop = false;
                    break;
                }
                default->{break;}
            }
        }
        scanner.close();
    }

}