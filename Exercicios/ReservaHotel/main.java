import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class main {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Número do quarto: ");
        Integer roomNumber = sc.nextInt();
        System.out.print("Data de entrada (dd/MM/yyyy): ");
        String checkInStr = sc.next();
        System.out.print("Data de saída (dd/MM/yyyy): ");
        String checkOutStr = sc.next();
        LocalDate checkIn = LocalDate.parse(checkInStr, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate checkOut = LocalDate.parse(checkOutStr, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        while(checkOut.isAfter(checkIn) == false){
            System.out.println("Erro na reserva: A data de saída deve ser posterior à data de entrada.");
            System.out.print("Data de entrada (dd/MM/yyyy): ");
            checkInStr = sc.next();
            System.out.print("Data de saída (dd/MM/yyyy): ");
            checkOutStr = sc.next();
            checkIn = LocalDate.parse(checkInStr, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            checkOut = LocalDate.parse(checkOutStr, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
        reservation reservation = new reservation(roomNumber, checkIn, checkOut);
        System.out.println("Número do quarto: " + reservation.getRoomNumber());
        System.out.println("Entrada: " + reservation.getCheckIn());
        System.out.println("Saída: " + reservation.getCheckOut());
        System.out.println("Dias restantes: " + reservation.duration());
        System.out.println();
        while(true){
            System.out.println("Deseja atualizar as datas da reserva? (s/n)");
            String resposta = sc.next();
            if(resposta.equalsIgnoreCase("s")){
                System.out.print("Data de entrada (dd/MM/yyyy): ");
                checkInStr = sc.next();
                System.out.print("Data de saída (dd/MM/yyyy): ");
                checkOutStr = sc.next();
                checkIn = LocalDate.parse(checkInStr, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                checkOut = LocalDate.parse(checkOutStr, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                reservation.updateDates(checkIn, checkOut);
                System.out.println();
            }
            else if(resposta.equalsIgnoreCase("n")){
                break;
            }
            else{
                System.out.println("Resposta inválida. Digite 's' para sim ou 'n' para não.");
            }
        }
        sc.close();
    }
}
