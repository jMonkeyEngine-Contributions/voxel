package com.jme3.voxel;

import com.jme3.voxel.field.ScalarField;
import com.jme3.voxel.volume.Volume;
import com.jme3.voxel.volume.Voxel;

/**
 * TODO doc
 * 
 * @author Marius Dransfeld
 * 
 */
public class Rasterer
{
	private Rasterer()
	{

	}

	/**
	 * TODO doc
	 * 
	 * @param field
	 * @param volume
	 * @param min
	 * @param max
	 */
	@SuppressWarnings("unchecked")
	public static <V extends Voxel> void raster(ScalarField field,
			Volume<V> volume, Vector3i min, Vector3i max)
	{
		for (int x = min.x; x < max.x; x++)
		{
			for (int y = min.y; y < max.y; y++)
			{
				for (int z = min.z; z < max.z; z++)
				{
					volume.setVoxel(x, y, z,
							(V) new Voxel(field.evaluate(x, y, z), 0));
				}
			}
		}
	}
}
