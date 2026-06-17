package UI;

import com.lowagie.text.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class SmartCityTrafficSensorsUtility {

    private static final SessionFactory SESSION_FACTORY = HibernateUtil.getSessionFactory();

    public static List<SmartCityTrafficSensors> getSensors() {

        try (Session session = SESSION_FACTORY.openSession()) {

            List<SmartCityTrafficSensors> sensors = session.createQuery("from SmartCityTrafficSensors", SmartCityTrafficSensors.class).list();
            return sensors;

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }

    }

}
