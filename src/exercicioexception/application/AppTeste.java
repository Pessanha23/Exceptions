package interfacedefaultmethod.application.exercicioexception.application;

import interfacedefaultmethod.application.exercicioexception.entities.DomainException;
import interfacedefaultmethod.application.exercicioexception.entities.Reservation;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AppTeste {

    @Test
    public void teste_1() throws ParseException, DomainException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String resultado = "";
        String resultado1 = "";
        Reservation reservation = new Reservation(8021, sdf.parse("23/09/2019"), sdf.parse("26/09/2019"));

        /* Metodo ruim para realizar
         */

        if (!reservation.getCheckOut().after(reservation.getCheckIn())) {
            resultado = "Error in reservation: Check-out date must be after check-in date";
        } else {
            resultado = reservation.toString()
                    + '\n'
                    + "Enter data to update the reservation:";

            reservation.updateDate(sdf.parse("24/09/2020"), sdf.parse("22/09/2020"));
            Date now = new Date();

            if (reservation.getCheckIn().before(now) || reservation.getCheckOut().before(now)) {
                resultado1 = "Error in reservation: Reservation dates for update must be future dates";

            } else if (!reservation.getCheckOut().after(reservation.getCheckIn())) {
                resultado1 = "Error in reservation: Check-out date must be after check-in date";

            } else {
                resultado1 = reservation.toString();
            }
        }

        String expectativa = """
                Reservation: 8021, check-in: 23/09/2019, check-out: 26/09/2019, 3 nights.
                Enter data to update the reservation:
                Error in reservation: Reservation dates for update must be future dates""";

        Assert.assertEquals(expectativa, resultado + '\n' + resultado1);

    }

    @Test
    public void teste_2() {
        String resultado = "";
        String resultado1 = "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Reservation reservation = null;

        try {
            reservation = new Reservation(8021, sdf.parse("23/09/2019"), sdf.parse("26/09/2019"));

            resultado = reservation.toString()
                        + '\n'
                        + "Enter data to update the reservation:";

            reservation.updateDate(sdf.parse("24/09/2020"), sdf.parse("22/09/2020"));
            resultado1 = reservation.toString();

        } catch (ParseException e) {
            resultado1 = "Invalid date format";
        } catch (DomainException e) {
            resultado1 = "Error in reservation: " + e.getMessage();
        } catch (RuntimeException e) {
            resultado1 = "Unexpected error";
        }

        String expectativa = """
                Reservation: 8021, check-in: 23/09/2019, check-out: 26/09/2019, 3 nights.
                Enter data to update the reservation:
                Error in reservation: Reservation dates for update must be future dates""";

        Assert.assertEquals(expectativa, resultado + '\n' + resultado1);

    }


}
