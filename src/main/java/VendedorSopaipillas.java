import java.security.PublicKey;
import java.util.Scanner;

public class VendedorSopaipillas {

    private double dineroRecibido;

    private double dineroCajachica;

    private double ventaDeldia=0;

    private String[] tipoDesalsas = {"Ketchup", "Mayonesa", "Mostaza"};

    private int cantidadDesopaipillasVendidas=0;

    private int precioSopaipilla=150;

    public VendedorSopaipillas(int precioSopaipilla,int dineroCajachica) {
        this.precioSopaipilla = precioSopaipilla;
        this.dineroCajachica = dineroCajachica;

    }

    public double getDineroRecibido() {
        return dineroRecibido;
    }

    public void setDineroRecibido(double dineroRecibido) {
        this.dineroRecibido = dineroRecibido;
    }

    public double getDineroCajachica() {
        return dineroCajachica;
    }

    public void setDineroCajachica(double dineroCajachica) {
        this.dineroCajachica = dineroCajachica;
    }

    public double getVentaDeldia() {
        return ventaDeldia;
    }

    public void setVentaDeldia(double ventaDeldia) {
        this.ventaDeldia = ventaDeldia;
    }

    public int getCantidadDesopaipillasVendidas() {
        return cantidadDesopaipillasVendidas;
    }

    public void setCantidadDesopaipillasVendidas(int cantidadDesopaipillasVendidas) {
        this.cantidadDesopaipillasVendidas = cantidadDesopaipillasVendidas;
    }

    public int getPrecioSopaipilla() {
        return precioSopaipilla;
    }

    public void setPrecioSopaipilla(int precioSopaipilla) {
        this.precioSopaipilla = precioSopaipilla;
    }

    public void menu() {
        int decisionSalir=0;
        while (decisionSalir != 1) {
            Scanner entrada = new Scanner(System.in);

            System.out.println("Hola! Bienvenido al carro de sopaipillas");

            System.out.print("Por favor indicanos cuantas sopaipillas quieres comprar: ");
            while (!entrada.hasNextInt()) {
                System.err.println("Debe ser un numero");
                System.out.print("Intentalo de nuevo: ");
                entrada.next();
            }
            int sopaipillas = entrada.nextInt();
            System.out.println(sopaipillas);
            System.out.println("Estas comprando " + sopaipillas + " sopaipillas");
            System.out.print("Ahora indicanos con que salsa quieres tus sopaipillas (0: Ketchup, 1: Mayonesa, 2: Mostaza): ");
            while (!entrada.hasNextInt()) {
                System.err.println("Debe ser un numero");
                System.out.print("Intentalo de nuevo: ");
                entrada.next();
            }
            int eleccionSalsa = entrada.nextInt();
            System.out.println("Tus sopaipillas tendran " + tipoDesalsas[eleccionSalsa]);

            double valorPedido = sopaipillas * precioSopaipilla;

            System.out.println("El total por las " + sopaipillas + " Es: " + valorPedido);

            System.out.print("Con cuanto dinero deseas pagar tu pedido (ingresa el monto aqui): ");
            while (!entrada.hasNextInt()) {
                System.err.println("Debe ser un numero");
                System.out.print("Intentalo de nuevo: ");
                entrada.next();
            }
            double dineroRecibido = entrada.nextInt();

            if(valorPedido>dineroRecibido){
                System.err.println("Se necesita más dinero, vuelve mas tarde.");
                salir();
            }
            entregarVuelto(dineroRecibido,valorPedido);
            System.out.print("Si deseas salir del carrito ingresa 1 sino cualquier numero ");
            while (!entrada.hasNextInt()) {
                System.err.println("Debe ser un numero");
                System.out.print("Intentalo de nuevo: ");
                entrada.next();
            }

            venderSopaipillas(sopaipillas);
            aumentarVentas(valorPedido);
            decisionSalir = entrada.nextInt();
            System.out.println(decisionSalir);
            if (decisionSalir == 1) {
                System.out.println("Gracias por comprar en el carrito de sopaipillas");
                salir();
            }
        }
    }

   public double venderSopaipillas(int sopaipillas){
        cantidadDesopaipillasVendidas+=sopaipillas;

        return sopaipillas;
    }
    public double aumentarVentas(double valorPedido){

        ventaDeldia+=valorPedido;
        return ventaDeldia;
    }
    public double entregarVuelto(double dineroRecibido, double valorPedido) {
        if (dineroRecibido > valorPedido) {
            double vuelto = dineroRecibido - valorPedido;
            if (vuelto > dineroCajachica) {
                System.err.println("No es posible darte vuelto, no tengo suficiente dinero, por favor vuelve más tarde.");
                salir();
            }
            dineroCajachica-=vuelto;
            System.out.println("Tu vuelto es: " + vuelto);
            return vuelto;
        }
        return 0;
    }

    private void salir(){
        System.exit(1);
    }
}
