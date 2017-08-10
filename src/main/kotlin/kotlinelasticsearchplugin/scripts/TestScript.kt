package kotlinelasticsearchplugin.scripts

import org.elasticsearch.common.Nullable
import org.elasticsearch.script.AbstractSearchScript
import org.elasticsearch.script.ExecutableScript
import org.elasticsearch.script.NativeScriptFactory



/**
 * Created by itasyurt on 11/08/2017.
 */
class TestScript(paramsArg:Map<String,Any>):AbstractSearchScript() {


    val params = paramsArg
    override fun run(): Any {
        return source()[params["fieldName"]].toString().toUpperCase()
    }


}

val SCRIPT_NAME = "TEST"

class Factory : NativeScriptFactory {

    override fun newScript(@Nullable params: Map<String, Any>): ExecutableScript {
        return TestScript(params)
    }

    override fun needsScores(): Boolean {
        return false
    }
}