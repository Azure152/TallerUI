package project.contenidos.estudiante;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import project.App;
import project.componentes.Boton;
import project.componentes.CampoEntrada;
import project.utilidades.Colores;
import project.utilidades.Cursores;
import project.utilidades.Fuentes;

public class LoginEstudiante extends JPanel {
    private App app;
    private Boton autenticacionBoton;
    private JLabel cambioLogin;

    public LoginEstudiante(App app) {
        this.app = app;

        this.setSize(800, 600);
        this.setPreferredSize(new Dimension(800, 600));
        this.setMinimumSize(new Dimension(800, 600));
        this.setMaximumSize(new Dimension(800, 600));
        this.setBackground(Colores.PRIMARY);
        this.setLayout(null);

        this.asignarComponentes();
        this.asignarListeners();
    }

    private void asignarComponentes() {
        this.add(this.crearContenedor(), BorderLayout.CENTER);
    }

    private JPanel crearContenedor() {
        JPanel contenedor = new JPanel();
        contenedor.setLayout(null);
        contenedor.setBackground(Colores.FONDO);
        contenedor.setSize(600, 200);
        contenedor.setLocation(
            (this.getWidth() - contenedor.getWidth()) / 2,
            (this.getHeight() - contenedor.getHeight()) / 2
        );

        this.asignarComponentesContenedor(contenedor);

        return contenedor;
    }

    private void asignarComponentesContenedor(JPanel contenedor) {
        CampoEntrada campoIdentificacion = new CampoEntrada();
        campoIdentificacion.setBounds(50, 52, 500, 40);
        campoIdentificacion.setTextoMarcador("Numero de identificacion");
        campoIdentificacion.setBorder(new MatteBorder(0, 0, 2, 0, Colores.PRIMARY));
        campoIdentificacion.setFont(Fuentes.PREDETERMINADA);
        campoIdentificacion.setHorizontalAlignment(SwingConstants.CENTER);
        // campoIdentificacion.setFont();

        autenticacionBoton = new Boton();
        autenticacionBoton.setText("Autenticar");
        autenticacionBoton.setBounds(50, 110, 500, 40);
        autenticacionBoton.setBackground(Colores.PRIMARY);
        autenticacionBoton.setForeground(Color.WHITE);
        autenticacionBoton.setFont(Fuentes.PREDETERMINADA);
        autenticacionBoton.setCursor(Cursores.POINTER_CURSOR);
        // autenticacionBoton.setHoverBackground(getBackground());

        cambioLogin = new JLabel();
        cambioLogin.setText("- Administrador ->");
        cambioLogin.setFont(Fuentes.PREDETERMINADA.deriveFont(Font.ITALIC));
        cambioLogin.setForeground(Colores.PRIMARY);
        cambioLogin.setBounds(240, 155, 120, 20);
        cambioLogin.setHorizontalAlignment(SwingConstants.CENTER);
        cambioLogin.setCursor(Cursores.POINTER_CURSOR);

        contenedor.add(campoIdentificacion);
        contenedor.add(autenticacionBoton);
        contenedor.add(cambioLogin);
    }

    private void asignarListeners() {
        // LoginEstudiante self = this;

        this.cambioLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) { app.loginAdministrador(); }
        });
    }
}
