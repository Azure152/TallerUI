package project.contenidos.administrador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import project.App;
import project.componentes.Boton;
import project.componentes.CampoEntrada;
import project.utilidades.Colores;
import project.utilidades.Cursores;
import project.utilidades.Fuentes;

public class VistaAsignaturaAdministrador extends JPanel {
    private App app;
    private Boton mostrarEstudiante;

    public VistaAsignaturaAdministrador(App app) {
        this.app = app;

        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        this.setBackground(Colores.FONDO);

        this.asignarComponentes();
        this.asignarListeners();
    }

    private void asignarComponentes() {
        this.add(this.crearBarraLateral());
        this.add(this.crearPanelContenido());
    }

    private JPanel crearBarraLateral() {
        JPanel barra = new JPanel();
        // barra.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        barra.setBackground(Colores.FONDO_DARK);
        barra.setPreferredSize(new Dimension(200, 600));
        barra.setLayout(new BoxLayout(barra, BoxLayout.PAGE_AXIS));

        JLabel titulo = new JLabel();
        titulo.setText("Panel administrativo");
        titulo.setBorder(new EmptyBorder(15, 10, 15, 10));
        titulo.setFont(Fuentes.PREDETERMINADA.deriveFont(16f).deriveFont(Font.BOLD));

        barra.add(titulo);
        barra.add(this.crearContenidoBarraLateral());
        barra.add(Box.createVerticalStrut(10));

        Arrays.stream(
            new String[] {"Everybody", "else is a", "returned"}
        ).iterator().forEachRemaining((name) -> {
            JLabel label = new JLabel("@ " + name);
            label.setBorder(new EmptyBorder(5, 10, 10, 10));
            label.setFont(Fuentes.PREDETERMINADA);
            barra.add(label);
        });

        return barra;
    }

    private JPanel crearContenidoBarraLateral() {
        JPanel contenido = new JPanel();
        contenido.setBackground(null);
        contenido.setLayout(new BoxLayout(contenido, BoxLayout.PAGE_AXIS));
        contenido.setPreferredSize(new Dimension(200, 600));
        contenido.setMaximumSize(new Dimension(200, 0));

        var sidebarEl1 = new JLabel();
        sidebarEl1.setText("Asignaturas");
        sidebarEl1.setFont(Fuentes.PREDETERMINADA);
        sidebarEl1.setBorder(new EmptyBorder(10, 15, 10, 10));
        sidebarEl1.setForeground(Colores.PRIMARY);

        var sidebarEl2 = new JLabel();
        sidebarEl2.setText("Estudiantes");
        sidebarEl2.setFont(Fuentes.PREDETERMINADA);
        sidebarEl2.setBorder(new EmptyBorder(10, 15, 10, 10));

        var sidebarEl3 = new JLabel();
        sidebarEl3.setText("Docentes");
        sidebarEl3.setFont(Fuentes.PREDETERMINADA);
        sidebarEl3.setBorder(new EmptyBorder(10, 15, 10, 10));

        contenido.add(sidebarEl1);
        contenido.add(sidebarEl2);
        contenido.add(sidebarEl3);

        sidebarEl1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) { app.asignaturasAdministrador(); }
        });

        sidebarEl2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) { app.estudiantesAdministrador(); }
        });

        sidebarEl3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) { app.docentesAdministrador(); }
        });

        return contenido;
    }

    private JPanel crearPanelContenido() {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(600, 600));
        panel.setBackground(Colores.FONDO);
        panel.setLayout(null);

        var cabecera = new JPanel();
        cabecera.setBounds(20, 10, 400, 30);
        cabecera.setLayout(new BoxLayout(cabecera, BoxLayout.LINE_AXIS));
        cabecera.setBackground(null);

        var nombre = new JLabel("Asignatura rand " + Math.round(Math.random() * 130));
        nombre.setFont(Fuentes.PREDETERMINADA.deriveFont(20f).deriveFont(Font.BOLD));
        nombre.setHorizontalAlignment(SwingConstants.LEFT);

        var codigo = new JLabel("ASD-1234");
        codigo.setFont(Fuentes.PREDETERMINADA.deriveFont(14f));
        codigo.setForeground(Color.GRAY);


        CampoEntrada campoNombre = new CampoEntrada();
        campoNombre.setBounds(20, 60, 560, 40);
        campoNombre.setTextoMarcador("Nombre de la asignatura");

        CampoEntrada campoCodigo = new CampoEntrada();
        campoCodigo.setBounds(20, 110, 560, 40);
        campoCodigo.setTextoMarcador("codigo de la asignatura");

        CampoEntrada campoCapacidad = new CampoEntrada();
        campoCapacidad.setBounds(20, 160, 560, 40);
        campoCapacidad.setTextoMarcador("capcidad maxima de estudiantes");

        String[] docentes = new String[] {
            "109341327: Jan Diego Perez",
            "109821309: Jhon David Alvarez"
        };

        JComboBox<String> docente = new JComboBox<>(docentes);
        docente.setBounds(20, 210, 410, 40);
        docente.setBackground(null);

        JLabel labelHabilitable = new JLabel();
        labelHabilitable.setText("Es habilitable: ");
        labelHabilitable.setBounds(470, 210, 90, 40);

        JCheckBox habilitableCheckBox = new JCheckBox();
        habilitableCheckBox.setBounds(560, 210, 20, 40);
        habilitableCheckBox.setBackground(null);

        Boton actualizarBtn =  new Boton();
        actualizarBtn.setBounds(20, 260, 180, 40);
        actualizarBtn.setBackground(Colores.PRIMARY);
        actualizarBtn.setText("Actualizar asignatura");
        actualizarBtn.setForeground(Color.WHITE);
        actualizarBtn.setCursor(Cursores.POINTER_CURSOR);

        Boton eliminarBtn = new Boton();
        eliminarBtn.setBounds(210, 260, 180, 40);
        eliminarBtn.setBackground(Colores.PELIGRO);
        eliminarBtn.setText("Eliminar asignatura");
        eliminarBtn.setForeground(Color.WHITE);
        eliminarBtn.setCursor(Cursores.POINTER_CURSOR);


        JSeparator sep = new JSeparator();
        // sep.setBackground(Color.);
        sep.setForeground(Color.LIGHT_GRAY);
        sep.setBounds(20, 310, 560, 1);

        JTable estudiantes = new JTable(
            new Object[][] {},
            new String[] {"Identificacion", "nombre", "promedio"}
        );

        JScrollPane contenedorTabla = new JScrollPane(estudiantes);
        contenedorTabla.setBounds(20, 320, 400, 260);

        Boton mostrar = new Boton();
        mostrar.setText("Mostrar");
        mostrar.setBounds(430, 340, 150, 30);
        mostrar.setCursor(Cursores.POINTER_CURSOR);

        Boton eliminarEnTabla = new Boton();
        eliminarEnTabla.setText("Liberar cupo");
        eliminarEnTabla.setBounds(430, 380, 150, 30);
        eliminarEnTabla.setCursor(Cursores.POINTER_CURSOR);

        cabecera.add(nombre);
        cabecera.add(Box.createHorizontalStrut(10));
        cabecera.add(codigo);
        panel.add(cabecera);
        panel.add(campoNombre);
        panel.add(campoCodigo);
        panel.add(campoCapacidad);
        panel.add(docente);
        panel.add(labelHabilitable);
        panel.add(habilitableCheckBox);
        panel.add(actualizarBtn);
        panel.add(eliminarBtn);
        panel.add(sep);
        panel.add(contenedorTabla);
        panel.add(mostrar);
        panel.add(eliminarEnTabla);

        mostrarEstudiante = mostrar;

        return panel;
    }


    private void asignarListeners() {
        var self = this;

        mostrarEstudiante.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) { self.calificacionModal(); }
        });
    }

    private void calificacionModal() {
        JDialog modal = new JDialog(this.app, "Calificaciones", true);
        modal.setSize(500, 300);
        modal.setLocationRelativeTo(null);
        modal.getContentPane().setBackground(Colores.FONDO);
        // modal.setLayout(new BorderLayout());
        modal.setLayout(null);

        JLabel nota1Label = new JLabel();
        nota1Label.setText("Nota 1: ");
        nota1Label.setBounds(20, 10, 100, 30);

        CampoEntrada campoNota1 = new CampoEntrada();
        campoNota1.setBounds(100, 10, 360, 30);
        
        JLabel nota2Label = new JLabel();
        nota2Label.setText("Nota 2: ");
        nota2Label.setBounds(20, 50, 100, 30);

        CampoEntrada campoNota2 = new CampoEntrada();
        campoNota2.setBounds(100, 50, 360, 30);

        JLabel nota3Label = new JLabel();
        nota3Label.setText("Nota 3: ");
        nota3Label.setBounds(20, 90, 100, 30);

        CampoEntrada campoNota3 = new CampoEntrada();
        campoNota3.setBounds(100, 90, 360, 30);

        JLabel nota4Label = new JLabel();
        nota4Label.setText("Nota 4: ");
        nota4Label.setBounds(20, 130, 100, 30);

        CampoEntrada campoNota4 = new CampoEntrada();
        campoNota4.setBounds(100, 130, 360, 30);

        Boton actualizar = new Boton();
        actualizar.setText("Actualizar");
        actualizar.setBackground(Colores.PRIMARY);
        actualizar.setBounds(20, 180, 440, 40);
        actualizar.setForeground(Color.WHITE);
        actualizar.setCursor(Cursores.POINTER_CURSOR);


        modal.add(nota1Label);
        modal.add(nota2Label);
        modal.add(nota3Label);
        modal.add(nota4Label);
        modal.add(campoNota1);
        modal.add(campoNota2);
        modal.add(campoNota3);
        modal.add(campoNota4);
        modal.add(actualizar);

        modal.setVisible(true);
    }
}
