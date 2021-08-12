package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.ControladorMenu;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import java.util.Hashtable;


public class VistaComoJugar extends Vista{
    Stage stage;

    public Scene crearEscena(Hashtable data){
        VBox contenedorPrincipal = new VBox();
        contenedorPrincipal.setSpacing(10);
        Label label = new Label();
        label.setText("Como jugar: \n1)Se selecciona la cantidad de jugadores y quien ira primero\n" +
                "2)Se le asigna un objetivo a cada jugador\n" +
                "3)Se reparten los paises 50 entre los jugadores y se coloca un ejercito en cada 1\n" +
                "4)Todos los jugadores colocan 5 tropas en los paises que quieran, y luego colocan 3 mas\n" +
                "5)Comienza el juego: El juego se divide en 2 fases: de ataque y reagrupacion, y de colocacion.\n" +
                "Fase de ataque: Cada jugador, empezando por el primero, puede elegir atacar paises que controla otro jugador\n." +
                "El atacante lanza tantos dados como ejércitos utilice para atacar, con un máximo de tres dados y recordando\n" +
                "que siempre uno de los ejércitos debe permanecer en el país que origina el ataque.Por otro lado, el defensor \n" +
                "lanza tantos dados como ejércitos tenga en el país defensor, con un máximo de tres.\n" +
                "Una vez que atacante y defensor tiran los dados se compara el dado mayor del atacante con el dado mayor del defensor y\n" +
                "así sucesivamente con el resto de los dados. Cada jugador retira de su país un ejército por cada dado derrotado.\n" +
                "Luego puede reagrupar sus tropas, moviendolas entre paises que sean limitrofes entre si(y que controle)\n" +
                "y luego que todos los jugadores hayan tenido su fase de ataque, se pasa a la fase de colocacion.\n" +
                "Fase de colocacion:Se le otorga a cada jugador tropas para colocar segun cuantos paises controle \n" +
                "(Cantidad de paises conquistados / 2). Ademas, si controla un continente completo recibe tropas adicionales \n" +
                "(Asia: 7 Europa: 5 America del Norte: 5 America del sur: 3 Africa: 3 Oceania: 2).\n" +
                "Esta secuencia de fases se repite hasta que un jugador haya cumplido su objetivo. Entonces, este sera el ganador.");
        label.setTextFill(Color.BLACK);
        label.setFont(new Font(label.getFont().getName(),18));
        Button btn_salir = new Button();
        contenedorPrincipal.getChildren().addAll(label, btn_salir);
        contenedorPrincipal.setAlignment(Pos.CENTER);
        btn_salir.setText("Volver al menú");

        btn_salir.setPrefWidth(200);

        this.setAlignment(Pos.CENTER);

        this.getChildren().addAll(contenedorPrincipal);
       /* Image imagen = new Image("file:"+System.getProperty("user.dir") + "/assets/instrucciones.png");
        BackgroundImage fondoImagen = new BackgroundImage(imagen,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
        Background fondo = new Background(fondoImagen);
        super.setBackground(fondo);*/

        btn_salir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ControladorMenu.mostrarMenu();
            }
        });

        return new Scene(this, 1280, 720);
    }
}