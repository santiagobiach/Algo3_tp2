package edu.fiuba.algo3.modelo.vistas;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.canjes.TarjetaDePais;
import edu.fiuba.algo3.modelo.controladores.ControladorJuego;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

public class VistaTablero extends AnchorPane{
    private Juego juego;
    public VistaTablero(Juego juego, ComboBox<String> CBPais){
        this.juego = juego;
        Label nombrePais = new Label("Pais seleccionado:");
        VistaPais argentina = new VistaPais(juego.getTablero().getPais("Argentina"),nombrePais, CBPais);
        VistaPais brasil = new VistaPais(juego.getTablero().getPais("Brasil"),nombrePais, CBPais);
        VistaPais chile = new VistaPais(juego.getTablero().getPais("Chile"),nombrePais, CBPais);
        VistaPais  uruguay = new VistaPais(juego.getTablero().getPais("Uruguay"),nombrePais, CBPais);
        VistaPais peru = new VistaPais(juego.getTablero().getPais("Peru"),nombrePais, CBPais);
        VistaPais colombia = new VistaPais(juego.getTablero().getPais("Colombia"),nombrePais, CBPais);
        VistaPais mexico = new VistaPais(juego.getTablero().getPais("Mexico"),nombrePais, CBPais);
        VistaPais california = new VistaPais(juego.getTablero().getPais("California"),nombrePais, CBPais);
        VistaPais oregon = new VistaPais(juego.getTablero().getPais("Oregon"),nombrePais, CBPais);
        VistaPais alaska = new VistaPais(juego.getTablero().getPais("Alaska"),nombrePais, CBPais);
        VistaPais  yukon = new VistaPais(juego.getTablero().getPais("Yukon"),nombrePais, CBPais);
        VistaPais canada = new VistaPais(juego.getTablero().getPais("Canada"),nombrePais, CBPais);
        VistaPais nuevaYork = new VistaPais(juego.getTablero().getPais("Nueva York"),nombrePais, CBPais);
        VistaPais terranova = new VistaPais(juego.getTablero().getPais("Terranova"),nombrePais, CBPais);
        VistaPais labrador = new VistaPais(juego.getTablero().getPais("Labrador"),nombrePais, CBPais);
        VistaPais groenlandia = new VistaPais(juego.getTablero().getPais("Groenlandia"),nombrePais, CBPais);
        VistaPais  sahara = new VistaPais(juego.getTablero().getPais("Sahara"),nombrePais, CBPais);
        VistaPais zaire = new VistaPais(juego.getTablero().getPais("Zaire"),nombrePais, CBPais);
        VistaPais sudafrica = new VistaPais(juego.getTablero().getPais("Sudafrica"),nombrePais, CBPais);
        VistaPais etiopia = new VistaPais(juego.getTablero().getPais("Etiopia"),nombrePais, CBPais);
        VistaPais egipto = new VistaPais(juego.getTablero().getPais("Egipto"),nombrePais, CBPais);
        VistaPais madagascar = new VistaPais(juego.getTablero().getPais("Madagascar"),nombrePais, CBPais);
        VistaPais australia = new VistaPais(juego.getTablero().getPais("Australia"),nombrePais, CBPais);
        VistaPais sumatra = new VistaPais(juego.getTablero().getPais("Sumatra"),nombrePais, CBPais);
        VistaPais borneo = new VistaPais(juego.getTablero().getPais("Borneo"),nombrePais, CBPais);
        VistaPais java = new VistaPais(juego.getTablero().getPais("Java"),nombrePais, CBPais);
        VistaPais espania = new VistaPais(juego.getTablero().getPais("España"),nombrePais, CBPais);
        VistaPais francia = new VistaPais(juego.getTablero().getPais("Francia"),nombrePais, CBPais);
        VistaPais italia = new VistaPais(juego.getTablero().getPais("Italia"),nombrePais, CBPais);
        VistaPais alemania = new VistaPais(juego.getTablero().getPais("Alemania"),nombrePais, CBPais);
        VistaPais polonia = new VistaPais(juego.getTablero().getPais("Polonia"),nombrePais, CBPais);
        VistaPais rusia = new VistaPais(juego.getTablero().getPais("Rusia"),nombrePais, CBPais);
        VistaPais suecia = new VistaPais(juego.getTablero().getPais("Suecia"),nombrePais, CBPais);
        VistaPais granBretania = new VistaPais(juego.getTablero().getPais("Gran Bretaña"),nombrePais, CBPais);
        VistaPais islandia = new VistaPais(juego.getTablero().getPais("Islandia"),nombrePais, CBPais);
        VistaPais turquia = new VistaPais(juego.getTablero().getPais("Turquia"),nombrePais, CBPais);
        VistaPais israel = new VistaPais(juego.getTablero().getPais("Israel"),nombrePais, CBPais);
        VistaPais arabia = new VistaPais(juego.getTablero().getPais("Arabia"),nombrePais, CBPais);
        VistaPais iran = new VistaPais(juego.getTablero().getPais("Iran"),nombrePais, CBPais);
        VistaPais aral = new VistaPais(juego.getTablero().getPais("Aral"),nombrePais, CBPais);
        VistaPais tartaria = new VistaPais(juego.getTablero().getPais("Tartaria"),nombrePais, CBPais);
        VistaPais taymir = new VistaPais(juego.getTablero().getPais("Taymir"),nombrePais, CBPais);
        VistaPais siberia = new VistaPais(juego.getTablero().getPais("Siberia"),nombrePais, CBPais);
        VistaPais kamtchatka = new VistaPais(juego.getTablero().getPais("Kamtchatka"),nombrePais, CBPais);
        VistaPais india = new VistaPais(juego.getTablero().getPais("India"),nombrePais, CBPais);
        VistaPais malasia = new VistaPais(juego.getTablero().getPais("Malasia"),nombrePais, CBPais);
        VistaPais mongolia = new VistaPais(juego.getTablero().getPais("Mongolia"),nombrePais, CBPais);
        VistaPais gobi = new VistaPais(juego.getTablero().getPais("Gobi"),nombrePais, CBPais);
        VistaPais china = new VistaPais(juego.getTablero().getPais("China"),nombrePais, CBPais);
        VistaPais japon = new VistaPais(juego.getTablero().getPais("Japon"),nombrePais, CBPais);

        argentina.setContent("m -36.253185,254.755 -11.861592,-8.04553 -2.156653,-80.45528 13.658802,-8.04553 23.363743,7.59855 -4.672751,13.40923 11.8615947,21.00776 -1.078329,8.4925 -28.3959307,16.09106 z");
        argentina.setLayoutX(381.0);
        argentina.setLayoutY(302.0);
        nombrePais.setLayoutY(23.0);
        nombrePais.setLayoutX(56.0);
        nombrePais.setFont(new Font("Arial", 18));
        brasil.setContent("M -36.612628,158.20866 -54.259614,127.93846 -42.265385,96.524997 2.8557693,101.66538 37.696153,126.225 43.978845,149.64231 9.1384614,174.20192 Z");
        brasil.setLayoutX(385.0);
        brasil.setLayoutY(301.0);

        chile.setContent( "m -48.114778,246.70947 -12.998682,-7.96717 0.571153,-63.39807 -10.280769,-10.28077 20.551645,1.19073 z");
        chile.setLayoutX(379.0);
        chile.setLayoutY(302.0);
        uruguay.setContent("m -6.0600412,200.2242 -11.8615948,-21.00776 4.672751,-13.40923 22.3873464,8.39471 -15.1985026,26.02228");
        uruguay.setLayoutX(382.0);
        uruguay.setLayoutY(301.0);
        peru.setContent( "m -70.823076,165.06346 -17.134615,-26.84423 33.698077,-10.28077 17.646986,30.2702 -13.658803,8.04553 z");
        peru.setLayoutX(381.0);
        peru.setLayoutY(299.0);
        colombia.setContent("m -87.957691,138.21923 -6.853846,-29.7 30.271154,-16.563463 22.274998,4.569232 -11.994229,31.413461");
        colombia.setLayoutX(384.0);
        colombia.setLayoutY(295.0);
        mexico.setContent("M 34.269232,97.667306 -9.7096153,69.109616 -7.4249999,59.4 9.1384614,49.119231 45.692308,90.242307");
        mexico.setLayoutX(255.0);
        mexico.setLayoutY(299.0);
        california.setContent("M 9.1384614,49.119231 -7.4249999,59.4 -9.7096153,69.109616 -22.846154,72.536539 -9.1384614,90.81346 -50.832691,73.678845 -65.682693,69.109616 -60.542307,39.980769 -38.267306,18.848077 27.986537,25.701923 9.1384614,49.119231");
        california.setLayoutX(253.0);
        california.setLayoutY(293.0);
        oregon.setContent("M -65.682693,69.109616 -60.542307,39.980769 -38.267306,18.848077 -59.4,-2.8557693 l -42.83654,19.4192303 -5.14038,10.851923 -15.42116,17.134615 57.115387,24.559617");
        oregon.setLayoutX(248.0);
        oregon.setLayoutY(294.0);
        alaska.setContent("M -122.79808,44.549999 -158.20961,14.85 l 5.71154,-39.980769 29.69999,5.711538 20.56154,35.982692");
        alaska.setLayoutX(243.0);
        alaska.setLayoutY(293.0);
        yukon.setContent("m -102.23654,16.563461 -20.56154,-35.982692 2.28462,-51.974998 17.13461,-13.136539 19.990389,25.701921 -1.71346,19.419231 15.421152,42.836539 z");
        yukon.setLayoutX(248.0);
        yukon.setLayoutY(287.0);
        canada.setContent("m -69.680769,3.426923 -15.421152,-42.836539 1.71346,-19.419231 -19.990389,-25.701921 63.398081,-54.830772 47.9769228,31.98462 L -29.7,-40.551922 -59.4,-2.8557693 -69.680769,3.426923");
        canada.setLayoutX(255.0);
        canada.setLayoutY(287.0);
        nuevaYork.setContent("M 27.986537,25.701923 -38.267306,18.848077 -59.4,-2.8557693 -37.124999,-31.41346 -7.9961538,-7.4249999 41.123076,-5.1403845 54.259614,21.132692 51.403845,44.549999 37.696153,19.419231 27.986537,25.701923");
        nuevaYork.setLayoutX(260.0);
        nuevaYork.setLayoutY(290.0);
        terranova.setContent("M -37.124999,-31.41346 -7.9961538,-7.4249999 41.123076,-5.1403845 41.694229,-28.557693 -22.846154,-54.830768 -29.7,-40.551922 l -7.424999,9.138462");
        terranova.setLayoutX(260.0);
        terranova.setLayoutY(288.0);
        labrador.setContent("M -0.57115384,-46.834615 8.5673077,-70.823076 38.838462,-82.817307 62.25577,-49.119231 41.694229,-28.557693 Z");
        labrador.setLayoutX(258.0);
        labrador.setLayoutY(285.0);
        groenlandia.setContent("m 62.25577,-125.08269 35.411536,20.56154 1.713463,39.980767 27.415381,31.984613 25.13077,-51.974998 -2.28461,-51.403842 -31.41347,-35.41154 -35.411533,3.99807 z");
        groenlandia.setLayoutX(224.0);
        groenlandia.setLayoutY(258.0);
        sahara.setContent("m 297,156.49615 6.28269,-34.26923 26.27307,-18.84807 58.25771,21.70384 -30.27117,29.7 -39.98076,26.27308 z");
        sahara.setLayoutX(243.0);
        sahara.setLayoutY(267.0);
        zaire.setContent("M 317.56154,181.05577 357.5423,154.78269 405.51922,178.2 400.95,199.33269 375.81922,219.32307 356.97115,193.62115 Z");
        zaire.setLayoutX(243.0);
        zaire.setLayoutY(272.0);
        sudafrica.setContent("m 375.81922,219.32307 14.27884,26.27308 41.12308,14.27885 19.41925,-29.12885 -14.27885,-33.69807 15.42114,-19.41924 -46.26346,0.57116 -4.56922,21.13269 -25.13078,19.99038");
        sudafrica.setLayoutX(245.0);
        sudafrica.setLayoutY(272.0);
        etiopia.setContent("M 451.78268,177.62884 405.51922,178.2 357.5423,154.78269 l 30.27117,-29.7 35.41154,15.99231 49.1192,9.13846 -20.56153,27.41538");
        etiopia.setLayoutX(247.0);
        etiopia.setLayoutY(270.0);
        egipto.setContent("m 366.10962,115.94423 21.70385,9.13846 35.41154,15.99231 49.1192,9.13846 25.13079,-25.70192 -34.84038,-28.557694 z");
        egipto.setLayoutX(247.0);
        egipto.setLayoutY(266.0);
        madagascar.setContent("m 476.91346,231.88846 9.13845,9.13846 16.56347,-9.70962 2.85578,-38.2673 -9.13847,-9.70962 -16.56347,6.85385 -9.13845,22.84615 z");
        madagascar.setLayoutX(249.0);
        madagascar.setLayoutY(262.0);
        australia.setContent("m 608.85,238.7423 -40.55194,-23.4173 -11.42307,-31.98462 35.9827,-30.84231 34.26923,-7.425 41.69423,17.13462 c 0,0 2.2846,42.26538 -2.85578,46.26346 C 660.82499,212.46923 608.85,238.7423 608.85,238.7423 Z");
        australia.setLayoutX(301.0);
        australia.setLayoutY(275.0);
        sumatra.setContent("m 543.73846,155.925 -18.84809,-18.84808 14.85,-13.70769 16.56347,18.84807 v 20.56154 z");
        sumatra.setLayoutX(324.0);
        sumatra.setLayoutY(252.0);
        borneo.setContent("m 599.71153,125.65385 -18.84807,-14.27885 14.85,-23.417309 6.28269,13.707699 5.71154,26.27307 z");
        borneo.setLayoutX(387.0);
        borneo.setLayoutY(255.0);
        java.setContent("m 623.69998,122.22692 15.99232,5.71154 11.42307,-17.70577 -4.56923,-20.561537 -14.85,3.426923 z");
        java.setLayoutX(384.0);
        java.setLayoutY(287.0);
        espania.setContent("m 249.02307,82.817307 c 9.13847,-2.855769 43.97884,-7.425001 43.97884,-7.425001 l 17.70578,-28.557691 -26.27307,-34.840384 -22.84616,-7.4250002 -22.275,9.7096152 -13.70769,9.138461 v 27.415384 z");
        espania.setLayoutX(243.0);
        espania.setLayoutY(283.0);
        francia.setContent("m 310.70769,46.834615 -26.27307,-34.840384 25.13076,-22.275 -5.71153,-31.41346 37.69614,-34.840386 32.55578,70.8230766 -18.27694,36.5538454 -45.12114,15.992308");
        francia.setLayoutX(242.0);
        francia.setLayoutY(275.0);
        italia.setContent("m 355.82883,30.842307 18.27694,-36.5538454 34.26923,24.5596154 -17.13462,8.567307 15.99231,30.271153 -23.98847,27.415384 -17.70576,-3.426923 7.425,-26.273074 -17.13463,-24.559617");
        italia.setLayoutX(242.0);
        italia.setLayoutY(280.0);
        alemania.setContent("M 408.375,18.848077 374.10577,-5.7115384 341.54999,-76.534615 379.24615,-100.52308 398.66538,-59.4 426.65192,-49.119231 436.9327,7.9961538 Z");
        alemania.setLayoutX(244.0);
        alemania.setLayoutY(274.0);
        polonia.setContent("M 436.9327,7.9961538 426.65192,-49.119231 398.66538,-59.4 l -19.41923,-41.12308 10.28076,-11.42307 75.96346,29.128843 37.12501,61.113461 -25.13076,14.85 -3.99809,22.275 -17.1346,-11.4230771 z");
        polonia.setLayoutX(245.0);
        polonia.setLayoutY(269.0);
        rusia.setContent("m 389.52691,-111.94615 75.96346,29.128845 37.12501,61.113459 43.4077,-23.988462 -21.70385,-57.686542 -22.27501,-32.55576 -4.56922,-46.26346 -46.26348,-20.56154 -1.14228,-19.99039 -70.82309,2.85577 -17.13463,37.69616 22.27501,31.98461 5.14038,38.26731");
        rusia.setLayoutX(251.0);
        rusia.setLayoutY(269.0);
        suecia.setContent("m 362.11152,-182.19807 -35.98267,23.4173 -25.70194,-8.56731 -3.99807,-54.25961 42.26539,5.14038 40.55192,-3.42692");
        suecia.setLayoutX(247.0);
        suecia.setLayoutY(268.0);
        granBretania.setContent("M 277.00962,-35.411539 304.99616,-73.107692 283.29231,-111.375 249.59423,-38.838462 Z");
        granBretania.setLayoutX(219.0);
        granBretania.setLayoutY(306.0);
        islandia.setContent("m 174.77307,-37.124999 29.7,14.278845 25.70193,-23.417308 -9.13846,-45.121152 -29.7,-7.424999 -20.56154,33.12692 z");
        islandia.setLayoutX(209.0);
        islandia.setLayoutY(308.0);
        turquia.setContent("m 473.48653,15.421154 3.99809,-22.275 25.13076,-14.85 43.4077,-23.988462 45.6923,29.128847 10.85191,29.699999 L 536.88461,-0.57115384 473.48653,15.421154");
        turquia.setLayoutX(246.0);
        turquia.setLayoutY(273.0);
        israel.setContent("M 536.88461,-0.57115384 473.48653,15.421154 462.63462,45.121152 495.19038,70.823076 560.87308,4.5692308 536.88461,-0.57115384");
        israel.setLayoutX(242.0);
        israel.setLayoutY(276.0);
        arabia.setContent("M 495.19038,70.823076 560.87308,4.5692308 602.56729,13.136538 579.15,55.401924 586.00384,70.251922 555.73268,97.096153 495.19038,70.823076");
        arabia.setLayoutX(248.0);
        arabia.setLayoutY(276.0);
        iran.setContent("m 602.56729,13.136538 -10.85191,-29.699999 -45.6923,-29.128847 -21.70385,-57.686542 -22.27501,-32.55576 -2.85578,-30.27116 33.12695,-1.14231 34.26923,74.821157 31.9846,50.832694 22.27501,50.8326904 z");
        iran.setLayoutX(253.0);
        iran.setLayoutY(270.0);
        aral.setContent("m 532.31539,-167.34808 -33.12695,1.14231 -1.71344,-15.9923 -46.26348,-20.56154 -1.14228,-19.99039 39.4096,-11.42307 27.41539,24.55961 z");
        aral.setLayoutX(252.0);
        aral.setLayoutY(266.0);
        tartaria.setContent("m 523.17692,-190.19423 -6.28269,-19.41923 -27.41539,-24.55961 23.41729,-17.70577 14.85001,1.71346 20.56154,54.83077 z");
        tartaria.setLayoutX(255.0);
        tartaria.setLayoutY(267.0);
        taymir.setContent("m 527.74614,-250.16538 18.84809,-5.71154 26.84423,8.56731 -2.28462,37.69615 -22.84616,14.27885");
        taymir.setLayoutX(258.0);
        taymir.setLayoutY(265.0);
        siberia.setContent("m 532.31539,-167.34808 -9.13847,-22.84615 25.13076,-5.14038 22.84616,-14.27885 2.28462,-37.69615 23.98845,3.42692 -5.14038,32.55577 20.56154,14.85 -15.42116,25.13077 -19.41923,11.42307 -45.69229,-7.425");
        siberia.setLayoutX(261.0);
        siberia.setLayoutY(269.0);
        kamtchatka.setContent("m 612.84807,-196.47692 -20.56154,-14.85 5.14038,-32.55577 13.13654,-13.13654 h 38.26732 l 5.14038,18.84808 -12.56538,7.99615 15.42116,27.98654 z");
        kamtchatka.setLayoutX(266.0);
        kamtchatka.setLayoutY(265.0);
        india.setContent("m 608.27885,-19.990384 50.26152,-17.705769 19.99038,13.136538 12.56541,76.534613 -27.98654,40.551925 -39.40964,-34.840386 -2.85575,-48.5480756 z");
        india.setLayoutX(264.0);
        india.setLayoutY(284.0);
        malasia.setContent("m 681.38653,-10.851923 -2.85578,-13.707692 -19.99038,-13.136538 103.37884,-22.846154 c 0,0 19.41923,33.698077 21.1327,42.836538 1.71347,9.1384613 -5.14038,69.680767 -5.14038,69.680767 L 702.51922,-9.1384614 Z");
        malasia.setLayoutX(273.0);
        malasia.setLayoutY(285.0);
        mongolia.setContent("m 532.31539,-167.34808 45.69229,7.425 19.41923,-11.42307 24.55963,45.12115 -55.40192,33.698077");
        mongolia.setLayoutX(265.0);
        mongolia.setLayoutY(271.0);
        gobi.setContent("m 566.58462,-92.526923 31.9846,50.832694 26.27307,-8.567309 31.98464,-55.401922 -34.84039,-20.56154 z");
        gobi.setLayoutX(262.0);
        gobi.setLayoutY(274.0);
        china.setContent("m 598.56922,-41.694229 9.70963,21.703845 50.26152,-17.705769 103.37884,-22.846154 -12.56538,-62.255773 -50.83267,-13.13653 -41.69423,-66.25385 -43.97886,5.71154 -15.42116,25.13077 24.55963,45.12115 c 0,0 34.84039,20.56154 34.84039,20.56154 l -31.98464,55.401922 -26.27307,8.567309 9.70963,21.703845");
        china.setLayoutX(269.0);
        china.setLayoutY(275.0);
        japon.setContent("m 688.76917,-231.93346 2.82845,21.28369 26.26405,14.04723 0.80812,15.32425 18.99094,5.53376 10.10155,15.32425 8.48533,-22.13503 c 0,0 -16.16251,-26.81744 -19.395,-28.94581 -3.23251,-2.12837 -21.41531,-15.32425 -21.41531,-15.32425 z");
        japon.setLayoutX(258.0);
        japon.setLayoutY(274.0);
        Line puente1 = new Line();
        puente1.setEndX(110.0);
        puente1.setStartX(-172.0);
        puente1.setLayoutX(204.0);
        puente1.setLayoutY(491.0);
        Line puente2 = new Line();
        puente2.setEndX(151.0);
        puente2.setEndY(-32.0);
        puente2.setStartX(182.29290771484375);
        puente2.setStartY(35.29290771484375);
        puente2.setLayoutX(454.0);
        puente2.setLayoutY(508.0);
        Line puente3 = new Line();
        puente3.setEndX(-40.0);
        puente3.setEndY(20);
        puente3.setStartX(-100.0);
        puente3.setLayoutX(737.0);
        puente3.setLayoutY(544.0);
        Line puente4 = new Line();
        puente4.setEndX(-58.94903564453125);
        puente4.setEndY(-60.97308349609375);
        puente4.setStartX(-100.0);
        puente4.setLayoutX(796.0);
        puente4.setLayoutY(564.0);
        Line puente5 = new Line();
        puente5.setEndX(30.0);
        puente5.setEndY(-34.0);
        puente5.setStartX(-82.02117919921875);
        puente5.setStartY(-18.0);
        puente5.setLayoutX(511.0);
        puente5.setLayoutY(445.0);
        Line puente6 = new Line();
        puente6.setEndX(-18.0);
        puente6.setEndY(-97.0);
        puente6.setStartX(-46.7403564453125);
        puente6.setLayoutX(361.0);
        puente6.setLayoutY(311.0);
        Line puente7 = new Line();
        puente7.setEndX(9.0);
        puente7.setEndY(-23.0);
        puente7.setStartX(-17.0);
        puente7.setStartY(24.18267822265625);
        puente7.setLayoutX(314.0);
        puente7.setLayoutY(178.0);
        Line puente8 = new Line();
        puente8.setEndX(5.0);
        puente8.setEndY(-103.0);
        puente8.setStartX(-22.0);
        puente8.setStartY(-125.0);
        puente8.setLayoutX(388.0);
        puente8.setLayoutY(327.0);
        Line puente9 = new Line();
        puente9.setEndX(142.0);
        puente9.setEndY(82.0);
        puente9.setStartX(117.0);
        puente9.setStartY(57.0);
        puente9.setLayoutX(409.0);
        puente9.setLayoutY(303.0);
        Line puente10 = new Line();
        puente10.setEndX(58.0);
        puente10.setEndY(-49.0);
        puente10.setStartX(58);
        puente10.setStartY(-72.41152954101562);
        puente10.setLayoutX(429.0);
        puente10.setLayoutY(343);
        Line puente11 = new Line();
        puente11.setEndX(14.0);
        puente11.setEndY(26.0);
        puente11.setStartX(-31.0);
        puente11.setStartY(34.0);
        puente11.setLayoutX(469);
        puente11.setLayoutY(203);

        Line puente12 = new Line();
        puente12.setEndX(13.0);
        puente12.setEndY(-23.0);
        puente12.setStartX(-119.0);
        puente12.setStartY(86.19036865234375);
        puente12.setLayoutX(539.0);
        puente12.setLayoutY(123.0);

        Line puente13 = new Line();
        puente13.setEndX(67);
        puente13.setEndY(-28.0);
        puente13.setStartX(-20.0);
        puente13.setStartY(-4.1025390625);
        puente13.setLayoutX(534);
        puente13.setLayoutY(214);
        Line puente14 = new Line();
        puente14.setEndX(17.0);
        puente14.setEndY(-74.0);
        puente14.setStartX(-23);
        puente14.setStartY(24);
        puente14.setLayoutX(679);
        puente14.setLayoutY(348);
        Line puente15 = new Line();
        puente15.setEndX(19.0);
        puente15.setEndY(-17.0);
        puente15.setStartX(-30.0);
        puente15.setStartY(66.0);
        puente15.setLayoutX(702.0);
        puente15.setLayoutY(303.0);
        Line puente16 = new Line();
        puente16.setEndX(8.0);
        puente16.setEndY(-30.0);
        puente16.setStartX(-0.29290771484375);
        puente16.setStartY(-0.29290771484375);
        puente16.setLayoutX(722.0);
        puente16.setLayoutY(370);
        Line puente17 = new Line();
        puente17.setEndX(-36.94903564453125);
        puente17.setEndY(12.34033203125);
        puente17.setStartX(-36.94903564453125);
        puente17.setStartY(-30.0);
        puente17.setLayoutX(774);
        puente17.setLayoutY(433);
        Line puente18 = new Line();
        puente18.setEndX(-2.0);

        puente18.setStartX(-8.0);
        puente18.setStartY(-39.0);
        puente18.setLayoutX(874);
        puente18.setLayoutY(445);

        Line puente19 = new Line();
        puente19.setEndX(4.0);
        puente19.setEndY(-41.0);
        puente19.setStartX(-24.0);
        puente19.setStartY(5.07305908203125);
        puente19.setLayoutX(970);
        puente19.setLayoutY(415);

        Line puente20 = new Line();
        puente20.setEndX(33.5);
        puente20.setEndY(-30.0615234375);
        puente20.setStartX(-10.6729736328125);
        puente20.setStartY(9);
        puente20.setLayoutX(981.0);
        puente20.setLayoutY(445.0);

        Line puente21 = new Line();
        puente21.setEndX(24.0);
        puente21.setEndY(-117.0);
        puente21.setStartX(0.27886962890625);
        puente21.setStartY(-90.47305297851562);
        puente21.setLayoutX(872);
        puente21.setLayoutY(467);
        Line puente22 = new Line();
        puente22.setEndX(39.0);
        puente22.setEndY(-25.0);
        puente22.setStartX(17.0);
        puente22.setStartY(14.95770263671875);
        puente22.setLayoutX(970);
        puente22.setLayoutY(328);
        Line puente23 = new Line();
        puente23.setEndX(25.5084228515625);
        puente23.setEndY(-31.1768798828125);
        puente23.setStartX(-8.0);
        puente23.setStartY(-11.0);
        puente23.setLayoutX(955);
        puente23.setLayoutY(109);

        Line puente24 = new Line();
        puente24.setEndX(25.5084228515625);
        puente24.setEndY(-31.1768798828125);
        puente24.setStartX(-8.0);
        puente24.setStartY(-11.0);
        puente24.setLayoutX(955);
        puente24.setLayoutY(109);
        Line puente25 = new Line();
        puente25.setEndX(14.7691650390625);
        puente25.setEndY(-25.0);
        puente25.setStartX(-9.0);
        puente25.setStartY(-25.0);
        puente25.setLayoutX(932.0);
        puente25.setLayoutY(78);
        Line puente26 = new Line();
        puente26.setEndX(108);
        puente26.setEndY(20);
        puente26.setStartX(-49.0);
        puente26.setLayoutX(964);
        puente26.setLayoutY(32);
        Line puente27 = new Line();
        puente27.setEndX(28.7904052734375);
        puente27.setEndY(-78.0);
        puente27.setStartX(-41.70710754394531);
        puente27.setStartY(-118.0);
        puente27.setLayoutX(56.0);
        puente27.setLayoutY(355);
        Line puente28 = new Line();
        puente28.setEndX(182.0);
        puente28.setEndY(-34.0);
        puente28.setStartX(79.3270263671875);
        puente28.setStartY(-34.0);
        puente28.setLayoutX(891.0);
        puente28.setLayoutY(514.);
        VBox jugadores = new VBox();
        jugadores.setLayoutY(554.0);
        jugadores.setPrefHeight(145);
        ListView<Jugador> listaJugadores = new ListView<Jugador>();
        listaJugadores.setMouseTransparent(true);
        listaJugadores.setFocusTraversable( false );
        listaJugadores.setCellFactory(param -> new ListCell<Jugador>() {
            @Override
            protected void updateItem(Jugador item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null || item.cantidadPaisesConquistados() == 0) {
                    setText(null);
                } else {
                    setTextFill(ControladorJuego.getColorJugador(item));
                    setText(item.getNombre());
                }
            }
        });
        for(Jugador j: juego.getJugadores()){
            listaJugadores.getItems().add(j);
        }
        jugadores.getChildren().addAll(listaJugadores);

        this.setPrefWidth(1080.0);
        this.setPrefHeight(720.0);


        this.getChildren().addAll(argentina,chile,brasil,uruguay,peru,colombia,mexico,california,
                oregon,alaska,yukon, canada,nuevaYork,terranova,labrador,groenlandia, sahara,zaire,sudafrica,
                etiopia,egipto,madagascar,australia,sumatra,borneo,java,espania,francia,italia,alemania,
                polonia,rusia,suecia,granBretania,islandia,turquia,israel,arabia,iran,aral,tartaria,taymir,
                siberia,kamtchatka,india,malasia,mongolia,gobi,china,japon,nombrePais,puente1,puente2,puente3, puente4,
                puente5,puente6,puente7,puente8,puente9,puente10,puente11,puente12,puente13,puente14,puente15,
                puente16,puente17,puente18,puente19,puente20,puente21,puente22,puente23,puente24,puente25,
                puente26,puente27,puente28,jugadores);
    }

}
