package com.ibhh.CurveCraft.Listeners;

import org.bukkit.block.Block;
import org.bukkit.block.Sign;

/**
 * @author ibhh
 */
public class BlockTools
{
	public static boolean isSign(Block block)
	{
		return block.getState() instanceof Sign;
	}
}
