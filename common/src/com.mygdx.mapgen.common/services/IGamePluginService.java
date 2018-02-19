package com.mygdx.mapgen.common.services;

import com.mygdx.mapgen.common.GameData;
import com.mygdx.mapgen.common.World;

/**
 * Created by Daniel Johansen on 19-02-2018.
 */
public interface IGamePluginService {

    void start(GameData gameData, World world);



    void stop(GameData gameData, World world);

}
