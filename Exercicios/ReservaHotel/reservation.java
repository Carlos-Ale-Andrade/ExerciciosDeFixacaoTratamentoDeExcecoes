
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class reservation{
    private Integer roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public reservation(){}
    public reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut){
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }



    public Integer duration(){
        return (int) ChronoUnit.DAYS.between(checkIn, checkOut);
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