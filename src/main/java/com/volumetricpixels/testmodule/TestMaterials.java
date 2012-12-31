package com.volumetricpixels.testmodule;

import com.volumetricpixels.testmodule.materials.TestBlockMaterial;
import com.volumetricpixels.testmodule.materials.battery.BatteryBlock;
import com.volumetricpixels.testmodule.materials.capacitor.CapacitorBlock;
import com.volumetricpixels.testmodule.materials.windmill.WindmillBlock;
import com.volumetricpixels.testmodule.materials.wire.WireBlock;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.spout.api.Spout;

public class TestMaterials {

    private TestMaterials() {
    }
    
    public static final WindmillBlock WINDMILL_BLOCK = new WindmillBlock("Windmill");
    public static final BatteryBlock BATTERY_BLOCK = new BatteryBlock("Battery");
    public static final WireBlock WIRE_BLOCK = new WireBlock("Wire");
    public static final CapacitorBlock CAPACITOR_BLOCK = new CapacitorBlock("Capacitor");
    
    public static void initialise() {
        try {
            for(Field field : TestMaterials.class.getFields()) {
                if ((field.getModifiers() & (Modifier.STATIC | Modifier.PUBLIC)) > 0) {
                    Object temp = field.get(null);
                    if (TestBlockMaterial.class.isAssignableFrom(field.getClass())) {
                        TestBlockMaterial mat = (TestBlockMaterial)temp;
                        mat.initialise();
                    }
                }
            }
        } catch (Exception ex) {
            Spout.getLogger().severe("Failed to initialise TestModule recipes!");
        }
    }    
}