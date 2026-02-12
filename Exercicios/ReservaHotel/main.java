import java.util.Scanner;


public class main {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        reservation reserva = new reservation();
        reserva.newReservation();
        sc.close();
    }
}
