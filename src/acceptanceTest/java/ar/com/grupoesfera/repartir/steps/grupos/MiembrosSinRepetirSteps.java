package ar.com.grupoesfera.repartir.steps.grupos;

import ar.com.grupoesfera.repartir.steps.CucumberSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class MiembrosSinRepetirSteps  extends CucumberSteps {

    @Cuando("el usuario crea un grupo con un unico miembro repetido")
    public void el_usuario_crea_un_grupo_con_miembros_repetidos() {

        var crearGruposButton = driver.findElement(By.id("crearGruposButton"));
        crearGruposButton.click();

        driver.findElement(By.id("nombreGrupoNuevoInput")).sendKeys("Asado esquizofrenico");

        var miembrosInput = driver.findElement(By.id("miembrosGrupoNuevoInput"));
        miembrosInput.sendKeys("Daniel");
        miembrosInput.sendKeys(Keys.ENTER);
        miembrosInput.sendKeys("Daniel");
        miembrosInput.sendKeys(Keys.ENTER);

        driver.findElement(By.id("guardarGrupoNuevoButton")).click();

        var wait = new WebDriverWait(driver, 2);
        wait.until(visibilityOfElementLocated(By.id("mensajesToast")));
    }

    @Entonces("no deberia crear el grupo con miembros repetidos")
    public void no_deberia_crear_el_grupo_con_miembros_repetidos() {
        var wait = new WebDriverWait(driver, 2);
        var mensajesToast = wait.withMessage("Mostro Toast")
                .until(visibilityOfElementLocated(By.id("mensajesToast")));
        wait.withMessage("Título del Toast es 'Error'")
                .until(textToBePresentInElement(mensajesToast, "Error"));
        assertThat(mensajesToast.getText())
                .as("Descripción del Toast")
                .contains("No se puede guardar");
    }

    @Cuando("el usuario crea un grupo con dos miembros llamados {string} y otro miembro llamado {string}")
    public void el_usuario_crea_un_grupo_dos_miembros_llamados_y_otro_miembro_llamado(String miembroRepetido, String miembroSinRepetir) {
        var crearGruposButton = driver.findElement(By.id("crearGruposButton"));
        crearGruposButton.click();

        driver.findElement(By.id("nombreGrupoNuevoInput")).sendKeys("Truco Gallo");

        var miembrosInput = driver.findElement(By.id("miembrosGrupoNuevoInput"));

        miembrosInput.sendKeys(miembroRepetido);
        miembrosInput.sendKeys(Keys.ENTER);
        miembrosInput.sendKeys(miembroRepetido);
        miembrosInput.sendKeys(Keys.ENTER);

        miembrosInput.sendKeys(miembroSinRepetir);
        miembrosInput.sendKeys(Keys.ENTER);

        driver.findElement(By.id("guardarGrupoNuevoButton")).click();

        var wait = new WebDriverWait(driver, 2);
        wait.until(visibilityOfElementLocated(By.id("mensajesToast")));
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
