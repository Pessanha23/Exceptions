package interfacedefaultmethod.application.exercicioexception2.application;

import interfacedefaultmethod.application.exercicioexception2.entities.Account;
import interfacedefaultmethod.application.exercicioexception2.entities.BusinessException;
import org.junit.Assert;
import org.junit.Test;

public class AppTeste {

    @Test
    public void teste_1() {
        String resultado = "";
        String resultado1 = "";
        Account account = new Account(8021, "Bob Brown", 500.0, 300.0);

        resultado = account.toString()
                + '\n'
                + "Enter amount for withdraw: ";
        try {
            account.withdraw(100.0);
            resultado1 = "New balance: " + String.valueOf(account.getBalance());
        } catch (BusinessException e) {
            resultado1 = e.getMessage();
        }


        String expectativa = """
                Number: 8021
                Holder: Bob Brown
                Initial Balance: 500.0
                WithdrawLimit: 300.0
                
                Enter amount for withdraw:\s
                New balance: 400.0""";

        Assert.assertEquals(expectativa, resultado + '\n' + resultado1);
    }
    @Test
    public void teste_2() {
        String resultado = "";
        String resultado1 = "";
        Account account =new Account(8021, "Bob Brown", 500.0, 300.0);

        resultado = account.toString()
                + '\n'
                + "Enter amount for withdraw: ";
        try {
            account.withdraw(400.00);
            resultado1 = String.valueOf(account.getBalance());
        } catch (BusinessException e) {
            resultado1 = e.getMessage();
        }
        String expectativa = """
            Number: 8021
            Holder: Bob Brown
            Initial Balance: 500.0
            WithdrawLimit: 300.0
                            
            Enter amount for withdraw:\s
            Erro de saque: A quantia excede o limite de saque""";

        Assert.assertEquals(expectativa, resultado + '\n' + resultado1 );
    }
    @Test
    public void teste_3(){
        String resultado = "";
        String resultado1 = "";
        Account account = new Account(8021, "Bob Brown", 200.0, 300.0);

        resultado = account.toString()
                + '\n'
                + "Enter amount for withdraw: ";
        try {
            account.withdraw(250.0);
            resultado1 = String.valueOf(account.getBalance());
        } catch (BusinessException e) {
            resultado1 = e.getMessage();
        }
        String expectativa = """
             Number: 8021
             Holder: Bob Brown
             Initial Balance: 200.0
             WithdrawLimit: 300.0
             
             Enter amount for withdraw:\s
             Erro de saque: Saldo insuficiente""";

        Assert.assertEquals(expectativa, resultado + '\n' + resultado1 );
    }
}
