Este programa Java consiste en una interfaz gráfica de usuario (GUI) para la venta de boletos de viaje. La funcionalidad está dividida en dos archivos .java:

Boleto.java:

Representa un objeto Boleto que tiene atributos como número de boleto, nombre del cliente, destino, tipo de viaje, precio, fecha y si el cliente es adulto mayor.
Contiene métodos para calcular el importe, impuesto, descuento y el total a pagar basándose en las reglas del negocio.
Proporciona métodos de acceso para obtener los detalles del boleto.
BoletoInterface.java:

Es una interfaz gráfica de usuario (GUI) utilizando Swing para crear una ventana donde los usuarios pueden ingresar la información del boleto.
La interfaz incluye campos de texto para ingresar datos como número de boleto, nombre del cliente, destino, precio, fecha, y una casilla de verificación para indicar si el cliente es adulto mayor.
También hay un botón de "Calcular" que realiza el cálculo del boleto y muestra los resultados en una tabla en la misma ventana.
Se utiliza un evento de botón para llamar al método calcularBoleto(), que crea un objeto Boleto con la información ingresada, realiza los cálculos y muestra los resultados en la tabla.
En resumen, la interfaz permite a los usuarios ingresar detalles de un boleto de viaje, realizar cálculos basados en las reglas de negocio definidas en la clase Boleto, y ver los resultados de manera visual en la interfaz gráfica.





