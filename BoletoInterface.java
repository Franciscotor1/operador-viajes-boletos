import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoletoInterface extends JFrame {
    private JTextField numeroBoletoField;
    private JTextField nombreClienteField;
    private JTextField destinoField;
    private JComboBox<String> tipoViajeComboBox;
    private JTextField precioField;
    private JTextField fechaField;
    private JCheckBox adultoMayorCheckBox;
    private JButton calcularButton;
    private JTable tablaResultados;
    private JScrollPane scrollPane;

    public BoletoInterface() {
        setTitle("Venta de Boletos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(255, 255, 255)); // Color de fondo blanco

        JLabel numeroBoletoLabel = new JLabel("Número de Boleto:");
        JLabel nombreClienteLabel = new JLabel("Nombre del Cliente:");
        JLabel destinoLabel = new JLabel("Destino:");
        JLabel tipoViajeLabel = new JLabel("Tipo de Viaje:");
        JLabel precioLabel = new JLabel("Precio:");
        JLabel fechaLabel = new JLabel("Fecha:");

        numeroBoletoField = new JTextField(10);
        nombreClienteField = new JTextField(10);
        destinoField = new JTextField(10);

        String[] tiposViaje = {"Sencillo", "Doble"};
        tipoViajeComboBox = new JComboBox<>(tiposViaje);

        precioField = new JTextField(10);
        fechaField = new JTextField(10);

        adultoMayorCheckBox = new JCheckBox("Cliente Adulto Mayor");
        calcularButton = new JButton("Calcular");
        tablaResultados = new JTable();
        scrollPane = new JScrollPane(tablaResultados);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2));
        panel.setBackground(new Color(255, 255, 255)); // Color de fondo blanco
        panel.add(numeroBoletoLabel);
        panel.add(numeroBoletoField);
        panel.add(nombreClienteLabel);
        panel.add(nombreClienteField);
        panel.add(destinoLabel);
        panel.add(destinoField);
        panel.add(tipoViajeLabel);
        panel.add(tipoViajeComboBox);
        panel.add(precioLabel);
        panel.add(precioField);
        panel.add(fechaLabel);
        panel.add(fechaField);
        panel.add(adultoMayorCheckBox);
        panel.add(calcularButton);

        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularBoleto();
            }
        });
    }

    private void calcularBoleto() {
        try {
            int numeroBoleto = Integer.parseInt(numeroBoletoField.getText());
            String nombreCliente = nombreClienteField.getText();
            String destino = destinoField.getText();
            int tipoViaje = tipoViajeComboBox.getSelectedIndex() + 1;
            double precio = Double.parseDouble(precioField.getText());
            String fecha = fechaField.getText();
            boolean esAdultoMayor = adultoMayorCheckBox.isSelected();

            Boleto boleto = new Boleto(numeroBoleto, nombreCliente, destino, tipoViaje, precio, fecha, esAdultoMayor);

            Object[][] data = {
                    {"Número de Boleto", boleto.getNumeroBoleto()},
                    {"Fecha", boleto.getFecha()},
                    {"Nombre Cliente", boleto.getNombreCliente()},
                    {"Destino", boleto.getDestino()},
                    {"Tipo Viaje", (boleto.getTipoViaje() == 1 ? "Sencillo" : "Doble")},
                    {"Precio", "$" + boleto.getPrecio()},
                    {"Importe Subtotal", "$" + boleto.calcularImporte()},
                    {"Impuesto (+16%)", "$" + boleto.calcularImpuesto()},
                    {"Descuento (-)", "$" + boleto.calcularDescuento()},
                    {"Total a Pagar", "$" + boleto.calcularTotalPagar()}
            };

            String[] columnNames = {"Concepto", "Valor"};
            DefaultTableModel model = new DefaultTableModel(data, columnNames);
            tablaResultados.setModel(model);

            JOptionPane.showMessageDialog(this, "Cálculo completado", "Resultado", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese valores válidos para el número de boleto, precio y fecha.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                BoletoInterface interfaz = new BoletoInterface();
                interfaz.setVisible(true);
            }
        });
    }
}
