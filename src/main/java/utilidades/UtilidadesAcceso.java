package utilidades;

import java.io.InputStream;
import java.util.Properties;

/**
 * Asignatura: Patrones de Diseño de Software
 * Patrón Creacional - > Singleton
 * Tipo de Clase: Configuración de Propiedades
 */
public class UtilidadesAcceso {
    public static Properties loadProperty(String propertiesURL){
        try {
            Properties properties = new Properties();
            InputStream inputStream = UtilidadesAcceso.class.getClassLoader().getResourceAsStream(propertiesURL);
            if (inputStream == null) {
                throw new IllegalArgumentException("Archivo de propiedades no encontrado: " + propertiesURL);
            }
            properties.load(inputStream);
            return properties;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
