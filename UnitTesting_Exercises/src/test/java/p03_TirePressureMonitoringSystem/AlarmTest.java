package p03_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import p06_TirePressureMonitoringSystem.Alarm;
import p06_TirePressureMonitoringSystem.Sensor;

public class AlarmTest {

    @Test
    public void testAlarmWithNormalValue(){
        Sensor sensor = Mockito.mock(Sensor.class);
        Alarm alarm = new Alarm(sensor);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(19.3);

        alarm.check();
        Assert.assertFalse(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmWithLowerValue(){
        Sensor sensor = Mockito.mock(Sensor.class);
        Alarm alarm = new Alarm(sensor);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(15.3);

        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }
    @Test
    public void testAlarmWithHigherValue(){
        Sensor sensor = Mockito.mock(Sensor.class);
        Alarm alarm = new Alarm(sensor);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(24.3);

        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

}
