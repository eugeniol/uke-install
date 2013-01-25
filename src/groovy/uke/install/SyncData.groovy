package uke.install

import uke.DbConfigParam
import org.codehaus.groovy.grails.commons.GrailsApplication
/**
 * Created with IntelliJ IDEA.
 * User: elattanzio
 * Date: 15/08/12
 * Time: 09:56
 * To change this template use File | Settings | File Templates.
 */
class SyncData {
    GrailsApplication grailsApplication
    IInstalador instalador

    def run() {
        def dbVersion = DbConfigParam.findByName('db.version')
        if (!dbVersion)
            dbVersion = new DbConfigParam(name: 'db.version', value: '0').save()


        if (dbVersion.value == '0') {
          //  new GenerarIndices(grailsApplication).run()
            instalador?.setup()
        }

        instalador?.run()

        dbVersion.value = (dbVersion.value?.toInteger() + 1).toString()
        dbVersion.save()
    }
}


