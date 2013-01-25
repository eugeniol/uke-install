package uke.install

import org.codehaus.groovy.grails.commons.GrailsApplication

/**
 * Created with IntelliJ IDEA.
 * User: elattanzio
 * Date: 21/01/13
 * Time: 13:49
 * To change this template use File | Settings | File Templates.
 */
interface IInstalador {
    GrailsApplication app
    void run();
    void setup();
}
