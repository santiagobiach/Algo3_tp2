package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.ControladorMenu;
import edu.fiuba.algo3.vistas.botones.BotonAgregarJugador;
import edu.fiuba.algo3.vistas.botones.BotonModificarCantidadDeJugadores;
import edu.fiuba.algo3.vistas.botones.BotonQuitarJugador;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Hashtable;

public class VistaConfigurarPartida extends Vista{
    private int nombresVisibles = 2;

    private void mostrarCamposYBotones(Group nombres, Group botones){
        int i=0;
        for(Object t: nombres.getChildren()){
            ((TextField)t).setPrefWidth(200);
            ((TextField)t).setLayoutY(30*(i+1));
            ((TextField)t).setVisible((i++<this.nombresVisibles));
        }
        botones.setLayoutY(30*(this.nombresVisibles+10));

        for(Object b: botones.getChildren())
            ((BotonModificarCantidadDeJugadores)b).nuevoNumeroDeJugadores(nombresVisibles);
    }

    private void agregarJugador(Group nombres, Group botones){
        this.nombresVisibles++;
        this.mostrarCamposYBotones(nombres, botones);
    }

    private void quitarJugador(Group nombres, Group botones){
        this.nombresVisibles--;
        this.mostrarCamposYBotones(nombres, botones);
    }

    public Scene crearEscena(Hashtable data) {
        Label mensaje = new Label();
        mensaje.setTextFill(Color.WHITE);

        if(data.containsKey("mensaje")){
            System.out.println(((String)data.get("mensaje")));
            mensaje.setText(((String)data.get("mensaje")));
        }

        Group botones = new Group();
        Group nombres = new Group();

        TextField nombre1 = new TextField();
        nombre1.setPromptText("Ingrese el nombre del jugador 1");
        TextField nombre2 = new TextField();
        nombre2.setPromptText("Ingrese el nombre del jugador 2");
        TextField nombre3 = new TextField();
        nombre3.setPromptText("Ingrese el nombre del jugador 3");
        TextField nombre4 = new TextField();
        nombre4.setPromptText("Ingrese el nombre del jugador 4");
        TextField nombre5 = new TextField();
        nombre5.setPromptText("Ingrese el nombre del jugador 5");
        TextField nombre6 = new TextField();
        nombre6.setPromptText("Ingrese el nombre del jugador 6");

        nombres.getChildren().addAll(nombre1, nombre2, nombre3, nombre4, nombre5, nombre6);

        BotonAgregarJugador btn_agregar_jugador = new BotonAgregarJugador();
        btn_agregar_jugador.setText("AGREGAR UN JUGADOR");
        btn_agregar_jugador.setPrefWidth(200);

        BotonQuitarJugador btn_quitar_jugador = new BotonQuitarJugador();
        btn_quitar_jugador.setText("QUITAR UN JUGADOR");
        btn_quitar_jugador.setPrefWidth(200);
        btn_quitar_jugador.setLayoutY(30);

        botones.getChildren().addAll(btn_agregar_jugador, btn_quitar_jugador);

        Button btn_empezar = new Button();
        btn_empezar.setText("EMPEZAR");
        btn_empezar.setPrefHeight(40);
        btn_empezar.setPrefWidth(100);
        btn_empezar.setLayoutX(200);
        btn_empezar.setLayoutY(200);

        this.setAlignment(Pos.CENTER);

        this.setSpacing(5);
        this.getChildren().addAll(mensaje, nombres, botones, btn_empezar);
        mostrarCamposYBotones(nombres, botones);

        Image imagen = new Image("file:"+System.getProperty("user.dir") + "/assets/Portada2.jpeg");
        BackgroundImage fondoImagen = new BackgroundImage(imagen,BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
        Background fondo = new Background(fondoImagen);
        super.setBackground(fondo);

        btn_agregar_jugador.setOnAction(actionEvent -> {
            agregarJugador(nombres, botones);
            btn_agregar_jugador.nuevoNumeroDeJugadores(nombresVisibles);
            btn_quitar_jugador.nuevoNumeroDeJugadores(nombresVisibles);

        });

        btn_quitar_jugador.setOnAction(actionEvent -> {
            quitarJugador(nombres, botones);
            btn_agregar_jugador.nuevoNumeroDeJugadores(nombresVisibles);
            btn_quitar_jugador.nuevoNumeroDeJugadores(nombresVisibles);

        });

        btn_empezar.setOnAction(actionEvent -> {
            Hashtable data1 = new Hashtable();
            ArrayList<String> nombres_introducidos = new ArrayList<>();
            for (int i = 0; i < nombresVisibles; i++) {
                nombres_introducidos.add(((TextField)nombres.getChildren().get(i)).getText());
            }
            data1.put("nombres", nombres_introducidos);
            ControladorMenu.empezarPartida(data1);
        });

        return new Scene(this, 1280, 720);
    }

}

