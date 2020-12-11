import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestVendedorSopaipillas {
    private VendedorSopaipillas miVendedor;
    private double valorPedido;
    private double dineroRecibido;
    private int sopaipillas;
    @BeforeEach
    void setUp() {
    this.miVendedor = new VendedorSopaipillas(150,20000);
    this.valorPedido=450;
    this.sopaipillas=3;
    this.dineroRecibido=1500;
    }

    @Test
    void venderSopaipillas() {
        int expected =2;

        assertEquals(expected, this.miVendedor.venderSopaipillas(sopaipillas));
    }

    @Test
    void testaumentarVentas() {
        int expected =450;

        assertEquals(expected, this.miVendedor.aumentarVentas(valorPedido));
    }

    @Test
    void entregarVuelto() {
        int expected =1050;

        assertEquals(expected, this.miVendedor.entregarVuelto(dineroRecibido,valorPedido));
    }
}