package ar.com.grupoesfera.repartir.steps.grupos;

import ar.com.grupoesfera.repartir.steps.CucumberSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

public class MiembrosSinRepetirSteps  extends CucumberSteps {

    @Cuando("el usuario crea un grupo con {int} miembros llamados {string}")
    public void el_usuario_crea_un_grupo_con_miembros_llamados(Integer int1, String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Entonces("no deberia crear el grupo con usuarios repetidos")
    public void no_deberia_crear_el_grupo_con_usuarios_repetidos() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Cuando("el usuario crea un grupo con {int} miembros llamados {string} y otro miembro {string}")
    public void el_usuario_crea_un_grupo_con_miembros_llamados_y_otro_miembro(Integer int1, String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Cuando("el usuario crea udos grupo con dos miembros llamados {string} y {string}")
    public void el_usuario_crea_udos_grupo_con_dos_miembros_llamados_y(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Entonces("debería visualizar los dos grupos dentro del listado")
    public void debería_visualizar_los_dos_grupos_dentro_del_listado() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
