package com.mygdx.mapgen.common.EntityComponents;

import com.mygdx.mapgen.common.GameData;
import com.mygdx.mapgen.common.World;

/**
 * Created by Daniel Johansen on 19-02-2018.
 */
public interface EntityComponent {
    void process(GameData gameData, World world);

}
