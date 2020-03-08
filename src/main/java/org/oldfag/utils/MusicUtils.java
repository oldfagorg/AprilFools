package org.oldfag.utils;

import org.oldfag.AprilFools;
import org.primesoft.midiplayer.track.BaseTrack;
import org.primesoft.midiplayer.track.GlobalTrack;

import java.util.Random;

/**
 * @author John200410 3/8/2020 for OldfagAprilFools
 */
public class MusicUtils {

	public static GlobalTrack getRandomTrack() {
		Random rand = new Random();
		return AprilFools.tracks.get(rand.nextInt(AprilFools.tracks.size()));
	}

}
