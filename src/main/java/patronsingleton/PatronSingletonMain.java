package patronsingleton;

/**
 * Asignatura: Patrones de Diseño de Software
 * Patrón Creacional - > Singleton
 * Tipo de Clase: Main()
 */
public class PatronSingletonMain {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new ModificarSingleton("Hilo 1", "Aplicación 1", "1.1"));
        Thread thread2 = new Thread(new ModificarSingleton("Hilo 2", "Aplicación 2", "2.2"));
        Thread thread3 = new Thread(new ModificarSingleton("Hilo 3", "Aplicación 3", "3.3"));

        // Iniciar los hilos
        thread1.start();
        thread2.start();
        thread3.start();

        // Esperar a que los hilos terminen
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Comprobación final de los atributos de la configuración
        ParametrizacionSingleton singleton = ParametrizacionSingleton.getInstance();
        System.out.println("Configuración final: " + singleton);
    }
    static class ModificarSingleton implements Runnable {
        private String threadName;
        private String nombreAplicacion;
        private String numeroVersion;

        public ModificarSingleton(String threadName, String nombreAplicacion, String numeroVersion) {
            this.threadName = threadName;
            this.nombreAplicacion = nombreAplicacion;
            this.numeroVersion = numeroVersion;
        }

        @Override
        public void run() {
            ParametrizacionSingleton singleton = ParametrizacionSingleton.getInstance();
            System.out.println(threadName + " obtiene la instancia del Singleton");

            // Modificar las propiedades del Singleton
            singleton.setNombreAplicacion(nombreAplicacion);
            singleton.setNumeroVersion(numeroVersion);

            System.out.println(threadName + " establece: " + singleton);
        }
    }
}
