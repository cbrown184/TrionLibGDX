package unit.core;


import com.badlogic.gdx.math.Vector2;
import com.google.inject.Inject;
import com.greenwell.trion.engine.components.reversetime.TimePosition;
import com.greenwell.trion.engine.components.reversetime.TimePositionLinkedList;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class TimeWarpTests  extends TestPropertyInjector{

    @Inject
    TimePositionLinkedList timePositionList;

    @Test
    public void TimePositionListQueueTimePositions() throws InterruptedException {


        ArrayList<TimePosition> incomingTimePositions = new ArrayList<>();
        long startTestTime = System.currentTimeMillis();

        //Add two seconds worth of time positions
        while (System.currentTimeMillis() - startTestTime <  500){
            Thread.sleep(1);
            timePositionList.add((new Vector2(0,0)));
        }
        System.out.println(timePositionList.size());

        long finishTime = System.currentTimeMillis();

        timePositionList.update(1f);

        //Assert that window is less than window size
        Assert.assertTrue(timePositionList.size() > 0);
        //Assert that window is less than window size
        Assert.assertTrue((timePositionList.last().getTime() - timePositionList.first().getTime() <= timePositionList.getMaxDuration() * 1000000));
        Assert.assertTrue((timePositionList.last().getTime() - timePositionList.first().getTime() > 0));
        //Assert we clipped the correct end of the window
        Assert.assertTrue(timePositionList.first().getTime() - startTestTime > finishTime - timePositionList.last().getTime());


    }

}
