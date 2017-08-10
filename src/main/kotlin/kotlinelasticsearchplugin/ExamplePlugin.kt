package kotlinelasticsearchplugin

import kotlinelasticsearchplugin.scripts.Factory
import kotlinelasticsearchplugin.scripts.SCRIPT_NAME
import kotlinelasticsearchplugin.scripts.TestScript
import org.elasticsearch.common.logging.Loggers
import org.elasticsearch.plugins.Plugin
import org.elasticsearch.script.ScriptModule

/**
 * Created by itasyurt on 11/08/2017.
 */
class ExamplePlugin:Plugin() {
    private val logger = Loggers.getLogger(javaClass)
    override fun name()="example"

    override fun description()="example-description"

    fun onModule(scriptModule: ScriptModule) {

        scriptModule.registerScript(SCRIPT_NAME, Factory::class.java)

        logger.info("Example Script Registered.")
    }
}