package ar.com.grupoesfera.repartir.steps.grupos;

import ar.com.grupoesfera.repartir.steps.CucumberSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

public class MiembrosSinRepetirSteps  extends CucumberSteps {

    @Cuando("el usuario crea un grupo con un unico miembro repetido")
    public void el_usuario_crea_un_grupo_con_miembros_repetidos() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Entonces("no deberia crear el grupo con miembros repetidos")
    public void no_deberia_crear_el_grupo_con_miembros_repetidos() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Cuando("el usuario crea un grupo con dos miembros llamados {string} y otro miembro llamado {string}")
    public void el_usuario_crea_un_grupo_dos_miembros_llamados_y_otro_miembro_llamado(String miembro1, String miembro2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Cuando("el usuario crea udos grupo con dos miembros distintos")
    public void el_usuario_crea_udos_grupo_con_dos_miembros_distintos() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Entonces("debería visualizar los dos grupos dentro del listado")
    public void debería_visualizar_los_dos_grupos_dentro_del_listado() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
