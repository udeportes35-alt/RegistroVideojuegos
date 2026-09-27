package principal;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import modelo.Videojuego;
import vista.VentanaVideojuegos;

public class Principal {
    
    private ArrayList<Videojuego> videojuegos;
    private VentanaVideojuegos ventana;
    
    public Principal() {
        videojuegos = new ArrayList<>();
        ventana = new VentanaVideojuegos();

        ventana.getBtnAgregar().addActionListener(e -> agregarVideojuego());
        ventana.getBtnEliminar().addActionListener(e -> eliminarVideojuego());
    }

    public void iniciar() {
        ventana.setVisible(true);
    }

    public void agregarVideojuego() {
        String titulo = ventana.getTitulo().trim();
        String genero = ventana.getGenero().trim();
        String textoPrecio = ventana.getPrecio().trim();

        if (titulo.isEmpty()) {
            ventana.mensaje("El título no puede estar vacío.");
            return;
        }

        try {
            double precio = Double.parseDouble(textoPrecio);

            Videojuego videojuego =
                    new Videojuego(titulo, genero, precio);

            videojuegos.add(videojuego);

            ventana.agregarFila(
                    videojuego.getTitulo(),
                    videojuego.getGenero(),
                    videojuego.getPrecio()
            );

            ventana.limpiarCampos();

        } catch (NumberFormatException e) {
            ventana.mensaje("Ingrese un precio válido.");
        }
    }

    public void eliminarVideojuego() {
       int fila = ventana.getFilaSeleccionada();

    if (fila == -1) {
        ventana.mensaje("Seleccione un videojuego para eliminar.");
        return;
    }

    int respuesta = javax.swing.JOptionPane.showConfirmDialog(
            ventana,
            "¿Está seguro de eliminar este videojuego?",
            "Confirmar eliminación",
            javax.swing.JOptionPane.YES_NO_OPTION
    );

    if (respuesta == javax.swing.JOptionPane.YES_OPTION) {
        videojuegos.remove(fila);
        ventana.eliminarFila(fila);
    }
   }
    public static void main(String[] args) {
           SwingUtilities.invokeLater(() -> {
            Principal programa = new Principal();
            programa.iniciar();
        });
    }
    
}
