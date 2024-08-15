package patronsingleton;

/**
 * Asignatura: Patrones de Diseño de Software
 * Patrón Creacional - > Singleton
 * Tipo de Clase: Main()
 */
public class PatronSingletonMain {
    public static void main(String[] args) {
        // Configuración de Propiedades para el Modulo No->1
        ParametrizacionSingleton singletonA = ParametrizacionSingleton.getInstance();
        // Configuración de Propiedades para el Modulo No->1
        ParametrizacionSingleton singletonB = ParametrizacionSingleton.getInstance();
        System.out.println(singletonA);
        System.out.println(singletonB);
        System.out.println("Igual referencia ==> " + (singletonA == singletonB));

        singletonA.setNombreAplicacion("Patron Creacional Singleton");
        singletonB.setNumeroVersion("2.0x");
        System.out.println("SingletonA ==> " + singletonA);
        System.out.println("SingletonB ==> " + singletonB);

        singletonA = null;
        singletonB = null;

        singletonA = ParametrizacionSingleton.getInstance();
        System.out.println("singletonA ==> " + singletonA);
    }
}
