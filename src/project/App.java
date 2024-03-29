package project;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import project.componentes.Boton;
import project.contenidos.administrador.AsginaturasAdministador;
import project.contenidos.administrador.DocentesAdministrador;
import project.contenidos.administrador.EstudiantesAdministrador;
import project.contenidos.administrador.LoginAdministrador;
import project.contenidos.administrador.VistaAsignaturaAdministrador;
import project.contenidos.administrador.VistaDocenteAdministrador;
import project.contenidos.administrador.VistaEstudianteAdministrador;
import project.contenidos.estudiante.LoginEstudiante;
import project.utilidades.Colores;
import project.utilidades.Cursores;

public class App extends JFrame {
    public static void main(String[] args) throws Exception {
        App aplicacion = new App();
        aplicacion.loginEstudiante();
        // aplicacion.asignaturasAdministrador();
        // aplicacion.mostrarAsignaturaAdministrador();
        // aplicacion.estudiantesAdministrador();
        // aplicacion.mostrarEstudianteAdministrador();
        // aplicacion.docentesAdministrador();
        // aplicacion.mostrarDocenteAdministrador();
    }

    /**
     * construye una instancia de aplicacion
     */
    public App() {
        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 630);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setFont(this.defaultFont());

        this.designarComponentes();

        this.setVisible(true);
    }

    /**
     * asigna/añade/agrega los componentes basicos de la ventana
     */
    private void designarComponentes() {
        Container contentPane = this.getContentPane();
        contentPane.setBackground(Colores.FONDO);
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));

        this.getContentPane().add(this.crearBarraTitulo());
        this.getContentPane().add(this.crearPanelContenido());
    }

    /**
     * crea la barra de titulo para la ventana
     * 
     * @return barra de titulo
     */
    private JPanel crearBarraTitulo() {
        App self = this;

        JPanel barra = new JPanel();
        barra.setName("barraTitulo");
        barra.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        // barra.setBackground(Color.decode("#f7f8ff"));
        
        Dimension d = new Dimension(800, 30);
        barra.setPreferredSize(d);

        Boton cerrar = new Boton(" X ");
        cerrar.setFont(this.getFont().deriveFont(20f));
        cerrar.setForeground(Color.BLACK);
        cerrar.setBackground(null);
        cerrar.setHoverBackground(Colores.PELIGRO);
        cerrar.setHoverForeground(Color.WHITE);
        cerrar.setCursor(Cursores.POINTER_CURSOR);
        cerrar.setPreferredSize(new Dimension(40, 30));

        Boton minimizar = new Boton(" - ");
        minimizar.setFont(this.getFont().deriveFont(20f));
        minimizar.setForeground(Color.BLACK);
        minimizar.setBackground(null);
        minimizar.setHoverBackground(Colores.PRIMARY);
        minimizar.setHoverForeground(Color.WHITE);
        minimizar.setCursor(Cursores.POINTER_CURSOR);
        minimizar.setPreferredSize(new Dimension(35, 30));

        barra.add(minimizar);
        barra.add(cerrar);

        cerrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) { self.finalizar(); }
        });

        minimizar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) { self.minimizar(); }
        });

        return barra;
    }

    /**
     * crea el panel para agregar el contenido de la vista
     * 
     * @return panel para el contenido
     */
    private JPanel crearPanelContenido() {
        JPanel contenidoPanel = new JPanel();
        contenidoPanel.setName("panelContenido");
        contenidoPanel.setPreferredSize(new Dimension(800, 600));
        contenidoPanel.setLayout(new BoxLayout(contenidoPanel, BoxLayout.PAGE_AXIS));
        // contenidoPanel.setBackground(Colores.PRIMARY);

        return contenidoPanel;
    }

    /**
     * cambia el contenido de la vista actual
     */
    public void cambiarContenido(JPanel contenido) {
        this.panelContenido().removeAll();
        this.panelContenido().add(contenido);
        this.panelContenido().revalidate();
        this.panelContenido().repaint();
    }

    /**
     * fuente por defecto para la apliacion
     * 
     * @return fuente
     */
    private Font defaultFont() {
        return new Font("Arial", Font.PLAIN, 14);
    }

    /**
     * dispara el evento para cerrar la ventana
     */
    private void finalizar() {
        this.dispatchEvent(
            new WindowEvent(this, WindowEvent.WINDOW_CLOSING)
        );
    }

    /**
     * cambia el estado de la ventana a una minimizado
     */
    private void minimizar() {
        this.setState(JFrame.ICONIFIED);
    }

    /**
     * obtiene el panel que se usa para el contenido
     * 
     * @return panel para el contenido
     */
    public JPanel panelContenido() {
        return (JPanel) this.getContentPane().getComponent(1);
    }

    /*
     * ------------------------------------------------------------------------
     * funciones para el cambio de contenidos
     * ------------------------------------------------------------------------
     */

    /**
     * contenido para el ingreso de estudiante a la aplicacion
     */
    public void loginEstudiante() {
        this.cambiarContenido(new LoginEstudiante(this));
    }

    /**
     * cambia el contenido al de login para administrador
     */
    public void loginAdministrador() {
        this.cambiarContenido(new LoginAdministrador(this));
    }

    /**
     * cambia el contenido para mostrar las asignaturas al admistrador
     */
    public void asignaturasAdministrador() {
        this.cambiarContenido(new AsginaturasAdministador(this));
    }

    /**
     * cambia el contenido al de la vista de una asignatura
     */
    public void mostrarAsignaturaAdministrador() {
        this.cambiarContenido(new VistaAsignaturaAdministrador(this));
    }

    /**
     * cambia el contenido para mostrar los estudiantes al admistrador
     */
    public void estudiantesAdministrador() {
        this.cambiarContenido(new EstudiantesAdministrador(this));
    }

    /**
     * cambia el contenido al de la vista de detalles de un estudiante
     */
    public void mostrarEstudianteAdministrador() {
        this.cambiarContenido(new VistaEstudianteAdministrador(this));
    }

    /**
     * cambia el contenido para mostrar los docentes al admistrador
     */
    public void docentesAdministrador() {
        this.cambiarContenido(new DocentesAdministrador(this));
    }

    /**
     * cmaiba el contenido para mostrar los detalles del docente
     */
    public void mostrarDocenteAdministrador() {
        this.cambiarContenido(new VistaDocenteAdministrador(this));
    }
}
