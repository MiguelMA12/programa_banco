
import javax.swing.JOptionPane;
import java.util.Scanner;

public class BANCO {

    private String nombreBanco = "BBVA";
    private String Direccion = "Av independecia 52";
    private String numero = "7121718384";

    private String cliente;
    private String numerodecuenta;
    private double saldo;

    public void inciar() {
        boolean salir = false;
        Scanner scanner = new Scanner(System.in);

        while (!salir) {
            int opcion = menu();

            switch (opcion) {
                case 1:
                    abrir_cuenta();
                    break;
                case 2:
                    mostrar_cuenta();
                    break;
                case 3:
                    realizar_transacion();
                    break;
                case 4:
                    datos_banco();
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "opcion invalida intente de nuevo");
                    break;
            }
        }
        scanner.close();
    }

    public int menu() {
        String menu = "=====" + nombreBanco + "====\n"
                + "1.- abrir cuenta\n"
                + "2.- mostrar cuenta\n"
                + "3.- realizar transaccion\n"
                + "4.- mostrar datos del banco\n"
                + "5.- salir\n";
        String opcionStr = JOptionPane.showInputDialog(menu);
        int opcion = Integer.parseInt(opcionStr);

        return opcion;
    }

    public void abrir_cuenta() {
        cliente = JOptionPane.showInputDialog("ingrese su nombre");
        numerodecuenta = JOptionPane.showInputDialog("ingrese el numero de cuenta");
        String saldoStr = JOptionPane.showInputDialog("ingrese el saldo");
        saldo = Double.parseDouble(saldoStr);

    }

    public void mostrar_cuenta() {
        String mostrarcuenta = "------Datos de la cuenta------\n"
                + "nombre del cliente: " + cliente + "\n"
                + "numero de cuenta: " + numerodecuenta + "\n"
                + "saldo de " + cliente + " : $" + String.format("%.2f", saldo);

        JOptionPane.showMessageDialog(null, mostrarcuenta);

    }

    public void realizar_transacion() {
        int opcion = menu_transacion();

        switch (opcion) {
            case 1:
                retirar();
                break;
            case 2:
                depositar();
                break;
            default:
                JOptionPane.showMessageDialog(null, "opcion invalida intente de nuevo");
                break;
        }

    }

    public int menu_transacion() {
        String menut = "------Transaccion------\n"
                + "1.- retirar\n"
                + "2.- depositar";

        String opcionStr = JOptionPane.showInputDialog(menut);

        int opcion = Integer.parseInt(opcionStr);

        return opcion;

    }

    public void retirar() {
        String montoStr = JOptionPane.showInputDialog("ingrese el monto a retirar: ");
        double monto = Double.parseDouble(montoStr);

        if (monto <= saldo) {
            saldo -= monto;
            JOptionPane.showMessageDialog(null, "retiro realizado con exito");
            imprimir_comprobante("retiro", monto);
        } else {
            JOptionPane.showMessageDialog(null, "insuficiencia de saldo");

        }

    }

    public void depositar() {
        String montoStr = JOptionPane.showInputDialog("ingrese el monto a depositar: ");
        double monto = Double.parseDouble(montoStr);

        saldo += monto;
        JOptionPane.showMessageDialog(null, "deposito realizado con exito");
        imprimir_comprobante("deposito", monto);
    }

    public void datos_banco() {
        String datos = "-----" + nombreBanco + "------\n"
                + "direccion: " + Direccion + "\n"
                + "numero: " + numero;

        JOptionPane.showMessageDialog(null, datos);

    }

    public boolean validacion(String numero) {
        return numero.matches("\\d{10}");
    }

    public void imprimir_comprobante(String tipoTransaccion, double monto) {
        String comprobante = "===== Comprobante de Transacción =====\n"
                + "Tipo de transacción: " + tipoTransaccion + "\n"
                + "Cliente: " + cliente + "\n"
                + "Número de cuenta: " + numerodecuenta + "\n"
                + "Monto: $" + String.format("%.2f", monto) + "\n"
                + "Saldo actual: $" + String.format("%.2f", saldo);

        System.out.println(comprobante);

    }

    public static void main(String[] args) {
        BANCO banco = new BANCO();
        banco.inciar();
    }
}
