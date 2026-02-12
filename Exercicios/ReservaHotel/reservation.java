
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;


public class reservation{
    private Integer roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public reservation(){}

    

    public Integer duration(){
        return (int) ChronoUnit.DAYS.between(checkIn, checkOut);
    }

    public void newReservation(){
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
        
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;

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
                updateDates(checkIn, checkOut);
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


    public void updateDates(LocalDate checkIn, LocalDate checkOut){
        if(checkOut.isAfter(checkIn) == true){
            this.checkIn = checkIn;
            this.checkOut = checkOut;
            System.out.println("A reserva foi atualizada!");
            System.out.println("Número do quarto: " + roomNumber);
            System.out.println("Entrada: " + checkIn);
            System.out.println("Saída: " + checkOut);
            System.out.print("Dias restantes: " + duration());
        }
        else{
            System.out.println("Erro na reserva: A data de saída deve ser posterior à data de entrada.");
        }
    }




    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }
    
}
