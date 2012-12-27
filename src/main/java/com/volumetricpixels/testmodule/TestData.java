package com.volumetricpixels.testmodule;

import com.volumetricpixels.testmodule.materials.batteryblock.BatteryBlock;
import com.volumetricpixels.testmodule.materials.windmill.WindmillBlock;

public class TestData {

    private TestData() {
    }
    
    public static final WindmillBlock WINDMILL_BLOCK = new WindmillBlock("Windmill", 150);
    public static final BatteryBlock BATTERY_BLOCK = new BatteryBlock("Battery", 151);
    
}
