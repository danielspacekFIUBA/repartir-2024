package ar.com.grupoesfera.repartir.steps.grupos;

import ar.com.grupoesfera.repartir.steps.CucumberSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class MiembrosSinRepetirSteps  extends CucumberSteps {

    private List<String> grupos = new ArrayList<>();

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

    @Cuando("el usuario crea {int} grupos con los mismos miembros en cada uno de ellos")
    public void el_usuario_crea_udos_grupo_con_dos_miembros_distintos(int cantidadGrupos) {
        // creo en memoria una lista con 2 usuarios distintos
        var members = List.of("Diego", "Armando");

        // bucle para crear la cantidad de grupos
        for (int i = 0; i < cantidadGrupos; i++) {
            var crearGruposButton = driver.findElement(By.id("crearGruposButton"));
            crearGruposButton.click();

            var nombreGrupo = "Nuevo grupo " + i;
            grupos.add(nombreGrupo);

            driver.findElement(By.id("nombreGrupoNuevoInput")).sendKeys(nombreGrupo);

            var miembrosInput = driver.findElement(By.id("miembrosGrupoNuevoInput"));
            // recorro los members
            members.forEach(member -> {
                miembrosInput.sendKeys(member);
                miembrosInput.sendKeys(Keys.ENTER);
            });

            driver.findElement(By.id("guardarGrupoNuevoButton")).click();

            var wait = new WebDriverWait(driver, 2);
            wait.until(visibilityOfElementLocated(By.id("mensajesToast")));
        }
    }

    @Entonces("debería visualizar los grupos dentro del listado")
    public void debería_visualizar_los_grupos_dentro_del_listado() {
        var grupoTR = driver.findElements(By.cssSelector("app-grupos table tr"));
        assertThat(grupoTR).hasSizeGreaterThan(1);

        for (int i = 0; i < this.grupos.size(); i++) {
            var grupo = this.grupos.get(i);

            var campoTDs = grupoTR.get(i + 1).findElements(By.tagName("td"));
            var nombreGrupoActual = campoTDs.get(1).getText();
            assertThat(nombreGrupoActual).isNotEmpty();
            assertThat(nombreGrupoActual).isEqualTo(grupo);
        }
    }
}
