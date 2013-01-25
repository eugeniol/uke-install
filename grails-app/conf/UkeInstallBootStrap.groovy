import uke.install.SyncData
import uke.install.IInstalador

class UkeInstallBootStrap {
    def grailsApplication
    def init    = { servletContext ->
        def instalador = grailsApplication.config.instaladorClass

        if (instalador) {
            Class InstaladorClass = this.getClass().getClassLoader().loadClass(instalador);
            IInstalador ins = InstaladorClass.newInstance();

            ins.app = grailsApplication

            def s = new SyncData(
                grailsApplication: grailsApplication,
                instalador: ins)

            s.run()
        }
    }
    def destroy = {
    }
}