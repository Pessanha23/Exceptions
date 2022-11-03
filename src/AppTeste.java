package interfacedefaultmethod.application;

import interfacedefaultmethod.service.BrazilTaxService;
import interfacedefaultmethod.service.UsaTaxService;
import org.junit.Assert;
import org.junit.Test;
public class AppTeste {

    @Test
    public void teste_1(){
        BrazilTaxService brazilTaxService = new BrazilTaxService(2);

        double resultado = brazilTaxService.pagamento(200,3);
        double expectativa = 212.24160000000003;

        Assert.assertEquals(expectativa,resultado,0);
    }
    @Test
    public void teste_2(){
        UsaTaxService usaTaxService = new UsaTaxService(1);

        double resultado = usaTaxService.pagamento(200,3);
        double expectativa = 206.06020000000004;

        Assert.assertEquals(expectativa,resultado,0);
    }
}
