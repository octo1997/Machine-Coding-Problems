import com.services.BookMyShow;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        boolean isActive = true;
        while(isActive){
            String newLine = scanner.nextLine();
            String[] cmds = newLine.split(" ");
            switch (cmds[0]){
                case "CREATETHEATRE" -> {
                    BookMyShow.getInstance().createTheatre(cmds[1], cmds[2]);

                }
                case "HOSTSHOW" -> {
                    BookMyShow.getInstance().hostShow(cmds[1], new SimpleDateFormat("dd/mm/yyyy").parse(cmds[2]),
                            new SimpleDateFormat("dd/mm/yyyy").parse(cmds[3]), cmds[4], cmds[5]);
                }
                case "VIEWSHOWSATLOC" -> {
                    BookMyShow.getInstance().viewShowsAtMyLocation(cmds[1]);
                }
                case "VIEWTHEATREBYLOCANDSHOW" -> {
                    BookMyShow.getInstance().viewTheatresByShowsAtMyLocation(cmds[1], cmds[2]);
                }
                case "BOOKASEAT" -> {
                    BookMyShow.getInstance().bookAShow(cmds[1], cmds[2], cmds[3], cmds[4], cmds[5], cmds[6]);
                }
            }
        }

        scanner.close();

    }

}